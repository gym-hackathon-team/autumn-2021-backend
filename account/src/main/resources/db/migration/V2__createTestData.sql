INSERT INTO accounts (id, balance,number,type,organization_id)
VALUES('85947d1e-3419-11ec-8d3d-0242ac130003',200,'42557788887799664560','ORGANIZATION',
       'cfa9254a-3418-11ec-8d3d-0242ac130003');

INSERT INTO accounts (id, balance,number,type,user_id)
VALUES('85947f44-3419-11ec-8d3d-0242ac130003',null,'13954255548888779123','USER',
       '689198ba-3418-11ec-8d3d-0242ac130003');


INSERT INTO accounts (id, balance,number,type,user_id)
VALUES('85948f8e-3419-11ec-8d3d-0242ac130003',null,'42555466667791321453','USER',
       '955a2006-3418-11ec-8d3d-0242ac130003');




INSERT INTO cards (id, account_id,balance,number)
VALUES('9f2e4f56-341a-11ec-8d3d-0242ac130003','85947f44-3419-11ec-8d3d-0242ac130003',
       300,'1111222233334444');


INSERT INTO cards (id, account_id,balance,number)
VALUES('9f2e532a-341a-11ec-8d3d-0242ac130003','85948f8e-3419-11ec-8d3d-0242ac130003',
       500,'4274222233334444');





INSERT INTO transactions (id,amount,from_card,to_organization,type )
VALUES('39f96480-341b-11ec-8d3d-0242ac130003',40,'9f2e532a-341a-11ec-8d3d-0242ac130003',
       'cfa9254a-3418-11ec-8d3d-0242ac130003','ORGANIZATION');


INSERT INTO transactions (id,amount,from_card,to_card,type )
VALUES('39f966ba-341b-11ec-8d3d-0242ac130003',50,'9f2e4f56-341a-11ec-8d3d-0242ac130003',
       '9f2e532a-341a-11ec-8d3d-0242ac130003','USER');

