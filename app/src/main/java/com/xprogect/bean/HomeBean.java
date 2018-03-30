package com.xprogect.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/3/28
 * function：
 */

public class HomeBean implements Serializable {

    /**
     * newsList : [{"id":332,"title":"财经早餐2018年3月30日","tags":null,"cover":{"src":"http://file.rongtousky.com/rttx/file/201803300902334404217.jpg","width":149,"height":111},"description":null,"releasedTime":"2018年03月30日 09:02","displayType":1,"link":"rttx://news?url=http%3A%2F%2Fwww.rongtousky.com%3A80%2Fapp%2Farticle%3Fid%3D332%26type%3D2&shareUrl=http%3A%2F%2Fwww.rongtousky.com%3A80%2Fapp%2Farticle%3Fid%3D332%26type%3D2&shareTitle=%E8%B4%A2%E7%BB%8F%E6%97%A9%E9%A4%902018%E5%B9%B43%E6%9C%8830%E6%97%A5&shareImage=http%3A%2F%2Ffile.rongtousky.com%2Frttx%2Ffile%2F201803300902205136573.jpg&shareText=%E5%A4%96%E7%AE%A1%E5%B1%80%EF%BC%9A%E6%88%AA%E8%87%B32017%E5%B9%B412%E6%9C%88%E6%9C%AB%EF%BC%8C%E6%88%91%E5%9B%BD%E5%AF%B9%E5%A4%96%E9%87%91%E8%9E%8D%E8%B5%84%E4%BA%A769256%E4%BA%BF%E7%BE%8E%E5%85%83%EF%BC%8C%E5%AF%B9%E5%A4%96%E8%B4%9F%E5%80%BA51115%E4%BA%BF%E7%BE%8E%E5%85%83%EF%BC%8C%E5%AF%B9%E5%A4%96%E5%87%80%E8%B5%84%E4%BA%A718141%E4%BA%BF%E7%BE%8E%E5%85%83%E3%80%82&newsId=332&newsType=0","grade":1},{"id":331,"title":"中国祭出原油期货，旨在定价权之争","tags":null,"cover":{"src":"http://file.rongtousky.com/rttx/file/201803291634379597231.jpg","width":484,"height":300},"description":null,"releasedTime":"2018年03月29日 16:40","displayType":1,"link":"rttx://news?url=http%3A%2F%2Fwww.rongtousky.com%3A80%2Fapp%2Farticle%3Fid%3D331%26type%3D2&shareUrl=http%3A%2F%2Fwww.rongtousky.com%3A80%2Fapp%2Farticle%3Fid%3D331%26type%3D2&shareTitle=%E4%B8%AD%E5%9B%BD%E7%A5%AD%E5%87%BA%E5%8E%9F%E6%B2%B9%E6%9C%9F%E8%B4%A7%EF%BC%8C%E6%97%A8%E5%9C%A8%E5%AE%9A%E4%BB%B7%E6%9D%83%E4%B9%8B%E4%BA%89&shareImage=http%3A%2F%2Ffile.rongtousky.com%2Frttx%2Ffile%2F201803291640124428482.jpg&shareText=%E6%9C%AC%E5%91%A8%EF%BC%8C%E4%B8%80%E5%9C%BA%E5%85%B7%E6%9C%89%E9%87%8C%E7%A8%8B%E7%A2%91%E6%84%8F%E4%B9%89%E7%9A%84%E5%A4%A7%E4%BA%8B%E5%8F%91%E7%94%9F%E4%BA%86...&newsId=331&newsType=0","grade":1}]
     * popProductList : [{"id":2,"title":"新材料","desc":"本基金投资于江西东海蓝玉光电科技有限公司的股权，扩大经营成果，分享投资收益。","expectedRate":"浮动收益","link":"rttx://product?id=2"},{"id":3,"title":"","desc":"教育类项目","expectedRate":"纯浮动收益","link":"rttx://product?id=3"},{"id":5,"title":"在严格控制风险的前提下，通过积极主动的参与企业管理，帮助企业制定适应市场需求的发展战略，对企业的经营和管理进行改进，力争为基金投资人提供稳健持续增长的投资收益。","desc":"新材料","expectedRate":"浮动收益","link":"rttx://product?id=5"},{"id":6,"title":"","desc":"新材料","expectedRate":"浮动收益","link":"rttx://product?id=6"}]
     * liveList : [{"id":3,"title":"博铸讲堂第五十三期《基金从业考试科目一第四章》","description":"29日下午2点准时开讲！","cover":{"src":"http://file.rongtousky.com/rttx/file/201803210953054413189.jpg","width":720,"height":417},"releasedTime":"2018-03-28 16:47:45","link":"rttx://web?url=http%3A%2F%2Fmlive8.inke.cn%2Fapp%2Fhot%2Flive%3Fuid%3D539867061%26liveid%3D1514872000355195"}]
     * hotProductList : [{"id":7,"name":"博铸蓝宝石三号私募股权投资基金","tags":"hot","type":"finance","period":"1年","remainAmt":"6000万元人民币","expectedRate":"浮动收益","rateDesc":"新材料","percent":0,"link":"rttx://product?id=7"},{"id":5,"name":"博铸蓝宝石二号私募股权投资基金","tags":"hot","type":"finance","period":"1年","remainAmt":"3000万元人民币","expectedRate":"浮动收益","rateDesc":"新材料","percent":0,"link":"rttx://product?id=5"}]
     * videoNewsList : [{"id":23,"title":"博铸讲堂第五十一期《基金从业考试科目一第三章》","keyword":"基金从业考试","cover":{"src":"http://file.rongtousky.com/rttx/file/201803271341199144306.jpg","width":720,"height":417},"description":"本课题将围绕基金从业考试所涵盖的知识内容开讲","link":"rttx://video?id=23&newsId=23&newsType=1","releasedTime":"2018-03-27","grade":0},{"id":22,"title":"博铸讲堂第五十期《投资区块链的分析》","keyword":"区块链","cover":{"src":"http://file.rongtousky.com/rttx/file/201803271256305276747.jpg","width":720,"height":417},"description":"本期的课题将分为以下几部分：\r\n1.什么是区块链\r\n2.区块链的前景\r\n3.投资区块链的风险","link":"rttx://video?id=22&newsId=22&newsType=1","releasedTime":"2018-03-27","grade":0}]
     * isEnd : true
     */

