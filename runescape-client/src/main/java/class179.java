import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class179 {
   @ObfuscatedName("s")
   public static int[] field2949 = new int[32];
   @ObfuscatedName("t")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("z")
   @Export("settings")
   public static int[] settings;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2949[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2092907758"
   )
   static void method3455(int var0) {
      class47.field1022 = new class32();
      class47.field1022.field699 = Client.menuActionParams0[var0];
      class47.field1022.field691 = Client.menuActionParams1[var0];
      class47.field1022.field692 = Client.menuTypes[var0];
      class47.field1022.field693 = Client.menuIdentifiers[var0];
      class47.field1022.field694 = Client.menuOptions[var0];
   }
}
