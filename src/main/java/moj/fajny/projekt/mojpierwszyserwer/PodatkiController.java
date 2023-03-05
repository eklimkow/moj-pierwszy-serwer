package moj.fajny.projekt.mojpierwszyserwer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/podatki")
public class PodatkiController {

    enum Rodzaj {
        VAT(0.23f),
        DOCHODOWY(0.18f),
        BELKI(0.02f);

        float wartosc;

        Rodzaj(float wartosc) {
            this.wartosc = wartosc;
        }

        public float getWartosc() {
            return wartosc;
        }
    }

    //http://localhost:8080/podatki/policz?ilosc=700&rodzaj=VAT
    // /podatki/policz?ilosc=700&rodzaj=VAT -> 700 * 0,23
    @GetMapping("/policz")
    public float policz(@RequestParam int ilosc,@RequestParam Rodzaj rodzaj) {
        return ilosc * rodzaj.getWartosc();
    }

    //http://localhost:8080/podatki?rodzaj=VAT
    //podatki?rodzaj=VAT -> 0,23f
    @GetMapping
    public float get (@RequestParam Rodzaj rodzaj) {
        return rodzaj.getWartosc();
    }

    //http://localhost:8080/swagger-ui.html
    //http://localhost:8080/v3/api-docs

}
