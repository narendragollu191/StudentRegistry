package com.example.demo.student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Address {

    @Id
    @SequenceGenerator( name = "address_seq", sequenceName = "address_seq", allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")

    private Integer id;

    private String statename;

    private String streetname;

    private String Zipcode;

    public Address() {
    };

    public Address(Integer id, String statename, String streetname, String Zipcode) {
        this.id = id;
        this.statename = statename;
        this.streetname = streetname;
        this.Zipcode = Zipcode;
    }

    public Address(String statename, String streetname, String Zipcode) {
        this.statename = statename;
        this.streetname = streetname;
        this.Zipcode = Zipcode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    // public String getStatename() { return statename; }
    // public void setStatename(String statename) { this.statename = statename; }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", statename=" + statename + ", streetname=" + streetname + ", Zipcode=" + Zipcode
                + "]";
    }

}
