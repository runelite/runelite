import java.awt.Container;
import java.awt.Insets;
import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("ct")
public class class83 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1125685761
   )
   int field1445;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -923790247
   )
   int field1446;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1450922451
   )
   int field1447;

   @ObfuscatedName("dr")
   static void method1909(String var0) {
      class3.field58 = var0;

      try {
         String var1 = client.field540.getParameter(class189.field3051.field3049);
         String var2 = client.field540.getParameter(class189.field3058.field3049);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         String var5;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            String var4 = var3 + "; Expires=";
            long var6 = class18.method214() + 94608000000L;
            class110.field1945.setTime(new Date(var6));
            int var8 = class110.field1945.get(7);
            int var9 = class110.field1945.get(5);
            int var10 = class110.field1945.get(2);
            int var11 = class110.field1945.get(1);
            int var12 = class110.field1945.get(11);
            int var13 = class110.field1945.get(12);
            int var14 = class110.field1945.get(13);
            var5 = class110.field1944[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + class110.field1950[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
            var3 = var4 + var5 + "; Max-Age=" + 94608000L;
         }

         client var16 = client.field540;
         var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var16).eval(var5);
      } catch (Throwable var15) {
         ;
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2085995532"
   )
   static void method1910() {
      client var0 = client.field540;
      synchronized(client.field540) {
         Container var1 = client.field540.method3036();
         if(null != var1) {
            class218.field3161 = Math.max(var1.getSize().width, class118.field1985);
            class42.field1005 = Math.max(var1.getSize().height, class140.field2160);
            if(var1 == class59.field1217) {
               Insets var2 = class59.field1217.getInsets();
               class218.field3161 -= var2.left + var2.right;
               class42.field1005 -= var2.bottom + var2.top;
            }

            if(class218.field3161 <= 0) {
               class218.field3161 = 1;
            }

            if(class42.field1005 <= 0) {
               class42.field1005 = 1;
            }

            int var8 = client.field508?2:1;
            if(var8 == 1) {
               class6.field107 = client.field417 * 765;
               class31.field749 = client.field518 * 503;
            } else {
               class6.field107 = Math.min(class218.field3161, 7680);
               class31.field749 = Math.min(class42.field1005, 2160);
            }

            class143.field2179 = (class218.field3161 - class6.field107) / 2;
            class143.field2189 = 0;
            class45.field1042.setSize(class6.field107, class31.field749);
            class139.field2149 = class19.method247(class6.field107, class31.field749, class45.field1042);
            if(var1 == class59.field1217) {
               Insets var3 = class59.field1217.getInsets();
               class45.field1042.setLocation(var3.left + class143.field2179, var3.top + class143.field2189);
            } else {
               class45.field1042.setLocation(class143.field2179, class143.field2189);
            }

            class47.method1010();
            if(client.field453 != -1) {
               int var9 = client.field453;
               int var4 = class6.field107;
               int var5 = class31.field749;
               if(class103.method2303(var9)) {
                  class1.method11(class172.field2850[var9], -1, var4, var5, true);
               }
            }

            class38.method767();
         }
      }
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "347494282"
   )
   static final void method1911(int var0, int var1) {
      int var2 = class38.field876.method4052("Choose Option");

      int var3;
      for(var3 = 0; var3 < client.field435; ++var3) {
         class223 var4 = class38.field876;
         String var5;
         if(client.field445[var3].length() > 0) {
            var5 = client.field440[var3] + " " + client.field445[var3];
         } else {
            var5 = client.field440[var3];
         }

         int var6 = var4.method4052(var5);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = 22 + client.field435 * 15;
      int var7 = var0 - var2 / 2;
      if(var2 + var7 > class6.field107) {
         var7 = class6.field107 - var2;
      }

      if(var7 < 0) {
         var7 = 0;
      }

      int var8 = var1;
      if(var1 + var3 > class31.field749) {
         var8 = class31.field749 - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      client.field470 = true;
      class13.field192 = var7;
      class30.field709 = var8;
      class180.field2925 = var2;
      class118.field1987 = 22 + client.field435 * 15;
   }
}
