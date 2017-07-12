import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("k")
   public static short[][] field2620;
   @ObfuscatedName("w")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("a")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1397426691
   )
   @Export("transformedNpcId")
   public int transformedNpcId;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -1250468515690502403L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 8511230713991366085L
   )
   long field2625;
   @ObfuscatedName("y")
   @Export("colorsToReplace")
   public static short[][] colorsToReplace;
   @ObfuscatedName("e")
   static final int[] field2628;
   @ObfuscatedName("i")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("o")
   public static NodeCache field2630;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "981590401"
   )
   public void method3931(boolean var1) {
      if(this.isFemale != var1) {
         this.method3962((int[])null, this.bodyPartColours, var1, -1);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-138645642"
   )
   public void method3932(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = colorsToReplace[var1].length - 1;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      } else {
         do {
            ++var3;
            if(var3 >= colorsToReplace[var1].length) {
               var3 = 0;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      }

      this.bodyPartColours[var1] = var3;
      this.setHash();
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "18995"
   )
   static final void method3933(boolean var0) {
      Client.field1050 = 0;
      Client.pendingNpcFlagsCount = 0;
      Client.secretPacketBuffer2.bitAccess();
      int var1 = Client.secretPacketBuffer2.getBits(8);
      int var2;
      if(var1 < Client.field937) {
         for(var2 = var1; var2 < Client.field937; ++var2) {
            Client.field1051[++Client.field1050 - 1] = Client.npcIndices[var2];
         }
      }

      if(var1 > Client.field937) {
         throw new RuntimeException("");
      } else {
         Client.field937 = 0;

         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         for(var2 = 0; var2 < var1; ++var2) {
            int var8 = Client.npcIndices[var2];
            NPC var9 = Client.cachedNPCs[var8];
            var3 = Client.secretPacketBuffer2.getBits(1);
            if(var3 == 0) {
               Client.npcIndices[++Client.field937 - 1] = var8;
               var9.field1287 = Client.gameCycle;
            } else {
               var4 = Client.secretPacketBuffer2.getBits(2);
               if(var4 == 0) {
                  Client.npcIndices[++Client.field937 - 1] = var8;
                  var9.field1287 = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var8;
               } else if(var4 == 1) {
                  Client.npcIndices[++Client.field937 - 1] = var8;
                  var9.field1287 = Client.gameCycle;
                  var5 = Client.secretPacketBuffer2.getBits(3);
                  var9.method1696(var5, (byte)1);
                  var6 = Client.secretPacketBuffer2.getBits(1);
                  if(var6 == 1) {
                     Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var8;
                  }
               } else if(var4 == 2) {
                  Client.npcIndices[++Client.field937 - 1] = var8;
                  var9.field1287 = Client.gameCycle;
                  var5 = Client.secretPacketBuffer2.getBits(3);
                  var9.method1696(var5, (byte)2);
                  var6 = Client.secretPacketBuffer2.getBits(3);
                  var9.method1696(var6, (byte)2);
                  var7 = Client.secretPacketBuffer2.getBits(1);
                  if(var7 == 1) {
                     Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var8;
                  }
               } else if(var4 == 3) {
                  Client.field1051[++Client.field1050 - 1] = var8;
               }
            }
         }

         class40.method562(var0);

         for(var1 = 0; var1 < Client.pendingNpcFlagsCount; ++var1) {
            var2 = Client.pendingNpcFlagsIndices[var1];
            NPC var13 = Client.cachedNPCs[var2];
            int var14 = Client.secretPacketBuffer2.readUnsignedByte();
            if((var14 & 4) != 0) {
               var3 = Client.secretPacketBuffer2.readByteOb1();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               var4 = Client.secretPacketBuffer2.method3173();
               if(var3 == var13.animation && var3 != -1) {
                  var5 = class224.getAnimation(var3).replyMode;
                  if(var5 == 1) {
                     var13.actionFrame = 0;
                     var13.field1247 = 0;
                     var13.actionAnimationDisable = var4;
                     var13.field1262 = 0;
                  }

                  if(var5 == 2) {
                     var13.field1262 = 0;
                  }
               } else if(var3 == -1 || var13.animation == -1 || class224.getAnimation(var3).forcedPriority >= class224.getAnimation(var13.animation).forcedPriority) {
                  var13.animation = var3;
                  var13.actionFrame = 0;
                  var13.field1247 = 0;
                  var13.actionAnimationDisable = var4;
                  var13.field1262 = 0;
                  var13.field1269 = var13.queueSize;
               }
            }

            if((var14 & 2) != 0) {
               var13.graphic = Client.secretPacketBuffer2.readUnsignedShort();
               var3 = Client.secretPacketBuffer2.readIntOb3();
               var13.field1238 = var3 >> 16;
               var13.graphicsDelay = Client.gameCycle + (var3 & '\uffff');
               var13.field1244 = 0;
               var13.field1277 = 0;
               if(var13.graphicsDelay > Client.gameCycle) {
                  var13.field1244 = -1;
               }

               if(var13.graphic == '\uffff') {
                  var13.graphic = -1;
               }
            }

            if((var14 & 8) != 0) {
               var13.overhead = Client.secretPacketBuffer2.readString();
               var13.field1264 = 100;
            }

            if((var14 & 1) != 0) {
               var13.interacting = Client.secretPacketBuffer2.readUnsignedShort();
               if(var13.interacting == '\uffff') {
                  var13.interacting = -1;
               }
            }

            if((var14 & 16) != 0) {
               var3 = Client.secretPacketBuffer2.readUnsignedByte();
               int var10;
               int var11;
               if(var3 > 0) {
                  for(var4 = 0; var4 < var3; ++var4) {
                     var6 = -1;
                     var7 = -1;
                     var10 = -1;
                     var5 = Client.secretPacketBuffer2.getUSmart();
                     if(var5 == 32767) {
                        var5 = Client.secretPacketBuffer2.getUSmart();
                        var7 = Client.secretPacketBuffer2.getUSmart();
                        var6 = Client.secretPacketBuffer2.getUSmart();
                        var10 = Client.secretPacketBuffer2.getUSmart();
                     } else if(var5 != 32766) {
                        var7 = Client.secretPacketBuffer2.getUSmart();
                     } else {
                        var5 = -1;
                     }

                     var11 = Client.secretPacketBuffer2.getUSmart();
                     var13.method1536(var5, var7, var6, var10, Client.gameCycle, var11);
                  }
               }

               var4 = Client.secretPacketBuffer2.method3292();
               if(var4 > 0) {
                  for(var5 = 0; var5 < var4; ++var5) {
                     var6 = Client.secretPacketBuffer2.getUSmart();
                     var7 = Client.secretPacketBuffer2.getUSmart();
                     if(var7 != 32767) {
                        var10 = Client.secretPacketBuffer2.getUSmart();
                        var11 = Client.secretPacketBuffer2.readUnsignedByte();
                        int var12 = var7 > 0?Client.secretPacketBuffer2.method3324():var11;
                        var13.method1537(var6, Client.gameCycle, var7, var10, var11, var12);
                     } else {
                        var13.method1550(var6);
                     }
                  }
               }
            }

            if((var14 & 64) != 0) {
               var13.composition = class35.getNpcDefinition(Client.secretPacketBuffer2.readUnsignedShortOb1());
               var13.field1242 = var13.composition.field3561;
               var13.field1291 = var13.composition.field3573;
               var13.field1246 = var13.composition.field3556;
               var13.field1283 = var13.composition.field3577;
               var13.field1270 = var13.composition.field3575;
               var13.field1249 = var13.composition.field3570;
               var13.idlePoseAnimation = var13.composition.field3564;
               var13.field1290 = var13.composition.field3555;
               var13.field1245 = var13.composition.field3566;
            }

            if((var14 & 32) != 0) {
               var3 = Client.secretPacketBuffer2.readUnsignedShortOb1();
               var4 = Client.secretPacketBuffer2.readUnsignedShort();
               var5 = var13.x - (var3 - KeyFocusListener.baseX - KeyFocusListener.baseX) * 64;
               var6 = var13.y - (var4 - class266.baseY - class266.baseY) * 64;
               if(var5 != 0 || var6 != 0) {
                  var13.field1266 = (int)(Math.atan2((double)var5, (double)var6) * 325.949D) & 2047;
               }
            }
         }

         for(var1 = 0; var1 < Client.field1050; ++var1) {
            var2 = Client.field1051[var1];
            if(Client.cachedNPCs[var2].field1287 != Client.gameCycle) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.packetLength != Client.secretPacketBuffer2.offset) {
            throw new RuntimeException(Client.secretPacketBuffer2.offset + "," + Client.packetLength);
         } else {
            for(var1 = 0; var1 < Client.field937; ++var1) {
               if(Client.cachedNPCs[Client.npcIndices[var1]] == null) {
                  throw new RuntimeException(var1 + "," + Client.field937);
               }
            }

         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1814788693"
   )
   public void method3934(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2628[var2]];
         if(var3 == 0) {
            var1.putByte(-1);
         } else {
            var1.putByte(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.putByte(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "3"
   )
   public Model method3936(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return class35.getNpcDefinition(this.transformedNpcId).method4651(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.equipmentIds;
         if(var1 != null && (var1.leftHandItem >= 0 || var1.rightHandItem >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.equipmentIds[var8];
            }

            if(var1.leftHandItem >= 0) {
               var5 += (long)(var1.leftHandItem - this.equipmentIds[5] << 40);
               var7[5] = var1.leftHandItem;
            }

            if(var1.rightHandItem >= 0) {
               var5 += (long)(var1.rightHandItem - this.equipmentIds[3] << 48);
               var7[3] = var1.rightHandItem;
            }
         }

         Model var15 = (Model)field2630.get(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var10;
            for(int var11 = 0; var11 < 12; ++var11) {
               var10 = var7[var11];
               if(var10 >= 256 && var10 < 512 && !class95.getKitDefinition(var10 - 256).ready()) {
                  var9 = true;
               }

               if(var10 >= 512 && !AbstractByteBuffer.getItemDefinition(var10 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2625) {
                  var15 = (Model)field2630.get(this.field2625);
               }

               if(var15 == null) {
                  return null;
               }
            }

            if(var15 == null) {
               ModelData[] var17 = new ModelData[12];
               var10 = 0;

               int var12;
               for(int var13 = 0; var13 < 12; ++var13) {
                  var12 = var7[var13];
                  ModelData var14;
                  if(var12 >= 256 && var12 < 512) {
                     var14 = class95.getKitDefinition(var12 - 256).getModelData();
                     if(var14 != null) {
                        var17[var10++] = var14;
                     }
                  }

                  if(var12 >= 512) {
                     var14 = AbstractByteBuffer.getItemDefinition(var12 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var17[var10++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var17, var10);

               for(var12 = 0; var12 < 5; ++var12) {
                  if(this.bodyPartColours[var12] < colorsToReplace[var12].length) {
                     var18.recolor(class18.colorsToFind[var12], colorsToReplace[var12][this.bodyPartColours[var12]]);
                  }

                  if(this.bodyPartColours[var12] < field2620[var12].length) {
                     var18.recolor(NPC.field1398[var12], field2620[var12][this.bodyPartColours[var12]]);
                  }
               }

               var15 = var18.light(64, 850, -30, -50, -30);
               field2630.put(var15, var5);
               this.field2625 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            Model var16;
            if(var1 != null && var3 != null) {
               var16 = var1.method4694(var15, var2, var3, var4);
            } else if(var1 != null) {
               var16 = var1.method4704(var15, var2);
            } else {
               var16 = var3.method4704(var15, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1000000"
   )
   public int method3938() {
      return this.transformedNpcId == -1?this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[4] << 20) + (this.bodyPartColours[0] << 25) + (this.equipmentIds[0] << 15):305419896 + class35.getNpcDefinition(this.transformedNpcId).id;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "119651624"
   )
   @Export("setHash")
   void setHash() {
      long var1 = this.hash;
      int var3 = this.equipmentIds[5];
      int var4 = this.equipmentIds[9];
      this.equipmentIds[5] = var4;
      this.equipmentIds[9] = var3;
      this.hash = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.hash <<= 4;
         if(this.equipmentIds[var5] >= 256) {
            this.hash += (long)(this.equipmentIds[var5] - 256);
         }
      }

      if(this.equipmentIds[0] >= 256) {
         this.hash += (long)(this.equipmentIds[0] - 256 >> 4);
      }

      if(this.equipmentIds[1] >= 256) {
         this.hash += (long)(this.equipmentIds[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.hash <<= 3;
         this.hash += (long)this.bodyPartColours[var5];
      }

      this.hash <<= 1;
      this.hash += (long)(this.isFemale?1:0);
      this.equipmentIds[5] = var3;
      this.equipmentIds[9] = var4;
      if(0L != var1 && this.hash != var1) {
         field2630.remove(var1);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "48"
   )
   public void method3958(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2628[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               do {
                  do {
                     if(!var2) {
                        --var3;
                        if(var3 < 0) {
                           var3 = KitDefinition.field3359 - 1;
                        }
                     } else {
                        ++var3;
                        if(var3 >= KitDefinition.field3359) {
                           var3 = 0;
                        }
                     }

                     var4 = class95.getKitDefinition(var3);
                  } while(var4 == null);
               } while(var4.nonSelectable);
            } while(var4.bodyPartId != var1 + (this.isFemale?7:0));

            this.equipmentIds[field2628[var1]] = var3 + 256;
            this.setHash();
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "1994660166"
   )
   ModelData method3959() {
      if(this.transformedNpcId != -1) {
         return class35.getNpcDefinition(this.transformedNpcId).method4645();
      } else {
         boolean var1 = false;

         int var2;
         for(int var3 = 0; var3 < 12; ++var3) {
            var2 = this.equipmentIds[var3];
            if(var2 >= 256 && var2 < 512 && !class95.getKitDefinition(var2 - 256).method4396()) {
               var1 = true;
            }

            if(var2 >= 512 && !AbstractByteBuffer.getItemDefinition(var2 - 512).method4587(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var7 = new ModelData[12];
            var2 = 0;

            int var4;
            for(int var5 = 0; var5 < 12; ++var5) {
               var4 = this.equipmentIds[var5];
               ModelData var6;
               if(var4 >= 256 && var4 < 512) {
                  var6 = class95.getKitDefinition(var4 - 256).method4387();
                  if(var6 != null) {
                     var7[var2++] = var6;
                  }
               }

               if(var4 >= 512) {
                  var6 = AbstractByteBuffer.getItemDefinition(var4 - 512).method4588(this.isFemale);
                  if(var6 != null) {
                     var7[var2++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var2);

            for(var4 = 0; var4 < 5; ++var4) {
               if(this.bodyPartColours[var4] < colorsToReplace[var4].length) {
                  var8.recolor(class18.colorsToFind[var4], colorsToReplace[var4][this.bodyPartColours[var4]]);
               }

               if(this.bodyPartColours[var4] < field2620[var4].length) {
                  var8.recolor(NPC.field1398[var4], field2620[var4][this.bodyPartColours[var4]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-195004579"
   )
   public void method3962(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3359; ++var6) {
               KitDefinition var7 = class95.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodyPartId == (var3?7:0) + var5) {
                  var1[field2628[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.transformedNpcId = var4;
      this.setHash();
   }

   static {
      field2628 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2630 = new NodeCache(260);
   }
}
