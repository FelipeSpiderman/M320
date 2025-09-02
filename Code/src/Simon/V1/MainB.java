package Simon.V1;
import java.util.*;

public class MainB {
    public static void main(String[] args){
        List<Gradable> exams = new ArrayList<>();
        exams.add(new Exam("Mathe",5));
        exams.add(new Exam("Deutsch",4));
        exams.add(new Exam("Informatik",6));

        for(Gradable g : exams) System.out.println(g);
    }
}
