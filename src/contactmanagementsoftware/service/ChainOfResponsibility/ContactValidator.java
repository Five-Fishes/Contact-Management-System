package contactmanagementsoftware.service.ChainOfResponsibility;

import contactmanagementsoftware.entity.Contact;

public abstract class ContactValidator {

    private ContactValidator contactValidator;

    public ContactValidator(ContactValidator contactValidator) {
        this.contactValidator = contactValidator;
    }

    public boolean validateContact(Contact contact) {
        if (contactValidator != null) {
            contactValidator.validateContact(contact);
        }
        return true;
    }

    public void setContactValidator(ContactValidator contactValidator) {
        this.contactValidator = contactValidator;
    }

    public ContactValidator getContactValidator() {
        return contactValidator;
    }
}
