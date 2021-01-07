package contactmanagementsoftware;

public class ConstructContact {

    public Acquaintances createContact(int type, String[] args) {
        if (type == 0) {
            return personalFriendsContact(args);
        }
        if (type == 1) {
            return relativesContact(args);
        }
        if (type == 2) {
            return professionalFriendsContact(args);
        }
        if (type == 3) {
            return CasualAcquaintancesContact(args);
        }
        return null;
    }

    private Acquaintances CasualAcquaintancesContact(String[] args) {
        CasualAcquaintances casualAcquaintances = new CasualAcquaintances();

        casualAcquaintances.setName(args[0]);
        casualAcquaintances.setMobileNo(args[1]);
        casualAcquaintances.setEmail(args[2]);
        casualAcquaintances.setWhenWhere(args[3]);
        casualAcquaintances.setCircumstances(args[4]);
        casualAcquaintances.setOtherInfo(args[5]);

        return casualAcquaintances;
    }

    private Acquaintances professionalFriendsContact(String[] args) {
        ProfessionalFriends professionalFriends = new ProfessionalFriends();

        professionalFriends.setName(args[0]);
        professionalFriends.setMobileNo(args[1]);
        professionalFriends.setEmail(args[2]);
        professionalFriends.setCommonInterests(args[3]);

        return professionalFriends;
    }

    private Acquaintances relativesContact(String[] args) {
        Relatives relatives = new Relatives();

        relatives.setName(args[0]);
        relatives.setMobileNo(args[1]);
        relatives.setEmail(args[2]);
        relatives.setBDate(args[3]);
        relatives.setLDate(args[4]);
        return relatives;
    }

    private Acquaintances personalFriendsContact(String[] args) {
        PersonalFriends personalFriends = new PersonalFriends();

        personalFriends.setName(args[0]);
        personalFriends.setMobileNo(args[1]);
        personalFriends.setEmail(args[2]);
        personalFriends.setEvents(args[3]);
        personalFriends.setAContext(args[4]);
        personalFriends.setADate(args[5]);
        return personalFriends;
    }
}
