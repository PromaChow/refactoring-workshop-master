package workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlaintextToHtmlConverter {


    public String toHtml() throws Exception {
        String text = read();
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    protected String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get("sample.txt")));
    }

    private HashMap initializeHashMap(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("<", "&lt;");
        map.put(">", "&gt;");
        map.put("&", "&amp;");
        map.put("\n", )
    }

    private String basicHtmlEncode(String source) {
        int i = 0;
        List<String> result = new ArrayList<>();
        List<String> convertedLine = new ArrayList<>();
        String characterToConvert = stashNextCharacterAndAdvanceThePointer(source);

        while (i <= source.length()) {
            switch (characterToConvert) {
                case "<":
                    convertedLine.add("&lt;");
                    break;
                case ">":
                    convertedLine.add("&gt;");
                    break;
                case "&":
                    convertedLine.add("&amp;");
                    break;
                case "\n":
                    addANewLine(result,convertedLine);
                    break;
                default:
                    pushACharacterToTheOutput(convertedLine);
            }

            characterToConvert = stashNextCharacterAndAdvanceThePointer(source);
        }
        addANewLine(result,convertedLine);
        String finalResult = String.join("<br />", result);
        return finalResult;
    }

    //pick the character from source string
    //and increment the pointer
    private String stashNextCharacterAndAdvanceThePointer(String source) {
        char c = source.charAt(i);
        i += 1;
        return String.valueOf(c);
    }

    //stringfy convertedLine array and push into result
    //reset convertedLine
    private void addANewLine(List<String>result, List<String>convertedLine) {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine = new ArrayList<>();
    }

    private void pushACharacterToTheOutput(List<String>convertedLine) {convertedLine.add(characterToConvert);
    }
}
