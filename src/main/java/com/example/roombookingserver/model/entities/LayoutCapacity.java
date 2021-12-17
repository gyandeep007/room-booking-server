package com.example.roombookingserver.model.entities;


import com.example.roombookingserver.model.Layout;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class LayoutCapacity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "layout_id")
    private Long id;


    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Layout layout;


    @Column(nullable = false)
    private Integer capacity;

    public LayoutCapacity(Layout layout, int capacity) {
        this.layout = layout;
        this.capacity =capacity;

    }
}
