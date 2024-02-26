package com.example.newproject.House;
import org.hibernate.ResourceClosedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HouseController {
    private final HouseRepository houseRepo;

    public HouseController(HouseRepository houseRepo) {
        this.houseRepo = houseRepo;
    }

    @GetMapping("/")
    public String hello(){
        return "helo!";
    }

    @GetMapping("/houses")
    public List<House> getHouses(){
        return houseRepo.findAll();
    }

    @GetMapping("/houses/{id}")
    public ResponseEntity<House> getSpesificHouses(@PathVariable Long id){
        House house = houseRepo.findById(id).orElse(null);
        return ResponseEntity.ok().body(house);
    }

    @PostMapping("/houses")
    public House addHouse(@RequestBody House house){
        return houseRepo.save(house);
    }

    @DeleteMapping("/houses/{id}")
    public String deleteHouse(@PathVariable Long id) {
        House house = houseRepo.findById(id).orElseThrow(() -> new ResourceClosedException("House not found for this id :" + id));
        houseRepo.delete(house);
        return "House No: " + id + " deleted.";
    }

    @PutMapping("houses/{id}")
    public ResponseEntity<House> updateHouse(@PathVariable Long id, @RequestBody House houseDetails){
        House house = houseRepo.findById(id).orElse(null);
        if (house != null) {
            house.setName(houseDetails.getName());
            house.setLocation(houseDetails.getLocation());
            house.setPrice(houseDetails.getPrice());
            house.setDescription(houseDetails.getDescription());
            house.setBanyo_sayisi(houseDetails.getBanyo_sayisi());
            house.setYatak_sayisi(houseDetails.getYatak_sayisi());
            house.setMetrekare(houseDetails.getMetrekare());
            house.setImagePath(houseDetails.getImagePath());
            final House updatedHouse = houseRepo.save(house);
            return ResponseEntity.ok(updatedHouse);
        }
        else {
            return null;
        }
    }

}
