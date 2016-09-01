import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class159 {
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 288206857
   )
   static int field2362;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = -1403725577
   )
   @Export("baseY")
   static int baseY;

   @ObfuscatedName("j")
   public static String method3202(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class165.field2710[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass146;ZI)V",
      garbageValue = "-1021899156"
   )
   public static void method3203(class146 var0, boolean var1) {
      if(null != class174.field2774) {
         try {
            class174.field2774.method3044();
         } catch (Exception var6) {
            ;
         }

         class174.field2774 = null;
      }

      class174.field2774 = var0;
      class22.method558(var1);
      class174.field2789.offset = 0;
      class85.field1465 = null;
      XClanMember.field630 = null;
      class174.field2787 = 0;

      while(true) {
         class175 var2 = (class175)class174.field2779.method3821();
         if(var2 == null) {
            while(true) {
               var2 = (class175)class174.field2784.method3821();
               if(null == var2) {
                  if(class174.field2790 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.method2715(4);
                        var7.method2715(class174.field2790);
                        var7.method2542(0);
                        class174.field2774.method3043(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class174.field2774.method3044();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class174.field2792;
                        class174.field2774 = null;
                     }
                  }

                  class174.field2775 = 0;
                  class174.field2776 = class34.method713();
                  return;
               }

               class174.field2783.method3918(var2);
               class174.field2782.method3819(var2, var2.hash);
               ++class174.field2786;
               --class174.field2793;
            }
         }

         class174.field2777.method3819(var2, var2.hash);
         ++class174.field2794;
         --class174.field2785;
      }
   }
}
