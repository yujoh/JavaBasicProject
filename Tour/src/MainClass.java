import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		RevCategoryData[] rec=recCategory();
		System.out.println("=========가볼만한 곳=========");
		for(RevCategoryData r:rec) {
			System.out.println(r.num+"."+r.title);
			System.out.println("설명 : "+r.explain);
		}
		
		Scanner scan=new Scanner(System.in);
		System.out.print("여행지 선택 (1~12) : ");
		int pick=scan.nextInt();
		reccomendDetail(pick,rec[pick-1].link);
	
		
		
	}
	
	static RevCategoryData[] recCategory() throws Exception{
		RevCategoryData[] rec=new RevCategoryData[12];

			Document doc=Jsoup.connect("http://info.hanatour.com/dest/list/place/1").get();			
			Elements title=doc.select("div.listArea strong.title");
			Elements explain=doc.select("div.listArea p.desc");
			Elements link=doc.select("div.listArea a");
		
			for(int j=0;j<12;j++) {
				RevCategoryData r=new RevCategoryData();
				r.num=j+1;
				r.title=title.get(j).text();
				r.explain=explain.get(j).text();
				r.link="http://info.hanatour.com"+link.get(j).attr("href");
				rec[j]=r;
			}		
		return rec;
	}
	
	static void reccomendDetail(int index,String link) throws Exception {
	
		Document doc=Jsoup.connect(link).get();
		Element name=doc.selectFirst("div.nd_spot_title_wrap h1.nd_spot_d_title");
		Element location=doc.selectFirst("div.nd_spot_info_wrap dd");
		Elements way=doc.select("div.nd_spot_info_wrap dd:last-child");
		Element img=doc.selectFirst("div.nd_spot_img_wrap img");			
		Element recommend=doc.selectFirst("div.nd_spot_cmt");
		Elements tel_dt=doc.select("div.nd_spot_info_wrap dl dt");
        Elements tel=doc.select("div.nd_spot_info_wrap dl dd");
        Elements awesome=doc.select("div.likeArea li.awesome i.count");
        Elements good=doc.select("div.likeArea li.good i.count");
        Elements aweful=doc.select("div.likeArea li.aweful i.count");
        
        String s1="없음";
        for(int b=0;b<tel_dt.size();b++){
        	String s=tel_dt.get(b).text();
        	if(s.equals("전화번호")){
	        	s1=tel.get(b).text();
	        }  	
        }
        System.out.println("====================검색결과========================");
        System.out.println(index+".이름 : "+name.text());
		System.out.println("지역 : "+location.text());
		System.out.println("찾아가는 방법 : "+way.text());
		System.out.println("전화번호 : "+s1);
		System.out.println("사진: "+img.attr("src"));
		System.out.println("추천이유 : "+recommend.text());
		System.out.println("완전 좋아요 "+awesome.text()+" | 좋아요 "+good.text()+" | 별로에요 "+aweful.text());
		System.out.println("==================================================");
	}
	
}
