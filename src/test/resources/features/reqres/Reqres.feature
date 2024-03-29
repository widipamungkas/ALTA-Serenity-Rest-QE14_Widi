Feature: Test API Update and Delete
@tugas
  Scenario Outline: Get list users with valid parameter page
    Given Get list user with parameter page <page>
    When Send request get list users
    Then Status code should be 200
    And Response body page should be <page>
    And Validate json schema "ListUsersJsonSchema.json"
    Examples:
      | page |
      | 1    |
      | 2    |

@tugas
    Scenario: Post create user with valid json
      Given Create user with valid json "CreateUser.json"
      When Send request create new user
      Then Status code should be 201
      And Response body name should be "morpheus" and job is "leader"
      And Validate json schema "CreateUserJsonSchema.json"

@tugas
      Scenario Outline: : Update user with valid json and user id
      Given Update user with valid json "<json>" and user id <id>
        When Send request update user
        Then Status code should be 200
        And Response body name should be name <name> and job is <job>
        And Validate json schema "UpdateUserJsonSchema.json"

        Examples:
          | id | json             | name                    | job                  |
          | 1  | UpdateUser.json  | widi pamungkas update   | QA Engineer Update   |
          | 2  | UpdateUser2.json | widi pamungkas update 2 | QA Engineer Update 2 |
          | 3  | UpdateUser3.json | widi pamungkas update 3 | QA Engineer Update 3 |


