import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class51 implements class103 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Lds;",
      garbageValue = "1201696267"
   )
   public AbstractSoundSystem vmethod1892() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(Lhy;IIII)V",
      garbageValue = "-341650785"
   )
   static final void method785(Widget var0, int var1, int var2, int var3) {
      class210 var4 = var0.method3980(false);
      if(var4 != null) {
         if(Client.field1140 < 3) {
            class87.compass.method5001(var1, var2, var4.field2600, var4.field2599, 25, 25, Client.mapAngle, 256, var4.field2602, var4.field2601);
         } else {
            Rasterizer2D.method4868(var1, var2, 0, var4.field2602, var4.field2601);
         }

      }
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "14"
   )
   static final void method784(boolean var0) {
      Client.field1029 = 0;
      Client.pendingNpcFlagsCount = 0;
      class46.method708();
      GameEngine.method944(var0);

      int var1;
      int var2;
      for(var1 = 0; var1 < Client.pendingNpcFlagsCount; ++var1) {
         var2 = Client.pendingNpcFlagsIndices[var1];
         NPC var3 = Client.cachedNPCs[var2];
         int var4 = Client.secretPacketBuffer2.readUnsignedByte();
         int var5;
         int var6;
         int var7;
         int var8;
         if((var4 & 16) != 0) {
            var5 = Client.secretPacketBuffer2.readUnsignedByte();
            int var9;
            int var10;
            int var11;
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = Client.secretPacketBuffer2.getUSmart();
                  if(var7 == 32767) {
                     var7 = Client.secretPacketBuffer2.getUSmart();
                     var9 = Client.secretPacketBuffer2.getUSmart();
                     var8 = Client.secretPacketBuffer2.getUSmart();
                     var10 = Client.secretPacketBuffer2.getUSmart();
                  } else if(var7 != 32766) {
                     var9 = Client.secretPacketBuffer2.getUSmart();
                  } else {
                     var7 = -1;
                  }

                  var11 = Client.secretPacketBuffer2.getUSmart();
                  var3.method1489(var7, var9, var8, var10, Client.gameCycle, var11);
               }
            }

            var6 = Client.secretPacketBuffer2.method3249();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = Client.secretPacketBuffer2.getUSmart();
                  var9 = Client.secretPacketBuffer2.getUSmart();
                  if(var9 != 32767) {
                     var10 = Client.secretPacketBuffer2.getUSmart();
                     var11 = Client.secretPacketBuffer2.readUnsignedByte();
                     int var12 = var9 > 0?Client.secretPacketBuffer2.method3166():var11;
                     var3.method1490(var8, Client.gameCycle, var9, var10, var11, var12);
                  } else {
                     var3.method1491(var8);
                  }
               }
            }
         }

         if((var4 & 1) != 0) {
            var3.interacting = Client.secretPacketBuffer2.readUnsignedShort();
            if(var3.interacting == '\uffff') {
               var3.interacting = -1;
            }
         }

         if((var4 & 32) != 0) {
            var3.overhead = Client.secretPacketBuffer2.readString();
            var3.field1230 = 100;
         }

         if((var4 & 64) != 0) {
            var5 = Client.secretPacketBuffer2.readUnsignedShortOb1();
            if(var5 == '\uffff') {
               var5 = -1;
            }

            var6 = Client.secretPacketBuffer2.method3249();
            if(var5 == var3.animation && var5 != -1) {
               var7 = class112.getAnimation(var5).replyMode;
               if(var7 == 1) {
                  var3.actionFrame = 0;
                  var3.field1248 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field1259 = 0;
               }

               if(var7 == 2) {
                  var3.field1259 = 0;
               }
            } else if(var5 == -1 || var3.animation == -1 || class112.getAnimation(var5).forcedPriority >= class112.getAnimation(var3.animation).forcedPriority) {
               var3.animation = var5;
               var3.actionFrame = 0;
               var3.field1248 = 0;
               var3.actionAnimationDisable = var6;
               var3.field1259 = 0;
               var3.field1273 = var3.queueSize;
            }
         }

         if((var4 & 8) != 0) {
            var5 = Client.secretPacketBuffer2.readByteOb1();
            var6 = Client.secretPacketBuffer2.readByteOb1();
            var7 = var3.x - (var5 - class163.baseX - class163.baseX) * 64;
            var8 = var3.y - (var6 - class10.baseY - class10.baseY) * 64;
            if(var7 != 0 || var8 != 0) {
               var3.field1242 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if((var4 & 4) != 0) {
            var3.graphic = Client.secretPacketBuffer2.readByteOb1();
            var5 = Client.secretPacketBuffer2.method3184();
            var3.field1255 = var5 >> 16;
            var3.graphicsDelay = (var5 & '\uffff') + Client.gameCycle;
            var3.field1250 = 0;
            var3.field1253 = 0;
            if(var3.graphicsDelay > Client.gameCycle) {
               var3.field1250 = -1;
            }

            if(var3.graphic == '\uffff') {
               var3.graphic = -1;
            }
         }

         if((var4 & 2) != 0) {
            var3.composition = class224.getNpcDefinition(Client.secretPacketBuffer2.readByteOb1());
            var3.field1218 = var3.composition.field3557;
            var3.field1267 = var3.composition.field3580;
            var3.field1251 = var3.composition.field3563;
            var3.field1223 = var3.composition.field3576;
            var3.field1224 = var3.composition.field3565;
            var3.field1225 = var3.composition.field3583;
            var3.idlePoseAnimation = var3.composition.field3562;
            var3.field1220 = var3.composition.field3561;
            var3.field1244 = var3.composition.field3572;
         }
      }

      for(var1 = 0; var1 < Client.field1029; ++var1) {
         var2 = Client.field1030[var1];
         if(Client.cachedNPCs[var2].field1263 != Client.gameCycle) {
            Client.cachedNPCs[var2].composition = null;
            Client.cachedNPCs[var2] = null;
         }
      }

      if(Client.packetLength != Client.secretPacketBuffer2.offset) {
         throw new RuntimeException(Client.secretPacketBuffer2.offset + "," + Client.packetLength);
      } else {
         for(var1 = 0; var1 < Client.field944; ++var1) {
            if(Client.cachedNPCs[Client.npcIndices[var1]] == null) {
               throw new RuntimeException(var1 + "," + Client.field944);
            }
         }

      }
   }
}
