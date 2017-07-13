import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hl")
public class class211 {
   @ObfuscatedName("a")
   public static int[] field2609;
   @ObfuscatedName("j")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("n")
   @Export("widgetSettings")
   public static int[] widgetSettings;

   static {
      field2609 = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2609[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }
}
