package StudyNotes.hspStudy.encap;


public class Acount {
    private String name;
    private double balance;
    private String password;

    public Acount() {

    }

    public Acount(String name, double balance, String password) {
        setName(name);
        setBalance(balance);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 5 && name.length() > 1) {
            this.name = name;
        }else {
            System.out.println("名字要在(2到4)字符默认为XXX");
            this.name = "XXX";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 20) {
            this.balance = balance;
        } else {
            System.out.println("余额要>20,默认为0");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() >= 6) {
            this.password = password;
        } else{
            System.out.println("密码长度不够,默认值为123456");
            this.password = "123456";
        }
    }

    public void info(){
        System.out.println("name:" + name + "\t" + "balance:" + balance + "\t" + "password:" + password);
    }
}
