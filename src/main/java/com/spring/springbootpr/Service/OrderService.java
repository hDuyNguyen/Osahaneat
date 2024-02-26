package com.spring.springbootpr.Service;
import com.spring.springbootpr.Entity.*;
import com.spring.springbootpr.Entity.Key.KeyOrderItem;
import com.spring.springbootpr.Payload.Request.OrderRequest;
import com.spring.springbootpr.Repository.OrderItemRepository;
import com.spring.springbootpr.Repository.OrderRepository;
import com.spring.springbootpr.Service.imp.OrderServiceImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService implements OrderServiceImp {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public boolean insertOrder(OrderRequest orderRequest) {

        try {
            Users users = new Users();
            users.setId(orderRequest.getUserId());

            Restaurant restaurant = new Restaurant();
            restaurant.setId(orderRequest.getResId());
            Orders orders = new Orders();


            orders.setUsers(users);
            orders.setRestaurant(restaurant);

            orderRepository.save(orders);

            List<OrderItem> items = new ArrayList<>();
            for (int idFood: orderRequest.getFoodIds()) {
                Food food = new Food();
                food.setId(idFood);

                OrderItem orderItem = new OrderItem();
                KeyOrderItem keyOrderItem = new KeyOrderItem(orders.getId(), idFood);
                orderItem.setKeys(keyOrderItem);

                items.add(orderItem);
            }

            orderItemRepository.saveAll(items);

            return true;
        } catch (Exception e) {
            System.out.println("Error insert order" + e.getMessage());
            return false;
        }
    }
}
