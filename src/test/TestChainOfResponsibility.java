package test;

import contactmanagementsoftware.Acquaintances;
import contactmanagementsoftware.chainOfResponsibility.resource.ContactValidatorChain;

public class TestChainOfResponsibility {
    public static void main(String[] args) {
        ContactValidatorChain chain = new ContactValidatorChain();
        Acquaintances contact = new Acquaintances();
        contact.setName("Yaw Jian Hao");
        contact.setEmail("howardyjh@siswa.um.edu.my");
        contact.setMobileNo("0123456789");

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
