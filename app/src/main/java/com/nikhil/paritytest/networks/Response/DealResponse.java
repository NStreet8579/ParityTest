package com.nikhil.paritytest.networks.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DealResponse implements Serializable {


    @SerializedName("seo_setting")
    @Expose
    public SeoSetting seoSetting;
    @SerializedName("deals")
    @Expose
    public Deals deals;
    private final static long serialVersionUID = 5068904878316620041L;


    public class Datum implements Serializable
    {

        @SerializedName("id")
        @Expose
        public Long id;
        @SerializedName("title")
        @Expose
        public String title;
        @SerializedName("fpd_flag")
        @Expose
        public Boolean fpdFlag;
        @SerializedName("off_percent")
        @Expose
        public String offPercent;
        @SerializedName("current_price")
        @Expose
        public Long currentPrice;
        @SerializedName("original_price")
        @Expose
        public Long originalPrice;
        @SerializedName("image")
        @Expose
        public String image;
        @SerializedName("comments_count")
        @Expose
        public Long commentsCount;
        @SerializedName("all_posts_count")
        @Expose
        public Long allPostsCount;
        @SerializedName("created_at")
        @Expose
        public Long createdAt;
        @SerializedName("score")
        @Expose
        public Long score;
        @SerializedName("vote_value")
        @Expose
        public Long voteValue;
        @SerializedName("state")
        @Expose
        public String state;
        @SerializedName("description")
        @Expose
        public Object description;
        @SerializedName("share_url")
        @Expose
        public String shareUrl;
        @SerializedName("deal_url")
        @Expose
        public String dealUrl;
        @SerializedName("view_count")
        @Expose
        public Long viewCount;
        @SerializedName("vote_down_reason")
        @Expose
        public VoteDownReason voteDownReason;
        @SerializedName("vote_count")
        @Expose
        public Long voteCount;
        @SerializedName("fpd_suggestted")
        @Expose
        public Boolean fpdSuggestted;
        @SerializedName("front_page_suggestions_count")
        @Expose
        public Long frontPageSuggestionsCount;
        @SerializedName("merchant")
        @Expose
        public Merchant merchant;
        @SerializedName("user")
        @Expose
        public User user;
        private final static long serialVersionUID = 985043174386382291L;

    }

    public class Deals implements Serializable
    {

        @SerializedName("total_count")
        @Expose
        public Long totalCount;
        @SerializedName("data")
        @Expose
        public List<Datum> data = null;
        private final static long serialVersionUID = 4391159710144247000L;

    }





    public class Merchant implements Serializable
    {

        @SerializedName("id")
        @Expose
        public Long id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("image")
        @Expose
        public String image;
        @SerializedName("permalink")
        @Expose
        public String permalink;
        @SerializedName("recommendation")
        @Expose
        public Long recommendation;
        @SerializedName("recommendation_flag")
        @Expose
        public Boolean recommendationFlag;
        @SerializedName("average_rating")
        @Expose
        public String averageRating;
        private final static long serialVersionUID = -2089145209164264134L;

    }

    public class SeoSetting implements Serializable
    {

        @SerializedName("title")
        @Expose
        public String title;
        @SerializedName("description")
        @Expose
        public String description;
        @SerializedName("web_url")
        @Expose
        public String webUrl;
        private final static long serialVersionUID = 2168098646341933141L;

    }

    public class User implements Serializable
    {

        @SerializedName("id")
        @Expose
        public Long id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("image")
        @Expose
        public String image;
        @SerializedName("rank")
        @Expose
        public String rank;
        @SerializedName("current_dimes")
        @Expose
        public Long currentDimes;
        @SerializedName("karma")
        @Expose
        public Long karma;
        @SerializedName("fpd_count")
        @Expose
        public Long fpdCount;
        private final static long serialVersionUID = -8821985140643567507L;

    }

    public class VoteDownReason implements Serializable
    {

        @SerializedName("Better price elsewhere")
        @Expose
        public Long betterPriceElsewhere;
        @SerializedName("Invalid/User Specific Coupon/Deal")
        @Expose
        public Long invalidUserSpecificCouponDeal;
        @SerializedName("Product not good/not worth the price")
        @Expose
        public Long productNotGoodNotWorthThePrice;
        @SerializedName("Referral link")
        @Expose
        public Long referralLink;
        @SerializedName("Self Promotion")
        @Expose
        public Long selfPromotion;
        @SerializedName("Other reasons")
        @Expose
        public Long otherReasons;
        @SerializedName("Repost")
        @Expose
        public Long repost;
        @SerializedName("Bad Reviews for Website/Seller")
        @Expose
        public Long badReviewsForWebsiteSeller;
        private final static long serialVersionUID = 5547822070710352413L;

    }
}
