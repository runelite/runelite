import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class151 extends class297 {
   @ObfuscatedName("d")
   final boolean field2120;

   public class151(boolean var1) {
      this.field2120 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkz;Lkz;S)I",
      garbageValue = "12621"
   )
   int method3202(ChatPlayer var1, ChatPlayer var2) {
      if(Client.world == var1.world) {
         if(var2.world != Client.world) {
            return this.field2120?-1:1;
         }
      } else if(var2.world == Client.world) {
         return this.field2120?1:-1;
      }

      return this.method5387(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3202((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)[Lio;",
      garbageValue = "-1427083191"
   )
   public static class254[] method3207() {
      return new class254[]{class254.field3315, class254.field3321, class254.field3316, class254.field3324, class254.field3319, class254.field3318, class254.field3317, class254.field3320};
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2100972752"
   )
   static void method3208() {
      class332.field3990 = null;
      class332.offsetsY = null;
      Varbit.field3539 = null;
      BoundingBox2D.field242 = null;
      class332.field3994 = null;
      class332.spritePixels = null;
   }
}
