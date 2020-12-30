package contactmanagementsoftware.entity;

public class Contact {
    private String name;
    private String email;
    private String mobileNo;

    private String commonInterests;

    private String ADate;
    private String events;
    private String AContext;

    private String LDate;
    private String BDate;

    private String circumstances;
    private String otherInfo;
    private String whenWhere;

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCommonInterests() {
        return commonInterests;
    }

    public void setCommonInterests(String commonInterests) {
        this.commonInterests = commonInterests;
    }

    public String getADate() {
        return ADate;
    }

    public void setADate(String ADate) {
        this.ADate = ADate;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public String getAContext() {
        return AContext;
    }

    public void setAContext(String AContext) {
        this.AContext = AContext;
    }

    public String getLDate() {
        return LDate;
    }

    public void setLDate(String LDate) {
        this.LDate = LDate;
    }

    public String getBDate() {
        return BDate;
    }

    public void setBDate(String BDate) {
        this.BDate = BDate;
    }

    public String getCircumstances() {
        return circumstances;
    }

    public void setCircumstances(String circumstances) {
        this.circumstances = circumstances;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getWhenWhere() {
        return whenWhere;
    }

    public void setWhenWhere(String whenWhere) {
        this.whenWhere = whenWhere;
    }
}
