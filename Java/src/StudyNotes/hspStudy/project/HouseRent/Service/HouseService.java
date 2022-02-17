package StudyNotes.hspStudy.project.HouseRent.Service;

import StudyNotes.hspStudy.project.HouseRent.domain.House;

public class HouseService {

    //House[]对象来保存House对象
    private House[] houses;

    public HouseService( int size){
        houses = new House[size];
        houses[0] = new House(1,"wyw","159","qy",3000,"未出租");
    }

    public House[] list(){
        return houses;
    }

    public boolean add(House newHouse){
        return false;
    }
}
