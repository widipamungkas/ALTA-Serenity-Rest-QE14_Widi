Feature: Patch Test API
  @tugas
  Scenario Outline: Patch user with valid json
    Given Patch user with valid json "<json>" and user id <id>
    When Send request patch user
    Then Status code should be 200
    And Response body name should be name <name> and job is <job>
    And Validate json schema "UpdateUserJsonSchema.json"
    Examples:
      | id | json             | name                    | job                  |
      | 1  | UpdateUser.json  | widi pamungkas update   | QA Engineer Update   |
      | 2  | UpdateUser2.json | widi pamungkas update 2 | QA Engineer Update 2 |
      | 3  | UpdateUser3.json | widi pamungkas update 3 | QA Engineer Update 3 |
