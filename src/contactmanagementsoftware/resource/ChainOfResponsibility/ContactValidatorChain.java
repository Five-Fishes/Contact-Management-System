package contactmanagementsoftware.resource.ChainOfResponsibility;

import contactmanagementsoftware.entity.Contact;
import contactmanagementsoftware.service.ChainOfResponsibility.*;

import java.util.List;

public class ContactValidatorChain {
    ContactValidator chain;

    public ContactValidatorChain() {
        buildChain();
    }

    public void buildChain() {
        chain = new CasualAcquaintanceValidator(new RelativesValidator(new PersonalFriendsValidator(new ProfessionalFriendsValidator(new AcquaintanceValidator(null)))));
    }

    public void buildChain(List<ContactValidator> contactValidatorList) {
        if (contactValidatorList.size() < 1) {
            throw new IllegalArgumentException("ContactValidator List is 0");
        }
        for (int i = 1; i < contactValidatorList.size(); i++) {
            contactValidatorList.get(i).setContactValidator(contactValidatorList.get(i-1));
            chain = contactValidatorList.get(i);
        }
    }

    public void validateContact(Contact contact) {
        chain.validateContact(contact);
    }
}
