package com.gymteam.backend.account.service.impl;

import com.gymteam.backend.account.entity.Account;
import com.gymteam.backend.account.entity.Card;
import com.gymteam.backend.account.entity.StrategyType;
import com.gymteam.backend.account.entity.Transaction;
import com.gymteam.backend.account.exception.NotFoundException;
import com.gymteam.backend.account.repository.AccountRepository;
import com.gymteam.backend.account.repository.CardRepository;
import com.gymteam.backend.account.repository.TransactionRepository;
import com.gymteam.backend.account.service.interfaces.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    private final CardRepository cardRepository;

    private final AccountRepository accountRepository;

    @Override
    @Transactional // TODO Check this
    public Transaction createUserTransaction(UUID userId, UUID cardId, String toCard, Double amount) throws NotFoundException {
        Optional<Card> userCardOptional = cardRepository.findById(cardId);
        Optional<Card> destinationCardOptional = cardRepository.findCardByNumber(toCard);

        if (userCardOptional.isPresent() && destinationCardOptional.isPresent()) {
            Card userCard = userCardOptional.get();
            Card destinationCard = destinationCardOptional.get();

            userCard.setBalance(userCard.getBalance() - amount);

            Transaction transaction = new Transaction();
            transaction.setAmount(amount);
            transaction.setFromCard(cardId);
            transaction.setType(StrategyType.USER);
            transaction.setToCard(destinationCard.getId());

            destinationCard.setBalance(destinationCard.getBalance() + amount);

            cardRepository.save(userCard);
            cardRepository.save(destinationCard);

            return transactionRepository.save(transaction);
        }
        else {
            throw new NotFoundException();
        }
    }

    @Override
    @Transactional
    public Transaction createOrganizationTransaction(UUID userId, UUID cardId, String toAccount, Double amount) throws NotFoundException {
        Optional<Card> userCardOptional = cardRepository.findById(cardId);
        Optional<Account> destinationAccountOptional = accountRepository.findAccountByNumber(toAccount);

        if (userCardOptional.isPresent() && destinationAccountOptional.isPresent()) {
            Card userCard = userCardOptional.get();
            Account destinationAccount = destinationAccountOptional.get();

            userCard.setBalance(userCard.getBalance() - amount);

            Transaction transaction = new Transaction();
            transaction.setAmount(amount);
            transaction.setFromCard(cardId);
            transaction.setType(StrategyType.ORGANIZATION);
            transaction.setToOrganization(destinationAccount.getId());

            destinationAccount.setBalance(destinationAccount.getBalance() + amount);

            cardRepository.save(userCard);
            accountRepository.save(destinationAccount);

            return transactionRepository.save(transaction);
        }
        else {
            throw new NotFoundException();
        }
    }
}