    @SerializedName("isEnd")
    private boolean isEnd;
    @SerializedName("newsList")
    private List<NewsListBean> newsList;
    @SerializedName("popProductList")
    private List<PopProductListBean> popProductList;
    @SerializedName("liveList")
    private List<LiveListBean> liveList;
    @SerializedName("hotProductList")
    private List<HotProductListBean> hotProductList;
    @SerializedName("videoNewsList")
    private List<VideoNewsListBean> videoNewsList;

    public boolean isIsEnd() {
        return isEnd;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public List<NewsListBean> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsListBean> newsList) {
        this.newsList = newsList;
    }

    public List<PopProductListBean> getPopProductList() {
        return popProductList;
    }

    public void setPopProductList(List<PopProductListBean> popProductList) {
        this.popProductList = popProductList;
    }

    public List<LiveListBean> getLiveList() {
        return liveList;
    }

    public void setLiveList(List<LiveListBean> liveList) {
        this.liveList = liveList;
    }

    public List<HotProductListBean> getHotProductList() {
        return hotProductList;
    }

    public void setHotProductList(List<HotProductListBean> hotProductList) {
        this.hotProductList = hotProductList;
    }

    public List<VideoNewsListBean> getVideoNewsList() {
        return videoNewsList;
    }

    public void setVideoNewsList(List<VideoNewsListBean> videoNewsList) {
        this.videoNewsList = videoNewsList;
    }

