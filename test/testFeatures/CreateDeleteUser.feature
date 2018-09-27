#Author: nvq.rich@gmail.com
#Keywords Summary : Test MaSoi

@tag
Feature: Create/Delete user
  This is the create user feature

  @tag1
  Scenario: Open manage user screen
    Given I'm in the game
    And I see play btn
    When Click on play button
    And Wait 3s
    Then The setup UI display
    And Has 4 default user

  @tag2
  Scenario: Delete user
    Given I'm in the manage user page
    And I open user contains " 2" in name
    When I click on delete btn
    Then User contains " 2" in name was deleted


  @tag3
  Scenario: Create 4 user
    Given I'm in the manage user page
    Then I can add the user
      | Anthony |
      | Jenny   |
      | Jack    |
      | Robert  |

