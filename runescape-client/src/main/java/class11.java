import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class11 {
   @ObfuscatedName("ab")
   static class168 field177;
   @ObfuscatedName("f")
   @Export("chatLineMap")
   static final Map field178 = new HashMap();
   @ObfuscatedName("x")
   static final class200 field179 = new class200();
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1592776039
   )
   static int field180 = 0;
   @ObfuscatedName("u")
   static final class198 field182 = new class198(1024);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-67"
   )
   @Export("widgetReset")
   static final void method141() {
      class46.field1060.method3796();
      class150.method3167();
      class44.field1047.method3796();
      class40.field938.method3796();
      class40.field966.method3796();
      class40.field940.method3796();
      class40.field950.method3796();
      class109.method2473();
      class42.method937();
      class42.field1013.method3796();
      class42.field1001.method3796();
      class39.method835();
      class141.method3009();
      class52.field1168.method3796();
      class101.method2343();
      class6.method97();
      ((class95)class91.field1594).method2235();
      class22.field600.method3796();
      class131.field2068.method3298();
      class130.field2062.method3298();
      class8.field143.method3298();
      class136.field2101.method3298();
      class89.field1563.method3298();
      class17.field261.method3298();
      class113.field1971.method3298();
      class108.field1909.method3298();
      class38.field889.method3298();
      class29.field702.method3298();
      class152.field2257.method3298();
      class17.field255.method3298();
   }

   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-548602404"
   )
   static void method147(String var0) {
      client.field413 = var0;

      try {
         String var1 = client.field530.getParameter(class190.field3065.field3069);
         String var2 = client.field530.getParameter(class190.field3067.field3069);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + class187.method3778(class130.method2846() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         class132.method2864(client.field530, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var4) {
         ;
      }

   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(Lclass173;B)Z",
      garbageValue = "56"
   )
   static final boolean method150(class173 var0) {
      int var1 = var0.field2758;
      if(var1 == 205) {
         client.field343 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            client.field561.method3521(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            client.field561.method3510(var2, var3 == 1);
         }

         if(var1 == 324) {
            client.field561.method3511(false);
         }

         if(var1 == 325) {
            client.field561.method3511(true);
         }

         if(var1 == 326) {
            client.field333.method2773(58);
            client.field561.method3512(client.field333);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-508186653"
   )
   @Export("setGameState")
   static void method156(int var0) {
      if(var0 != client.field299) {
         if(client.field299 == 0) {
            class15.method182();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            client.field378 = 0;
            client.field342 = 0;
            client.field326 = 0;
         }

         if(var0 != 20 && var0 != 40 && class9.field158 != null) {
            class9.field158.method3013();
            class9.field158 = null;
         }

         if(client.field299 == 25) {
            client.field499 = 0;
            client.field377 = 0;
            client.field479 = 1;
            client.field347 = 0;
            client.field404 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class41.method886(class89.field1567, class29.field702, class108.field1909, true, client.field299 == 11?4:0);
            } else if(var0 == 11) {
               class41.method886(class89.field1567, class29.field702, class108.field1909, false, 4);
            } else {
               class21.method614();
            }
         } else {
            class41.method886(class89.field1567, class29.field702, class108.field1909, true, 0);
         }

         client.field299 = var0;
      }
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1216198829"
   )
   static final void method157(int var0) {
      if(var0 >= 0) {
         int var1 = client.field434[var0];
         int var2 = client.field431[var0];
         int var3 = client.field329[var0];
         int var4 = client.field433[var0];
         String var5 = client.field459[var0];
         String var6 = client.field435[var0];
         class34.method761(var1, var2, var3, var4, var5, var6, class140.field2161, class140.field2158);
      }
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "768337800"
   )
   static final void method158(int var0, int var1) {
      if(class170.field2709 != var0 || class0.field5 != var1) {
         class170.field2709 = var0;
         class0.field5 = var1;
         method156(25);
         class33.method747("Loading - please wait.", true);
         int var2 = class172.field2734;
         int var3 = class20.field576;
         class172.field2734 = (var0 - 6) * 8;
         class20.field576 = (var1 - 6) * 8;
         int var4 = class172.field2734 - var2;
         int var5 = class20.field576 - var3;
         var2 = class172.field2734;
         var3 = class20.field576;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            class34 var7 = client.field328[var6];
            if(var7 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.field875[var8] -= var4;
                  var7.field876[var8] -= var5;
               }

               var7.field837 -= var4 * 128;
               var7.field880 -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            class2 var20 = client.field302[var6];
            if(var20 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.field875[var8] -= var4;
                  var20.field876[var8] -= var5;
               }

               var20.field837 -= var4 * 128;
               var20.field880 -= 128 * var5;
            }
         }

         byte var19 = 0;
         byte var18 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var18 = -1;
            var21 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var12 = var19; var18 != var12; var12 += var21) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var12 + var4;
               int var15 = var5 + var13;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     client.field572[var16][var12][var13] = client.field572[var16][var14][var15];
                  } else {
                     client.field572[var16][var12][var13] = null;
                  }
               }
            }
         }

         for(class16 var17 = (class16)client.field421.method3852(); null != var17; var17 = (class16)client.field421.method3857()) {
            var17.field233 -= var4;
            var17.field231 -= var5;
            if(var17.field233 < 0 || var17.field231 < 0 || var17.field233 >= 104 || var17.field231 >= 104) {
               var17.method3946();
            }
         }

         if(client.field482 != 0) {
            client.field482 -= var4;
            client.field522 -= var5;
         }

         client.field554 = 0;
         client.field536 = false;
         client.field422 = -1;
         client.field423.method3849();
         client.field549.method3849();

         for(var13 = 0; var13 < 4; ++var13) {
            client.field350[var13].method2432();
         }

      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lclass37;I)V",
      garbageValue = "1145770990"
   )
   static final void method160(class37 var0) {
      int var1 = var0.field823 - client.field301;
      int var2 = var0.field825 * 64 + var0.field862 * 128;
      int var3 = var0.field825 * 64 + var0.field864 * 128;
      var0.field837 += (var2 - var0.field837) / var1;
      var0.field880 += (var3 - var0.field880) / var1;
      var0.field865 = 0;
      var0.field871 = var0.field850;
   }
}
