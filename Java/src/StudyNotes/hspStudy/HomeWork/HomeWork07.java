package StudyNotes.hspStudy.HomeWork;

/**
 * coding: utf-8
 * @version 1.0
 */
public class HomeWork07 {
    public static void main(String[] args) {
        Color red = Color.RED;
        red.show();
        switch (red){
            case RED:
                System.out.println("RED");
                break;
            case BLUE:
                System.out.println("BLUE");
                break;
            case YELLOW:
                System.out.println("YELLOW");
                break; 
        }
    }
}

interface ColorInterface {
    public void show();
}

enum  Color implements ColorInterface {

    RED(255,0,0),BLUE(0,0,255),
    YELLOW(255,255,0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    private Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println(redValue+blueValue+greenValue);
    }
}
