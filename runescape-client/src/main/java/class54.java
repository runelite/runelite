import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class54 {
   @ObfuscatedName("d")
   public static int[] field635;
   @ObfuscatedName("w")
   static int[] field639;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "55142388"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1973751084"
   )
   static final void method781(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field977 == 1) && Client.friendCount < 400) {
            String var1 = WorldMapData.cleanUsername(var0, GrandExchangeOffer.jagexLoginType);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = WorldMapData.cleanUsername(var3.name, GrandExchangeOffer.jagexLoginType);
                  if(var4 != null && var4.equals(var1)) {
                     Preferences.sendGameMessage(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.previousName != null) {
                     var5 = WorldMapData.cleanUsername(var3.previousName, GrandExchangeOffer.jagexLoginType);
                     if(var5 != null && var5.equals(var1)) {
                        Preferences.sendGameMessage(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var7 = Client.ignores[var2];
                  var4 = WorldMapData.cleanUsername(var7.name, GrandExchangeOffer.jagexLoginType);
                  if(var4 != null && var4.equals(var1)) {
                     Preferences.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var7.previousName != null) {
                     var5 = WorldMapData.cleanUsername(var7.previousName, GrandExchangeOffer.jagexLoginType);
                     if(var5 != null && var5.equals(var1)) {
                        Preferences.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(WorldMapData.cleanUsername(GrandExchangeOffer.localPlayer.name, GrandExchangeOffer.jagexLoginType).equals(var1)) {
                  Preferences.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  PacketNode var6 = class235.method4272(ClientPacket.field2422, Client.field915.field1462);
                  var6.packetBuffer.putByte(Size.getLength(var0));
                  var6.packetBuffer.putString(var0);
                  Client.field915.method1898(var6);
               }
            }
         } else {
            Preferences.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }
}
