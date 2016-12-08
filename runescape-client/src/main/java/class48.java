import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class48 extends CacheableNode {
   @ObfuscatedName("o")
   static NodeCache field946 = new NodeCache(128);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 15593241
   )
   int field947;
   @ObfuscatedName("b")
   int[] field948;
   @ObfuscatedName("g")
   String[] field949;
   @ObfuscatedName("m")
   int[] field950;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1680893353
   )
   int field951;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1452423847
   )
   int field952;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1010333563
   )
   int field953;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "-560021963"
   )
   public static void method876(class182 var0) {
      class187.field2781 = var0;
      class150.field2057 = class187.field2781.method3245(16);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "-440348474"
   )
   static MessageNode method877(int var0) {
      return (MessageNode)class47.field945.method2258((long)var0);
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIB)V",
      garbageValue = "83"
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
