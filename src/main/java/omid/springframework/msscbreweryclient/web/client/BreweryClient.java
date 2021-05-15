package omid.springframework.msscbreweryclient.web.client;

import omid.springframework.msscbreweryclient.web.model.BeerDto;
import omid.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * Created by jt on 2019-04-23.
 */
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }
    public URI saveBeerDto(BeerDto beerDto){
        return restTemplate.postForLocation(apihost + BEER_PATH_V1,beerDto);
    }
    public void updateBeer(UUID uuid,BeerDto beerDto){
        restTemplate.put(apihost + BEER_PATH_V1 + "/" + uuid.toString(),beerDto);
    }
    public void deleteBeer(UUID id){
        restTemplate.delete(apihost+BEER_PATH_V1 + "/"+ id);
    }



    public CustomerDto getCustomerById(UUID uuid){
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + uuid.toString(), CustomerDto.class);
    }
    public URI saveCustomerDto(CustomerDto customerDto){
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1,customerDto);
    }
    public void updateCustomer(UUID uuid,CustomerDto customerDto){
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + "/" + uuid.toString(),customerDto);
    }

    public void deleteCustomer(UUID id){
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + "/"+ id);
    }
    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
