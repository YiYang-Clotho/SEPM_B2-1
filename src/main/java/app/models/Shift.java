package app.models;

public class Shift {
    private Long id = null;
    private String staff = null;
    private String start_time = null;
    private String end_time = null;
    private String position = null;
    private String day = null;
    private String date = null;

    public Shift(){

    }

    public  Shift(String date, String day, String start_time, String end_time, String staff, String position){
        this.date = date;
        this.day = day;
        this.start_time = start_time;
        this.end_time = end_time;
        this.staff = staff;
        this.position = position;
    }

    public Long getID(){
        return this.id;
    }
    public void setID(Long id){
        this.id = id;
    }

    public String getDate(){
        return this.date;
    }
    public void setDate(String date){
        this.date = date;
    }

    public String getDay(){
        return this.day;
    }
    public void setDay(String day){
        this.day = day;
    }

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

    public String getStaff(){
        return this.staff;
    }
    public void setStaff(String staff){
        this.staff = staff;
    }

    public String getPosition(){
        return this.position;
    }
    public void setPosition(String position){
        this.position = position;
    }



}

