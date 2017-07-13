import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class20 {
   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "6"
   )
   static final void method150(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field1178 == -1) {
            Client.field1178 = var0.spriteId;
            Client.field1066 = var0.field2689;
         }

         if(Client.field1177.isFemale) {
            var0.spriteId = Client.field1178;
         } else {
            var0.spriteId = Client.field1066;
         }

      } else if(var1 == 325) {
         if(Client.field1178 == -1) {
            Client.field1178 = var0.spriteId;
            Client.field1066 = var0.field2689;
         }

         if(Client.field1177.isFemale) {
            var0.spriteId = Client.field1066;
         } else {
            var0.spriteId = Client.field1178;
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
