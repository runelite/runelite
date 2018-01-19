import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class87 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 291410129
   )
   @Export("canvasWidth")
   public static int canvasWidth;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)[B",
      garbageValue = "364372291"
   )
   public static byte[] method1741(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 > 0 && var4 < 128 || var4 >= 160 && var4 <= 255) {
            var2[var3] = (byte)var4;
         } else if(var4 == 8364) {
            var2[var3] = -128;
         } else if(var4 == 8218) {
            var2[var3] = -126;
         } else if(var4 == 402) {
            var2[var3] = -125;
         } else if(var4 == 8222) {
            var2[var3] = -124;
         } else if(var4 == 8230) {
            var2[var3] = -123;
         } else if(var4 == 8224) {
            var2[var3] = -122;
         } else if(var4 == 8225) {
            var2[var3] = -121;
         } else if(var4 == 710) {
            var2[var3] = -120;
         } else if(var4 == 8240) {
            var2[var3] = -119;
         } else if(var4 == 352) {
            var2[var3] = -118;
         } else if(var4 == 8249) {
            var2[var3] = -117;
         } else if(var4 == 338) {
            var2[var3] = -116;
         } else if(var4 == 381) {
            var2[var3] = -114;
         } else if(var4 == 8216) {
            var2[var3] = -111;
         } else if(var4 == 8217) {
            var2[var3] = -110;
         } else if(var4 == 8220) {
            var2[var3] = -109;
         } else if(var4 == 8221) {
            var2[var3] = -108;
         } else if(var4 == 8226) {
            var2[var3] = -107;
         } else if(var4 == 8211) {
            var2[var3] = -106;
         } else if(var4 == 8212) {
            var2[var3] = -105;
         } else if(var4 == 732) {
            var2[var3] = -104;
         } else if(var4 == 8482) {
            var2[var3] = -103;
         } else if(var4 == 353) {
            var2[var3] = -102;
         } else if(var4 == 8250) {
            var2[var3] = -101;
         } else if(var4 == 339) {
            var2[var3] = -100;
         } else if(var4 == 382) {
            var2[var3] = -98;
         } else if(var4 == 376) {
            var2[var3] = -97;
         } else {
            var2[var3] = 63;
         }
      }

      return var2;
   }

   @ObfuscatedName("kj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1338909166"
   )
   static final void method1740(String var0, boolean var1) {
      if(var0 != null) {
         if((Client.ignoreCount < 100 || Client.field977 == 1) && Client.ignoreCount < 400) {
            String var2 = WorldMapData.cleanUsername(var0, GrandExchangeOffer.jagexLoginType);
            if(var2 != null) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < Client.ignoreCount; ++var3) {
                  Ignore var4 = Client.ignores[var3];
                  var5 = WorldMapData.cleanUsername(var4.name, GrandExchangeOffer.jagexLoginType);
                  if(var5 != null && var5.equals(var2)) {
                     Preferences.sendGameMessage(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(var4.previousName != null) {
                     var6 = WorldMapData.cleanUsername(var4.previousName, GrandExchangeOffer.jagexLoginType);
                     if(var6 != null && var6.equals(var2)) {
                        Preferences.sendGameMessage(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < Client.friendCount; ++var3) {
                  Friend var8 = Client.friends[var3];
                  var5 = WorldMapData.cleanUsername(var8.name, GrandExchangeOffer.jagexLoginType);
                  if(var5 != null && var5.equals(var2)) {
                     Preferences.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var8.previousName != null) {
                     var6 = WorldMapData.cleanUsername(var8.previousName, GrandExchangeOffer.jagexLoginType);
                     if(var6 != null && var6.equals(var2)) {
                        Preferences.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(WorldMapData.cleanUsername(GrandExchangeOffer.localPlayer.name, GrandExchangeOffer.jagexLoginType).equals(var2)) {
                  Preferences.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  PacketNode var7 = class235.method4272(ClientPacket.field2331, Client.field915.field1462);
                  var7.packetBuffer.putByte(Size.getLength(var0));
                  var7.packetBuffer.putString(var0);
                  Client.field915.method1898(var7);
               }
            }
         } else {
            Preferences.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }
}
