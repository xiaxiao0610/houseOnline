package com.xl.houseonline.cos;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.Bucket;
import com.qcloud.cos.model.COSObjectSummary;
import com.qcloud.cos.model.ListObjectsRequest;
import com.qcloud.cos.model.ObjectListing;
import com.qcloud.cos.region.Region;

import java.util.List;

public class InitCos {

    // 1 初始化用户身份信息（secretId, secretKey）。


// 这里建议设置使用 https 协议


//  clientConfig.setHttpProtocol(HttpProtocol.https);
    // 3 生成 cos 客户端。


    public static void main(String[] args) {
        String secretId = "AKIDtZzA7o7ZdkcEbk8JjvvfArLaaKqBE5nI";
        String secretKey = "OXQ4WkjbFdmgLp20pRovoRt51oNfhiT3";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的地域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
// clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("COS_REGION");
        ClientConfig clientConfig = new ClientConfig(region);
        clientConfig.setHttpProtocol(HttpProtocol.https);
        COSClient cosClient = new COSClient(cred, clientConfig);
        List<Bucket> buckets = cosClient.listBuckets();
//        for (Bucket bucketElement : buckets) {
//            String bucketName = bucketElement.getName();
//            String bucketLocation = bucketElement.getLocation();
//            System.out.println(bucketName);
//            System.out.println(bucketLocation);
//        }
//    }
        // Bucket的命名格式为 BucketName-APPID ，此处填写的存储桶名称必须为此格式
        String bucketName = "xl-1258185807";
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
// 设置bucket名称
        listObjectsRequest.setBucketName(bucketName);
// prefix表示列出的object的key以prefix开始
        listObjectsRequest.setPrefix("xl/");
// deliter表示分隔符, 设置为/表示列出当前目录下的object, 设置为空表示列出所有的object
//        listObjectsRequest.setDelimiter("");
// 设置最大遍历出多少个对象, 一次listobject最大支持1000
        listObjectsRequest.setMaxKeys(1000);
        ObjectListing objectListing = null;
        do {
            try {
                objectListing = cosClient.listObjects(listObjectsRequest);
            } catch (CosServiceException e) {
                e.printStackTrace();
                return;
            } catch (CosClientException e) {
                e.printStackTrace();
                return;
            }
            // common prefix表示表示被delimiter截断的路径, 如delimter设置为/, common prefix则表示所有子目录的路径
            List<String> commonPrefixs = objectListing.getCommonPrefixes();
            // object summary表示所有列出的object列表
            List<COSObjectSummary> cosObjectSummaries = objectListing.getObjectSummaries();
            for (COSObjectSummary cosObjectSummary : cosObjectSummaries) {
                // 文件的路径key
                String key = cosObjectSummary.getKey();
                System.out.println(key);
                // 文件的etag
                String etag = cosObjectSummary.getETag();
                // 文件的长度
                long fileSize = cosObjectSummary.getSize();
                // 文件的存储类型
                String storageClasses = cosObjectSummary.getStorageClass();
            }
            String nextMarker = objectListing.getNextMarker();
            listObjectsRequest.setMarker(nextMarker);
        } while (objectListing.isTruncated());

    }
}