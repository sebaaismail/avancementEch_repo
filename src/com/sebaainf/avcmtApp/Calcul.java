package com.sebaainf.avcmtApp;

import javax.swing.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by user on 14/09/2015.
 */
public class Calcul extends JFrame{


    private static SituationAvcmtEch sit = new SituationAvcmtEch();

    private void calculer(SituationAvcmtEch sit, Date dateAvancmtEch, String duree) {



    }

    public static void main(String[] args) throws IOException {

        SituationAvcmtEch cal = new SituationAvcmtEch();
        Scanner scanner = new Scanner(System.in);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            String dateEffetEch;

            System.out.println("Entrer echelon actuel ....");

            int ech_actuel = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Entrer la date d'avancement d'chelon de cette année .... dd/MM/yyyy");

            dateEffetEch = scanner.nextLine();

            sit.setEchelon_actuel(ech_actuel);
            Date date1 = df.parse(dateEffetEch);
            sit.setDate_avcmt_ech_actuelAnnee(date1);


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

            sit.avcmtEch(2.5);
            //sit.avcmtEch();

            //TODO
            // cal.date_reliq = System.in.;

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
