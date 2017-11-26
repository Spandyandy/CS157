public class ClassNotes {
    public static void main(String[] args){
    String digits = "-36";    
    int mult = 1;
    int result =0, index, value;
    index = digits.length()-1;
    while (index >= 0){
        char ch = digits.charAt(index);
        value = ch - '0';
        result += value * mult;
        mult = mult *10;
        index--;
    }
    System.out.println(result);
}
}
