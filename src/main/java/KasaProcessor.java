import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;

public class KasaProcessor {

    private KasaItem[] kasaItems;

    public KasaProcessor() {
        loadItems();
    }

    private void loadItems() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("kasa-items.json").getFile());

        ObjectMapper objectMapper = new ObjectMapper();
        try (Reader reader = new FileReader(file)) {
//             TODO: Je nutné vytvořit objekt KasaItem s platnými vlastnostmi
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            kasaItems = mapper.readValue(reader, KasaItem[].class);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int countAllItems() {
        return kasaItems.length;
    }

    public int sumAllOriginalPrices() {
        final int sum = Arrays.stream(kasaItems)
                .filter(item -> item.getOriginalPrice() != null)
                .mapToInt(KasaItem::getOriginalPrice).sum();
        return sum;
    }

    public void printAllDiscountedItems() {
        Arrays.stream(kasaItems)
                .filter(item -> Boolean.TRUE.equals(item.isDiscounted()))
                .forEach(KasaItem::printInfo);
    }


//    public int OriginalCurrentDifference() {
//        Arrays.stream(kasaItems)
//                .filter(item -> item.getOriginalPrice() != null)
//                .filter(item -> item.getCurrentPrice() != null && item.getOriginalPrice() >= item.getCurrentPrice())
//                .max(Comparator.comparing())
//                .mapToInt(KasaItem::getCurrentPrice && KasaItem::getOriginalPrice)
//
//    }

    public void createCategoryTree() {

        Map<String, Object> categoryTree = new HashMap<>();
        int count = 0;
        for (KasaItem item : kasaItems) {
            String[] categories = item.getCategory().split(">");
            Map<String, Object> temp = categoryTree;
            for (int i = 1; i < categories.length; i++) {
                String category = categories[i];
                if (categoryTree.containsKey(category)){
                    temp = (Map<String, Object>) categoryTree.get(category);
                }else{
                    temp.put(category, new HashMap<String, Object>());
                    temp = (Map<String, Object>) temp.get(category);
                }
                count ++;

            }
        }
    }

}
