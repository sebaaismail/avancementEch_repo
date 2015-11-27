import com.jgoodies.common.bean.Bean;
import javafx.util.Duration;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.io.IOException;
import java.util.Date;

/**
 * class that hold a situation of one employ : les entrees
 * Created by user on 14/09/2015.
 */
public class Situation extends Bean {


    private int echelon_actuel = 0;

    private int[] old_reliq ={0, 0, 0}; // AA MM JJ


    private Date date_effet_old_reliq;
    private Date date_effet_ech_actuel;

    public int getEchelon_actuel() {

        return echelon_actuel;
    }

    public void setEchelon_actuel(int echelon_actuel) {

        this.echelon_actuel = echelon_actuel;
    }

    public int[] getOld_reliq() {

        return old_reliq;
    }

    public void setOld_reliq(int[] old_reliq) {

        this.old_reliq = old_reliq;
    }

    public Date getDate_effet_old_reliq() {

        return date_effet_old_reliq;
    }

    public void setDate_effet_old_reliq(Date date_effet_old_reliq) {

        this.date_effet_old_reliq = date_effet_old_reliq;
    }

    public Date getDate_effet_ech_actuel() {

        return date_effet_ech_actuel;
    }

    public void setDate_effet_ech_actuel(Date date_effet_ech_actuel) {

        this.date_effet_ech_actuel = date_effet_ech_actuel;
    }

    public void avcmtEch() {


    }
}
