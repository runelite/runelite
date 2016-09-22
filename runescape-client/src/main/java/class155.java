import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class155 implements class115 {
   @ObfuscatedName("z")
   public static final class155 field2328 = new class155(4, 3, false, false, true);
   @ObfuscatedName("d")
   public static final class155 field2329 = new class155(1, 0, true, true, true);
   @ObfuscatedName("v")
   public static final class155 field2330 = new class155(2, 1, true, true, false);
   @ObfuscatedName("r")
   public static final class155 field2331 = new class155(3, 2, false, false, true);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1793397517
   )
   final int field2333;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2044382175
   )
   public final int field2334;
   @ObfuscatedName("i")
   public final boolean field2335;
   @ObfuscatedName("g")
   public final boolean field2336;
   @ObfuscatedName("a")
   public static final class155 field2337 = new class155(0, -1, true, false, true);
   @ObfuscatedName("pb")
   static class163 field2338;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "1254410565"
   )
   public static String method3188(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < 0 + var2; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class164.field2706[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[1 + var4] & 255;
            var3.append(class164.field2706[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[2 + var4] & 255;
               var3.append(class164.field2706[(var6 & 15) << 2 | var7 >>> 6]).append(class164.field2706[var7 & 63]);
            } else {
               var3.append(class164.field2706[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class164.field2706[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1565114944"
   )
   public int vmethod3214() {
      return this.field2333;
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class155(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2333 = var1;
      this.field2334 = var2;
      this.field2335 = var4;
      this.field2336 = var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-3080940"
   )
   public static int method3191(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Lclass170;Lclass187;I)Z",
      garbageValue = "1561631471"
   )
   public static boolean method3193(class170 var0, class170 var1, class170 var2, class187 var3) {
      class186.field3018 = var0;
      class186.field3013 = var1;
      class186.field3012 = var2;
      class186.field3015 = var3;
      return true;
   }
}
