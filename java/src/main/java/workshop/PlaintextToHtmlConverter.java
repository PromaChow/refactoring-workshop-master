package workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PlaintextToHtmlConverter {

    private List<Tags> tagMatchers;
    private NullTagResponse nullTagResponse;

    public String toHtml() throws Exception {
        String text = read();
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    protected String read() throws IOException {
        String fileName = "sample.txt";
        Path filePath = Paths.get(fileName);
        byte[] bytes = Files.readAllBytes(filePath);
        return new String(bytes);

    }



    private String basicHtmlEncode(String source) {
        String result = nullTagResponse.generate();
        char[] chars = source.toCharArray();

        for(char characterToConvert : chars){

            for (Tags tag : tagMatchers) {
                if (tag.matches(characterToConvert)) result+=tag.generate();
                else result+=characterToConvert;
            }

        }
        result+="<br />";
        return result;
    }





}
