import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        String link = "https://www.bbc.com/";
        List<String> urlList = Arrays.asList(
                "https://www.bbc.com/",
                "https://www.bbc.com/",
                "https://www.bbc.com/");
        String result = getWebContent(link);
    }

    private static String getWebContent(String link) throws IOException {
        URL url = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String encoding = connection.getContentEncoding();

        InputStream inputStream = connection.getInputStream();
        Stream<String> lines = new BufferedReader(new InputStreamReader(inputStream))
                .lines();
        return lines.collect(Collectors.joining());
    }


}
