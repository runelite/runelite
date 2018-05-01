import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class155 extends class297 {
   @ObfuscatedName("g")
   final boolean field2125;

   public class155(boolean var1) {
      this.field2125 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;I)I",
      garbageValue = "90555155"
   )
   int method3231(ChatPlayer var1, ChatPlayer var2) {
      return var2.world != var1.world?(this.field2125?var1.world - var2.world:var2.world - var1.world):this.method5341(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3231((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-11595"
   )
   protected static final void method3236() {
      class324.timer.vmethod3396();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field673[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field694[var0] = 0L;
      }

      GameEngine.field689 = 0;
   }
}
