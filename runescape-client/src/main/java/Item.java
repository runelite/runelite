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
   static final void method1665(PacketBuffer var0) {
      for(int var1 = 0; var1 < class96.field1493; ++var1) {
         int var2 = class96.field1500[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.readUnsignedByte();
         if((var4 & 1) != 0) {
            var4 += var0.readUnsignedByte() << 8;
         }

         class41.method572(var0, var2, var3, var4);
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
