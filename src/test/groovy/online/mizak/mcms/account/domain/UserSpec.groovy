package online.mizak.mcms.account.domain

import online.mizak.mcms.infrastructure.exceptions.NotAcceptableException
import spock.lang.Specification

class UserSpec extends Specification implements UserSamples {

    def userFacade = AccountConfig.accountFacade()

    // - - - Create - - - //

    def "System should create user with login only"() {
        when: "Create regular user"
        def createdUser = userFacade.createUser(validCreateUserRequest)
        then: "User has been created"
        createdUser.id() != null
    }

    def "System should throw exception when login is not more or equal than minimal length"() {
        when: "Create user"
        def createdUser = userFacade.createUser(invalidCreateUserRequest)
        then: "Exception was thrown"
        def e = thrown(NotAcceptableException.class)
        e.message == "User login must be between 5 and 32 characters."
    }

    def "System should throw exception when login is greater than maximal length"() {

    }

    def "System should throw exception when try to create login with some illegal chars"() {

    }

    def "System should create user with email address"() {

    }

    def "System should create privileged admin user if database is empty"() {

    }

    // - - - Read - - - //

    def "System should show all users"() {

    }

    def "System should show all users paginated"() {

    }

    def "System should count users"() {
        when: "Create one user"
        userFacade.createUser(validCreateUserRequest)
        then: "In system exist one user"
        userFacade.countUsers() == 1
    }

    // - - - Update - - - //

    def "System should update user password"() {

    }

    def "System should update user email"() {

    }

    def "System should block update user email when format is not correctly"() {

    }

    def "System should disable user account"() {

    }

    def "System should enable user account"() {

    }

    // - - - Delete - - - //

    def "System should delete user"() {

    }

    def "System should block delete user if currently existing users is 1"() {

    }

}
