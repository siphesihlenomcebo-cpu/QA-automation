Feature: SwagLabs Login
 Test Case
 Validate that user can successful Login with credentials
 Validate if user can Login with invalid username and valid password
 Validate if user can Login with valid username and invalid password
 Validate if user can Login with invalid username and invalid password
 Validate if user can Login with empty username and  password
 verify that user can add product to cart and verify
 Verify user can add multiple products to cart


  Scenario Outline: Validate that user can successful Login with credentials
    Given User is on SwagLabs page
    When User enters username "<username>"
    And User enters password "<password>"
    And User clicks login button
    Then Product page is displayed
    Examples:
      | username       | password     |
      | standard_user  | secret_sauce |

  Scenario Outline:  Validate if user can Login with invalid username and valid password
    Given User is on SwagLabs page
    When User enters username "<username>"
    And User enters password "<password>"
    And User clicks login button
    Then Error message "<errorMessage>" should be displayed
    Examples:
      | username    | password         | errorMessage                                                              |
      | standard_   |secret_sauce      | Epic sadface: Username and password do not match any user in this service |


  Scenario Outline:  Validate if user can Login with empty username and  password
    Given User is on SwagLabs page
    When User enters username "<username>"
    And User enters password "<password>"
    And User clicks login button
    Then Error message "<errorMessage>" should be displayed
    Examples:
      | username    | password | errorMessage                       |
      |             |          | Epic sadface: Username is required |

  Scenario Outline: Validate if user can Login with valid username and invalid password
    Given User is on SwagLabs page
    When User enters username "<username>"
    And User enters password "<password>"
    And User clicks login button
    Then Error message "<errorMessage>" should be displayed
    Examples:
      | username      | password     | errorMessage                                                              |
      | standard_user |secret_s      | Epic sadface: Username and password do not match any user in this service |

  Scenario Outline: verify that user can add product to cart
    Given User is on SwagLabs page
    When User enters username "<username>"
    And User enters password "<password>"
    And User clicks login button
    Then Product page is displayed
    When User clicks product to cart
    When user click shopping cart
    Then Your cart page is displayed
    When User clicks checkout
    Then Checkout Your Information page is displayed
    When User enters first name "<firstname>"
    And User enters last name "<lastname>"
    And User enter code "<postalCode>"
    When User clicks continue button
    Then Overview page is displayed
    Examples:
      | username       | password     |  firstname |lastname |postalCode|
      | standard_user  | secret_sauce |  Sphesihle  |   Langa |   1459   |


  Scenario Outline: Verify user can add multiple products to cart
    Given User is on SwagLabs page
    When User enters username "<username>"
    And User enters password "<password>"
    And User clicks login button
    Then Product page is displayed
    When the user adds three different products to the cart
    And user click shopping cart
    Then Your cart page is displayed
    When User clicks checkout
    Then Checkout Your Information page is displayed

    Examples:
      | username       | password     |
      | standard_user  | secret_sauce |