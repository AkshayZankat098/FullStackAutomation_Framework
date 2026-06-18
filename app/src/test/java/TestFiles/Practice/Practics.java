package TestFiles.Practice;

public class Practics {

    public static void main(String[] args) {

        String str = "Akshay";

        String reverse = "";

        System.out.println(str.length());

        for (int i = str.length(); i > 0; i--) {
            reverse = reverse + str.charAt(i - 1);
        }
        System.out.println(reverse);


        StringBuilder sb = new StringBuilder(str);
        String reversed01 = sb.reverse().toString();
        System.out.println(reversed01);
    }

}
