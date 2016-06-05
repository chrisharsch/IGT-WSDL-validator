package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
//http://localhost:8080/customer/add?lastName=Albers&firstName=Hans&birthDate=1990-01-01&email=email@domain.de&street=CustomerStraße1&postcode=1234567&city=Hanover
//http://localhost:8080/article/add?price=12.00&stock=2&shoppingPrice=19.99&name=Schickriegel&description=KinderRiegel

//http://localhost:8080/validateWSDL?wsdl_url=https://svn.apache.org/repos/asf/airavata/sandbox/xbaya-web/test/Calculator.wsdl