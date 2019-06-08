import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("GroundItem")
public final class GroundItem extends Entity {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 893970699
   )
   @Export("id")
   int id;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 454094667
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ldu;",
      garbageValue = "-2134947096"
   )
   protected final Model getModel() {
      return Skills.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1050170563"
   )
   static void method2094() {
      Messages.Messages_channels.clear();
      Messages.Messages_hashTable.clear();
      Messages.Messages_queue.clear();
      Messages.Messages_count = 0;
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "411352848"
   )
   static void method2095(int var0) {
      Client.__client_oa = 0L;
      if(var0 >= 2) {
         Client.isResizable = true;
      } else {
         Client.isResizable = false;
      }

      if(SpotAnimationDefinition.method4822() == 1) {
         TextureProvider.client.setMaxCanvasSize(765, 503);
      } else {
         TextureProvider.client.setMaxCanvasSize(7680, 2160);
      }

      if(Client.gameState >= 25) {
         AbstractByteArrayCopier.method4024();
      }

   }
}
