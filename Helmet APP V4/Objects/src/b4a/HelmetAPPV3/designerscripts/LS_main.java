package b4a.HelmetAPPV3.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_main{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[main/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 4;BA.debugLine="p1.Left = 5%x"[main/General script]
views.get("p1").vw.setLeft((int)((5d / 100 * width)));
//BA.debugLineNum = 5;BA.debugLine="p1.Top = 5%y"[main/General script]
views.get("p1").vw.setTop((int)((5d / 100 * height)));
//BA.debugLineNum = 6;BA.debugLine="p1.width = 90%x"[main/General script]
views.get("p1").vw.setWidth((int)((90d / 100 * width)));
//BA.debugLineNum = 7;BA.debugLine="p1.Height = p1.Width"[main/General script]
views.get("p1").vw.setHeight((int)((views.get("p1").vw.getWidth())));
//BA.debugLineNum = 9;BA.debugLine="qrcrv.Left = p1.Left + 0.05*p1.width"[main/General script]
views.get("qrcrv").vw.setLeft((int)((views.get("p1").vw.getLeft())+0.05d*(views.get("p1").vw.getWidth())));
//BA.debugLineNum = 10;BA.debugLine="qrcrv.Top = p1.Top  + 0.05*p1.height"[main/General script]
views.get("qrcrv").vw.setTop((int)((views.get("p1").vw.getTop())+0.05d*(views.get("p1").vw.getHeight())));
//BA.debugLineNum = 11;BA.debugLine="qrcrv.width = p1.Width * 0.8"[main/General script]
views.get("qrcrv").vw.setWidth((int)((views.get("p1").vw.getWidth())*0.8d));
//BA.debugLineNum = 12;BA.debugLine="qrcrv.Height = 0.75 * p1.height"[main/General script]
views.get("qrcrv").vw.setHeight((int)(0.75d*(views.get("p1").vw.getHeight())));
//BA.debugLineNum = 14;BA.debugLine="b1.Left = p1.Left"[main/General script]
views.get("b1").vw.setLeft((int)((views.get("p1").vw.getLeft())));
//BA.debugLineNum = 15;BA.debugLine="b1.Top = p1.Bottom + 5%y"[main/General script]
views.get("b1").vw.setTop((int)((views.get("p1").vw.getTop() + views.get("p1").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 16;BA.debugLine="b1.Width = 40%x"[main/General script]
views.get("b1").vw.setWidth((int)((40d / 100 * width)));
//BA.debugLineNum = 17;BA.debugLine="b1.Height = 15%y"[main/General script]
views.get("b1").vw.setHeight((int)((15d / 100 * height)));
//BA.debugLineNum = 19;BA.debugLine="b2.Left = 55%x"[main/General script]
views.get("b2").vw.setLeft((int)((55d / 100 * width)));
//BA.debugLineNum = 20;BA.debugLine="b2.Top = p1.Bottom + 5%y"[main/General script]
views.get("b2").vw.setTop((int)((views.get("p1").vw.getTop() + views.get("p1").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 21;BA.debugLine="b2.Width = 40%x"[main/General script]
views.get("b2").vw.setWidth((int)((40d / 100 * width)));
//BA.debugLineNum = 22;BA.debugLine="b2.Height = 15%y"[main/General script]
views.get("b2").vw.setHeight((int)((15d / 100 * height)));
//BA.debugLineNum = 24;BA.debugLine="l1.Left = 2%x"[main/General script]
views.get("l1").vw.setLeft((int)((2d / 100 * width)));
//BA.debugLineNum = 25;BA.debugLine="l1.Top = 85%y"[main/General script]
views.get("l1").vw.setTop((int)((85d / 100 * height)));
//BA.debugLineNum = 26;BA.debugLine="l1.Width = 96%x"[main/General script]
views.get("l1").vw.setWidth((int)((96d / 100 * width)));
//BA.debugLineNum = 27;BA.debugLine="l1.Height = 15%y"[main/General script]
views.get("l1").vw.setHeight((int)((15d / 100 * height)));

}
}