package com.example.roombookingserver.model.entities;

import com.example.roombookingserver.model.Layout;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "room_id", nullable = false)
    private List<LayoutCapacity> capacities;

    public Room(String name, String location) {
        this.name = name;
        this.location = location;
        capacities = new ArrayList<>();
        for (Layout layout : Layout.values()) {
            capacities.add(new LayoutCapacity(layout, 0));
        }

    }

    public void setCapacity(LayoutCapacity capacity){
        for (LayoutCapacity layoutCapacity:capacities) {
            if(layoutCapacity.getLayout() == capacity.getLayout()){
                layoutCapacity.setCapacity(capacity.getCapacity());
            }
        }
    }
}
