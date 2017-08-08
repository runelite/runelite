import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class165 {
   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIS)V",
      garbageValue = "1653"
   )
   @Export("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      boolean var12 = false;
      if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
         Client.menuOptions[Client.menuOptionCount] = var0;
         Client.menuTargets[Client.menuOptionCount] = var1;
         Client.menuTypes[Client.menuOptionCount] = var2;
         Client.menuIdentifiers[Client.menuOptionCount] = var3;
         Client.menuActionParams0[Client.menuOptionCount] = var4;
         Client.menuActionParams1[Client.menuOptionCount] = var5;
         Client.field1048[Client.menuOptionCount] = var12;
         ++Client.menuOptionCount;
      }

   }
}
