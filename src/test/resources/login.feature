Feature: Login the site

  Scenario Outline: Login the site as an existing user

    Given I am on the Login page
    When I enter "<username>" and "<password>"
    And I click Sign in button
    Then I should go to Dashboard page
    Then Close the browser

    Examples:
    | username | password |
    | hr.doctor@hospitalrun.io | HRt3st12 |
    | hr.nurse@hospitalrun.io | HRt3st12 |
    | hr.nurse.manager@hospitalrun.io | HRt3st12 |