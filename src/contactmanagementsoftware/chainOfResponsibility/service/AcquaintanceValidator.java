package contactmanagementsoftware.chainOfResponsibility.service;

import contactmanagementsoftware.Acquaintances;

public class AcquaintanceValidator extends ContactValidator {
    public AcquaintanceValidator(ContactValidator contactValidator) {
        super(contactValidator);
    }

    @Override
    public boolean validateContact(Acquaintances contact) {
        validateName(contact.getName());
        validateEmail(contact.getEmail());
        validateMobileNumber(contact.getMobileNo());
        return super.validateContact(contact);
    }

    private void validateName(String name) {
        if (name == null || name.trim().length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.trim().length() < 1) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (! ((email.contains("@") && email.contains("."))) ) {
            throw new IllegalArgumentException("Please enter a validate email");
        }
    }

    private void validateMobileNumber(String mobileNo) {
        if (mobileNo == null || mobileNo.trim().length() < 1) {
            throw new IllegalArgumentException("Mobile Number cannot be empty");
        }
        if (mobileNo.trim().length() < 6 || mobileNo.trim().length() > 15 ) {
            throw new IllegalArgumentException("Please enter a validate mobile number (6-15) digits");
        }
        try {
            Integer.parseInt(mobileNo);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Please enter mobile number with digits only");
        }
    }
}
