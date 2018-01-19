import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class222 {
   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      signature = "Lck;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("n")
   @Export("varpsMasks")
   public static int[] varpsMasks;
   @ObfuscatedName("v")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("y")
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lil;Ljava/lang/String;Ljava/lang/String;I)Lkm;",
      garbageValue = "2036774627"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class86.method1735(var0, var3, var4);
   }
}
