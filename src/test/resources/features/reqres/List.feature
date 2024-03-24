Feature: Test API List User
  Scenario: get list resource
    Given Get list resource correctly
    When Send request get list resources
    Then Status code should be 200
    And Validate json schema "ListResourcesJsonSchema.json"
    And Response body should be page 1

  Scenario: get single list user
    Given Get list single user
    When Send request get list single user
    Then Status code should be 200
    And Validate json schema "ListSingleUserJsonSchema.json"
    And Response body should be data id 2


  Scenario: Get single list user not found
    Given Get list single user with invalid page
    When Send request get list single user invalid page
    Then Status code should be 404
    And Validate json schema "ListSingleNotFoundJsonSchema.json"
