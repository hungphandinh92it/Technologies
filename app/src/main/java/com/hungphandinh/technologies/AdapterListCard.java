package com.hungphandinh.technologies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

import java.util.List;

/**
 * Created by hungphandinh on 05-Jan-15.
 */
public class AdapterListCard extends RecyclerView.Adapter<AdapterListCard.CardViewHolder>{
    enum CARD_TYPE{
        NORMAL, MINI;
    };
    private List<CardData> mCardDatas ;
    private CARD_TYPE mCardType;
    public AdapterListCard(List<CardData> cardDatas){
        this(cardDatas, CARD_TYPE.NORMAL);
    }

    public void setCardType(CARD_TYPE mCardType) {
        this.mCardType = mCardType;
    }

    public AdapterListCard(List<CardData> mCardDatas, CARD_TYPE mCardType) {
        this.mCardDatas = mCardDatas;
        this.mCardType = mCardType;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        CardData data = mCardDatas.get(position);
        SmartImageView imgCard = null;
        switch (mCardType){
            case MINI:
                holder.imgCard.setVisibility(View.GONE);
                holder.txtContent.setVisibility(View.GONE);

                holder.imgCardMini.setVisibility(View.VISIBLE);
                holder.txtTitle.setTextSize(16);

                imgCard = holder.imgCardMini;
                break;
            case NORMAL:
                holder.imgCard.setVisibility(View.VISIBLE);
                holder.txtContent.setVisibility(View.VISIBLE);

                holder.imgCardMini.setVisibility(View.GONE);
                holder.txtTitle.setTextSize(20);

                imgCard = holder.imgCard;
                break;
        }
        holder.txtTitle.setText(data.txtTitle);
        if(data.imgLink!=""&&data.imgLink!=null){
            imgCard.setVisibility(View.VISIBLE);
            imgCard.setBackgroundColor(data.imgIcon);
            imgCard.setImageUrl(data.imgLink);
            holder.txtContent.setText("");
        } else {
            imgCard.setImageBitmap(null);
            imgCard.setVisibility(View.GONE);
            holder.txtContent.setText(data.txtContent);
        }

        holder.txtPage.setText(data.txtPage);
        holder.txtTime.setText(data.txtTime);
    }

    @Override
    public int getItemCount() {
        return mCardDatas.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;
        TextView txtContent;
        TextView txtPage;
        TextView txtTime;
        SmartImageView imgCard;
        SmartImageView imgCardMini;
        ImageView imgCardIcon;
        public CardViewHolder(View itemView) {
            super(itemView);
            txtContent = (TextView) itemView.findViewById(R.id.txtContent);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtPage = (TextView) itemView.findViewById(R.id.txtPageCard);
            txtTime = (TextView) itemView.findViewById(R.id.txtTimeCard);

            imgCard = (SmartImageView) itemView.findViewById(R.id.imgCard);
            imgCardIcon = (ImageView) itemView.findViewById(R.id.imgIconCard);
            imgCardMini = (SmartImageView) itemView.findViewById(R.id.imgCardMini);
        }
    }

    public void setCardDatas(List<CardData> datas) {
        this.mCardDatas = datas;
    }
}
