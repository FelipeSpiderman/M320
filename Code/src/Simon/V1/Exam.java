package Simon.V1;

class Exam implements Gradable {
    String subject; int grade;
    Exam(String s, int g){ subject=s; grade=g; }
    public int getGrade(){ return grade; }
    public String toString(){ return subject + ": " + grade; }
}
