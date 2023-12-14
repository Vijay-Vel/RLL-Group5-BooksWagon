Feature: Testing Bookswagon Website

  Scenario: Navigate to Fiction Books and Buy book
    Given User is on the Bookswagon website HomePage
    When User navigates to the Fiction books section
    And User selects a book
   	Given User adds the book to the cart in fiction
  	When User verifies the book is in the cart