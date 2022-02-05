package com.propify.challenge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    PropertyMapper propertyMapper;
    @Mock
    AddressMapper addressMapper;
    @Mock
    AlertService alertService;

    @InjectMocks
    PropertyService propertyService;

    // TODO: add at least 3 tests to the method propertyService.propertyReport()
    @Test
    public void testPropertyReport() {
        Mockito.when(propertyMapper.search(null, null)).thenReturn(new HashSet<>());

        PropertyReport propertyReport = propertyService.propertyReport();

        assert propertyReport.averageRentPrice == 0.0;
    }

}
