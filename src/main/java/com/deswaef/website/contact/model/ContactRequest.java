package com.deswaef.website.contact.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * User: Quinten
 * Date: 9-9-2014
 * Time: 11:54
 *
 * @author Quinten De Swaef
 */
@Entity
public class ContactRequest {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestTime;

    @PrePersist
    private void prePersist() {
        this.requestTime = now();
    }

    private Date now() {
        return new Date();
    }

    public Long getId() {
        return id;
    }

    public ContactRequest setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ContactRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ContactRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public ContactRequest setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ContactRequest setMessage(String message) {
        this.message = message;
        return this;
    }
}
