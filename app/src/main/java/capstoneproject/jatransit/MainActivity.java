package capstoneproject.jatransit;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState;

/**
 * Created by CaliphCole on 02/17/2015.
 */
public class MainActivity extends ActionBarActivity{

    private static final String TAG = "DemoActivity";

    private SlidingUpPanelLayout mLayout;

    private MapsActivity maps;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //setSupportActionBar((Toolbar)findViewById(R.id.main_toolbar));


        mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        mLayout.setPanelSlideListener(new PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.i(TAG, "onPanelSlide, offset " + slideOffset);
            }

            @Override
            public void onPanelExpanded(View panel) {
                Log.i(TAG, "onPanelExpanded");

            }

            @Override
            public void onPanelCollapsed(View panel) {
                Log.i(TAG, "onPanelCollapsed");

            }

            @Override
            public void onPanelAnchored(View panel) {
                Log.i(TAG, "onPanelAnchored");
            }

            @Override
            public void onPanelHidden(View panel) {
                Log.i(TAG, "onPanelHidden");
            }
        });



       TextView t = (TextView) findViewById(R.id.name);
        t.setText("Retrieve Routes");

        TextView routeName = (TextView) findViewById(R.id.routeName);





        maps = MapsActivity.newInstance(0, maps.ARG_CATEGORY_NUMBER);
        FragmentManager fragmentManager0 = getSupportFragmentManager();

        fragmentManager0.beginTransaction().add(R.id.container, maps,maps.ARG_CATEGORY_NUMBER).commit();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        MenuItem item = menu.findItem(R.id.action_toggle);
        /*if (mLayout != null) {
            if (mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.HIDDEN) {
                item.setTitle("Show Panel");
            } else {
                item.setTitle("Hide Panel");
            }
        }*/
        //super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_toggle: {
               /* if (mLayout != null) {
                    if (mLayout.getPanelState() != PanelState.HIDDEN) {
                        mLayout.setPanelState(PanelState.HIDDEN);
                        item.setTitle("Show Panel");
                    } else {
                        mLayout.setPanelState(PanelState.COLLAPSED);
                        item.setTitle("Hide Panel");
                    }
                }*/
                return true;
            }
            case R.id.action_anchor: {
               /*if (mLayout != null) {
                    if (mLayout.getAnchorPoint() == 1.0f) {
                        mLayout.setAnchorPoint(0.7f);
                        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.ANCHORED);
                        item.setTitle("Test");
                    } else {
                        mLayout.setAnchorPoint(1.0f);
                        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                        item.setTitle("Test");
                    }
                }*/
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        if (mLayout != null &&
                (mLayout.getPanelState() == PanelState.EXPANDED || mLayout.getPanelState() == PanelState.ANCHORED)) {
            mLayout.setPanelState(PanelState.COLLAPSED);
        } else {
            super.onBackPressed();
        }
    }
}
