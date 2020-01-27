# card-verification-backend

This is a credit card verification app, built with Java Spring boot, that makes use of  a third party Api, https://binlist.net/ to verify the genuineness of a card 
valid/not valid, its scheme( VISA, MASTERCARD or AMEX), card type(debit or credit)etc.

### This app has two endpoints:


[verification link](https://card-verification-server.herokuapp.com/card-scheme/verify/453342) 
- which which verifies the validity of a card

[get-stats](https://card-verification-server.herokuapp.com/card-scheme/stats?start=1&limit=3) 
- returns a structured response of the number of hits within the specified pagination.