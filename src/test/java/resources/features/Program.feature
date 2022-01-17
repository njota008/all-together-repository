@UI @ignore
Feature: Program

  Scenario Outline: DTP Program Creation & Deletion
    Given I successfully login with "<user>" and "<password>"
    When I navigate to the DTP Program page
    And I fill all the fields in the Program Info section
    And I select the taxonomies and tags
    And I select the accelerators
    And I select the events and performance studies
    And I supply information about support and inquiries
    And I select advisors
    And I review and publish the program
    Then the program is created successfully
    And I delete the program

    Examples:
      | user                          | password |
      | thehackettgrouptest@gmail.com | welcome1 |