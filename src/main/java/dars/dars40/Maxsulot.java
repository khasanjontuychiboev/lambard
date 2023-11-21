package dars.dars40;

class Maxsulot{
    private String nomi;
    private Integer mudati;

    public Maxsulot(String nomi, Integer mudati) {
        this.nomi = nomi;
        this.mudati = mudati;
    }

    public String getNomi() {
        return nomi;
    }

    public void setNomi(String nomi) {
        this.nomi = nomi;
    }
    

    public Integer getMudati() {
        return mudati;
    }

    public void setMudati(Integer mudati) {
        this.mudati = mudati;
    }

    @Override
    public String toString() {
        return "Maxsulot{" +
                "nomi='" + nomi + '\'' +
                ", mudati=" + mudati +
                '}';
    }
}