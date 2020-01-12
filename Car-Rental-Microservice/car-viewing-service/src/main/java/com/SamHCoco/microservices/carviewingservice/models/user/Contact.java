package com.SamHCoco.microservices.carviewingservice.models.user;

public class Contact {

    private String phoneNumber;
    private String email;

    public Contact(){

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return " \nCONTACT: " + "\n" +
                "  phone: " + phoneNumber + "\n" +
                "  email: " + email + "\n";
    }
}