    public static class NewsListBean implements Serializable {
        /**
         * id : 332
         * title : 财经早餐2018年3月30日
         * tags : null
         * cover : {"src":"http://file.rongtousky.com/rttx/file/201803300902334404217.jpg","width":149,"height":111}
         * description : null
         * releasedTime : 2018年03月30日 09:02
         * displayType : 1
         * link : rttx://news?url=http%3A%2F%2Fwww.rongtousky.com%3A80%2Fapp%2Farticle%3Fid%3D332%26type%3D2&shareUrl=http%3A%2F%2Fwww.rongtousky.com%3A80%2Fapp%2Farticle%3Fid%3D332%26type%3D2&shareTitle=%E8%B4%A2%E7%BB%8F%E6%97%A9%E9%A4%902018%E5%B9%B43%E6%9C%8830%E6%97%A5&shareImage=http%3A%2F%2Ffile.rongtousky.com%2Frttx%2Ffile%2F201803300902205136573.jpg&shareText=%E5%A4%96%E7%AE%A1%E5%B1%80%EF%BC%9A%E6%88%AA%E8%87%B32017%E5%B9%B412%E6%9C%88%E6%9C%AB%EF%BC%8C%E6%88%91%E5%9B%BD%E5%AF%B9%E5%A4%96%E9%87%91%E8%9E%8D%E8%B5%84%E4%BA%A769256%E4%BA%BF%E7%BE%8E%E5%85%83%EF%BC%8C%E5%AF%B9%E5%A4%96%E8%B4%9F%E5%80%BA51115%E4%BA%BF%E7%BE%8E%E5%85%83%EF%BC%8C%E5%AF%B9%E5%A4%96%E5%87%80%E8%B5%84%E4%BA%A718141%E4%BA%BF%E7%BE%8E%E5%85%83%E3%80%82&newsId=332&newsType=0
         * grade : 1
         */

        @SerializedName("id")
        private int id;
        @SerializedName("title")
        private String title;
        @SerializedName("tags")
        private String tags;
        @SerializedName("cover")
        private CoverBean cover;
        @SerializedName("description")
        private String description;
        @SerializedName("releasedTime")
        private String releasedTime;
        @SerializedName("displayType")
        private int displayType;
        @SerializedName("link")
        private String link;
        @SerializedName("grade")
        private int grade;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public CoverBean getCover() {
            return cover;
        }

