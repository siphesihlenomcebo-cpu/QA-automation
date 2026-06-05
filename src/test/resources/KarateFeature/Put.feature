Feature: PUT Booking

  Background:
    * url 'https://restful-booker.herokuapp.com'

  Scenario: Update booking
    Given path 'auth'
    And header Content-Type = 'application/json'
    And request
    """
    {
      "username": "admin",
      "password": "password123"
    }
    """
    When method POST
    Then status 200
    * def token = response.token

    Given path 'booking', 1
    And header Content-Type = 'application/json'
    And header Accept = 'application/json'
    And header Cookie = 'token=' + token
    And request
    """
    {
      "firstname": "Updated",
      "lastname": "User",
      "totalprice": 999,
      "depositpaid": true,
      "bookingdates": {
        "checkin": "2025-02-01",
        "checkout": "2025-02-10"
      },
      "additionalneeds": "Lunch"
    }
    """
    When method PUT
    Then status 200
    * print response
