import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class KasaProcessor {

    public void loadItems() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("kasa-items.json").getFile());

        ObjectMapper objectMapper = new ObjectMapper();
        try (Reader reader = new FileReader(file)) {
//             TODO: Je nutné vytvořit objekt KasaItem s platnými vlastnostmi
//            KasaItem[] items = objectMapper.readValue(reader, KasaItem[].class);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
