Feature: to test the Books Wagon page on chrome browser

  @login
  Scenario Outline: to test the Login page
    Given the User is on the BooksWagon home page
    Then the User hover My Accounts and clicks on the login button
    When the User enter email as '<EmailId>' on the login page
    When the User enter password as '<password>' on the login page
    And the User clicks on the login button on the page
    And the User hover My Account and clicks on logout button

    Examples: 
      | EmailId | password |
      |         |          |
      |         |          |
      |         |          |
