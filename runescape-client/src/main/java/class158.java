import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ff")
public class class158 {
   @ObfuscatedName("ey")
   static SpritePixels[] field2353;
   @ObfuscatedName("g")
   public static final boolean[] field2354 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("r")
   public static int[] field2358 = new int[99];

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2358[var1] = var0 / 4;
      }

   }
}
