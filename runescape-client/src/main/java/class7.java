import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class7 {
   @ObfuscatedName("a")
   @Export("drawBoundingBoxes3D")
   public static boolean drawBoundingBoxes3D;
   @ObfuscatedName("w")
   @Export("drawBoundingBoxes2D")
   public static boolean drawBoundingBoxes2D;
   @ObfuscatedName("e")
   @Export("drawObjectGeometry2D")
   public static boolean drawObjectGeometry2D;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lc;"
   )
   @Export("boundingBox3DDrawMode")
   public static class11 boundingBox3DDrawMode;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("boundingBoxes")
   public static CombatInfoList boundingBoxes;
   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   @Export("slArrowSprites")
   static IndexedSprite[] slArrowSprites;

   static {
      drawBoundingBoxes3D = false;
      drawBoundingBoxes2D = false;
      drawObjectGeometry2D = false;
      boundingBox3DDrawMode = class11.BoundingBox3DDrawMode_mouseOver;
      boundingBoxes = new CombatInfoList();
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1884317379"
   )
   static final void method34(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field918 == 1) && Client.friendCount < 400) {
            String var1 = class221.cleanUsername(var0, PendingSpawn.jagexLoginType);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = class221.cleanUsername(var3.name, PendingSpawn.jagexLoginType);
                  if(var4 != null && var4.equals(var1)) {
                     class25.sendGameMessage(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.previousName != null) {
                     var5 = class221.cleanUsername(var3.previousName, PendingSpawn.jagexLoginType);
                     if(var5 != null && var5.equals(var1)) {
                        class25.sendGameMessage(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var7 = Client.ignores[var2];
                  var4 = class221.cleanUsername(var7.name, PendingSpawn.jagexLoginType);
                  if(var4 != null && var4.equals(var1)) {
                     class25.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var7.previousName != null) {
                     var5 = class221.cleanUsername(var7.previousName, PendingSpawn.jagexLoginType);
                     if(var5 != null && var5.equals(var1)) {
                        class25.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class221.cleanUsername(UrlRequest.localPlayer.name, PendingSpawn.jagexLoginType).equals(var1)) {
                  class25.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  PacketNode var6 = FileSystem.method4252(ClientPacket.field2349, Client.field888.field1449);
                  var6.packetBuffer.putByte(Ignore.getLength(var0));
                  var6.packetBuffer.putString(var0);
                  Client.field888.method1862(var6);
               }
            }
         } else {
            class25.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }
}
