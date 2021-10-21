package com.gymteam.backend.bff.controller;

import com.gymteam.backend.bff.dto.Admin;
import com.gymteam.backend.bff.dto.User;
import com.gymteam.backend.bff.dto.auth.*;
import com.gymteam.backend.bff.exception.auth.FieldEmptyException;
import com.gymteam.backend.bff.exception.auth.FieldMissingException;
import com.gymteam.backend.bff.exception.auth.PasswordMismatchException;
import com.gymteam.backend.bff.service.interfaces.AuthService;
import feign.FeignException;
import feign.RetryableException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/admin/signin")
    public ResponseEntity<Object> signInAdmin(@RequestBody AdminLoginRequest request) {
        try {
            return new ResponseEntity<>(authService.signInAdmin(request), HttpStatus.OK);
        }
        catch(FieldMissingException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch(FieldEmptyException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (FeignException e)
        {
            int status;
            if (e.status()==-1)
            {
                status=503;
            }
            if (e.status()==403)
            {
                status=403;
            }
            if (e.status()==401)
            {
                status=401;
            }
            if (e.status()==400)
            {
                status=400;
            }
            else
            {
                status=500;
            }
            return new ResponseEntity<>(e.toString(),HttpStatus.valueOf(status));
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/admin/signup")
    public ResponseEntity<Object> signUpAdmin(@RequestBody AdminRegisterRequest request) {
        try {
            return new ResponseEntity<>(authService.signUpAdmin(request), HttpStatus.OK);
        } catch (PasswordMismatchException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch(FieldMissingException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch(FieldEmptyException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (FeignException e)
        {
            int status;
            if (e.status()==-1)
            {
                status=503;
            }
            if (e.status()==403)
            {
                status=403;
            }
            if (e.status()==401)
            {
                status=401;
            }
            if (e.status()==400)
            {
                status=400;
            }
            else
            {
                status=500;
            }
            return new ResponseEntity<>(e.toString(),HttpStatus.valueOf(status));
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user/login")
    public ResponseEntity<Object> signInUser(@RequestBody UserLoginRequest request) {
        try {
            return new ResponseEntity<>(authService.signInUser(request), HttpStatus.OK);
        }
        catch(FieldMissingException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch(FieldEmptyException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (FeignException e)
        {
            int status;
            if (e.status()==-1)
            {
                status=503;
            }
            if (e.status()==403)
            {
                status=403;
            }
            if (e.status()==401)
            {
                status=401;
            }
            if (e.status()==400)
            {
                status=400;
            }
            else
            {
                status=500;
            }
            return new ResponseEntity<>(e.toString(),HttpStatus.valueOf(status));
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user/register")
    public ResponseEntity<Object> signUpUser(@RequestBody UserRegisterRequest request) {
        try {
            return new ResponseEntity<>(authService.signUpUser(request), HttpStatus.OK);
        } catch (PasswordMismatchException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch(FieldMissingException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch(FieldEmptyException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (FeignException e)
        {
            int status;
            if (e.status()==-1)
            {
                status=503;
            }
            if (e.status()==403)
            {
                status=403;
            }
            if (e.status()==401)
            {
                status=401;
            }
            if (e.status()==400)
            {
                status=400;
            }
            else
            {
                status=500;
            }
            return new ResponseEntity<>(e.toString(),HttpStatus.valueOf(status));
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
