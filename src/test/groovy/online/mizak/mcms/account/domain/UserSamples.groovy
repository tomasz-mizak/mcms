package online.mizak.mcms.account.domain

import groovy.transform.CompileStatic
import online.mizak.mcms.account.dto.CreateUserRequest

@CompileStatic
trait UserSamples {

    String validLogin = "t.mizak"
    String validPassword = "t.mizak@123!#"
    String invalidLogin = "ewa"
    String invalidLogin_tooLong = "aLotOfTextInPasswordCannotBeAcceptedByServerIfIsGreaterThanNChars"
    String invalidPassword = "tmizak"
    String invalidPassword_tooShort = "abc"
    String invalidPassword_tooLong = "aLotOfTextInPasswordCannotBeAcceptedByServerIfIsGreaterThanNChars"

    CreateUserRequest validCreateUserRequest = new CreateUserRequest(validLogin, validPassword, null)
    CreateUserRequest invalidCreateUserRequest = new CreateUserRequest(invalidLogin, validPassword, null)

}
