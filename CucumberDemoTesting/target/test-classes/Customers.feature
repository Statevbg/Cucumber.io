Feature: Customers
  Scenario: Add a new Customer
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and Password as "admin"
    And Click on login
    Then User can view Dashboard
    When User click on customers Menu
    And click on Add new button
    Then User can view Add new customer page
    When user enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser