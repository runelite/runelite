import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class23 {
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = -1238294817
   )
   static int field366;

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1103258524"
   )
   static final void method175(boolean var0) {
      Client.field1037 = 0;
      Client.pendingNpcFlagsCount = 0;
      RSCanvas.method775();

      int var1;
      while(Client.secretPacketBuffer2.bitsAvail(Client.packetLength) >= 27) {
         var1 = Client.secretPacketBuffer2.getBits(15);
         if(var1 == 32767) {
            break;
         }

         boolean var2 = false;
         if(Client.cachedNPCs[var1] == null) {
            Client.cachedNPCs[var1] = new NPC();
            var2 = true;
         }

         NPC var3 = Client.cachedNPCs[var1];
         Client.npcIndices[++Client.npcIndexesCount - 1] = var1;
         var3.field1255 = Client.gameCycle;
         int var4;
         if(var0) {
            var4 = Client.secretPacketBuffer2.getBits(8);
            if(var4 > 127) {
               var4 -= 256;
            }
         } else {
            var4 = Client.secretPacketBuffer2.getBits(5);
            if(var4 > 15) {
               var4 -= 32;
            }
         }

         int var5 = Client.secretPacketBuffer2.getBits(1);
         if(var5 == 1) {
            Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var1;
         }

         int var6;
         if(var0) {
            var6 = Client.secretPacketBuffer2.getBits(8);
            if(var6 > 127) {
               var6 -= 256;
            }
         } else {
            var6 = Client.secretPacketBuffer2.getBits(5);
            if(var6 > 15) {
               var6 -= 32;
            }
         }

         var3.composition = class17.getNpcDefinition(Client.secretPacketBuffer2.getBits(14));
         int var7 = Client.secretPacketBuffer2.getBits(1);
         int var8 = Client.field1042[Client.secretPacketBuffer2.getBits(3)];
         if(var2) {
            var3.orientation = var3.angle = var8;
         }

         var3.field1221 = var3.composition.field3555;
         var3.field1262 = var3.composition.field3562;
         if(var3.field1262 == 0) {
            var3.angle = 0;
         }

         var3.field1217 = var3.composition.field3573;
         var3.field1218 = var3.composition.field3578;
         var3.field1219 = var3.composition.field3563;
         var3.field1220 = var3.composition.field3564;
         var3.idlePoseAnimation = var3.composition.field3549;
         var3.field1253 = var3.composition.field3585;
         var3.field1227 = var3.composition.field3560;
         var3.method1694(class66.localPlayer.pathX[0] + var4, class66.localPlayer.pathY[0] + var6, var7 == 1);
      }

      Client.secretPacketBuffer2.byteAccess();
      class21.method162();

      for(var1 = 0; var1 < Client.field1037; ++var1) {
         int var9 = Client.field1038[var1];
         if(Client.cachedNPCs[var9].field1255 != Client.gameCycle) {
            Client.cachedNPCs[var9].composition = null;
            Client.cachedNPCs[var9] = null;
         }
      }

      if(Client.packetLength != Client.secretPacketBuffer2.offset) {
         throw new RuntimeException(Client.secretPacketBuffer2.offset + "," + Client.packetLength);
      } else {
         for(var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
            if(Client.cachedNPCs[Client.npcIndices[var1]] == null) {
               throw new RuntimeException(var1 + "," + Client.npcIndexesCount);
            }
         }

      }
   }
}
