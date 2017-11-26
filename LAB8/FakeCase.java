public class FakeCase
{
    public static String toUpper(String s){
        String result = "";
        int counter = 0;
        int length = s.length();
        while (counter <length){
            char c = s.charAt(counter);
            if(c >= 'a' && c<= 'z'){
                c= (char)(c-32);
            }
            result = result + c;
            counter++;
        }
        return result;
    }
    public static String toLower(String s){
        String result = "";
        int counter = 0;
        int length = s.length();
        while (counter <length){
            char c = s.charAt(counter);
            if(c >= 'A' && c<= 'Z'){
                c= (char)(c+32);
            }
            result = result + c;
            counter++;
        }
        return result;
    }
}