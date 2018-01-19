import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class160 {
   @ObfuscatedName("n")
   static boolean field2179;
   @ObfuscatedName("v")
   static File field2181;
   @ObfuscatedName("y")
   static Hashtable field2180;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   @Export("soundTaskDataProvider")
   static TaskDataProvider soundTaskDataProvider;
   @ObfuscatedName("ap")
   @Export("clientInstance")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client clientInstance;

   static {
      field2179 = false;
      field2180 = new Hashtable(16);
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "([Lhq;Lhq;ZI)V",
      garbageValue = "1900690927"
   )
   static void method3094(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class23.method168(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class23.method168(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(FontName.loadWidget(var6)) {
            class23.method168(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "621931092"
   )
   static void method3100() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.first(); var0 != null; var0 = (WidgetNode)Client.componentTable.next()) {
         int var1 = var0.id;
         if(FontName.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = UrlRequester.getWidget(var4);
               if(var5 != null) {
                  class28.method220(var5);
               }
            }
         }
      }

   }
}
