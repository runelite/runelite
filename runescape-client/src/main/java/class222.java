import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hs")
public class class222 {
   @ObfuscatedName("a")
   @Export("varpsMasks")
   public static int[] varpsMasks;
   @ObfuscatedName("w")
   @Export("settings")
   @Hook("varbitChanged")
   public static int[] settings;
   @ObfuscatedName("e")
   @Export("widgetSettings")
   public static int[] widgetSettings;

   static {
      varpsMasks = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         varpsMasks[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }
}
