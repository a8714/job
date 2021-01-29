package com.roo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;

@Component
public class SuProce implements PageProcessor {


    @Scheduled(fixedDelay = 1000)
    public void zb(){
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(new Proxy("106.14.43.64", 8080)));
        Spider.create(new SuProce()).addUrl("https://api.myip.com/").setDownloader(httpClientDownloader).run();
    }
    @Override
    public void process(Page page) {
        System.out.println(page.getHtml().toString());
    }

    private Site site = new Site();
    @Override
    public Site getSite() {
        return site;
    }


}
