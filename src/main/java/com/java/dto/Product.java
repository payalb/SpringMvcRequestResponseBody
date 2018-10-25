package com.java.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Product implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
 private int id;
 private String name;
 private float price;
 private int quantity;
 private String description;
 private String photo;
 private byte active;
 private LocalDateTime creationdate;
 @ManyToMany
 private List<Category> categories;
}
