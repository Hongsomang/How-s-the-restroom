package com.restroom.restroom.service;

import com.restroom.restroom.dao.PublicDataDao;
import com.restroom.restroom.model.Region;
import com.restroom.restroom.model.Restroom;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PublicDataServiceImpl implements PublicDataService{

    final PublicDataDao publicDataDao;

    public PublicDataServiceImpl(PublicDataDao publicDataDao) {
        this.publicDataDao = publicDataDao;
    }


    //초기화
    @Override
    public List<Restroom> reset(int categoryCode) throws IOException, NoSuchAlgorithmException, KeyManagementException {

        List<Restroom> list=getRestroomList(categoryCode);


        return list;
    }


    //화장싱 크롤링
    public List<Restroom> getRestroomList(int categoryCode) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        String code =getCode(categoryCode);
        String url="https://www.localdata.go.kr/lif/lifeCtacDataView.do";
        Map<String,String> data=new HashMap<>();
        data.put("localCode",code);
        data.put("sidoCode",code);
        data.put("opnEtcSvcId","12_04_01_E");

        setSSL();
        Document doc= Jsoup.connect(url).data(data).post();

        String totalText=doc.select(".tablecnt-area span").get(0).text().replaceAll(",","");
        List<Integer> pageList=getPageList(totalText);

        List<Restroom> list=new ArrayList<>();
        for(int page :pageList){
            data.put("pageIndex",Integer.toString(page));
            Document newDoc= Jsoup.connect(url).data(data).post();
            Elements tr= newDoc.select(".dataset-table table tbody .etctablemodal");


            for(int i=0 ;i<tr.size();i++){
                Restroom item=new Restroom();
                String name= tr.get(i).select("td:nth-child(2)").text();
                String address=tr.get(i).select("td:nth-child(3)").text();
                String time=tr.get(i).select("td:nth-child(4)").text();

               item.setSubCategoryCode(categoryCode);
               item.setName(name);
               item.setAddress(address);
               item.setTime(time);

               list.add(item);
            }
        }


        return list;
    }

    //지역별 코드 가져오기
    public String getCode(int categoryCode){
        String code="";

        switch (categoryCode){
            case 1:
                code= Region.SEOUL.getCode();
                break;
            case 2:
                code=Region.BUSAN.getCode();
                break;
            case 3:
                code=Region.DAEGU.getCode();
                break;
            case 4:
                code=Region.INCHEON.getCode();
                break;
            case 5:
                code=Region.GWANGJU.getCode();
                break;
            case 6:
                code=Region.DAEJEON.getCode();
                break;
            case 7:
                code=Region.ULSAN.getCode();
                break;
            case 8:
                code=Region.SEJONG.getCode();
                break;
            case 9:
                code=Region.GYEONGGI_DO.getCode();
                break;
            case 10:
                code=Region.GANGWON_DO.getCode();
                break;
            case 11:
                code=Region.CHUNGCHEONGBUK_DO.getCode();
                break;
            case 12:
                code=Region.CHUNGCHEONGNAM_DO.getCode();
                break;
            case 13:
                code=Region.JEOLLABUK_DO.getCode();
                break;
            case 14:
                code=Region.JEOLLANAM_DO.getCode();
                break;
            case 15:
                code=Region.GYEONGSANGBUK_DO.getCode();
                break;
            case 16:
                code=Region.GYEONGSANGNAM_DO.getCode();
                break;
            case 17:
                code=Region.JEJU_DO.getCode();
        }

        return code;
    }


    //페이지 개수 생성
    public List<Integer> getPageList (String totalText){
        List<Integer> list =new ArrayList<>();
        int total=Integer.parseInt(totalText);
        int pages=0;
        if(total % 30 >0){
            pages=total/30+1;
        }
        else{
            pages=total/30;
        }

        for(int i=1;i<=pages;i++){
            list.add(i);
        }

        return list;
    }


    //ssl인증서 비활성화
    public static void setSSL() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        // TODO Auto-generated method stub
                        return null;
                    }
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType)
                            throws CertificateException {
                        // TODO Auto-generated method stub

                    }
                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType)
                            throws CertificateException {
                        // TODO Auto-generated method stub
                    }
                }
        };
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }
}
