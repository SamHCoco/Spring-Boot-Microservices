# User-Service

## Overview:
This service functions as part of the *Car Rental Microservice*

Its function is to manage functionality related to user accounts, such as adding new users or retrieving the following details for any user. This service maintains its own relational database '**car-rental-users**' containing a '**user**' table with the following columns:

- *id* - integer
- *city* - text
- *location* - text
- *postcode* - text
- *street* - text
- *email* - text
- *phone_number* - text
- *first_name* - text
- *last_name* - text
- *user_name* - text

### API Guide

#### Get User
To get a single user, specified by their username, a HTTP GET request is made
to the following endpoint:
```
GET http://user-service/api/users/{userName}

For example, to get user 'johnsmith':

GET http://user-service/api/users/johnsmith
```

#### Add User
To add a single user, a HTTP POST request, with a User JSON object in its Request Body, is made to the following endpoint:
```
POST http://user-service/api/users
```

JSON structure for *User* object in request body for POST requests:
```
{
  "userName": "SarahT",
  "firstName": "Sarah",
  "lastName": "Thornton",

  "contact": {"email": "sarah-thornton@email.co.uk",
	          "phoneNumber": "+445555555"
             },

  "address": {"street": "80 Church Road",
	          "city": "Reading",
              "postcode": "PF3 0ED",
	          "location": "south-UK"
	         }
}
```
*Example User JSON object*
