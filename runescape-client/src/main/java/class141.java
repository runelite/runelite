import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class141 extends class283 {
   @ObfuscatedName("pv")
   @ObfuscatedSignature(
      signature = "Lcp;"
   )
   static class88 field1906;
   @ObfuscatedName("w")
   final boolean field1905;

   public class141(boolean var1) {
      this.field1905 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lkd;Lkd;S)I",
      garbageValue = "3136"
   )
   int method3174(ChatPlayer var1, ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field1905?var1.field3649 - var2.field3649:var2.field3649 - var1.field3649):this.method5320(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3174((ChatPlayer)var1, (ChatPlayer)var2);
   }
}
