package com.optimagrowth.licensingservice.service;

import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.optimagrowth.licensingservice.model.License;

@Service
public class LicenseService {
    
    @Autowired
    private MessageSource messageSource;

    public License getLicense(String licenseId, String organizationId){
        License license = new License();
           license.setId(new Random().nextInt(1000));
           license.setLicenseId(licenseId);
           license.setLicenseType("full");
           license.setOrganizationId(organizationId);
           license.setDescription("Software product");
           license.setProductName("Ostock");
        
       return license;
    }

    public String createLicense(License license, String organizationId, Locale locale){
        if(license!=null){
            license.setOrganizationId(organizationId);
            return String.format(
                messageSource.getMessage("license.create.message", null,locale) , license.toString());
        }
        return null;
    }

    public String updateLicense(License license, String organizationId){
        if(license!=null){
            license.setOrganizationId(organizationId);
            return String.format(
                messageSource.getMessage("license.create.message", null, null), license.toString());
        }
        return null;
    }

    public String deleteLicense(String licenseId, String organizationId){
        String responseMessage = null;
        responseMessage = String.format("Deleting license with id %s for the organization %s",licenseId, organizationId);
        return responseMessage;
    }
}
