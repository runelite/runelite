import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
final class class3 implements class0 {
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = 1417798389
   )
   @Export("port2")
   static int port2;

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1983835380"
   )
   static final void method3() {
      Client.field997 = Client.cycleCntr;
   }
}
