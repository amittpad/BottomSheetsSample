package info.encoders.amit.bottomsheetssample;

import android.support.design.widget.*;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomSheetBehavior bottomSheetBehavior;
    private TextView bottomSheetHeading;
    private Button expandBottomSheetButton;
    private Button collapseBottomSheetButton;
    private Button hideBottomSheetButton;
    private Button showBottomSheetDialogButton;
    private Button checkBottomSheetExpandOrCollapse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheetLayout));
        bottomSheetHeading = (TextView) findViewById(R.id.bottomSheetHeading);
        expandBottomSheetButton = (Button) findViewById(R.id.expand_bottom_sheet_button);
        collapseBottomSheetButton = (Button) findViewById(R.id.collapse_bottom_sheet_button);
        hideBottomSheetButton = (Button) findViewById(R.id.hide_bottom_sheet_button);
        showBottomSheetDialogButton = (Button) findViewById(R.id.show_bottom_sheet_dialog_button);
        checkBottomSheetExpandOrCollapse =(Button)findViewById(R.id.check_expand_collapse_button);

    }

    private void initListeners() {
        // register the listener for button click
        expandBottomSheetButton.setOnClickListener(this);
        collapseBottomSheetButton.setOnClickListener(this);
        hideBottomSheetButton.setOnClickListener(this);
        showBottomSheetDialogButton.setOnClickListener(this);
        checkBottomSheetExpandOrCollapse.setOnClickListener(this);

        // Capturing the callbacks for bottom sheet
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {

//                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
//                    bottomSheetHeading.setText(getString(R.string.text_collapse_me));
//                } else {
//                    bottomSheetHeading.setText(getString(R.string.text_expand_me));
//                }

//                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
//                    bottomSheetBehavior.setPeekHeight(0);
//                }


                // Check Logs to see how bottom sheets behaves
                switch (newState) {
                    case BottomSheetBehavior.STATE_EXPANDED:
                        Log.e("Bottom Sheet Behaviour", "STATE_EXPANDED");
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        Log.e("Bottom Sheet Behaviour", "STATE_COLLAPSED");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        Log.e("Bottom Sheet Behaviour", "STATE_DRAGGING");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.e("Bottom Sheet Behaviour", "STATE_HIDDEN");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        Log.e("Bottom Sheet Behaviour", "STATE_SETTLING");
                        break;
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.expand_bottom_sheet_button:
                // Expanding the bottom sheet
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.collapse_bottom_sheet_button:
                // Collapsing the bottom sheet
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
            case R.id.hide_bottom_sheet_button:
                // Hiding the bottom sheet
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                break;
            case R.id.show_bottom_sheet_dialog_button:
                BottomSheetDialogFragment bottomSheetDialogFragment = new CustomBottomSheetDialogFragment();
                bottomSheetDialogFragment.show(getSupportFragmentManager(),"Dialog");
                break;
            case R.id.check_expand_collapse_button:
                if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED)
                    //If state is in collapse mode expand it
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                else
                    //else if state is expanded collapse it
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;

        }

    }
}
