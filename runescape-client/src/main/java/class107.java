import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
public abstract class class107 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -895371417
   )
   public int field1889;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1245276001
   )
   public int field1891;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -562829577
   )
   public int field1892;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 85307635
   )
   public int field1898;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIILclass108;I)Z",
      garbageValue = "-1542389522"
   )
   public abstract boolean vmethod2368(int var1, int var2, int var3, class108 var4);

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "6"
   )
   static final int method2369(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && 2 == (class5.field90[1][var3][var4] & 2)) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = var6 * class5.field93[var5][var3 + 1][var4] + (128 - var6) * class5.field93[var5][var3][var4] >> 7;
         int var9 = (128 - var6) * class5.field93[var5][var3][1 + var4] + var6 * class5.field93[var5][var3 + 1][var4 + 1] >> 7;
         return var7 * var9 + (128 - var7) * var8 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lclass35;",
      garbageValue = "1458931639"
   )
   static class35 method2372(int var0) {
      return (class35)class11.field167.method3794((long)var0);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "198293957"
   )
   public static void method2373() {
      class183.field2972.method3584();
      class183.field2973 = 1;
      class183.field2974 = null;
   }
}
