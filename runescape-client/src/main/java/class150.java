import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class150 extends class283 {
   @ObfuscatedName("b")
   final boolean field2081;

   public class150(boolean var1) {
      this.field2081 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;I)I",
      garbageValue = "-581264504"
   )
   int method3117(ChatPlayer var1, ChatPlayer var2) {
      if(Client.world == var1.world) {
         if(var2.world != Client.world) {
            return this.field2081?-1:1;
         }
      } else if(var2.world == Client.world) {
         return this.field2081?1:-1;
      }

      return this.method5214(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3117((ChatPlayer)var1, (ChatPlayer)var2);
   }
}
