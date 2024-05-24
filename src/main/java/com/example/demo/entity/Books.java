package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Books extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String category;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "publisher_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "fk_books_publishers"
            )
    )
    @JsonBackReference
    private Publishers publisher;
}
//@Entity
//@Builder
//public record Books(
//        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//        int id,
//        String title,
//        String description,
//        String category,
//        LocalDateTime createdAt,
//        LocalDateTime updatedAt,
//        @ManyToOne(
//                cascade = CascadeType.ALL
//        )
//        @JoinColumn(
//                name = "publisher_id",
//                referencedColumnName = "id",
//                foreignKey = @ForeignKey(
//                        name = "fk_books_publishers"
//                )
//        )
//        @JsonBackReference
//        Publishers publisher
//){}
