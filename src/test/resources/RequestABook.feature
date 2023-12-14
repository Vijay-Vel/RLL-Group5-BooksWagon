Feature: Testing RequestBook Functionality

  Scenario Outline: Request a Book in BooksWagon Website
    Given The user clicks on Request a book Page
    When enter the required data iSBN as '<isbn>' Title as '<BookTitle>' Author as '<authorName>'  Phone as '<Phno>'
    And Click the submit button
    Then request should be notify to them

    Examples: 
      | isbn | BookTitle | authorName | Phno |  
      |      |           |            |      |  
      |      |           |            |      |   
