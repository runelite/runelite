import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public class class88 {
   @ObfuscatedName("x")
   static final BigInteger field1387;
   @ObfuscatedName("g")
   static final BigInteger field1388;

   static {
      field1387 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1388 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1388093473"
   )
   @Export("drawStatusBox")
   static final void drawStatusBox(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = class35.font_p12full.method4777(var0, 250);
      int var6 = class35.font_p12full.method4778(var0, 250) * 13;
      Rasterizer2D.method4968(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
      Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 16777215);
      class35.font_p12full.method4784(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class91.method1724(var3 - var2, var4 - var2, var5 + var2 + var2, var6 + var2 + var2);
      if(var1) {
         IndexFile.field2286.vmethod5043(0, 0);
      } else {
         int var7 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < Client.field1129; ++var11) {
            if(Client.widgetPositionX[var11] + Client.widgetBoundsWidth[var11] > var7 && Client.widgetPositionX[var11] < var9 + var7 && Client.widgetBoundsHeight[var11] + Client.widgetPositionY[var11] > var8 && Client.widgetPositionY[var11] < var10 + var8) {
               Client.field1132[var11] = true;
            }
         }
      }

   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1091702541"
   )
   static void method1705() {
      Client.secretPacketBuffer1.putOpcode(28);
      Client.secretPacketBuffer1.putByte(class13.method77());
      Client.secretPacketBuffer1.putShort(GameEngine.canvasWidth);
      Client.secretPacketBuffer1.putShort(class1.canvasHeight);
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "9"
   )
   static final void method1708(boolean var0) {
      Client.field1048 = 0;
      Client.pendingNpcFlagsCount = 0;
      Client.secretPacketBuffer2.bitAccess();
      int var1 = Client.secretPacketBuffer2.getBits(8);
      int var2;
      if(var1 < Client.field958) {
         for(var2 = var1; var2 < Client.field958; ++var2) {
            Client.field1049[++Client.field1048 - 1] = Client.npcIndices[var2];
         }
      }

      if(var1 > Client.field958) {
         throw new RuntimeException("");
      } else {
         Client.field958 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = Client.npcIndices[var2];
            NPC var4 = Client.cachedNPCs[var3];
            var5 = Client.secretPacketBuffer2.getBits(1);
            if(var5 == 0) {
               Client.npcIndices[++Client.field958 - 1] = var3;
               var4.field1275 = Client.gameCycle;
            } else {
               var6 = Client.secretPacketBuffer2.getBits(2);
               if(var6 == 0) {
                  Client.npcIndices[++Client.field958 - 1] = var3;
                  var4.field1275 = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
               } else if(var6 == 1) {
                  Client.npcIndices[++Client.field958 - 1] = var3;
                  var4.field1275 = Client.gameCycle;
                  var7 = Client.secretPacketBuffer2.getBits(3);
                  var4.method1686(var7, (byte)1);
                  var8 = Client.secretPacketBuffer2.getBits(1);
                  if(var8 == 1) {
                     Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                  }
               } else if(var6 == 2) {
                  Client.npcIndices[++Client.field958 - 1] = var3;
                  var4.field1275 = Client.gameCycle;
                  var7 = Client.secretPacketBuffer2.getBits(3);
                  var4.method1686(var7, (byte)2);
                  var8 = Client.secretPacketBuffer2.getBits(3);
                  var4.method1686(var8, (byte)2);
                  var9 = Client.secretPacketBuffer2.getBits(1);
                  if(var9 == 1) {
                     Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                  }
               } else if(var6 == 3) {
                  Client.field1049[++Client.field1048 - 1] = var3;
               }
            }
         }

         NPC var13;
         int var14;
         while(Client.secretPacketBuffer2.bitsAvail(Client.packetLength) >= 27) {
            var1 = Client.secretPacketBuffer2.getBits(15);
            if(var1 == 32767) {
               break;
            }

            boolean var15 = false;
            if(Client.cachedNPCs[var1] == null) {
               Client.cachedNPCs[var1] = new NPC();
               var15 = true;
            }

            var13 = Client.cachedNPCs[var1];
            Client.npcIndices[++Client.field958 - 1] = var1;
            var13.field1275 = Client.gameCycle;
            var14 = Client.field976[Client.secretPacketBuffer2.getBits(3)];
            if(var15) {
               var13.orientation = var13.angle = var14;
            }

            var5 = Client.secretPacketBuffer2.getBits(1);
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

            if(var0) {
               var7 = Client.secretPacketBuffer2.getBits(8);
               if(var7 > 127) {
                  var7 -= 256;
               }
            } else {
               var7 = Client.secretPacketBuffer2.getBits(5);
               if(var7 > 15) {
                  var7 -= 32;
               }
            }

            var13.composition = class183.getNpcDefinition(Client.secretPacketBuffer2.getBits(14));
            var8 = Client.secretPacketBuffer2.getBits(1);
            if(var8 == 1) {
               Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var1;
            }

            var13.field1219 = var13.composition.field3543;
            var13.field1230 = var13.composition.field3566;
            if(var13.field1230 == 0) {
               var13.angle = 0;
            }

            var13.field1226 = var13.composition.field3549;
            var13.field1218 = var13.composition.field3550;
            var13.field1228 = var13.composition.field3551;
            var13.field1229 = var13.composition.field3546;
            var13.idlePoseAnimation = var13.composition.field3553;
            var13.field1241 = var13.composition.field3563;
            var13.field1225 = var13.composition.field3548;
            var13.method1685(XGrandExchangeOffer.localPlayer.pathX[0] + var7, XGrandExchangeOffer.localPlayer.pathY[0] + var6, var5 == 1);
         }

         Client.secretPacketBuffer2.byteAccess();

         for(var1 = 0; var1 < Client.pendingNpcFlagsCount; ++var1) {
            var2 = Client.pendingNpcFlagsIndices[var1];
            var13 = Client.cachedNPCs[var2];
            var14 = Client.secretPacketBuffer2.readUnsignedByte();
            if((var14 & 8) != 0) {
               var13.interacting = Client.secretPacketBuffer2.method3329();
               if(var13.interacting == '\uffff') {
                  var13.interacting = -1;
               }
            }

            if((var14 & 16) != 0) {
               var5 = Client.secretPacketBuffer2.method3185();
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
                     var13.method1528(var7, var9, var8, var10, Client.gameCycle, var11);
                  }
               }

               var6 = Client.secretPacketBuffer2.method3201();
               if(var6 > 0) {
                  for(var7 = 0; var7 < var6; ++var7) {
                     var8 = Client.secretPacketBuffer2.getUSmart();
                     var9 = Client.secretPacketBuffer2.getUSmart();
                     if(var9 != 32767) {
                        var10 = Client.secretPacketBuffer2.getUSmart();
                        var11 = Client.secretPacketBuffer2.readUnsignedShortOb1();
                        int var12 = var9 > 0?Client.secretPacketBuffer2.readUnsignedByte():var11;
                        var13.method1529(var8, Client.gameCycle, var9, var10, var11, var12);
                     } else {
                        var13.method1530(var8);
                     }
                  }
               }
            }

            if((var14 & 2) != 0) {
               var13.composition = class183.getNpcDefinition(Client.secretPacketBuffer2.readUnsignedShort());
               var13.field1219 = var13.composition.field3543;
               var13.field1230 = var13.composition.field3566;
               var13.field1226 = var13.composition.field3549;
               var13.field1218 = var13.composition.field3550;
               var13.field1228 = var13.composition.field3551;
               var13.field1229 = var13.composition.field3546;
               var13.idlePoseAnimation = var13.composition.field3553;
               var13.field1241 = var13.composition.field3563;
               var13.field1225 = var13.composition.field3548;
            }

            if((var14 & 1) != 0) {
               var13.graphic = Client.secretPacketBuffer2.method3210();
               var5 = Client.secretPacketBuffer2.method3218();
               var13.field1259 = var5 >> 16;
               var13.graphicsDelay = (var5 & '\uffff') + Client.gameCycle;
               var13.field1256 = 0;
               var13.field1257 = 0;
               if(var13.graphicsDelay > Client.gameCycle) {
                  var13.field1256 = -1;
               }

               if(var13.graphic == '\uffff') {
                  var13.graphic = -1;
               }
            }

            if((var14 & 4) != 0) {
               var5 = Client.secretPacketBuffer2.method3329();
               var6 = Client.secretPacketBuffer2.method3329();
               var7 = var13.x - (var5 - class47.baseX - class47.baseX) * 64;
               var8 = var13.y - (var6 - class44.baseY - class44.baseY) * 64;
               if(var7 != 0 || var8 != 0) {
                  var13.field1246 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
               }
            }

            if((var14 & 32) != 0) {
               var5 = Client.secretPacketBuffer2.method3209();
               if(var5 == '\uffff') {
                  var5 = -1;
               }

               var6 = Client.secretPacketBuffer2.method3185();
               if(var5 == var13.animation && var5 != -1) {
                  var7 = PendingSpawn.getAnimation(var5).replyMode;
                  if(var7 == 1) {
                     var13.actionFrame = 0;
                     var13.field1267 = 0;
                     var13.actionAnimationDisable = var6;
                     var13.field1254 = 0;
                  }

                  if(var7 == 2) {
                     var13.field1254 = 0;
                  }
               } else if(var5 == -1 || var13.animation == -1 || PendingSpawn.getAnimation(var5).forcedPriority >= PendingSpawn.getAnimation(var13.animation).forcedPriority) {
                  var13.animation = var5;
                  var13.actionFrame = 0;
                  var13.field1267 = 0;
                  var13.actionAnimationDisable = var6;
                  var13.field1254 = 0;
                  var13.field1277 = var13.queueSize;
               }
            }

            if((var14 & 64) != 0) {
               var13.overhead = Client.secretPacketBuffer2.readString();
               var13.field1274 = 100;
            }
         }

         for(var1 = 0; var1 < Client.field1048; ++var1) {
            var2 = Client.field1049[var1];
            if(Client.cachedNPCs[var2].field1275 != Client.gameCycle) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.packetLength != Client.secretPacketBuffer2.offset) {
            throw new RuntimeException(Client.secretPacketBuffer2.offset + "," + Client.packetLength);
         } else {
            for(var1 = 0; var1 < Client.field958; ++var1) {
               if(Client.cachedNPCs[Client.npcIndices[var1]] == null) {
                  throw new RuntimeException(var1 + "," + Client.field958);
               }
            }

         }
      }
   }
}
