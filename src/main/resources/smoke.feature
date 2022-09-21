

@Smoke
Feature: As a user
    User want to test all main site functionality
    So that user can be sure that site works correctly


  Scenario Outline: Check if the element "cropp" is visible
    Given User opens '<homePage>' page
    Then User checks whether 'cropp' is written in the header of the site

    Examples:
      |homePage|
      |https://www.cropp.com/ua/uk/|

  Scenario Outline: Check if the elements contains word <keyWord> more then <times>
    Given User opens '<homePage>' page
    And User accepts cookies
    When User moves a cursor to the tab menu Shoes
    And User clicks All for men
    Then User checks if the elements on page contains word '<keyWord>' more than ten times


    Examples:
    |homePage|keyWord|
    |https://www.cropp.com/ua/uk/|Кеди|