package com.hungphandinh.technologies;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hungphandinh.technologies.engine.FeedLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by hungphandinh on 05-Jan-15.
 */
public class FragmentListCards extends Fragment {
    public static final java.lang.String COLOR = "color";
    public static final java.lang.String LINK = "link";
    List<CardData> mCardDatas;
    SwipeRefreshLayout swipeRefreshLayout;
    private AdapterListCard.CARD_TYPE mCardType = AdapterListCard.CARD_TYPE.NORMAL;
    private AdapterListCard mAdapterListCard;
    private Context mContext;
    private RecyclerView recyclerView   ;

    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        @Override
        public void onRefresh() {
            loadFeed(link);
        }
    };
    private String link ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        int color = bundle.getInt(COLOR);
        link = bundle.getString(LINK);
        loadFeed(link);
    }

    private void loadFeed(String link) {
        FeedLoader feedLoader = new FeedLoader() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                if(swipeRefreshLayout!=null){
                    swipeRefreshLayout.setRefreshing(true);
                }
            }

            @Override
            public void onSuccess(List<CardData> feedsList) {
                if (mAdapterListCard != null) {
                    mCardDatas = feedsList;
                    mAdapterListCard.setCardDatas(feedsList);
                    mAdapterListCard.notifyDataSetChanged();
                }
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onError(int kind) {
                switch (kind) {
                    case FeedLoader.NO_CONTENT:
                        Toast.makeText(mContext, "NO CONTENT", Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case FeedLoader.NULL_CONTENT:
                        Toast.makeText(mContext, "NULL CONTENT", Toast.LENGTH_SHORT)
                                .show();
                        break;
                    default:
                        break;
                }
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        };
        feedLoader.execute(link);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_list, container, false);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setColorSchemeColors(0xFF3F51B5);
        recyclerView = (RecyclerView) view.findViewById(R.id.listCard);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        if(mCardDatas != null){
            mAdapterListCard = new AdapterListCard(mCardDatas, mCardType);
        } else {
            mAdapterListCard = new AdapterListCard(new ArrayList<CardData>(), mCardType);
        }

        recyclerView.setAdapter(mAdapterListCard);
        return view;
    }

    public void setCardType(AdapterListCard.CARD_TYPE cardType) {
        mCardType = cardType;
        if(mAdapterListCard!=null){
            mAdapterListCard.setCardType(cardType);
            mAdapterListCard.notifyDataSetChanged();
        }
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }
}
