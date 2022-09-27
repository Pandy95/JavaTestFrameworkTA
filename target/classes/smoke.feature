

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
    Then User checks if products on page contains word '<keyWord>' more than '<times>' times

    Examples:
      |homePage                    |keyWord |times|
      |https://www.cropp.com/ua/uk/|Кеди    |10   |
      |https://www.cropp.com/ua/uk/|Кросівки|20   |

  Scenario Outline: Check that location and language change working correctly
    Given User opens '<homePage>' page
    And User accepts cookies
    When User clicks Language button
    And User changes location to '<location>'
    Then User checks that url has changed to '<expectedUrl>'

    Examples:
      |homePage                    |location|expectedUrl                 |
      |https://www.cropp.com/ua/uk/|Poland  |https://www.cropp.com/pl/pl/|
      |https://www.cropp.com/ua/uk/|Italy   |https://www.cropp.com/it/it/|