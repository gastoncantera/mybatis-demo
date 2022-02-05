package com.propify.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    // API endpoints for CRUD operations on entities of type Property

    @GetMapping("/search")
    public Collection<Property> search(@RequestParam(required = false) String minRentPrice, @RequestParam(required = false) String maxRentPrice) {
        return propertyService.search(minRentPrice, maxRentPrice);
    }

    @GetMapping("/find/{id}")
    public Property findById(@PathVariable int id) {
        return propertyService.findById(id);
    }

    public void insert(Property property) {
        // TODO: Property attributes must be validated
        propertyService.insert(property);
    }

    public void update(Property property) {
        // TODO: Property attributes must be validated
        propertyService.update(property);
    }

    public void delete(int id) {
        propertyService.delete(id);
    }

    @GetMapping("/report")
    public PropertyReport report() {
        return propertyService.propertyReport();
    }
}
