package com.jsp.wh.entity;

import java.util.List;

import com.jsp.wh.enums.MaterialType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Storage {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	 private int storageId; 
	 private String blockName; 
	 private String section; 
	 private double lengthInMeters; 
	 private double breadthInMeters; 
	 private double heightInMeters; 
	 private int capacityInWeight; 
	 @Enumerated(EnumType.STRING) 
	 List<MaterialType> materialTypes; 
	 private double maxAdditionalWeight; 
	 private double availableArea; 
	 
	 @ManyToOne 
	 private Warehouse wareHouse;

	public int getStorageId() {
		return storageId;
	}

	public String getBlockName() {
		return blockName;
	}

	public String getSection() {
		return section;
	}

	public double getLengthInMeters() {
		return lengthInMeters;
	}

	public double getBreadthInMeters() {
		return breadthInMeters;
	}

	public double getHeightInMeters() {
		return heightInMeters;
	}

	public int getCapacityInWeight() {
		return capacityInWeight;
	}

	public List<MaterialType> getMaterialTypes() {
		return materialTypes;
	}

	public double getMaxAdditionalWeight() {
		return maxAdditionalWeight;
	}

	public double getAvailableArea() {
		return availableArea;
	}

	public Warehouse getWareHouse() {
		return wareHouse;
	}

	public void setStorageId(int storageId) {
		this.storageId = storageId;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public void setLengthInMeters(double lengthInMeters) {
		this.lengthInMeters = lengthInMeters;
	}

	public void setBreadthInMeters(double breadthInMeters) {
		this.breadthInMeters = breadthInMeters;
	}

	public void setHeightInMeters(double heightInMeters) {
		this.heightInMeters = heightInMeters;
	}

	public void setCapacityInWeight(int capacityInWeight) {
		this.capacityInWeight = capacityInWeight;
	}

	public void setMaterialTypes(List<MaterialType> materialTypes) {
		this.materialTypes = materialTypes;
	}

	public void setMaxAdditionalWeight(double maxAdditionalWeight) {
		this.maxAdditionalWeight = maxAdditionalWeight;
	}

	public void setAvailableArea(double availableArea) {
		this.availableArea = availableArea;
	}

	public void setWareHouse(Warehouse wareHouse) {
		this.wareHouse = wareHouse;
	}
	 
	 
}
