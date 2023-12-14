Feature: Award Winners Test

Scenario: Perform Award Page Operations
    Given I am on the home page
    When I click on the award link
    And I sort books by discount
    And I click on first book to buy
    Then I click on cart to see details
    And I click on buy
    And  I click on address save and continue