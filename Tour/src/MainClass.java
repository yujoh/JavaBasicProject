import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		RevCategoryData[] rec=recCategory();
		System.out.println("=========�������� ��=========");
		for(RevCategoryData r:rec) {
			System.out.println(r.num+"."+r.title);
			System.out.println("���� : "+r.explain);
		}
		
		Scanner scan=new Scanner(System.in);
		System.out.print("������ ���� (1~12) : ");
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
        
        String s1="����";
        for(int b=0;b<tel_dt.size();b++){
        	String s=tel_dt.get(b).text();
        	if(s.equals("��ȭ��ȣ")){
	        	s1=tel.get(b).text();
	        }  	
        }
        System.out.println("====================�˻����========================");
        System.out.println(index+".�̸� : "+name.text());
		System.out.println("���� : "+location.text());
		System.out.println("ã�ư��� ��� : "+way.text());
		System.out.println("��ȭ��ȣ : "+s1);
		System.out.println("����: "+img.attr("src"));
		System.out.println("��õ���� : "+recommend.text());
		System.out.println("���� ���ƿ� "+awesome.text()+" | ���ƿ� "+good.text()+" | ���ο��� "+aweful.text());
		System.out.println("==================================================");
	}
	
}
