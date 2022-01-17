@UI @ignore
Feature: Fill Assessments > Finance E2E Benefit Case Survey

  Scenario: Assessments > Finance E2E Benefit Case Survey
    Given I successfully login in DTP
    When I navigate to the Finance Benefits End-to-End page
    And Create and fill a new survey
