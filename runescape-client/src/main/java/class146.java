import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class146 {
   @ObfuscatedName("d")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("m")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("n")
   static int[] field2034 = new int[32];

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIS)I",
      garbageValue = "22168"
   )
   static final int method2789(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & '\uff00') * var3 + (var1 & '\uff00') * var2 & 16711680) + ((var1 & 16711935) * var2 + (var0 & 16711935) * var3 & -16711936) >> 8;
   }

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2034[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }
}
