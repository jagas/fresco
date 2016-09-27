package lt.mindstorm.webpanimation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.article_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        super.onViewCreated(view, savedInstanceState);

        Button  button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stuff();
            }
        });
    }

    private void stuff() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
   startActivityForResult(photoPickerIntent, 100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (isImageSelected(requestCode, resultCode)) {
            Log.e("image url", "" + data.getData());
        } else {
            Log.e("BAD RESULT", "request code: " + requestCode + " resultCode: " + resultCode);
        }
    }

    private boolean isImageSelected(int requestCode, int resultCode) {
        return requestCode == 100 && resultCode == Activity.RESULT_OK;
    }
}
