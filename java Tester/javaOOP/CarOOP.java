package javaOOP;

public class CarOOP {

	private String carCompany;
	private String carType;
	private String fuelType;
	private Float mileAge;
	private Double carPrice;
	
	protected CarOOP(String carCompany, String carType, String fuelType, Float mileAge, Double carPrice) {
		super();
		this.carCompany = carCompany;
		this.carType = carType;
		this.fuelType = fuelType;
		this.mileAge = mileAge;
		this.carPrice = carPrice;
	}
	
	protected final String getCarCompany() {
		return carCompany;
	}
	protected final void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}
	protected final String getCarType() {
		return carType;
	}
	protected final void setCarType(String carType) {
		this.carType = carType;
	}
	protected final String getFuelType() {
		return fuelType;
	}
	protected final void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	protected final Float getMileAge() {
		return mileAge;
	}
	protected final void setMileAge(Float mileAge) {
		this.mileAge = mileAge;
	}
	protected final Double getCarPrice() {
		return carPrice;
	}
	protected final void setCarPrice(Double carPrice) {
		this.carPrice = carPrice;
	}
	
	protected void showCarInfor() {
		System.out.println("Car company = "+ getCarCompany());
		System.out.println("Car type = "+ getCarType());
		System.out.println("Car fuel type = "+ getFuelType());
		System.out.println("Car mile age = "+ getMileAge());
		System.out.println("Car price = "+ getCarPrice());
	}
	
	public static void main(String[] args) {
		CarOOP honda = new CarOOP("Honda","City","Petrol",150f,50000d);
		honda.showCarInfor();
		
		CarOOP toyota = new CarOOP("Toyota","City1","Petrol1",1501f,60000d);
		toyota.showCarInfor();
		
	}

}
