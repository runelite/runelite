import java.util.LinkedList;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public abstract class class28 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1659610075
   )
   int field390;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -494707005
   )
   int field388;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1861708317
   )
   int field392;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -149116543
   )
   int field391;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 832844171
   )
   int field389;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 946731561
   )
   int field393;
   @ObfuscatedName("s")
   short[][][] field394;
   @ObfuscatedName("b")
   short[][][] field395;
   @ObfuscatedName("e")
   byte[][][] field396;
   @ObfuscatedName("f")
   byte[][][] field397;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "[[[[Laf;"
   )
   class31[][][][] field398;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IILgv;I)V",
      garbageValue = "1907312354"
   )
   void method211(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method212(var1, var2, var3, var4);
         } else {
            this.method213(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IILgv;II)V",
      garbageValue = "-857846096"
   )
   void method212(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field395[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field394[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILgv;IB)V",
      garbageValue = "-105"
   )
   void method213(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field394[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field395[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field396[var9][var1][var2] = (byte)(var11 >> 2);
               this.field397[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field398[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3514();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1062785844"
   )
   int method218(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field394[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "757645590"
   )
   int method231() {
      return this.field392;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1521876128"
   )
   int method214() {
      return this.field391;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "1319537812"
   )
   static final void method230(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class94.field1403 = 0;
      int var3 = 0;
      var0.bitAccess();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < class94.playerIndexesCount; ++var4) {
         var5 = class94.playerIndices[var4];
         if((class94.field1402[var5] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class94.field1402[var5] = (byte)(class94.field1402[var5] | 2);
            } else {
               var6 = var0.getBits(1);
               if(var6 == 0) {
                  var3 = Varcs.method1852(var0);
                  class94.field1402[var5] = (byte)(class94.field1402[var5] | 2);
               } else {
                  ServerPacket.decodeMovement(var0, var5);
               }
            }
         }
      }

      var0.byteAccess();
      if(var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var4 = 0; var4 < class94.playerIndexesCount; ++var4) {
            var5 = class94.playerIndices[var4];
            if((class94.field1402[var5] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class94.field1402[var5] = (byte)(class94.field1402[var5] | 2);
               } else {
                  var6 = var0.getBits(1);
                  if(var6 == 0) {
                     var3 = Varcs.method1852(var0);
                     class94.field1402[var5] = (byte)(class94.field1402[var5] | 2);
                  } else {
                     ServerPacket.decodeMovement(var0, var5);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var4 = 0; var4 < class94.field1407; ++var4) {
               var5 = class94.field1412[var4];
               if((class94.field1402[var5] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class94.field1402[var5] = (byte)(class94.field1402[var5] | 2);
                  } else {
                     var6 = var0.getBits(1);
                     if(var6 == 0) {
                        var3 = Varcs.method1852(var0);
                        class94.field1402[var5] = (byte)(class94.field1402[var5] | 2);
                     } else if(GrandExchangeEvent.decodeRegionHash(var0, var5)) {
                        class94.field1402[var5] = (byte)(class94.field1402[var5] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var4 = 0; var4 < class94.field1407; ++var4) {
                  var5 = class94.field1412[var4];
                  if((class94.field1402[var5] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class94.field1402[var5] = (byte)(class94.field1402[var5] | 2);
                     } else {
                        var6 = var0.getBits(1);
                        if(var6 == 0) {
                           var3 = Varcs.method1852(var0);
                           class94.field1402[var5] = (byte)(class94.field1402[var5] | 2);
                        } else if(GrandExchangeEvent.decodeRegionHash(var0, var5)) {
                           class94.field1402[var5] = (byte)(class94.field1402[var5] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class94.playerIndexesCount = 0;
                  class94.field1407 = 0;

                  Player var7;
                  for(var4 = 1; var4 < 2048; ++var4) {
                     class94.field1402[var4] = (byte)(class94.field1402[var4] >> 1);
                     var7 = Client.cachedPlayers[var4];
                     if(var7 != null) {
                        class94.playerIndices[++class94.playerIndexesCount - 1] = var4;
                     } else {
                        class94.field1412[++class94.field1407 - 1] = var4;
                     }
                  }

                  for(var3 = 0; var3 < class94.field1403; ++var3) {
                     var4 = class94.field1413[var3];
                     var7 = Client.cachedPlayers[var4];
                     var6 = var0.readUnsignedByte();
                     if((var6 & 128) != 0) {
                        var6 += var0.readUnsignedByte() << 8;
                     }

                     KeyFocusListener.method755(var0, var4, var7, var6);
                  }

                  if(var0.offset - var2 != var1) {
                     throw new RuntimeException(var0.offset - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(ZLgr;I)V",
      garbageValue = "1795268632"
   )
   static final void method233(boolean var0, PacketBuffer var1) {
      Client.field978 = 0;
      Client.pendingNpcFlagsCount = 0;
      PacketBuffer var2 = Client.field915.packetBuffer;
      var2.bitAccess();
      int var3 = var2.getBits(8);
      int var4;
      if(var3 < Client.npcIndexesCount) {
         for(var4 = var3; var4 < Client.npcIndexesCount; ++var4) {
            Client.field979[++Client.field978 - 1] = Client.npcIndices[var4];
         }
      }

      if(var3 > Client.npcIndexesCount) {
         throw new RuntimeException("");
      } else {
         Client.npcIndexesCount = 0;

         for(var4 = 0; var4 < var3; ++var4) {
            int var5 = Client.npcIndices[var4];
            NPC var6 = Client.cachedNPCs[var5];
            int var7 = var2.getBits(1);
            if(var7 == 0) {
               Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
               var6.npcCycle = Client.gameCycle;
            } else {
               int var8 = var2.getBits(2);
               if(var8 == 0) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                  var6.npcCycle = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
               } else {
                  int var9;
                  int var10;
                  if(var8 == 1) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                     var6.npcCycle = Client.gameCycle;
                     var9 = var2.getBits(3);
                     var6.method1716(var9, (byte)1);
                     var10 = var2.getBits(1);
                     if(var10 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
                     }
                  } else if(var8 == 2) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                     var6.npcCycle = Client.gameCycle;
                     var9 = var2.getBits(3);
                     var6.method1716(var9, (byte)2);
                     var10 = var2.getBits(3);
                     var6.method1716(var10, (byte)2);
                     int var11 = var2.getBits(1);
                     if(var11 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
                     }
                  } else if(var8 == 3) {
                     Client.field979[++Client.field978 - 1] = var5;
                  }
               }
            }
         }

         class81.updateNpcs(var0, var1);
         method210(var1);

         int var12;
         for(var12 = 0; var12 < Client.field978; ++var12) {
            var3 = Client.field979[var12];
            if(Client.cachedNPCs[var3].npcCycle != Client.gameCycle) {
               Client.cachedNPCs[var3].composition = null;
               Client.cachedNPCs[var3] = null;
            }
         }

         if(var1.offset != Client.field915.packetLength) {
            throw new RuntimeException(var1.offset + "," + Client.field915.packetLength);
         } else {
            for(var12 = 0; var12 < Client.npcIndexesCount; ++var12) {
               if(Client.cachedNPCs[Client.npcIndices[var12]] == null) {
                  throw new RuntimeException(var12 + "," + Client.npcIndexesCount);
               }
            }

         }
      }
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(Lgr;S)V",
      garbageValue = "5003"
   )
   static final void method210(PacketBuffer var0) {
      for(int var1 = 0; var1 < Client.pendingNpcFlagsCount; ++var1) {
         int var2 = Client.pendingNpcFlagsIndices[var1];
         NPC var3 = Client.cachedNPCs[var2];
         int var4 = var0.readUnsignedByte();
         int var5;
         int var6;
         int var7;
         int var8;
         if((var4 & 1) != 0) {
            var5 = var0.readUnsignedShort();
            var6 = var0.readUnsignedShort();
            var7 = var3.x - (var5 - class175.baseX - class175.baseX) * 64;
            var8 = var3.y - (var6 - GraphicsObject.baseY - GraphicsObject.baseY) * 64;
            if(var7 != 0 || var8 != 0) {
               var3.field1177 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if((var4 & 16) != 0) {
            var5 = var0.method3374();
            int var9;
            int var10;
            int var11;
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = var0.getUSmart();
                  if(var7 == 32767) {
                     var7 = var0.getUSmart();
                     var9 = var0.getUSmart();
                     var8 = var0.getUSmart();
                     var10 = var0.getUSmart();
                  } else if(var7 != 32766) {
                     var9 = var0.getUSmart();
                  } else {
                     var7 = -1;
                  }

                  var11 = var0.getUSmart();
                  var3.method1560(var7, var9, var8, var10, Client.gameCycle, var11);
               }
            }

            var6 = var0.method3363();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  if(var9 != 32767) {
                     var10 = var0.getUSmart();
                     var11 = var0.readUnsignedByteNegate();
                     int var12 = var9 > 0?var0.readUnsignedByteNegate():var11;
                     var3.method1556(var8, Client.gameCycle, var9, var10, var11, var12);
                  } else {
                     var3.method1558(var8);
                  }
               }
            }
         }

         if((var4 & 64) != 0) {
            var3.interacting = var0.readUnsignedShortOb1();
            if(var3.interacting == 65535) {
               var3.interacting = -1;
            }
         }

         if((var4 & 32) != 0) {
            var3.graphic = var0.method3337();
            var5 = var0.method3383();
            var3.field1190 = var5 >> 16;
            var3.graphicsDelay = (var5 & 65535) + Client.gameCycle;
            var3.field1187 = 0;
            var3.field1188 = 0;
            if(var3.graphicsDelay > Client.gameCycle) {
               var3.field1187 = -1;
            }

            if(var3.graphic == 65535) {
               var3.graphic = -1;
            }
         }

         if((var4 & 2) != 0) {
            var5 = var0.readUnsignedShortOb1();
            if(var5 == 65535) {
               var5 = -1;
            }

            var6 = var0.readUnsignedByteNegate();
            if(var5 == var3.animation && var5 != -1) {
               var7 = class45.getAnimation(var5).replyMode;
               if(var7 == 1) {
                  var3.actionFrame = 0;
                  var3.field1159 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field1185 = 0;
               }

               if(var7 == 2) {
                  var3.field1185 = 0;
               }
            } else if(var5 == -1 || var3.animation == -1 || class45.getAnimation(var5).forcedPriority >= class45.getAnimation(var3.animation).forcedPriority) {
               var3.animation = var5;
               var3.actionFrame = 0;
               var3.field1159 = 0;
               var3.actionAnimationDisable = var6;
               var3.field1185 = 0;
               var3.field1208 = var3.queueSize;
            }
         }

         if((var4 & 4) != 0) {
            var3.composition = class45.getNpcDefinition(var0.readUnsignedShortOb1());
            var3.field1153 = var3.composition.field3667;
            var3.field1202 = var3.composition.field3662;
            var3.field1168 = var3.composition.field3659;
            var3.field1158 = var3.composition.field3646;
            var3.field1175 = var3.composition.field3645;
            var3.field1160 = var3.composition.field3657;
            var3.idlePoseAnimation = var3.composition.field3642;
            var3.field1156 = var3.composition.field3643;
            var3.field1173 = var3.composition.field3644;
         }

         if((var4 & 8) != 0) {
            var3.overhead = var0.readString();
            var3.overheadTextCyclesRemaining = 100;
         }
      }

   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(Lhq;I)V",
      garbageValue = "727985606"
   )
   static void method220(Widget var0) {
      if(var0.loopCycle == Client.field1059) {
         Client.field1041[var0.boundsIndex] = true;
      }

   }
}
