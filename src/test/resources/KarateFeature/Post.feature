Feature: POST

    Background:
        * url 'https://restful-booker.herokuapp.com'
        * header Content-Type = 'application/json'
        * header Accept = 'application/json'

    Scenario: Create booking successfully
        Given path 'booking'
        And request
    """
    {
      "firstname": "John",
      "lastname": "Doe",
      "totalprice": 123,
      "depositpaid": true,
      "bookingdates": {
        "checkin": "2025-01-01",
        "checkout": "2025-01-05"
      },
      "additionalneeds": "Breakfast"
    }
    """
        When method POST
        Then status 200 || status 201
        * print response