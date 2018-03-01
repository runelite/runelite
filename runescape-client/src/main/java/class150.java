import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class150 extends class297 {
   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   static JagexGame field2118;
   @ObfuscatedName("d")
   final boolean field2115;

   public class150(boolean var1) {
      this.field2115 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkz;Lkz;I)I",
      garbageValue = "-2129961198"
   )
   int method3195(ChatPlayer var1, ChatPlayer var2) {
      return Client.world == var1.world && var2.world == Client.world?(this.field2115?var1.method5385().method5536(var2.method5385()):var2.method5385().method5536(var1.method5385())):this.method5387(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3195((ChatPlayer)var1, (ChatPlayer)var2);
   }
}
