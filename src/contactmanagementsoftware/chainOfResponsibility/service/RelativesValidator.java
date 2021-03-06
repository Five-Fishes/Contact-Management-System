package contactmanagementsoftware.chainOfResponsibility.service;

import contactmanagementsoftware.Acquaintances;
import contactmanagementsoftware.Relatives;
import contactmanagementsoftware.singleton.Logger;
import contactmanagementsoftware.singleton.LoggerSingleton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RelativesValidator extends ContactValidator {

    private final Logger logger = LoggerSingleton.getInstance();

    public RelativesValidator(ContactValidator contactValidator) {
        super(contactValidator);
    }

    @Override
    public boolean validateContact(Acquaintances contact) {
        logger.debug("Relatives Validator validate contact");
        if (contact instanceof Relatives) {
            validateLDate(((Relatives) contact).getLDate());
            validateBDate(((Relatives) contact).getBDate());
            return true;
        }
        return super.validateContact(contact);
    }

    private void validateLDate(String lDate) {
        if (lDate == null || lDate.trim().length() < 1) {
            throw new IllegalArgumentException("Last meet date cannot be empty");
        }
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(lDate);
            Date today = new Date();
            if (date1.after(today)) {
                throw new IllegalArgumentException("Last meet date cannot be later than today");
            }

            if (isDateNYearsBefore(date1, 50)) {
                throw new IllegalArgumentException("Last meet date cannot be early than 50 years ago");
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Please enter Last meet date in (dd/mm/yyyy) format");
        }
    }

    private void validateBDate(String bDate) {
        if (bDate == null || bDate.trim().length() < 1) {
            throw new IllegalArgumentException("Birth date cannot be empty");
        }
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(bDate);
            Date today = new Date();
            if (date1.after(today)) {
                throw new IllegalArgumentException("Birth date cannot be later than today");
            }

            if (isDateNYearsBefore(date1, 100)) {
                throw new IllegalArgumentException("Birth date cannot be early than 100 years ago");
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Please enter birth date in (dd/mm/yyyy) format");
        }
    }

    private boolean isDateNYearsBefore (Date date, int nYears) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -nYears);
        Date hundredYearsAgo = calendar.getTime();
        return date.before(hundredYearsAgo);
    }
}
