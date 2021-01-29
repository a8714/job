package com.roo;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class JobProce implements PageProcessor {
    public void process(Page page) {
        //page.putField("h2",page.getHtml().css("h2#1-webmagic").all());
        page.putField("h2",page.getHtml().xpath("//div[@id=loading]/p").all());
    }
    private Site site = new Site();
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new JobProce()).addUrl("https://www.ayulong.cn/blog/14").addPipeline(new FilePipeline("C:\\Users\\GIGA\\Desktop\\service")).run();
    }
}
