import java.util.Arrays;

public class Solution {

    /**
    Converts dash/underscore delimited words into camel casing. The first word within the output is capitalized only if the original word was capitalized
     **/
    static String toCamelCase(String string) {

        String[] stringsArray = string.split("[-_]");
        StringBuilder camelCaseString = new StringBuilder(stringsArray[0]);
        for (int i = 1; i < stringsArray.length; i++) {
            if(stringsArray[i].equals("")){
                i++;
            }
            camelCaseString.append(stringsArray[i].substring(0, 1).toUpperCase())
                    .append(stringsArray[i].substring(1));
        }

        return camelCaseString.toString();
    }
}
