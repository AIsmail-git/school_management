/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 10 June 2022
 */
package za.ac.cput.school_management.domain;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Entity
public class City {
    @Id
    private String id;

    private String name;

    @ManyToOne(cascade = { PERSIST, MERGE })
    @NotFound(action = NotFoundAction.IGNORE)
    private Country country;

    public City(){}

    private City(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.country = builder.country;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Country getCountry()
    {
        return country;
    }

    public static class Builder {
        private String id;
        private String name;
        private Country country;

        public Builder setId(String id)
        {
            this.id = id;
            return this;
        }

        public Builder setName(String name)
        {
            this.name = name;
            return this;
        }

        public Builder setCountry(Country country)
        {
            this.country = country;
            return this;
        }

        @Override
        public String toString()
        {
            return "Builder{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", country=" + country + '}';
        }

        public City build()
        {
            return new City(this);
        }

    }
}





