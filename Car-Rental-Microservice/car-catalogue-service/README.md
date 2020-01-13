# Car Catalogue Service

### Overview:
This service functions as part of the *Car Rental Microservice*.

Its specific function is to serve clients the fleet of cars available to them through the car rental business and to allow administrators to manage the fleet through *CRUD* operations.

This service maintains its own relational database of rental cars in a '**rental-car-catalogue**' MySQL database containing a '**car**' table with the following columns:

- *id* - integer
- *make* - text
- *model* - text
- *location* - text
- *miles_per_gallon* - integer
- *seats* - integer

### API Guide

To get ALL cars in the service, a GET request is made to the following URL endpoint:

```
GET http://car-catalogue-service/api/cars/all
```

Such a call returns a JSON response with the following structure:
```
EXAMPLE RESPONSE
{
    "cars": [
        {
            "make": "Nissan",
            "model": "Qashqai",
            "id": 2,
            "seats": 5,
            "milesPerGallon": 49,
            "location": "south-UK"
        },
        {
            "make": "BMW",
            "model": "5 Series 520d SE",
            "id": 3,
            "seats": 5,
            "milesPerGallon": 52,
            "location": "north-UK"
        }
    ]
}
```
