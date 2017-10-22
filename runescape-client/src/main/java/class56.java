import java.applet.Applet;
import java.io.IOException;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("bs")
public class class56 {
   @ObfuscatedName("w")
   static Applet field693;
   @ObfuscatedName("s")
   static String field692;
   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "Lbm;"
   )
   static class70 field695;
   @ObfuscatedName("p")
   public static int[] field700;
   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "[Ljo;"
   )
   static IndexedSprite[] field697;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = 475226431
   )
   static int field696;

   static {
      field693 = null;
      field692 = null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lbl;I)V",
      garbageValue = "-2067981463"
   )
   public static void method817(ScriptEvent var0) {
      Actor.method1541(var0, 200000);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lih;II)V",
      garbageValue = "-1934446240"
   )
   static void method816(IndexData var0, int var1) {
      if(WorldMapType3.field404 != null) {
         WorldMapType3.field404.offset = var1 * 8 + 5;
         int var2 = WorldMapType3.field404.readInt();
         int var3 = WorldMapType3.field404.readInt();
         var0.setInformation(var2, var3);
      } else {
         class14.method87((IndexData)null, 255, 255, 0, (byte)0, true);
         class238.field3260[var1] = var0;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "856711815"
   )
   public static final void method814(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.min(var3, Math.min(var4, var5)) - var6;
      int var8 = Math.max(var3, Math.max(var4, var5)) + var6;
      int var9 = Math.min(var0, Math.min(var1, var2)) - var6;
      int var10 = Math.max(var0, Math.max(var1, var2)) + var6;
      class7.field241.method3651(new class8(var7, var9, var8, var10, -49088));
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "54"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      KeyFocusListener.method756();
      ++Client.audioEffectCount;
      if(Client.audioEffectCount >= 50 || var0) {
         Client.audioEffectCount = 0;
         if(!Client.socketError && class15.rssocket != null) {
            Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_KEEPALIVE);

	    // no need to finish packet here as keepalive is length zero

            try {
               class15.rssocket.queueForWrite(Client.secretPacketBuffer1.payload, 0, Client.secretPacketBuffer1.offset);
               Client.secretPacketBuffer1.offset = 0;
            } catch (IOException var2) {
               Client.socketError = true;
            }
         }

      }
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "10"
   )
   static final int method812() {
      if(class70.preferences.hideRoofs) {
         return class46.plane;
      } else {
         int var0 = 3;
         if(class18.cameraPitch < 310) {
            int var1 = AbstractByteBuffer.cameraX >> 7;
            int var2 = World.cameraY >> 7;
            int var3 = class66.localPlayer.x >> 7;
            int var4 = class66.localPlayer.y >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class46.plane;
            }

            if((class61.tileSettings[class46.plane][var1][var2] & 4) != 0) {
               var0 = class46.plane;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = var6 * 65536 / var5;
               var8 = 32768;

               while(var3 != var1) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class61.tileSettings[class46.plane][var1][var2] & 4) != 0) {
                     var0 = class46.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class61.tileSettings[class46.plane][var1][var2] & 4) != 0) {
                        var0 = class46.plane;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = 32768;

               while(var4 != var2) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class61.tileSettings[class46.plane][var1][var2] & 4) != 0) {
                     var0 = class46.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class61.tileSettings[class46.plane][var1][var2] & 4) != 0) {
                        var0 = class46.plane;
                     }
                  }
               }
            }
         }

         if(class66.localPlayer.x >= 0 && class66.localPlayer.y >= 0 && class66.localPlayer.x < 13312 && class66.localPlayer.y < 13312) {
            if((class61.tileSettings[class46.plane][class66.localPlayer.x >> 7][class66.localPlayer.y >> 7] & 4) != 0) {
               var0 = class46.plane;
            }

            return var0;
         } else {
            return class46.plane;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "-2004489491"
   )
   static int method815(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if(var0 == 4100) {
         var3 = class81.scriptStringStack[--class266.scriptStringStackSize];
         var4 = class81.intStack[--class278.intStackSize];
         class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var35;
         if(var0 == 4101) {
            class266.scriptStringStackSize -= 2;
            var3 = class81.scriptStringStack[class266.scriptStringStackSize];
            var35 = class81.scriptStringStack[class266.scriptStringStackSize + 1];
            class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var3 + var35;
            return 1;
         } else if(var0 == 4102) {
            var3 = class81.scriptStringStack[--class266.scriptStringStackSize];
            var4 = class81.intStack[--class278.intStackSize];
            class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var3 + class223.method4148(var4, true);
            return 1;
         } else if(var0 == 4103) {
            var3 = class81.scriptStringStack[--class266.scriptStringStackSize];
            class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var8;
            int var21;
            int var28;
            if(var0 == 4104) {
               var21 = class81.intStack[--class278.intStackSize];
               long var22 = ((long)var21 + 11745L) * 86400000L;
               class81.field1332.setTime(new Date(var22));
               var28 = class81.field1332.get(5);
               int var29 = class81.field1332.get(2);
               var8 = class81.field1332.get(1);
               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var28 + "-" + class81.field1338[var29] + "-" + var8;
               return 1;
            } else if(var0 == 4105) {
               class266.scriptStringStackSize -= 2;
               var3 = class81.scriptStringStack[class266.scriptStringStackSize];
               var35 = class81.scriptStringStack[class266.scriptStringStackSize + 1];
               if(class66.localPlayer.composition != null && class66.localPlayer.composition.isFemale) {
                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var35;
               } else {
                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4106) {
               var21 = class81.intStack[--class278.intStackSize];
               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = Integer.toString(var21);
               return 1;
            } else {
               int var5;
               if(var0 == 4107) {
                  class266.scriptStringStackSize -= 2;
                  int[] var27 = class81.intStack;
                  var4 = ++class278.intStackSize - 1;
                  String var37 = class81.scriptStringStack[class266.scriptStringStackSize];
                  String var38 = class81.scriptStringStack[class266.scriptStringStackSize + 1];
                  var8 = Client.languageId;
                  int var9 = var37.length();
                  int var10 = var38.length();
                  int var11 = 0;
                  int var12 = 0;
                  char var13 = 0;
                  char var14 = 0;

                  label262:
                  while(true) {
                     if(var11 - var13 >= var9 && var12 - var14 >= var10) {
                        int var32 = Math.min(var9, var10);

                        char var18;
                        int var33;
                        for(var33 = 0; var33 < var32; ++var33) {
                           char var17 = var37.charAt(var33);
                           var18 = var38.charAt(var33);
                           if(var18 != var17 && Character.toUpperCase(var17) != Character.toUpperCase(var18)) {
                              var17 = Character.toLowerCase(var17);
                              var18 = Character.toLowerCase(var18);
                              if(var17 != var18) {
                                 var5 = class2.method1(var17, var8) - class2.method1(var18, var8);
                                 break label262;
                              }
                           }
                        }

                        var33 = var9 - var10;
                        if(var33 != 0) {
                           var5 = var33;
                        } else {
                           for(int var34 = 0; var34 < var32; ++var34) {
                              var18 = var37.charAt(var34);
                              char var19 = var38.charAt(var34);
                              if(var19 != var18) {
                                 var5 = class2.method1(var18, var8) - class2.method1(var19, var8);
                                 break label262;
                              }
                           }

                           var5 = 0;
                        }
                        break;
                     }

                     if(var11 - var13 >= var9) {
                        var5 = -1;
                        break;
                     }

                     if(var12 - var14 >= var10) {
                        var5 = 1;
                        break;
                     }

                     char var15;
                     if(var13 != 0) {
                        var15 = var13;
                        boolean var30 = false;
                     } else {
                        var15 = var37.charAt(var11++);
                     }

                     char var16;
                     if(var14 != 0) {
                        var16 = var14;
                        boolean var31 = false;
                     } else {
                        var16 = var38.charAt(var12++);
                     }

                     var13 = WorldMapType1.method267(var15);
                     var14 = WorldMapType1.method267(var16);
                     var15 = class46.method659(var15, var8);
                     var16 = class46.method659(var16, var8);
                     if(var15 != var16 && Character.toUpperCase(var15) != Character.toUpperCase(var16)) {
                        var15 = Character.toLowerCase(var15);
                        var16 = Character.toLowerCase(var16);
                        if(var16 != var15) {
                           var5 = class2.method1(var15, var8) - class2.method1(var16, var8);
                           break;
                        }
                     }
                  }

                  var27[var4] = class219.method4137(var5);
                  return 1;
               } else {
                  byte[] var24;
                  Font var25;
                  if(var0 == 4108) {
                     var3 = class81.scriptStringStack[--class266.scriptStringStackSize];
                     class278.intStackSize -= 2;
                     var4 = class81.intStack[class278.intStackSize];
                     var5 = class81.intStack[class278.intStackSize + 1];
                     var24 = BaseVarType.field41.getConfigData(var5, 0);
                     var25 = new Font(var24);
                     class81.intStack[++class278.intStackSize - 1] = var25.method4840(var3, var4);
                     return 1;
                  } else if(var0 == 4109) {
                     var3 = class81.scriptStringStack[--class266.scriptStringStackSize];
                     class278.intStackSize -= 2;
                     var4 = class81.intStack[class278.intStackSize];
                     var5 = class81.intStack[class278.intStackSize + 1];
                     var24 = BaseVarType.field41.getConfigData(var5, 0);
                     var25 = new Font(var24);
                     class81.intStack[++class278.intStackSize - 1] = var25.method4839(var3, var4);
                     return 1;
                  } else if(var0 == 4110) {
                     class266.scriptStringStackSize -= 2;
                     var3 = class81.scriptStringStack[class266.scriptStringStackSize];
                     var35 = class81.scriptStringStack[class266.scriptStringStackSize + 1];
                     if(class81.intStack[--class278.intStackSize] == 1) {
                        class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var3;
                     } else {
                        class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var35;
                     }

                     return 1;
                  } else if(var0 == 4111) {
                     var3 = class81.scriptStringStack[--class266.scriptStringStackSize];
                     class81.scriptStringStack[++class266.scriptStringStackSize - 1] = FontTypeFace.appendTags(var3);
                     return 1;
                  } else if(var0 == 4112) {
                     var3 = class81.scriptStringStack[--class266.scriptStringStackSize];
                     var4 = class81.intStack[--class278.intStackSize];
                     class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else if(var0 == 4113) {
                     var21 = class81.intStack[--class278.intStackSize];
                     class81.intStack[++class278.intStackSize - 1] = FileRequest.method4186((char)var21)?1:0;
                     return 1;
                  } else {
                     boolean var6;
                     char var7;
                     int[] var20;
                     if(var0 == 4114) {
                        var21 = class81.intStack[--class278.intStackSize];
                        var20 = class81.intStack;
                        var5 = ++class278.intStackSize - 1;
                        var7 = (char)var21;
                        var6 = var7 >= '0' && var7 <= '9' || var7 >= 'A' && var7 <= 'Z' || var7 >= 'a' && var7 <= 'z';
                        var20[var5] = var6?1:0;
                        return 1;
                     } else if(var0 == 4115) {
                        var21 = class81.intStack[--class278.intStackSize];
                        var20 = class81.intStack;
                        var5 = ++class278.intStackSize - 1;
                        var7 = (char)var21;
                        var6 = var7 >= 'A' && var7 <= 'Z' || var7 >= 'a' && var7 <= 'z';
                        var20[var5] = var6?1:0;
                        return 1;
                     } else if(var0 != 4116) {
                        if(var0 == 4117) {
                           var3 = class81.scriptStringStack[--class266.scriptStringStackSize];
                           if(var3 != null) {
                              class81.intStack[++class278.intStackSize - 1] = var3.length();
                           } else {
                              class81.intStack[++class278.intStackSize - 1] = 0;
                           }

                           return 1;
                        } else if(var0 == 4118) {
                           var3 = class81.scriptStringStack[--class266.scriptStringStackSize];
                           class278.intStackSize -= 2;
                           var4 = class81.intStack[class278.intStackSize];
                           var5 = class81.intStack[class278.intStackSize + 1];
                           class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var3.substring(var4, var5);
                           return 1;
                        } else if(var0 == 4119) {
                           var3 = class81.scriptStringStack[--class266.scriptStringStackSize];
                           StringBuilder var36 = new StringBuilder(var3.length());
                           boolean var26 = false;

                           for(var28 = 0; var28 < var3.length(); ++var28) {
                              var7 = var3.charAt(var28);
                              if(var7 == '<') {
                                 var26 = true;
                              } else if(var7 == '>') {
                                 var26 = false;
                              } else if(!var26) {
                                 var36.append(var7);
                              }
                           }

                           class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var36.toString();
                           return 1;
                        } else if(var0 == 4120) {
                           var3 = class81.scriptStringStack[--class266.scriptStringStackSize];
                           var4 = class81.intStack[--class278.intStackSize];
                           class81.intStack[++class278.intStackSize - 1] = var3.indexOf(var4);
                           return 1;
                        } else if(var0 == 4121) {
                           class266.scriptStringStackSize -= 2;
                           var3 = class81.scriptStringStack[class266.scriptStringStackSize];
                           var35 = class81.scriptStringStack[class266.scriptStringStackSize + 1];
                           var5 = class81.intStack[--class278.intStackSize];
                           class81.intStack[++class278.intStackSize - 1] = var3.indexOf(var35, var5);
                           return 1;
                        } else {
                           return 2;
                        }
                     } else {
                        var21 = class81.intStack[--class278.intStackSize];
                        var20 = class81.intStack;
                        var5 = ++class278.intStackSize - 1;
                        var7 = (char)var21;
                        var6 = var7 >= '0' && var7 <= '9';
                        var20[var5] = var6?1:0;
                        return 1;
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(Lhj;IIB)V",
      garbageValue = "47"
   )
   static final void method813(Widget var0, int var1, int var2) {
      if(var0.field2712 == 1) {
         class215.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      int var4;
      int var5;
      if(var0.field2712 == 2 && !Client.spellSelected) {
         var5 = class25.getWidgetConfig(var0);
         var4 = var5 >> 11 & 63;
         if(var4 == 0) {
            var3 = null;
         } else if(var0.selectedAction != null && var0.selectedAction.trim().length() != 0) {
            var3 = var0.selectedAction;
         } else {
            var3 = null;
         }

         if(var3 != null) {
            class215.addMenuEntry(var3, class24.getColTags(65280) + var0.field2683, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2712 == 3) {
         class215.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2712 == 4) {
         class215.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2712 == 5) {
         class215.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2712 == 6 && Client.field1078 == null) {
         class215.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var6;
      int var18;
      if(var0.type == 2) {
         var18 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               var6 = (var0.paddingX + 32) * var5;
               int var7 = (var0.paddingY + 32) * var4;
               if(var18 < 20) {
                  var6 += var0.xSprites[var18];
                  var7 += var0.field2701[var18];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.field1177 = var18;
                  class94.field1498 = var0;
                  if(var0.itemIds[var18] > 0) {
                     label432: {
                        ItemComposition var8 = FaceNormal.getItemDefinition(var0.itemIds[var18] - 1);
                        boolean var9;
                        int var10;
                        if(Client.itemSelectionState == 1) {
                           var10 = class25.getWidgetConfig(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if(var0.id != ClanMember.field915 || var18 != class5.selectedItemIndex) {
                                 class215.addMenuEntry("Use", Client.field1068 + " " + "->" + " " + class24.getColTags(16748608) + var8.name, 31, var8.id, var18, var0.id);
                              }
                              break label432;
                           }
                        }

                        if(Client.spellSelected) {
                           var10 = class25.getWidgetConfig(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if((class90.field1421 & 16) == 16) {
                                 class215.addMenuEntry(Client.field1072, Client.field1087 + " " + "->" + " " + class24.getColTags(16748608) + var8.name, 32, var8.id, var18, var0.id);
                              }
                              break label432;
                           }
                        }

                        String[] var19 = var8.inventoryActions;
                        if(Client.field1085) {
                           var19 = class8.method43(var19);
                        }

                        var10 = -1;
                        if(Client.field961 && KeyFocusListener.field659[81]) {
                           var10 = var8.method4669();
                        }

                        int var12 = class25.getWidgetConfig(var0);
                        boolean var11 = (var12 >> 30 & 1) != 0;
                        if(var11) {
                           for(int var13 = 4; var13 >= 3; --var13) {
                              if(var13 != var10) {
                                 class225.method4156(var0, var8, var18, var13, false);
                              }
                           }
                        }

                        Object var10000 = null;
                        if(WorldMapType3.method213(class25.getWidgetConfig(var0))) {
                           class215.addMenuEntry("Use", class24.getColTags(16748608) + var8.name, 38, var8.id, var18, var0.id);
                        }

                        int var14 = class25.getWidgetConfig(var0);
                        boolean var26 = (var14 >> 30 & 1) != 0;
                        int var15;
                        if(var26) {
                           for(var15 = 2; var15 >= 0; --var15) {
                              if(var10 != var15) {
                                 class225.method4156(var0, var8, var18, var15, false);
                              }
                           }

                           if(var10 >= 0) {
                              class225.method4156(var0, var8, var18, var10, true);
                           }
                        }

                        var19 = var0.configActions;
                        if(Client.field1085) {
                           var19 = class8.method43(var19);
                        }

                        if(var19 != null) {
                           for(var15 = 4; var15 >= 0; --var15) {
                              if(var19[var15] != null) {
                                 byte var16 = 0;
                                 if(var15 == 0) {
                                    var16 = 39;
                                 }

                                 if(var15 == 1) {
                                    var16 = 40;
                                 }

                                 if(var15 == 2) {
                                    var16 = 41;
                                 }

                                 if(var15 == 3) {
                                    var16 = 42;
                                 }

                                 if(var15 == 4) {
                                    var16 = 43;
                                 }

                                 class215.addMenuEntry(var19[var15], class24.getColTags(16748608) + var8.name, var16, var8.id, var18, var0.id);
                              }
                           }
                        }

                        class215.addMenuEntry("Examine", class24.getColTags(16748608) + var8.name, 1005, var8.id, var18, var0.id);
                     }
                  }
               }

               ++var18;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.spellSelected) {
            var4 = class25.getWidgetConfig(var0);
            boolean var27 = (var4 >> 21 & 1) != 0;
            if(var27 && (class90.field1421 & 32) == 32) {
               class215.addMenuEntry(Client.field1072, Client.field1087 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var18 = 9; var18 >= 5; --var18) {
               var6 = class25.getWidgetConfig(var0);
               boolean var24 = (var6 >> var18 + 1 & 1) != 0;
               String var17;
               if(!var24 && var0.field2742 == null) {
                  var17 = null;
               } else if(var0.actions != null && var0.actions.length > var18 && var0.actions[var18] != null && var0.actions[var18].trim().length() != 0) {
                  var17 = var0.actions[var18];
               } else {
                  var17 = null;
               }

               if(var17 != null) {
                  class215.addMenuEntry(var17, var0.name, 1007, var18 + 1, var0.index, var0.id);
               }
            }

            var5 = class25.getWidgetConfig(var0);
            var4 = var5 >> 11 & 63;
            if(var4 == 0) {
               var3 = null;
            } else if(var0.selectedAction != null && var0.selectedAction.trim().length() != 0) {
               var3 = var0.selectedAction;
            } else {
               var3 = null;
            }

            if(var3 != null) {
               class215.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var5 = 4; var5 >= 0; --var5) {
               int var21 = class25.getWidgetConfig(var0);
               boolean var25 = (var21 >> var5 + 1 & 1) != 0;
               String var22;
               if(!var25 && var0.field2742 == null) {
                  var22 = null;
               } else if(var0.actions != null && var0.actions.length > var5 && var0.actions[var5] != null && var0.actions[var5].trim().length() != 0) {
                  var22 = var0.actions[var5];
               } else {
                  var22 = null;
               }

               if(var22 != null) {
                  class215.addMenuEntry(var22, var0.name, 57, var5 + 1, var0.index, var0.id);
               }
            }

            if(class226.method4157(class25.getWidgetConfig(var0))) {
               class215.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }
}
