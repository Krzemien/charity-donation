package pl.coderslab.charity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    @NotBlank
    @Size(min = 2, max = 60, message = "Nazwa musi być o długości 2-60 znaków")
    private String username;
    @Column(nullable = false, length = 60)
    @NotBlank
    @Size(min = 2, max = 60, message = "Hasło musi być o długości 2-60 znaków")
    private String password;
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    private int enabled;
    @OneToMany
    private Set<Role> roles;

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }

}
