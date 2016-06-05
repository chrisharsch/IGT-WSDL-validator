package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

/**
 * Created by Tim on 01.06.2016.
 */
@Controller
public class WSDLValidatorController{
    @RequestMapping(value = "/validateWSDL")
    @ResponseBody
    public boolean validate(String wsdl_url) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new URL("http://schemas.xmlsoap.org/wsdl/"));
            Validator validator = schema.newValidator();
            URL url = new URL(wsdl_url);
            validator.validate(new StreamSource(url.openStream()));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
        return true;
    }
}
