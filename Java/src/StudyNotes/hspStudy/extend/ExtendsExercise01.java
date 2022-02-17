package StudyNotes.hspStudy.extend;

public class ExtendsExercise01 {
    public static void main(String[] args) {
        PC pc = new PC("i510400h","16","STAT","LEGION");
        NotePad notePad = new NotePad("875","6","128","黑");
        System.out.println("======pc======");
        pc.printinfo();
        System.out.println("======notePad======");
        notePad.printDetails();
    }
}

class computer {
    private String CPU;
    private String Memory;
    private String HardDisk;

    public computer(String CPU, String Memory, String HardDisk) {
        this.CPU = CPU;
        this.Memory = Memory;
        this.HardDisk = HardDisk;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getMemory() {
        return Memory;
    }

    public void setMemory(String memory) {
        Memory = memory;
    }

    public String getHardDisk() {
        return HardDisk;
    }

    public void setHardDisk(String hardDisk) {
        HardDisk = hardDisk;
    }

    public String getDetails() {
        return "CPU:" + CPU + "  Memory:" + Memory + "  HardDisk:" + HardDisk;
    }
}

class PC extends computer {
    private String brand;
    public PC(String CPU, String Memory, String HardDisk, String brand) {
        super(CPU, Memory, HardDisk);
        this.brand = brand;
    }
    public void printinfo(){
        System.out.println(getDetails() +"  brand:" + brand);
    }
}

class NotePad extends computer {
    private String color;

    public NotePad(String CPU, String Memory, String HardDisk, String color) {
        super(CPU, Memory, HardDisk);
        this.color = color;
    }

    public void printDetails(){
        System.out.println(getDetails()+ "  color:" + color);
    }
}