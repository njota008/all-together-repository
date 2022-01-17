@UI
Feature: Login

  Scenario Outline: Login Success
    Given I navigate to the Home Page
    When I enter "<user>" and "<password>" as credentials
    Then I should login successfully with the proper "<user>"

    Examples:
      | user                          | password |
      | thehackettgrouptest@gmail.com | welcome1 |

  @ignore
  Scenario Outline: Login with incorrect and no credentials
    Given I navigate to the Home Page
    When I enter "<user>" and "<password>" as credentials
    Then I should see an alert
    And I should stay in the Home Page

    Examples:
      | user                          | password |
      | thehackettgrouptest@gmail.com | welcome2 |
      | thehackettgrouptes1@gmail.com | welcome1 |
      |                               |          |