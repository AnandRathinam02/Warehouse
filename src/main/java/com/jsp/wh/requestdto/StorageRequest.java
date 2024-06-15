package com.jsp.wh.requestdto;

import java.util.List;

import com.jsp.wh.enums.MaterialType;

public class StorageRequest { 
	  
	 private String blockName; 
	 private String section; 
	 private int capacityInWeight; 
	 private double lengthInMeters; 
	 private double breadthInMeters; 
	 private double heightInMeters; 
	 List<MaterialType> materialTypes;
	public String getBlockName() {
		return blockName;
	}
	public String getSection() {
		return section;
	}
	public int getCapacityInWeight() {
		return capacityInWeight;
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
	public List<MaterialType> getMaterialTypes() {
		return materialTypes;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public void setCapacityInWeight(int capacityInWeight) {
		this.capacityInWeight = capacityInWeight;
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
	public void setMaterialTypes(List<MaterialType> materialTypes) {
		this.materialTypes = materialTypes;
	} 
	  
	  
	}
