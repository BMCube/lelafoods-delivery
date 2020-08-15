package edu.miu.lelafoods.delivery.dto;

import edu.miu.lelafoods.delivery.domain.Address;

import java.util.List;

public class Restaurant {

        private Long id;

        private String name;

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addresses=" + addresses +
                ", foods=" + foods +
                '}';
    }

    List<Address> addresses;

        List<Food> foods;

        public Restaurant() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Address> getAddresses() {
            return addresses;
        }

        public void setAddresses(List<Address> addresses) {
            this.addresses = addresses;
        }

        public List<Food> getFoods() {
            return foods;
        }

        public void setFoods(List<Food> foods) {
            this.foods = foods;
        }
}
