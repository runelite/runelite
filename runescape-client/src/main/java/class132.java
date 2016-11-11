import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public final class class132 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "80"
   )
   public static boolean method2857(int var0) {
      return (var0 >> 29 & 1) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Lclass136;",
      garbageValue = "98"
   )
   static class136 method2860() {
      try {
         return new class150();
      } catch (Throwable var1) {
         return new class144();
      }
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "-1997893753"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            ++Client.menuOptionCount;
         }

      }
   }
}
