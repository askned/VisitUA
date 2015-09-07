package info.visitkievukraine.visitukraine;

import android.app.Fragment;


import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.metromap)
public class MetroFragment extends Fragment {

    @ViewById
    SubsamplingScaleImageView imageView;

    @AfterViews
    void ready() {
        imageView.setImage(ImageSource.resource(R.drawable.kiev_map_9));
    }
}
