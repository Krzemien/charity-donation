package pl.coderslab.charity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @Min(value = 1, message = "Minimum 1")
    @Max(value = 100, message = "Maksimum 10")
    private int quantity;
    @OneToMany
    @NotNull(message = "Nie wybrano żadnej kategorii")
    private List<Category> categories;
    @ManyToOne
    @NotNull(message = "Nie wybrano instytucji")
    private Institution institution;
    @Size(min = 1, max = 250, message = "Dopuszczalna ilość znaków od 1 do 250")
    private String phoneNumber;
    @Size(min = 1, max = 250, message = "Dopuszczalna ilość znaków od 1 do 250")
    private String street;
    @Size(min = 1, max = 250, message = "Dopuszczalna ilość znaków od 1 do 250")
    private String city;
    @Size(min = 1, max = 250, message = "Dopuszczalna ilość znaków od 1 do 250")
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Pole nie może być puste")
    private LocalDate pickUpDate;
    @DateTimeFormat(pattern = "HH:mm")
    @NotNull(message = "Pole nie może być puste")
    private LocalTime pickUpTime;
    @Size(max = 250, message = "Maksymalna ilość znaków to 250")
    private String pickUpComment;

}
