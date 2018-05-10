import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class144 extends class283 {
   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   static Widget field1921;
   @ObfuscatedName("w")
   final boolean field1917;

   public class144(boolean var1) {
      this.field1917 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lkd;Lkd;I)I",
      garbageValue = "888960326"
   )
   int method3189(ChatPlayer var1, ChatPlayer var2) {
      return var2.rank != var1.rank?(this.field1917?var1.rank - var2.rank:var2.rank - var1.rank):this.method5320(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3189((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(Lbu;IIB)V",
      garbageValue = "93"
   )
   static void method3193(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = class137.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.actionFrameCycle = 0;
            var0.actionAnimationDisable = var2;
            var0.field919 = 0;
         }

         if(var3 == 2) {
            var0.field919 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class137.getAnimation(var1).forcedPriority >= class137.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.actionFrameCycle = 0;
         var0.actionAnimationDisable = var2;
         var0.field919 = 0;
         var0.field942 = var0.queueSize;
      }

   }
}
