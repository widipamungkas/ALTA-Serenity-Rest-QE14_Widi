Feature: Test API Login

  @Tugas
  Scenario: Post login successfully

    Given login user with valid email and password with json "LoginUserJsonSchema.json"
    When send request post login
    Then Status should be 200
    And Validate json schema "LoginUserJsonSchemaReturn.json"
    And Response body should be show "QpwL5tke4Pnpja7X4"

  Scenario: Post login unsuccessfully
    Given login user without input email and password with json "InvalidLoginUserJsonSchema.json"
    When send request post login
    Then Status should be 400
    And Response body should shown error "Missing password"
    And Validate json schema "LoginUserJsonFailed.json"

  Scenario: Login - Unsucessfull
    Given login username without password with json "UnsuccessLogin.json"
    When send request post login
    Then Status should be 400
    And Response body should be shown error messages "Missing password"
    And Validate json schema "LoginUserJsonFailed.json"


