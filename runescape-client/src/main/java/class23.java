import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class23 {
   @ObfuscatedName("c")
   static String[] field327;
   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   static IndexData field326;
   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgd;B)V",
      garbageValue = "18"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = class275.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field834 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class13.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - ClanMember.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      class28.plane = var2.field835 = var4;
      if(class94.field1408[var1] != null) {
         var2.decodeApperance(class94.field1408[var1]);
      }

      class94.playerIndexesCount = 0;
      class94.playerIndices[++class94.playerIndexesCount - 1] = var1;
      class94.field1397[var1] = 0;
      class94.field1402 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class94.field1404[var7] = (var10 << 14) + var11 + (var9 << 28);
            class94.field1395[var7] = 0;
            class94.field1409[var7] = -1;
            class94.field1403[++class94.field1402 - 1] = var7;
            class94.field1397[var7] = 0;
         }
      }

      var0.byteAccess();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lij;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "102371072"
   )
   public static void method163(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.getFile(var1);
      int var6 = var0.getChild(var5, var2);
      class226.method4079(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;B)Ljava/lang/String;",
      garbageValue = "9"
   )
   static String method165(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class153) {
         class153 var2 = (class153)var0;
         var1 = var2.field2119 + " | ";
         var0 = var2.field2122;
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1711917877"
   )
   public static int method168(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-523469835"
   )
   static final void method167() {
      if(!class133.field1908) {
         int var0 = Region.pitchSin;
         int var1 = Region.pitchCos;
         int var2 = Region.yawSin;
         int var3 = Region.yawCos;
         byte var4 = 50;
         short var5 = 3500;
         int var6 = (class133.field1900 - Graphics3D.centerX) * var4 / Graphics3D.field1926;
         int var7 = (class133.field1906 - Graphics3D.centerY) * var4 / Graphics3D.field1926;
         int var8 = (class133.field1900 - Graphics3D.centerX) * var5 / Graphics3D.field1926;
         int var9 = (class133.field1906 - Graphics3D.centerY) * var5 / Graphics3D.field1926;
         int var10 = Graphics3D.method2623(var7, var4, var1, var0);
         int var11 = Graphics3D.method2624(var7, var4, var1, var0);
         var7 = var10;
         var10 = Graphics3D.method2623(var9, var5, var1, var0);
         int var12 = Graphics3D.method2624(var9, var5, var1, var0);
         var9 = var10;
         var10 = Graphics3D.method2609(var6, var11, var3, var2);
         var11 = Graphics3D.method2667(var6, var11, var3, var2);
         var6 = var10;
         var10 = Graphics3D.method2609(var8, var12, var3, var2);
         var12 = Graphics3D.method2667(var8, var12, var3, var2);
         class133.field1904 = (var10 + var6) / 2;
         Item.field1392 = (var9 + var7) / 2;
         class133.field1905 = (var11 + var12) / 2;
         SoundTask.field1573 = (var10 - var6) / 2;
         CombatInfo1.field1208 = (var9 - var7) / 2;
         class133.field1901 = (var12 - var11) / 2;
         class51.field611 = Math.abs(SoundTask.field1573);
         class22.field317 = Math.abs(CombatInfo1.field1208);
         ClanMember.field854 = Math.abs(class133.field1901);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Leo;[Lfy;I)V",
      garbageValue = "1361180709"
   )
   static final void method164(Region var0, CollisionData[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class61.tileSettings[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class61.tileSettings[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method3045(var3, var4);
                  }
               }
            }
         }
      }

      class61.field715 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field715 < -8) {
         class61.field715 = -8;
      }

      if(class61.field715 > 8) {
         class61.field715 = 8;
      }

      class61.field716 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field716 < -16) {
         class61.field716 = -16;
      }

      if(class61.field716 > 16) {
         class61.field716 = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var42 = class175.field2440[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class61.tileHeights[var2][var12 + 1][var11] - class61.tileHeights[var2][var12 - 1][var11];
               var14 = class61.tileHeights[var2][var12][var11 + 1] - class61.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var13 * var13 + var14 * var14 + 65536));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var16 * -50 + var18 * -50 + var17 * -10) / var10 + 96;
               var20 = (var42[var12][var11 + 1] >> 3) + (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11] >> 1);
               class61.field703[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class61.field706[var11] = 0;
            class61.field707[var11] = 0;
            class61.field719[var11] = 0;
            class47.field555[var11] = 0;
            FileOnDisk.field1680[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class233.field3204[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = class217.method3957(var14 - 1);
                     class61.field706[var12] += var43.hue;
                     class61.field707[var12] += var43.saturation;
                     class61.field719[var12] += var43.lightness;
                     class47.field555[var12] += var43.hueMultiplier;
                     ++FileOnDisk.field1680[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class233.field3204[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = class217.method3957(var15 - 1);
                     class61.field706[var12] -= var44.hue;
                     class61.field707[var12] -= var44.saturation;
                     class61.field719[var12] -= var44.lightness;
                     class47.field555[var12] -= var44.hueMultiplier;
                     --FileOnDisk.field1680[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = var17 + 5;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class61.field706[var18];
                     var13 += class61.field707[var18];
                     var14 += class61.field719[var18];
                     var15 += class47.field555[var18];
                     var16 += FileOnDisk.field1680[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class61.field706[var19];
                     var13 -= class61.field707[var19];
                     var14 -= class61.field719[var19];
                     var15 -= class47.field555[var19];
                     var16 -= FileOnDisk.field1680[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.lowMemory || (class61.tileSettings[0][var11][var17] & 2) != 0 || (class61.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class61.field705) {
                        class61.field705 = var2;
                     }

                     var20 = class233.field3204[var2][var11][var17] & 255;
                     int var21 = class37.field474[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class61.tileHeights[var2][var11][var17];
                        int var23 = class61.tileHeights[var2][var11 + 1][var17];
                        int var24 = class61.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class61.tileHeights[var2][var11][var17 + 1];
                        int var26 = class61.field703[var11][var17];
                        int var27 = class61.field703[var11 + 1][var17];
                        int var28 = class61.field703[var11 + 1][var17 + 1];
                        int var29 = class61.field703[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class19.method143(var32, var33, var34);
                           var32 = var32 + class61.field715 & 255;
                           var34 += class61.field716;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class19.method143(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var47 = true;
                           if(var20 == 0 && class61.field702[var2][var11][var17] != 0) {
                              var47 = false;
                           }

                           if(var21 > 0 && !ClientPacket.method3094(var21 - 1).isHidden) {
                              var47 = false;
                           }

                           if(var47 && var22 == var23 && var22 == var24 && var22 == var25) {
                              class27.field368[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = Graphics3D.colorPalette[class111.method2106(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class111.method2106(var30, var26), class111.method2106(var30, var27), class111.method2106(var30, var28), class111.method2106(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class61.field702[var2][var11][var17] + 1;
                           byte var48 = class19.field296[var2][var11][var17];
                           Overlay var35 = ClientPacket.method3094(var21 - 1);
                           int var36 = var35.texture;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = Graphics3D.textureLoader.getAverageTextureRGB(var36);
                              var37 = -1;
                           } else if(var35.color == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class19.method143(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class61.field715 & 255;
                              var40 = var35.lightness + class61.field716;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class19.method143(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = Graphics3D.colorPalette[class226.adjustHSLListness0(var38, 96)];
                           }

                           if(var35.otherRgbColor != -1) {
                              var40 = var35.otherHue + class61.field715 & 255;
                              int var41 = var35.otherLightness + class61.field716;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class19.method143(var40, var35.otherSaturation, var41);
                              var39 = Graphics3D.colorPalette[class226.adjustHSLListness0(var38, 96)];
                           }

                           var0.addTile(var2, var11, var17, var33, var48, var36, var22, var23, var24, var25, class111.method2106(var30, var26), class111.method2106(var30, var27), class111.method2106(var30, var28), class111.method2106(var30, var29), class226.adjustHSLListness0(var37, var26), class226.adjustHSLListness0(var37, var27), class226.adjustHSLListness0(var37, var28), class226.adjustHSLListness0(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               if((class61.tileSettings[var2][var12][var11] & 8) != 0) {
                  var17 = 0;
               } else if(var2 > 0 && (class61.tileSettings[1][var12][var11] & 2) != 0) {
                  var17 = var2 - 1;
               } else {
                  var17 = var2;
               }

               var0.setPhysicalLevel(var2, var12, var11, var17);
            }
         }

         class233.field3204[var2] = null;
         class37.field474[var2] = null;
         class61.field702[var2] = null;
         class19.field296[var2] = null;
         class175.field2440[var2] = null;
      }

      var0.applyLighting(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class61.tileSettings[1][var2][var3] & 2) == 2) {
               var0.setBridge(var2, var3);
            }
         }
      }

      var2 = 1;
      var3 = 2;
      var4 = 4;

      for(var5 = 0; var5 < 4; ++var5) {
         if(var5 > 0) {
            var2 <<= 3;
            var3 <<= 3;
            var4 <<= 3;
         }

         for(int var6 = 0; var6 <= var5; ++var6) {
            for(int var7 = 0; var7 <= 104; ++var7) {
               for(int var8 = 0; var8 <= 104; ++var8) {
                  short var46;
                  if((class27.field368[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class27.field368[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class27.field368[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label485:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class27.field368[var11 - 1][var8][var13] & var2) == 0) {
                              break label485;
                           }
                        }

                        --var11;
                     }

                     label474:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class27.field368[var12 + 1][var8][var13] & var2) == 0) {
                              break label474;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class61.tileHeights[var12][var8][var9] - var46;
                        var16 = class61.tileHeights[var11][var8][var9];
                        Region.addOcclude(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class27.field368[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class27.field368[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class27.field368[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class27.field368[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label538:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class27.field368[var11 - 1][var13][var7] & var3) == 0) {
                              break label538;
                           }
                        }

                        --var11;
                     }

                     label527:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class27.field368[var12 + 1][var13][var7] & var3) == 0) {
                              break label527;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class61.tileHeights[var12][var9][var7] - var46;
                        var16 = class61.tileHeights[var11][var9][var7];
                        Region.addOcclude(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class27.field368[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class27.field368[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class27.field368[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class27.field368[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label591:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class27.field368[var6][var9 - 1][var13] & var4) == 0) {
                              break label591;
                           }
                        }

                        --var9;
                     }

                     label580:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class27.field368[var6][var10 + 1][var13] & var4) == 0) {
                              break label580;
                           }
                        }

                        ++var10;
                     }

                     if((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
                        var13 = class61.tileHeights[var6][var9][var11];
                        Region.addOcclude(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class27.field368[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lcg;",
      garbageValue = "1762786697"
   )
   static World method170() {
      World.field1216 = 0;
      return class37.method478();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "-16"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }
}
