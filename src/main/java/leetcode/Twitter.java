package leetcode;

import java.util.*;

/**
 * Created by taku on 7/11/16.
 */
public class Twitter {
    private HashMap<Integer, HashSet<Integer>> followings;
    private HashMap<Integer, HashSet<Integer>> refollowings;
    private HashMap<Integer, SortedSet<Tweet>> timeSeriesPosts;
    private HashMap<Integer, List<Tweet>> tweetsByUser;
    private int time;

    private class Tweet implements Comparable<Tweet> {
        public int time;
        public int tweetId;

        Tweet(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Tweet)) {
                return false;
            }
            return tweetId == ((Tweet) other).tweetId;
        }

        @Override
        public int hashCode() {
            return tweetId;
        }

        @Override
        public int compareTo(Tweet other) {
            if (time == other.time) return 0;
            else if (time < other.time) return 1;
            else return -1;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        this.followings = new HashMap<>();
        this.refollowings = new HashMap<>();
        this.timeSeriesPosts = new HashMap<>();
        this.tweetsByUser = new HashMap<>();
        this.time = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(time, tweetId);
        this.time += 1;

        if (!tweetsByUser.containsKey(userId)) {
            tweetsByUser.put(userId, new LinkedList<>());
        }
        tweetsByUser.get(userId).add(tweet);
        if (!timeSeriesPosts.containsKey(userId)) {
            timeSeriesPosts.put(userId, new TreeSet<>());
        }
        timeSeriesPosts.get(userId).add(tweet);

        if (!refollowings.containsKey(userId)) {
            return;
        }
        HashSet<Integer> refollowing = refollowings.get(userId);
        for (int id : refollowing) {
            if (!timeSeriesPosts.containsKey(id)) {
                timeSeriesPosts.put(id, new TreeSet<>());
            }
            timeSeriesPosts.get(id).add(tweet);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if (!timeSeriesPosts.containsKey(userId)) {
            return new LinkedList<>();
        }
        int cnt = 0;
        List<Integer> tweets = new LinkedList<>();
        for (Tweet tweet : timeSeriesPosts.get(userId)) {
            tweets.add(tweet.tweetId);
            cnt++;
            if (cnt == 10) break;
        }
        return tweets;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (!this.followings.containsKey(followerId)) {
            this.followings.put(followerId, new HashSet<>());
        }
        if (!this.refollowings.containsKey(followeeId)) {
            this.refollowings.put(followeeId, new HashSet<>());
        }
        HashSet<Integer> following = this.followings.get(followerId);
        HashSet<Integer> refollowing = this.refollowings.get(followeeId);
        following.add(followeeId);
        refollowing.add(followerId);

        // Add all tweetId posted by followeeId to the timeline of followerId
        if (!tweetsByUser.containsKey(followeeId)) {
            return;
        }
        List<Tweet> tweets = tweetsByUser.get(followeeId);
        if (!timeSeriesPosts.containsKey(followerId)) {
            timeSeriesPosts.put(followerId, new TreeSet<>());
        }
        SortedSet<Tweet> timeline = timeSeriesPosts.get(followerId);
        for (Tweet tweet : tweets) {
            timeline.add(tweet);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;;
        if (!this.followings.containsKey(followerId) || !this.refollowings.containsKey(followeeId)) {
            return;
        }
        HashSet<Integer> following = this.followings.get(followerId);
        HashSet<Integer> refollowing = this.refollowings.get(followeeId);
        following.remove(followeeId);
        refollowing.remove(followerId);

        // Remove all tweedId posted by followeeId
        if (!tweetsByUser.containsKey(followeeId)) {
            return;
        }
        List<Tweet> tweets = tweetsByUser.get(followeeId);
        SortedSet<Tweet> timeline = timeSeriesPosts.get(followerId);
        for (Tweet tweet : tweets) {
            timeline.remove(tweet);
        }
    }
}
