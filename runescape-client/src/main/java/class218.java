import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hi")
public class class218 {
   @ObfuscatedName("b")
   public static int[] field2680;
   @ObfuscatedName("s")
   @Export("settings")
   @Hook("varbitChanged")
   public static int[] settings;
   @ObfuscatedName("r")
   @Export("widgetSettings")
   public static int[] widgetSettings;

   static {
      field2680 = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2680[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }
}
