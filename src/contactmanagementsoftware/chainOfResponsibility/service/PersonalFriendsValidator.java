package contactmanagementsoftware.chainOfResponsibility.service;

import contactmanagementsoftware.Acquaintances;
import contactmanagementsoftware.PersonalFriends;
import contactmanagementsoftware.singleton.Logger;
import contactmanagementsoftware.singleton.LoggerSingleton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonalFriendsValidator extends ContactValidator {

    private final Logger logger = LoggerSingleton.getInstance();

    public PersonalFriendsValidator(ContactValidator contactValidator) {
        super(contactValidator);
    }

    @Override
    public boolean validateContact(Acquaintances contact) {
        logger.debug("Personal Friends Validator validate contact");
        if (contact instanceof PersonalFriends) {
            validateADate(((PersonalFriends) contact).getADate());
            validateEvents(((PersonalFriends) contact).getEvents());
            validateAContext(((PersonalFriends) contact).getAContext());
            return true;
        }
        return super.validateContact(contact);
    }

    private void validateADate(String aDate) {
        if (aDate == null || aDate.trim().length() < 1) {
            throw new IllegalArgumentException("Acquaintance date cannot be empty");
        }
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(aDate);
            if (date1.after(new Date())) {
                throw new IllegalArgumentException("Acquaintance date cannot be later than today");
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Please enter acquaintance date in (dd/mm/yyyy) format");
        }
    }

    private void validateEvents(String events) {
        if (events == null) {
            throw new IllegalArgumentException("Events cannot be empty");
        }
        if (events.trim().length() < 1 || events.trim().length() > 300) {
            throw new IllegalArgumentException("Please enter events between (1-300) characters");
        }
    }

    private void validateAContext(String aContext) {
        if (aContext == null) {
            throw new IllegalArgumentException("Acquaintance context cannot be empty");
        }
        if (aContext.trim().length() < 1 || aContext.trim().length() > 300) {
            throw new IllegalArgumentException("Please enter acquaintance context between (1-300) characters");
        }
    }
}
