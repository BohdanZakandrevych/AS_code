package pl.as.domain;

import jakarta.validation.constraints.NotBlank;

public class Adres {
    @NotBlank
    private String ulica;

    @NotBlank
    private String kodLubMiasto;

    @NotBlank
    private String wojewodztwo;

    @NotBlank
    private String kraj;

    public Adres(String ulica, String kodLubMiasto, String wojewodztwo, String kraj) {
        setUlica(ulica);
        setKodLubMiasto(kodLubMiasto);
        setWojewodztwo(wojewodztwo);
        setKraj(kraj);
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ValidationUtils.requireNotBlank(ulica, "ulica");
    }

    public String getKodLubMiasto() {
        return kodLubMiasto;
    }

    public void setKodLubMiasto(String kodLubMiasto) {
        this.kodLubMiasto = ValidationUtils.requireNotBlank(kodLubMiasto, "kodLubMiasto");
    }

    public String getWojewodztwo() {
        return wojewodztwo;
    }

    public void setWojewodztwo(String wojewodztwo) {
        this.wojewodztwo = ValidationUtils.requireNotBlank(wojewodztwo, "wojewodztwo");
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = ValidationUtils.requireNotBlank(kraj, "kraj");
    }
}
