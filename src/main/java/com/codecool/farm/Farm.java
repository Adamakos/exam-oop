package com.codecool.farm;

import com.codecool.farm.animal.Animal;
import com.codecool.farm.animal.Cattle;

import java.util.ArrayList;
import java.util.List;

class Farm {

    private final List<Animal> animals;

    public Farm(List<Animal> animals) {
        this.animals = animals;
    }

    public void feedAnimals() {
        animals.forEach(Animal::feed);
    }

    public void butcher(Butcher butcher) {
        this.animals.removeIf(butcher::canButcher);
    }

    public boolean isEmpty() {
        return this.animals.isEmpty();
    }

    public List<String> getStatus() {
        List<String> statusList = new ArrayList<>();
        String type;
        for (Animal animal : this.animals) {
            if (animal instanceof Cattle) type = "cattle";
            else type = "pig";
            statusList.add("There is a " + animal.getSize() + " sized " + type + " in the farm.");
        }
        return statusList;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

}
