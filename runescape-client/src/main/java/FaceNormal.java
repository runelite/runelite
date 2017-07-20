import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field2099;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1407965931
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2002160687
   )
   @Export("z")
   int z;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -482815685
   )
   @Export("x")
   int x;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CB)B",
      garbageValue = "77"
   )
   public static byte method2807(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "8221"
   )
   static final void method2809(int var0, int var1, int var2, int var3) {
      if(Client.itemSelectionState == 0 && !Client.spellSelected) {
         class261.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class134.field1954; ++var6) {
         var7 = class134.field1955[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var5 != var7) {
            var5 = var7;
            if(var10 == 2 && class19.region.method2715(class10.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = class169.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(var12 == null) {
                  continue;
               }

               if(Client.itemSelectionState == 1) {
                  class261.addMenuEntry("Use", Client.field1058 + " " + "->" + " " + class8.getColTags('\uffff') + var12.name, 1, var7, var8, var9);
               } else if(Client.spellSelected) {
                  if((class39.field534 & 4) == 4) {
                     class261.addMenuEntry(Client.field1062, Client.field1063 + " " + "->" + " " + class8.getColTags('\uffff') + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.actions;
                  if(Client.field1174) {
                     var13 = IndexDataBase.method4103(var13);
                  }

                  if(var13 != null) {
                     for(int var14 = 4; var14 >= 0; --var14) {
                        if(var13[var14] != null) {
                           short var15 = 0;
                           if(var14 == 0) {
                              var15 = 3;
                           }

                           if(var14 == 1) {
                              var15 = 4;
                           }

                           if(var14 == 2) {
                              var15 = 5;
                           }

                           if(var14 == 3) {
                              var15 = 6;
                           }

                           if(var14 == 4) {
                              var15 = 1001;
                           }

                           class261.addMenuEntry(var13[var14], class8.getColTags('\uffff') + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class261.addMenuEntry("Examine", class8.getColTags('\uffff') + var12.name, 1002, var12.id << 14, var8, var9);
               }
            }

            Player var16;
            int var19;
            NPC var20;
            int var27;
            int[] var28;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field3532 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var19 = 0; var19 < Client.field953; ++var19) {
                     var20 = Client.cachedNPCs[Client.npcIndices[var19]];
                     if(var20 != null && var20 != var23 && var20.composition.field3532 == 1 && var23.x == var20.x && var23.y == var20.y) {
                        class174.method3305(var20.composition, Client.npcIndices[var19], var8, var9);
                     }
                  }

                  var19 = class96.field1469;
                  var28 = class96.field1470;

                  for(var27 = 0; var27 < var19; ++var27) {
                     var16 = Client.cachedPlayers[var28[var27]];
                     if(var16 != null && var23.x == var16.x && var16.y == var23.y) {
                        class17.method127(var16, var28[var27], var8, var9);
                     }
                  }
               }

               class174.method3305(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var19 = 0; var19 < Client.field953; ++var19) {
                     var20 = Client.cachedNPCs[Client.npcIndices[var19]];
                     if(var20 != null && var20.composition.field3532 == 1 && var24.x == var20.x && var24.y == var20.y) {
                        class174.method3305(var20.composition, Client.npcIndices[var19], var8, var9);
                     }
                  }

                  var19 = class96.field1469;
                  var28 = class96.field1470;

                  for(var27 = 0; var27 < var19; ++var27) {
                     var16 = Client.cachedPlayers[var28[var27]];
                     if(var16 != null && var24 != var16 && var16.x == var24.x && var16.y == var24.y) {
                        class17.method127(var16, var28[var27], var8, var9);
                     }
                  }
               }

               if(var11 != Client.field1033) {
                  class17.method127(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[class10.plane][var8][var9];
               if(var25 != null) {
                  for(Item var26 = (Item)var25.getTail(); var26 != null; var26 = (Item)var25.getPrevious()) {
                     ItemComposition var29 = class10.getItemDefinition(var26.id);
                     if(Client.itemSelectionState == 1) {
                        class261.addMenuEntry("Use", Client.field1058 + " " + "->" + " " + class8.getColTags(16748608) + var29.name, 16, var26.id, var8, var9);
                     } else if(Client.spellSelected) {
                        if((class39.field534 & 1) == 1) {
                           class261.addMenuEntry(Client.field1062, Client.field1063 + " " + "->" + " " + class8.getColTags(16748608) + var29.name, 17, var26.id, var8, var9);
                        }
                     } else {
                        String[] var21 = var29.groundActions;
                        if(Client.field1174) {
                           var21 = IndexDataBase.method4103(var21);
                        }

                        for(int var22 = 4; var22 >= 0; --var22) {
                           if(var21 != null && var21[var22] != null) {
                              byte var17 = 0;
                              if(var22 == 0) {
                                 var17 = 18;
                              }

                              if(var22 == 1) {
                                 var17 = 19;
                              }

                              if(var22 == 2) {
                                 var17 = 20;
                              }

                              if(var22 == 3) {
                                 var17 = 21;
                              }

                              if(var22 == 4) {
                                 var17 = 22;
                              }

                              class261.addMenuEntry(var21[var22], class8.getColTags(16748608) + var29.name, var17, var26.id, var8, var9);
                           } else if(var22 == 2) {
                              class261.addMenuEntry("Take", class8.getColTags(16748608) + var29.name, 20, var26.id, var8, var9);
                           }
                        }

                        class261.addMenuEntry("Examine", class8.getColTags(16748608) + var29.name, 1004, var26.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var18 = Client.cachedPlayers[Client.field1033];
         class17.method127(var18, Client.field1033, var6, var7);
      }

   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1696570080"
   )
   static final void method2808(int var0, int var1) {
      if(Client.field992 == 2) {
         class22.method157((Client.hintArrowX - class21.baseX << 7) + Client.field938, (Client.hintArrowY - class164.baseY << 7) + Client.field1117, Client.hintArrowType * 2);
         if(Client.screenY > -1 && Client.gameCycle % 20 < 10) {
            class92.pkIcons[0].method4958(var0 + Client.screenY - 12, Client.screenX + var1 - 28);
         }

      }
   }
}
