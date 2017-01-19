import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class48 extends CacheableNode {
   @ObfuscatedName("f")
   int[] field934;
   @ObfuscatedName("h")
   String[] field935;
   @ObfuscatedName("c")
   int[] field936;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -774048689
   )
   int field937;
   @ObfuscatedName("s")
   static NodeCache field938 = new NodeCache(128);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -238057711
   )
   int field939;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 626236105
   )
   int field940;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      longValue = -1042210312971959337L
   )
   static long field941;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = -1706476923
   )
   static int field942;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 142405077
   )
   int field943;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass190;",
      garbageValue = "1049388055"
   )
   public static class190 method844(int var0) {
      class190 var1 = (class190)class190.field2807.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class190.field2804.method3182(13, var0);
         var1 = new class190();
         var1.field2797 = var0;
         if(null != var2) {
            var1.method3364(new Buffer(var2));
         }

         class190.field2807.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)I",
      garbageValue = "-56"
   )
   public static int method849(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZB)V",
      garbageValue = "-82"
   )
   public static void method850(String var0, boolean var1, boolean var2) {
      RSCanvas.method2034(var0, var1, "openjs", var2);
   }
}
