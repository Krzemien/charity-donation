package pl.coderslab.charity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Donation {
    @Id
    @GeneratedValue
    private Long id;
    private int quantity;
    @OneToMany
    private List<Category> categories;
    @ManyToOne
    private Institution institution;

    // ... pozostale
}
