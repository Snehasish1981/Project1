
Feature: Open Goibibo website landing page
Background:

  Scenario Outline: Open Goibibo website landing page

    Given User launch Goibibo website page
    When User clicks on hotel menu
    And enters location <Location> & check in <Fromdate> & check out <Todate> details
    And selects one adult <Guests> under Rooms <Rooms> option

    And clicks on Search button
    When Hotel list appears
    Then list down the hotel names
    Then select hotel <Hotelname> from the list
    Then close browser
    Examples:
    |Location|Fromdate|Todate|Guests|Rooms|Hotelname|
    |Kolkata |29-May-2024|31-May-2024|"1"|"1"|NPG|
