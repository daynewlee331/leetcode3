package leetcode3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
	public static void main(String[] args){
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5);
		twitter.getNewsFeed(1);
	}
	
	HashMap<Integer, Set<Integer>> follow = null;
	int timer = 0;
	HashMap<Integer, LinkedList<Tweet>> userTweets = null;

	/** Initialize your data structure here. */
	public Twitter() {
		this.timer = 0;
		this.follow = new HashMap<Integer, Set<Integer>>();
		this.userTweets = new HashMap<Integer, LinkedList<Tweet>>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		Tweet t = new Tweet(tweetId, this.timer);
		if (this.userTweets.containsKey(userId)) this.userTweets.get(userId).add(t);
		else {
			LinkedList<Tweet> list = new LinkedList<>();
			list.add(t);
			this.userTweets.put(userId, list);
		}
		this.timer++;
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(new Comparator<Tweet>() {
			@Override
			public int compare(Tweet o1, Tweet o2) {
				return o2.timer - o1.timer;
			}
		});
		if (this.follow.containsKey(userId)) {
			for (Integer uid : this.follow.get(userId)) {
				if (this.userTweets.containsKey(uid))
					for (Tweet t : this.userTweets.get(uid)) pq.add(t);
			}
		}
		if (this.userTweets.containsKey(userId)) {
			for (Tweet t : this.userTweets.get(userId)) pq.add(t);
		}
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < 10 && !pq.isEmpty(); i++) res.add(pq.poll().id);
		return res;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		if(followerId == followeeId) return;
		if (this.follow.containsKey(followerId)) this.follow.get(followerId).add(followeeId);
		else {
			Set<Integer> set = new HashSet<Integer>();
			set.add(followeeId);
			this.follow.put(followerId, set);
		}
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		if (this.follow.containsKey(followerId)) this.follow.get(followerId).remove(followeeId);
	}

	class Tweet {
		int timer = 0;
		int id = 0;

		Tweet(int id, int time) {
			this.id = id;
			this.timer = time;
		}
	}
}
