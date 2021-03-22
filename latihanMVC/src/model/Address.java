package model;

public class Address {
    
    private String Prefix;
    private int AddressId;
    private String Street1;
    private String Street2;
    private int VillageId;
    
    //konstruktor
    public Address(String Prefix, int AddressId, String Street1, String Street2, int VillageId) {
        this.Prefix = Prefix;
        this.AddressId = AddressId;
        this.Street1 = Street1;
        this.Street2 = Street2;
        this.VillageId = VillageId;
    }
    public Address() {
        
    }

    
    //getter dan setter
    public String getPrefix() {
        return Prefix;
    }

    public void setPrefix(String Prefix) {
        this.Prefix = Prefix;
    }

    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int AddressId) {
        this.AddressId = AddressId;
    }

    public String getStreet1() {
        return Street1;
    }

    public void setStreet1(String Street1) {
        this.Street1 = Street1;
    }

    public String getStreet2() {
        return Street2;
    }

    public void setStreet2(String Street2) {
        this.Street2 = Street2;
    }

    public int getVillageId() {
        return VillageId;
    }

    public void setVillageId(int VillageId) {
        this.VillageId = VillageId;
    }
    
    
}
