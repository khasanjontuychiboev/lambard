package dars.dars40;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class MaxsulotService {
    private CopyOnWriteArrayList<Maxsulot> maxsulotlar;

    public MaxsulotService() {
        this.maxsulotlar = new CopyOnWriteArrayList<>();
        maxsulotlar.add(new Maxsulot("Qatiq",1));
        maxsulotlar.add(new Maxsulot("Non",4));
        maxsulotlar.add(new Maxsulot("Karam",12));
        maxsulotlar.add(new Maxsulot("Tuxum",15));
        maxsulotlar.add(new Maxsulot("Suv",20));
        maxsulotlar.add(new Maxsulot("Gosht",3));
        maxsulotlar.add(new Maxsulot("Saryoq",2));
    }

    public void  schuledDecrease(){
        for (Maxsulot maxsulot: maxsulotlar) {
            maxsulot.setMudati(maxsulot.getMudati()-1);
            if (maxsulot.getMudati() <=0 ){
                maxsulotlar.remove(maxsulot);
            }
        }
        System.out.println(maxsulotlar);
    }

    public CopyOnWriteArrayList<Maxsulot> getMaxsulotlar() {
        return maxsulotlar;
    }
}
