import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class155 extends class297 {
   @ObfuscatedName("d")
   final boolean field2133;

   public class155(boolean var1) {
      this.field2133 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkz;Lkz;B)I",
      garbageValue = "84"
   )
   int method3233(ChatPlayer var1, ChatPlayer var2) {
      return var2.world != var1.world?(this.field2133?var1.world - var2.world:var2.world - var1.world):this.method5387(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3233((ChatPlayer)var1, (ChatPlayer)var2);
   }
}
