package com.lr97128.tess.biz;

import java.io.File;

import org.junit.jupiter.api.Test;
import com.alibaba.fastjson.JSON;
import com.qcloud.image.ImageClient;
import com.qcloud.image.request.GeneralOcrRequest;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class TestUnit {

	/*
	 * 测试图像识别成文字，初级阶段，没有开启学习库
	 * 	只能识别纯文字的图片，如果图片中有其他内容，则识别为乱码
	 * 
	 * */
	@Test
	public void test1() throws Exception {
		ITesseract instance = new Tesseract();
		//如果未将tessdata放在根目录下需要指定绝对路径
        //instance.setDatapath("the absolute path of tessdata");
		//如果需要识别英文之外的语种，需要指定识别语种，并且需要将对应的语言包放进项目中
		//如:instance.setLanguage("chi_sim");
		// 指定识别图片
		File imgDir = new File("image/234.png");
		long startTime = System.currentTimeMillis();
		String ocrResult = instance.doOCR(imgDir);
		// 输出识别结果
		System.out.println("OCR Result: \n" 
		+ ocrResult + "\n 耗时：" + (System.currentTimeMillis() 
				- startTime) + "ms");
		
	}
	
	/*
	 * 测试功能：使用腾讯AI，识别图片上的文字
	 * 说明一：recognition.image.myqcloud.com/ocr/handwriting为手写体识别接口url，一定不要加http://
	 * 说明二：recognition.image.myqcloud.com/ocr/general为印刷体识别接口url，一定不要加http://
	 * */
	@Test
	public void test2() {
		String APPID = "1258217036";
		String SecretId = "AKID1ucDiezwCcI6LabFj6MBMMLHG6MRNGXu";
		String SecretKey = "PTgemjVM97wfCO7h6f6mRuJWt4yjIl5T";
		//bucketName是腾讯AI图片字体识别API要求传入的参数，但经过几次测试，发现它的值可以是任意字符串
//		String bucketName = "recognition.image.myqcloud.com/ocr/handwriting";   //手写体识别
//		String bucketName = "recognition.image.myqcloud.com/ocr/general";   //印刷体识别
		String bucketName = "bucketName";
		String url = ImageClient.NEW_DOMAIN_recognition_image_myqcloud_com;
		//ImageClient.NEW_DOMAIN_recognition_image_myqcloud_com就是recognition.image.myqcloud.com
		ImageClient imageClient = new ImageClient(APPID, SecretId, SecretKey,url);
		//从demo.java上来看，貌似取消了手写体识别的方法.
		GeneralOcrRequest request = new GeneralOcrRequest(bucketName, 
				"http://119.29.105.155/wx/123.jpg");
		try {
			String result = imageClient.generalOcr(request);
			Character obj = JSON.parseObject(result, Character.class);
			Item[] items = obj.getData().getItems();
			for (Item item : items) {
				String macaddress = item.getItemstring();
//				if (macaddress.toUpperCase().contains("CM")) { //CM MAC: 5887E2A8C2F2
				if (macaddress.contains("cm") || macaddress.contains("CM")
						|| macaddress.contains("Cm") || macaddress.contains("cM")) {
					//CM MAC: 5887E2A8C2F2
					System.out.println(item.getItemstring());
				}
			}
//			obj.getData().getItems()[0].getItemstring();
//			System.out.println(obj.getData().getItems()[2].getItemstring());
//			System.out.print(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 将返回的文字，封装成真实的字符串
	 * */
	@Test
	public void test03() {
		System.out.println(ImageClient.NEW_DOMAIN_recognition_image_myqcloud_com);
		String json = "{\"code\":0,\"message\":\"OK\",\"data\":{\"recognize_warn_msg\":[],\"recognize_warn_code\":[],\"items\":[{\"itemcoord\":{\"x\":434,\"y\":320,\"width\":327,\"height\":25},\"words\":[{\"character\":\"S\",\"confidence\":0.9362868666648864},{\"character\":\"N\",\"confidence\":0.9455952644348145},{\"character\":\":\",\"confidence\":0.975440502166748},{\"character\":\"\",\"confidence\":1.0},{\"character\":\"9\",\"confidence\":0.9997251629829408},{\"character\":\"9\",\"confidence\":0.9997629523277284},{\"character\":\"7\",\"confidence\":0.9998929500579834},{\"character\":\"5\",\"confidence\":0.998645842075348},{\"character\":\"6\",\"confidence\":0.9999167919158936},{\"character\":\"6\",\"confidence\":0.9993995428085328},{\"character\":\"1\",\"confidence\":0.999637484550476},{\"character\":\"3\",\"confidence\":0.9999556541442872},{\"character\":\"3\",\"confidence\":0.9999126195907592},{\"character\":\"0\",\"confidence\":0.9996590614318848},{\"character\":\"0\",\"confidence\":0.999985694885254},{\"character\":\"0\",\"confidence\":0.9999760389328004},{\"character\":\"0\",\"confidence\":0.9999785423278808},{\"character\":\"0\",\"confidence\":0.999995231628418},{\"character\":\"0\",\"confidence\":0.9999794960021972},{\"character\":\"5\",\"confidence\":0.9999196529388428},{\"character\":\"7\",\"confidence\":0.9999344348907472}],\"itemstring\":\"SN: 99756613300000057\"},{\"itemcoord\":{\"x\":433,\"y\":411,\"width\":334,\"height\":25},\"words\":[{\"character\":\"S\",\"confidence\":0.9990578293800354},{\"character\":\"T\",\"confidence\":0.9943594336509704},{\"character\":\"B\",\"confidence\":0.9985742568969728},{\"character\":\"\",\"confidence\":1.0},{\"character\":\"M\",\"confidence\":0.9633293151855468},{\"character\":\"A\",\"confidence\":0.8593809008598328},{\"character\":\"C\",\"confidence\":0.8135583996772766},{\"character\":\":\",\"confidence\":0.6275402903556824},{\"character\":\"\",\"confidence\":1.0},{\"character\":\"8\",\"confidence\":0.9987480640411376},{\"character\":\"4\",\"confidence\":0.9991325736045836},{\"character\":\"6\",\"confidence\":0.9993252754211426},{\"character\":\"2\",\"confidence\":0.9995879530906676},{\"character\":\"2\",\"confidence\":0.986958920955658},{\"character\":\"3\",\"confidence\":0.9967890977859496},{\"character\":\"1\",\"confidence\":0.9993731379508972},{\"character\":\"5\",\"confidence\":0.9996962547302246},{\"character\":\"A\",\"confidence\":0.9843496680259704},{\"character\":\"A\",\"confidence\":0.9912516474723816},{\"character\":\"9\",\"confidence\":0.999195635318756},{\"character\":\"0\",\"confidence\":0.9995169639587402}],\"itemstring\":\"STB MAC: 84622315AA90\"},{\"itemcoord\":{\"x\":434,\"y\":501,\"width\":338,\"height\":24},\"words\":[{\"character\":\"C\",\"confidence\":0.9799563884735109},{\"character\":\"M\",\"confidence\":0.960647702217102},{\"character\":\"\",\"confidence\":1.0},{\"character\":\"M\",\"confidence\":0.8932746052742004},{\"character\":\"A\",\"confidence\":0.6920808553695679},{\"character\":\"C\",\"confidence\":0.9512506723403932},{\"character\":\":\",\"confidence\":0.9379260540008544},{\"character\":\"\",\"confidence\":1.0},{\"character\":\"5\",\"confidence\":0.9997585415840148},{\"character\":\"8\",\"confidence\":0.999614715576172},{\"character\":\"8\",\"confidence\":0.9997881054878236},{\"character\":\"7\",\"confidence\":0.9999639987945556},{\"character\":\"E\",\"confidence\":0.997423768043518},{\"character\":\"2\",\"confidence\":0.9986205101013184},{\"character\":\"A\",\"confidence\":0.9997580647468568},{\"character\":\"8\",\"confidence\":0.9983513355255128},{\"character\":\"C\",\"confidence\":0.9998206496238709},{\"character\":\"2\",\"confidence\":0.9994118213653565},{\"character\":\"F\",\"confidence\":0.8111476302146912},{\"character\":\"2\",\"confidence\":0.9981870055198668}],\"itemstring\":\"CM MAC: 5887E2A8C2F2\"},{\"itemcoord\":{\"x\":435,\"y\":589,\"width\":352,\"height\":26},\"words\":[{\"character\":\"W\",\"confidence\":0.99413400888443},{\"character\":\"I\",\"confidence\":0.96341472864151},{\"character\":\"F\",\"confidence\":0.9955345392227172},{\"character\":\"I\",\"confidence\":0.977711260318756},{\"character\":\"\",\"confidence\":1.0},{\"character\":\"M\",\"confidence\":0.9599703550338744},{\"character\":\"A\",\"confidence\":0.9305201172828674},{\"character\":\"C\",\"confidence\":0.9931855201721193},{\"character\":\":\",\"confidence\":0.8381572365760803},{\"character\":\"\",\"confidence\":1.0},{\"character\":\"5\",\"confidence\":0.9997645020484924},{\"character\":\"8\",\"confidence\":0.9997275471687316},{\"character\":\"8\",\"confidence\":0.999853014945984},{\"character\":\"7\",\"confidence\":0.9998397827148438},{\"character\":\"E\",\"confidence\":0.9982696771621704},{\"character\":\"2\",\"confidence\":0.999768316745758},{\"character\":\"A\",\"confidence\":0.9995391368865968},{\"character\":\"8\",\"confidence\":0.9985201954841614},{\"character\":\"B\",\"confidence\":0.9998034834861757},{\"character\":\"F\",\"confidence\":0.99791020154953},{\"character\":\"D\",\"confidence\":0.999777853488922},{\"character\":\"2\",\"confidence\":0.9993420243263244}],\"itemstring\":\"WIFI MAC: 5887E2A8BFD2\"},{\"itemcoord\":{\"x\":35,\"y\":548,\"width\":343,\"height\":135},\"words\":[{\"character\":\"1\",\"confidence\":0.8569043874740601},{\"character\":\"1\",\"confidence\":0.8225178718566895},{\"character\":\"1\",\"confidence\":0.8613858819007874},{\"character\":\"1\",\"confidence\":0.7833694815635681},{\"character\":\"l\",\"confidence\":0.266534686088562}],\"itemstring\":\"1111l\"},{\"itemcoord\":{\"x\":1358,\"y\":684,\"width\":23,\"height\":14},\"words\":[{\"character\":\"n\",\"confidence\":0.569238007068634}],\"itemstring\":\"n\"},{\"itemcoord\":{\"x\":1342,\"y\":912,\"width\":59,\"height\":33},\"words\":[{\"character\":\"云\",\"confidence\":0.762053906917572},{\"character\":\"z\",\"confidence\":0.4090554714202881}],\"itemstring\":\"云z\"},{\"itemcoord\":{\"x\":29,\"y\":938,\"width\":983,\"height\":124},\"words\":[{\"character\":\"1\",\"confidence\":0.7633122801780701},{\"character\":\"1\",\"confidence\":0.7270671129226685},{\"character\":\"1\",\"confidence\":0.7017043232917786},{\"character\":\"1\",\"confidence\":0.6958458423614502},{\"character\":\".\",\"confidence\":0.4654660224914551},{\"character\":\".\",\"confidence\":0.4932596981525421},{\"character\":\".\",\"confidence\":0.592778205871582},{\"character\":\".\",\"confidence\":0.7340375781059265},{\"character\":\".\",\"confidence\":0.5333365797996521},{\"character\":\"1\",\"confidence\":0.8643268942832947},{\"character\":\"1\",\"confidence\":0.679284393787384},{\"character\":\"1\",\"confidence\":0.7332273125648499},{\"character\":\"1\",\"confidence\":0.65324467420578},{\"character\":\"l\",\"confidence\":0.46142154932022097}],\"itemstring\":\"1111.....1111l\"}],\"session_id\":\"1258217036-2018313085\",\"angle\":88.58984375,\"class\":[]}}";
		Character obj = JSON.parseObject(json, Character.class);
		obj.getData().getItems()[0].getItemstring();
		System.out.println(obj.getData().getItems()[2].getItemstring());
//		String str = object.toString();
//		int indexOf1 = str.indexOf("itemstring");
//		int indexOf2 = str.indexOf("itemcoord");
//		String str1 = str.substring(indexOf1-1,indexOf2-2);
//		str = str.substring(indexOf2-1);
////		object = JSON.parse(object.toString());
//		System.out.println(object);
//		System.out.println(indexOf1);
//		System.out.println(str1);
//		System.out.println(str);
	}
	/*
	 * 测试object封装成JSON对象后的输出
	 * {"stu":{"gander":"男","stuId":11,"name":"liurui","age":12},"id":1}
	 * */
	@Test
	public void test04() {
		Student stu = new Student();
		stu.setStuId(11);
		stu.setName("liurui");
		stu.setAge(12);
		stu.setGander("男");
		Person person = new Person();
		person.setId(1);
		person.setStu(stu);
		Object json = JSON.toJSON(person);
		System.out.println(json.toString());
	}
}
