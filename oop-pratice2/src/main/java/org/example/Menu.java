package org.example;

import java.util.List;
import java.util.Objects;

public class Menu {
    private List<MenuItem> menuItems;
    public Menu(List<MenuItem> MenuItems) {
        this.menuItems = MenuItems;

    }

    public MenuItem choose(String name) {
        return this.menuItems.stream()
                .filter(menuItem -> menuItem.matches(name))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("잘못된메뉴"));

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(menuItems, menu.menuItems);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(menuItems);
    }
}