        public void setCover(CoverBean cover) {
            this.cover = cover;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getReleasedTime() {
            return releasedTime;
        }

        public void setReleasedTime(String releasedTime) {
            this.releasedTime = releasedTime;
        }

        public int getDisplayType() {
            return displayType;
        }

        public void setDisplayType(int displayType) {
            this.displayType = displayType;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public static class CoverBean implements Serializable{
            /**
             * src : http://file.rongtousky.com/rttx/file/201803300902334404217.jpg
             * width : 149
             * height : 111
             */

            @SerializedName("src")
            private String src;
            @SerializedName("width")
            private int width;
            @SerializedName("height")
            private int height;

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }
    }

    public static class PopProductListBean implements Serializable{
        /**
         * id : 2
         * title : 新材料
         * desc : 本基金投资于江西东海蓝玉光电科技有限公司的股权，扩大经营成果，分享投资收益。
         * expectedRate : 浮动收益
         * link : rttx://product?id=2
         */

        @SerializedName("id")
        private int id;
        @SerializedName("title")
        private String title;
        @SerializedName("desc")
        private String desc;
        @SerializedName("expectedRate")
        private String expectedRate;
        @SerializedName("link")
        private String link;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getExpectedRate() {
            return expectedRate;
        }

        public void setExpectedRate(String expectedRate) {
            this.expectedRate = expectedRate;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }

    public static class LiveListBean implements Serializable{
        /**
         * id : 3
         * title : 博铸讲堂第五十三期《基金从业考试科目一第四章》
         * description : 29日下午2点准时开讲！
         * cover : {"src":"http://file.rongtousky.com/rttx/file/201803210953054413189.jpg","width":720,"height":417}
         * releasedTime : 2018-03-28 16:47:45
         * link : rttx://web?url=http%3A%2F%2Fmlive8.inke.cn%2Fapp%2Fhot%2Flive%3Fuid%3D539867061%26liveid%3D1514872000355195
         */

        @SerializedName("id")
        private int id;
        @SerializedName("title")
        private String title;
        @SerializedName("description")
        private String description;
        @SerializedName("cover")
        private CoverBeanX cover;
        @SerializedName("releasedTime")
        private String releasedTime;
        @SerializedName("link")
        private String link;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public CoverBeanX getCover() {
            return cover;
        }

        public void setCover(CoverBeanX cover) {
            this.cover = cover;
        }

        public String getReleasedTime() {
            return releasedTime;
        }

        public void setReleasedTime(String releasedTime) {
            this.releasedTime = releasedTime;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public static class CoverBeanX implements Serializable{
            /**
             * src : http://file.rongtousky.com/rttx/file/201803210953054413189.jpg
             * width : 720
             * height : 417
             */

            @SerializedName("src")
            private String src;
            @SerializedName("width")
            private int width;
            @SerializedName("height")
            private int height;

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }
    }

    public static class HotProductListBean implements Serializable{
        /**
         * id : 7
         * name : 博铸蓝宝石三号私募股权投资基金
         * tags : hot
         * type : finance
         * period : 1年
         * remainAmt : 6000万元人民币
         * expectedRate : 浮动收益
         * rateDesc : 新材料
         * percent : 0
         * link : rttx://product?id=7
         */

        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("tags")
        private String tags;
        @SerializedName("type")
        private String type;
        @SerializedName("period")
        private String period;
        @SerializedName("remainAmt")
        private String remainAmt;
        @SerializedName("expectedRate")
        private String expectedRate;
        @SerializedName("rateDesc")
        private String rateDesc;
        @SerializedName("percent")
        private int percent;
        @SerializedName("link")
        private String link;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public String getRemainAmt() {
            return remainAmt;
        }

        public void setRemainAmt(String remainAmt) {
            this.remainAmt = remainAmt;
        }

        public String getExpectedRate() {
            return expectedRate;
        }

        public void setExpectedRate(String expectedRate) {
            this.expectedRate = expectedRate;
        }

        public String getRateDesc() {
            return rateDesc;
        }

        public void setRateDesc(String rateDesc) {
            this.rateDesc = rateDesc;
        }

        public int getPercent() {
            return percent;
        }

        public void setPercent(int percent) {
            this.percent = percent;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }

    public static class VideoNewsListBean implements Serializable{
        /**
         * id : 23
         * title : 博铸讲堂第五十一期《基金从业考试科目一第三章》
         * keyword : 基金从业考试
         * cover : {"src":"http://file.rongtousky.com/rttx/file/201803271341199144306.jpg","width":720,"height":417}
         * description : 本课题将围绕基金从业考试所涵盖的知识内容开讲
         * link : rttx://video?id=23&newsId=23&newsType=1
         * releasedTime : 2018-03-27
         * grade : 0
         */

        @SerializedName("id")
        private int id;
        @SerializedName("title")
        private String title;
        @SerializedName("keyword")
        private String keyword;
        @SerializedName("cover")
        private CoverBeanXX cover;
        @SerializedName("description")
        private String description;
        @SerializedName("link")
        private String link;
        @SerializedName("releasedTime")
        private String releasedTime;
        @SerializedName("grade")
        private int grade;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public CoverBeanXX getCover() {
            return cover;
        }

        public void setCover(CoverBeanXX cover) {
            this.cover = cover;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getReleasedTime() {
            return releasedTime;
        }

        public void setReleasedTime(String releasedTime) {
            this.releasedTime = releasedTime;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public static class CoverBeanXX implements Serializable{
            /**
             * src : http://file.rongtousky.com/rttx/file/201803271341199144306.jpg
             * width : 720
             * height : 417
             */

            @SerializedName("src")
            private String src;
            @SerializedName("width")
            private int width;
            @SerializedName("height")
            private int height;

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }
    }
}
