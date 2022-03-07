package Lesson25.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="publishers")
public class Publisher {
    @Id
    private int id;
    private String name;
}
