package com.xprogect.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/3/28
 * function：
 */

public class HomeBean {

    /**
     * status : 1001
     * message : success
     * result : {"image":{"src":"","width":0,"height":0},"serviceTel":"0571-88034286"}
     */

    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("result")
    private ResultBean result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * image : {"src":"","width":0,"height":0}
         * serviceTel : 0571-88034286
         */

        @SerializedName("image")
        private ImageBean image;
        @SerializedName("serviceTel")
        private String serviceTel;

        public ImageBean getImage() {
            return image;
        }

        public void setImage(ImageBean image) {
            this.image = image;
        }

        public String getServiceTel() {
            return serviceTel;
        }

        public void setServiceTel(String serviceTel) {
            this.serviceTel = serviceTel;
        }

        public static class ImageBean {
            /**
             * src :
             * width : 0
             * height : 0
             */

            @SerializedName("src")
            private String src;
            @SerializedName("width")
            private String width;
            @SerializedName("height")
            private String height;

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }
        }
    }
}
