import java.awt.Image;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
final class class5 implements Comparator {
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = 1184382683
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("n")
   static SpritePixels field60;
   @ObfuscatedName("k")
   static int[] field61;
   @ObfuscatedName("qd")
   protected static Image field65;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-2131323617"
   )
   int method59(class2 var1, class2 var2) {
      return var1.field26.price < var2.field26.price?-1:(var1.field26.price == var2.field26.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method59((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZI)I",
      garbageValue = "-1676378254"
   )
   static int method64(int var0, Script var1, boolean var2) {
      String var3;
      if(var0 == 3100) {
         var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
         class16.sendGameMessage(0, "", var3);
         return 1;
      } else if(var0 == 3101) {
         class103.scriptIntStackSize -= 2;
         class47.method965(class36.localPlayer, class32.scriptIntStack[class103.scriptIntStackSize], class32.scriptIntStack[class103.scriptIntStackSize + 1]);
         return 1;
      } else if(var0 == 3103) {
         Buffer.method3033();
         return 1;
      } else {
         int var13;
         if(var0 == 3104) {
            var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
            var13 = 0;
            if(class105.method2082(var3)) {
               var13 = class145.method2759(var3);
            }

            Client.field348.method3073(23);
            Client.field348.method2821(var13);
            return 1;
         } else if(var0 == 3105) {
            var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
            Client.field348.method3073(191);
            Client.field348.method2918(var3.length() + 1);
            Client.field348.method2824(var3);
            return 1;
         } else if(var0 == 3106) {
            var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
            Client.field348.method3073(41);
            Client.field348.method2918(var3.length() + 1);
            Client.field348.method2824(var3);
            return 1;
         } else {
            String var10;
            int var11;
            int var12;
            if(var0 != 3107) {
               if(var0 == 3108) {
                  class103.scriptIntStackSize -= 3;
                  var11 = class32.scriptIntStack[class103.scriptIntStackSize];
                  var13 = class32.scriptIntStack[1 + class103.scriptIntStackSize];
                  var12 = class32.scriptIntStack[class103.scriptIntStackSize + 2];
                  Widget var15 = class179.method3296(var12);
                  Friend.method176(var15, var11, var13);
                  return 1;
               } else if(var0 == 3109) {
                  class103.scriptIntStackSize -= 2;
                  var11 = class32.scriptIntStack[class103.scriptIntStackSize];
                  var13 = class32.scriptIntStack[1 + class103.scriptIntStackSize];
                  Widget var14 = var2?XGrandExchangeOffer.field58:XClanMember.field297;
                  Friend.method176(var14, var11, var13);
                  return 1;
               } else if(var0 == 3110) {
                  class15.field173 = class32.scriptIntStack[--class103.scriptIntStackSize] == 1;
                  return 1;
               } else if(var0 == 3111) {
                  class32.scriptIntStack[++class103.scriptIntStackSize - 1] = class184.field2735.field714?1:0;
                  return 1;
               } else if(var0 == 3112) {
                  class184.field2735.field714 = class32.scriptIntStack[--class103.scriptIntStackSize] == 1;
                  class99.method1996();
                  return 1;
               } else if(var0 == 3113) {
                  var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                  boolean var4 = class32.scriptIntStack[--class103.scriptIntStackSize] == 1;
                  TextureProvider.method1507(var3, var4, "openjs", false);
                  return 1;
               } else if(var0 == 3115) {
                  var11 = class32.scriptIntStack[--class103.scriptIntStackSize];
                  Client.field348.method3073(184);
                  Client.field348.method2831(var11);
                  return 1;
               } else if(var0 == 3116) {
                  var11 = class32.scriptIntStack[--class103.scriptIntStackSize];
                  class32.scriptStringStackSize -= 2;
                  var10 = class32.scriptStringStack[class32.scriptStringStackSize];
                  String var5 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                  if(var10.length() > 500) {
                     return 1;
                  } else if(var5.length() > 500) {
                     return 1;
                  } else {
                     Client.field348.method3073(179);
                     Client.field348.method2831(1 + class119.method2340(var10) + class119.method2340(var5));
                     Client.field348.method2824(var5);
                     Client.field348.method2935(var11);
                     Client.field348.method2824(var10);
                     return 1;
                  }
               } else if(var0 == 3117) {
                  Client.field453 = class32.scriptIntStack[--class103.scriptIntStackSize] == 1;
                  return 1;
               } else {
                  return 2;
               }
            } else {
		    //3107
               var11 = class32.scriptIntStack[--class103.scriptIntStackSize];
               var10 = class32.scriptStringStack[--class32.scriptStringStackSize];
               var12 = class45.field921;
               int[] var6 = class45.field931;
               boolean var7 = false;

               for(int var8 = 0; var8 < var12; ++var8) {
                  Player var9 = Client.cachedPlayers[var6[var8]];
                  if(null != var9 && var9 != class36.localPlayer && var9.name != null && var9.name.equalsIgnoreCase(var10)) {
                     if(var11 == 1) {
                        Client.field348.method3073(96);
                        Client.field348.method2831(var6[var8]);
                        Client.field348.method2856(0);
                     } else if(var11 == 4) {
                        Client.field348.method3073(42);
                        Client.field348.method2918(0);
                        Client.field348.method2865(var6[var8]);
                     } else if(var11 == 6) {
                        Client.field348.method3073(176);
                        Client.field348.method2857(0);
                        Client.field348.method2864(var6[var8]);
                     } else if(var11 == 7) {
                        Client.field348.method3073(30);
                        Client.field348.method2865(var6[var8]);
                        Client.field348.method2935(0);
                     }

                     var7 = true;
                     break;
                  }
               }

               if(!var7) {
                  class16.sendGameMessage(4, "", "Unable to find " + var10);
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[IB)V",
      garbageValue = "1"
   )
   static void method66(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var1 + var2) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method668()?1:0;
                     var12 = var8.method668()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method668()?1:0;
                     var12 = var8.method668()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method66(var0, var1, var6, var3, var4);
         method66(var0, 1 + var6, var2, var3, var4);
      }

   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-987059047"
   )
   static final void method68() {
      int var1;
      int var3;
      int var5;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      if(Client.packetOpcode == 248) {
         byte var0 = Client.field350.method3023();
         var1 = Client.field350.method2867();
         byte var2 = Client.field350.method3015();
         var3 = Client.field350.method2873();
         byte var4 = Client.field350.readByte();
         var5 = Client.field350.readUnsignedShort();
         byte var6 = Client.field350.method3023();
         var7 = Client.field350.method2873();
         var8 = Client.field350.method2859();
         var9 = var8 >> 2;
         var10 = var8 & 3;
         var11 = Client.field368[var9];
         var12 = Client.field350.readUnsignedByte();
         int var13 = class181.field2704 + (var12 >> 4 & 7);
         int var14 = class8.field81 + (var12 & 7);
         Player var15;
         if(var7 == Client.localInteractingIndex) {
            var15 = class36.localPlayer;
         } else {
            var15 = Client.cachedPlayers[var7];
         }

         if(null != var15) {
            ObjectComposition var16 = class187.getObjectDefinition(var3);
            int var17;
            int var18;
            if(var10 != 1 && var10 != 3) {
               var17 = var16.sizeX;
               var18 = var16.sizeY;
            } else {
               var17 = var16.sizeY;
               var18 = var16.sizeX;
            }

            int var19 = var13 + (var17 >> 1);
            int var20 = (1 + var17 >> 1) + var13;
            int var21 = (var18 >> 1) + var14;
            int var22 = (var18 + 1 >> 1) + var14;
            int[][] var23 = class10.tileHeights[WallObject.plane];
            int var24 = var23[var19][var21] + var23[var20][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
            int var25 = (var13 << 7) + (var17 << 6);
            int var26 = (var14 << 7) + (var18 << 6);
            Model var27 = var16.method3653(var9, var10, var23, var25, var24, var26);
            if(var27 != null) {
               class13.method171(WallObject.plane, var13, var14, var11, -1, 0, 0, 1 + var1, var5 + 1);
               var15.totalLevel = Client.gameCycle + var1;
               var15.field265 = Client.gameCycle + var5;
               var15.model = var27;
               var15.field266 = var17 * 64 + var13 * 128;
               var15.field268 = var18 * 64 + var14 * 128;
               var15.field267 = var24;
               byte var28;
               if(var2 > var6) {
                  var28 = var2;
                  var2 = var6;
                  var6 = var28;
               }

               if(var4 > var0) {
                  var28 = var4;
                  var4 = var0;
                  var0 = var28;
               }

               var15.field270 = var13 + var2;
               var15.field271 = var13 + var6;
               var15.field282 = var14 + var4;
               var15.field273 = var14 + var0;
            }
         }
      }

      Item var31;
      int var35;
      int var36;
      if(Client.packetOpcode == 225) {
         var35 = Client.field350.readUnsignedByte();
         var1 = (var35 >> 4 & 7) + class181.field2704;
         var36 = (var35 & 7) + class8.field81;
         var3 = Client.field350.method2867();
         if(var1 >= 0 && var36 >= 0 && var1 < 104 && var36 < 104) {
            Deque var30 = Client.groundItemDeque[WallObject.plane][var1][var36];
            if(var30 != null) {
               for(var31 = (Item)var30.method2458(); var31 != null; var31 = (Item)var30.method2472()) {
                  if((var3 & 32767) == var31.id) {
                     var31.unlink();
                     break;
                  }
               }

               if(var30.method2458() == null) {
                  Client.groundItemDeque[WallObject.plane][var1][var36] = null;
               }

               class88.groundItemSpawned(var1, var36);
            }
         }

      } else {
         int var37;
         int var38;
         if(Client.packetOpcode == 153) {
            var35 = Client.field350.readUnsignedByte();
            var1 = class181.field2704 + (var35 >> 4 & 7);
            var36 = class8.field81 + (var35 & 7);
            var3 = Client.field350.readUnsignedShort();
            var37 = Client.field350.readUnsignedByte();
            var5 = var37 >> 4 & 15;
            var38 = var37 & 7;
            var7 = Client.field350.readUnsignedByte();
            if(var1 >= 0 && var36 >= 0 && var1 < 104 && var36 < 104) {
               var8 = 1 + var5;
               if(class36.localPlayer.pathX[0] >= var1 - var8 && class36.localPlayer.pathX[0] <= var1 + var8 && class36.localPlayer.pathY[0] >= var36 - var8 && class36.localPlayer.pathY[0] <= var8 + var36 && Client.field546 != 0 && var38 > 0 && Client.field547 < 50) {
                  Client.field548[Client.field547] = var3;
                  Client.field549[Client.field547] = var38;
                  Client.field550[Client.field547] = var7;
                  Client.field349[Client.field547] = null;
                  Client.field555[Client.field547] = (var1 << 16) + (var36 << 8) + var5;
                  ++Client.field547;
               }
            }
         }

         if(Client.packetOpcode == 84) {
            var35 = Client.field350.method2861();
            var1 = class181.field2704 + (var35 >> 4 & 7);
            var36 = (var35 & 7) + class8.field81;
            var3 = Client.field350.method2873();
            var37 = Client.field350.method2873();
            if(var1 >= 0 && var36 >= 0 && var1 < 104 && var36 < 104) {
               var31 = new Item();
               var31.id = var3;
               var31.quantity = var37;
               if(null == Client.groundItemDeque[WallObject.plane][var1][var36]) {
                  Client.groundItemDeque[WallObject.plane][var1][var36] = new Deque();
               }

               Client.groundItemDeque[WallObject.plane][var1][var36].method2453(var31);
               class88.groundItemSpawned(var1, var36);
            }

         } else if(Client.packetOpcode == 247) {
            var35 = Client.field350.readUnsignedByte();
            var1 = (var35 >> 4 & 7) + class181.field2704;
            var36 = (var35 & 7) + class8.field81;
            var3 = var1 + Client.field350.readByte();
            var37 = var36 + Client.field350.readByte();
            var5 = Client.field350.readShort();
            var38 = Client.field350.readUnsignedShort();
            var7 = Client.field350.readUnsignedByte() * 4;
            var8 = Client.field350.readUnsignedByte() * 4;
            var9 = Client.field350.readUnsignedShort();
            var10 = Client.field350.readUnsignedShort();
            var11 = Client.field350.readUnsignedByte();
            var12 = Client.field350.readUnsignedByte();
            if(var1 >= 0 && var36 >= 0 && var1 < 104 && var36 < 104 && var3 >= 0 && var37 >= 0 && var3 < 104 && var37 < 104 && var38 != '\uffff') {
               var1 = var1 * 128 + 64;
               var36 = 128 * var36 + 64;
               var3 = 64 + 128 * var3;
               var37 = 64 + 128 * var37;
               Projectile var33 = new Projectile(var38, WallObject.plane, var1, var36, class2.method19(var1, var36, WallObject.plane) - var7, Client.gameCycle + var9, Client.gameCycle + var10, var11, var12, var5, var8);
               var33.method867(var3, var37, class2.method19(var3, var37, WallObject.plane) - var8, var9 + Client.gameCycle);
               Client.projectiles.method2453(var33);
            }

         } else if(Client.packetOpcode == 231) {
            var35 = Client.field350.method2861();
            var1 = (var35 >> 4 & 7) + class181.field2704;
            var36 = (var35 & 7) + class8.field81;
            var3 = Client.field350.method2861();
            var37 = var3 >> 2;
            var5 = var3 & 3;
            var38 = Client.field368[var37];
            var7 = Client.field350.method2867();
            if(var1 >= 0 && var36 >= 0 && var1 < 104 && var36 < 104) {
               class13.method171(WallObject.plane, var1, var36, var38, var7, var37, var5, 0, -1);
            }

         } else if(Client.packetOpcode == 116) {
            var35 = Client.field350.readUnsignedByte();
            var1 = (var35 >> 4 & 7) + class181.field2704;
            var36 = class8.field81 + (var35 & 7);
            var3 = Client.field350.readUnsignedShort();
            var37 = Client.field350.readUnsignedByte();
            var5 = Client.field350.readUnsignedShort();
            if(var1 >= 0 && var36 >= 0 && var1 < 104 && var36 < 104) {
               var1 = var1 * 128 + 64;
               var36 = 128 * var36 + 64;
               class33 var39 = new class33(var3, WallObject.plane, var1, var36, class2.method19(var1, var36, WallObject.plane) - var37, var5, Client.gameCycle);
               Client.field418.method2453(var39);
            }

         } else if(Client.packetOpcode == 58) {
            var35 = Client.field350.method2859();
            var1 = class181.field2704 + (var35 >> 4 & 7);
            var36 = class8.field81 + (var35 & 7);
            var3 = Client.field350.method2861();
            var37 = var3 >> 2;
            var5 = var3 & 3;
            var38 = Client.field368[var37];
            var7 = Client.field350.readUnsignedShort();
            if(var1 >= 0 && var36 >= 0 && var1 < 103 && var36 < 103) {
               if(var38 == 0) {
                  WallObject var32 = Script.region.method1769(WallObject.plane, var1, var36);
                  if(var32 != null) {
                     var9 = var32.hash >> 14 & 32767;
                     if(var37 == 2) {
                        var32.renderable1 = new class49(var9, 2, var5 + 4, WallObject.plane, var1, var36, var7, false, var32.renderable1);
                        var32.renderable2 = new class49(var9, 2, var5 + 1 & 3, WallObject.plane, var1, var36, var7, false, var32.renderable2);
                     } else {
                        var32.renderable1 = new class49(var9, var37, var5, WallObject.plane, var1, var36, var7, false, var32.renderable1);
                     }
                  }
               }

               if(var38 == 1) {
                  DecorativeObject var40 = Script.region.method1927(WallObject.plane, var1, var36);
                  if(null != var40) {
                     var9 = var40.hash >> 14 & 32767;
                     if(var37 != 4 && var37 != 5) {
                        if(var37 == 6) {
                           var40.renderable1 = new class49(var9, 4, var5 + 4, WallObject.plane, var1, var36, var7, false, var40.renderable1);
                        } else if(var37 == 7) {
                           var40.renderable1 = new class49(var9, 4, (var5 + 2 & 3) + 4, WallObject.plane, var1, var36, var7, false, var40.renderable1);
                        } else if(var37 == 8) {
                           var40.renderable1 = new class49(var9, 4, var5 + 4, WallObject.plane, var1, var36, var7, false, var40.renderable1);
                           var40.renderable2 = new class49(var9, 4, 4 + (2 + var5 & 3), WallObject.plane, var1, var36, var7, false, var40.renderable2);
                        }
                     } else {
                        var40.renderable1 = new class49(var9, 4, var5, WallObject.plane, var1, var36, var7, false, var40.renderable1);
                     }
                  }
               }

               if(var38 == 2) {
                  GameObject var41 = Script.region.method1854(WallObject.plane, var1, var36);
                  if(var37 == 11) {
                     var37 = 10;
                  }

                  if(var41 != null) {
                     var41.renderable = new class49(var41.hash >> 14 & 32767, var37, var5, WallObject.plane, var1, var36, var7, false, var41.renderable);
                  }
               }

               if(var38 == 3) {
                  GroundObject var42 = Script.region.method1772(WallObject.plane, var1, var36);
                  if(null != var42) {
                     var42.renderable = new class49(var42.hash >> 14 & 32767, 22, var5, WallObject.plane, var1, var36, var7, false, var42.renderable);
                  }
               }
            }

         } else if(Client.packetOpcode == 186) {
            var35 = Client.field350.method2897();
            var1 = var35 >> 2;
            var36 = var35 & 3;
            var3 = Client.field368[var1];
            var37 = Client.field350.method2897();
            var5 = (var37 >> 4 & 7) + class181.field2704;
            var38 = (var37 & 7) + class8.field81;
            if(var5 >= 0 && var38 >= 0 && var5 < 104 && var38 < 104) {
               class13.method171(WallObject.plane, var5, var38, var3, -1, var1, var36, 0, -1);
            }

         } else if(Client.packetOpcode == 44) {
            var35 = Client.field350.readUnsignedByte();
            var1 = (var35 >> 4 & 7) + class181.field2704;
            var36 = (var35 & 7) + class8.field81;
            var3 = Client.field350.readUnsignedShort();
            var37 = Client.field350.readUnsignedShort();
            var5 = Client.field350.readUnsignedShort();
            if(var1 >= 0 && var36 >= 0 && var1 < 104 && var36 < 104) {
               Deque var29 = Client.groundItemDeque[WallObject.plane][var1][var36];
               if(null != var29) {
                  for(Item var34 = (Item)var29.method2458(); var34 != null; var34 = (Item)var29.method2472()) {
                     if((var3 & 32767) == var34.id && var37 == var34.quantity) {
                        var34.quantity = var5;
                        break;
                     }
                  }

                  class88.groundItemSpawned(var1, var36);
               }
            }

         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "1185263182"
   )
   public static String method70(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }
}
