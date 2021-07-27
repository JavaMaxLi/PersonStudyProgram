package com.tasoft.syb.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ExaminationTest {
	public static void main(String[] args) throws Exception {

		JSONArray examinationList = new JSONArray();
		JSONObject item = new JSONObject();
		JSONArray optionList = new JSONArray();
		JSONObject option = new JSONObject();
		// ----------------------------111111-------------------------------------
		{
			item = new JSONObject();
			item.put("no", "1");
			item.put("type", "1");// 1 文本2图片
			item.put("msg", "现在正在做第1题，剩余9道题");
			item.put("process", "../img/examination/pro/pro1.png");
			item.put("title", "第一题");
			item.put("answer", "2");
			item.put("describe", "《四书五经》中的“五经”指的是：");

			optionList = new JSONArray();
			{
				option = new JSONObject();
				option.put("no", "0");
				option.put("pic", "txt0.png");
				option.put("value", "易经、道德经、诗经、春秋、礼记");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "1");
				option.put("pic", "txt1.png");
				option.put("value", "易经、道德经、尚书、春秋、礼记");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "2");
				option.put("pic", "txt2.png");
				option.put("value", "易经、诗经 、 尚书、春秋、礼记");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "3");
				option.put("pic", "txt3.png");
				option.put("value", "易经、道德经、诗经、春秋、尚书");
				optionList.add(option);
			}
			item.put("options", optionList);
			examinationList.add(item);
		}
		// ----------------------------2222222222-------------------------------------
		{
			item = new JSONObject();
			item.put("no", "2");
			item.put("type", "1");// 1 文本2图片
			item.put("msg", "现在正在做第2题，剩余8道题");
			item.put("process", "../img/examination/pro/pro2.png");
			item.put("title", "第二题");
			item.put("answer", "1");
			item.put("describe", "弘扬京剧的歌曲《说唱脸谱》中“蓝脸的_____盗御马，红脸的关公战长沙”，所唱的蓝脸人物是谁？");

			optionList = new JSONArray();
			{
				option = new JSONObject();
				option.put("no", "0");
				option.put("pic", "txt0.png");
				option.put("value", "多尔衮");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "1");
				option.put("pic", "txt1.png");
				option.put("value", "窦尔敦");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "2");
				option.put("pic", "txt2.png");
				option.put("value", "多尔敦");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "3");
				option.put("pic", "txt3.png");
				option.put("value", "敦尔敦");
				optionList.add(option);
			}
			item.put("options", optionList);
			examinationList.add(item);
		}
		// ------------------------------333333333333-----------------------------------
		{
			item = new JSONObject();
			item.put("no", "3");
			item.put("type", "1");// 1 文本2图片
			item.put("msg", "现在正在做第3题，剩余7道题");
			item.put("process", "../img/examination/pro/pro3.png");
			item.put("title", "第三题");
			item.put("answer", "3");
			item.put("describe", "“文房四宝”的四宝指的是哪四宝？");

			optionList = new JSONArray();
			{
				option = new JSONObject();
				option.put("no", "0");
				option.put("pic", "txt0.png");
				option.put("value", "毛笔、墨汁、镇纸、砚台");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "1");
				option.put("pic", "txt1.png");
				option.put("value", "毛笔、墨汁、宣纸、砚台");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "2");
				option.put("pic", "txt2.png");
				option.put("value", "毛笔、墨条、镇纸、砚台");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "3");
				option.put("pic", "txt3.png");
				option.put("value", "毛笔、墨条、宣纸、砚台");
				optionList.add(option);
			}
			item.put("options", optionList);
			examinationList.add(item);
		}
		// --------------------------------44444444444---------------------------------
		{
			item = new JSONObject();
			item.put("no", "4");
			item.put("type", "1");// 1 文本2图片
			item.put("msg", "现在正在做第4题，剩余6道题");
			item.put("process", "../img/examination/pro/pro4.png");
			item.put("title", "第四题");
			item.put("answer", "0");
			item.put("describe", "甲午战争中，北洋水师的最高统领是谁？");

			optionList = new JSONArray();
			{
				option = new JSONObject();
				option.put("no", "0");
				option.put("pic", "txt0.png");
				option.put("value", "丁汝昌");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "1");
				option.put("pic", "txt1.png");
				option.put("value", "李鸿章");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "2");
				option.put("pic", "txt2.png");
				option.put("value", "邓世昌");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "3");
				option.put("pic", "txt3.png");
				option.put("value", "袁世凯");
				optionList.add(option);
			}
			item.put("options", optionList);
			examinationList.add(item);
		}
		// --------------------------------55555555555555---------------------------------
		{
			item = new JSONObject();
			item.put("no", "1");
			item.put("type", "1");// 1 文本2图片
			item.put("msg", "现在正在做第5题，剩余5道题");
			item.put("process", "../img/examination/pro/pro5.png");
			item.put("title", "第五题");
			item.put("answer", "1");
			item.put("describe", "我国是哪一年加入世界贸易组织WTO的？");

			optionList = new JSONArray();
			{
				option = new JSONObject();
				option.put("no", "0");
				option.put("pic", "txt0.png");
				option.put("value", "2000年");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "1");
				option.put("pic", "txt1.png");
				option.put("value", "2001年");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "2");
				option.put("pic", "txt2.png");
				option.put("value", "2002年");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "3");
				option.put("pic", "txt3.png");
				option.put("value", "2003年");
				optionList.add(option);
			}
			item.put("options", optionList);
			examinationList.add(item);
		}
		// --------------------------------666666666666---------------------------------
		{
			item = new JSONObject();
			item.put("no", "6");
			item.put("type", "1");// 1 文本2图片
			item.put("msg", "现在正在做第6题，剩余4道题");
			item.put("process", "../img/examination/pro/pro6.png");
			item.put("title", "第一题");
			item.put("answer", "1");
			item.put("describe", "水是人体必需的营养元素，我们每天都离不开水，日常补水应该喝什么比较好？");

			optionList = new JSONArray();
			{
				option = new JSONObject();
				option.put("no", "0");
				option.put("pic", "txt0.png");
				option.put("value", "苏打水");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "1");
				option.put("pic", "txt1.png");
				option.put("value", "白开水");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "2");
				option.put("pic", "txt2.png");
				option.put("value", "纯净水");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "3");
				option.put("pic", "txt3.png");
				option.put("value", "自来水");
				optionList.add(option);
			}
			item.put("options", optionList);
			examinationList.add(item);
		}
		// ----------------------------7777777777777-------------------------------------
		{
			item = new JSONObject();
			item.put("no", "7");
			item.put("type", "2");// 1 文本2图片
			item.put("msg", "现在正在做第7题，剩余3道题");
			item.put("process", "../img/examination/pro/pro7.png");
			item.put("title", "第七题");
			item.put("answer", "3");
			item.put("describe", "中华人民共和国的第二任国家主席是？");

			optionList = new JSONArray();
			{
				option = new JSONObject();
				option.put("no", "0");
				option.put("pic", "pic0.png");
				option.put("value", "../img/examination/qus/7A.png");
				option.put("meno", "毛泽东");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "1");
				option.put("pic", "pic1.png");
				option.put("value", "../img/examination/qus/7B.png");
				option.put("meno", "邓小平");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "2");
				option.put("pic", "pic2.png");
				option.put("value", "../img/examination/qus/7C.png");
				option.put("meno", "华国锋");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "3");
				option.put("pic", "pic3.png");
				option.put("value", "../img/examination/qus/7D.png");
				option.put("meno", "刘少奇");
				optionList.add(option);
			}
			item.put("options", optionList);
			examinationList.add(item);
		}
		// ----------------------------88888888888-------------------------------------
		{
			item = new JSONObject();
			item.put("no", "8");
			item.put("type", "2");// 1 文本2图片
			item.put("msg", "现在正在做第8题，剩余2道题");
			item.put("process", "../img/examination/pro/pro8.png");
			item.put("title", "第八题");
			item.put("answer", "1");
			item.put("describe", "下面哪个不属于“除四害运动”中的四害？");

			optionList = new JSONArray();
			{
				option = new JSONObject();
				option.put("no", "0");
				option.put("pic", "pic0.png");
				option.put("value", "../img/examination/qus/8A.png");
				option.put("meno", "苍蝇");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "1");
				option.put("pic", "pic1.png");
				option.put("value", "../img/examination/qus/8B.png");
				option.put("meno", "蝗虫");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "2");
				option.put("pic", "pic2.png");
				option.put("value", "../img/examination/qus/8C.png");
				option.put("meno", "麻雀");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "3");
				option.put("pic", "pic3.png");
				option.put("value", "../img/examination/qus/8D.png");
				option.put("meno", "蚊子");
				optionList.add(option);
			}
			item.put("options", optionList);
			examinationList.add(item);
		}
		// ----------------------------9999999999-------------------------------------
		{
			item = new JSONObject();
			item.put("no", "9");
			item.put("type", "2");// 1 文本2图片
			item.put("msg", "现在正在做第9题，剩余1道题");
			item.put("process", "../img/examination/pro/pro9.png");
			item.put("title", "第九题");
			item.put("answer", "0");
			item.put("describe", "“两弹一星之父”指的是哪位科学家？");

			optionList = new JSONArray();
			{
				option = new JSONObject();
				option.put("no", "0");
				option.put("pic", "pic0.png");
				option.put("value", "../img/examination/qus/9A.png");
				option.put("meno", "邓稼先");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "1");
				option.put("pic", "pic1.png");
				option.put("value", "../img/examination/qus/9B.png");
				option.put("meno", "钱学森");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "2");
				option.put("pic", "pic2.png");
				option.put("value", "../img/examination/qus/9C.png");
				option.put("meno", "钱三强");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "3");
				option.put("pic", "pic3.png");
				option.put("value", "../img/examination/qus/9D.png");
				option.put("meno", "赵九章");
				optionList.add(option);
			}
			item.put("options", optionList);
			examinationList.add(item);
		}
		// ----------------------------7777777777777-------------------------------------
		{
			item = new JSONObject();
			item.put("no", "10");
			item.put("type", "2");// 1 文本2图片
			item.put("msg", "现在正在做第10题，剩余0道题");
			item.put("process", "../img/examination/pro/pro10.png");
			item.put("title", "第十题");
			item.put("answer", "1");
			item.put("describe", "下面哪张是第二套人民币十元的正面图像？");

			optionList = new JSONArray();
			{
				option = new JSONObject();
				option.put("no", "0");
				option.put("pic", "pic0.png");
				option.put("value", "../img/examination/qus/10A.png");
				option.put("meno", " ");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "1");
				option.put("pic", "pic1.png");
				option.put("value", "../img/examination/qus/10B.png");
				option.put("meno", " ");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "2");
				option.put("pic", "pic2.png");
				option.put("value", "../img/examination/qus/10C.png");
				option.put("meno", " ");
				optionList.add(option);

				option = new JSONObject();
				option.put("no", "3");
				option.put("pic", "pic3.png");
				option.put("value", "../img/examination/qus/10D.png");
				option.put("meno", " ");
				optionList.add(option);
			}
			item.put("options", optionList);
			examinationList.add(item);
		}
		System.out.println(examinationList);
	}

}
