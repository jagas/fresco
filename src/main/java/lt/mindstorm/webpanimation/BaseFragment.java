package lt.mindstorm.webpanimation;

import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.List;


public class BaseFragment extends Fragment {

//    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
//            ActivityCompat.startActivity(getActivity(), intent, options);
//        } else {
//            int code = requestCode;
//            if (requestCode != -1) {
//                try {
//                    Field index = Fragment.class.getDeclaredField("mIndex");
//                    index.setAccessible(true);
//                    code = ((index.getInt(this) + 1) << 16) + (requestCode & 0xffff); //NOPMD
//                } catch (NoSuchFieldException e) {
//                    throw new RuntimeException(e);
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            ActivityCompat.startActivityForResult(getActivity(), intent, code, options);
//        }
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        List<Fragment> fragments = getChildFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                fragment.onActivityResult(requestCode, resultCode, data);
            }
        }
    }
}
