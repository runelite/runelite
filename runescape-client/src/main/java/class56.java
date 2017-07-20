import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class56 {
   @ObfuscatedName("c")
   static Applet field674;
   @ObfuscatedName("o")
   static String field675;
   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   static RSSocket field680;

   static {
      field674 = null;
      field675 = null;
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2139298263"
   )
   static final void method788(int var0) {
      if(class9.loadWidget(var0)) {
         Permission.method3990(Widget.widgets[var0], -1);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-1676"
   )
   public static void method782() {
      PlayerComposition.field2593.reset();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lip;Lip;Lip;Lip;I)V",
      garbageValue = "-2145297297"
   )
   public static void method778(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, IndexDataBase var3) {
      class35.widgetIndex = var0;
      class60.field745 = var1;
      VertexNormal.field1966 = var2;
      class27.field390 = var3;
      Widget.widgets = new Widget[class35.widgetIndex.size()][];
      class163.validInterfaces = new boolean[class35.widgetIndex.size()];
   }
}
