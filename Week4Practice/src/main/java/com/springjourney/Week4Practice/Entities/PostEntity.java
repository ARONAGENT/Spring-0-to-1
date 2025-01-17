package com.springjourney.Week4Practice.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="post")
@Audited
public class PostEntity extends AuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    private String name;

    private String description;


}
