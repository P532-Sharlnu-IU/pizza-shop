package edu.iu.habahram.pizzashop.repository;

import edu.iu.habahram.pizzashop.model.ChicagoPizzaStore;
import edu.iu.habahram.pizzashop.model.OrderData;
import edu.iu.habahram.pizzashop.model.Pizza;
import edu.iu.habahram.pizzashop.model.PizzaStore;
import org.springframework.stereotype.Repository;
import edu.iu.habahram.pizzashop.model.NewYorkPizzaStore;

@Repository
public class TextFilePizzaRepository implements PizzaRepository{
    @Override
    public String prepareTheOrder(OrderData orderData) {
        PizzaStore pizzaStore = null;
        if(orderData.store().equalsIgnoreCase("chicago")) {
            pizzaStore = new ChicagoPizzaStore();
        }
        else if(orderData.store().equalsIgnoreCase("new york")){
            pizzaStore = new NewYorkPizzaStore();
        }
        Pizza pizza = pizzaStore.orderPizza(orderData.item());
        return pizza.toString();
    }
}
