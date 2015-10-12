package info.visitkievukraine.visitukraine;


import android.app.Fragment;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.rey.material.widget.Button;
import com.rey.material.widget.Slider;
import com.rey.material.widget.Switch;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


@EFragment(R.layout.fragment_cost_calculate)
public class CostCalculateFragment extends Fragment implements CompoundButton.OnCheckedChangeListener, Switch.OnCheckedChangeListener {

    @ViewById
    Slider seekBar;

    @ViewById
    TextView editText, sumtext;

    @ViewById
    Button buttonrezult;

    @ViewById
    Switch switchhome, switchfood, switchtransport, switchnclub;

    Integer homecost;
    Integer fudcost = 15;

    public CostCalculateFragment() {
        // Required empty public constructor
    }

    Integer costhost = 3;
    Integer costhotel = 20;
    Integer costtransp = 20;
    Integer costnclub = 0;


    Integer fastbook = 15;
    Integer café = 30;

    Integer museum = 5;
    Integer club = 50;
    Integer vipclub = 100;
    Integer pub = 15;
    Integer taxi = 20;
    Integer publictran = 2;
    Integer driver = 200;

    @AfterViews
    void ready() {
        homecost = costhost;
        switchhome.setOnCheckedChangeListener(this);
        switchfood.setOnCheckedChangeListener(this);
        switchtransport.setOnCheckedChangeListener(this);
        switchnclub.setOnCheckedChangeListener(this);
        buttonrezult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer days = Integer.valueOf(String.valueOf(editText.getText()));
                Snackbar.make(getView(), R.string.diferensumm, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Integer summall = days * (homecost + fudcost + costtransp) + costnclub;
                sumtext.setText(getString(R.string.summatex) + String.valueOf(summall) + " $");
            }
        });

        seekBar.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
                                                @Override
                                                public void onPositionChanged(Slider slider, boolean b, float v, float v1, int i, int i1) {
                                                    String progress1 = String.valueOf(i);
                                                    editText.setText(progress1);
                                                }
                                            }
        );

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (switchhome.isChecked()) {
            homecost = costhotel;
        } else {
            homecost = costhost;
        }
        if (switchfood.isChecked()) {
            fudcost = café;
        } else {
            fudcost = fastbook;
        }
        if (switchtransport.isChecked()) {
            costtransp = taxi;
        } else {
            costtransp = publictran;
        }
        if (switchnclub.isChecked()) {
            costnclub = 50;
        } else {
            costnclub = 0;
        }
    }

    @Override
    public void onCheckedChanged(Switch aSwitch, boolean b) {
        if (switchhome.isChecked()) {
            homecost = costhotel;
        } else {
            homecost = costhost;
        }
        if (switchfood.isChecked()) {
            fudcost = café;
        } else {
            fudcost = fastbook;
        }
        if (switchtransport.isChecked()) {
            costtransp = taxi;
        } else {
            costtransp = publictran;
        }
        if (switchnclub.isChecked()) {
            costnclub = 50;
        } else {
            costnclub = 0;
        }
    }
}