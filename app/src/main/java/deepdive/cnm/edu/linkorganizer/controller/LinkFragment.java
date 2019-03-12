package deepdive.cnm.edu.linkorganizer.controller;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import deepdive.cnm.edu.linkorganizer.service.LinkOrganizerDB;
import deepdive.cnm.edu.linkorganizer.R;
import deepdive.cnm.edu.linkorganizer.entity.Link;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LinkFragment extends Fragment {

  //EditTexts
  private EditText linkUrl;
  private EditText descriptorUrl;
  //Buttons
  private Button deleteButton;
  private Button saveLink;

  public LinkFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_link, container, false);
    linkUrl = view.findViewById(R.id.link_url);
    descriptorUrl = view.findViewById(R.id.descriptor_url);
    deleteButton = view.findViewById(R.id.cancel_button);
    saveLink = view.findViewById(R.id.save_link);
    saveLink.setOnClickListener((v) -> saveLink());
    return view;
  }

  private void saveLink() {

    String url = linkUrl.getText().toString();
    String descriptor = linkUrl.getText().toString();
    Link link = new Link();
    link.setUrl(url);
    link.setDescriptor(descriptor);
    new InsertLinkTask().execute(link);

  }

  private static class InsertLinkTask extends AsyncTask<Link, Void, List<Long>> {


    @Override
    protected List<Long> doInBackground(Link... links) {
      return LinkOrganizerDB.getInstance().getLinkDao().insert(links);
    }
  }
}
