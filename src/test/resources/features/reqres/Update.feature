Feature: Test API Update
  @tugas
    #Negative Test Case
  Scenario Outline: : Update user with invalid json and user id
    Given Update user with invalid json "<json>" and user id <id>
    When Send request update user
    Then Status code should be 404

    Examples:
      | id | json                   |
      | 1  | UpdateInvalidUser.json |