package online.mizak.mcms.account.dto;

public record CreateUserRequest(
        String login,
        String password,
        String email
) {

}
