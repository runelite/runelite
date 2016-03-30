import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
@Implements("WidgetNode")
public class class3 extends class208 {
   @ObfuscatedName("t")
   boolean field71 = false;
   @ObfuscatedName("a")
   static int[][][] field72;
   @ObfuscatedName("na")
   static class74 field73;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2025756115
   )
   @Export("id")
   int field74;
   @ObfuscatedName("de")
   @Export("region")
   static class86 field75;
   @ObfuscatedName("cu")
   static class224 field76;
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = 2031014551
   )
   static int field78;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1122330519
   )
   int field79;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "2019784435"
   )
   static void method42(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         class25 var8 = class189.field3062[var6];
         class189.field3062[var6] = class189.field3062[var1];
         class189.field3062[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class90.method2078(class189.field3062[var9], var8, var2, var3, var4, var5) <= 0) {
               class25 var10 = class189.field3062[var9];
               class189.field3062[var9] = class189.field3062[var7];
               class189.field3062[var7++] = var10;
            }
         }

         class189.field3062[var1] = class189.field3062[var7];
         class189.field3062[var7] = var8;
         method42(var0, var7 - 1, var2, var3, var4, var5);
         method42(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1079962515"
   )
   static final void method43(boolean var0) {
      class59.method1272();
      ++client.field342;
      if(client.field342 >= 50 || var0) {
         client.field342 = 0;
         if(!client.field347 && null != class9.field173) {
            client.field318.method2757(249);

            try {
               class9.field173.method3002(client.field318.field2012, 0, client.field318.field2011);
               client.field318.field2011 = 0;
            } catch (IOException var2) {
               client.field347 = true;
            }
         }

      }
   }

   @ObfuscatedName("o")
   static final void method44() {
      if(client.field346 > 0) {
         class38.method785();
      } else {
         class138.method2937(40);
         class31.field743 = class9.field173;
         class9.field173 = null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IZS)Ljava/lang/String;",
      garbageValue = "1"
   )
   public static String method45(int var0) {
      if(var0 < 0) {
         return Integer.toString(var0);
      } else {
         int var2 = var0;
         String var1;
         if(var0 < 0) {
            var1 = Integer.toString(var0, 10);
         } else {
            int var3 = 2;

            for(int var4 = var0 / 10; var4 != 0; ++var3) {
               var4 /= 10;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var2;
               var2 /= 10;
               int var8 = var7 - var2 * 10;
               if(var8 >= 10) {
                  var5[var6] = (char)(87 + var8);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            var1 = new String(var5);
         }

         return var1;
      }
   }

   @ObfuscatedName("w")
   public static int method46(int var0) {
      return var0 >> 11 & 63;
   }

   @ObfuscatedName("m")
   static class25 method47() {
      return class25.field643 < class25.field642?class189.field3062[++class25.field643 - 1]:null;
   }

   @ObfuscatedName("w")
   static void method48(class0 var0) {
      class13.method161(var0, 200000);
   }
}
