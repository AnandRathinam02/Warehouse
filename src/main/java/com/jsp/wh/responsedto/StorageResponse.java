package com.jsp.wh.responsedto;

import java.util.List;

import com.jsp.wh.enums.MaterialType;

public class StorageResponse { 
	 
	 private int storageId; 
	 private String blockName; 
	 private String section; 
	 private double capacityInKg; 
	 List<MaterialType> materialTypes; 
	 private double maxAdditionalWeight; 
	 private double availableArea;
	public int getStorageId() {
		return storageId;
	}
	public String getBlockName() {
		return blockName;
	}
	public String getSection() {
		return section;
	}
	public double getCapacityInKg() {
		return capacityInKg;
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
	public void setStorageId(int storageId) {
		this.storageId = storageId;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public void setCapacityInKg(double capacityInKg) {
		this.capacityInKg = capacityInKg;
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
 
	 
	 
	 
	}
