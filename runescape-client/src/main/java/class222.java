import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
public class class222 {
   @ObfuscatedName("c")
   public static final boolean[] field2834;
   @ObfuscatedName("e")
   public static int[] field2835;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1705659439"
   )
   public static int method4064(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }

   static {
      field2834 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2835 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2835[var1] = var0 / 4;
      }

   }
}
