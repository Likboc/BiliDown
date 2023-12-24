import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://api.bilibili.com/x/web-interface/view/detail?bvid=BV1Mt4y1X718");
        URL url1 = new URL("https://api.bilibili.com/x/player/playurl?cid=1376711108&bvid=BV1HQ4y137H4&qn=32&type=&otype=json&fnver=0&fnval=4048&fourk=1");
        URL url2 = new URL("https://cn-jsnj-fx-02-01.bilivideo.com/upgcxcode/08/11/1376711108/1376711108-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfqXBvEqxTEto8BTrNvN0GvT90W5JZMkX_YN0MvXg8gNEV4NC8xNEV4N03eN0B5tZlqNxTEto8BTrNvNeZVuJ10Kj_g2UB02J0mN0B5tZlqNCNEto8BTrNvNC7MTX502C8f2jmMQJ6mqF2fka1mqx6gqj0eN0B599M=\u0026uipk=5\u0026nbs=1\u0026deadline=1703405041\u0026gen=playurlv2\u0026os=bcache\u0026oi=3737023947\u0026trid=0000f28f621b65fc45e8a04ae1a07b32a1a9u\u0026mid=692350792\u0026platform=pc\u0026upsig=ae9db284cdd807c2b24b0fd3971eaaab\u0026uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform\u0026cdnid=3851\u0026bvc=vod\u0026nettype=0\u0026orderid=0,3\u0026buvid=AB32223F-EF64-9568-44D6-885367286F5670742infoc\u0026build=0\u0026f=u_0_0\u0026agrr=1\u0026bw=53204\u0026np=151355618\u0026logo=80000000");
        HttpURLConnection connection = (HttpURLConnection) url2.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty();

        InputStream inputStream =connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String b;
        while((b=bufferedReader.readLine())!= null) {
            System.out.println(b);
        }


    }
}
