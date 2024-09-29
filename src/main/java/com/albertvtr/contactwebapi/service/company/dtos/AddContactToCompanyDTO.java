package com.albertvtr.contactwebapi.service.company.dtos;


public class AddContactToCompanyDTO {

    private Long companyId;
    private Long contactId;

    public AddContactToCompanyDTO() {}
    public AddContactToCompanyDTO(Long companyId, Long contactId) {
        setCompanyId(companyId);
        setContactId(contactId);
    }

    // Getters and setters
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }
}


