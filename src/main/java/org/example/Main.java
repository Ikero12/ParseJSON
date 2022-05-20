package org.example;
import org.json.JSONArray;
import org.json.JSONObject;
public class Main {
    public static void main(String[] args) {

        final String json = "{\n" +
                "    \"pageInfo\": {\n" +
                "            \"pageName\": \"Homepage\",\n" +
                "            \"logo\": \"https://www.example.com/logo.jpg\"\n" +
                "    },\n" +
                "    \"posts\": [\n" +
                "            {\n" +
                "                \"post_id\": \"0123456789\",\n" +
                "                \"actor_id\": \"1001\",\n" +
                "                \"author_name\": \"Jane Doe\",\n" +
                "                \"post_title\": \"How to parse JSON in Java\",\n" +
                "                \"comments\": [\"HOLA\",\"lol\"],\n" +
                "                \"time_of_post\": \"1234567890\"\n" +
                "            }\n" +
                "    ]\n" +
                "}";

                JSONObject obj = new JSONObject(json);
                String pageName = obj.getJSONObject("pageInfo").getString("pageName");

                System.out.println(pageName);

                JSONArray arr = obj.getJSONArray("posts");
               JSONArray comm = arr.getJSONObject(0).getJSONArray("comments");
                for (int i = 0; i < arr.length(); i++) {
                    String postid = arr.getJSONObject(i).getString("post_id");

                    for(int y=0;y<comm.length();y++){
                    //String comm = arr.getJSONObject(0).getJSONArray("comments").getString(y);
                        System.out.println(postid +" "+ comm.getString(y));
                    }
                }


    }}
