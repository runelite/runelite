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
   public static short[][] field2627;
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
               var3 = field2627[var1].length - 1;
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
            if(var3 >= field2627[var1].length) {
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
      this.method3957();
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "18995"
   )
   static final void method3933(boolean var0) {
      Client.field1050 = 0;
      Client.field965 = 0;
      Client.secretPacketBuffer2.method3410();
      int var1 = Client.secretPacketBuffer2.method3388(8);
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

         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = Client.npcIndices[var2];
            NPC var4 = Client.cachedNPCs[var3];
            var5 = Client.secretPacketBuffer2.method3388(1);
            if(var5 == 0) {
               Client.npcIndices[++Client.field937 - 1] = var3;
               var4.field1287 = Client.gameCycle;
            } else {
               var6 = Client.secretPacketBuffer2.method3388(2);
               if(var6 == 0) {
                  Client.npcIndices[++Client.field937 - 1] = var3;
                  var4.field1287 = Client.gameCycle;
                  Client.field1026[++Client.field965 - 1] = var3;
               } else if(var6 == 1) {
                  Client.npcIndices[++Client.field937 - 1] = var3;
                  var4.field1287 = Client.gameCycle;
                  var7 = Client.secretPacketBuffer2.method3388(3);
                  var4.method1696(var7, (byte)1);
                  var8 = Client.secretPacketBuffer2.method3388(1);
                  if(var8 == 1) {
                     Client.field1026[++Client.field965 - 1] = var3;
                  }
               } else if(var6 == 2) {
                  Client.npcIndices[++Client.field937 - 1] = var3;
                  var4.field1287 = Client.gameCycle;
                  var7 = Client.secretPacketBuffer2.method3388(3);
                  var4.method1696(var7, (byte)2);
                  var8 = Client.secretPacketBuffer2.method3388(3);
                  var4.method1696(var8, (byte)2);
                  var9 = Client.secretPacketBuffer2.method3388(1);
                  if(var9 == 1) {
                     Client.field1026[++Client.field965 - 1] = var3;
                  }
               } else if(var6 == 3) {
                  Client.field1051[++Client.field1050 - 1] = var3;
               }
            }
         }

         class40.method562(var0);

         for(var1 = 0; var1 < Client.field965; ++var1) {
            var2 = Client.field1026[var1];
            NPC var13 = Client.cachedNPCs[var2];
            int var14 = Client.secretPacketBuffer2.readUnsignedByte();
            if((var14 & 4) != 0) {
               var5 = Client.secretPacketBuffer2.readByteOb1();
               if(var5 == '\uffff') {
                  var5 = -1;
               }

               var6 = Client.secretPacketBuffer2.method3173();
               if(var5 == var13.animation && var5 != -1) {
                  var7 = class224.getAnimation(var5).replyMode;
                  if(var7 == 1) {
                     var13.actionFrame = 0;
                     var13.field1247 = 0;
                     var13.actionAnimationDisable = var6;
                     var13.field1262 = 0;
                  }

                  if(var7 == 2) {
                     var13.field1262 = 0;
                  }
               } else if(var5 == -1 || var13.animation == -1 || class224.getAnimation(var5).forcedPriority >= class224.getAnimation(var13.animation).forcedPriority) {
                  var13.animation = var5;
                  var13.actionFrame = 0;
                  var13.field1247 = 0;
                  var13.actionAnimationDisable = var6;
                  var13.field1262 = 0;
                  var13.field1269 = var13.queueSize;
               }
            }

            if((var14 & 2) != 0) {
               var13.graphic = Client.secretPacketBuffer2.readUnsignedShort();
               var5 = Client.secretPacketBuffer2.readIntOb3();
               var13.field1238 = var5 >> 16;
               var13.field1278 = Client.gameCycle + (var5 & '\uffff');
               var13.field1244 = 0;
               var13.field1277 = 0;
               if(var13.field1278 > Client.gameCycle) {
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
               var5 = Client.secretPacketBuffer2.readUnsignedByte();
               int var10;
               int var11;
               if(var5 > 0) {
                  for(var6 = 0; var6 < var5; ++var6) {
                     var8 = -1;
                     var9 = -1;
                     var10 = -1;
                     var7 = Client.secretPacketBuffer2.method3159();
                     if(var7 == 32767) {
                        var7 = Client.secretPacketBuffer2.method3159();
                        var9 = Client.secretPacketBuffer2.method3159();
                        var8 = Client.secretPacketBuffer2.method3159();
                        var10 = Client.secretPacketBuffer2.method3159();
                     } else if(var7 != 32766) {
                        var9 = Client.secretPacketBuffer2.method3159();
                     } else {
                        var7 = -1;
                     }

                     var11 = Client.secretPacketBuffer2.method3159();
                     var13.method1536(var7, var9, var8, var10, Client.gameCycle, var11);
                  }
               }

               var6 = Client.secretPacketBuffer2.method3292();
               if(var6 > 0) {
                  for(var7 = 0; var7 < var6; ++var7) {
                     var8 = Client.secretPacketBuffer2.method3159();
                     var9 = Client.secretPacketBuffer2.method3159();
                     if(var9 != 32767) {
                        var10 = Client.secretPacketBuffer2.method3159();
                        var11 = Client.secretPacketBuffer2.readUnsignedByte();
                        int var12 = var9 > 0?Client.secretPacketBuffer2.method3324():var11;
                        var13.method1537(var8, Client.gameCycle, var9, var10, var11, var12);
                     } else {
                        var13.method1550(var8);
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
               var5 = Client.secretPacketBuffer2.readUnsignedShortOb1();
               var6 = Client.secretPacketBuffer2.readUnsignedShort();
               var7 = var13.x - (var5 - class50.baseX - class50.baseX) * 64;
               var8 = var13.y - (var6 - class266.baseY - class266.baseY) * 64;
               if(var7 != 0 || var8 != 0) {
                  var13.field1266 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
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

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class95.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class176.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
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
               ModelData[] var16 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class95.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class176.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < field2627[var13].length) {
                     var18.method2422(class18.field323[var13], field2627[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < field2620[var13].length) {
                     var18.method2422(NPC.field1398[var13], field2620[var13][this.bodyPartColours[var13]]);
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
            Model var17;
            if(var1 != null && var3 != null) {
               var17 = var1.method4694(var15, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.method4704(var15, var2);
            } else {
               var17 = var3.method4704(var15, var4);
            }

            return var17;
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

   static {
      field2628 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2630 = new NodeCache(260);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "119651624"
   )
   void method3957() {
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
            } while(var4 == null || var4.nonSelectable || var4.bodyPartId != var1 + (this.isFemale?7:0));

            this.equipmentIds[field2628[var1]] = var3 + 256;
            this.method3957();
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

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class95.getKitDefinition(var3 - 256).method4396()) {
               var1 = true;
            }

            if(var3 >= 512 && !class176.getItemDefinition(var3 - 512).method4587(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var7 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.equipmentIds[var4];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class95.getKitDefinition(var5 - 256).method4387();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class176.getItemDefinition(var5 - 512).method4588(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < field2627[var5].length) {
                  var8.method2422(class18.field323[var5], field2627[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < field2620[var5].length) {
                  var8.method2422(NPC.field1398[var5], field2620[var5][this.bodyPartColours[var5]]);
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
      this.method3957();
   }
}
