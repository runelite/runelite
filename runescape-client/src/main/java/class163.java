import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class163 {
   @ObfuscatedName("g")
   public static int[][] field2285;
   @ObfuscatedName("y")
   public static int[][] field2289;
   @ObfuscatedName("z")
   public static int[] field2283;
   @ObfuscatedName("r")
   public static int[] field2284;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1051358349
   )
   public static int field2287;

   static {
      field2285 = new int[128][128];
      field2289 = new int[128][128];
      field2283 = new int[4096];
      field2284 = new int[4096];
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfb;I)I",
      garbageValue = "-936731923"
   )
   static int method3092(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }
}
