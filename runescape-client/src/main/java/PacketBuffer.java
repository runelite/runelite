import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("r")
   static final int[] field2593;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1770691627
   )
   @Export("bitPosition")
   int bitPosition;

   static {
      field2593 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1607852720"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "-204900323"
   )
   @Export("setIsaacCipher")
   public void setIsaacCipher(ISAACCipher var1) {
      this.cipher = var1;
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1234455582"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1298143065"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1200817943"
   )
   public boolean method3813() {
      int var1 = super.payload[super.offset] - this.cipher.method3824() & 255;
      return var1 >= 128;
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "24"
   )
   public int method3792() {
      int var1 = super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
      return var1 < 128?var1:(var1 - 128 << 8) + (super.payload[++super.offset - 1] - this.cipher.nextInt() & 255);
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-59"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "128205369"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2593[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2593[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2593[var1];
      }

      return var4;
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "831892280"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1043325065"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "3"
   )
   static final void method3820(boolean var0) {
      for(int var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method5134()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1153 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field952[var4][var5] == Client.field953) {
                     continue;
                  }

                  Client.field952[var4][var5] = Client.field953;
               }

               if(!var2.composition.field3729) {
                  var3 -= Integer.MIN_VALUE;
               }

               var2.field1154 = Client.gameCycle;
               class308.region.method3006(class237.plane, var2.x, var2.y, class5.getTileHeight(var2.field1153 * 64 - 64 + var2.x, var2.field1153 * 64 - 64 + var2.y, class237.plane), var2.field1153 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1181);
            }
         }
      }

   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "255"
   )
   static final void method3821(int var0, int var1, int var2, int var3) {
      if(Client.itemSelectionState == 0 && !Client.spellSelected) {
         RunException.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class132.Viewport_entityCountAtMouse; ++var6) {
         var7 = class132.Viewport_entityIdsAtMouse[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && class308.region.getObjectFlags(class237.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = FileRequest.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(var12 == null) {
                  continue;
               }

               if(Client.itemSelectionState == 1) {
                  RunException.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class173.getColTags(65535) + var12.name, 1, var7, var8, var9);
               } else if(Client.spellSelected) {
                  if((class241.field2799 & 4) == 4) {
                     RunException.addMenuEntry(Client.field956, Client.field1015 + " " + "->" + " " + class173.getColTags(65535) + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var19 = var12.actions;
                  if(var19 != null) {
                     for(int var20 = 4; var20 >= 0; --var20) {
                        if(var19[var20] != null) {
                           short var15 = 0;
                           if(var20 == 0) {
                              var15 = 3;
                           }

                           if(var20 == 1) {
                              var15 = 4;
                           }

                           if(var20 == 2) {
                              var15 = 5;
                           }

                           if(var20 == 3) {
                              var15 = 6;
                           }

                           if(var20 == 4) {
                              var15 = 1001;
                           }

                           RunException.addMenuEntry(var19[var20], class173.getColTags(65535) + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  RunException.addMenuEntry("Examine", class173.getColTags(65535) + var12.name, 1002, var12.id << 14, var8, var9);
               }
            }

            int var13;
            NPC var14;
            Player var16;
            int[] var26;
            int var28;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field3702 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.npcIndexesCount; ++var13) {
                     var14 = Client.cachedNPCs[Client.npcIndices[var13]];
                     if(var14 != null && var23 != var14 && var14.composition.field3702 == 1 && var14.x == var23.x && var14.y == var23.y) {
                        WorldMapDecoration.method302(var14.composition, Client.npcIndices[var13], var8, var9);
                     }
                  }

                  var13 = class93.playerIndexesCount;
                  var26 = class93.playerIndices;

                  for(var28 = 0; var28 < var13; ++var28) {
                     var16 = Client.cachedPlayers[var26[var28]];
                     if(var16 != null && var23.x == var16.x && var16.y == var23.y) {
                        class37.method522(var16, var26[var28], var8, var9);
                     }
                  }
               }

               WorldMapDecoration.method302(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.npcIndexesCount; ++var13) {
                     var14 = Client.cachedNPCs[Client.npcIndices[var13]];
                     if(var14 != null && var14.composition.field3702 == 1 && var14.x == var24.x && var24.y == var14.y) {
                        WorldMapDecoration.method302(var14.composition, Client.npcIndices[var13], var8, var9);
                     }
                  }

                  var13 = class93.playerIndexesCount;
                  var26 = class93.playerIndices;

                  for(var28 = 0; var28 < var13; ++var28) {
                     var16 = Client.cachedPlayers[var26[var28]];
                     if(var16 != null && var16 != var24 && var24.x == var16.x && var16.y == var24.y) {
                        class37.method522(var16, var26[var28], var8, var9);
                     }
                  }
               }

               if(var11 != Client.field982) {
                  class37.method522(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[class237.plane][var8][var9];
               if(var25 != null) {
                  for(Item var29 = (Item)var25.getTail(); var29 != null; var29 = (Item)var25.getPrevious()) {
                     ItemComposition var27 = GameObject.getItemDefinition(var29.id);
                     if(Client.itemSelectionState == 1) {
                        RunException.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class173.getColTags(16748608) + var27.name, 16, var29.id, var8, var9);
                     } else if(Client.spellSelected) {
                        if((class241.field2799 & 1) == 1) {
                           RunException.addMenuEntry(Client.field956, Client.field1015 + " " + "->" + " " + class173.getColTags(16748608) + var27.name, 17, var29.id, var8, var9);
                        }
                     } else {
                        String[] var21 = var27.groundActions;

                        for(int var22 = 4; var22 >= 0; --var22) {
                           if(var21 != null && var21[var22] != null) {
                              byte var17 = 0;
                              if(var22 == 0) {
                                 var17 = 18;
                              }

                              if(var22 == 1) {
                                 var17 = 19;
                              }

                              if(var22 == 2) {
                                 var17 = 20;
                              }

                              if(var22 == 3) {
                                 var17 = 21;
                              }

                              if(var22 == 4) {
                                 var17 = 22;
                              }

                              RunException.addMenuEntry(var21[var22], class173.getColTags(16748608) + var27.name, var17, var29.id, var8, var9);
                           } else if(var22 == 2) {
                              RunException.addMenuEntry("Take", class173.getColTags(16748608) + var27.name, 20, var29.id, var8, var9);
                           }
                        }

                        RunException.addMenuEntry("Examine", class173.getColTags(16748608) + var27.name, 1004, var29.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var18 = Client.cachedPlayers[Client.field982];
         class37.method522(var18, Client.field982, var6, var7);
      }

   }
}
