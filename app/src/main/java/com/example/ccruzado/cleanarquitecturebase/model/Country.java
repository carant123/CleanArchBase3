package com.example.ccruzado.cleanarquitecturebase.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ccruzado on 14/03/2018.
 */


@Root(name = "Table", strict = false)
public class Country {

    @Element(name = "Name", required = false)
    private String country;

    public Country() {
    }

    public Country(String country) {
        this.country = country;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
