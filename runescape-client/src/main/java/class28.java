import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class28 {
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -613151895
   )
   @Export("cameraZ")
   static int cameraZ;

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1641740588"
   )
   static void method633(int var0) {
      class8.field153 = new class32();
      class8.field153.field739 = Client.menuActionParams0[var0];
      class8.field153.field733 = Client.menuActionParams1[var0];
      class8.field153.field732 = Client.menuTypes[var0];
      class8.field153.field736 = Client.menuIdentifiers[var0];
      class8.field153.field735 = Client.menuOptions[var0];
   }
}
