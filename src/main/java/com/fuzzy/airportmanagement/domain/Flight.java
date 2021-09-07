package com.fuzzy.airportmanagement.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "flights")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "departure_time")
    Date depDate;
    @Column(name = "arrival_time")
    Date arrDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dep_airport_id", referencedColumnName = "id")
    Airport depAirport;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arr_airport_id", referencedColumnName = "id")
    Airport arrAirport;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    Company company;
    @ManyToMany
    @JoinTable(name = "flight_passenger",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id"))
    Set<Passenger> passengers;

}
