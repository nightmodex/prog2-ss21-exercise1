import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Result {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        if(grades == null){
            throw new IllegalArgumentException();
        }
        if(containsNullElements(grades)){
            throw new IllegalArgumentException();
        }
        List<Integer> output = new ArrayList<>();
        if(checkRange(grades.get(0))) {
            for (int i = 1; i < grades.size(); i++) {
                int roundedGrade = roundToNextMultipleOfFive(grades.get(i));
                output.add(roundedGrade);
            }
        }
        return output;
    }

    protected static int roundToNextMultipleOfFive(Integer grade){
        if(grade>=38){
            grade = (grade%5>=3 ? (grade/5)*5+5 : grade);
        }
        return grade;
    }

    protected static boolean checkRange(Integer value){
       return value < 60 && value > 0;
    }

    protected static boolean containsNullElements(List<Integer> grades){
        return grades.contains(null);
    }
}