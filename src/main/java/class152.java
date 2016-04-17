import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class152 implements class112 {
   @ObfuscatedName("q")
   public final boolean field2259;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -731647633
   )
   public final int field2260;
   @ObfuscatedName("d")
   public static final class152 field2261 = new class152(2, 1, true, true, false);
   @ObfuscatedName("c")
   public static final class152 field2262 = new class152(3, 2, false, false, true);
   @ObfuscatedName("w")
   public static final class152 field2263 = new class152(1, 0, true, true, true);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2140242757
   )
   final int field2264;
   @ObfuscatedName("a")
   public static final class152 field2265 = new class152(0, -1, true, false, true);
   @ObfuscatedName("p")
   public final boolean field2266;
   @ObfuscatedName("y")
   public static final class152 field2268 = new class152(4, 3, false, false, true);

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "0"
   )
   class152(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2264 = var1;
      this.field2260 = var2;
      this.field2266 = var4;
      this.field2259 = var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1405875737"
   )
   public int vmethod3266() {
      return this.field2264;
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "([Lclass173;II)V",
      garbageValue = "-1804825006"
   )
   static final void method3244(class173[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class173 var3 = var0[var2];
         if(var3 != null && var3.field2777 == var1 && (!var3.field2757 || !class219.method4065(var3))) {
            if(0 == var3.field2824) {
               if(!var3.field2757 && class219.method4065(var3) && class43.field1032 != var3) {
                  continue;
               }

               method3244(var0, var3.field2842);
               if(null != var3.field2867) {
                  method3244(var3.field2867, var3.field2842);
               }

               class3 var4 = (class3)client.field453.method3868((long)var3.field2842);
               if(var4 != null) {
                  method3248(var4.field70);
               }
            }

            if(6 == var3.field2824) {
               int var5;
               if(-1 != var3.field2805 || var3.field2834 != -1) {
                  boolean var7 = class154.method3253(var3);
                  if(var7) {
                     var5 = var3.field2834;
                  } else {
                     var5 = var3.field2805;
                  }

                  if(-1 != var5) {
                     class42 var6 = class96.method2279(var5);

                     for(var3.field2856 += client.field427; var3.field2856 > var6.field995[var3.field2771]; class23.method657(var3)) {
                        var3.field2856 -= var6.field995[var3.field2771];
                        ++var3.field2771;
                        if(var3.field2771 >= var6.field989.length) {
                           var3.field2771 -= var6.field998;
                           if(var3.field2771 < 0 || var3.field2771 >= var6.field989.length) {
                              var3.field2771 = 0;
                           }
                        }
                     }
                  }
               }

               if(0 != var3.field2779 && !var3.field2757) {
                  int var8 = var3.field2779 >> 16;
                  var5 = var3.field2779 << 16 >> 16;
                  var8 *= client.field427;
                  var5 *= client.field427;
                  var3.field2800 = var8 + var3.field2800 & 2047;
                  var3.field2810 = var5 + var3.field2810 & 2047;
                  class23.method657(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass167;III)Lclass78;",
      garbageValue = "1547999453"
   )
   public static class78 method3246(class167 var0, int var1, int var2) {
      if(!class30.method748(var0, var1, var2)) {
         return null;
      } else {
         class78 var4 = new class78();
         var4.field1405 = class76.field1385;
         var4.field1407 = class103.field1773;
         var4.field1403 = class76.field1389[0];
         var4.field1404 = class76.field1387[0];
         var4.field1401 = class126.field2042[0];
         var4.field1402 = class77.field1397[0];
         int var5 = var4.field1401 * var4.field1402;
         byte[] var6 = class76.field1388[0];
         var4.field1411 = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.field1411[var7] = class8.field153[var6[var7] & 255];
         }

         class15.method203();
         return var4;
      }
   }

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1322589754"
   )
   static final void method3248(int var0) {
      if(class9.method161(var0)) {
         method3244(class173.field2886[var0], -1);
      }
   }
}
