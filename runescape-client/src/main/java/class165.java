import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class165 {
   @ObfuscatedName("f")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("e")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("i")
   static int[] field2170 = new int[32];

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2170[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "329626630"
   )
   public static void method3060(int var0) {
      if(class138.field1914 != 0) {
         ItemLayer.field1220 = var0;
      } else {
         class138.field1913.method2470(var0);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "464132444"
   )
   static void method3061() {
      class45.field908 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class45.field907[var0] = null;
         class45.field913[var0] = 1;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "117"
   )
   static char method3062(char var0) {
      return var0 != 181 && var0 != 402?Character.toTitleCase(var0):var0;
   }
}
