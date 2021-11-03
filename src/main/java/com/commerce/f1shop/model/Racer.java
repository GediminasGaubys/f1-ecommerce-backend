package com.commerce.f1shop.model;

import javax.persistence.*;

@Entity
@Table(name = "racers")
public class Racer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "team")
    private String team;

    @Column(name = "carNumber")
    private String carNumber;

    @Column(name = "racesWon")
    private Integer racesWon;

    @Column(name = "age")
    private Integer age;

    @Column(name = "polePositions")
    private Integer polePositions;

    @Column(name = "entries")
    private Integer entries;

    @Column(name = "championships")
    private Integer championships;

    @Column(name = "podiums")
    private Integer podiums;

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getRacesWon() {
        return racesWon;
    }

    public void setRacesWon(Integer racesWon) {
        this.racesWon = racesWon;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPolePositions() {
        return polePositions;
    }

    public void setPolePositions(Integer polePositions) {
        this.polePositions = polePositions;
    }

    public Integer getEntries() {
        return entries;
    }

    public void setEntries(Integer entries) {
        this.entries = entries;
    }

    public Integer getChampionships() {
        return championships;
    }

    public void setChampionships(Integer championships) {
        this.championships = championships;
    }

    public Integer getPodiums() {
        return podiums;
    }

    public void setPodiums(Integer podiums) {
        this.podiums = podiums;
    }
}
