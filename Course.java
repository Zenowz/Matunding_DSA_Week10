public class Course {

    private String code;
    private String description;

    public Course(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public Course() {
    }

    public void setCourse(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String showCourseInfo() {
        return "Code\t: " + code + "\nDescription\t: " + description;
    }

    public String getCourse() {
        return "Code\t: " + code + "\nDescription\t: " + description;
    }

    public void viewCourseInfo() {
        System.out.println("Code\t: " + code);
        System.out.println("Description\t: " + description);
    }
}
