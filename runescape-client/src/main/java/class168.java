import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class168 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1622082407
   )
   public static int field2197;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      longValue = -6453837003847405463L
   )
   static long field2198;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass110;ZI)V",
      garbageValue = "1436095358"
   )
   public static void method3103(class110 var0, boolean var1) {
      if(null != class185.field2774) {
         try {
            class185.field2774.method2027();
         } catch (Exception var6) {
            ;
         }

         class185.field2774 = null;
      }

      class185.field2774 = var0;
      MessageNode.method201(var1);
      class185.field2775.offset = 0;
      class172.field2358 = null;
      class149.field2051 = null;
      class185.field2768 = 0;

      while(true) {
         class181 var2 = (class181)class185.field2758.method2296();
         if(var2 == null) {
            while(true) {
               var2 = (class181)class185.field2766.method2296();
               if(var2 == null) {
                  if(class185.field2760 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.method2815(4);
                        var7.method2815(class185.field2760);
                        var7.method2712(0);
                        class185.field2774.method2016(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class185.field2774.method2027();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class185.field2763;
                        class185.field2774 = null;
                     }
                  }

                  class185.field2756 = 0;
                  class185.field2757 = class114.method2154();
                  return;
               }

               class185.field2762.method2248(var2);
               class185.field2759.method2291(var2, var2.hash);
               ++class185.field2764;
               --class185.field2767;
            }
         }

         class185.field2773.method2291(var2, var2.hash);
         ++class185.field2765;
         --class185.field2761;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "85862815"
   )
   public static int method3104(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }
}
