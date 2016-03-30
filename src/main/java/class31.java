import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class31 {
   @ObfuscatedName("aj")
   static String field714;
   @ObfuscatedName("w")
   static boolean field715;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1640278675
   )
   static int field716;
   @ObfuscatedName("p")
   static class80 field717;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1857356855
   )
   static int field718;
   @ObfuscatedName("i")
   static int[] field719;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1772102235
   )
   static int field720 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 432798871
   )
   static int field721;
   @ObfuscatedName("at")
   static boolean field722;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1202752659
   )
   static int field723;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1213060405
   )
   static int field725;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -214222025
   )
   static int field726;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 312901363
   )
   static int field727;
   @ObfuscatedName("ac")
   static String field728;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1098614667
   )
   static int field729;
   @ObfuscatedName("ae")
   static String field730;
   @ObfuscatedName("t")
   static class80 field731;
   @ObfuscatedName("az")
   static String field732;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 362980185
   )
   static int field733;
   @ObfuscatedName("ag")
   @Export("username")
   static String field734;
   @ObfuscatedName("ad")
   static String field735;
   @ObfuscatedName("au")
   static class159 field736;
   @ObfuscatedName("b")
   static int[] field737;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 496413647
   )
   static int field738;
   @ObfuscatedName("al")
   static String field739;
   @ObfuscatedName("an")
   static boolean field741;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 318643399
   )
   static int field742;
   @ObfuscatedName("cy")
   static class143 field743;

   static {
      field718 = 202 + field720;
      field719 = new int[256];
      field716 = 0;
      field721 = 0;
      field723 = 0;
      field733 = 0;
      field725 = 0;
      field726 = 0;
      field727 = 10;
      field728 = "";
      field729 = 0;
      field730 = "";
      field714 = "";
      field732 = "";
      field739 = "";
      field734 = "";
      field735 = "";
      field736 = class159.field2626;
      field722 = true;
      field738 = 0;
      field741 = false;
      field742 = -1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static void method698() {
      client var0 = client.field294;
      synchronized(client.field294) {
         Container var1 = client.field294.method3039();
         if(var1 != null) {
            class16.field252 = Math.max(var1.getSize().width, class30.field711);
            class90.field1568 = Math.max(var1.getSize().height, class22.field601);
            Insets var2;
            if(class33.field773 == var1) {
               var2 = class33.field773.getInsets();
               class16.field252 -= var2.right + var2.left;
               class90.field1568 -= var2.bottom + var2.top;
            }

            if(class16.field252 <= 0) {
               class16.field252 = 1;
            }

            if(class90.field1568 <= 0) {
               class90.field1568 = 1;
            }

            if(class44.method979() == 1) {
               class15.field235 = client.field509;
               class15.field233 = client.field510 * 503;
            } else {
               class15.field235 = Math.min(class16.field252, 7680);
               class15.field233 = Math.min(class90.field1568, 2160);
            }

            class144.field2226 = (class16.field252 - class15.field235) / 2;
            class144.field2221 = 0;
            class87.field1537.setSize(class15.field235, class15.field233);
            class42.field991 = class24.method610(class15.field235, class15.field233, class87.field1537);
            if(class33.field773 == var1) {
               var2 = class33.field773.getInsets();
               class87.field1537.setLocation(class144.field2226 + var2.left, class144.field2221 + var2.top);
            } else {
               class87.field1537.setLocation(class144.field2226, class144.field2221);
            }

            int var8 = class15.field235;
            int var3 = class15.field233;
            if(class16.field252 < var8) {
               var8 = class16.field252;
            }

            if(class90.field1568 < var3) {
               var3 = class90.field1568;
            }

            if(null != class41.field989) {
               try {
                  class132.method2849(client.field294, "resize", new Object[]{Integer.valueOf(class44.method979())});
               } catch (Throwable var6) {
                  ;
               }
            }

            if(client.field454 != -1) {
               class14.method168(client.field454, class15.field235, class15.field233, true);
            }

            class36.method766();
         }
      }
   }

   @ObfuscatedName("d")
   static final int method706(int var0, int var1) {
      if(-2 == var0) {
         return 12345678;
      } else if(-1 == var0) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
