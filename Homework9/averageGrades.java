/**
 * Junghoo Kim (Andy)
 * part 4
 * 
 */
public class averageGrades {
    private int student = 5000;
    private int classes = 6;

    private int[][] grades = new int [student][classes];

    public void printAvgs () {
        for (int student = 0; student < 5000; student++) {
            int sum = 0;
            int avg = 0;
            classes = 6;
            for (int i = 0; i < classes; i++) {
                sum += grades[student][i];
                if(grades[student][i] == 0){    //if they didn't take 6 classes
                    classes--;                  
                }
            }
            avg = sum / classes;
            System.out.println ("The average grade for student " + student + " is a " + avg + " GPA.");
        }
    }
}