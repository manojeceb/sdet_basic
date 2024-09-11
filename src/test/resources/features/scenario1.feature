Feature: Welcome to the-internet Features

  Scenario: Verification of page title
    Given I open the herokuapp url
    And I verify the page title "The Internet"

  Scenario: Verification of A/B Testing link and the text
    Given I open the herokuapp url
    When I click the "A/B Testing" link
    Then I verify the text "A/B Test Variation 1"
    And I navigate to home page

  Scenario: Verification of dropdown selection
    Given I open the herokuapp url
    When I click the "Dropdown" link
    Then I select the option "Option 1" and make sure it is selected
    And I navigate to home page

  Scenario: Verification of frame links
    Given I open the herokuapp url
    When I click the "Frames" link
    Then I validate the hyperlinks available
      | Nested Frames |
      | iFrame        |