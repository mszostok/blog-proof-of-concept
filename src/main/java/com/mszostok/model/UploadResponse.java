package com.mszostok.model;

import com.mszostok.configuration.StaticResourceConfig;

/**
 * Success image response model
 *
 * @author mszostok
 */
public class UploadResponse {

    private static final String IMG_TAG = "<img src=" + StaticResourceConfig.UPLOAD_URL.replace("**", "")
            + "/{path} alt=\"\" /> ";

    private final String message;
    private final String imgUrl;

    public UploadResponse(String message, String imgPath) {
        this.message = message;
        this.imgUrl = IMG_TAG.replace("{path}", imgPath);
    }

    public String getMessage() {
        return message;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    @Override
    public String toString() {
        return "UploadResponse{" +
                "message='" + message + '\'' +
                ", url='" + imgUrl + '\'' +
                '}';
    }
}
