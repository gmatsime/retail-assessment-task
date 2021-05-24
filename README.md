# retail-assessment-task

# Installing

After checking out the git repo run the following maven command

mvn clean install

This should install all packages, run all unit tests

# Starting

To start the server please run the following maven command

mvn spring-boot:run


# Testing

To execute the unit tests against the business logic service classes please run the following maven command

mvn test

# Code coverage
classes     |   Method   |  Line coverage
- --          -----        ------
model 100%  |    66%     |     69%
- - -        ----------   -------------
service100% |   100%     |   95%


# Using
API Endpoint

Http Method - POST

Endpoint - localhost:8080/api/bill

Example request

{
{
    "userType": "CUSTOMER",
    "registrationDate": "2021-10-07"
},
"bill":


{
    "items": [
        {
            "itemType": "GROCERY",
            "price": 100.0
        },
        {
            "itemType": "GROCERY",
            "price": 100.0
        },
        {
            "itemType": "GROCERY",
            "price": 100.0
        },
        {
            "itemType": "GROCERY",
            "price": 100.0
        }
    ]
}
}

Net payable amount

373.90
