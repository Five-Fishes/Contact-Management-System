package test;

import contactmanagementsoftware.entity.Contact;
import contactmanagementsoftware.resource.ChainOfResponsibility.ContactValidatorChain;

public class TestChainOfResponsibility {
    public static void main(String[] args) {
        ContactValidatorChain chain = new ContactValidatorChain();
        Contact contact = new Contact();
        contact.setName("Yaw Jian Hao");
        contact.setEmail("howardyjh@siswa.um.edu.my");
        contact.setMobileNo("0123456789");
        contact.setAContext("Meet in office");

        System.out.println("Start Validate");
        try {
            chain.validateContact(contact);
        } catch (Exception e) {
            // TODO: display messageDialog
            // JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
            System.out.println(e.getMessage());
        }

        System.out.println("End Validate");
    }
}
