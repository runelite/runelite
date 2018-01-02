import net.runelite.mapping.*;

import java.io.File;
import java.io.RandomAccessFile;

@ObfuscatedName("bv")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1624456843
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -181195109
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1783927465
   )
   @Export("type")
   int type;
   @ObfuscatedName("k")
   @Export("name")
   String name;
   @ObfuscatedName("u")
   @Export("sender")
   String sender;
   @ObfuscatedName("z")
   @Export("value")
   String value;

   @Hook(value = "setMessage", end = true)
   MessageNode(int var1, String var2, String var3, String var4) {
      this.id = FriendLoginUpdate.method1044();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1489597992"
   )
   @Export("setMessage")
   @Hook(value = "setMessage", end = true)
   void setMessage(int var1, String var2, String var3, String var4) {
      this.id = FriendLoginUpdate.method1044();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-959431109"
   )
   static File method1071(String var0) {
      if(!class160.field2150) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class160.field2149.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class160.field2148, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class160.field2149.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-1811690398"
   )
   static char method1070(char var0) {
      return (char)(var0 == 198?69:(var0 == 230?101:(var0 == 223?115:(var0 == 338?69:(var0 == 339?'e':'\u0000')))));
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgh;J)V"
   )
   static void method1073(Buffer var0, long var1) {
      var1 /= 10L;
      if(var1 < 0L) {
         var1 = 0L;
      } else if(var1 > 65535L) {
         var1 = 65535L;
      }

      var0.putShort((int)var1);
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(ZLgy;B)V",
      garbageValue = "-111"
   )
   @Export("npcUpdatePacket")
   static final void npcUpdatePacket(boolean var0, PacketBuffer var1) {
      Client.localNpcsCount = 0;
      Client.pendingNpcFlagsCount = 0;
      class5.npcUpdateViewport();
      SceneMetadata.updateNpcs(var0, var1);
      class27.npcUpdateMasks(var1);

      int var2;
      for(var2 = 0; var2 < Client.localNpcsCount; ++var2) {
         int var3 = Client.npcIndiciesPendingRemoval[var2];
         if(Client.cachedNPCs[var3].npcCycle != Client.gameCycle) {
            Client.cachedNPCs[var3].composition = null;
            Client.cachedNPCs[var3] = null;
         }
      }

      if(var1.offset != Client.field888.packetLength) {
         throw new RuntimeException(var1.offset + "," + Client.field888.packetLength);
      } else {
         for(var2 = 0; var2 < Client.npcIndexesCount; ++var2) {
            if(Client.cachedNPCs[Client.npcIndices[var2]] == null) {
               throw new RuntimeException(var2 + "," + Client.npcIndexesCount);
            }
         }

      }
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "0"
   )
   @Export("writeRespondPlayerRequest")
   static void writeRespondPlayerRequest(int var0, String var1) {
      int var2 = class94.playerIndexesCount;
      int[] var3 = class94.playerIndices;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(var6 != null && var6 != UrlRequest.localPlayer && var6.name != null && var6.name.equalsIgnoreCase(var1)) {
            PacketNode var7;
            if(var0 == 1) {
               var7 = FileSystem.bufferForSize(ClientPacket.field2315, Client.field888.field1449);
               var7.packetBuffer.putByte(0);
               var7.packetBuffer.putShortLE(var3[var5]);
               Client.field888.method1862(var7);
            } else if(var0 == 4) {
               var7 = FileSystem.bufferForSize(ClientPacket.field2359, Client.field888.field1449);
               var7.packetBuffer.method3287(0);
               var7.packetBuffer.putShortLE(var3[var5]);
               Client.field888.method1862(var7);
            } else if(var0 == 6) {
               var7 = FileSystem.bufferForSize(ClientPacket.field2361, Client.field888.field1449);
               var7.packetBuffer.writeIntLE16(var3[var5]);
               var7.packetBuffer.method3285(0);
               Client.field888.method1862(var7);
            } else if(var0 == 7) {
               var7 = FileSystem.bufferForSize(ClientPacket.field2391, Client.field888.field1449);
               var7.packetBuffer.method3287(0);
               var7.packetBuffer.putShortLE(var3[var5]);
               Client.field888.method1862(var7);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class25.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }
}
