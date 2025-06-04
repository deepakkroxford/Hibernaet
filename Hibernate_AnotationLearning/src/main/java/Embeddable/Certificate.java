package Embeddable;

import jakarta.persistence.Embeddable;

@Embeddable
public class Certificate {

    private String courseName;
    private String duration;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
