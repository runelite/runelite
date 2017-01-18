import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public final class class116 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -245910869
   )
   int field1801 = '\ufde8';
   @ObfuscatedName("x")
   class72 field1802 = null;
   @ObfuscatedName("a")
   class72 field1803 = null;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1111100885
   )
   int field1804;
   @ObfuscatedName("u")
   static byte[] field1805 = new byte[520];

   @ObfuscatedSignature(
      signature = "(ILclass72;Lclass72;I)V",
      garbageValue = "500000"
   )
   public class116(int var1, class72 var2, class72 var3, int var4) {
      this.field1804 = var1;
      this.field1802 = var2;
      this.field1803 = var3;
      this.field1801 = var4;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;B)V",
      garbageValue = "1"
   )
   public static void method2213(class182 var0, class182 var1) {
      CombatInfo2.field2821 = var0;
      CombatInfo2.field2816 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I[BIZB)Z",
      garbageValue = "75"
   )
   boolean method2214(int var1, byte[] var2, int var3, boolean var4) {
      class72 var5 = this.field1802;
      class72 var6 = this.field1802;
      synchronized(this.field1802) {
         try {
            int var7;
            boolean var8;
            boolean var10000;
            if(var4) {
               if(this.field1803.method1341() < (long)(6 + 6 * var1)) {
                  var8 = false;
                  var10000 = var8;
                  return var10000;
               }

               this.field1803.method1335((long)(6 * var1));
               this.field1803.method1338(field1805, 0, 6);
               var7 = (field1805[5] & 255) + ((field1805[4] & 255) << 8) + ((field1805[3] & 255) << 16);
               if(var7 <= 0 || (long)var7 > this.field1802.method1341() / 520L) {
                  var8 = false;
                  var10000 = var8;
                  return var10000;
               }
            } else {
               var7 = (int)((this.field1802.method1341() + 519L) / 520L);
               if(var7 == 0) {
                  var7 = 1;
               }
            }

            field1805[0] = (byte)(var3 >> 16);
            field1805[1] = (byte)(var3 >> 8);
            field1805[2] = (byte)var3;
            field1805[3] = (byte)(var7 >> 16);
            field1805[4] = (byte)(var7 >> 8);
            field1805[5] = (byte)var7;
            this.field1803.method1335((long)(var1 * 6));
            this.field1803.method1360(field1805, 0, 6);
            int var9 = 0;
            int var10 = 0;

            while(true) {
               if(var9 < var3) {
                  label129: {
                     int var11 = 0;
                     int var12;
                     if(var4) {
                        this.field1802.method1335((long)(var7 * 520));

                        try {
                           this.field1802.method1338(field1805, 0, 8);
                        } catch (EOFException var16) {
                           break label129;
                        }

                        var12 = ((field1805[0] & 255) << 8) + (field1805[1] & 255);
                        int var13 = ((field1805[2] & 255) << 8) + (field1805[3] & 255);
                        var11 = ((field1805[4] & 255) << 16) + ((field1805[5] & 255) << 8) + (field1805[6] & 255);
                        int var14 = field1805[7] & 255;
                        if(var1 != var12 || var13 != var10 || var14 != this.field1804) {
                           var8 = false;
                           var10000 = var8;
                           return var10000;
                        }

                        if(var11 < 0 || (long)var11 > this.field1802.method1341() / 520L) {
                           var8 = false;
                           var10000 = var8;
                           return var10000;
                        }
                     }

                     if(var11 == 0) {
                        var4 = false;
                        var11 = (int)((this.field1802.method1341() + 519L) / 520L);
                        if(var11 == 0) {
                           ++var11;
                        }

                        if(var11 == var7) {
                           ++var11;
                        }
                     }

                     if(var3 - var9 <= 512) {
                        var11 = 0;
                     }

                     field1805[0] = (byte)(var1 >> 8);
                     field1805[1] = (byte)var1;
                     field1805[2] = (byte)(var10 >> 8);
                     field1805[3] = (byte)var10;
                     field1805[4] = (byte)(var11 >> 16);
                     field1805[5] = (byte)(var11 >> 8);
                     field1805[6] = (byte)var11;
                     field1805[7] = (byte)this.field1804;
                     this.field1802.method1335((long)(var7 * 520));
                     this.field1802.method1360(field1805, 0, 8);
                     var12 = var3 - var9;
                     if(var12 > 512) {
                        var12 = 512;
                     }

                     this.field1802.method1360(var2, var9, var12);
                     var9 += var12;
                     var7 = var11;
                     ++var10;
                     continue;
                  }
               }

               var8 = true;
               var10000 = var8;
               return var10000;
            }
         } catch (IOException var17) {
            return false;
         }
      }
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "694661705"
   )
   static final void method2218(boolean var0) {
      Client.field330 = 0;
      Client.field324 = 0;
      Client.field409.method3031();
      int var1 = Client.field409.method3032(8);
      int var2;
      if(var1 < Client.field322) {
         for(var2 = var1; var2 < Client.field322; ++var2) {
            Client.field459[++Client.field330 - 1] = Client.field483[var2];
         }
      }

      if(var1 > Client.field322) {
         throw new RuntimeException("");
      } else {
         Client.field322 = 0;

         int var3;
         int var4;
         int var5;
         int var6;
         NPC var8;
         int var9;
         for(var2 = 0; var2 < var1; ++var2) {
            int var7 = Client.field483[var2];
            var8 = Client.cachedNPCs[var7];
            var3 = Client.field409.method3032(1);
            if(var3 == 0) {
               Client.field483[++Client.field322 - 1] = var7;
               var8.field630 = Client.gameCycle;
            } else {
               var4 = Client.field409.method3032(2);
               if(var4 == 0) {
                  Client.field483[++Client.field322 - 1] = var7;
                  var8.field630 = Client.gameCycle;
                  Client.field370[++Client.field324 - 1] = var7;
               } else if(var4 == 1) {
                  Client.field483[++Client.field322 - 1] = var7;
                  var8.field630 = Client.gameCycle;
                  var5 = Client.field409.method3032(3);
                  var8.method725(var5, (byte)1);
                  var6 = Client.field409.method3032(1);
                  if(var6 == 1) {
                     Client.field370[++Client.field324 - 1] = var7;
                  }
               } else if(var4 == 2) {
                  Client.field483[++Client.field322 - 1] = var7;
                  var8.field630 = Client.gameCycle;
                  var5 = Client.field409.method3032(3);
                  var8.method725(var5, (byte)2);
                  var6 = Client.field409.method3032(3);
                  var8.method725(var6, (byte)2);
                  var9 = Client.field409.method3032(1);
                  if(var9 == 1) {
                     Client.field370[++Client.field324 - 1] = var7;
                  }
               } else if(var4 == 3) {
                  Client.field459[++Client.field330 - 1] = var7;
               }
            }
         }

         while(Client.field409.method3033(Client.field328) >= 27) {
            var1 = Client.field409.method3032(15);
            if(var1 == 32767) {
               break;
            }

            boolean var10 = false;
            if(null == Client.cachedNPCs[var1]) {
               Client.cachedNPCs[var1] = new NPC();
               var10 = true;
            }

            var8 = Client.cachedNPCs[var1];
            Client.field483[++Client.field322 - 1] = var1;
            var8.field630 = Client.gameCycle;
            var9 = Client.field409.method3032(1);
            var8.composition = Actor.getNpcDefinition(Client.field409.method3032(14));
            if(var0) {
               var3 = Client.field409.method3032(8);
               if(var3 > 127) {
                  var3 -= 256;
               }
            } else {
               var3 = Client.field409.method3032(5);
               if(var3 > 15) {
                  var3 -= 32;
               }
            }

            if(var0) {
               var4 = Client.field409.method3032(8);
               if(var4 > 127) {
                  var4 -= 256;
               }
            } else {
               var4 = Client.field409.method3032(5);
               if(var4 > 15) {
                  var4 -= 32;
               }
            }

            var5 = Client.field309[Client.field409.method3032(3)];
            if(var10) {
               var8.angle = var5 * -1112863629;
               var8.field650 = var5;
            }

            var6 = Client.field409.method3032(1);
            if(var6 == 1) {
               Client.field370[++Client.field324 - 1] = var1;
            }

            var8.field603 = var8.composition.field3007;
            var8.field616 = var8.composition.field3015;
            if(var8.field616 == 0) {
               var8.angle = 0;
            }

            var8.field607 = var8.composition.field3000;
            var8.field608 = var8.composition.field3019;
            var8.field639 = var8.composition.field2995;
            var8.field614 = var8.composition.field3001;
            var8.idlePoseAnimation = var8.composition.field2992;
            var8.field605 = var8.composition.field2987;
            var8.field626 = var8.composition.field2997;
            var8.method715(var3 + class148.localPlayer.pathX[0], class148.localPlayer.pathY[0] + var4, var9 == 1);
         }

         Client.field409.method3040();
         class1.method13();

         for(var1 = 0; var1 < Client.field330; ++var1) {
            var2 = Client.field459[var1];
            if(Client.gameCycle != Client.cachedNPCs[var2].field630) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.field409.offset != Client.field328) {
            throw new RuntimeException(Client.field409.offset + "," + Client.field328);
         } else {
            for(var1 = 0; var1 < Client.field322; ++var1) {
               if(null == Client.cachedNPCs[Client.field483[var1]]) {
                  throw new RuntimeException(var1 + "," + Client.field322);
               }
            }

         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "-742717808"
   )
   public static Object method2221(byte[] var0, boolean var1) {
      if(null == var0) {
         return null;
      } else {
         if(var0.length > 136 && !class156.field2096) {
            try {
               class151 var2 = new class151();
               var2.vmethod2996(var0);
               return var2;
            } catch (Throwable var3) {
               class156.field2096 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "24"
   )
   static final void method2222(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class6.region.method1696(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      ModIcon var14;
      if(var5 != 0) {
         var6 = class6.region.method1714(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var12 = class179.field2668.image;
         var10 = 2048 * (103 - var2) + var1 * 4 + 24624;
         var11 = var5 >> 14 & 32767;
         ObjectComposition var13 = Tile.getObjectDefinition(var11);
         if(var13.mapSceneId != -1) {
            var14 = class114.field1780[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method4066(var15 + 48 + 4 * var1, 4 * (104 - var2 - var13.sizeY) + 48 + var16);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var12[var10] = var9;
                  var12[var10 + 512] = var9;
                  var12[1024 + var10] = var9;
                  var12[1536 + var10] = var9;
               } else if(var7 == 1) {
                  var12[var10] = var9;
                  var12[var10 + 1] = var9;
                  var12[var10 + 2] = var9;
                  var12[3 + var10] = var9;
               } else if(var7 == 2) {
                  var12[3 + var10] = var9;
                  var12[var10 + 3 + 512] = var9;
                  var12[1027 + var10] = var9;
                  var12[1536 + var10 + 3] = var9;
               } else if(var7 == 3) {
                  var12[var10 + 1536] = var9;
                  var12[1536 + var10 + 1] = var9;
                  var12[1538 + var10] = var9;
                  var12[var10 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var12[var10] = var9;
               } else if(var7 == 1) {
                  var12[3 + var10] = var9;
               } else if(var7 == 2) {
                  var12[3 + var10 + 1536] = var9;
               } else if(var7 == 3) {
                  var12[var10 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var12[var10] = var9;
                  var12[var10 + 512] = var9;
                  var12[var10 + 1024] = var9;
                  var12[var10 + 1536] = var9;
               } else if(var7 == 0) {
                  var12[var10] = var9;
                  var12[1 + var10] = var9;
                  var12[2 + var10] = var9;
                  var12[var10 + 3] = var9;
               } else if(var7 == 1) {
                  var12[3 + var10] = var9;
                  var12[3 + var10 + 512] = var9;
                  var12[1024 + var10 + 3] = var9;
                  var12[1539 + var10] = var9;
               } else if(var7 == 2) {
                  var12[1536 + var10] = var9;
                  var12[1 + var10 + 1536] = var9;
                  var12[var10 + 1536 + 2] = var9;
                  var12[1536 + var10 + 3] = var9;
               }
            }
         }
      }

      var5 = class6.region.method1698(var0, var1, var2);
      ObjectComposition var17;
      if(var5 != 0) {
         var6 = class6.region.method1714(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         var17 = Tile.getObjectDefinition(var9);
         int var18;
         if(var17.mapSceneId != -1) {
            var14 = class114.field1780[var17.mapSceneId];
            if(var14 != null) {
               var11 = (var17.sizeX * 4 - var14.originalWidth) / 2;
               var18 = (var17.sizeY * 4 - var14.height) / 2;
               var14.method4066(var11 + 48 + 4 * var1, var18 + 48 + (104 - var2 - var17.sizeY) * 4);
            }
         } else if(var8 == 9) {
            var10 = 15658734;
            if(var5 > 0) {
               var10 = 15597568;
            }

            int[] var20 = class179.field2668.image;
            var18 = 24624 + var1 * 4 + 2048 * (103 - var2);
            if(var7 != 0 && var7 != 2) {
               var20[var18] = var10;
               var20[513 + var18] = var10;
               var20[var18 + 1024 + 2] = var10;
               var20[1539 + var18] = var10;
            } else {
               var20[1536 + var18] = var10;
               var20[var18 + 1024 + 1] = var10;
               var20[514 + var18] = var10;
               var20[3 + var18] = var10;
            }
         }
      }

      var5 = class6.region.method1699(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         var17 = Tile.getObjectDefinition(var6);
         if(var17.mapSceneId != -1) {
            ModIcon var19 = class114.field1780[var17.mapSceneId];
            if(var19 != null) {
               var9 = (var17.sizeX * 4 - var19.originalWidth) / 2;
               int var21 = (var17.sizeY * 4 - var19.height) / 2;
               var19.method4066(var9 + 48 + var1 * 4, 48 + 4 * (104 - var2 - var17.sizeY) + var21);
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;B)V",
      garbageValue = "111"
   )
   public static void method2223(class182 var0) {
      class191.field2795 = var0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "0"
   )
   public boolean method2224(int var1, byte[] var2, int var3) {
      class72 var4 = this.field1802;
      class72 var5 = this.field1802;
      synchronized(this.field1802) {
         if(var3 >= 0 && var3 <= this.field1801) {
            boolean var6 = this.method2214(var1, var2, var3, true);
            if(!var6) {
               var6 = this.method2214(var1, var2, var3, false);
            }

            return var6;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "153351855"
   )
   static void method2225(String var0, String var1, String var2) {
      class41.loginMessage1 = var0;
      class41.loginMessage2 = var1;
      class41.loginMessage3 = var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILRegion;[LCollisionData;I)V",
      garbageValue = "-202532450"
   )
   static final void method2226(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method2963();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.method2963();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var4 == var17 && var16 >= var5 && var16 < 8 + var5 && var15 >= var6 && var15 < 8 + var6) {
               ObjectComposition var21 = Tile.getObjectDefinition(var11);
               int var22 = var16 & 7;
               int var23 = var15 & 7;
               int var24 = var21.sizeX;
               int var25 = var21.sizeY;
               int var26;
               if((var20 & 1) == 1) {
                  var26 = var24;
                  var24 = var25;
                  var25 = var26;
               }

               int var27 = var7 & 3;
               int var28;
               if(var27 == 0) {
                  var28 = var22;
               } else if(var27 == 1) {
                  var28 = var23;
               } else if(var27 == 2) {
                  var28 = 7 - var22 - (var24 - 1);
               } else {
                  var28 = 7 - var23 - (var25 - 1);
               }

               var26 = var28 + var2;
               int var29 = var3 + GroundObject.method1496(var16 & 7, var15 & 7, var7, var21.sizeX, var21.sizeY, var20);
               if(var26 > 0 && var29 > 0 && var26 < 103 && var29 < 103) {
                  int var30 = var1;
                  if((class10.tileSettings[1][var26][var29] & 2) == 2) {
                     var30 = var1 - 1;
                  }

                  CollisionData var31 = null;
                  if(var30 >= 0) {
                     var31 = var9[var30];
                  }

                  class13.method172(var1, var26, var29, var11, var7 + var20 & 3, var19, var8, var31);
               }
            }
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "346699876"
   )
   public byte[] method2227(int var1) {
      class72 var2 = this.field1802;
      class72 var3 = this.field1802;
      synchronized(this.field1802) {
         byte[] var10000;
         try {
            Object var4;
            if(this.field1803.method1341() < (long)(6 + 6 * var1)) {
               var4 = null;
               var10000 = (byte[])((byte[])var4);
               return var10000;
            }

            this.field1803.method1335((long)(var1 * 6));
            this.field1803.method1338(field1805, 0, 6);
            int var5 = ((field1805[1] & 255) << 8) + ((field1805[0] & 255) << 16) + (field1805[2] & 255);
            int var6 = ((field1805[3] & 255) << 16) + ((field1805[4] & 255) << 8) + (field1805[5] & 255);
            if(var5 < 0 || var5 > this.field1801) {
               var4 = null;
               var10000 = (byte[])((byte[])var4);
               return var10000;
            }

            if(var6 > 0 && (long)var6 <= this.field1802.method1341() / 520L) {
               byte[] var7 = new byte[var5];
               int var8 = 0;
               int var9 = 0;

               while(var8 < var5) {
                  if(var6 == 0) {
                     var4 = null;
                     var10000 = (byte[])((byte[])var4);
                     return var10000;
                  }

                  this.field1802.method1335((long)(520 * var6));
                  int var10 = var5 - var8;
                  if(var10 > 512) {
                     var10 = 512;
                  }

                  this.field1802.method1338(field1805, 0, 8 + var10);
                  int var11 = ((field1805[0] & 255) << 8) + (field1805[1] & 255);
                  int var12 = ((field1805[2] & 255) << 8) + (field1805[3] & 255);
                  int var13 = (field1805[6] & 255) + ((field1805[4] & 255) << 16) + ((field1805[5] & 255) << 8);
                  int var14 = field1805[7] & 255;
                  if(var1 == var11 && var9 == var12 && var14 == this.field1804) {
                     if(var13 >= 0 && (long)var13 <= this.field1802.method1341() / 520L) {
                        for(int var15 = 0; var15 < var10; ++var15) {
                           var7[var8++] = field1805[var15 + 8];
                        }

                        var6 = var13;
                        ++var9;
                        continue;
                     }

                     var4 = null;
                     var10000 = (byte[])((byte[])var4);
                     return var10000;
                  }

                  var4 = null;
                  var10000 = (byte[])((byte[])var4);
                  return var10000;
               }

               var10000 = var7;
               return var10000;
            }

            var4 = null;
            var10000 = (byte[])((byte[])var4);
         } catch (IOException var17) {
            return null;
         }

         return var10000;
      }
   }
}
