package com.xdailiao.wechat.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
/**
 * 
 * @author viakiba
 *
 */
public class ClientCustomSSL {
	
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
    public static String sendtoWecat(String str,String url) throws Exception {
        KeyStore keyStore  = KeyStore.getInstance("PKCS12");
        FileInputStream instream = new FileInputStream(new File("c:/mp/1432719502.p12"));
        try {
            keyStore.load(instream, "1432719502".toCharArray());
        } finally {
            instream.close();
        }
        SSLContext sslcontext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, "1432719502".toCharArray())
                .build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[] { "TLSv1" },
                null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();
        StringBuffer sb = new StringBuffer(); 
        try {
            HttpPost httpPost = new HttpPost(url);
            StringEntity entity = new StringEntity(str, "utf-8");
            httpPost.setEntity(entity);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
            	 HttpEntity httpentity = response.getEntity();
                 if (httpentity != null) {
                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpentity.getContent()));
                     String text;
                     while ((text = bufferedReader.readLine()) != null) {
                        sb.append(text);
                     }
                 }
                 EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        return sb.toString();
    }
}
