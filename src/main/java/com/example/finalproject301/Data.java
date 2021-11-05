package com.example.finalproject301;

public class Data {
    String lastname;
    String firstname;
    String age1;
    String birth;
    String addr;
    String contact;
    String idnum1;
    String category1;
    String codee;

    public Data(String lastname, String firstname, String age1, String birth, String addr, String contact, String idnum1, String category1,String codee) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.age1 = age1;
        this.birth = birth;
        this.addr = addr;
        this.contact = contact;
        this.idnum1 = idnum1;
        this.category1 = category1;
        this.codee = codee;
    }

    public String getLname() {
        return lastname;
    }

    public String getFname() {
        return firstname;
    }

    public String getAge1() {
        return age1;
    }

    public String getBirth() {
        return birth;
    }

    public String getAddr() {
        return addr;
    }

    public String getContact() { return contact;
    }

    public String getIdnum1() {
        return idnum1;
    }

    public String getCategory1() {
        return category1;
    }

    public String getcodee() {
        return codee;
    }
}
