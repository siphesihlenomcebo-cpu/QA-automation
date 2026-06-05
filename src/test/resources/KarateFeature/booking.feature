Feature: Booking API

  Background:
    * url 'https://restful-booker.herokuapp.com'

  Scenario: Get all bookings
    Given path 'booking'
    When method GET
    Then status 200
    * def responseData = response

  Scenario: Get first booking details
    Given path 'booking'
    When method GET
    Then status 200
    * def firstBooking = response[0].bookingid
#
##    Given path 'booking', firstBooking.bookingid
##    When method GET
##    Then status 200
##    * print response
#
