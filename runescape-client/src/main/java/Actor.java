import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1204403297
   )
   int field801 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1929217361
   )
   int field802 = -1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1672533163
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 723918725
   )
   @Export("graphic")
   int graphic = -1;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1813263359
   )
   int field805 = 1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 365849769
   )
   int field806 = -1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 2055691129
   )
   int field807 = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1235530899
   )
   int field808 = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1476780691
   )
   @Export("x")
   int x;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 2068118977
   )
   int field810 = 0;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1751716439
   )
   int field811 = 0;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1963280841
   )
   int field812 = -1;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 887576627
   )
   int field813 = -1;
   @ObfuscatedName("ad")
   @Export("overhead")
   String overhead = null;
   @ObfuscatedName("aj")
   boolean field815;
   @ObfuscatedName("ai")
   @Export("inSequence")
   boolean inSequence = false;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -280260643
   )
   int field817 = 100;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -349170937
   )
   int field818 = 0;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1997139499
   )
   int field819 = 0;
   @ObfuscatedName("aw")
   byte field820 = 0;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 1263249321
   )
   int field821 = 0;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -228343261
   )
   @Export("interacting")
   int interacting = -1;
   @ObfuscatedName("aq")
   int[] field823 = new int[4];
   @ObfuscatedName("af")
   int[] field824 = new int[4];
   @ObfuscatedName("bp")
   int[] field825 = new int[4];
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1301228225
   )
   @Export("poseAnimation")
   int poseAnimation = -1;
   @ObfuscatedName("bg")
   boolean field828 = false;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -660620493
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation = -1;
   @ObfuscatedName("cx")
   @Export("pathY")
   int[] pathY = new int[10];
   @ObfuscatedName("bh")
   class205 field831 = new class205();
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1483190473
   )
   int field832 = 0;
   @ObfuscatedName("as")
   int[] field833 = new int[4];
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -135694867
   )
   @Export("actionFrame")
   int actionFrame = 0;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -530243271
   )
   int field835 = 0;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 632968889
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable = 0;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1694614299
   )
   int field837 = 0;
   @ObfuscatedName("ak")
   int[] field838 = new int[4];
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 755371523
   )
   int field839;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1395103727
   )
   int field840 = 0;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1158979047
   )
   @Export("poseFrame")
   int poseFrame = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -281559585
   )
   @Export("y")
   int y;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 1710651651
   )
   int field843;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -356442079
   )
   int field844;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 136041019
   )
   int field845;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -2077123333
   )
   int field846;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 618965331
   )
   int field847;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1084414271
   )
   int field848;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 2133373229
   )
   int field849;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1921987083
   )
   int field850 = -1;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 572639001
   )
   int field851 = 200;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1927472265
   )
   int field852;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 1085004809
   )
   int field853;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1710588847
   )
   int field854 = 32;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 1284937069
   )
   int field855 = 0;
   @ObfuscatedName("cb")
   @Export("pathX")
   int[] pathX = new int[10];
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -2018704019
   )
   @Export("animation")
   int animation = -1;
   @ObfuscatedName("ci")
   byte[] field858 = new byte[10];
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 739097621
   )
   int field859 = 0;
   @ObfuscatedName("ax")
   boolean field860 = false;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1795134029
   )
   int field861 = -1;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "909472363"
   )
   boolean vmethod767() {
      return false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "445049372"
   )
   final void method768() {
      this.field855 = 0;
      this.field821 = 0;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1678026546"
   )
   final void method770(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field823[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class51 var14 = class9.method119(var1);
         var10 = var14.field1093;
         var11 = var14.field1084;
      }

      int var12;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var12 = 0;
         if(var10 == 0) {
            var12 = this.field823[0];
         } else if(var10 == 1) {
            var12 = this.field833[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field823[var13] < var12) {
                  var9 = var13;
                  var12 = this.field823[var13];
               }
            } else if(var10 == 1 && this.field833[var13] < var12) {
               var9 = var13;
               var12 = this.field833[var13];
            }
         }

         if(var10 == 1 && var12 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field820 = 0;
         }

         for(var12 = 0; var12 < 4; ++var12) {
            byte var15 = this.field820;
            this.field820 = (byte)((this.field820 + 1) % 4);
            if(this.field823[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field838[var9] = var1;
         this.field833[var9] = var2;
         this.field824[var9] = var3;
         this.field825[var9] = var4;
         this.field823[var9] = var11 + var5 + var6;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1504064508"
   )
   final void method772(int var1) {
      class49 var2 = class24.method587(var1);

      for(class26 var3 = (class26)this.field831.method3850(); var3 != null; var3 = (class26)this.field831.method3852()) {
         if(var2 == var3.field622) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1998955240"
   )
   static final void method775() {
      class14.method174(false);
      Client.field322 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < Client.field551.length; ++var1) {
         if(Client.field327[var1] != -1 && null == Client.field551[var1]) {
            Client.field551[var1] = class24.field603.method3272(Client.field327[var1], 0);
            if(Client.field551[var1] == null) {
               var0 = false;
               ++Client.field322;
            }
         }

         if(class186.field2998[var1] != -1 && null == class132.field2091[var1]) {
            class132.field2091[var1] = class24.field603.method3309(class186.field2998[var1], 0, class26.xteaKeys[var1]);
            if(class132.field2091[var1] == null) {
               var0 = false;
               ++Client.field322;
            }
         }
      }

      if(!var0) {
         Client.field329 = 1;
      } else {
         Client.field324 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < Client.field551.length; ++var1) {
            byte[] var46 = class132.field2091[var1];
            if(null != var46) {
               var3 = 64 * (class9.mapRegions[var1] >> 8) - class23.baseX;
               var4 = 64 * (class9.mapRegions[var1] & 255) - class8.baseY;
               if(Client.field428) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= class169.method3247(var46, var3, var4);
            }
         }

         if(!var0) {
            Client.field329 = 2;
         } else {
            if(Client.field329 != 0) {
               class22.method555("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class12.method162();
            class117.method2418();
            class12.method162();
            class114.region.method1915();
            class12.method162();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method2360();
            }

            int var2;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var2 = 0; var2 < 104; ++var2) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class5.tileSettings[var1][var2][var3] = 0;
                  }
               }
            }

            class12.method162();
            class177.method3444();
            var1 = Client.field551.length;

            for(class24 var63 = (class24)class24.field590.method3808(); null != var63; var63 = (class24)class24.field590.method3810()) {
               if(var63.field598 != null) {
                  class75.field1389.method1144(var63.field598);
                  var63.field598 = null;
               }

               if(var63.field599 != null) {
                  class75.field1389.method1144(var63.field599);
                  var63.field599 = null;
               }
            }

            class24.field590.method3802();
            class14.method174(true);
            int var5;
            if(!Client.field428) {
               byte[] var48;
               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = 64 * (class9.mapRegions[var2] >> 8) - class23.baseX;
                  var4 = (class9.mapRegions[var2] & 255) * 64 - class8.baseY;
                  var48 = Client.field551[var2];
                  if(null != var48) {
                     class12.method162();
                     WidgetNode.method40(var48, var3, var4, class54.field1132 * 8 - 48, class53.field1122 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = (class9.mapRegions[var2] >> 8) * 64 - class23.baseX;
                  var4 = (class9.mapRegions[var2] & 255) * 64 - class8.baseY;
                  var48 = Client.field551[var2];
                  if(var48 == null && class53.field1122 < 800) {
                     class12.method162();
                     class77.method1612(var3, var4, 64, 64);
                  }
               }

               class14.method174(true);

               for(var2 = 0; var2 < var1; ++var2) {
                  byte[] var51 = class132.field2091[var2];
                  if(null != var51) {
                     var4 = (class9.mapRegions[var2] >> 8) * 64 - class23.baseX;
                     var5 = (class9.mapRegions[var2] & 255) * 64 - class8.baseY;
                     class12.method162();
                     class152.method3140(var51, var4, var5, class114.region, Client.collisionMaps);
                  }
               }
            }

            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
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
            if(Client.field428) {
               for(var2 = 0; var2 < 4; ++var2) {
                  class12.method162();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var58 = false;
                        var6 = Client.field330[var2][var3][var4];
                        if(var6 != -1) {
                           var7 = var6 >> 24 & 3;
                           var8 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = var10 / 8 + (var9 / 8 << 8);

                           for(var12 = 0; var12 < class9.mapRegions.length; ++var12) {
                              if(class9.mapRegions[var12] == var11 && null != Client.field551[var12]) {
                                 class112.method2389(Client.field551[var12], var2, var3 * 8, 8 * var4, var7, 8 * (var9 & 7), 8 * (var10 & 7), var8, Client.collisionMaps);
                                 var58 = true;
                                 break;
                              }
                           }
                        }

                        if(!var58) {
                           var7 = var2;
                           var8 = var3 * 8;
                           var9 = 8 * var4;

                           for(var10 = 0; var10 < 8; ++var10) {
                              for(var11 = 0; var11 < 8; ++var11) {
                                 class5.tileHeights[var7][var10 + var8][var11 + var9] = 0;
                              }
                           }

                           if(var8 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class5.tileHeights[var7][var8][var10 + var9] = class5.tileHeights[var7][var8 - 1][var9 + var10];
                              }
                           }

                           if(var9 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class5.tileHeights[var7][var8 + var10][var9] = class5.tileHeights[var7][var10 + var8][var9 - 1];
                              }
                           }

                           if(var8 > 0 && class5.tileHeights[var7][var8 - 1][var9] != 0) {
                              class5.tileHeights[var7][var8][var9] = class5.tileHeights[var7][var8 - 1][var9];
                           } else if(var9 > 0 && class5.tileHeights[var7][var8][var9 - 1] != 0) {
                              class5.tileHeights[var7][var8][var9] = class5.tileHeights[var7][var8][var9 - 1];
                           } else if(var8 > 0 && var9 > 0 && class5.tileHeights[var7][var8 - 1][var9 - 1] != 0) {
                              class5.tileHeights[var7][var8][var9] = class5.tileHeights[var7][var8 - 1][var9 - 1];
                           }
                        }
                     }
                  }
               }

               for(var2 = 0; var2 < 13; ++var2) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field330[0][var2][var3];
                     if(var4 == -1) {
                        class77.method1612(8 * var2, var3 * 8, 8, 8);
                     }
                  }
               }

               class14.method174(true);

               for(var2 = 0; var2 < 4; ++var2) {
                  class12.method162();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label1246:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field330[var2][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var7 = var5 >> 1 & 3;
                           var8 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = var9 / 8 + (var8 / 8 << 8);

                           for(var11 = 0; var11 < class9.mapRegions.length; ++var11) {
                              if(var10 == class9.mapRegions[var11] && null != class132.field2091[var11]) {
                                 byte[] var52 = class132.field2091[var11];
                                 var13 = 8 * var3;
                                 var14 = 8 * var4;
                                 var15 = 8 * (var8 & 7);
                                 var16 = (var9 & 7) * 8;
                                 Region var49 = class114.region;
                                 CollisionData[] var18 = Client.collisionMaps;
                                 Buffer var47 = new Buffer(var52);
                                 var20 = -1;

                                 while(true) {
                                    var21 = var47.method2654();
                                    if(var21 == 0) {
                                       continue label1246;
                                    }

                                    var20 += var21;
                                    var22 = 0;

                                    while(true) {
                                       var23 = var47.method2654();
                                       if(var23 == 0) {
                                          break;
                                       }

                                       var22 += var23 - 1;
                                       var24 = var22 & 63;
                                       var25 = var22 >> 6 & 63;
                                       var26 = var22 >> 12;
                                       var27 = var47.method2481();
                                       var28 = var27 >> 2;
                                       var29 = var27 & 3;
                                       if(var6 == var26 && var25 >= var15 && var25 < 8 + var15 && var24 >= var16 && var24 < var16 + 8) {
                                          ObjectComposition var30 = class40.getObjectDefinition(var20);
                                          var31 = var13 + class59.method1188(var25 & 7, var24 & 7, var7, var30.field923, var30.field924, var29);
                                          var32 = var14 + class12.method161(var25 & 7, var24 & 7, var7, var30.field923, var30.field924, var29);
                                          if(var31 > 0 && var32 > 0 && var31 < 103 && var32 < 103) {
                                             var33 = var2;
                                             if((class5.tileSettings[1][var31][var32] & 2) == 2) {
                                                var33 = var2 - 1;
                                             }

                                             CollisionData var54 = null;
                                             if(var33 >= 0) {
                                                var54 = var18[var33];
                                             }

                                             class51.method1032(var2, var31, var32, var20, var29 + var7 & 3, var28, var49, var54);
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

            class14.method174(true);
            class117.method2418();
            class12.method162();
            Region var64 = class114.region;
            CollisionData[] var67 = Client.collisionMaps;

            for(var4 = 0; var4 < 4; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  for(var6 = 0; var6 < 104; ++var6) {
                     if((class5.tileSettings[var4][var5][var6] & 1) == 1) {
                        var7 = var4;
                        if((class5.tileSettings[1][var5][var6] & 2) == 2) {
                           var7 = var4 - 1;
                        }

                        if(var7 >= 0) {
                           var67[var7].method2363(var5, var6);
                        }
                     }
                  }
               }
            }

            class5.field80 += (int)(Math.random() * 5.0D) - 2;
            if(class5.field80 < -8) {
               class5.field80 = -8;
            }

            if(class5.field80 > 8) {
               class5.field80 = 8;
            }

            class5.field81 += (int)(Math.random() * 5.0D) - 2;
            if(class5.field81 < -16) {
               class5.field81 = -16;
            }

            if(class5.field81 > 16) {
               class5.field81 = 16;
            }

            int var17;
            int var19;
            int var56;
            for(var4 = 0; var4 < 4; ++var4) {
               byte[][] var65 = class217.field3197[var4];
               var11 = (int)Math.sqrt(5100.0D);
               var12 = 768 * var11 >> 8;

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var15 = class5.tileHeights[var4][1 + var14][var13] - class5.tileHeights[var4][var14 - 1][var13];
                     var16 = class5.tileHeights[var4][var14][var13 + 1] - class5.tileHeights[var4][var14][var13 - 1];
                     var17 = (int)Math.sqrt((double)(var15 * var15 + 65536 + var16 * var16));
                     var56 = (var15 << 8) / var17;
                     var19 = 65536 / var17;
                     var20 = (var16 << 8) / var17;
                     var21 = (var20 * -50 + -50 * var56 + -10 * var19) / var12 + 96;
                     var22 = (var65[var14][var13] >> 1) + (var65[var14][1 + var13] >> 3) + (var65[var14][var13 - 1] >> 2) + (var65[var14 - 1][var13] >> 2) + (var65[1 + var14][var13] >> 3);
                     class11.field164[var14][var13] = var21 - var22;
                  }
               }

               for(var13 = 0; var13 < 104; ++var13) {
                  class5.field70[var13] = 0;
                  MessageNode.field776[var13] = 0;
                  class5.field65[var13] = 0;
                  class124.field2052[var13] = 0;
                  class5.field72[var13] = 0;
               }

               for(var13 = -5; var13 < 109; ++var13) {
                  for(var14 = 0; var14 < 104; ++var14) {
                     var15 = 5 + var13;
                     if(var15 >= 0 && var15 < 104) {
                        var16 = class220.field3213[var4][var15][var14] & 255;
                        if(var16 > 0) {
                           class43 var66 = class77.method1610(var16 - 1);
                           class5.field70[var14] += var66.field960;
                           MessageNode.field776[var14] += var66.field961;
                           class5.field65[var14] += var66.field963;
                           class124.field2052[var14] += var66.field958;
                           ++class5.field72[var14];
                        }
                     }

                     var16 = var13 - 5;
                     if(var16 >= 0 && var16 < 104) {
                        var17 = class220.field3213[var4][var16][var14] & 255;
                        if(var17 > 0) {
                           class43 var59 = class77.method1610(var17 - 1);
                           class5.field70[var14] -= var59.field960;
                           MessageNode.field776[var14] -= var59.field961;
                           class5.field65[var14] -= var59.field963;
                           class124.field2052[var14] -= var59.field958;
                           --class5.field72[var14];
                        }
                     }
                  }

                  if(var13 >= 1 && var13 < 103) {
                     var14 = 0;
                     var15 = 0;
                     var16 = 0;
                     var17 = 0;
                     var56 = 0;

                     for(var19 = -5; var19 < 109; ++var19) {
                        var20 = 5 + var19;
                        if(var20 >= 0 && var20 < 104) {
                           var14 += class5.field70[var20];
                           var15 += MessageNode.field776[var20];
                           var16 += class5.field65[var20];
                           var17 += class124.field2052[var20];
                           var56 += class5.field72[var20];
                        }

                        var21 = var19 - 5;
                        if(var21 >= 0 && var21 < 104) {
                           var14 -= class5.field70[var21];
                           var15 -= MessageNode.field776[var21];
                           var16 -= class5.field65[var21];
                           var17 -= class124.field2052[var21];
                           var56 -= class5.field72[var21];
                        }

                        if(var19 >= 1 && var19 < 103 && (!Client.field271 || (class5.tileSettings[0][var13][var19] & 2) != 0 || (class5.tileSettings[var4][var13][var19] & 16) == 0)) {
                           if(var4 < class5.field66) {
                              class5.field66 = var4;
                           }

                           var22 = class220.field3213[var4][var13][var19] & 255;
                           var23 = class5.field67[var4][var13][var19] & 255;
                           if(var22 > 0 || var23 > 0) {
                              var24 = class5.tileHeights[var4][var13][var19];
                              var25 = class5.tileHeights[var4][1 + var13][var19];
                              var26 = class5.tileHeights[var4][var13 + 1][var19 + 1];
                              var27 = class5.tileHeights[var4][var13][1 + var19];
                              var28 = class11.field164[var13][var19];
                              var29 = class11.field164[var13 + 1][var19];
                              int var55 = class11.field164[var13 + 1][1 + var19];
                              var31 = class11.field164[var13][var19 + 1];
                              var32 = -1;
                              var33 = -1;
                              int var34;
                              int var35;
                              int var36;
                              if(var22 > 0) {
                                 var34 = 256 * var14 / var17;
                                 var35 = var15 / var56;
                                 var36 = var16 / var56;
                                 var32 = World.method655(var34, var35, var36);
                                 var34 = var34 + class5.field80 & 255;
                                 var36 += class5.field81;
                                 if(var36 < 0) {
                                    var36 = 0;
                                 } else if(var36 > 255) {
                                    var36 = 255;
                                 }

                                 var33 = World.method655(var34, var35, var36);
                              }

                              class48 var37;
                              if(var4 > 0) {
                                 boolean var61 = true;
                                 if(var22 == 0 && class5.field69[var4][var13][var19] != 0) {
                                    var61 = false;
                                 }

                                 if(var23 > 0) {
                                    var36 = var23 - 1;
                                    var37 = (class48)class48.field1035.get((long)var36);
                                    class48 var57;
                                    if(null != var37) {
                                       var57 = var37;
                                    } else {
                                       byte[] var38 = class48.field1036.method3272(4, var36);
                                       var37 = new class48();
                                       if(var38 != null) {
                                          var37.method954(new Buffer(var38), var36);
                                       }

                                       var37.method953();
                                       class48.field1035.put(var37, (long)var36);
                                       var57 = var37;
                                    }

                                    if(!var57.field1031) {
                                       var61 = false;
                                    }
                                 }

                                 if(var61 && var25 == var24 && var24 == var26 && var27 == var24) {
                                    class16.field216[var4][var13][var19] |= 2340;
                                 }
                              }

                              var34 = 0;
                              if(var33 != -1) {
                                 var34 = class94.colorPalette[Ignore.method106(var33, 96)];
                              }

                              if(var23 == 0) {
                                 var64.method1973(var4, var13, var19, 0, 0, -1, var24, var25, var26, var27, Ignore.method106(var32, var28), Ignore.method106(var32, var29), Ignore.method106(var32, var55), Ignore.method106(var32, var31), 0, 0, 0, 0, var34, 0);
                              } else {
                                 var35 = 1 + class5.field69[var4][var13][var19];
                                 byte var62 = class62.field1261[var4][var13][var19];
                                 int var53 = var23 - 1;
                                 class48 var39 = (class48)class48.field1035.get((long)var53);
                                 if(var39 != null) {
                                    var37 = var39;
                                 } else {
                                    byte[] var40 = class48.field1036.method3272(4, var53);
                                    var39 = new class48();
                                    if(null != var40) {
                                       var39.method954(new Buffer(var40), var53);
                                    }

                                    var39.method953();
                                    class48.field1035.put(var39, (long)var53);
                                    var37 = var39;
                                 }

                                 int var50 = var37.field1032;
                                 int var41;
                                 int var42;
                                 int var43;
                                 int var44;
                                 if(var50 >= 0) {
                                    var42 = class94.field1625.vmethod2160(var50);
                                    var41 = -1;
                                 } else if(var37.field1034 == 16711935) {
                                    var41 = -2;
                                    var50 = -1;
                                    var42 = -2;
                                 } else {
                                    var41 = World.method655(var37.field1044, var37.field1038, var37.field1039);
                                    var43 = class5.field80 + var37.field1044 & 255;
                                    var44 = var37.field1039 + class5.field81;
                                    if(var44 < 0) {
                                       var44 = 0;
                                    } else if(var44 > 255) {
                                       var44 = 255;
                                    }

                                    var42 = World.method655(var43, var37.field1038, var44);
                                 }

                                 var43 = 0;
                                 if(var42 != -2) {
                                    var43 = class94.colorPalette[class144.method2979(var42, 96)];
                                 }

                                 if(var37.field1037 != -1) {
                                    var44 = class5.field80 + var37.field1040 & 255;
                                    int var45 = class5.field81 + var37.field1042;
                                    if(var45 < 0) {
                                       var45 = 0;
                                    } else if(var45 > 255) {
                                       var45 = 255;
                                    }

                                    var42 = World.method655(var44, var37.field1041, var45);
                                    var43 = class94.colorPalette[class144.method2979(var42, 96)];
                                 }

                                 var64.method1973(var4, var13, var19, var35, var62, var50, var24, var25, var26, var27, Ignore.method106(var32, var28), Ignore.method106(var32, var29), Ignore.method106(var32, var55), Ignore.method106(var32, var31), class144.method2979(var41, var28), class144.method2979(var41, var29), class144.method2979(var41, var55), class144.method2979(var41, var31), var34, var43);
                              }
                           }
                        }
                     }
                  }
               }

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var64.method1919(var4, var14, var13, class85.method1893(var4, var14, var13));
                  }
               }

               class220.field3213[var4] = null;
               class5.field67[var4] = null;
               class5.field69[var4] = null;
               class62.field1261[var4] = null;
               class217.field3197[var4] = null;
            }

            var64.method2047(-50, -10, -50);

            for(var4 = 0; var4 < 104; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  if((class5.tileSettings[1][var4][var5] & 2) == 2) {
                     var64.method1917(var4, var5);
                  }
               }
            }

            var4 = 1;
            var5 = 2;
            var6 = 4;

            for(var7 = 0; var7 < 4; ++var7) {
               if(var7 > 0) {
                  var4 <<= 3;
                  var5 <<= 3;
                  var6 <<= 3;
               }

               for(var8 = 0; var8 <= var7; ++var8) {
                  for(var9 = 0; var9 <= 104; ++var9) {
                     for(var10 = 0; var10 <= 104; ++var10) {
                        short var60;
                        if((class16.field216[var8][var10][var9] & var4) != 0) {
                           var11 = var9;
                           var12 = var9;
                           var13 = var8;

                           for(var14 = var8; var11 > 0 && (class16.field216[var8][var10][var11 - 1] & var4) != 0; --var11) {
                              ;
                           }

                           while(var12 < 104 && (class16.field216[var8][var10][var12 + 1] & var4) != 0) {
                              ++var12;
                           }

                           label981:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var12; ++var15) {
                                 if((class16.field216[var13 - 1][var10][var15] & var4) == 0) {
                                    break label981;
                                 }
                              }

                              --var13;
                           }

                           label970:
                           while(var14 < var7) {
                              for(var15 = var11; var15 <= var12; ++var15) {
                                 if((class16.field216[var14 + 1][var10][var15] & var4) == 0) {
                                    break label970;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (1 + (var12 - var11)) * (var14 + 1 - var13);
                           if(var15 >= 8) {
                              var60 = 240;
                              var17 = class5.tileHeights[var14][var10][var11] - var60;
                              var56 = class5.tileHeights[var13][var10][var11];
                              Region.method1918(var7, 1, var10 * 128, 128 * var10, 128 * var11, 128 * var12 + 128, var17, var56);

                              for(var19 = var13; var19 <= var14; ++var19) {
                                 for(var20 = var11; var20 <= var12; ++var20) {
                                    class16.field216[var19][var10][var20] &= ~var4;
                                 }
                              }
                           }
                        }

                        if((class16.field216[var8][var10][var9] & var5) != 0) {
                           var11 = var10;
                           var12 = var10;
                           var13 = var8;

                           for(var14 = var8; var11 > 0 && (class16.field216[var8][var11 - 1][var9] & var5) != 0; --var11) {
                              ;
                           }

                           while(var12 < 104 && (class16.field216[var8][var12 + 1][var9] & var5) != 0) {
                              ++var12;
                           }

                           label1034:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var12; ++var15) {
                                 if((class16.field216[var13 - 1][var15][var9] & var5) == 0) {
                                    break label1034;
                                 }
                              }

                              --var13;
                           }

                           label1023:
                           while(var14 < var7) {
                              for(var15 = var11; var15 <= var12; ++var15) {
                                 if((class16.field216[var14 + 1][var15][var9] & var5) == 0) {
                                    break label1023;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var12 - var11 + 1) * (var14 + 1 - var13);
                           if(var15 >= 8) {
                              var60 = 240;
                              var17 = class5.tileHeights[var14][var11][var9] - var60;
                              var56 = class5.tileHeights[var13][var11][var9];
                              Region.method1918(var7, 2, 128 * var11, 128 + 128 * var12, var9 * 128, 128 * var9, var17, var56);

                              for(var19 = var13; var19 <= var14; ++var19) {
                                 for(var20 = var11; var20 <= var12; ++var20) {
                                    class16.field216[var19][var20][var9] &= ~var5;
                                 }
                              }
                           }
                        }

                        if((class16.field216[var8][var10][var9] & var6) != 0) {
                           var11 = var10;
                           var12 = var10;
                           var13 = var9;

                           for(var14 = var9; var13 > 0 && (class16.field216[var8][var10][var13 - 1] & var6) != 0; --var13) {
                              ;
                           }

                           while(var14 < 104 && (class16.field216[var8][var10][var14 + 1] & var6) != 0) {
                              ++var14;
                           }

                           label1087:
                           while(var11 > 0) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class16.field216[var8][var11 - 1][var15] & var6) == 0) {
                                    break label1087;
                                 }
                              }

                              --var11;
                           }

                           label1076:
                           while(var12 < 104) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class16.field216[var8][1 + var12][var15] & var6) == 0) {
                                    break label1076;
                                 }
                              }

                              ++var12;
                           }

                           if((var12 - var11 + 1) * (var14 - var13 + 1) >= 4) {
                              var15 = class5.tileHeights[var8][var11][var13];
                              Region.method1918(var7, 4, 128 * var11, var12 * 128 + 128, 128 * var13, 128 * var14 + 128, var15, var15);

                              for(var16 = var11; var16 <= var12; ++var16) {
                                 for(var17 = var13; var17 <= var14; ++var17) {
                                    class16.field216[var8][var16][var17] &= ~var6;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class14.method174(true);
            var4 = class5.field66;
            if(var4 > class59.plane) {
               var4 = class59.plane;
            }

            if(var4 < class59.plane - 1) {
               var4 = class59.plane - 1;
            }

            if(Client.field271) {
               class114.region.method1916(class5.field66);
            } else {
               class114.region.method1916(0);
            }

            for(var5 = 0; var5 < 104; ++var5) {
               for(var6 = 0; var6 < 104; ++var6) {
                  class116.groundItemSpawned(var5, var6);
               }
            }

            class12.method162();
            Projectile.method88();
            ObjectComposition.field926.reset();
            if(class118.field2008 != null) {
               Client.field300.method2748(96);
               Client.field300.method2642(1057001181);
            }

            if(!Client.field428) {
               var5 = (class54.field1132 - 6) / 8;
               var6 = (6 + class54.field1132) / 8;
               var7 = (class53.field1122 - 6) / 8;
               var8 = (6 + class53.field1122) / 8;

               for(var9 = var5 - 1; var9 <= var6 + 1; ++var9) {
                  for(var10 = var7 - 1; var10 <= 1 + var8; ++var10) {
                     if(var9 < var5 || var9 > var6 || var10 < var7 || var10 > var8) {
                        class24.field603.method3270("m" + var9 + "_" + var10);
                        class24.field603.method3270("l" + var9 + "_" + var10);
                     }
                  }
               }
            }

            class112.setGameState(30);
            class12.method162();
            class152.method3124();
            Client.field300.method2748(33);
            class14.field199.vmethod3110();

            for(var5 = 0; var5 < 32; ++var5) {
               GameEngine.field2251[var5] = 0L;
            }

            for(var5 = 0; var5 < 32; ++var5) {
               GameEngine.field2238[var5] = 0L;
            }

            class34.field752 = 0;
         }
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1860441080"
   )
   final void method779(int var1, int var2, int var3, int var4, int var5, int var6) {
      class49 var7 = class24.method587(var1);
      class26 var8 = null;
      class26 var9 = null;
      int var10 = var7.field1053;
      int var11 = 0;

      class26 var12;
      for(var12 = (class26)this.field831.method3850(); var12 != null; var12 = (class26)this.field831.method3852()) {
         ++var11;
         if(var12.field622.field1047 == var7.field1047) {
            var12.method605(var2 + var4, var5, var6, var3);
            return;
         }

         if(var12.field622.field1052 <= var7.field1052) {
            var8 = var12;
         }

         if(var12.field622.field1053 > var10) {
            var9 = var12;
            var10 = var12.field622.field1053;
         }
      }

      if(null != var9 || var11 < 4) {
         var12 = new class26(var7);
         if(var8 == null) {
            this.field831.method3851(var12);
         } else {
            class205.method3846(var12, var8);
         }

         var12.method605(var4 + var2, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-1736992338"
   )
   public static String method781(CharSequence var0) {
      String var1 = class126.method2787(class133.method2828(var0));
      if(null == var1) {
         var1 = "";
      }

      return var1;
   }
}
