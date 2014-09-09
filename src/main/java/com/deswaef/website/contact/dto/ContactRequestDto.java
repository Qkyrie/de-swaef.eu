package com.deswaef.website.contact.dto;

/**
 * User: Quinten
 * Date: 9-9-2014
 * Time: 23:25
 *
 * @author Quinten De Swaef
 */
public interface ContactRequestDto {
    Long getId();
    String getName();
    String getPhone();
    String getEmail();
    String getMessage();
}
