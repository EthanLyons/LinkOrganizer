package deepdive.cnm.edu.linkorganizer.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;
import deepdive.cnm.edu.linkorganizer.R;
import deepdive.cnm.edu.linkorganizer.model.entity.Link;
import java.util.List;


public class HistoryAdapter extends ArrayAdapter<Link> {

  public HistoryAdapter(@NonNull Context context, int resource) {
    super(context, resource);
  }

  public HistoryAdapter(@NonNull Context context, int resource,
      @NonNull List<Link> objects) {
    super(context, resource, objects);
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView,
      @NonNull ViewGroup parent) {
    Link link = getItem(position);
    View view = (convertView != null) ? convertView :
        LayoutInflater.from(getContext()).inflate(R.layout.link_list_item, parent, false);
    ((TextView) view.findViewById(R.id.link_url)).setText(link.getUrl());
    ((TextView) view.findViewById(R.id.descriptor_url)).setText(link.getDescriptor());
    return view;
  }

}

