import org.example.API.WbiEnc;
import org.example.util.HttpRequestUtil;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        String url = "https://cn-jsnj-fx-02-01.bilivideo.com/upgcxcode/33/09/1348330933/1348330933-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfqXBvEqxTEto8BTrNvN0GvT90W5JZMkX_YN0MvXg8gNEV4NC8xNEV4N03eN0B5tZlqNxTEto8BTrNvNeZVuJ10Kj_g2UB02J0mN0B5tZlqNCNEto8BTrNvNC7MTX502C8f2jmMQJ6mqF2fka1mqx6gqj0eN0B599M=\u0026uipk=5\u0026nbs=1\u0026deadline=1703581835\u0026gen=playurlv2\u0026os=bcache\u0026oi=3737023947\u0026trid=0000937d8848734844d8814fac059577bc1du\u0026mid=692350792\u0026platform=pc\u0026upsig=4e46b3c0a4f444cadaaafd8891c9a41a\u0026uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform\u0026cdnid=3851\u0026bvc=vod\u0026nettype=0\u0026orderid=0,3\u0026buvid=AB32223F-EF64-9568-44D6-885367286F5670742infoc\u0026build=0\u0026f=u_0_0\u0026agrr=1\u0026bw=44271\u0026np=151355618\u0026logo=80000000";
        String real_url = WbiEnc.setWrid(WbiEnc.setWts(url));
        String a1 = "https://cn-jsnj-fx-02-01.bilivideo.com/upgcxcode/33/09/1348330933/1348330933-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfqXBvEqxTEto8BTrNvN0GvT90W5JZMkX_YN0MvXg8gNEV4NC8xNEV4N03eN0B5tZlqNxTEto8BTrNvNeZVuJ10Kj_g2UB02J0mN0B5tZlqNCNEto8BTrNvNC7MTX502C8f2jmMQJ6mqF2fka1mqx6gqj0eN0B599M=\u0026uipk=5\u0026nbs=1\u0026deadline=1703593254\u0026gen=playurlv2\u0026os=bcache\u0026oi=1880743779\u0026trid=0000b93eed1c18c740fb8a83f2903e5dc5f3u\u0026mid=0\u0026platform=pc\u0026upsig=253a9823d3b6db89a152209c5c4e7296\u0026uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform\u0026cdnid=3851\u0026bvc=vod\u0026nettype=0\u0026orderid=0,3\u0026buvid=\u0026build=0\u0026f=u_0_0\u0026agrr=1\u0026bw=44271\u0026np=151355618\u0026logo=80000000";

        String test = "https://api.bilibili.com/x/player/wbi/playurl?cid=1348330933&bvid=BV12H4y117d8&qn=32";
        String turl = WbiEnc.setWrid(WbiEnc.setWts(test));
        String res = HttpRequestUtil.getStatus(a1);
        System.out.println(res);
    }
}
