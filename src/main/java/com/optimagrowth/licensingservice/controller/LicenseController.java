package com.optimagrowth.licensingservice.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optimagrowth.licensingservice.model.License;
import com.optimagrowth.licensingservice.service.LicenseService;

@RestController
@RequestMapping(value = "v1/organization/{organizationId}/license")
public class LicenseController {

    @Autowired
    private LicenseService licenseService;
    
    @GetMapping(value = "/{licenseId}")
    ResponseEntity<License> getLicense(
        @PathVariable("organizationId") String organizationId,
        @PathVariable("licenseId") String licenseId){
          License license  = licenseService.getLicense(licenseId, organizationId);
          return ResponseEntity.ok(license);
    }

    @PostMapping
    ResponseEntity<String> createLicense(
        @PathVariable("organizationId") String organizationId,
        @RequestBody License license,
        @RequestHeader(value = "Accept-Language", required = false) Locale locale){

        String response = licenseService.createLicense(license, organizationId, locale);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    ResponseEntity<String> updateLicense(
        @PathVariable("organizationId") String organizationId,
        @RequestBody License license){

        String response = licenseService.updateLicense(license, organizationId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{licenseId}")
    ResponseEntity<String> deleteLicense(
        @PathVariable("organizationId") String organizationId,
        @PathVariable("licenseId") String licenseId){

        String response = licenseService.deleteLicense(licenseId, organizationId);
        return ResponseEntity.ok(response);
    }
}
