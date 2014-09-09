package com.deswaef.website.contact.mvc.dto;

import com.deswaef.website.contact.dto.ContactRequestDto;
import com.deswaef.website.contact.model.ContactRequest;

/**
 * User: Quinten
 * Date: 9-9-2014
 * Time: 23:45
 *
 * @author Quinten De Swaef
 */
public class ContactRequestDtoImpl implements ContactRequestDto {

    private String email;
    private String phone;
    private String message;
    private String name;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
