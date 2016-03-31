package com.deswaef.website.contact.service;

import com.deswaef.website.contact.dto.ContactRequestDto;
import com.deswaef.website.contact.model.ContactRequest;
import com.deswaef.website.contact.repository.ContactRequestRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: Quinten
 * Date: 9-9-2014
 * Time: 23:24
 *
 * @author Quinten De Swaef
 */
@Service
public class ContactRequestService {

    private Log LOG = LogFactory.getLog(this.getClass());

    @Value("${mail.default.address.to}")
    private String defaultAddressTo;

    @Value("${mail.default.address.from}")
    private String defaultAddressFrom;

    @Autowired
    private MailService mailService;

    @Autowired
    private ContactRequestRepository repository;

    @Transactional
    public ContactRequest request(ContactRequestDto requestDto) {
        ContactRequest save = repository.save(
                new ContactRequest()
                        .setEmail(requestDto.getEmail())
                        .setName(requestDto.getName())
                        .setPhone(requestDto.getPhone())
                        .setMessage(requestDto.getMessage())
        );
        sendMail(save);
        return save;
    }

    @Async
    private void sendMail(ContactRequest save) {
        try {
            mailService.createMail()
                    .from(defaultAddressFrom)
                    .to(defaultAddressTo)
                    .subject("new contact request from de-swaef.eu")
                    .body(String.format("%s would like to contact you\n\n%s", save.getEmail(), save.getMessage()))
                    .send();
        } catch (Exception ex) {
            LOG.error("unable to send mail: " + ex.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public List<ContactRequest> findAll() {
        return repository.findAll();
    }
}
