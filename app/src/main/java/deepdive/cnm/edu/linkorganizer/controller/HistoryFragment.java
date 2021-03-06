package deepdive.cnm.edu.linkorganizer.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import deepdive.cnm.edu.linkorganizer.R;
import deepdive.cnm.edu.linkorganizer.model.LinkOrganizerDB.Converters.DeleteLinkTask;
import deepdive.cnm.edu.linkorganizer.model.entity.Link;
import deepdive.cnm.edu.linkorganizer.model.LinkOrganizerDB;
import deepdive.cnm.edu.linkorganizer.view.HistoryAdapter;
import edu.cnm.deepdive.android.BaseFluentAsyncTask;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

  private ListView linkList;

  private List<Link> links;

  private HistoryAdapter adapter;

  public HistoryFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_history, container, false);
    linkList = view.findViewById(R.id.link_list);
    links = new ArrayList<>();
    adapter = new HistoryAdapter(getContext(), R.layout.link_list_item, links);
    linkList.setAdapter(adapter);
    registerForContextMenu(linkList);
    new SelectAllLinkTask()
        .setSuccessListener((links) -> {
          this.links.clear();
          this.links.addAll(links);
          adapter.notifyDataSetChanged();
        })
        .execute();
    return view;
  }


  @Override
  public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, v, menuInfo);
    getActivity().getMenuInflater().inflate(R.menu.context_option, menu);
  }



  @Override
  public boolean onContextItemSelected(MenuItem item) {
    boolean handled = true;
    AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
    int position = info.position;
    Link link = links.get(position);
    switch (item.getItemId()) {
      case R.id.delete_title:
        new DeleteLinkTask()
            .setSuccessListener((v) -> {
              links.remove(position);
              adapter.notifyDataSetChanged();
            })
            .execute(link);
        break;
      case R.id.edit_title:

        getFragmentManager().beginTransaction().replace(R.id.fragment_container, LinkFragment.newInstance(link.getId())).commit();
        LinkOrganizerDB.getInstance();
        break;
      case R.id.share_title:
        //TODO Create an intent for sharing
        break;
      default:
        handled = false;
    }
    return handled;
  }

  public static class SelectAllLinkTask
      extends BaseFluentAsyncTask<Void, Void, List<Link>, List<Link>> {

    @Override
    protected List<Link> perform(Void... voids) {
      return LinkOrganizerDB.getInstance().getLinkDao().getAllLinks();
    }

  }


}
