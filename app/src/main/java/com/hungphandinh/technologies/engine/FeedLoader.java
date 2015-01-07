package com.hungphandinh.technologies.engine;

import java.util.List;

import com.hungphandinh.technologies.CardData;

import android.os.AsyncTask;

public abstract class FeedLoader extends
		AsyncTask<String, Integer, List<CardData>> {

	public static final int NO_CONTENT = 1;
	public static final int NULL_CONTENT = 0;

	@Override
	protected List<CardData> doInBackground(String... params) {
//		return new RssPaserApdapter(new RssParser()).parser(params[0]);
		return new ChannelRefresh().parser(params[0]);
	}

	@Override
	protected void onPostExecute(List<CardData> result) {
		if (result != null) {
			if (result.size() != 0) {
				onSuccess(result);
			} else {
				onError(NO_CONTENT);
			}
		} else {
			onError(NULL_CONTENT);
		}
	}

	public abstract void onSuccess(List<CardData> feedsListItems);

	public abstract void onError(int kind);
}
