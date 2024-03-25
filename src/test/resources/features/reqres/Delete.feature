Feature: Test API Delete
  @tugas
    #Negative Delete Test Case
  Scenario: Delete user with valid user id
    Given Delete user with user id 2
    When Send request delete user
    Then Status code should be 204

  @tugas
    #Negative Delete Test Case
  Scenario: Delete user with invalid user id
    Given Delete user with invalid user "a"
    When Send request delete user
    Then Status code should be 204