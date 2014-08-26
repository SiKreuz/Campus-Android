package de.tum.in.tumcampus.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import de.tum.in.tumcampus.R;
import de.tum.in.tumcampus.auxiliary.ImplicitCounter;
import de.tum.in.tumcampus.activities.generic.ActivityForDownloadingExternal;
import de.tum.in.tumcampus.adapters.GallerySectionsPagerAdapter;
import de.tum.in.tumcampus.auxiliary.Const;

/**
 * Displays images fetched from Facebook.
 * 
 * @review Sascha Moecker
 * 
 */
public class GalleryActivity extends ActivityForDownloadingExternal {

    private SharedPreferences sharedPrefs;

    //private ImplicitCounter implicitCounter;


	public GalleryActivity() {
		super(Const.GALLERY, R.layout.activity_gallery);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestDownload(false);
		sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
		if (sharedPrefs.getBoolean("implicitly_id", true)){
			ImplicitCounter.Counter("gallery_id",getApplicationContext());
		}
		
	}

	@Override
	protected void onStart() {
		super.onStart();
		sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        GallerySectionsPagerAdapter mSectionsPagerAdapter = new GallerySectionsPagerAdapter(this,
                getSupportFragmentManager());

        ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager
				.setCurrentItem(GallerySectionsPagerAdapter.PAGE_LATESTS_GALLERY);
		mViewPager.setAdapter(mSectionsPagerAdapter);
	}
}