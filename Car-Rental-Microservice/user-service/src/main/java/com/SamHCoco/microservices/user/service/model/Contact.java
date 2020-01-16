package com.SamHCoco.microservices.user.service.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Embeddable
public class Contact {

    @NotEmpty
    @NotNull
    private String phoneNumber;

    @NotEmpty
    @NotNull
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
