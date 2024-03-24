Feature: Test API Register

  Scenario: Post register succesful
  Given User register with valid email and password "RegisterUser.json"
    When Send request post register
    Then Status should be 200
    And Response body should be 4 and "QpwL5tke4Pnpja7X4"
    And Validate json schema "RegisterUserJsonSchema.json"

  Scenario: User register unsuccessfully
  Given User register with invalid email and valid password "UnsuccessfulRegisterUser.json"
    When Send request post register
    Then Status should be 400
    And Response body should shown an error message "Missing email or username"
    And Validate json schema "InvalidRegJsonSchema.json"

    Scenario: Post register unsuccesful
      Given User register without input password "UnsuccesRegUser.json"
      When Send request post register
      Then Status should be 400
      And Response body should be shown error "Missing password"
      And Validate json schema "UnsuccesfulRegJsonSchema.json"
