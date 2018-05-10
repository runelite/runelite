import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
public class class234 {
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      intValue = -655729291
   )
   static int field2801;
   @ObfuscatedName("m")
   public static final boolean[] field2797;
   @ObfuscatedName("q")
   public static int[] field2798;
   @ObfuscatedName("ag")
   static Image field2799;
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;

   static {
      field2797 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2798 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2798[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-71"
   )
   static String method4595(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }
}
