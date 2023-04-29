package jsonparser.Tester;

import jsonparser.data.JSON;
import jsonparser.parser.JsonParser;
import jsonparser.parser.NaiveJsonParser;
import jsonparser.tokenizer.NaiveTokenizer;

public class tester {
    public static void main(String[] args) {
        JsonParser parser = new NaiveJsonParser(new NaiveTokenizer());
        String jsonText = "{" +
                "\"name\":\"Shreyash\"," +
                "\"age\":\"26\",".....;
                ////.....
        JSON json = parser.parse(jsonText);
        System.out.println(parser.toString(json.get("report-cards").get("sem-1").get("cgpa")));

    }
}
