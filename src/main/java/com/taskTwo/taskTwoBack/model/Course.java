package com.taskTwo.taskTwoBack.model;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="course")
public class Course {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COURSE_ID")
    private Long id;
    private String name;
    private float price;
    @Column(name = "image", length = 1000)
	private byte[] picByte;
    public Course() {}
    public Course(String name, float price,byte[] picByte) {
		this.name = name;
		this.price=price;
		this.picByte = picByte;
	}
	public void setPicByte(byte[] compressedBytes) {
	    this.picByte = compressedBytes;	}
	public byte[] getPicByte() {
		// TODO Auto-generated method stub
		return null;
	}
}

