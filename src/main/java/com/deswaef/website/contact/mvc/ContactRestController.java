package com.deswaef.website.contact.mvc;

import com.deswaef.website.contact.model.ContactRequest;
import com.deswaef.website.contact.mvc.dto.ContactRequestDtoImpl;
import com.deswaef.website.contact.service.ContactRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * User: Quinten
 * Date: 9-9-2014
 * Time: 23:30
 *
 * @author Quinten De Swaef
 */
@RestController
@RequestMapping(value = "/rest/contact")
public class ContactRestController {

    @Autowired
    private ContactRequestService requestService;

    @RequestMapping(method = GET)
    public ResponseEntity<String> defaultRouting() {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @RequestMapping(method = POST ,headers = "content-type=application/x-www-form-urlencoded")
    public ResponseEntity<ContactRequest> doRequest(@ModelAttribute ContactRequestDtoImpl contactRequestDto) {
        return new ResponseEntity<>(requestService.request(contactRequestDto), HttpStatus.OK);
    }
}
