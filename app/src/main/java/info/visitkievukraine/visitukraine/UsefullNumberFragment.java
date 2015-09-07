package info.visitkievukraine.visitukraine;

import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.usefull_number)
public class UsefullNumberFragment extends Fragment {


    @ViewById
    Button button101,button102,button103,button59 ,button058,callkievtaxi2,calllvivtaxi,airport,callprivatclin1,callprivatclinix2,pizzacall;

    String num;

    @AfterViews
    void ready() {
    }
    @Click(R.id.button101)
    void alert99() {
        num = "tel:101";
        call(num);
    }
    @Click(R.id.button102)
    void alert1() {
        num = "tel:102";
        call(num);
    }
    @Click(R.id.button103)
    void alert3() {
        num = "tel:103";
        call(num);
    }

    @Click(R.id.button59)
    void alert4() {
        num = "tel:059";
        call(num);
    }
    @Click(R.id.button058)
    void alert5() {
        num = "tel:058";
        call(num);
    }
    @Click(R.id.callkievtaxi2)
    void alert6() {
        num = "tel:603";
        call(num);
    }

    @Click(R.id.calllvivtaxi)
    void alert7() {
        num = "tel:+380444675467";
        call(num);
    }
    @Click(R.id.airport)
    void alert8() {
        num = "tel:+380443934371";
        call(num);
    }
    @Click(R.id.callprivatclin1)
    void alert9() {
        num = "tel:+380442380000";
        call(num);
    }
    @Click(R.id.callprivatclinix2)
    void alert10() {
        num = "tel:1555";
        call(num);
    }
    @Click(R.id.pizzacall)
    void alert140() {
        num = "tel:+380443777355";
        call(num);
    }









    private void call(String num) {
        try {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse(this.num));
            startActivity(callIntent);
        } catch (ActivityNotFoundException e) {
            Log.e("android dialing example", "Call failed", e);
        }
    }
}
