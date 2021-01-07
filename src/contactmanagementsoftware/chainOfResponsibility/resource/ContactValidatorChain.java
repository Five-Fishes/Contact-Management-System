package contactmanagementsoftware.chainOfResponsibility.resource;

import contactmanagementsoftware.Acquaintances;
import contactmanagementsoftware.chainOfResponsibility.service.*;
import contactmanagementsoftware.singleton.Logger;
import contactmanagementsoftware.singleton.LoggerSingleton;

import java.util.List;

public class ContactValidatorChain {
    ContactValidator chain;
    private final Logger logger = LoggerSingleton.getInstance();

    public ContactValidatorChain() {
        buildChain();
    }

    public void buildChain() {
        logger.debug("Build Chain");
        chain = new AcquaintanceValidator(new ProfessionalFriendsValidator(new PersonalFriendsValidator(new RelativesValidator(new CasualAcquaintanceValidator(null)))));
    }

    public void buildChain(List<ContactValidator> contactValidatorList) {
        if (contactValidatorList.size() < 1) {
            throw new IllegalArgumentException("ContactValidator List is 0");
        }
        if (! (contactValidatorList.get(0) instanceof  AcquaintanceValidator) ) {
            throw new IllegalArgumentException("First ContactValidator must be AcquaintanceValidator");
        }
        for (int i = 0; i < contactValidatorList.size()-1; i++) {
            contactValidatorList.get(i).setContactValidator(contactValidatorList.get(i+1));
        }
        chain = contactValidatorList.get(0);
    }

    public void validateContact(Acquaintances contact) {
        chain.validateContact(contact);
    }
}
