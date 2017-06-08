import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1481434579
   )
   int field870;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -681261707
   )
   @Export("team")
   int team;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1704806351
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 369628137
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("m")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1710657915
   )
   int field875;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1240889055
   )
   int field876;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1306707351
   )
   int field877;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 766479329
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2054658703
   )
   int field879;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 781775613
   )
   int field880;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 308955373
   )
   int field881;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1515969793
   )
   int field882;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1741178113
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("y")
   @Export("model")
   Model model;
   @ObfuscatedName("p")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 495784291
   )
   int field886;
   @ObfuscatedName("n")
   @Export("name")
   String name;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1971059043
   )
   int field888;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 598522001
   )
   int field889;
   @ObfuscatedName("l")
   boolean field890;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 496836127
   )
   int field891;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 453657821
   )
   int field892;
   @ObfuscatedName("d")
   boolean field893;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1023280789
   )
   int field894;
   @ObfuscatedName("t")
   boolean field895;
   @ObfuscatedName("cz")
   @Export("indexTextures")
   static IndexData indexTextures;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-70187083"
   )
   final void method1096(int var1, int var2, byte var3) {
      if(super.animation != -1 && class169.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1254 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.method1111();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var9 = this.method1111();
                  class163 var10 = class149.method2908(var1, var2);
                  CollisionData var11 = Client.collisionMaps[this.field891];
                  int[] var12 = Client.field1070;
                  int[] var13 = Client.field1196;
                  int var14 = 0;

                  label484:
                  while(true) {
                     int var15;
                     if(var14 >= 128) {
                        int var16;
                        int var17;
                        byte var19;
                        int var20;
                        int var21;
                        int var23;
                        int var25;
                        int var26;
                        int var27;
                        boolean var34;
                        int var36;
                        int var37;
                        int var39;
                        if(var9 == 1) {
                           var34 = class14.method105(var5, var6, var10, var11);
                        } else if(var9 == 2) {
                           var16 = var5;
                           var17 = var6;
                           byte var18 = 64;
                           var19 = 64;
                           var20 = var5 - var18;
                           var21 = var6 - var19;
                           class162.field2311[var18][var19] = 99;
                           class162.field2318[var18][var19] = 0;
                           byte var22 = 0;
                           var23 = 0;
                           class162.field2314[var22] = var5;
                           var39 = var22 + 1;
                           class162.field2312[var22] = var6;
                           int[][] var24 = var11.flags;

                           boolean var35;
                           while(true) {
                              if(var39 == var23) {
                                 class162.field2310 = var16;
                                 class2.field17 = var17;
                                 var35 = false;
                                 break;
                              }

                              var16 = class162.field2314[var23];
                              var17 = class162.field2312[var23];
                              var23 = var23 + 1 & 4095;
                              var36 = var16 - var20;
                              var37 = var17 - var21;
                              var25 = var16 - var11.x;
                              var26 = var17 - var11.y;
                              if(var10.vmethod3055(2, var16, var17, var11)) {
                                 class162.field2310 = var16;
                                 class2.field17 = var17;
                                 var35 = true;
                                 break;
                              }

                              var27 = class162.field2318[var36][var37] + 1;
                              if(var36 > 0 && class162.field2311[var36 - 1][var37] == 0 && (var24[var25 - 1][var26] & 19136782) == 0 && (var24[var25 - 1][var26 + 1] & 19136824) == 0) {
                                 class162.field2314[var39] = var16 - 1;
                                 class162.field2312[var39] = var17;
                                 var39 = var39 + 1 & 4095;
                                 class162.field2311[var36 - 1][var37] = 2;
                                 class162.field2318[var36 - 1][var37] = var27;
                              }

                              if(var36 < 126 && class162.field2311[var36 + 1][var37] == 0 && (var24[var25 + 2][var26] & 19136899) == 0 && (var24[var25 + 2][var26 + 1] & 19136992) == 0) {
                                 class162.field2314[var39] = var16 + 1;
                                 class162.field2312[var39] = var17;
                                 var39 = var39 + 1 & 4095;
                                 class162.field2311[var36 + 1][var37] = 8;
                                 class162.field2318[var36 + 1][var37] = var27;
                              }

                              if(var37 > 0 && class162.field2311[var36][var37 - 1] == 0 && (var24[var25][var26 - 1] & 19136782) == 0 && (var24[var25 + 1][var26 - 1] & 19136899) == 0) {
                                 class162.field2314[var39] = var16;
                                 class162.field2312[var39] = var17 - 1;
                                 var39 = var39 + 1 & 4095;
                                 class162.field2311[var36][var37 - 1] = 1;
                                 class162.field2318[var36][var37 - 1] = var27;
                              }

                              if(var37 < 126 && class162.field2311[var36][var37 + 1] == 0 && (var24[var25][var26 + 2] & 19136824) == 0 && (var24[var25 + 1][var26 + 2] & 19136992) == 0) {
                                 class162.field2314[var39] = var16;
                                 class162.field2312[var39] = var17 + 1;
                                 var39 = var39 + 1 & 4095;
                                 class162.field2311[var36][var37 + 1] = 4;
                                 class162.field2318[var36][var37 + 1] = var27;
                              }

                              if(var36 > 0 && var37 > 0 && class162.field2311[var36 - 1][var37 - 1] == 0 && (var24[var25 - 1][var26] & 19136830) == 0 && (var24[var25 - 1][var26 - 1] & 19136782) == 0 && (var24[var25][var26 - 1] & 19136911) == 0) {
                                 class162.field2314[var39] = var16 - 1;
                                 class162.field2312[var39] = var17 - 1;
                                 var39 = var39 + 1 & 4095;
                                 class162.field2311[var36 - 1][var37 - 1] = 3;
                                 class162.field2318[var36 - 1][var37 - 1] = var27;
                              }

                              if(var36 < 126 && var37 > 0 && class162.field2311[var36 + 1][var37 - 1] == 0 && (var24[var25 + 1][var26 - 1] & 19136911) == 0 && (var24[var25 + 2][var26 - 1] & 19136899) == 0 && (var24[var25 + 2][var26] & 19136995) == 0) {
                                 class162.field2314[var39] = var16 + 1;
                                 class162.field2312[var39] = var17 - 1;
                                 var39 = var39 + 1 & 4095;
                                 class162.field2311[var36 + 1][var37 - 1] = 9;
                                 class162.field2318[var36 + 1][var37 - 1] = var27;
                              }

                              if(var36 > 0 && var37 < 126 && class162.field2311[var36 - 1][var37 + 1] == 0 && (var24[var25 - 1][var26 + 1] & 19136830) == 0 && (var24[var25 - 1][var26 + 2] & 19136824) == 0 && (var24[var25][var26 + 2] & 19137016) == 0) {
                                 class162.field2314[var39] = var16 - 1;
                                 class162.field2312[var39] = var17 + 1;
                                 var39 = var39 + 1 & 4095;
                                 class162.field2311[var36 - 1][var37 + 1] = 6;
                                 class162.field2318[var36 - 1][var37 + 1] = var27;
                              }

                              if(var36 < 126 && var37 < 126 && class162.field2311[var36 + 1][var37 + 1] == 0 && (var24[var25 + 1][var26 + 2] & 19137016) == 0 && (var24[var25 + 2][var26 + 2] & 19136992) == 0 && (var24[var25 + 2][var26 + 1] & 19136995) == 0) {
                                 class162.field2314[var39] = var16 + 1;
                                 class162.field2312[var39] = var17 + 1;
                                 var39 = var39 + 1 & 4095;
                                 class162.field2311[var36 + 1][var37 + 1] = 12;
                                 class162.field2318[var36 + 1][var37 + 1] = var27;
                              }
                           }

                           var34 = var35;
                        } else {
                           var34 = class215.method4008(var5, var6, var9, var10, var11);
                        }

                        int var8;
                        label507: {
                           var15 = var5 - 64;
                           var16 = var6 - 64;
                           var17 = class162.field2310;
                           var36 = class2.field17;
                           if(!var34) {
                              var37 = Integer.MAX_VALUE;
                              var20 = Integer.MAX_VALUE;
                              byte var38 = 10;
                              var39 = var10.field2319;
                              var23 = var10.field2320;
                              int var33 = var10.field2321;
                              var25 = var10.field2324;

                              for(var26 = var39 - var38; var26 <= var39 + var38; ++var26) {
                                 for(var27 = var23 - var38; var27 <= var38 + var23; ++var27) {
                                    int var28 = var26 - var15;
                                    int var29 = var27 - var16;
                                    if(var28 >= 0 && var29 >= 0 && var28 < 128 && var29 < 128 && class162.field2318[var28][var29] < 100) {
                                       int var30 = 0;
                                       if(var26 < var39) {
                                          var30 = var39 - var26;
                                       } else if(var26 > var33 + var39 - 1) {
                                          var30 = var26 - (var39 + var33 - 1);
                                       }

                                       int var31 = 0;
                                       if(var27 < var23) {
                                          var31 = var23 - var27;
                                       } else if(var27 > var23 + var25 - 1) {
                                          var31 = var27 - (var25 + var23 - 1);
                                       }

                                       int var32 = var30 * var30 + var31 * var31;
                                       if(var32 < var37 || var32 == var37 && class162.field2318[var28][var29] < var20) {
                                          var37 = var32;
                                          var20 = class162.field2318[var28][var29];
                                          var17 = var26;
                                          var36 = var27;
                                       }
                                    }
                                 }
                              }

                              if(var37 == Integer.MAX_VALUE) {
                                 var8 = -1;
                                 break label507;
                              }
                           }

                           if(var5 == var17 && var36 == var6) {
                              var8 = 0;
                           } else {
                              var19 = 0;
                              class162.field2314[var19] = var17;
                              var37 = var19 + 1;
                              class162.field2312[var19] = var36;

                              for(var20 = var21 = class162.field2311[var17 - var15][var36 - var16]; var5 != var17 || var6 != var36; var20 = class162.field2311[var17 - var15][var36 - var16]) {
                                 if(var21 != var20) {
                                    var21 = var20;
                                    class162.field2314[var37] = var17;
                                    class162.field2312[var37++] = var36;
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
                                 var12[var39] = class162.field2314[var37];
                                 var13[var39++] = class162.field2312[var37];
                                 if(var39 >= var12.length) {
                                    break;
                                 }
                              }

                              var8 = var39;
                           }
                        }

                        var14 = var8;
                        if(var8 < 1) {
                           break;
                        }

                        var15 = 0;

                        while(true) {
                           if(var15 >= var14 - 1) {
                              break label484;
                           }

                           var4.method1103(Client.field1070[var15], Client.field1196[var15], (byte)2);
                           ++var15;
                        }
                     }

                     for(var15 = 0; var15 < 128; ++var15) {
                        class162.field2311[var14][var15] = 0;
                        class162.field2318[var14][var15] = 99999999;
                     }

                     ++var14;
                  }
               }
            }

            this.method1103(var1, var2, var3);
         } else {
            this.method1123(var1, var2);
         }
      } else {
         this.method1123(var1, var2);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)LModel;",
      garbageValue = "-1617"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class169.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field895 || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:class169.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3978(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2515();
            super.field1276 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field895 && super.graphic != -1 && super.field1264 != -1) {
               var4 = class100.method1840(super.graphic).method4358(super.field1264);
               if(var4 != null) {
                  var4.method2519(0, -super.field1279, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field895 && this.model != null) {
               if(Client.gameCycle >= this.field879) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field879) {
                  var4 = this.model;
                  var4.method2519(this.field880 - super.x, this.field881 - this.field877, this.field882 - super.y);
                  if(super.field1252 == 512) {
                     var4.method2522();
                     var4.method2522();
                     var4.method2522();
                  } else if(super.field1252 == 1024) {
                     var4.method2522();
                     var4.method2522();
                  } else if(super.field1252 == 1536) {
                     var4.method2522();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field1252 == 512) {
                     var4.method2522();
                  } else if(super.field1252 == 1024) {
                     var4.method2522();
                     var4.method2522();
                  } else if(super.field1252 == 1536) {
                     var4.method2522();
                     var4.method2522();
                     var4.method2522();
                  }

                  var4.method2519(super.x - this.field880, this.field877 - this.field881, super.y - this.field882);
               }
            }

            var3.field1957 = true;
            return var3;
         }
      }
   }

   Player() {
      this.skullIcon = -1;
      this.overheadIcon = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field876 = 0;
      this.totalLevel = 0;
      this.field879 = 0;
      this.field895 = false;
      this.team = 0;
      this.field890 = false;
      this.field893 = false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "-626876095"
   )
   static File method1100(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      XItemContainer.field767 = new File(class2.field14, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      Buffer var8;
      File var23;
      if(XItemContainer.field767.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(XItemContainer.field767, "rw", 10000L);

            int var9;
            for(var8 = new Buffer((int)var7.method2370()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.method2369(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.readUnsignedByte();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.readUnsignedByte();
            }

            if(var9 <= 2) {
               var4 = var8.method3263();
               if(var10 == 1) {
                  var5 = var8.method3263();
               }
            } else {
               var4 = var8.method3321();
               if(var10 == 1) {
                  var5 = var8.method3321();
               }
            }

            var7.method2368();
         } catch (IOException var21) {
            var21.printStackTrace();
         }

         if(var4 != null) {
            var23 = new File(var4);
            if(!var23.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var23 = new File(var4, "test.dat");
            if(!WidgetNode.method1066(var23, true)) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label138:
         for(int var15 = 0; var15 < class155.field2260.length; ++var15) {
            for(int var16 = 0; var16 < class35.field499.length; ++var16) {
               File var17 = new File(class35.field499[var16] + class155.field2260[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && WidgetNode.method1066(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label138;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class2.field14 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      File var22;
      if(var5 != null) {
         var22 = new File(var5);
         var23 = new File(var4);

         try {
            File[] var24 = var22.listFiles();
            File[] var18 = var24;

            for(int var11 = 0; var11 < var18.length; ++var11) {
               File var12 = var18[var11];
               File var13 = new File(var23, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var20) {
            var20.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         var22 = new File(var4);
         var8 = null;

         try {
            FileOnDisk var25 = new FileOnDisk(XItemContainer.field767, "rw", 10000L);
            Buffer var26 = new Buffer(500);
            var26.putByte(3);
            var26.putByte(var8 != null?1:0);
            var26.method3152(var22.getPath());
            if(var8 != null) {
               var26.method3152("");
            }

            var25.method2366(var26.payload, 0, var26.offset);
            var25.method2368();
         } catch (IOException var19) {
            var19.printStackTrace();
         }
      }

      return new File(var4);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-41"
   )
   final boolean vmethod1669() {
      return this.composition != null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1264721382"
   )
   final void method1103(int var1, int var2, byte var3) {
      if(super.field1280 < 9) {
         ++super.field1280;
      }

      for(int var4 = super.field1280; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field1283[var4] = super.field1283[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field1283[0] = var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "2120829077"
   )
   final void method1109(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.readUnsignedByte();
      this.skullIcon = var1.readByte();
      this.overheadIcon = var1.readByte();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.readUnsignedByte();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.readUnsignedByte();
            var4[var5] = (var6 << 8) + var7;
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.readUnsignedShort();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = ItemComposition.getItemDefinition(var4[var5] - 512).field3550;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= PlayerComposition.field2621[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field1232 = var1.readUnsignedShort();
      if(super.field1232 == '\uffff') {
         super.field1232 = -1;
      }

      super.field1248 = super.field1232;
      super.field1234 = var1.readUnsignedShort();
      if(super.field1234 == '\uffff') {
         super.field1234 = -1;
      }

      super.field1235 = var1.readUnsignedShort();
      if(super.field1235 == '\uffff') {
         super.field1235 = -1;
      }

      super.field1265 = var1.readUnsignedShort();
      if(super.field1265 == '\uffff') {
         super.field1265 = -1;
      }

      super.field1237 = var1.readUnsignedShort();
      if(super.field1237 == '\uffff') {
         super.field1237 = -1;
      }

      super.field1238 = var1.readUnsignedShort();
      if(super.field1238 == '\uffff') {
         super.field1238 = -1;
      }

      this.name = var1.readString();
      if(this == class168.localPlayer) {
         class152.field2229 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.field876 = var1.readUnsignedShort();
      this.field890 = var1.readUnsignedByte() == 1;
      if(Client.field915 == 0 && Client.field1132 >= 2) {
         this.field890 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3991(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2063037693"
   )
   int method1111() {
      return this.composition != null && this.composition.field2631 != -1?class217.getNpcDefinition(this.composition.field2631).field3577:1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1634494908"
   )
   static boolean method1116(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1141960141"
   )
   void method1123(int var1, int var2) {
      super.field1280 = 0;
      super.field1285 = 0;
      super.field1258 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method1111();
      super.x = super.pathX[0] * 128 + var3 * 64;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }
}
