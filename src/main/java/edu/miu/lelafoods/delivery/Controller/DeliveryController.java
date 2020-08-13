package edu.miu.lelafoods.delivery.Controller;

import edu.miu.lelafoods.delivery.domain.Delivery;
import edu.miu.lelafoods.delivery.service.DeliveryService;
import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;
    @GetMapping({""})
    public List<Delivery> findAll() {
        List<Delivery> foodsList = deliveryService.findall();
        return foodsList;
    }

    @GetMapping("{id}")
    public Delivery findFoodById(@PathVariable("id") Long id) {
        return deliveryService.findById(id);
    }

    @GetMapping("/person/{name}")
    public Delivery getByDeliveryPersonName(@PathVariable("name") String name) {
        return deliveryService.getByDeliveryPersonName(name);
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createDelivery(@RequestBody Delivery delivery) {
        deliveryService.save(delivery);
    }


    @DeleteMapping("/remove/{id}")
    public void deleteById(@PathVariable("id")Long id){
        deliveryService.deleteById(id);
    }
}
