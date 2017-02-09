import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class49 extends Renderable {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1885256263
   )
   int field947;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 141787011
   )
   int field948;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 482267061
   )
   int field949;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1808068891
   )
   int field950;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -704757885
   )
   int field951;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = -1451913283
   )
   static int field952;
   @ObfuscatedName("q")
   Sequence field953;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 735035135
   )
   int field954;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -555777047
   )
   int field955;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 817061025
   )
   int field956;
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = 37749817
   )
   static int field958;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = -826549693
   )
   static int field959;
   @ObfuscatedName("cq")
   static Font field961;
   @ObfuscatedName("ev")
   static SpritePixels[] field963;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "637530507"
   )
   protected final Model getModel() {
      if(null != this.field953) {
         int var12 = Client.gameCycle - this.field955;
         if(var12 > 100 && this.field953.frameStep > 0) {
            var12 = 100;
         }

         label65: {
            do {
               do {
                  if(var12 <= this.field953.frameLenghts[this.field950]) {
                     break label65;
                  }

                  var12 -= this.field953.frameLenghts[this.field950];
                  ++this.field950;
               } while(this.field950 < this.field953.frameIDs.length);

               this.field950 -= this.field953.frameStep;
            } while(this.field950 >= 0 && this.field950 < this.field953.frameIDs.length);

            this.field953 = null;
         }

         this.field955 = Client.gameCycle - var12;
      }

      ObjectComposition var1 = class156.getObjectDefinition(this.field954);
      if(null != var1.impostorIds) {
         var1 = var1.getImpostor();
      }

      if(null == var1) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field949 != 1 && this.field949 != 3) {
            var2 = var1.sizeX;
            var3 = var1.sizeY;
         } else {
            var2 = var1.sizeY;
            var3 = var1.sizeX;
         }

         int var4 = (var2 >> 1) + this.field951;
         int var5 = (var2 + 1 >> 1) + this.field951;
         int var6 = (var3 >> 1) + this.field956;
         int var7 = (var3 + 1 >> 1) + this.field956;
         int[][] var8 = class11.tileHeights[this.field947];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var5][var6] + var8[var4][var6] >> 2;
         int var10 = (var2 << 6) + (this.field951 << 7);
         int var11 = (var3 << 6) + (this.field956 << 7);
         return var1.method3605(this.field948, this.field949, var8, var10, var9, var11, this.field953, this.field950);
      }
   }

   class49(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field954 = var1;
      this.field948 = var2;
      this.field949 = var3;
      this.field947 = var4;
      this.field951 = var5;
      this.field956 = var6;
      if(var7 != -1) {
         this.field953 = TextureProvider.getAnimation(var7);
         this.field950 = 0;
         this.field955 = Client.gameCycle - 1;
         if(this.field953.replyMode == 0 && var9 != null && var9 instanceof class49) {
            class49 var10 = (class49)var9;
            if(var10.field953 == this.field953) {
               this.field950 = var10.field950;
               this.field955 = var10.field955;
               return;
            }
         }

         if(var8 && this.field953.frameStep != -1) {
            this.field950 = (int)(Math.random() * (double)this.field953.frameIDs.length);
            this.field955 -= (int)(Math.random() * (double)this.field953.frameLenghts[this.field950]);
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "57127883"
   )
   public static void method901(Buffer var0) {
      byte[] var1 = new byte[24];

      try {
         class104.field1693.method1404(0L);
         class104.field1693.method1391(var1);

         int var2;
         for(var2 = 0; var2 < 24 && var1[var2] == 0; ++var2) {
            ;
         }

         if(var2 >= 24) {
            throw new IOException();
         }
      } catch (Exception var5) {
         for(int var3 = 0; var3 < 24; ++var3) {
            var1[var3] = -1;
         }
      }

      var0.method2921(var1, 0, 24);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIBB)V",
      garbageValue = "-108"
   )
   static final void method902(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.method236();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.method236();
            Client.field557.field1846 = var1;
            Client.field557.field1847 = var2;
            Client.field557.field1848 = 1;
            Client.field557.field1850 = 1;
            class22 var9 = Client.field557;
            class22 var10 = var9;
            CollisionData var11 = Client.collisionMaps[var0.field263];
            int[] var12 = Client.field532;
            int[] var13 = Client.field463;

            int var14;
            int var15;
            for(var14 = 0; var14 < 128; ++var14) {
               for(var15 = 0; var15 < 128; ++var15) {
                  class118.field1838[var14][var15] = 0;
                  class118.field1840[var14][var15] = 99999999;
               }
            }

            int var16;
            int var17;
            byte var18;
            byte var19;
            int var20;
            int var21;
            byte var22;
            int var23;
            int[][] var24;
            int var25;
            int var26;
            int var27;
            int var28;
            boolean var34;
            boolean var35;
            int var36;
            int var37;
            int var39;
            if(var8 == 1) {
               var16 = var4;
               var17 = var5;
               var18 = 64;
               var19 = 64;
               var20 = var4 - var18;
               var21 = var5 - var19;
               class118.field1838[var18][var19] = 99;
               class118.field1840[var18][var19] = 0;
               var22 = 0;
               var23 = 0;
               class118.field1842[var22] = var4;
               var39 = var22 + 1;
               class118.field1843[var22] = var5;
               var24 = var11.flags;

               while(true) {
                  if(var39 == var23) {
                     class118.field1844 = var16;
                     class105.field1722 = var17;
                     var35 = false;
                     break;
                  }

                  var16 = class118.field1842[var23];
                  var17 = class118.field1843[var23];
                  var23 = var23 + 1 & 4095;
                  var36 = var16 - var20;
                  var37 = var17 - var21;
                  var25 = var16 - var11.x;
                  var26 = var17 - var11.y;
                  if(var10.vmethod2275(1, var16, var17, var11)) {
                     class118.field1844 = var16;
                     class105.field1722 = var17;
                     var35 = true;
                     break;
                  }

                  var27 = 1 + class118.field1840[var36][var37];
                  if(var36 > 0 && class118.field1838[var36 - 1][var37] == 0 && (var24[var25 - 1][var26] & 19136776) == 0) {
                     class118.field1842[var39] = var16 - 1;
                     class118.field1843[var39] = var17;
                     var39 = 1 + var39 & 4095;
                     class118.field1838[var36 - 1][var37] = 2;
                     class118.field1840[var36 - 1][var37] = var27;
                  }

                  if(var36 < 127 && class118.field1838[var36 + 1][var37] == 0 && (var24[1 + var25][var26] & 19136896) == 0) {
                     class118.field1842[var39] = var16 + 1;
                     class118.field1843[var39] = var17;
                     var39 = 1 + var39 & 4095;
                     class118.field1838[1 + var36][var37] = 8;
                     class118.field1840[var36 + 1][var37] = var27;
                  }

                  if(var37 > 0 && class118.field1838[var36][var37 - 1] == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                     class118.field1842[var39] = var16;
                     class118.field1843[var39] = var17 - 1;
                     var39 = 1 + var39 & 4095;
                     class118.field1838[var36][var37 - 1] = 1;
                     class118.field1840[var36][var37 - 1] = var27;
                  }

                  if(var37 < 127 && class118.field1838[var36][1 + var37] == 0 && (var24[var25][1 + var26] & 19136800) == 0) {
                     class118.field1842[var39] = var16;
                     class118.field1843[var39] = 1 + var17;
                     var39 = var39 + 1 & 4095;
                     class118.field1838[var36][var37 + 1] = 4;
                     class118.field1840[var36][var37 + 1] = var27;
                  }

                  if(var36 > 0 && var37 > 0 && class118.field1838[var36 - 1][var37 - 1] == 0 && (var24[var25 - 1][var26 - 1] & 19136782) == 0 && (var24[var25 - 1][var26] & 19136776) == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                     class118.field1842[var39] = var16 - 1;
                     class118.field1843[var39] = var17 - 1;
                     var39 = 1 + var39 & 4095;
                     class118.field1838[var36 - 1][var37 - 1] = 3;
                     class118.field1840[var36 - 1][var37 - 1] = var27;
                  }

                  if(var36 < 127 && var37 > 0 && class118.field1838[var36 + 1][var37 - 1] == 0 && (var24[1 + var25][var26 - 1] & 19136899) == 0 && (var24[1 + var25][var26] & 19136896) == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                     class118.field1842[var39] = var16 + 1;
                     class118.field1843[var39] = var17 - 1;
                     var39 = var39 + 1 & 4095;
                     class118.field1838[1 + var36][var37 - 1] = 9;
                     class118.field1840[1 + var36][var37 - 1] = var27;
                  }

                  if(var36 > 0 && var37 < 127 && class118.field1838[var36 - 1][1 + var37] == 0 && (var24[var25 - 1][var26 + 1] & 19136824) == 0 && (var24[var25 - 1][var26] & 19136776) == 0 && (var24[var25][1 + var26] & 19136800) == 0) {
                     class118.field1842[var39] = var16 - 1;
                     class118.field1843[var39] = 1 + var17;
                     var39 = var39 + 1 & 4095;
                     class118.field1838[var36 - 1][1 + var37] = 6;
                     class118.field1840[var36 - 1][var37 + 1] = var27;
                  }

                  if(var36 < 127 && var37 < 127 && class118.field1838[var36 + 1][var37 + 1] == 0 && (var24[1 + var25][1 + var26] & 19136992) == 0 && (var24[var25 + 1][var26] & 19136896) == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
                     class118.field1842[var39] = 1 + var16;
                     class118.field1843[var39] = 1 + var17;
                     var39 = 1 + var39 & 4095;
                     class118.field1838[1 + var36][var37 + 1] = 12;
                     class118.field1840[1 + var36][1 + var37] = var27;
                  }
               }

               var34 = var35;
            } else if(var8 == 2) {
               var34 = DecorativeObject.method1906(var4, var5, var9, var11);
            } else {
               var16 = var4;
               var17 = var5;
               var18 = 64;
               var19 = 64;
               var20 = var4 - var18;
               var21 = var5 - var19;
               class118.field1838[var18][var19] = 99;
               class118.field1840[var18][var19] = 0;
               var22 = 0;
               var23 = 0;
               class118.field1842[var22] = var4;
               var39 = var22 + 1;
               class118.field1843[var22] = var5;
               var24 = var11.flags;

               label745:
               while(true) {
                  label743:
                  while(true) {
                     do {
                        do {
                           do {
                              label720:
                              do {
                                 if(var23 == var39) {
                                    class118.field1844 = var16;
                                    class105.field1722 = var17;
                                    var35 = false;
                                    break label745;
                                 }

                                 var16 = class118.field1842[var23];
                                 var17 = class118.field1843[var23];
                                 var23 = var23 + 1 & 4095;
                                 var36 = var16 - var20;
                                 var37 = var17 - var21;
                                 var25 = var16 - var11.x;
                                 var26 = var17 - var11.y;
                                 if(var10.vmethod2275(var8, var16, var17, var11)) {
                                    class118.field1844 = var16;
                                    class105.field1722 = var17;
                                    var35 = true;
                                    break label745;
                                 }

                                 var27 = 1 + class118.field1840[var36][var37];
                                 if(var36 > 0 && class118.field1838[var36 - 1][var37] == 0 && (var24[var25 - 1][var26] & 19136782) == 0 && (var24[var25 - 1][var26 + var8 - 1] & 19136824) == 0) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8 - 1) {
                                          class118.field1842[var39] = var16 - 1;
                                          class118.field1843[var39] = var17;
                                          var39 = var39 + 1 & 4095;
                                          class118.field1838[var36 - 1][var37] = 2;
                                          class118.field1840[var36 - 1][var37] = var27;
                                          break;
                                       }

                                       if((var24[var25 - 1][var28 + var26] & 19136830) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var36 < 128 - var8 && class118.field1838[1 + var36][var37] == 0 && (var24[var8 + var25][var26] & 19136899) == 0 && (var24[var25 + var8][var8 + var26 - 1] & 19136992) == 0) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8 - 1) {
                                          class118.field1842[var39] = var16 + 1;
                                          class118.field1843[var39] = var17;
                                          var39 = var39 + 1 & 4095;
                                          class118.field1838[var36 + 1][var37] = 8;
                                          class118.field1840[var36 + 1][var37] = var27;
                                          break;
                                       }

                                       if((var24[var8 + var25][var26 + var28] & 19136995) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var37 > 0 && class118.field1838[var36][var37 - 1] == 0 && (var24[var25][var26 - 1] & 19136782) == 0 && (var24[var25 + var8 - 1][var26 - 1] & 19136899) == 0) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8 - 1) {
                                          class118.field1842[var39] = var16;
                                          class118.field1843[var39] = var17 - 1;
                                          var39 = var39 + 1 & 4095;
                                          class118.field1838[var36][var37 - 1] = 1;
                                          class118.field1840[var36][var37 - 1] = var27;
                                          break;
                                       }

                                       if((var24[var28 + var25][var26 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var37 < 128 - var8 && class118.field1838[var36][1 + var37] == 0 && (var24[var25][var8 + var26] & 19136824) == 0 && (var24[var25 + var8 - 1][var8 + var26] & 19136992) == 0) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8 - 1) {
                                          class118.field1842[var39] = var16;
                                          class118.field1843[var39] = var17 + 1;
                                          var39 = var39 + 1 & 4095;
                                          class118.field1838[var36][var37 + 1] = 4;
                                          class118.field1840[var36][1 + var37] = var27;
                                          break;
                                       }

                                       if((var24[var25 + var28][var8 + var26] & 19137016) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var36 > 0 && var37 > 0 && class118.field1838[var36 - 1][var37 - 1] == 0 && (var24[var25 - 1][var26 - 1] & 19136782) == 0) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8) {
                                          class118.field1842[var39] = var16 - 1;
                                          class118.field1843[var39] = var17 - 1;
                                          var39 = 1 + var39 & 4095;
                                          class118.field1838[var36 - 1][var37 - 1] = 3;
                                          class118.field1840[var36 - 1][var37 - 1] = var27;
                                          break;
                                       }

                                       if((var24[var25 - 1][var28 + (var26 - 1)] & 19136830) != 0 || (var24[var28 + (var25 - 1)][var26 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var36 < 128 - var8 && var37 > 0 && class118.field1838[1 + var36][var37 - 1] == 0 && (var24[var25 + var8][var26 - 1] & 19136899) == 0) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8) {
                                          class118.field1842[var39] = 1 + var16;
                                          class118.field1843[var39] = var17 - 1;
                                          var39 = var39 + 1 & 4095;
                                          class118.field1838[1 + var36][var37 - 1] = 9;
                                          class118.field1840[1 + var36][var37 - 1] = var27;
                                          break;
                                       }

                                       if((var24[var25 + var8][var28 + (var26 - 1)] & 19136995) != 0 || (var24[var25 + var28][var26 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var36 > 0 && var37 < 128 - var8 && class118.field1838[var36 - 1][var37 + 1] == 0 && (var24[var25 - 1][var26 + var8] & 19136824) == 0) {
                                    for(var28 = 1; var28 < var8; ++var28) {
                                       if((var24[var25 - 1][var26 + var28] & 19136830) != 0 || (var24[var25 - 1 + var28][var26 + var8] & 19137016) != 0) {
                                          continue label720;
                                       }
                                    }

                                    class118.field1842[var39] = var16 - 1;
                                    class118.field1843[var39] = var17 + 1;
                                    var39 = var39 + 1 & 4095;
                                    class118.field1838[var36 - 1][1 + var37] = 6;
                                    class118.field1840[var36 - 1][1 + var37] = var27;
                                 }
                              } while(var36 >= 128 - var8);
                           } while(var37 >= 128 - var8);
                        } while(class118.field1838[var36 + 1][1 + var37] != 0);
                     } while((var24[var25 + var8][var8 + var26] & 19136992) != 0);

                     for(var28 = 1; var28 < var8; ++var28) {
                        if((var24[var28 + var25][var8 + var26] & 19137016) != 0 || (var24[var25 + var8][var26 + var28] & 19136995) != 0) {
                           continue label743;
                        }
                     }

                     class118.field1842[var39] = 1 + var16;
                     class118.field1843[var39] = var17 + 1;
                     var39 = var39 + 1 & 4095;
                     class118.field1838[var36 + 1][var37 + 1] = 12;
                     class118.field1840[1 + var36][var37 + 1] = var27;
                  }
               }

               var34 = var35;
            }

            int var7;
            label793: {
               var15 = var4 - 64;
               var16 = var5 - 64;
               var17 = class118.field1844;
               var36 = class105.field1722;
               if(!var34) {
                  var37 = Integer.MAX_VALUE;
                  var20 = Integer.MAX_VALUE;
                  byte var38 = 10;
                  var39 = var10.field1846;
                  var23 = var10.field1847;
                  int var33 = var10.field1848;
                  var25 = var10.field1850;

                  for(var26 = var39 - var38; var26 <= var38 + var39; ++var26) {
                     for(var27 = var23 - var38; var27 <= var38 + var23; ++var27) {
                        var28 = var26 - var15;
                        int var29 = var27 - var16;
                        if(var28 >= 0 && var29 >= 0 && var28 < 128 && var29 < 128 && class118.field1840[var28][var29] < 100) {
                           int var30 = 0;
                           if(var26 < var39) {
                              var30 = var39 - var26;
                           } else if(var26 > var33 + var39 - 1) {
                              var30 = var26 - (var33 + var39 - 1);
                           }

                           int var31 = 0;
                           if(var27 < var23) {
                              var31 = var23 - var27;
                           } else if(var27 > var25 + var23 - 1) {
                              var31 = var27 - (var25 + var23 - 1);
                           }

                           int var32 = var31 * var31 + var30 * var30;
                           if(var32 < var37 || var32 == var37 && class118.field1840[var28][var29] < var20) {
                              var37 = var32;
                              var20 = class118.field1840[var28][var29];
                              var17 = var26;
                              var36 = var27;
                           }
                        }
                     }
                  }

                  if(var37 == Integer.MAX_VALUE) {
                     var7 = -1;
                     break label793;
                  }
               }

               if(var4 == var17 && var5 == var36) {
                  var7 = 0;
               } else {
                  var19 = 0;
                  class118.field1842[var19] = var17;
                  var37 = var19 + 1;
                  class118.field1843[var19] = var36;

                  for(var20 = var21 = class118.field1838[var17 - var15][var36 - var16]; var17 != var4 || var36 != var5; var20 = class118.field1838[var17 - var15][var36 - var16]) {
                     if(var21 != var20) {
                        var21 = var20;
                        class118.field1842[var37] = var17;
                        class118.field1843[var37++] = var36;
                     }

                     if((var20 & 2) != 0) {
                        ++var17;
                     } else if((var20 & 8) != 0) {
                        --var17;
                     }

                     if((var20 & 1) != 0) {
                        ++var36;
                     } else if((var20 & 4) != 0) {
                        --var36;
                     }
                  }

                  var39 = 0;

                  while(var37-- > 0) {
                     var12[var39] = class118.field1842[var37];
                     var13[var39++] = class118.field1843[var37];
                     if(var39 >= var12.length) {
                        break;
                     }
                  }

                  var7 = var39;
               }
            }

            var14 = var7;
            if(var7 >= 1) {
               for(var15 = 0; var15 < var14 - 1; ++var15) {
                  var0.method240(Client.field532[var15], Client.field463[var15], var3);
               }

            }
         }
      }
   }
}
