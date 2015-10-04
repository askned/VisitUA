package info.visitkievukraine.visitukraine;


import android.app.Fragment;
import android.widget.TextView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.imigration_kart)
public class ImigrationFragment extends Fragment {


    public ImigrationFragment() {
        // Required empty public constructor
    }

    @ViewById
    SubsamplingScaleImageView imageView;

    @ViewById
    TextView textView2;

    @AfterViews
    void ready() {
        textView2.setText(R.string.imigrationText);
        imageView.setImage(ImageSource.resource(R.drawable.imigrate));

    }


}
