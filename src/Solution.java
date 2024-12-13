import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String string = bf.readLine();
            System.out.println(textModifier(string));
        }

        public static String textModifier(String s) {
            String[] string = s.split("\\s+");
            StringBuilder stringSpace = new StringBuilder();
            for (String strings : string) {
                stringSpace.append(strings).append(" ");
            }

            int i_1 = 0;
            while (i_1 < stringSpace.length()) {
                if (stringSpace.charAt(i_1) == '-' && i_1 + 1 < stringSpace.length()) {
                    char right = stringSpace.charAt(i_1 + 1);
                    char left = stringSpace.charAt(i_1 - 1);
                    stringSpace.setCharAt(i_1 - 1, right);
                    stringSpace
                            .setCharAt(i_1 + 1, left);
                    stringSpace.deleteCharAt(i_1);
                } else {
                    i_1++;
                }
            }

            for (int j = 0; j < stringSpace.length(); j++) {

                if (stringSpace.charAt(j) == '+') {
                    stringSpace.setCharAt(j, '!');
                }
            }

            int num = 0;
            int i_2 = 0;

            while (i_2 < stringSpace.length()) {
                char c = stringSpace.charAt(i_2);
                if (Character.isDigit(c)) {
                    num += Character.getNumericValue(c);
                    stringSpace.deleteCharAt(i_2);
                } else {
                    i_2++;
                }
            }

            if (num > 0) {
                stringSpace.append(num);
            }

            return stringSpace.toString();

        }
    }


