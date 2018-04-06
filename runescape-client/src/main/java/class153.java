import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public class class153 extends class297 {
   @ObfuscatedName("o")
   final boolean field2155;

   public class153(boolean var1) {
      this.field2155 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;B)I",
      garbageValue = "2"
   )
   int method3141(ChatPlayer var1, ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field2155?var1.field3845 - var2.field3845:var2.field3845 - var1.field3845):this.method5282(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3141((ChatPlayer)var1, (ChatPlayer)var2);
   }
}
