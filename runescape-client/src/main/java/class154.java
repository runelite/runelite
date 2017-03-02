import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class154 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1180399283
   )
   static int field2092 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1375702839
   )
   static int field2093 = 0;
   @ObfuscatedName("t")
   static byte[][] field2094 = new byte[1000][];
   @ObfuscatedName("k")
   static byte[][] field2095 = new byte[250][];
   @ObfuscatedName("h")
   static byte[][] field2096 = new byte[50][];
   @ObfuscatedName("ad")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 531275571
   )
   static int field2099 = 0;

   class154() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "110646619"
   )
   static synchronized byte[] method3075(int var0) {
      byte[] var1;
      if(var0 == 100 && field2092 > 0) {
         var1 = field2094[--field2092];
         field2094[field2092] = null;
         return var1;
      } else if(var0 == 5000 && field2093 > 0) {
         var1 = field2095[--field2093];
         field2095[field2093] = null;
         return var1;
      } else if(var0 == 30000 && field2099 > 0) {
         var1 = field2096[--field2099];
         field2096[field2099] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-806008878"
   )
   public static int method3076(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var1 + var0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass184;IIIBZI)V",
      garbageValue = "-988948041"
   )
   static void method3077(class184 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class181 var8 = (class181)class185.field2745.method2428(var6);
      if(null == var8) {
         var8 = (class181)class185.field2746.method2428(var6);
         if(var8 == null) {
            var8 = (class181)class185.field2744.method2428(var6);
            if(null != var8) {
               if(var5) {
                  var8.method2497();
                  class185.field2745.method2425(var8, var6);
                  --class185.field2750;
                  ++class185.field2755;
               }

            } else {
               if(!var5) {
                  var8 = (class181)class185.field2756.method2428(var6);
                  if(null != var8) {
                     return;
                  }
               }

               var8 = new class181();
               var8.field2703 = var0;
               var8.field2704 = var3;
               var8.field2702 = var4;
               if(var5) {
                  class185.field2745.method2425(var8, var6);
                  ++class185.field2755;
               } else {
                  class185.field2748.method2367(var8);
                  class185.field2744.method2425(var8, var6);
                  ++class185.field2750;
               }

            }
         }
      }
   }
}
