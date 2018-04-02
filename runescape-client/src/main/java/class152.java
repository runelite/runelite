import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class152 extends class297 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -530195745
   )
   public static int field2129;
   @ObfuscatedName("c")
   final boolean field2130;

   public class152(boolean var1) {
      this.field2130 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;B)I",
      garbageValue = "-67"
   )
   int method3142(ChatPlayer var1, ChatPlayer var2) {
      return Client.world == var1.world && var2.world == Client.world?(this.field2130?var1.field3839 - var2.field3839:var2.field3839 - var1.field3839):this.method5288(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3142((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1347687077"
   )
   public static void method3141() {
      ItemComposition.itemSpriteCache.reset();
   }
}
