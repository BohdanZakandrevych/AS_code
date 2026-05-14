package pl.as.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EdycjaKonkursu {
    @NotNull
    private final Integer Numer_edycji;

    @NotNull
    private Integer rok;

    @NotNull
    private Double kosztUdzialuNetto;

    @NotNull
    @Size(min = 1)
    private List<@NotBlank String> nazwa_Kategoria;

    @NotNull
    private LocalDateTime dataKoncowaZgloszen;

    @NotNull
    private LocalDateTime dataOgloszeniaFinalistow;

    @NotNull
    private LocalDateTime dataOgloszeniaLaureatow;

    @NotNull
    private LocalDateTime dataKoncowaZgloszeniaAplikacji;

    @NotNull
    private LocalDateTime dataWebinariumDlaPotencjalnychAplikantow;

    @NotNull
    private LocalDateTime dataWebinariumDlaAplikantow;

    @NotNull
    private LocalDateTime dataWebinariumDlaAsesorow;

    @NotNull
    private LocalDateTime dataWebinariumDlaAsesorowWiodacych;

    @NotNull
    private LocalDateTime dataRaportuNaPierwszeSpotkanieJury;

    @NotNull
    private LocalDateTime dataRaportuNaDrugieSpotkanieJury;

    @NotNull
    private LocalDateTime dataPierwszegoSpotkaniaJury;

    @NotNull
    private LocalDateTime dataDrugiegoSpotkaniaJury;

    @NotNull
    private LocalDateTime dataOgloszeniaFinalistow2;

    @NotNull
    private LocalDateTime dataOgloszeniaLaureatow2;

    @NotNull
    @Valid
    private final List<Dokument> dokumenty = new ArrayList<>();

    @NotNull
    @Size(min = 1)
    @Valid
    private final List<Projekt> projekty = new ArrayList<>();

    @NotNull
    @Valid
    private BiuroNagrody biuroNagrody;

    @NotNull
    @Size(min = 1)
    @Valid
    private final List<Finalista> finalisci = new ArrayList<>();

    @NotNull
    @Size(min = 2, max = 2)
    @Valid
    private final List<CzlonekJury> przewodniczacy = new ArrayList<>();

    @NotNull
    @Size(min = 1)
    @Valid
    private final List<CzlonekJury> czlonkowie = new ArrayList<>();

    public static EdycjaKonkursu utworzKolejnaEdycje(
            EdycjaKonkursu poprzedniaEdycja,
            Integer rok,
            Double kosztUdzialuNetto,
            List<String> nazwa_Kategoria,
            LocalDateTime dataKoncowaZgloszen,
            LocalDateTime dataOgloszeniaFinalistow,
            LocalDateTime dataOgloszeniaLaureatow,
            LocalDateTime dataKoncowaZgloszeniaAplikacji,
            LocalDateTime dataWebinariumDlaPotencjalnychAplikantow,
            LocalDateTime dataWebinariumDlaAplikantow,
            LocalDateTime dataWebinariumDlaAsesorow,
            LocalDateTime dataWebinariumDlaAsesorowWiodacych,
            LocalDateTime dataRaportuNaPierwszeSpotkanieJury,
            LocalDateTime dataRaportuNaDrugieSpotkanieJury,
            LocalDateTime dataPierwszegoSpotkaniaJury,
            LocalDateTime dataDrugiegoSpotkaniaJury,
            LocalDateTime dataOgloszeniaFinalistow2,
            LocalDateTime dataOgloszeniaLaureatow2
    ) {
        ValidationUtils.requireNotNull(poprzedniaEdycja, "poprzedniaEdycja");
        Integer docelowyRok = ValidationUtils.requireNotNull(rok, "rok");
        if (docelowyRok != poprzedniaEdycja.getRok() + 1) {
            throw new IllegalArgumentException("Ciągłość edycji: rok musi być równy (rok poprzedni + 1)");
        }

        int numer = poprzedniaEdycja.getNumer_edycji() + 1;
        return new EdycjaKonkursu(
                numer,
                docelowyRok,
                kosztUdzialuNetto,
                nazwa_Kategoria,
                dataKoncowaZgloszen,
                dataOgloszeniaFinalistow,
                dataOgloszeniaLaureatow,
                dataKoncowaZgloszeniaAplikacji,
                dataWebinariumDlaPotencjalnychAplikantow,
                dataWebinariumDlaAplikantow,
                dataWebinariumDlaAsesorow,
                dataWebinariumDlaAsesorowWiodacych,
                dataRaportuNaPierwszeSpotkanieJury,
                dataRaportuNaDrugieSpotkanieJury,
                dataPierwszegoSpotkaniaJury,
                dataDrugiegoSpotkaniaJury,
                dataOgloszeniaFinalistow2,
                dataOgloszeniaLaureatow2
        );
    }

    public EdycjaKonkursu(
            Integer Numer_edycji,
            Integer rok,
            Double kosztUdzialuNetto,
            List<String> nazwa_Kategoria,
            LocalDateTime dataKoncowaZgloszen,
            LocalDateTime dataOgloszeniaFinalistow,
            LocalDateTime dataOgloszeniaLaureatow,
            LocalDateTime dataKoncowaZgloszeniaAplikacji,
            LocalDateTime dataWebinariumDlaPotencjalnychAplikantow,
            LocalDateTime dataWebinariumDlaAplikantow,
            LocalDateTime dataWebinariumDlaAsesorow,
            LocalDateTime dataWebinariumDlaAsesorowWiodacych,
            LocalDateTime dataRaportuNaPierwszeSpotkanieJury,
            LocalDateTime dataRaportuNaDrugieSpotkanieJury,
            LocalDateTime dataPierwszegoSpotkaniaJury,
            LocalDateTime dataDrugiegoSpotkaniaJury,
            LocalDateTime dataOgloszeniaFinalistow2,
            LocalDateTime dataOgloszeniaLaureatow2
    ) {
        this.Numer_edycji = ValidationUtils.requireNotNull(Numer_edycji, "Numer_edycji");
        setRok(rok);
        setKosztUdzialuNetto(kosztUdzialuNetto);
        setNazwa_Kategoria(nazwa_Kategoria);

        setDataKoncowaZgloszen(dataKoncowaZgloszen);
        setDataOgloszeniaFinalistow(dataOgloszeniaFinalistow);
        setDataOgloszeniaLaureatow(dataOgloszeniaLaureatow);
        setDataKoncowaZgloszeniaAplikacji(dataKoncowaZgloszeniaAplikacji);
        setDataWebinariumDlaPotencjalnychAplikantow(dataWebinariumDlaPotencjalnychAplikantow);
        setDataWebinariumDlaAplikantow(dataWebinariumDlaAplikantow);
        setDataWebinariumDlaAsesorow(dataWebinariumDlaAsesorow);
        setDataWebinariumDlaAsesorowWiodacych(dataWebinariumDlaAsesorowWiodacych);
        setDataRaportuNaPierwszeSpotkanieJury(dataRaportuNaPierwszeSpotkanieJury);
        setDataRaportuNaDrugieSpotkanieJury(dataRaportuNaDrugieSpotkanieJury);
        setDataPierwszegoSpotkaniaJury(dataPierwszegoSpotkaniaJury);
        setDataDrugiegoSpotkaniaJury(dataDrugiegoSpotkaniaJury);
        setDataOgloszeniaFinalistow2(dataOgloszeniaFinalistow2);
        setDataOgloszeniaLaureatow2(dataOgloszeniaLaureatow2);
    }

    public Integer getNumer_edycji() {
        return Numer_edycji;
    }

    public Integer getRok() {
        return rok;
    }

    public void setRok(Integer rok) {
        this.rok = ValidationUtils.requireNotNull(rok, "rok");
    }

    public Double getKosztUdzialuNetto() {
        return kosztUdzialuNetto;
    }

    public void setKosztUdzialuNetto(Double kosztUdzialuNetto) {
        this.kosztUdzialuNetto = ValidationUtils.requireNotNull(kosztUdzialuNetto, "kosztUdzialuNetto");
    }

    public List<String> getNazwa_Kategoria() {
        return List.copyOf(nazwa_Kategoria);
    }

    public void setNazwa_Kategoria(List<String> nazwa_Kategoria) {
        ValidationUtils.requireNotNull(nazwa_Kategoria, "nazwa_Kategoria");
        this.nazwa_Kategoria = new ArrayList<>(nazwa_Kategoria);
    }

    public LocalDateTime getDataKoncowaZgloszen() {
        return dataKoncowaZgloszen;
    }

    public void setDataKoncowaZgloszen(LocalDateTime dataKoncowaZgloszen) {
        this.dataKoncowaZgloszen = ValidationUtils.requireNotNull(dataKoncowaZgloszen, "dataKoncowaZgloszen");
    }

    public LocalDateTime getDataOgloszeniaFinalistow() {
        return dataOgloszeniaFinalistow;
    }

    public void setDataOgloszeniaFinalistow(LocalDateTime dataOgloszeniaFinalistow) {
        this.dataOgloszeniaFinalistow = ValidationUtils.requireNotNull(dataOgloszeniaFinalistow, "dataOgloszeniaFinalistow");
    }

    public LocalDateTime getDataOgloszeniaLaureatow() {
        return dataOgloszeniaLaureatow;
    }

    public void setDataOgloszeniaLaureatow(LocalDateTime dataOgloszeniaLaureatow) {
        this.dataOgloszeniaLaureatow = ValidationUtils.requireNotNull(dataOgloszeniaLaureatow, "dataOgloszeniaLaureatow");
    }

    public LocalDateTime getDataKoncowaZgloszeniaAplikacji() {
        return dataKoncowaZgloszeniaAplikacji;
    }

    public void setDataKoncowaZgloszeniaAplikacji(LocalDateTime dataKoncowaZgloszeniaAplikacji) {
        this.dataKoncowaZgloszeniaAplikacji = ValidationUtils.requireNotNull(dataKoncowaZgloszeniaAplikacji, "dataKoncowaZgloszeniaAplikacji");
    }

    public LocalDateTime getDataWebinariumDlaPotencjalnychAplikantow() {
        return dataWebinariumDlaPotencjalnychAplikantow;
    }

    public void setDataWebinariumDlaPotencjalnychAplikantow(LocalDateTime dataWebinariumDlaPotencjalnychAplikantow) {
        this.dataWebinariumDlaPotencjalnychAplikantow = ValidationUtils.requireNotNull(dataWebinariumDlaPotencjalnychAplikantow, "dataWebinariumDlaPotencjalnychAplikantow");
    }

    public LocalDateTime getDataWebinariumDlaAplikantow() {
        return dataWebinariumDlaAplikantow;
    }

    public void setDataWebinariumDlaAplikantow(LocalDateTime dataWebinariumDlaAplikantow) {
        this.dataWebinariumDlaAplikantow = ValidationUtils.requireNotNull(dataWebinariumDlaAplikantow, "dataWebinariumDlaAplikantow");
    }

    public LocalDateTime getDataWebinariumDlaAsesorow() {
        return dataWebinariumDlaAsesorow;
    }

    public void setDataWebinariumDlaAsesorow(LocalDateTime dataWebinariumDlaAsesorow) {
        this.dataWebinariumDlaAsesorow = ValidationUtils.requireNotNull(dataWebinariumDlaAsesorow, "dataWebinariumDlaAsesorow");
    }

    public LocalDateTime getDataWebinariumDlaAsesorowWiodacych() {
        return dataWebinariumDlaAsesorowWiodacych;
    }

    public void setDataWebinariumDlaAsesorowWiodacych(LocalDateTime dataWebinariumDlaAsesorowWiodacych) {
        this.dataWebinariumDlaAsesorowWiodacych = ValidationUtils.requireNotNull(dataWebinariumDlaAsesorowWiodacych, "dataWebinariumDlaAsesorowWiodacych");
    }

    public LocalDateTime getDataRaportuNaPierwszeSpotkanieJury() {
        return dataRaportuNaPierwszeSpotkanieJury;
    }

    public void setDataRaportuNaPierwszeSpotkanieJury(LocalDateTime dataRaportuNaPierwszeSpotkanieJury) {
        this.dataRaportuNaPierwszeSpotkanieJury = ValidationUtils.requireNotNull(dataRaportuNaPierwszeSpotkanieJury, "dataRaportuNaPierwszeSpotkanieJury");
    }

    public LocalDateTime getDataRaportuNaDrugieSpotkanieJury() {
        return dataRaportuNaDrugieSpotkanieJury;
    }

    public void setDataRaportuNaDrugieSpotkanieJury(LocalDateTime dataRaportuNaDrugieSpotkanieJury) {
        this.dataRaportuNaDrugieSpotkanieJury = ValidationUtils.requireNotNull(dataRaportuNaDrugieSpotkanieJury, "dataRaportuNaDrugieSpotkanieJury");
    }

    public LocalDateTime getDataPierwszegoSpotkaniaJury() {
        return dataPierwszegoSpotkaniaJury;
    }

    public void setDataPierwszegoSpotkaniaJury(LocalDateTime dataPierwszegoSpotkaniaJury) {
        this.dataPierwszegoSpotkaniaJury = ValidationUtils.requireNotNull(dataPierwszegoSpotkaniaJury, "dataPierwszegoSpotkaniaJury");
    }

    public LocalDateTime getDataDrugiegoSpotkaniaJury() {
        return dataDrugiegoSpotkaniaJury;
    }

    public void setDataDrugiegoSpotkaniaJury(LocalDateTime dataDrugiegoSpotkaniaJury) {
        this.dataDrugiegoSpotkaniaJury = ValidationUtils.requireNotNull(dataDrugiegoSpotkaniaJury, "dataDrugiegoSpotkaniaJury");
    }

    public LocalDateTime getDataOgloszeniaFinalistow2() {
        return dataOgloszeniaFinalistow2;
    }

    public void setDataOgloszeniaFinalistow2(LocalDateTime dataOgloszeniaFinalistow2) {
        this.dataOgloszeniaFinalistow2 = ValidationUtils.requireNotNull(dataOgloszeniaFinalistow2, "dataOgloszeniaFinalistow2");
    }

    public LocalDateTime getDataOgloszeniaLaureatow2() {
        return dataOgloszeniaLaureatow2;
    }

    public void setDataOgloszeniaLaureatow2(LocalDateTime dataOgloszeniaLaureatow2) {
        this.dataOgloszeniaLaureatow2 = ValidationUtils.requireNotNull(dataOgloszeniaLaureatow2, "dataOgloszeniaLaureatow2");
    }

    public List<Dokument> getDokumenty() {
        return List.copyOf(dokumenty);
    }

    public void dodajDokument(Dokument dokument) {
        ValidationUtils.requireNotNull(dokument, "dokument");
        if (dokument.getEdycjaKonkursu() != this) {
            dokument.setEdycjaKonkursu(this);
        }
        if (!dokumenty.contains(dokument)) {
            dokumenty.add(dokument);
        }
    }

    public List<Projekt> getProjekty() {
        return List.copyOf(projekty);
    }

    public void dodajProjekt(Projekt projekt) {
        ValidationUtils.requireNotNull(projekt, "projekt");
        if (projekt.getEdycjaKonkursu() != this) {
            projekt.setEdycjaKonkursu(this);
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

    public BiuroNagrody getBiuroNagrody() {
        return biuroNagrody;
    }

    public void setBiuroNagrody(BiuroNagrody biuroNagrody) {
        BiuroNagrody noweBiuro = ValidationUtils.requireNotNull(biuroNagrody, "biuroNagrody");
        if (this.biuroNagrody == noweBiuro) {
            return;
        }
        if (this.biuroNagrody != null) {
            throw new IllegalStateException("biuroNagrody jest już przypisane");
        }
        this.biuroNagrody = noweBiuro;
        if (noweBiuro.getEdycjaKonkursu() != this) {
            noweBiuro.setEdycjaKonkursu(this);
        }
    }

    public List<Finalista> getFinalisci() {
        return List.copyOf(finalisci);
    }

    public void dodajFinaliste(Finalista finalista) {
        ValidationUtils.requireNotNull(finalista, "finalista");
        if (!finalisci.contains(finalista)) {
            finalisci.add(finalista);
        }
        if (finalista.getEdycjaKonkursu() != this) {
            finalista.setEdycjaKonkursu(this);
        }
    }

    void usunFinaliste(Finalista finalista) {
        if (finalista == null) {
            return;
        }
        finalisci.remove(finalista);
    }

    public List<CzlonekJury> getPrzewodniczacy() {
        return List.copyOf(przewodniczacy);
    }

    public void dodajPrzewodniczacego(CzlonekJury czlonekJury) {
        ValidationUtils.requireNotNull(czlonekJury, "czlonekJury");
        if (przewodniczacy.contains(czlonekJury)) {
            return;
        }
        if (przewodniczacy.size() >= 2) {
            throw new IllegalStateException("przewodniczacy musi zawierać dokładnie 2 osoby");
        }
        przewodniczacy.add(czlonekJury);
        if (!czlonekJury.getEdycje().contains(this)) {
            czlonekJury.dodajEdycje(this);
        }
    }

    public List<CzlonekJury> getCzlonkowie() {
        return List.copyOf(czlonkowie);
    }

    public void dodajCzlonka(CzlonekJury czlonekJury) {
        ValidationUtils.requireNotNull(czlonekJury, "czlonekJury");
        if (!czlonkowie.contains(czlonekJury)) {
            czlonkowie.add(czlonekJury);
        }
        if (!czlonekJury.getEdycjeCzlonkowskie().contains(this)) {
            czlonekJury.dodajEdycjeCzlonkowska(this);
        }
    }

    public void usunCzlonka(CzlonekJury czlonekJury) {
        if (czlonekJury == null) {
            return;
        }
        if (czlonkowie.remove(czlonekJury)) {
            czlonekJury.usunEdycjeCzlonkowskaWewn(this);
        }
    }

    void usunCzlonkaWewn(CzlonekJury czlonekJury) {
        if (czlonekJury == null) {
            return;
        }
        czlonkowie.remove(czlonekJury);
    }
}
