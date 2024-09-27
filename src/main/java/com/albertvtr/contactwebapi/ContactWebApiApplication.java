package com.albertvtr.contactwebapi;

import com.albertvtr.contactwebapi.model.entities.Contact;
import com.albertvtr.contactwebapi.model.entities.Employee;
import com.albertvtr.contactwebapi.model.entities.Freelance;
import com.albertvtr.contactwebapi.service.contact.dtos.ContactDTO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactWebApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactWebApiApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Configure converter to instantiate the right subclass when converting ContactDTO to Contact entity
        Converter<ContactDTO, Contact> contactConverter = new Converter<ContactDTO, Contact>() {

            @Override
            public Contact convert(MappingContext<ContactDTO, Contact> mappingContext) {
                ContactDTO source = mappingContext.getSource();
                Contact target = null;

                // Choosing the right subclass depending on contact type
                switch (source.getContactType()){
                    case EMPLOYEE -> target = modelMapper.map(source, Employee.class);
                    case FREELANCE -> target = modelMapper.map(source, Freelance.class);
                }

                return target;
            }
        };

        modelMapper.addConverter(contactConverter);
        return modelMapper;
    }

}
