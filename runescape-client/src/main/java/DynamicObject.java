import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("nl")
   @ObfuscatedSignature(
      signature = "[Lbs;"
   )
   @Export("clanMembers")
   static ClanMember[] clanMembers;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 1294384165
   )
   static int field1456;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1738258385
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1429042623
   )
   @Export("type")
   int type;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 833938059
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1528196667
   )
   @Export("level")
   int level;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 162936493
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1506807491
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   Sequence field1449;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1133556855
   )
   int field1453;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 730694003
   )
   int field1454;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLei;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1449 = ItemLayer.getAnimation(var7);
         this.field1453 = 0;
         this.field1454 = Client.gameCycle - 1;
         if(this.field1449.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.field1449 == this.field1449) {
               this.field1453 = var10.field1453;
               this.field1454 = var10.field1454;
               return;
            }
         }

         if(var8 && this.field1449.frameStep != -1) {
            this.field1453 = (int)(Math.random() * (double)this.field1449.frameIDs.length);
            this.field1454 -= (int)(Math.random() * (double)this.field1449.frameLenghts[this.field1453]);
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Len;",
      garbageValue = "-1864051962"
   )
   protected final Model getModel() {
      if(this.field1449 != null) {
         int var1 = Client.gameCycle - this.field1454;
         if(var1 > 100 && this.field1449.frameStep > 0) {
            var1 = 100;
         }

         label52: {
            do {
               do {
                  if(var1 <= this.field1449.frameLenghts[this.field1453]) {
                     break label52;
                  }

                  var1 -= this.field1449.frameLenghts[this.field1453];
                  ++this.field1453;
               } while(this.field1453 < this.field1449.frameIDs.length);

               this.field1453 -= this.field1449.frameStep;
            } while(this.field1453 >= 0 && this.field1453 < this.field1449.frameIDs.length);

            this.field1449 = null;
         }

         this.field1454 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class24.getObjectDefinition(this.id);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.orientation != 1 && this.orientation != 3) {
            var2 = var12.sizeX;
            var3 = var12.sizeY;
         } else {
            var2 = var12.sizeY;
            var3 = var12.sizeX;
         }

         int var4 = (var2 >> 1) + this.sceneX;
         int var5 = (var2 + 1 >> 1) + this.sceneX;
         int var6 = (var3 >> 1) + this.sceneY;
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class61.tileHeights[this.level];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var5][var6] + var8[var4][var6] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4693(this.type, this.orientation, var8, var10, var9, var11, this.field1449, this.field1453);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
      garbageValue = "1954150950"
   )
   static String method1931(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class153) {
         class153 var2 = (class153)var0;
         var1 = var2.field2134 + " | ";
         var0 = var2.field2137;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(var7 == null) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, var8 + 1);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(var8 + 1, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1967965153"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class96.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class96.field1433.put(var5, (long)var5.id);
      class96.field1427.method3837(var5);
      Client.chatCycle = Client.cycleCntr;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1379224596"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3289 != 0 && var3 > IndexDataBase.field3289) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 >= 0 && (IndexDataBase.field3289 == 0 || var6 <= IndexDataBase.field3289)) {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class174.method3227(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1852519105"
   )
   static final void method1935() {
      class274.flush(false);
      Client.field1029 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class148.field2107.length; ++var1) {
         if(Varbit.landMapFileIds[var1] != -1 && class148.field2107[var1] == null) {
            class148.field2107[var1] = class56.indexMaps.getConfigData(Varbit.landMapFileIds[var1], 0);
            if(class148.field2107[var1] == null) {
               var0 = false;
               ++Client.field1029;
            }
         }

         if(Varbit.landRegionFileIds[var1] != -1 && class36.field482[var1] == null) {
            class36.field482[var1] = class56.indexMaps.getConfigData(Varbit.landRegionFileIds[var1], 0, class21.xteaKeys[var1]);
            if(class36.field482[var1] == null) {
               var0 = false;
               ++Client.field1029;
            }
         }
      }

      if(!var0) {
         Client.field920 = 1;
      } else {
         Client.field918 = 0;
         var0 = true;

         int var3;
         int var4;
         int var9;
         int var10;
         int var11;
         int var13;
         int var14;
         int var15;
         int var16;
         int var17;
         int var18;
         for(var1 = 0; var1 < class148.field2107.length; ++var1) {
            byte[] var2 = class36.field482[var1];
            if(var2 != null) {
               var3 = (Script.mapRegions[var1] >> 8) * 64 - ItemLayer.baseX;
               var4 = (Script.mapRegions[var1] & 255) * 64 - ItemLayer.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               Buffer var8 = new Buffer(var2);
               var9 = -1;

               label1275:
               while(true) {
                  var10 = var8.getUSmart();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var8.getUSmart();
                        if(var13 == 0) {
                           continue label1275;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.readUnsignedByte() >> 2;
                        var17 = var3 + var15;
                        var18 = var4 + var14;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           ObjectComposition var19 = class24.getObjectDefinition(var9);
                           if(var16 != 22 || !Client.lowMemory || var19.field3506 != 0 || var19.interactType == 1 || var19.field3525) {
                              if(!var19.method4698()) {
                                 ++Client.field918;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.getUSmart();
                     if(var13 == 0) {
                        break;
                     }

                     var8.readUnsignedByte();
                  }
               }
            }
         }

         if(!var0) {
            Client.field920 = 2;
         } else {
            if(Client.field920 != 0) {
               class66.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class90.method1801();
            World.method1669();
            class90.method1801();
            class56.region.reset();
            class90.method1801();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].reset();
            }

            int var44;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var44 = 0; var44 < 104; ++var44) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class61.tileSettings[var1][var44][var3] = 0;
                  }
               }
            }

            class90.method1801();
            Buffer.method3420();
            var1 = class148.field2107.length;
            CombatInfo2.method4592();
            class274.flush(true);
            int var5;
            if(!Client.isDynamicRegion) {
               byte[] var45;
               for(var44 = 0; var44 < var1; ++var44) {
                  var3 = (Script.mapRegions[var44] >> 8) * 64 - ItemLayer.baseX;
                  var4 = (Script.mapRegions[var44] & 255) * 64 - ItemLayer.baseY;
                  var45 = class148.field2107[var44];
                  if(var45 != null) {
                     class90.method1801();
                     ItemLayer.method2519(var45, var3, var4, class231.field2918 * 8 - 48, class91.field1367 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var44 = 0; var44 < var1; ++var44) {
                  var3 = (Script.mapRegions[var44] >> 8) * 64 - ItemLayer.baseX;
                  var4 = (Script.mapRegions[var44] & 255) * 64 - ItemLayer.baseY;
                  var45 = class148.field2107[var44];
                  if(var45 == null && class91.field1367 < 800) {
                     class90.method1801();
                     PendingSpawn.method1610(var3, var4, 64, 64);
                  }
               }

               class274.flush(true);

               for(var44 = 0; var44 < var1; ++var44) {
                  byte[] var46 = class36.field482[var44];
                  if(var46 != null) {
                     var4 = (Script.mapRegions[var44] >> 8) * 64 - ItemLayer.baseX;
                     var5 = (Script.mapRegions[var44] & 255) * 64 - ItemLayer.baseY;
                     class90.method1801();
                     class39.method593(var46, var4, var5, class56.region, Client.collisionMaps);
                  }
               }
            }

            int var6;
            int var20;
            int var21;
            int var22;
            int var23;
            int var24;
            int var25;
            int var26;
            int var27;
            int var28;
            int var29;
            int var31;
            int var32;
            int var33;
            int var47;
            int var57;
            int var58;
            if(Client.isDynamicRegion) {
               for(var44 = 0; var44 < 4; ++var44) {
                  class90.method1801();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var56 = false;
                        var6 = Client.field884[var44][var3][var4];
                        if(var6 != -1) {
                           var57 = var6 >> 24 & 3;
                           var47 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(var58 = 0; var58 < Script.mapRegions.length; ++var58) {
                              if(Script.mapRegions[var58] == var11 && class148.field2107[var58] != null) {
                                 Client.method1542(class148.field2107[var58], var44, var3 * 8, var4 * 8, var57, (var9 & 7) * 8, (var10 & 7) * 8, var47, Client.collisionMaps);
                                 var56 = true;
                                 break;
                              }
                           }
                        }

                        if(!var56) {
                           class94.method1867(var44, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var44 = 0; var44 < 13; ++var44) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field884[0][var44][var3];
                     if(var4 == -1) {
                        PendingSpawn.method1610(var44 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               class274.flush(true);

               for(var44 = 0; var44 < 4; ++var44) {
                  class90.method1801();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label1150:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field884[var44][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var57 = var5 >> 1 & 3;
                           var47 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = (var47 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < Script.mapRegions.length; ++var11) {
                              if(Script.mapRegions[var11] == var10 && class36.field482[var11] != null) {
                                 byte[] var49 = class36.field482[var11];
                                 var13 = var3 * 8;
                                 var14 = var4 * 8;
                                 var15 = (var47 & 7) * 8;
                                 var16 = (var9 & 7) * 8;
                                 Region var50 = class56.region;
                                 CollisionData[] var51 = Client.collisionMaps;
                                 Buffer var59 = new Buffer(var49);
                                 var20 = -1;

                                 while(true) {
                                    var21 = var59.getUSmart();
                                    if(var21 == 0) {
                                       continue label1150;
                                    }

                                    var20 += var21;
                                    var22 = 0;

                                    while(true) {
                                       var23 = var59.getUSmart();
                                       if(var23 == 0) {
                                          break;
                                       }

                                       var22 += var23 - 1;
                                       var24 = var22 & 63;
                                       var25 = var22 >> 6 & 63;
                                       var26 = var22 >> 12;
                                       var27 = var59.readUnsignedByte();
                                       var28 = var27 >> 2;
                                       var29 = var27 & 3;
                                       if(var6 == var26 && var25 >= var15 && var25 < var15 + 8 && var24 >= var16 && var24 < var16 + 8) {
                                          ObjectComposition var30 = class24.getObjectDefinition(var20);
                                          var31 = var13 + class74.method1226(var25 & 7, var24 & 7, var57, var30.sizeX, var30.sizeY, var29);
                                          var32 = var14 + RSCanvas.method851(var25 & 7, var24 & 7, var57, var30.sizeX, var30.sizeY, var29);
                                          if(var31 > 0 && var32 > 0 && var31 < 103 && var32 < 103) {
                                             var33 = var44;
                                             if((class61.tileSettings[1][var31][var32] & 2) == 2) {
                                                var33 = var44 - 1;
                                             }

                                             CollisionData var34 = null;
                                             if(var33 >= 0) {
                                                var34 = var51[var33];
                                             }

                                             class153.addObject(var44, var31, var32, var20, var29 + var57 & 3, var28, var50, var34);
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class274.flush(true);
            World.method1669();
            class90.method1801();
            Region var55 = class56.region;
            CollisionData[] var64 = Client.collisionMaps;

            for(var4 = 0; var4 < 4; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  for(var6 = 0; var6 < 104; ++var6) {
                     if((class61.tileSettings[var4][var5][var6] & 1) == 1) {
                        var57 = var4;
                        if((class61.tileSettings[1][var5][var6] & 2) == 2) {
                           var57 = var4 - 1;
                        }

                        if(var57 >= 0) {
                           var64[var57].method3138(var5, var6);
                        }
                     }
                  }
               }
            }

            class61.field737 += (int)(Math.random() * 5.0D) - 2;
            if(class61.field737 < -8) {
               class61.field737 = -8;
            }

            if(class61.field737 > 8) {
               class61.field737 = 8;
            }

            class61.field730 += (int)(Math.random() * 5.0D) - 2;
            if(class61.field730 < -16) {
               class61.field730 = -16;
            }

            if(class61.field730 > 16) {
               class61.field730 = 16;
            }

            int var48;
            for(var4 = 0; var4 < 4; ++var4) {
               byte[][] var62 = class61.field738[var4];
               var11 = (int)Math.sqrt(5100.0D);
               var58 = var11 * 768 >> 8;

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var15 = class61.tileHeights[var4][var14 + 1][var13] - class61.tileHeights[var4][var14 - 1][var13];
                     var16 = class61.tileHeights[var4][var14][var13 + 1] - class61.tileHeights[var4][var14][var13 - 1];
                     var17 = (int)Math.sqrt((double)(var16 * var16 + var15 * var15 + 65536));
                     var18 = (var15 << 8) / var17;
                     var48 = 65536 / var17;
                     var20 = (var16 << 8) / var17;
                     var21 = (var20 * -50 + var18 * -50 + var48 * -10) / var58 + 96;
                     var22 = (var62[var14][var13 + 1] >> 3) + (var62[var14 - 1][var13] >> 2) + (var62[var14][var13 - 1] >> 2) + (var62[var14 + 1][var13] >> 3) + (var62[var14][var13] >> 1);
                     class218.field2686[var14][var13] = var21 - var22;
                  }
               }

               for(var13 = 0; var13 < 104; ++var13) {
                  class61.field729[var13] = 0;
                  RSCanvas.field632[var13] = 0;
                  Preferences.field1227[var13] = 0;
                  FloorUnderlayDefinition.field3399[var13] = 0;
                  class61.field728[var13] = 0;
               }

               for(var13 = -5; var13 < 109; ++var13) {
                  for(var14 = 0; var14 < 104; ++var14) {
                     var15 = var13 + 5;
                     if(var15 >= 0 && var15 < 104) {
                        var16 = class61.field726[var4][var15][var14] & 255;
                        if(var16 > 0) {
                           FloorUnderlayDefinition var66 = class2.method4(var16 - 1);
                           class61.field729[var14] += var66.hue;
                           RSCanvas.field632[var14] += var66.saturation;
                           Preferences.field1227[var14] += var66.lightness;
                           FloorUnderlayDefinition.field3399[var14] += var66.hueMultiplier;
                           ++class61.field728[var14];
                        }
                     }

                     var16 = var13 - 5;
                     if(var16 >= 0 && var16 < 104) {
                        var17 = class61.field726[var4][var16][var14] & 255;
                        if(var17 > 0) {
                           FloorUnderlayDefinition var67 = class2.method4(var17 - 1);
                           class61.field729[var14] -= var67.hue;
                           RSCanvas.field632[var14] -= var67.saturation;
                           Preferences.field1227[var14] -= var67.lightness;
                           FloorUnderlayDefinition.field3399[var14] -= var67.hueMultiplier;
                           --class61.field728[var14];
                        }
                     }
                  }

                  if(var13 >= 1 && var13 < 103) {
                     var14 = 0;
                     var15 = 0;
                     var16 = 0;
                     var17 = 0;
                     var18 = 0;

                     for(var48 = -5; var48 < 109; ++var48) {
                        var20 = var48 + 5;
                        if(var20 >= 0 && var20 < 104) {
                           var14 += class61.field729[var20];
                           var15 += RSCanvas.field632[var20];
                           var16 += Preferences.field1227[var20];
                           var17 += FloorUnderlayDefinition.field3399[var20];
                           var18 += class61.field728[var20];
                        }

                        var21 = var48 - 5;
                        if(var21 >= 0 && var21 < 104) {
                           var14 -= class61.field729[var21];
                           var15 -= RSCanvas.field632[var21];
                           var16 -= Preferences.field1227[var21];
                           var17 -= FloorUnderlayDefinition.field3399[var21];
                           var18 -= class61.field728[var21];
                        }

                        if(var48 >= 1 && var48 < 103 && (!Client.lowMemory || (class61.tileSettings[0][var13][var48] & 2) != 0 || (class61.tileSettings[var4][var13][var48] & 16) == 0)) {
                           if(var4 < class61.field725) {
                              class61.field725 = var4;
                           }

                           var22 = class61.field726[var4][var13][var48] & 255;
                           var23 = class285.field3790[var4][var13][var48] & 255;
                           if(var22 > 0 || var23 > 0) {
                              var24 = class61.tileHeights[var4][var13][var48];
                              var25 = class61.tileHeights[var4][var13 + 1][var48];
                              var26 = class61.tileHeights[var4][var13 + 1][var48 + 1];
                              var27 = class61.tileHeights[var4][var13][var48 + 1];
                              var28 = class218.field2686[var13][var48];
                              var29 = class218.field2686[var13 + 1][var48];
                              int var53 = class218.field2686[var13 + 1][var48 + 1];
                              var31 = class218.field2686[var13][var48 + 1];
                              var32 = -1;
                              var33 = -1;
                              int var35;
                              int var54;
                              if(var22 > 0) {
                                 var54 = var14 * 256 / var17;
                                 var35 = var15 / var18;
                                 int var36 = var16 / var18;
                                 var32 = class44.method691(var54, var35, var36);
                                 var54 = var54 + class61.field737 & 255;
                                 var36 += class61.field730;
                                 if(var36 < 0) {
                                    var36 = 0;
                                 } else if(var36 > 255) {
                                    var36 = 255;
                                 }

                                 var33 = class44.method691(var54, var35, var36);
                              }

                              if(var4 > 0) {
                                 boolean var68 = true;
                                 if(var22 == 0 && class61.field727[var4][var13][var48] != 0) {
                                    var68 = false;
                                 }

                                 if(var23 > 0 && !class82.method1733(var23 - 1).isHidden) {
                                    var68 = false;
                                 }

                                 if(var68 && var25 == var24 && var26 == var24 && var24 == var27) {
                                    ItemLayer.field1710[var4][var13][var48] |= 2340;
                                 }
                              }

                              var54 = 0;
                              if(var33 != -1) {
                                 var54 = Graphics3D.colorPalette[Parameters.method5097(var33, 96)];
                              }

                              if(var23 == 0) {
                                 var55.addTile(var4, var13, var48, 0, 0, -1, var24, var25, var26, var27, Parameters.method5097(var32, var28), Parameters.method5097(var32, var29), Parameters.method5097(var32, var53), Parameters.method5097(var32, var31), 0, 0, 0, 0, var54, 0);
                              } else {
                                 var35 = class61.field727[var4][var13][var48] + 1;
                                 byte var61 = class37.field490[var4][var13][var48];
                                 Overlay var37 = class82.method1733(var23 - 1);
                                 int var38 = var37.texture;
                                 int var39;
                                 int var40;
                                 int var41;
                                 int var42;
                                 if(var38 >= 0) {
                                    var40 = Graphics3D.textureLoader.getAverageTextureRGB(var38);
                                    var39 = -1;
                                 } else if(var37.color == 16711935) {
                                    var39 = -2;
                                    var38 = -1;
                                    var40 = -2;
                                 } else {
                                    var39 = class44.method691(var37.hue, var37.saturation, var37.lightness);
                                    var41 = var37.hue + class61.field737 & 255;
                                    var42 = var37.lightness + class61.field730;
                                    if(var42 < 0) {
                                       var42 = 0;
                                    } else if(var42 > 255) {
                                       var42 = 255;
                                    }

                                    var40 = class44.method691(var41, var37.saturation, var42);
                                 }

                                 var41 = 0;
                                 if(var40 != -2) {
                                    var41 = Graphics3D.colorPalette[class41.adjustHSLListness0(var40, 96)];
                                 }

                                 if(var37.otherRgbColor != -1) {
                                    var42 = var37.otherHue + class61.field737 & 255;
                                    int var43 = var37.otherLightness + class61.field730;
                                    if(var43 < 0) {
                                       var43 = 0;
                                    } else if(var43 > 255) {
                                       var43 = 255;
                                    }

                                    var40 = class44.method691(var42, var37.otherSaturation, var43);
                                    var41 = Graphics3D.colorPalette[class41.adjustHSLListness0(var40, 96)];
                                 }

                                 var55.addTile(var4, var13, var48, var35, var61, var38, var24, var25, var26, var27, Parameters.method5097(var32, var28), Parameters.method5097(var32, var29), Parameters.method5097(var32, var53), Parameters.method5097(var32, var31), class41.adjustHSLListness0(var39, var28), class41.adjustHSLListness0(var39, var29), class41.adjustHSLListness0(var39, var53), class41.adjustHSLListness0(var39, var31), var54, var41);
                              }
                           }
                        }
                     }
                  }
               }

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     if((class61.tileSettings[var4][var14][var13] & 8) != 0) {
                        var48 = 0;
                     } else if(var4 > 0 && (class61.tileSettings[1][var14][var13] & 2) != 0) {
                        var48 = var4 - 1;
                     } else {
                        var48 = var4;
                     }

                     var55.setPhysicalLevel(var4, var14, var13, var48);
                  }
               }

               class61.field726[var4] = null;
               class285.field3790[var4] = null;
               class61.field727[var4] = null;
               class37.field490[var4] = null;
               class61.field738[var4] = null;
            }

            var55.applyLighting(-50, -10, -50);

            for(var4 = 0; var4 < 104; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  if((class61.tileSettings[1][var4][var5] & 2) == 2) {
                     var55.setBridge(var4, var5);
                  }
               }
            }

            var4 = 1;
            var5 = 2;
            var6 = 4;

            for(var57 = 0; var57 < 4; ++var57) {
               if(var57 > 0) {
                  var4 <<= 3;
                  var5 <<= 3;
                  var6 <<= 3;
               }

               for(var47 = 0; var47 <= var57; ++var47) {
                  for(var9 = 0; var9 <= 104; ++var9) {
                     for(var10 = 0; var10 <= 104; ++var10) {
                        short var60;
                        if((ItemLayer.field1710[var47][var10][var9] & var4) != 0) {
                           var11 = var9;
                           var58 = var9;
                           var13 = var47;

                           for(var14 = var47; var11 > 0 && (ItemLayer.field1710[var47][var10][var11 - 1] & var4) != 0; --var11) {
                              ;
                           }

                           while(var58 < 104 && (ItemLayer.field1710[var47][var10][var58 + 1] & var4) != 0) {
                              ++var58;
                           }

                           label878:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var58; ++var15) {
                                 if((ItemLayer.field1710[var13 - 1][var10][var15] & var4) == 0) {
                                    break label878;
                                 }
                              }

                              --var13;
                           }

                           label867:
                           while(var14 < var57) {
                              for(var15 = var11; var15 <= var58; ++var15) {
                                 if((ItemLayer.field1710[var14 + 1][var10][var15] & var4) == 0) {
                                    break label867;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var58 - var11 + 1) * (var14 + 1 - var13);
                           if(var15 >= 8) {
                              var60 = 240;
                              var17 = class61.tileHeights[var14][var10][var11] - var60;
                              var18 = class61.tileHeights[var13][var10][var11];
                              Region.addOcclude(var57, 1, var10 * 128, var10 * 128, var11 * 128, var58 * 128 + 128, var17, var18);

                              for(var48 = var13; var48 <= var14; ++var48) {
                                 for(var20 = var11; var20 <= var58; ++var20) {
                                    ItemLayer.field1710[var48][var10][var20] &= ~var4;
                                 }
                              }
                           }
                        }

                        if((ItemLayer.field1710[var47][var10][var9] & var5) != 0) {
                           var11 = var10;
                           var58 = var10;
                           var13 = var47;

                           for(var14 = var47; var11 > 0 && (ItemLayer.field1710[var47][var11 - 1][var9] & var5) != 0; --var11) {
                              ;
                           }

                           while(var58 < 104 && (ItemLayer.field1710[var47][var58 + 1][var9] & var5) != 0) {
                              ++var58;
                           }

                           label931:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var58; ++var15) {
                                 if((ItemLayer.field1710[var13 - 1][var15][var9] & var5) == 0) {
                                    break label931;
                                 }
                              }

                              --var13;
                           }

                           label920:
                           while(var14 < var57) {
                              for(var15 = var11; var15 <= var58; ++var15) {
                                 if((ItemLayer.field1710[var14 + 1][var15][var9] & var5) == 0) {
                                    break label920;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var14 + 1 - var13) * (var58 - var11 + 1);
                           if(var15 >= 8) {
                              var60 = 240;
                              var17 = class61.tileHeights[var14][var11][var9] - var60;
                              var18 = class61.tileHeights[var13][var11][var9];
                              Region.addOcclude(var57, 2, var11 * 128, var58 * 128 + 128, var9 * 128, var9 * 128, var17, var18);

                              for(var48 = var13; var48 <= var14; ++var48) {
                                 for(var20 = var11; var20 <= var58; ++var20) {
                                    ItemLayer.field1710[var48][var20][var9] &= ~var5;
                                 }
                              }
                           }
                        }

                        if((ItemLayer.field1710[var47][var10][var9] & var6) != 0) {
                           var11 = var10;
                           var58 = var10;
                           var13 = var9;

                           for(var14 = var9; var13 > 0 && (ItemLayer.field1710[var47][var10][var13 - 1] & var6) != 0; --var13) {
                              ;
                           }

                           while(var14 < 104 && (ItemLayer.field1710[var47][var10][var14 + 1] & var6) != 0) {
                              ++var14;
                           }

                           label984:
                           while(var11 > 0) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((ItemLayer.field1710[var47][var11 - 1][var15] & var6) == 0) {
                                    break label984;
                                 }
                              }

                              --var11;
                           }

                           label973:
                           while(var58 < 104) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((ItemLayer.field1710[var47][var58 + 1][var15] & var6) == 0) {
                                    break label973;
                                 }
                              }

                              ++var58;
                           }

                           if((var58 - var11 + 1) * (var14 - var13 + 1) >= 4) {
                              var15 = class61.tileHeights[var47][var11][var13];
                              Region.addOcclude(var57, 4, var11 * 128, var58 * 128 + 128, var13 * 128, var14 * 128 + 128, var15, var15);

                              for(var16 = var11; var16 <= var58; ++var16) {
                                 for(var17 = var13; var17 <= var14; ++var17) {
                                    ItemLayer.field1710[var47][var16][var17] &= ~var6;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class274.flush(true);
            var4 = class61.field725;
            if(var4 > Ignore.plane) {
               var4 = Ignore.plane;
            }

            if(var4 < Ignore.plane - 1) {
               var4 = Ignore.plane - 1;
            }

            if(Client.lowMemory) {
               class56.region.setup(class61.field725);
            } else {
               class56.region.setup(0);
            }

            for(var5 = 0; var5 < 104; ++var5) {
               for(var6 = 0; var6 < 104; ++var6) {
                  class27.groundItemSpawned(var5, var6);
               }
            }

            class90.method1801();

            for(PendingSpawn var63 = (PendingSpawn)Client.pendingSpawns.getFront(); var63 != null; var63 = (PendingSpawn)Client.pendingSpawns.getNext()) {
               if(var63.hitpoints == -1) {
                  var63.delay = 0;
                  Coordinates.method4109(var63);
               } else {
                  var63.unlink();
               }
            }

            ObjectComposition.field3490.reset();
            PacketNode var65;
            if(class9.clientInstance.method924()) {
               var65 = Actor.method1628(ClientPacket.field2312, Client.field952.field1478);
               var65.packetBuffer.putInt(1057001181);
               Client.field952.method1951(var65);
            }

            if(!Client.isDynamicRegion) {
               var5 = (class231.field2918 - 6) / 8;
               var6 = (class231.field2918 + 6) / 8;
               var57 = (class91.field1367 - 6) / 8;
               var47 = (class91.field1367 + 6) / 8;

               for(var9 = var5 - 1; var9 <= var6 + 1; ++var9) {
                  for(var10 = var57 - 1; var10 <= var47 + 1; ++var10) {
                     if(var9 < var5 || var9 > var6 || var10 < var57 || var10 > var47) {
                        class56.indexMaps.method4301("m" + var9 + "_" + var10);
                        class56.indexMaps.method4301("l" + var9 + "_" + var10);
                     }
                  }
               }
            }

            class287.setGameState(30);
            class90.method1801();
            class44.method689();
            var65 = Actor.method1628(ClientPacket.field2387, Client.field952.field1478);
            Client.field952.method1951(var65);
            GameEngine.timer.vmethod3096();

            for(var6 = 0; var6 < 32; ++var6) {
               GameEngine.field669[var6] = 0L;
            }

            for(var6 = 0; var6 < 32; ++var6) {
               GameEngine.field671[var6] = 0L;
            }

            class9.field249 = 0;
         }
      }
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-121753652"
   )
   static final void method1934(int var0) {
      class35.method542();

      for(class81 var1 = (class81)class81.field1250.getFront(); var1 != null; var1 = (class81)class81.field1250.getNext()) {
         if(var1.field1251 != null) {
            var1.method1689();
         }
      }

      int var4 = ClanMember.method1228(var0).configType;
      if(var4 != 0) {
         int var2 = class218.widgetSettings[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.9D);
            }

            if(var2 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.8D);
            }

            if(var2 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.7D);
            }

            if(var2 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var4 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != Client.field1059) {
               if(Client.field1059 == 0 && Client.field1026 != -1) {
                  class182.method3518(class21.indexTrack1, Client.field1026, 0, var3, false);
                  Client.field1088 = false;
               } else if(var3 == 0) {
                  ItemLayer.method2521();
                  Client.field1088 = false;
               } else if(class210.field2594 != 0) {
                  class37.field485 = var3;
               } else {
                  class210.field2596.method3854(var3);
               }

               Client.field1059 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field1089 = 127;
            }

            if(var2 == 1) {
               Client.field1089 = 96;
            }

            if(var2 == 2) {
               Client.field1089 = 64;
            }

            if(var2 == 3) {
               Client.field1089 = 32;
            }

            if(var2 == 4) {
               Client.field1089 = 0;
            }
         }

         if(var4 == 5) {
            Client.field986 = var2;
         }

         if(var4 == 6) {
            Client.field1011 = var2;
         }

         if(var4 == 9) {
            Client.field1119 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field1067 = 127;
            }

            if(var2 == 1) {
               Client.field1067 = 96;
            }

            if(var2 == 2) {
               Client.field1067 = 64;
            }

            if(var2 == 3) {
               Client.field1067 = 32;
            }

            if(var2 == 4) {
               Client.field1067 = 0;
            }
         }

         if(var4 == 17) {
            Client.field878 = var2 & 65535;
         }

         class90[] var5;
         if(var4 == 18) {
            var5 = new class90[]{class90.field1327, class90.field1326, class90.field1325, class90.field1328};
            Client.field922 = (class90)class47.forOrdinal(var5, var2);
            if(Client.field922 == null) {
               Client.field922 = class90.field1328;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field978 = -1;
            } else {
               Client.field978 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            var5 = new class90[]{class90.field1327, class90.field1326, class90.field1325, class90.field1328};
            Client.field941 = (class90)class47.forOrdinal(var5, var2);
            if(Client.field941 == null) {
               Client.field941 = class90.field1328;
            }
         }

      }
   }
}
