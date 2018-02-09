import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class43 {
   @ObfuscatedName("al")
   static int[] field547;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 500591691
   )
   @Export("myWorldPort")
   static int myWorldPort;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1723422331
   )
   int field550;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 272751887
   )
   int field541;
   @ObfuscatedName("m")
   int[][] field542;
   @ObfuscatedName("h")
   int[][] field543;
   @ObfuscatedName("i")
   int[][] field540;
   @ObfuscatedName("w")
   int[][] field545;

   class43(int var1, int var2) {
      this.field550 = var1;
      this.field541 = var2;
      this.field542 = new int[var1][var2];
      this.field543 = new int[var1][var2];
      this.field540 = new int[var1][var2];
      this.field545 = new int[var1][var2];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIILil;I)V",
      garbageValue = "-683210012"
   )
   void method593(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field550 && var2 - var3 <= this.field541) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field550, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field541, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field542[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field543[var9][var10] += var4.saturation;
                     this.field540[var9][var10] += var4.lightness;
                     ++this.field545[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1721213914"
   )
   int method594(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field550 && var2 < this.field541) {
         if(this.field540[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field542[var1][var2] / this.field545[var1][var2];
            int var4 = this.field543[var1][var2] / this.field545[var1][var2];
            int var5 = this.field540[var1][var2] / this.field545[var1][var2];
            double var7 = (double)var3 / 256.0D;
            double var9 = (double)var4 / 256.0D;
            double var11 = (double)var5 / 256.0D;
            double var13 = var11;
            double var15 = var11;
            double var17 = var11;
            if(0.0D != var9) {
               double var19;
               if(var11 < 0.5D) {
                  var19 = (var9 + 1.0D) * var11;
               } else {
                  var19 = var9 + var11 - var11 * var9;
               }

               double var21 = 2.0D * var11 - var19;
               double var23 = var7 + 0.3333333333333333D;
               if(var23 > 1.0D) {
                  --var23;
               }

               double var27 = var7 - 0.3333333333333333D;
               if(var27 < 0.0D) {
                  ++var27;
               }

               if(6.0D * var23 < 1.0D) {
                  var13 = var21 + 6.0D * (var19 - var21) * var23;
               } else if(2.0D * var23 < 1.0D) {
                  var13 = var19;
               } else if(3.0D * var23 < 2.0D) {
                  var13 = var21 + (var19 - var21) * (0.6666666666666666D - var23) * 6.0D;
               } else {
                  var13 = var21;
               }

               if(var7 * 6.0D < 1.0D) {
                  var15 = 6.0D * (var19 - var21) * var7 + var21;
               } else if(var7 * 2.0D < 1.0D) {
                  var15 = var19;
               } else if(3.0D * var7 < 2.0D) {
                  var15 = var21 + 6.0D * (0.6666666666666666D - var7) * (var19 - var21);
               } else {
                  var15 = var21;
               }

               if(6.0D * var27 < 1.0D) {
                  var17 = var21 + (var19 - var21) * 6.0D * var27;
               } else if(2.0D * var27 < 1.0D) {
                  var17 = var19;
               } else if(3.0D * var27 < 2.0D) {
                  var17 = (0.6666666666666666D - var27) * (var19 - var21) * 6.0D + var21;
               } else {
                  var17 = var21;
               }
            }

            int var29 = (int)(var13 * 256.0D);
            int var20 = (int)(256.0D * var15);
            int var30 = (int)(var17 * 256.0D);
            int var22 = var30 + (var20 << 8) + (var29 << 16);
            return var22;
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Lit;",
      garbageValue = "-87"
   )
   public static BuildType method601(int var0) {
      BuildType[] var1 = new BuildType[]{BuildType.RC, BuildType.LIVE, BuildType.WIP, BuildType.BUILD_LIVE};
      BuildType[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         BuildType var4 = var2[var3];
         if(var0 == var4.ordinal) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1731665917"
   )
   public static boolean method598(int var0) {
      return var0 >= class232.field2937.field2938 && var0 <= class232.field2918.field2938 || var0 == class232.field2919.field2938;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "138080199"
   )
   static final void method592(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class160.field2156[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5][var4 - 1];
               }

               if(var3 + var1 == var4 && var4 < 103) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "1479488033"
   )
   static final void method599(int var0, int var1, boolean var2) {
      if(!var2 || var0 != MessageNode.field798 || ChatLineBuffer.field1440 != var1) {
         MessageNode.field798 = var0;
         ChatLineBuffer.field1440 = var1;
         class87.setGameState(25);
         BoundingBox2D.drawStatusBox("Loading - please wait.", true);
         int var3 = ClanMemberManager.baseX;
         int var4 = WorldMapData.baseY;
         ClanMemberManager.baseX = (var0 - 6) * 8;
         WorldMapData.baseY = (var1 - 6) * 8;
         int var5 = ClanMemberManager.baseX - var3;
         int var6 = WorldMapData.baseY - var4;
         var3 = ClanMemberManager.baseX;
         var4 = WorldMapData.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < 32768; ++var7) {
            NPC var8 = Client.cachedNPCs[var7];
            if(var8 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var8.pathX[var9] -= var5;
                  var8.pathY[var9] -= var6;
               }

               var8.x -= var5 * 128;
               var8.y -= var6 * 128;
            }
         }

         for(var7 = 0; var7 < 2048; ++var7) {
            Player var21 = Client.cachedPlayers[var7];
            if(var21 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var21.pathX[var9] -= var5;
                  var21.pathY[var9] -= var6;
               }

               var21.x -= var5 * 128;
               var21.y -= var6 * 128;
            }
         }

         byte var20 = 0;
         byte var18 = 104;
         byte var22 = 1;
         if(var5 < 0) {
            var20 = 103;
            var18 = -1;
            var22 = -1;
         }

         byte var10 = 0;
         byte var11 = 104;
         byte var12 = 1;
         if(var6 < 0) {
            var10 = 103;
            var11 = -1;
            var12 = -1;
         }

         int var14;
         for(int var13 = var20; var13 != var18; var13 += var22) {
            for(var14 = var10; var14 != var11; var14 += var12) {
               int var15 = var5 + var13;
               int var16 = var14 + var6;

               for(int var17 = 0; var17 < 4; ++var17) {
                  if(var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                     Client.groundItemDeque[var17][var13][var14] = Client.groundItemDeque[var17][var15][var16];
                  } else {
                     Client.groundItemDeque[var17][var13][var14] = null;
                  }
               }
            }
         }

         for(PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.getFront(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.getNext()) {
            var19.x -= var5;
            var19.y -= var6;
            if(var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
               var19.unlink();
            }
         }

         if(Client.destinationX != 0) {
            Client.destinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.queuedSoundEffectCount = 0;
         Client.field1068 = false;
         Client.field1049 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(Lhs;I)Z",
      garbageValue = "299943095"
   )
   static final boolean method600(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = PendingSpawn.method1592(var0, var1);
            int var3 = var0.field2868[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }
}
