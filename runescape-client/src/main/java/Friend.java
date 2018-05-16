import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kf")
@Implements("Friend")
public class Friend extends ChatPlayer {
   @ObfuscatedName("w")
   boolean field3664;
   @ObfuscatedName("m")
   boolean field3663;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lkf;I)I",
      garbageValue = "1903277839"
   )
   int method5485(Friend var1) {
      return super.world == Client.world && Client.world != var1.world?-1:(Client.world == var1.world && super.world != Client.world?1:(super.world != 0 && var1.world == 0?-1:(var1.world != 0 && super.world == 0?1:(this.field3664 && !var1.field3664?-1:(!this.field3664 && var1.field3664?1:(this.field3663 && !var1.field3663?-1:(!this.field3663 && var1.field3663?1:(super.world != 0?super.field3649 - var1.field3649:var1.field3649 - super.field3649))))))));
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljn;I)I",
      garbageValue = "1707398523"
   )
   public int vmethod5482(Nameable var1) {
      return this.method5485((Friend)var1);
   }

   public int compareTo(Object var1) {
      return this.method5485((Friend)var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lbb;I)V",
      garbageValue = "-2026437852"
   )
   @Export("changeWorld")
   static void changeWorld(World var0) {
      if(var0.method1603() != Client.isMembers) {
         Client.isMembers = var0.method1603();
         boolean var1 = var0.method1603();
         if(var1 != GrandExchangeOffer.isMembersWorld) {
            class21.method303();
            GrandExchangeOffer.isMembersWorld = var1;
         }
      }

      WorldComparator.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      ServerPacket.port1 = Client.socketType == 0?43594:var0.id + 40000;
      class13.port2 = Client.socketType == 0?443:var0.id + 50000;
      Size.myWorldPort = ServerPacket.port1;
   }
}
