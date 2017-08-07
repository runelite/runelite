import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
public class class244 extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static NodeCache field3305;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field3301;
   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("g")
   public boolean field3302;

   static {
      field3305 = new NodeCache(64);
   }

   class244() {
      this.field3302 = false;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfh;IB)V",
      garbageValue = "47"
   )
   void method4311(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3302 = true;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfh;I)V",
      garbageValue = "-935800789"
   )
   void method4312(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4311(var1, var2);
      }
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(Lbk;III)V",
      garbageValue = "1110488029"
   )
   static void method4319(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = Ignore.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1239 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1246 = 0;
         }

         if(var3 == 2) {
            var0.field1246 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || Ignore.getAnimation(var1).forcedPriority >= Ignore.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1239 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1246 = 0;
         var0.field1264 = var0.queueSize;
      }

   }
}
