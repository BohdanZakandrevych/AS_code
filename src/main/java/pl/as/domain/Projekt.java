package pl.as.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Projekt {
    @NotBlank
    private String nazwa;

    @NotBlank
    private String imieKierownika;

    @NotBlank
    private String nazwiskoKierownika;

    @NotNull
    private Integer czasTrwania;

    @NotNull
    private Integer liczbaCzlonkow;

    @NotNull
    private Double budzetProjektu;

    @NotNull
    private Integer liczbaPodwykonawcow;

    @NotNull
    private Boolean zgodnoscZCB4_0;

    @NotNull
    private Boolean dostepnoscDoPublikacji;

    @NotNull
    private Boolean czyUkonczony;

    @NotBlank
    private String opis;

    @NotNull
    @Valid
    private Adres adres;

    @NotBlank
    private String imieNazwiskoOsobyPotwierdzajacej;

    @NotNull
    private Boolean czyZaplacony;

    private LocalDateTime dataZakonczenia;

    private Kategoria kategoria;

    private LocalDateTime data;

    @NotNull
    private EdycjaKonkursu edycjaKonkursu;

    @NotNull
    private Aplikant aplikant;

    @NotNull
    private OsobaKontaktowa osobaKontaktowa;

    @NotNull
    private InicjatorProjektu inicjatorProjektu;

    @NotNull
    @Valid
    private OcenaIndywidualna ocenaIndywidualna;

    @NotNull
    private Asesor asesorWiodacy;

    @NotNull
    @Valid
    private final List<RaportNaPierwszeSpotkanie> raportyNaPierwszeSpotkanie = new ArrayList<>();

    @NotNull
    @Valid
    @Size(min = 2)
    private final List<RaportNaDrugieSpotkanie> ocenyIndywidualne = new ArrayList<>();

    public Projekt(
            String nazwa,
            String imieKierownika,
            String nazwiskoKierownika,
            Integer czasTrwania,
            Integer liczbaCzlonkow,
            Double budzetProjektu,
            Integer liczbaPodwykonawcow,
            Boolean zgodnoscZCB4_0,
            Boolean dostepnoscDoPublikacji,
            Boolean czyUkonczony,
            String opis,
            Adres adres,
            String imieNazwiskoOsobyPotwierdzajacej,
            Boolean czyZaplacony,
            EdycjaKonkursu edycjaKonkursu,
            Aplikant aplikant,
            OsobaKontaktowa osobaKontaktowa,
            InicjatorProjektu inicjatorProjektu,
            LocalDateTime data,
            LocalDateTime dataZakonczenia,
            Kategoria kategoria
    ) {
        setNazwa(nazwa);
        setImieKierownika(imieKierownika);
        setNazwiskoKierownika(nazwiskoKierownika);
        setCzasTrwania(czasTrwania);
        setLiczbaCzlonkow(liczbaCzlonkow);
        setBudzetProjektu(budzetProjektu);
        setLiczbaPodwykonawcow(liczbaPodwykonawcow);
        setZgodnoscZCB4_0(zgodnoscZCB4_0);
        setDostepnoscDoPublikacji(dostepnoscDoPublikacji);
        setCzyUkonczony(czyUkonczony);
        setOpis(opis);
        setAdres(adres);
        setImieNazwiskoOsobyPotwierdzajacej(imieNazwiskoOsobyPotwierdzajacej);
        setCzyZaplacony(czyZaplacony);

        if (data != null && data.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Data (onCreate) musi być w przyszłości lub teraźniejszości");
        }
        setData(data);
        setDataZakonczenia(dataZakonczenia);
        setKategoria(kategoria);

        setEdycjaKonkursu(edycjaKonkursu);
        setAplikant(aplikant);
        setOsobaKontaktowa(osobaKontaktowa);
        setInicjatorProjektu(inicjatorProjektu);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = ValidationUtils.requireNotBlank(nazwa, "nazwa");
    }

    public String getImieKierownika() {
        return imieKierownika;
    }

    public void setImieKierownika(String imieKierownika) {
        this.imieKierownika = ValidationUtils.requireNotBlank(imieKierownika, "imieKierownika");
    }

    public String getNazwiskoKierownika() {
        return nazwiskoKierownika;
    }

    public void setNazwiskoKierownika(String nazwiskoKierownika) {
        this.nazwiskoKierownika = ValidationUtils.requireNotBlank(nazwiskoKierownika, "nazwiskoKierownika");
    }

    public Integer getCzasTrwania() {
        return czasTrwania;
    }

    public void setCzasTrwania(Integer czasTrwania) {
        this.czasTrwania = ValidationUtils.requireNotNull(czasTrwania, "czasTrwania");
    }

    public Integer getLiczbaCzlonkow() {
        return liczbaCzlonkow;
    }

    public void setLiczbaCzlonkow(Integer liczbaCzlonkow) {
        this.liczbaCzlonkow = ValidationUtils.requireNotNull(liczbaCzlonkow, "liczbaCzlonkow");
    }

    public Double getBudzetProjektu() {
        return budzetProjektu;
    }

    public void setBudzetProjektu(Double budzetProjektu) {
        this.budzetProjektu = ValidationUtils.requireNotNull(budzetProjektu, "budzetProjektu");
    }

    public Integer getLiczbaPodwykonawcow() {
        return liczbaPodwykonawcow;
    }

    public void setLiczbaPodwykonawcow(Integer liczbaPodwykonawcow) {
        this.liczbaPodwykonawcow = ValidationUtils.requireNotNull(liczbaPodwykonawcow, "liczbaPodwykonawcow");
    }

    public Boolean getZgodnoscZCB4_0() {
        return zgodnoscZCB4_0;
    }

    public void setZgodnoscZCB4_0(Boolean zgodnoscZCB4_0) {
        this.zgodnoscZCB4_0 = ValidationUtils.requireNotNull(zgodnoscZCB4_0, "zgodnoscZCB4_0");
    }

    public Boolean getDostepnoscDoPublikacji() {
        return dostepnoscDoPublikacji;
    }

    public void setDostepnoscDoPublikacji(Boolean dostepnoscDoPublikacji) {
        this.dostepnoscDoPublikacji = ValidationUtils.requireNotNull(dostepnoscDoPublikacji, "dostepnoscDoPublikacji");
    }

    public Boolean getCzyUkonczony() {
        return czyUkonczony;
    }

    public void setCzyUkonczony(Boolean czyUkonczony) {
        this.czyUkonczony = ValidationUtils.requireNotNull(czyUkonczony, "czyUkonczony");
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = ValidationUtils.requireNotBlank(opis, "opis");
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = ValidationUtils.requireNotNull(adres, "adres");
    }

    public String getImieNazwiskoOsobyPotwierdzajacej() {
        return imieNazwiskoOsobyPotwierdzajacej;
    }

    public void setImieNazwiskoOsobyPotwierdzajacej(String imieNazwiskoOsobyPotwierdzajacej) {
        this.imieNazwiskoOsobyPotwierdzajacej = ValidationUtils.requireNotBlank(imieNazwiskoOsobyPotwierdzajacej, "imieNazwiskoOsobyPotwierdzajacej");
    }

    public Boolean getCzyZaplacony() {
        return czyZaplacony;
    }

    public void setCzyZaplacony(Boolean czyZaplacony) {
        this.czyZaplacony = ValidationUtils.requireNotNull(czyZaplacony, "czyZaplacony");
    }

    public LocalDateTime getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(LocalDateTime dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public EdycjaKonkursu getEdycjaKonkursu() {
        return edycjaKonkursu;
    }

    public void setEdycjaKonkursu(EdycjaKonkursu edycjaKonkursu) {
        EdycjaKonkursu nowa = ValidationUtils.requireNotNull(edycjaKonkursu, "edycjaKonkursu");
        if (this.edycjaKonkursu == nowa) {
            return;
        }
        if (this.edycjaKonkursu != null) {
            this.edycjaKonkursu.usunProjekt(this);
        }
        this.edycjaKonkursu = nowa;
        nowa.dodajProjekt(this);
    }

    public Aplikant getAplikant() {
        return aplikant;
    }

    public void setAplikant(Aplikant aplikant) {
        Aplikant nowy = ValidationUtils.requireNotNull(aplikant, "aplikant");
        if (this.aplikant == nowy) {
            return;
        }
        if (this.aplikant != null) {
            this.aplikant.usunProjekt(this);
        }
        this.aplikant = nowy;
        nowy.dodajProjekt(this);
    }

    public OsobaKontaktowa getOsobaKontaktowa() {
        return osobaKontaktowa;
    }

    public void setOsobaKontaktowa(OsobaKontaktowa osobaKontaktowa) {
        OsobaKontaktowa nowa = ValidationUtils.requireNotNull(osobaKontaktowa, "osobaKontaktowa");
        if (this.osobaKontaktowa == nowa) {
            return;
        }
        if (this.osobaKontaktowa != null) {
            this.osobaKontaktowa.usunProjekt(this);
        }
        this.osobaKontaktowa = nowa;
        nowa.dodajProjekt(this);
    }

    public InicjatorProjektu getInicjatorProjektu() {
        return inicjatorProjektu;
    }

    public void setInicjatorProjektu(InicjatorProjektu inicjatorProjektu) {
        InicjatorProjektu nowy = ValidationUtils.requireNotNull(inicjatorProjektu, "inicjatorProjektu");
        if (this.inicjatorProjektu == nowy) {
            return;
        }
        if (this.inicjatorProjektu != null) {
            this.inicjatorProjektu.usunSponsorowanyProjekt(this);
        }
        this.inicjatorProjektu = nowy;
        nowy.dodajSponsorowanyProjekt(this);
    }

    public OcenaIndywidualna getOcenaIndywidualna() {
        return ocenaIndywidualna;
    }

    public void setOcenaIndywidualna(OcenaIndywidualna ocenaIndywidualna) {
        OcenaIndywidualna nowaOcena = ValidationUtils.requireNotNull(ocenaIndywidualna, "ocenaIndywidualna");
        if (this.ocenaIndywidualna == nowaOcena) {
            return;
        }
        if (this.ocenaIndywidualna != null) {
            throw new IllegalStateException("ocenaIndywidualna jest już ustawiona");
        }
        this.ocenaIndywidualna = nowaOcena;
        if (nowaOcena.getProjekt() != this) {
            nowaOcena.setProjekt(this);
        }
    }

    public Asesor getAsesorWiodacy() {
        return asesorWiodacy;
    }

    public void setAsesorWiodacy(Asesor asesorWiodacy) {
        Asesor nowy = ValidationUtils.requireNotNull(asesorWiodacy, "asesorWiodacy");

        // Walidacja ograniczenia {subset} z diagramu UML
        boolean sporzadzilRaport = ocenyIndywidualne.stream()
                .anyMatch(raport -> raport.getAsesor().equals(nowy));

        if (!sporzadzilRaport) {
            throw new IllegalArgumentException("Asesor wiodący musi należeć do grupy asesorów sporządzających raport (subset).");
        }

        if (this.asesorWiodacy == nowy) {
            return;
        }
        if (this.asesorWiodacy != null) {
            this.asesorWiodacy.usunProjektWiodacy(this);
        }
        this.asesorWiodacy = nowy;
        if (!nowy.getProjektyWiodace().contains(this)) {
            nowy.dodajProjektWiodacy(this);
        }
    }

    public List<RaportNaPierwszeSpotkanie> getRaportyNaPierwszeSpotkanie() {
        return List.copyOf(raportyNaPierwszeSpotkanie);
    }

    public void dodajRaportNaPierwszeSpotkanie(RaportNaPierwszeSpotkanie raport) {
        ValidationUtils.requireNotNull(raport, "raport");
        if (raport.getProjekt() != this) {
            raport.setProjekt(this);
        }
        if (!raportyNaPierwszeSpotkanie.contains(raport)) {
            raportyNaPierwszeSpotkanie.add(raport);
        }
    }

    void usunRaportNaPierwszeSpotkanie(RaportNaPierwszeSpotkanie raport) {
        if (raport == null) {
            return;
        }
        raportyNaPierwszeSpotkanie.remove(raport);
    }

    public List<RaportNaDrugieSpotkanie> getOcenyIndywidualne() {
        return List.copyOf(ocenyIndywidualne);
    }

    public void dodajOceneIndywidualna(RaportNaDrugieSpotkanie raport) {
        ValidationUtils.requireNotNull(raport, "raport");
        if (raport.getProjekt() != this) {
            raport.setProjekt(this);
        }
        if (!ocenyIndywidualne.contains(raport)) {
            ocenyIndywidualne.add(raport);
        }
    }

    void usunOceneIndywidualna(RaportNaDrugieSpotkanie raport) {
        if (raport == null) {
            return;
        }
        ocenyIndywidualne.remove(raport);
    }

}
