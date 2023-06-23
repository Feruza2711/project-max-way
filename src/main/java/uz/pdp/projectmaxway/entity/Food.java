package uz.pdp.projectmaxway.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Food extends AbsUUIDEntity {

    @Column(nullable = false,unique = true)
    private String name;

    private String description;

    @ManyToOne
    private Category category;

    @Column(nullable = false)
    private double price;

}
