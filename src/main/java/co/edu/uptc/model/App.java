package co.edu.uptc.model;

import co.edu.uptc.model.data.City;
import co.edu.uptc.model.init.OnInit;
import co.edu.uptc.model.modules.SortModule;
import co.edu.uptc.model.structure.SimpleLinkedList;

public class App {
    private OnInit onInit = new OnInit();
    private SortModule sortModule = new SortModule();

    public SimpleLinkedList<City> init(SimpleLinkedList<City> sample) {
        return onInit.launch(sample);
    }

    public SimpleLinkedList<String> sortByDepartment(SimpleLinkedList<City> cities) {
        return sortModule.sortByDepartment(cities);
    }

    public SimpleLinkedList<City> sortCities(SimpleLinkedList<City> cities) {
        return sortModule.sortCities(cities);
    }
}
