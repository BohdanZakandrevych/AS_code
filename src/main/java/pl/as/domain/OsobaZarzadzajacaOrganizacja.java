package pl.as.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class OsobaZarzadzajacaOrganizacja {
    @NotBlank
    private String imie;

    @NotBlank
    private String nazwisko;

    @NotBlank
    private String stanowisko;

    @NotBlank
    private String telefon;

    @NotBlank
    @Pattern(regexp = ValidationUtils.EMAIL_REGEX)
    private String email;

    @NotNull
    private Aplikant aplikant;

    public OsobaZarzadzajacaOrganizacja(
            Aplikant aplikant,
            String imie,
            String nazwisko,
            String stanowisko,
            String telefon,
            String email
    ) {
        setImie(imie);
        setNazwisko(nazwisko);
        setStanowisko(stanowisko);
        setTelefon(telefon);
        setEmail(email);

        setAplikant(ValidationUtils.requireNotNull(aplikant, "aplikant"));
        aplikant.setZarzadca(this);
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

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = ValidationUtils.requireNotBlank(stanowisko, "stanowisko");
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

    public Aplikant getAplikant() {
        return aplikant;
    }

    void setAplikant(Aplikant aplikant) {
        this.aplikant = ValidationUtils.requireNotNull(aplikant, "aplikant");
    }
}
