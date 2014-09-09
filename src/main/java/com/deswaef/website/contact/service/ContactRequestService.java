package com.deswaef.website.contact.service;

import com.deswaef.website.contact.dto.ContactRequestDto;
import com.deswaef.website.contact.model.ContactRequest;
import com.deswaef.website.contact.repository.ContactRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: Quinten
 * Date: 9-9-2014
 * Time: 23:24
 *
 * @author Quinten De Swaef
 */
@Service
public class ContactRequestService {

    @Autowired
    private ContactRequestRepository repository;

    @Transactional
    public ContactRequest request(ContactRequestDto requestDto) {
        return repository.save(
            new ContactRequest()
                .setEmail(requestDto.getEmail())
                .setName(requestDto.getName())
                .setPhone(requestDto.getPhone())
                .setMessage(requestDto.getMessage())
        );
    }
}
