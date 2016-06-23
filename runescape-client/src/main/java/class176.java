import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fh")
public class class176 {
   @ObfuscatedName("u")
   @Export("settings")
   public static int[] field2903;
   @ObfuscatedName("f")
   static int[] field2904 = new int[32];
   @ObfuscatedName("x")
   @Export("widgetSettings")
   public static int[] field2905;
   @ObfuscatedName("g")
   static class80[] field2906;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2904[var1] = var0 - 1;
         var0 += var0;
      }

      field2903 = new int[2000];
      field2905 = new int[2000];
   }
}
