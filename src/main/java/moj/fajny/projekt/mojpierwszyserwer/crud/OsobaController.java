package moj.fajny.projekt.mojpierwszyserwer.crud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/osoby")
public class OsobaController {

    @Autowired
    private OsobaService service;

    @GetMapping
    public List<Osoba> list() {
        return service.list();
    }

    @GetMapping("/{pesel}")
    public Osoba get(@PathVariable String pesel) {
        return service.get(pesel);
    }

    @PostMapping
    public Osoba create (@RequestBody Osoba osoba) {
        return service.create(osoba);
    }

    @PutMapping
    public Osoba update(@RequestBody Osoba osoba) {
        return service.update(osoba);
    }

    @DeleteMapping("/{pesel}")
    public void delete (@PathVariable String pesel) {
        service.delete(pesel);
    }

}