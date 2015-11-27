
import org.apache.commons.lang3.time.DurationFormatUtils;

import javax.swing.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 14/09/2015.
 */
public class Calcul extends JFrame{


    private static Situation sit = new Situation();

    private void calculer(Situation sit, Date dateAvancmtEch, String duree) {



    }

    public static void main(String[] args) throws IOException {

        Situation cal = new Situation();
        Scanner scanner = new Scanner(System.in);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            String dateEffetEch;

            System.out.println("Entrer echelon actuel ....");

            int ech_actuel = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Entrer la date d'effet d'echelon .... dd/MM/yyyy");

            dateEffetEch = scanner.nextLine();

            sit.setEchelon_actuel(ech_actuel);
            Date date1 = df.parse(dateEffetEch);
            sit.setDate_effet_ech_actuel(date1);


            System.out.println("Entrer old reliquat ....annee");

            int years_rel = scanner.nextInt();


            System.out.println("Entrer le reliquat ....mois");

            int months_rel = scanner.nextInt();


            System.out.println("Entrer le reliquat ....jours");

            int days_rel = scanner.nextInt();
            scanner.nextLine();

            sit.setOld_reliq(new int[]{years_rel, months_rel, days_rel});

            System.out.println("Entrer la date de reliquat .... dd/MM/yyyy");

            String dateOldReliq = scanner.nextLine();
            sit.setDate_effet_old_reliq(df.parse(dateOldReliq));

            Calendar today = Calendar.getInstance();

            Calendar cal_r = Calendar.getInstance();
            cal_r.add(Calendar.DAY_OF_YEAR, (int) (365.25*(sit.getOld_reliq()[0]))); //years
            cal_r.add(Calendar.DAY_OF_YEAR, (int) (30.43*(sit.getOld_reliq()[1]))); //months
            cal_r.add(Calendar.DAY_OF_YEAR, sit.getOld_reliq()[2]);                 //days

            long reliq = cal_r.getTimeInMillis() - today.getTimeInMillis();

            Calendar cal_d = Calendar.getInstance();
            cal_d.add(Calendar.DAY_OF_YEAR, (int) (365.25*2.5));
            //c.add(Calendar.MONTH, 6);
            long duree = cal_d.getTimeInMillis() - today.getTimeInMillis();

            //long duree = TimeUnit.DAYS.toMillis((long) (365*2.5));


            String str = DurationFormatUtils.formatPeriod(sit.getDate_effet_old_reliq().getTime()+ duree,
                    sit.getDate_effet_ech_actuel().getTime()+reliq, "yy a MM 'm' dd j");
            System.out.println(str);

            //sit.avcmtEch();

            //TODO
            // cal.date_reliq = System.in.;

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
