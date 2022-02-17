package StudyNotes.hspStudy.encap;

public class AccountTest {
    public static void main(String[] args) {
        Acount acount2 = new Acount("qll",100000,"wywwywwyw");
        Acount acount = new Acount();
        acount.setName("wyw");
        acount.setPassword("qllqllqll");
        acount.setBalance(123000);
        acount.info();
        acount2.info();
    }
}
