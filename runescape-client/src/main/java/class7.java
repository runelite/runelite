import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class7 {
   @ObfuscatedName("i")
   public static boolean field232;
   @ObfuscatedName("j")
   public static boolean field228;
   @ObfuscatedName("a")
   public static boolean field236;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ll;"
   )
   public static class11 field229;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   public static CombatInfoList field231;
   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static IndexData field235;

   static {
      field232 = false;
      field228 = false;
      field236 = false;
      field229 = class11.field276;
      field231 = new CombatInfoList();
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(Lhx;I)V",
      garbageValue = "-427737604"
   )
   static void method34(Widget var0) {
      if(var0.loopCycle == Client.field1071) {
         Client.field1110[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1816981447"
   )
   static void method35(int var0) {
      if(var0 == -3) {
         class228.method4112("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class228.method4112("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class228.method4112("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class91.loginIndex = 3;
      } else if(var0 == 4) {
         class228.method4112("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class228.method4112("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class228.method4112("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class228.method4112("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class228.method4112("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class228.method4112("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class228.method4112("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class228.method4112("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class228.method4112("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class228.method4112("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class228.method4112("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class228.method4112("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class228.method4112("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class228.method4112("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class228.method4112("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class228.method4112("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class228.method4112("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class228.method4112("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class228.method4112("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class228.method4112("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class228.method4112("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class228.method4112("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class228.method4112("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class228.method4112("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class228.method4112("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class228.method4112("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class228.method4112("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class228.method4112("Enter the 6-digit code generated by your", "authenticator app.", "");
            WorldMapType2.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class228.method4112("The code you entered was incorrect.", "Please try again.", "");
            WorldMapType2.setGameState(11);
            return;
         }

         class228.method4112("Unexpected server response", "Please try using a different world.", "");
      }

      WorldMapType2.setGameState(10);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "992251286"
   )
   public static int method36(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var6 + var4] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var6 + var4] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var6 + var4] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var6 + var4] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if(var7 == 8220) {
            var3[var6 + var4] = -109;
         } else if(var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var6 + var4] = -98;
         } else if(var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lel;[Lfh;B)V",
      garbageValue = "8"
   )
   static final void method33(Region var0, CollisionData[] var1) {
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
                     var1[var5].method3106(var3, var4);
                  }
               }
            }
         }
      }

      class61.field775 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field775 < -8) {
         class61.field775 = -8;
      }

      if(class61.field775 > 8) {
         class61.field775 = 8;
      }

      class61.field776 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field776 < -16) {
         class61.field776 = -16;
      }

      if(class61.field776 > 16) {
         class61.field776 = 16;
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
         byte[][] var42 = VertexNormal.field2018[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class61.tileHeights[var2][var12 + 1][var11] - class61.tileHeights[var2][var12 - 1][var11];
               var14 = class61.tileHeights[var2][var12][var11 + 1] - class61.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var14 * var14 + 65536 + var13 * var13));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var17 * -10 + var16 * -50 + var18 * -50) / var10 + 96;
               var20 = (var42[var12][var11] >> 1) + (var42[var12][var11 + 1] >> 3) + (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12 - 1][var11] >> 2);
               class61.field773[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            Varcs.blendedHue[var11] = 0;
            class150.blendedSaturation[var11] = 0;
            class27.field401[var11] = 0;
            class244.field3318[var11] = 0;
            class61.field769[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class54.underlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = class94.method1790(var14 - 1);
                     Varcs.blendedHue[var12] += var43.hue;
                     class150.blendedSaturation[var12] += var43.saturation;
                     class27.field401[var12] += var43.lightness;
                     class244.field3318[var12] += var43.hueMultiplier;
                     ++class61.field769[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class54.underlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = class94.method1790(var15 - 1);
                     Varcs.blendedHue[var12] -= var44.hue;
                     class150.blendedSaturation[var12] -= var44.saturation;
                     class27.field401[var12] -= var44.lightness;
                     class244.field3318[var12] -= var44.hueMultiplier;
                     --class61.field769[var12];
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
                     var12 += Varcs.blendedHue[var18];
                     var13 += class150.blendedSaturation[var18];
                     var14 += class27.field401[var18];
                     var15 += class244.field3318[var18];
                     var16 += class61.field769[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= Varcs.blendedHue[var19];
                     var13 -= class150.blendedSaturation[var19];
                     var14 -= class27.field401[var19];
                     var15 -= class244.field3318[var19];
                     var16 -= class61.field769[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.lowMemory || (class61.tileSettings[0][var11][var17] & 2) != 0 || (class61.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class61.field770) {
                        class61.field770 = var2;
                     }

                     var20 = class54.underlayIds[var2][var11][var17] & 255;
                     int var21 = class178.overlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class61.tileHeights[var2][var11][var17];
                        int var23 = class61.tileHeights[var2][var11 + 1][var17];
                        int var24 = class61.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class61.tileHeights[var2][var11][var17 + 1];
                        int var26 = class61.field773[var11][var17];
                        int var27 = class61.field773[var11 + 1][var17];
                        int var28 = class61.field773[var11 + 1][var17 + 1];
                        int var29 = class61.field773[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = CombatInfo1.method1548(var32, var33, var34);
                           var32 = var32 + class61.field775 & 255;
                           var34 += class61.field776;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = CombatInfo1.method1548(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var47 = true;
                           if(var20 == 0 && class61.overlayPaths[var2][var11][var17] != 0) {
                              var47 = false;
                           }

                           if(var21 > 0 && !class61.method1098(var21 - 1).isHidden) {
                              var47 = false;
                           }

                           if(var47 && var23 == var22 && var24 == var22 && var25 == var22) {
                              class14.field300[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = Graphics3D.colorPalette[class15.method107(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class15.method107(var30, var26), class15.method107(var30, var27), class15.method107(var30, var28), class15.method107(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class61.overlayPaths[var2][var11][var17] + 1;
                           byte var48 = class215.overlayRotations[var2][var11][var17];
                           Overlay var35 = class61.method1098(var21 - 1);
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
                              var37 = CombatInfo1.method1548(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class61.field775 & 255;
                              var40 = var35.lightness + class61.field776;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = CombatInfo1.method1548(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = Graphics3D.colorPalette[class205.adjustHSLListness0(var38, 96)];
                           }

                           if(var35.otherRgbColor != -1) {
                              var40 = var35.otherHue + class61.field775 & 255;
                              int var41 = var35.otherLightness + class61.field776;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = CombatInfo1.method1548(var40, var35.otherSaturation, var41);
                              var39 = Graphics3D.colorPalette[class205.adjustHSLListness0(var38, 96)];
                           }

                           var0.addTile(var2, var11, var17, var33, var48, var36, var22, var23, var24, var25, class15.method107(var30, var26), class15.method107(var30, var27), class15.method107(var30, var28), class15.method107(var30, var29), class205.adjustHSLListness0(var37, var26), class205.adjustHSLListness0(var37, var27), class205.adjustHSLListness0(var37, var28), class205.adjustHSLListness0(var37, var29), var32, var39);
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

         class54.underlayIds[var2] = null;
         class178.overlayIds[var2] = null;
         class61.overlayPaths[var2] = null;
         class215.overlayRotations[var2] = null;
         VertexNormal.field2018[var2] = null;
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
                  if((class14.field300[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class14.field300[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && 0 != (class14.field300[var6][var8][var10 + 1] & var2)) {
                        ++var10;
                     }

                     label482:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class14.field300[var11 - 1][var8][var13] & var2) == 0) {
                              break label482;
                           }
                        }

                        --var11;
                     }

                     label471:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class14.field300[var12 + 1][var8][var13] & var2) == 0) {
                              break label471;
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
                              class14.field300[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class14.field300[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class14.field300[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && 0 != (class14.field300[var6][var10 + 1][var7] & var3)) {
                        ++var10;
                     }

                     label535:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class14.field300[var11 - 1][var13][var7] & var3) == 0) {
                              break label535;
                           }
                        }

                        --var11;
                     }

                     label524:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class14.field300[var12 + 1][var13][var7] & var3) == 0) {
                              break label524;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class61.tileHeights[var12][var9][var7] - var46;
                        var16 = class61.tileHeights[var11][var9][var7];
                        Region.addOcclude(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class14.field300[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class14.field300[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class14.field300[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class14.field300[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label588:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class14.field300[var6][var9 - 1][var13] & var4) == 0) {
                              break label588;
                           }
                        }

                        --var9;
                     }

                     label577:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class14.field300[var6][var10 + 1][var13] & var4) == 0) {
                              break label577;
                           }
                        }

                        ++var10;
                     }

                     if((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
                        var13 = class61.tileHeights[var6][var9][var11];
                        Region.addOcclude(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class14.field300[var6][var14][var15] &= ~var4;
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
