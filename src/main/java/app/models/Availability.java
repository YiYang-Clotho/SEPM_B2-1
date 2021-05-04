package app.models;

public class Availability {

    private Long id = null;
    private String start_time = null;
    private String end_time = null;
    private String staff_name = null;

    public Availability(){}

    public Availability(String start_time, String end_time, String staff_name){
        this.start_time = start_time;
        this.end_time = end_time;
        this.staff_name = staff_name;
    }
    public Long getID(){ return this.id; }
    public void setID(Long id){
        this.id = id;
    }

//    public String getDate(){
//        return this.date;
//    }
//    public void setDate(String date){
//        this.date = date;
//    }
//
//    public String getDay(){
//        return this.day;
//    }
//    public void setDay(String day){
//        this.day = day;
//    }

    public String getStart_time(){
        return this.start_time;
    }
    public void setStart_time(String start_time){
        this.start_time = start_time;
    }

    public String getEnd_time(){
        return this.end_time;
    }
    public void setEnd_time(String end_time){
        this.end_time = end_time;
    }

    public String getStaff_name(){
        return this.staff_name;
    }
    public void setStaff_name(String staff_name){ this.staff_name = staff_name;}

}
