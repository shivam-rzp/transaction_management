# Transaction Management

### Docker Setup -

1. Pull the Docker Image
   <!--DOCS_START-->
       docker pull 471112631041.dkr.ecr.eu-north-1.amazonaws.com/transaction-management:latest

   <!--DOCS_END-->

2. Run the Docker Image

   <!--DOCS_START-->
       docker run -d -p 8080:8080 transaction-management:latest

   <!--DOCS_END-->


### API documentation - 

1. Create Account

Url - **api/v1/accounts**
Method - POST


Request - 
<!--DOCS_START-->
    {
        "documentNumber": "1234"
    }
<!--DOCS_END-->

Response
<!--DOCS_START-->
    {
        "success": true,
        "message": "Account created successfully",
        "data": {
            "accountId": 3,
            "documentNumber": 1234
        }
    }
<!--DOCS_END-->

2. Fetch Account 

Url - **api/v1/accounts/3**
Method - GET

Response
<!--DOCS_START-->
    {
        "success": true,
        "message": "Account fetched successfully",
        "data": {
            "accountId": 5,
            "documentNumber": 1234
        }
    }
<!--DOCS_END-->

3. Create Transaction


Url - **api/v1/transactions**
Method - POST

Request
<!--DOCS_START-->
    {
        "operationTypeId": 1,
        "amount": -12,
        "accountId": 5
    }
<!--DOCS_END-->

Response
<!--DOCS_START-->
    {
        "success": true,
        "message": "Transaction created successfully",
        "data": {
            "transactionId": 2,
            "accountId": 5,
            "amount": -12.0,
            "operationTypeId": 1
        }
    }
<!--DOCS_END-->


