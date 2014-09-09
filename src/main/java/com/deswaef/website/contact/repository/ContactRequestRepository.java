package com.deswaef.website.contact.repository;

import com.deswaef.website.contact.model.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: Quinten
 * Date: 9-9-2014
 * Time: 23:22
 *
 * @author Quinten De Swaef
 */
public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {
}
