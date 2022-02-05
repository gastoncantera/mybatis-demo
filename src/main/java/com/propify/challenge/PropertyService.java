package com.propify.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PropertyService {

    PropertyMapper propertyMapper;

    AddressMapper addressMapper;

    AlertService alertService;

    @Autowired
    public PropertyService(PropertyMapper propertyMapper, AddressMapper addressMapper, AlertService alertService) {
        this.propertyMapper = propertyMapper;
        this.addressMapper = addressMapper;
        this.alertService = alertService;
    }

    public Collection<Property> search(String minRentPrice, String maxRentPrice) {
        return propertyMapper.search(minRentPrice, maxRentPrice);
    }

    public Property findById(int id) {
        return propertyMapper.findById(id);
    }

    public void insert(Property property) {
        propertyMapper.insert(property);
        System.out.println("CREATED: " + property.id);
    }

    public void update(Property property) {
        propertyMapper.update(property);
        System.out.println("UPDATED: " + property.id);
    }

    public void delete(int id) {
        propertyMapper.delete(id);
        System.out.println("DELETED: " + id);

        alertService.sendPropertyDeletedAlert(id);
        // TODO: Sending the alert should be non-blocking (asynchronous)
        //  Extra points for only sending the alert when/if the transaction is committed
    }

    public PropertyReport propertyReport() {
        var allProperties = propertyMapper.search(null, null);
        var propertyReport = new PropertyReport();

        // Calculate total quantity
        propertyReport.totalQuantity = allProperties.size();

        // Calculate the quantity of each type, 0 if there is no properties.
        propertyReport.quantityPerType = allProperties.stream()
                .map(p -> p.type)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        // Calculate the average rent price (exclude the properties without rent price or with rent price = 0)
        propertyReport.averageRentPrice = allProperties.stream()
                .filter(p -> p.rentPrice != 0)
                .mapToDouble(p -> p.rentPrice)
                .average()
                .orElse(0.0);

        // Calculate the quantity of properties in the state of Illinois (IL)
        propertyReport.illinoisQuantity = (int) allProperties.stream()
                .filter(p -> p.address.state.equals("IL"))
                .count();

        return propertyReport;
    }
}
