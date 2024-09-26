package co.edu.uptc.model.init;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.uptc.model.data.City;
import co.edu.uptc.model.structure.SimpleLinkedList;

public class OnInit {
    ObjectMapper objectMapper = new ObjectMapper();
    ApiConsumer apiConsumer = new ApiConsumer();

        public SimpleLinkedList<City> launch(SimpleLinkedList<City> sample) {
        try {
            String data = apiConsumer.getData();
            City[] municipios = objectMapper.readValue(data, City[].class);

            for (City municipio : municipios) {
                sample.add(municipio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sample;
    }
}
