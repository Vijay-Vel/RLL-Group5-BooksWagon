Feature: TodaysDeal and Search box testing

  Scenario Outline: search item in the search box  scenario
    Given user entering the '<search>' item in the search box
    And User click on search button
    When User click on wishList

    Examples: 
      | search |
      |        |
      |        |