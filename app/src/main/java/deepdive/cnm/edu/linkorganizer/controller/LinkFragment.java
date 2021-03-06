package deepdive.cnm.edu.linkorganizer.controller;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import deepdive.cnm.edu.linkorganizer.model.LinkOrganizerDB;
import deepdive.cnm.edu.linkorganizer.R;
import deepdive.cnm.edu.linkorganizer.model.entity.Link;
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

  private Link link;

  public LinkFragment() {
    // Required empty public constructor
  }

  /**
   * Creates new instance of a link and bundles it.
   *
   * @param id identification parameter of a specific instance of a <code>Link</code>
   * @return returns bundled instance of ID
   */
  public static Fragment newInstance(long id) {

    LinkFragment linkFragment = new LinkFragment();
    Bundle bundle = new Bundle();
    bundle.putLong("id", id);
    linkFragment.setArguments(bundle);
    return linkFragment;

  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_link, container, false);
    linkUrl = view.findViewById(R.id.link_url);
    descriptorUrl = view.findViewById(R.id.descriptor_url);
    saveLink = view.findViewById(R.id.save_link);
    saveLink.setOnClickListener((v) -> saveLink());
    if (getArguments() != null && getArguments().containsKey("id")) {
      new AsyncTask<Long, Void, Link>() {
        @Override
        protected Link doInBackground(Long... longs) {
          return LinkOrganizerDB.getInstance().getLinkDao().getLinkById(longs[0]);
        }

        @Override
        protected void onPostExecute(Link link) {
          linkUrl.setText(link.getUrl());
          descriptorUrl.setText(link.getDescriptor());
          LinkFragment.this.link = link;
        }

      }
          .execute(getArguments().getLong("id"));
    }
    return view;
  }

  private void saveLink() {

    String url = linkUrl.getText().toString();
    String descriptor = descriptorUrl.getText().toString();

    if (link != null) {
      link.setUrl(url);
      link.setDescriptor(descriptor);
      new AsyncTask<Link, Void, Void>() {
        @Override
        protected Void doInBackground(Link... links) {
          LinkOrganizerDB.getInstance().getLinkDao().update(links[0]);
          return null;
        }

      }
          .execute(link);
    } else {
      Link link = new Link();
      link.setUrl(url);
      link.setDescriptor(descriptor);
      new InsertLinkTask().execute(link);
    }
  }


  private static class InsertLinkTask extends AsyncTask<Link, Void, List<Long>> {


    @Override
    protected List<Long> doInBackground(Link... links) {
      return LinkOrganizerDB.getInstance().getLinkDao().insert(links);
    }
  }
}
