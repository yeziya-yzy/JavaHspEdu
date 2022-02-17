package StudyNotes.hspStudy.innerClass;

public class innnerClassExercise {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("起床了");
            }
        });
        cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("上课了");
            }
        });
    }
}

interface Bell{
    void ring();
}

class Cellphone{
    public void alarmClock(Bell bell){
        bell.ring();
    }
}