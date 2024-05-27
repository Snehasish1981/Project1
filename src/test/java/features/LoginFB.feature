Feature: Open Facebook page and login
  Background:
@FB_Login
  Scenario: Open Facebook page and login using UID and PWD

    Given User launch Facebook website page
    When User enters UID and PWD and hits submit button
    Then Facebook landing page should be displayed


