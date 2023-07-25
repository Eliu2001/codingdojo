package com.codingdojo.onetoone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.onetoone.models.License;
import com.codingdojo.onetoone.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;

	@Autowired
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}

	public List<License> allLicense() {
		return licenseRepository.findAll();
	}

	public License create(License l) {
		String licenseNumber = generateLicenseNumber();
        l.setNumber(licenseNumber);
		return licenseRepository.save(l);
	}

	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}

	public License update(Long id, License License) {
		Optional<License> lic = licenseRepository.findById(id);
		if (lic.isPresent()) {
			License lice = lic.get();
			lice.setNumber(License.getNumber());
			lice.setExpirationDate(License.getExpirationDate());
			lice.setState(License.getState());
			return licenseRepository.save(lice);
		} else {
			throw new IllegalArgumentException("No se encontró ningún lenguaje con el ID proporcionado.");
		}
	}

	public void delete(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if (optionalLicense.isPresent()) {
			licenseRepository.delete(optionalLicense.get());
		} else {
			throw new IllegalArgumentException("El libro con ID " + id + " no existe.");
		}
	}
	public License save(License license) {
		return licenseRepository.save(license);
	}
	
    private String generateLicenseNumber() {
        // Obtener el número actual de licencias en la base de datos
        long totalLicenses = licenseRepository.count();

        // Generar el número de licencia en el formato deseado
        String format = String.format("%07d", totalLicenses + 1);
        return format;
    }
}
