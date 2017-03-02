import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class165 {
   @ObfuscatedName("b")
   public static int[] field2153 = new int[32];
   @ObfuscatedName("l")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("i")
   @Export("widgetSettings")
   public static int[] widgetSettings;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2153[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   class165() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1892046607"
   )
   static void method3219() {
      XItemContainer.itemContainers = new XHashTable(32);
   }
}
