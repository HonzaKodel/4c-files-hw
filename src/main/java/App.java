

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.stream.IntStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static java.lang.Integer.parseInt;

public class App {
    private static int pocatecniCena = 0;
    private static int pocetProduktu = 0;
    @SuppressWarnings("unchecked")


    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("C:\\Users\\Honza\\IdeaProjects\\4c-files-hw\\src\\main\\resources\\kasa-items.json")) {

            Object jsonObject = parser.parse(reader);

            JSONArray productList = (JSONArray) jsonObject;
            // System.out.println(productList);

            productList.forEach(emp -> parseDiscountedObjects((JSONObject) emp));
            productList.forEach(emp -> parseCelkovaCenaObjects((JSONObject) emp));
            productList.forEach(emp -> parsePriceDifference((JSONObject) emp));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    private static void parseDiscountedObjects(JSONObject product) {
        JSONObject productObject = product;

        Boolean discount = (Boolean) productObject.get("discounted");


        String name = (String) productObject.get("itemName");


        if (discount == true) {
            System.out.println(name);
            int pocet =  pocetProduktu++;
            System.out.println(pocet+1);
        }
    }


    private static void parseCelkovaCenaObjects(JSONObject product) {
        JSONObject productObject = product;

        //  String price = (String) productObject.get("currentPrice");
        //  Integer currentPrice = Integer.parseInt(price);

        Integer currentPrice = (Integer) productObject.get("currentPrice");

        int result = pocatecniCena + currentPrice;
        pocatecniCena = result;

        System.out.println("Celková cena produktů je: " +  result + " Kč. ");


    }


    private static void parsePriceDifference(JSONObject product) {
        JSONObject productObject = product;

        String price2 = (String) productObject.get("originalPrice");
        Integer originalPrice = Integer.parseInt(price2);

        String price = (String) productObject.get("currentPrice");
        Integer currentPrice = Integer.parseInt(price);

        String name = (String) productObject.get("itemName");

        if (originalPrice != null) {
            int rozdil = originalPrice - currentPrice;
        }

    }

    private static void categoryTree(JSONObject product){
        JSONObject productObject = product;

        String name = (String) productObject.get("itemName");

        String kategorie = (String) productObject.get("category");
    }
}



