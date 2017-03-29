package com.example.android.wtmusic;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class songList extends AppCompatActivity {

    ListView list;
    String[] songs;
    String[] description;
    int imgs [] = {R.drawable.coldplay, R.drawable.twentyonepilots, R.drawable.owlcity, R.drawable.hanszimmer};


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Resources res = getResources();

        songs = res.getStringArray(R.array.songs);
        description = res.getStringArray(R.array.Description);

        list = (ListView) findViewById(R.id.list);
        MyAdapter adapter = new MyAdapter(this,songs,imgs,description);
        list.setAdapter(adapter);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("songList Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        int[] imgs;
        String mySongs[];
        String myDescription[];

        MyAdapter(Context l, String[] songs, int[] imgs, String[] description) {
            super(l, R.layout.row, R.id.textN1, songs);
            this.context = l;
            this.imgs = imgs;
            this.myDescription = description;
            this.mySongs = songs;

        }



@Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View row = layoutInflater.inflate(R.layout.row, parent, false);
    ImageView images = (ImageView) row.findViewById(R.id.icon);
    TextView mySongs = (TextView) row.findViewById(R.id.textN1);
    TextView myDescription = (TextView) row.findViewById(R.id.textN2);
            images.setImageResource(imgs[position]);
            mySongs.setText(songs[position]);
            myDescription.setText(description[position]);
            return row;

        }

    }
}