package app.models;

public class Shift {
    private Long id = null;
    private String title =  null;
    private String staff_name = null;
    private String detail =  null;
    private String status =  null;
    private String created_time =  null;
    private String finish_time =  null;
    private String due_time =  null;

    public Shift(){

    }

    public Shift(Long id, String title, String staff_name, String detail, String status, String created_time, String finish_time, String due_time) {
        this.id = id;
        this.title = title;
        this.staff_name = staff_name;
        this.detail = detail;
        this.status = status;
        this.created_time = created_time;
        this.finish_time = finish_time;
        this.due_time = due_time;
    }


    public Shift(String title, String staff_name, String detail, String status, String created_time, String finish_time, String due_time) {
        this.title = title;
        this.staff_name = staff_name;
        this.detail = detail;
        this.status = status;
        this.created_time = created_time;
        this.finish_time = finish_time;
        this.due_time = due_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(String finish_time) {
        this.finish_time = finish_time;
    }

    public String getDue_time() {
        return due_time;
    }

    public void setDue_time(String due_time) {
        this.due_time = due_time;
    }


    @Override
    public String toString() {
        return "Shift{" +
                "id=" + id +
                ", title=" + title + '\'' +
                ", staff_name=" + staff_name + '\'' +
                ", detail=" + detail + '\'' +
                ", status=" + status + '\'' +
                ", created_time=" + created_time + '\'' +
                ", finish_time=" + finish_time + '\'' +
                ", due_time=" + due_time +
                '}';
    }
}

