import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class156 extends class297 {
   @ObfuscatedName("d")
   final boolean field2134;

   public class156(boolean var1) {
      this.field2134 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkz;Lkz;I)I",
      garbageValue = "1725900720"
   )
   int method3235(ChatPlayer var1, ChatPlayer var2) {
      return var2.rank != var1.rank?(this.field2134?var1.rank - var2.rank:var2.rank - var1.rank):this.method5387(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3235((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(Lbk;II)V",
      garbageValue = "1915151848"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      class160.worldToScreen(var0.x, var0.y, var1);
   }
}
