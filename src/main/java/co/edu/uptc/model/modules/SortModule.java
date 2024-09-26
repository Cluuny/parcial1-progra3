package co.edu.uptc.model.modules;

import co.edu.uptc.model.data.City;
import co.edu.uptc.model.structure.SimpleLinkedList;

public class SortModule {
    public SimpleLinkedList<String> sortByDepartment(SimpleLinkedList<City> Citys) {
        SimpleLinkedList<String> departments = new SimpleLinkedList<>();
        for (City City : Citys) {
            if (!departments.contains(City.getDepartamento())) {
                departments.add(City.getDepartamento());
            }
        }
        sortAlphabetic(departments);

        return departments;
    }

    private void sortAlphabetic(SimpleLinkedList<String> list) {
        int n = list.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                String current = list.get(i);
                String next = list.get(i + 1);
                if (current.compareTo(next) > 0) {
                    list.set(i, next);
                    list.set(i + 1, current);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public SimpleLinkedList<City> sortCities(SimpleLinkedList<City> cities) {
        SimpleLinkedList<City> sortedList = new SimpleLinkedList<>();
        SimpleLinkedList<String> uniqueDepartments = new SimpleLinkedList<>();

        for (City city : cities) {
            if (!containsDepartament(uniqueDepartments, city.getDepartamento())) {
                uniqueDepartments.add(city.getDepartamento());
            }
        }

        for (int i = 0; i < uniqueDepartments.size(); i++) {
            for (int j = i + 1; j < uniqueDepartments.size(); j++) {
                if (uniqueDepartments.get(i).compareTo(uniqueDepartments.get(j)) < 0) {
                    String temp = uniqueDepartments.get(i);
                    uniqueDepartments.set(i, uniqueDepartments.get(j));
                    uniqueDepartments.set(j, temp);
                }
            }
        }

        for (int i = 0; i < uniqueDepartments.size(); i++) {
            String departament = uniqueDepartments.get(i);
            SimpleLinkedList<City> tempList = new SimpleLinkedList<>();

            for (City city : cities) {
                if (city.getDepartamento().equals(departament)) {
                    tempList.add(city);
                }
            }

            for (int m = 0; m < tempList.size(); m++) {
                for (int n = m + 1; n < tempList.size(); n++) {
                    if (tempList.get(m).getMunicipio().compareTo(tempList.get(n).getMunicipio()) > 0) {
                        City tempMunicipio = tempList.get(m);
                        tempList.set(m, tempList.get(n));
                        tempList.set(n, tempMunicipio);
                    }
                }
            }

            for (City city : tempList) {
                sortedList.add(city);
            }
        }

        return sortedList;
    }

    private boolean containsDepartament(SimpleLinkedList<String> list, String departament) {
        for (String dept : list) {
            if (dept.equals(departament)) {
                return true;
            }
        }
        return false;
    }
}
