#Feature: UserRegistration
#  I want to check that the user can register in our e-Commerce Website.
#  Scenario: user Registration
#    Given  the User in the Home Page
#    When  I click on register link
#    And I entered the user Data
#    Then The registration page displayed Successfully

Feature: UserRegistration
  I want to check that the user can register in our e-Commerce Website.
  Scenario Outline: : user Registration
    Given  the User in the Home Page
    When  I click on register link
    And I entered the user Data "<firstname>","<lastname>", "<email>","<password>"
    Then The registration page displayed Successfully

Examples:
  | firstname | lastname | email           | password  |  |
  | ahmed     | mohamed  | ah.mo@gmail.com | 123546987 |  |
  | loai      | taha     | looooo.ehh@gmail.com | 55555555789 |  |



