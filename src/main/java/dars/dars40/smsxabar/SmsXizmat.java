package dars.dars40.smsxabar;

import java.util.concurrent.CopyOnWriteArrayList;

public class SmsXizmat {
    private CopyOnWriteArrayList<Abanent> abanents;

    public SmsXizmat() {
        this.abanents = new CopyOnWriteArrayList<>();
        abanents.add(new Abanent(1,"Xasan"));
        abanents.add(new Abanent(2,"Xusan"));
        abanents.add(new Abanent(3,"Avazbek"));
        abanents.add(new Abanent(4,"Imronbek"));
    }

    public void smsYubor(){
        for (Abanent abonent: abanents) {
            System.out.printf("\n %s abanentga sms yuborildi",abonent);
        }
    }

}
