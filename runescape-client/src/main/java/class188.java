import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class188 {
   @ObfuscatedName("nm")
   @ObfuscatedSignature(
      signature = "[Lbu;"
   )
   @Export("clanMembers")
   static ClanMember[] clanMembers;

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "201905336"
   )
   static final void method3609(String var0) {
      if(var0 != null) {
         String var1 = GraphicsObject.cleanUsername(var0, class236.jagexLoginType);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.friendCount; ++var2) {
               Friend var3 = Client.friends[var2];
               String var4 = var3.name;
               String var5 = GraphicsObject.cleanUsername(var4, class236.jagexLoginType);
               boolean var6;
               if(var0 != null && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --Client.friendCount;

                  for(int var7 = var2; var7 < Client.friendCount; ++var7) {
                     Client.friends[var7] = Client.friends[var7 + 1];
                  }

                  Client.field977 = Client.cycleCntr;
                  PacketNode var8 = class218.method4105(ClientPacket.field2337, Client.field916.field1470);
                  var8.packetBuffer.putByte(AbstractSoundSystem.getLength(var0));
                  var8.packetBuffer.putString(var0);
                  Client.field916.method1925(var8);
                  break;
               }
            }

         }
      }
   }
}
