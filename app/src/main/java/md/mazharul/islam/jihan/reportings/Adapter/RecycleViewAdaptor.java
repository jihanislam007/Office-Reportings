package md.mazharul.islam.jihan.reportings.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import md.mazharul.islam.jihan.reportings.R;

/**
 * Created by Jihan on 31-Oct-17.
 */

public class RecycleViewAdaptor extends RecyclerView.Adapter<RecycleViewAdaptor.ViewHolder> {

    ArrayList<Uri> alImage;
    ArrayList<Uri> crossImage;
    Context context;

    public RecycleViewAdaptor(Context context, ArrayList<Uri> alImage, ArrayList<Uri> crossImage) {
        super();
        this.context = context;
        this.alImage = alImage;
        this.crossImage = crossImage;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ricycl_view_image_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
      //  viewHolder.tvSpecies.setText(alName.get(i));
      /*  viewHolder.imgThumbnail.setImageResource(alImage.get(i));

        viewHolder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                  //  Toast.makeText(context, "#" + position + " - " + alName.get(position) + " (Long click)", Toast.LENGTH_SHORT).show();
                    context.startActivity(new Intent(context, RecycleViewAdaptor.class));
                } else {
                 //   Toast.makeText(context, "#" + position + " - " + alName.get(position), Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
       // return alName.size();
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public ImageView imgThumbnail;
        public ImageView crossimgThumbnail;
     //   public TextView tvSpecies;
        private ItemClickListener clickListener;
        private ItemClickListener crossclickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.img_thumbnail);
            crossimgThumbnail = (ImageView) itemView.findViewById(R.id.CancelPreviewOneimageView);
         //   tvSpecies = (TextView) itemView.findViewById(R.id.tv_species);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onClick(view, getPosition(), true);
            return true;
        }
    }

}