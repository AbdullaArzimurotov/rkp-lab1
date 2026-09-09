package ru.kafpin.laboratoriya;

public class Student {
    private long id;
    private String surname;
    private String name;
    private String patronymic;
    private String email;
    private int enrollmentYear;

    private String groupName;
    private String login;

    public Student() {}

    public long getId() { return id; }
    public void setId(long id) {
        this.id = id;
        generateLogin();
    }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPatronymic() { return patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getEnrollmentYear() { return enrollmentYear; }
    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
        String yearStr = String.valueOf(enrollmentYear);
        if (yearStr.length() >= 2) {
            this.groupName = "ПИН-1" + yearStr.substring(yearStr.length() - 2);
        }
        generateLogin();
    }

    public String getGroupName() { return groupName; }
    public String getLogin() { return login; }

    private void generateLogin() {
        if (this.groupName != null && this.id > 0) {
            String formattedGroup = this.groupName.toLowerCase().replace("пин-", "pin");
            this.login = "student-" + formattedGroup + "-" + this.id;
        }
    }
}