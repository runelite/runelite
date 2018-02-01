import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class35 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lau;"
   )
   static final class35 field460;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lau;"
   )
   static final class35 field461;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -365963771
   )
   static int field464;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1244337563
   )
   final int field462;

   static {
      field460 = new class35(0);
      field461 = new class35(1);
   }

   class35(int var1) {
      this.field462 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Lho;",
      garbageValue = "217431509"
   )
   @Export("getWidget")
   public static Widget getWidget(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & 65535;
      if(FileRequest.widgets[var1] == null || FileRequest.widgets[var1][var2] == null) {
         boolean var3 = class213.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return FileRequest.widgets[var1][var2];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfy;Lgo;B)Lfa;",
      garbageValue = "0"
   )
   public static PacketNode method501(ClientPacket var0, ISAACCipher var1) {
      PacketNode var2 = class186.method3627();
      var2.clientPacket = var0;
      var2.field2399 = var0.packetLength;
      if(var2.field2399 == -1) {
         var2.packetBuffer = new PacketBuffer(260);
      } else if(var2.field2399 == -2) {
         var2.packetBuffer = new PacketBuffer(10000);
      } else if(var2.field2399 <= 18) {
         var2.packetBuffer = new PacketBuffer(20);
      } else if(var2.field2399 <= 98) {
         var2.packetBuffer = new PacketBuffer(100);
      } else {
         var2.packetBuffer = new PacketBuffer(260);
      }

      var2.packetBuffer.setIsaacCipher(var1);
      var2.packetBuffer.putOpcode(var2.clientPacket.packetId);
      var2.field2400 = 0;
      return var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILcd;ZB)I",
      garbageValue = "3"
   )
   static int method500(int var0, Script var1, boolean var2) {
      Widget var3 = getWidget(class80.intStack[--class80.intStackSize]);
      if(var0 == 2600) {
         class80.intStack[++class80.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 2601) {
         class80.intStack[++class80.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 2602) {
         class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 2603) {
         class80.intStack[++class80.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         class80.intStack[++class80.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         class80.intStack[++class80.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 2606) {
         class80.intStack[++class80.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 2607) {
         class80.intStack[++class80.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 2608) {
         class80.intStack[++class80.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 2609) {
         class80.intStack[++class80.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 2610) {
         class80.intStack[++class80.intStackSize - 1] = var3.field2770;
         return 1;
      } else if(var0 == 2611) {
         class80.intStack[++class80.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 2612) {
         class80.intStack[++class80.intStackSize - 1] = var3.field2764;
         return 1;
      } else if(var0 == 2613) {
         class80.intStack[++class80.intStackSize - 1] = var3.field2758.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1372637622"
   )
   static final void method503(String var0) {
      PacketNode var1 = method501(ClientPacket.field2323, Client.field867.field1439);
      var1.packetBuffer.putByte(ContextMenuRow.getLength(var0));
      var1.packetBuffer.putString(var0);
      Client.field867.method2021(var1);
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "670801293"
   )
   static final void method499() {
      for(Projectile var0 = (Projectile)Client.projectiles.getFront(); var0 != null; var0 = (Projectile)Client.projectiles.getNext()) {
         if(var0.floor == MessageNode.plane && Client.gameCycle <= var0.endCycle) {
            if(Client.gameCycle >= var0.startMovementCycle) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.moveProjectile(var1.x, var1.y, GameCanvas.getTileHeight(var1.x, var1.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = class36.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.moveProjectile(var3.x, var3.y, GameCanvas.getTileHeight(var3.x, var3.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               var0.update(Client.field882);
               class48.region.method2822(MessageNode.plane, (int)var0.x, (int)var0.y, (int)var0.z, 60, var0, var0.rotationX, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }
}
