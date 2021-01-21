package com.example.sampleExample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
public class Publisher {

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private Long Id;
  private String name;
  private String addressLine1;
  private String city;
  private String state;
  private String zip;

  public Publisher(String name, String addressLine1, String city, String state, String zip) {
    this.name = name;
    this.addressLine1 = addressLine1;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }

  @Override
  public String toString() {
    return "Publisher{" +
           "Id=" + Id +
           ", name='" + name + '\'' +
           ", addressLine1='" + addressLine1 + '\'' +
           ", city='" + city + '\'' +
           ", state='" + state + '\'' +
           ", zip='" + zip + '\'' +
           '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Publisher publisher = (Publisher)o;
    return Objects.equals(Id, publisher.Id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Id);
  }
}
