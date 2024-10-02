package online.mizak.mcms.account.dto;

public record UserDto(
        Long id,
        String login,
        String email,
        String role
) {

}
