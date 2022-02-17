package StudyNotes.hspStudy.project.HouseRent.domain;

/**
 * 一个House对象表示一个房源信息
 */
public class House {
    //属性
    //编号,房主,电话,地址,月租,状态(未出租\已出租)
    private int id;
    private String name;
    private String phone;
    private String address;
    private int rent;
    private String stata;

    public House(int id, String name, String phone, String address, int rent, String stata) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.stata = stata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getStata() {
        return stata;
    }

    public void setStata(String stata) {
        this.stata = stata;
    }

    //为了方便的输出对象信息,我们改写toString
    @Override
    public String toString() {
        return   id  +
                "\t\t" + name +
                "\t\t" + phone  +
                "\t\t" + address  +
                "\t\t" + rent +
                "\t\t" + stata ;
    }
}
