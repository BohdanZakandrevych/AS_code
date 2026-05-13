package pl.as.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class InicjatorProjektu {
    @NotBlank
    private String nazwa;

    @NotBlank
    private String telefon;

    @NotBlank
    @Pattern(regexp = ValidationUtils.EMAIL_REGEX)
    private String email;

    @NotNull
    @Valid
    private Adres adres;

    @NotNull
    @Size(min = 1)
    @Valid
    private final List<Projekt> sponsorowaneProjekty = new ArrayList<>();

    public InicjatorProjektu(String nazwa, String telefon, String email, Adres adres) {
        setNazwa(nazwa);
        setTelefon(telefon);
        setEmail(email);
        setAdres(adres);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = ValidationUtils.requireNotBlank(nazwa, "nazwa");
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
        this.adres = ValidationUtils.requireNotNull(adres, "adres");
    }

    public List<Projekt> getSponsorowaneProjekty() {
        return List.copyOf(sponsorowaneProjekty);
    }

    public void dodajSponsorowanyProjekt(Projekt projekt) {
        ValidationUtils.requireNotNull(projekt, "projekt");
        if (projekt.getInicjatorProjektu() != this) {
            projekt.setInicjatorProjektu(this);
        }
        if (!sponsorowaneProjekty.contains(projekt)) {
            sponsorowaneProjekty.add(projekt);
        }
    }

    void usunSponsorowanyProjekt(Projekt projekt) {
        if (projekt == null) {
            return;
        }
        sponsorowaneProjekty.remove(projekt);
    }
}
