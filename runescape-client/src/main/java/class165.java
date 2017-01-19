import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class165 {
   @ObfuscatedName("s")
   public static int[] field2173 = new int[32];
   @ObfuscatedName("c")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("f")
   @Export("widgetSettings")
   public static int[] widgetSettings;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2173[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1640405041"
   )
   public static void method3037() {
      FloorUnderlayDefinition.field2812.reset();
   }
}
