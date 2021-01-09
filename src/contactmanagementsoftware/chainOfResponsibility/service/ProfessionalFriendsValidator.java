package contactmanagementsoftware.chainOfResponsibility.service;

import contactmanagementsoftware.Acquaintances;
import contactmanagementsoftware.ProfessionalFriends;
import contactmanagementsoftware.singleton.Logger;
import contactmanagementsoftware.singleton.LoggerSingleton;

public class ProfessionalFriendsValidator extends ContactValidator {

    private final Logger logger = LoggerSingleton.getInstance();

    public ProfessionalFriendsValidator(ContactValidator contactValidator) {
        super(contactValidator);
    }

    @Override
    public boolean validateContact(Acquaintances contact) {
        logger.debug("Professional Friends Validator validate contact");
        if (contact instanceof ProfessionalFriends) {
            validateCommonInterests(((ProfessionalFriends) contact).getCommonInterests());
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
