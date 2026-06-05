Feature: Delete Booking

  Background:
    * url 'https://restful-booker.herokuapp.com'

  Scenario: Delete booking
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
    * print 'Token:', token

    Given path 'booking', 1
    And header Cookie = 'token=' + token
    When method DELETE
    Then status 201