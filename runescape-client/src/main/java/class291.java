import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kb")
public abstract class class291 {
   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(Lhx;B)V",
      garbageValue = "-102"
   )
   static final void method5341(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field1204 == -1) {
            Client.field1204 = var0.spriteId;
            Client.field1205 = var0.field2668;
         }

         if(Client.field1078.isFemale) {
            var0.spriteId = Client.field1204;
         } else {
            var0.spriteId = Client.field1205;
         }

      } else if(var1 == 325) {
         if(Client.field1204 == -1) {
            Client.field1204 = var0.spriteId;
            Client.field1205 = var0.field2668;
         }

         if(Client.field1078.isFemale) {
            var0.spriteId = Client.field1205;
         } else {
            var0.spriteId = Client.field1204;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }
}
