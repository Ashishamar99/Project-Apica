package com.apico.usermanangement.model;

import com.apico.usermanangement.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "User id which is unique for each journal.")
    private Long id;

    @Schema(description = "Username of the user.")
    private String username;

    @Schema(description = "Password of the user.")
    private String password;

    @Schema(description = "Mail id of the user.")
    private String mailId;

    @Schema(description = "Phone number of the user.")
    private String phNo;

    @Schema(description = "Role of the user.")
    private Role role;
}
