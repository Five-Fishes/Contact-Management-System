package contactmanagementsoftware.service.ChainOfResponsibility;

import contactmanagementsoftware.entity.Contact;

public class ProfessionalFriendsValidator extends ContactValidator {
    private static final String CONTACT_TYPE = "class contactmanagementsoftware.ProfessionalFriends";

    public ProfessionalFriendsValidator(ContactValidator contactValidator) {
        super(contactValidator);
    }

    @Override
    public boolean validateContact(Contact contact) {
        // TODO: use instance of class
        if (contact.getClass().toString().equalsIgnoreCase(CONTACT_TYPE)) {
            validateCommonInterests(contact.getCommonInterests());
            return true;
        }
        return super.validateContact(contact);
    }

    private void validateCommonInterests(String commonInterests) {
        if (commonInterests == null) {
            throw new IllegalArgumentException("Common Interests cannot be empty");
        }
        if (commonInterests.trim().length() < 1 || commonInterests.trim().length() > 300) {
            throw new IllegalArgumentException("Please enter common interest between (1-300) characters");
        }
    }
}
