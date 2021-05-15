package omid.springframework.msscbreweryclient.web.client;

import omid.springframework.msscbreweryclient.web.model.BeerDto;
import omid.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }
    @Test
    void testNewBeer(){
        BeerDto newBeer = BeerDto
                .builder()
                .beerName("New Beer")
                .build();
        URI uri = client.saveBeerDto(newBeer);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }
    @Test
    void testUpdateBeer(){
        BeerDto newBeer = BeerDto
                .builder()
                .beerName("New Beer")
                .build();
        client.updateBeer(UUID.randomUUID(),newBeer);
    }
    @Test
    void testDeleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }
    @Test
    void testNewCustomer(){
        CustomerDto newCustomer = CustomerDto
                .builder()
                .name("New Customer")
                .build();
        URI uri = client.saveCustomerDto(newCustomer);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }
    @Test
    void testUpdateCustomer(){
        CustomerDto newCustomer = CustomerDto
                .builder()
                .name("New Customer")
                .build();
        client.updateCustomer(UUID.randomUUID(),newCustomer);
    }
    @Test
    void testDeleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());
    }
}