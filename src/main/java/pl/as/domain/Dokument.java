package pl.as.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Dokument {
    @NotNull
    private TypDokumentu typ_dokument;

    @NotBlank
    private String Tresc;

    @NotNull
    private EdycjaKonkursu edycjaKonkursu;

    public Dokument(TypDokumentu typ_dokument, String Tresc, EdycjaKonkursu edycjaKonkursu) {
        setTyp_dokument(typ_dokument);
        setTresc(Tresc);
        setEdycjaKonkursu(ValidationUtils.requireNotNull(edycjaKonkursu, "edycjaKonkursu"));
        edycjaKonkursu.dodajDokument(this);
    }

    public TypDokumentu getTyp_dokument() {
        return typ_dokument;
    }

    public void setTyp_dokument(TypDokumentu typ_dokument) {
        this.typ_dokument = ValidationUtils.requireNotNull(typ_dokument, "typ_dokument");
    }

    public String getTresc() {
        return Tresc;
    }

    public void setTresc(String Tresc) {
        this.Tresc = ValidationUtils.requireNotBlank(Tresc, "Tresc");
    }

    public EdycjaKonkursu getEdycjaKonkursu() {
        return edycjaKonkursu;
    }

    void setEdycjaKonkursu(EdycjaKonkursu edycjaKonkursu) {
        this.edycjaKonkursu = ValidationUtils.requireNotNull(edycjaKonkursu, "edycjaKonkursu");
    }
}
