package com.booboomx.rxjavaretrofitdemo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by booboomx on 17/2/6.
 */

public class NewsTimeLineBean implements Serializable {

    /**
     * date : 20170117
     * stories : [{"images":["http://pic3.zhimg.com/3c6e7c90b31e34636de95e8a7cbc307e.jpg"],"type":0,"id":9154689,"ga_prefix":"011713","title":"要命还是要梦？乐视和贾跃亭最终选择了命"},{"images":["http://pic2.zhimg.com/20cb9381ef039b21e4c6aa4a4749583d.jpg"],"type":0,"id":9155346,"ga_prefix":"011712","title":"大误 · 你敢和我比做题么？"},{"title":"什么样的家居风格不会过时？","ga_prefix":"011711","images":["http://pic2.zhimg.com/a7900b972ede223ca2e4cfe391e404c1.jpg"],"multipic":true,"type":0,"id":9152944},{"images":["http://pic4.zhimg.com/ff43d4ed81eb78daeb4971800e3310cb.jpg"],"type":0,"id":9154766,"ga_prefix":"011710","title":"如果强行让电动机停止转动，会发生什么？"},{"images":["http://pic3.zhimg.com/33dfa3d80bd7068ab0b92cda3c3396f2.jpg"],"type":0,"id":9154603,"ga_prefix":"011709","title":"聂隐娘与最后的遣唐使"},{"images":["http://pic4.zhimg.com/bdea539d001f1783cee64fb143aab8a3.jpg"],"type":0,"id":9154538,"ga_prefix":"011708","title":"央行：各位第三方支付，这个备付金我帮你们存起来吧"},{"images":["http://pic1.zhimg.com/a92b88a959b02720ffa8700c6492ae0c.jpg"],"type":0,"id":9154078,"ga_prefix":"011707","title":"星座、MBTI 和大五人格，什么样的人格测量才算准？"},{"images":["http://pic3.zhimg.com/577c8c713c7c126cd7b679c5397b7d72.jpg"],"type":0,"id":9153511,"ga_prefix":"011707","title":"谷歌 Material Design 从这些方面打破了我的思维局限"},{"images":["http://pic1.zhimg.com/da280b93b6a2dbef48e0f8ad953213a0.jpg"],"type":0,"id":9154698,"ga_prefix":"011707","title":"3D 动画盛行，迪士尼的 2D 动画师现在都做什么去了？"},{"images":["http://pic1.zhimg.com/84dee3f5591cdaaba35524f5568fabe0.jpg"],"type":0,"id":9152630,"ga_prefix":"011706","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic2.zhimg.com/2f1cff972588cd4947b1f376a9a39211.jpg","type":0,"id":9154689,"ga_prefix":"011713","title":"要命还是要梦？乐视和贾跃亭最终选择了命"},{"image":"http://pic3.zhimg.com/21b31a7b19c30f73d5d3b202adb1f682.jpg","type":0,"id":9154538,"ga_prefix":"011708","title":"央行：各位第三方支付，这个备付金我帮你们存起来吧"},{"image":"http://pic1.zhimg.com/7d8ae8e196786523a959ab25c4799660.jpg","type":0,"id":9153511,"ga_prefix":"011707","title":"谷歌 Material Design 从这些方面打破了我的思维局限"},{"image":"http://pic4.zhimg.com/a4e97822826679401cb65fb02889f0e3.jpg","type":0,"id":9154021,"ga_prefix":"011620","title":"低成本幸福指南：用牙齿咬住一根铅笔"},{"image":"http://pic3.zhimg.com/278394bde1b594113ecb37dd44e5897a.jpg","type":0,"id":9152858,"ga_prefix":"011618","title":"做一点好吃的肉酱，拌一大碗面"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["http://pic3.zhimg.com/3c6e7c90b31e34636de95e8a7cbc307e.jpg"]
         * type : 0
         * id : 9154689
         * ga_prefix : 011713
         * title : 要命还是要梦？乐视和贾跃亭最终选择了命
         * multipic : true
         */

        private int type;
        private long id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public long getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : http://pic2.zhimg.com/2f1cff972588cd4947b1f376a9a39211.jpg
         * type : 0
         * id : 9154689
         * ga_prefix : 011713
         * title : 要命还是要梦？乐视和贾跃亭最终选择了命
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}

