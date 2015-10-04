package info.visitkievukraine.visitukraine;

import android.app.Fragment;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.rey.material.widget.FloatingActionButton;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.metromap)
public class MetroFragment extends Fragment {
    Boolean isKiev;

    @ViewById
    SubsamplingScaleImageView imageView;

    @ViewById
    FloatingActionButton fab;

    @AfterViews
    void ready() {
        imageView.setImage(ImageSource.resource(R.drawable.kiev_map_9));
        getActivity().setTitle(getString(R.string.metrokiev));
        isKiev = true;
    }

    @Click
    void fabClicked() {
        if (isKiev == true) {
            imageView.setImage(ImageSource.resource(R.drawable.kharkiv_map));
            getActivity().setTitle(getString(R.string.metrokharkov));
            isKiev = false;
        } else {
            imageView.setImage(ImageSource.resource(R.drawable.kiev_map_9));
            getActivity().setTitle(getString(R.string.kartakiev));
            isKiev = true;
        }
    }
}
