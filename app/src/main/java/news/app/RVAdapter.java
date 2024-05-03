package news.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private List<News> newsItemList;
    private Context context;
    private OnItemClickListener listener;

    public RVAdapter(List<News> newsItemList, Context context) {
        this.newsItemList = newsItemList;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.news_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.ViewHolder holder, int position) {
        holder.title.setText(newsItemList.get(position).getNewsTitle());
        holder.imageButton.setImageBitmap(newsItemList.get(position).getNewsIcon());

        holder.itemView.setOnClickListener(view -> {
            if (listener != null) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageButton imageButton;
        LinearLayout MainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.headlines);
            imageButton = itemView.findViewById(R.id.image);
            MainLayout = itemView.findViewById(R.id.main_layout);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
