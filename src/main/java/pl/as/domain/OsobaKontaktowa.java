package pl.as.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class OsobaKontaktowa {
    @NotBlank
    private String imie;

    @NotBlank
    private String nazwisko;

    @NotBlank
    private String telefon;

    @NotBlank
    @Pattern(regexp = ValidationUtils.EMAIL_REGEX)
    private String email;

    @Valid
    private Adres adres;

    @NotNull
    @Size(min = 1)
    @Valid
    private final List<Projekt> projekty = new ArrayList<>();

    public OsobaKontaktowa(
            String imie,
            String nazwisko,
            String telefon,
            String email,
            Adres adres
    ) {
        setImie(imie);
        setNazwisko(nazwisko);
        setTelefon(telefon);
        setEmail(email);
        setAdres(adres);
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = ValidationUtils.requireNotBlank(imie, "imie");
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = ValidationUtils.requireNotBlank(nazwisko, "nazwisko");
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = ValidationUtils.requireNotBlank(telefon, "telefon");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = ValidationUtils.requireValidEmail(email, "email");
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public List<Projekt> getProjekty() {
        return List.copyOf(projekty);
    }

    public void dodajProjekt(Projekt projekt) {
        ValidationUtils.requireNotNull(projekt, "projekt");
        if (projekt.getOsobaKontaktowa() != this) {
            projekt.setOsobaKontaktowa(this);
        }
        if (!projekty.contains(projekt)) {
            projekty.add(projekt);
        }
    }

    void usunProjekt(Projekt projekt) {
        if (projekt == null) {
            return;
        }
        projekty.remove(projekt);
    }
}
