import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("kj")
   static Widget field1476;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2016798259
   )
   @Export("id")
   int id;
   @ObfuscatedName("pk")
   @ObfuscatedGetter(
      intValue = 480568745
   )
   static int field1479;
   @ObfuscatedName("nk")
   static class276 field1480;
   @ObfuscatedName("rd")
   static Preferences field1481;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -810336505
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;B)V",
      garbageValue = "74"
   )
   @Export("updatePlayersFlag")
   static final void updatePlayersFlag(PacketBuffer packetBuffer) {
      for(int i = 0; i < class96.field1493; ++i) {
         int playerIndex = class96.field1500[i];
         Player player = Client.cachedPlayers[playerIndex];
         int updateFlag = packetBuffer.readUnsignedByte();
         if((updateFlag & 1) != 0) {
            updateFlag += packetBuffer.readUnsignedByte() << 8;
         }

         class41.updatePlayerFlag(packetBuffer, playerIndex, player, updateFlag);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-2066149273"
   )
   protected final Model getModel() {
      return class224.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2077169710"
   )
   static void method1668() {
      if(class17.loadWorlds()) {
         class92.worldSelectShown = true;
      }

   }
}
