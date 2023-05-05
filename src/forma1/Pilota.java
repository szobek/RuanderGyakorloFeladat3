package forma1;

public class Pilota {
private String name;
private String birthDate;
private String country;
private int num;
private boolean isActive;
public Pilota(String name, String birthDate, String country, int num, boolean isActive) {
	super();
	this.name = name;
	this.birthDate = birthDate;
	this.country = country;
	this.num = num;
	this.isActive = isActive;
}

public Pilota(String[] csvLine) {
	this.name = csvLine[0];
	this.birthDate = csvLine[1];
	this.country = csvLine[2];
	this.num = Integer.parseInt( csvLine[3]);
	this.isActive = false;
}
}
