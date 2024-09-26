package co.edu.uptc.presenter;

import co.edu.uptc.model.App;
import co.edu.uptc.model.data.City;
import co.edu.uptc.model.structure.SimpleLinkedList;
import co.edu.uptc.view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static App app = new App();
    static SimpleLinkedList<City> globaLinkedList = new SimpleLinkedList<>();
    static MainFrame mainFrame; // Declare mainFrame as static

    public static void main(String[] args) {
        globaLinkedList = app.init(globaLinkedList);

        // Initialize mainFrame
        mainFrame = new MainFrame(new ShowDepartmentsAction(), new ShowMunicipalitiesAction());
        mainFrame.setVisible(true);
    }

    static class ShowDepartmentsAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get sorted department list
            SimpleLinkedList<String> sortedDepartments = app.sortByDepartment(globaLinkedList);
            // Display the departments in the view
            mainFrame.displayDepartments(sortedDepartments);
        }
    }

    static class ShowMunicipalitiesAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get municipality list
            SimpleLinkedList<City> cities = app.sortCities(globaLinkedList);

            SimpleLinkedList<String> stringCities = new SimpleLinkedList<>();
            for (City city : cities) {
                stringCities.add(city.toString());
            }
            // Display the municipalities in the view
            mainFrame.displayMunicipalities(stringCities);
        }
    }
}
