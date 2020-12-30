package contactmanagementsoftware.service.ChainOfResponsibility;

import contactmanagementsoftware.entity.Contact;

public class CasualAcquaintanceValidator extends ContactValidator {
    private static final String CONTACT_TYPE = "class contactmanagementsoftware.CasualAcquaintance";

    public CasualAcquaintanceValidator(ContactValidator contactValidator) {
        super(contactValidator);
    }

    @Override
    public boolean validateContact(Contact contact) {
        if (contact.getClass().toString().equalsIgnoreCase(CONTACT_TYPE)) {
            validateCircumstances(contact.getCircumstances());
            validateOtherInfo(contact.getOtherInfo());
            validateWhenWhere(contact.getWhenWhere());
            return true;
        }
        return super.validateContact(contact);
    }

    private void validateCircumstances(String circumstances) {
        if (circumstances == null) {
            throw new IllegalArgumentException("Circumstances cannot be empty");
        }
        if (circumstances.trim().length() < 1 || circumstances.trim().length() > 300) {
            throw new IllegalArgumentException("Please enter circumstances between (1-300) characters");
        }
    }

    private void validateOtherInfo(String otherInfo) {
        if (otherInfo== null) {
            throw new IllegalArgumentException("Other info cannot be empty");
        }
        if (otherInfo.trim().length() < 1 || otherInfo.trim().length() > 300) {
            throw new IllegalArgumentException("Please enter other info between (1-300) characters");
        }
    }

    private void validateWhenWhere(String whenWhere) {
        if (whenWhere == null) {
            throw new IllegalArgumentException("When where cannot be empty");
        }
        if (whenWhere.trim().length() < 1 || whenWhere.trim().length() > 300) {
            throw new IllegalArgumentException("Please enter when where between (1-300) characters");
        }
    }
}
