import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class43 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static Widget field582;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1563057943
   )
   int field574;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2076481523
   )
   int field575;
   @ObfuscatedName("f")
   int[][] field576;
   @ObfuscatedName("x")
   int[][] field581;
   @ObfuscatedName("p")
   int[][] field584;
   @ObfuscatedName("g")
   int[][] field579;

   class43(int var1, int var2) {
      this.field574 = var1;
      this.field575 = var2;
      this.field576 = new int[var1][var2];
      this.field584 = new int[var1][var2];
      this.field581 = new int[var1][var2];
      this.field579 = new int[var1][var2];
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-234949898"
   )
   int method643(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field574 && var2 < this.field575) {
         if(this.field581[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field576[var1][var2] / this.field579[var1][var2];
            int var4 = this.field584[var1][var2] / this.field579[var1][var2];
            int var5 = this.field581[var1][var2] / this.field579[var1][var2];
            double var7 = (double)var3 / 256.0D;
            double var9 = (double)var4 / 256.0D;
            double var11 = (double)var5 / 256.0D;
            double var13 = var11;
            double var15 = var11;
            double var17 = var11;
            if(var9 != 0.0D) {
               double var19;
               if(var11 < 0.5D) {
                  var19 = var11 * (1.0D + var9);
               } else {
                  var19 = var9 + var11 - var9 * var11;
               }

               double var21 = var11 * 2.0D - var19;
               double var23 = var7 + 0.3333333333333333D;
               if(var23 > 1.0D) {
                  --var23;
               }

               double var27 = var7 - 0.3333333333333333D;
               if(var27 < 0.0D) {
                  ++var27;
               }

               if(var23 * 6.0D < 1.0D) {
                  var13 = (var19 - var21) * 6.0D * var23 + var21;
               } else if(2.0D * var23 < 1.0D) {
                  var13 = var19;
               } else if(3.0D * var23 < 2.0D) {
                  var13 = var21 + 6.0D * (0.6666666666666666D - var23) * (var19 - var21);
               } else {
                  var13 = var21;
               }

               if(var7 * 6.0D < 1.0D) {
                  var15 = var7 * 6.0D * (var19 - var21) + var21;
               } else if(var7 * 2.0D < 1.0D) {
                  var15 = var19;
               } else if(3.0D * var7 < 2.0D) {
                  var15 = 6.0D * (var19 - var21) * (0.6666666666666666D - var7) + var21;
               } else {
                  var15 = var21;
               }

               if(6.0D * var27 < 1.0D) {
                  var17 = var21 + var27 * (var19 - var21) * 6.0D;
               } else if(2.0D * var27 < 1.0D) {
                  var17 = var19;
               } else if(var27 * 3.0D < 2.0D) {
                  var17 = var21 + 6.0D * (var19 - var21) * (0.6666666666666666D - var27);
               } else {
                  var17 = var21;
               }
            }

            int var29 = (int)(var13 * 256.0D);
            int var20 = (int)(256.0D * var15);
            int var30 = (int)(256.0D * var17);
            int var22 = var30 + (var20 << 8) + (var29 << 16);
            return var22;
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIILiu;B)V",
      garbageValue = "94"
   )
   void method646(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field574 && var2 - var3 <= this.field575) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field574, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field575, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field576[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field584[var9][var10] += var4.saturation;
                     this.field581[var9][var10] += var4.lightness;
                     ++this.field579[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2090658862"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class239.field3246 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class239.field3246.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class239.field3246.close();
            } catch (Exception var3) {
               ;
            }

            ++class239.field3256;
            class239.field3246 = null;
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2088769547"
   )
   public static void method652() {
      Area.skeletonsIndex.reset();
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(Lbs;B)V",
      garbageValue = "20"
   )
   static final void method650(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = class36.region.method2728(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class36.region.method2782(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class36.region.method2730(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class36.region.method2731(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = class36.region.method2825(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1209 = var2;
      var0.field1206 = var3;
      var0.field1210 = var4;
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(Lim;IIII)V",
      garbageValue = "1307788123"
   )
   static final void method649(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3570) {
               if(!var0.field3572 || Client.field1094 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + class34.method465(var0.combatLevel, XGrandExchangeOffer.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3572 && Client.field1046) {
                     DynamicObject.addMenuEntry("Examine", Tile.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     DynamicObject.addMenuEntry("Use", Client.field1084 + " " + "->" + " " + Tile.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((class51.field664 & 2) == 2) {
                        DynamicObject.addMenuEntry(Client.field993, Client.field1085 + " " + "->" + " " + Tile.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3572 && Client.field1046?2000:0;
                     String[] var6 = var0.actions;
                     if(Client.field1027) {
                        var6 = class158.method3000(var6);
                     }

                     int var7;
                     int var8;
                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && !var6[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var5 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var5 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = var5 + 11;
                              }

                              if(var7 == 3) {
                                 var8 = var5 + 12;
                              }

                              if(var7 == 4) {
                                 var8 = var5 + 13;
                              }

                              DynamicObject.addMenuEntry(var6[var7], Tile.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(Client.field1117 != class92.field1424) {
                                 if(class92.field1422 == Client.field1117 || Client.field1117 == class92.field1426 && var0.combatLevel > XGrandExchangeOffer.localPlayer.combatLevel) {
                                    var9 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var9 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = var9 + 10;
                                 }

                                 if(var7 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = var9 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = var9 + 13;
                                 }

                                 DynamicObject.addMenuEntry(var6[var7], Tile.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3572 || !Client.field1046) {
                        DynamicObject.addMenuEntry("Examine", Tile.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}
