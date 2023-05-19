package mk.finki.ukim.lab.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "shop_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<ShoppingCart> carts;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime dateOfBirth;


    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = LocalDateTime.now();
    }
}