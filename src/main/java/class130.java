import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class130 {
   @ObfuscatedName("w")
   public static final class130 field2058 = new class130(1);
   @ObfuscatedName("d")
   static final class130 field2060 = new class130(2);
   @ObfuscatedName("ge")
   static class173 field2061;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1543201857
   )
   public final int field2062;
   @ObfuscatedName("a")
   static final class130 field2064 = new class130(0);
   @ObfuscatedName("o")
   static int[] field2066;

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class130(int var1) {
      this.field2062 = var1;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1968775113"
   )
   static final void method2949(int var0, int var1) {
      class199 var2 = client.field425[class42.field1002][var0][var1];
      if(null == var2) {
         class30.field717.method2097(class42.field1002, var0, var1);
      } else {
         long var3 = -99999999L;
         class28 var5 = null;

         class28 var6;
         for(var6 = (class28)var2.method3926(); null != var6; var6 = (class28)var2.method3902()) {
            class51 var7 = class11.method178(var6.field691);
            long var8 = (long)var7.field1150;
            if(var7.field1136 == 1) {
               var8 *= (long)(var6.field689 + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class30.field717.method2097(class42.field1002, var0, var1);
         } else {
            var2.method3901(var5);
            class28 var10 = null;
            class28 var11 = null;

            for(var6 = (class28)var2.method3926(); var6 != null; var6 = (class28)var2.method3902()) {
               if(var6.field691 != var5.field691) {
                  if(var10 == null) {
                     var10 = var6;
                  }

                  if(var10.field691 != var6.field691 && null == var11) {
                     var11 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            class30.field717.method2015(class42.field1002, var0, var1, class34.method816(128 * var0 + 64, 64 + 128 * var1, class42.field1002), var5, var9, var10, var11);
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)Ljava/lang/String;",
      garbageValue = "-118"
   )
   public static String method2950(class119 var0) {
      String var1;
      try {
         int var2 = var0.method2812();
         if(var2 > 32767) {
            var2 = 32767;
         }

         byte[] var3 = new byte[var2];
         var0.field1992 += class129.field2055.method2536(var0.field1993, var0.field1992, var3, 0, var2);
         String var4 = class47.method1084(var3, 0, var2);
         var1 = var4;
      } catch (Exception var5) {
         var1 = "Cabbage";
      }

      return var1;
   }
}
