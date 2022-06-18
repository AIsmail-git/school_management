/***
 * CityController.java
 * Controller for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 15 June 2022
 */
package za.ac.cput.school_management.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.school_management.api.CityAPI;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.service.cityService.ICityService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school-management/city/")
@Slf4j
public class CityController {

    private final ICityService cityService;
    private final CityAPI cityAPI;


    @Autowired
    public CityController(ICityService cityService, CityAPI cityAPI) {

        this.cityService = cityService;
        this.cityAPI = cityAPI;
    }

    @PostMapping("save")
    public ResponseEntity<City> save(@Valid @RequestBody City city) {
        log.info("save request: {}", city);
        City save = cityService.save(city);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<City> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        City city = this.cityService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(city);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("delete request{}", id);
        this.cityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<City>> findAll() {
        List<City> cityList = this.cityService.findAll();
        return ResponseEntity.ok(cityList);
    }

    // Question 7:
    @GetMapping("read-city-by-country-id/{countryId}")
    public ResponseEntity<List<String>> findCitiesByCountry(@PathVariable String countryId) {
        log.info("get cities in country: {}", countryId);
        List<String> cityNameList = this.cityAPI.findCitiesByCountry(countryId);
        System.out.println(cityNameList);
        return ResponseEntity.ok(cityNameList);
    }
}
