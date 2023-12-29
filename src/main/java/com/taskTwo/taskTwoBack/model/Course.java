package com.taskTwo.taskTwoBack.model;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Course {
    @Id
    private String id;
    private String name;
    private float price;
    @Column(name = "image", length = 1000)
	private byte[] picByte;
    public Course(String name, float price, byte[] picByte) {
		this.name = name;
		this.price=price;
		this.picByte = picByte;
	}
	public void setId(String id) {
		this.id=id;
		
	}
	public Object getPicByte() {
		// TODO Auto-generated method stub
		return null;
	}
}

