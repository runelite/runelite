import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
public class class248 {
   @ObfuscatedName("k")
   public static final boolean[] field3011;
   @ObfuscatedName("t")
   public static int[] field3012;
   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "[Lld;"
   )
   @Export("crossSprites")
   static SpritePixels[] crossSprites;

   static {
      field3011 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field3012 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field3012[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1602991858"
   )
   public static int method4500(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }
}
