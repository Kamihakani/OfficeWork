package com.Officework.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EngineDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long engineNo;
    private String enginePower;
    private String engineType;
    private String madeBy;
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "car_id", referencedColumnName = "car_id", updatable = false)
    @JsonIgnore
    private Car car;
}
