import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = 1076143031
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   Sequence field1516;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 207171057
   )
   @Export("id")
   int id;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1499348917
   )
   int field1518;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 807412183
   )
   @Export("type")
   int type;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1304933649
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1404537621
   )
   @Export("level")
   int level;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -825810299
   )
   int field1517;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 423694731
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1018001043
   )
   @Export("sceneY")
   int sceneY;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLep;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1516 = class40.getAnimation(var7);
         this.field1517 = 0;
         this.field1518 = Client.gameCycle - 1;
         if(this.field1516.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(this.field1516 == var10.field1516) {
               this.field1517 = var10.field1517;
               this.field1518 = var10.field1518;
               return;
            }
         }

         if(var8 && this.field1516.frameStep != -1) {
            this.field1517 = (int)(Math.random() * (double)this.field1516.frameIDs.length);
            this.field1518 -= (int)(Math.random() * (double)this.field1516.frameLenghts[this.field1517]);
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lev;",
      garbageValue = "1458652918"
   )
   protected final Model getModel() {
      if(this.field1516 != null) {
         int var1 = Client.gameCycle - this.field1518;
         if(var1 > 100 && this.field1516.frameStep > 0) {
            var1 = 100;
         }

         label49: {
            do {
               do {
                  if(var1 <= this.field1516.frameLenghts[this.field1517]) {
                     break label49;
                  }

                  var1 -= this.field1516.frameLenghts[this.field1517];
                  ++this.field1517;
               } while(this.field1517 < this.field1516.frameIDs.length);

               this.field1517 -= this.field1516.frameStep;
            } while(this.field1517 >= 0 && this.field1517 < this.field1516.frameIDs.length);

            this.field1516 = null;
         }

         this.field1518 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = WidgetNode.getObjectDefinition(this.id);
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

         int var4 = this.sceneX + (var2 >> 1);
         int var5 = this.sceneX + (var2 + 1 >> 1);
         int var6 = this.sceneY + (var3 >> 1);
         int var7 = this.sceneY + (var3 + 1 >> 1);
         int[][] var8 = class62.tileHeights[this.level];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var5][var6] + var8[var4][var6] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4514(this.type, this.orientation, var8, var10, var9, var11, this.field1516, this.field1517);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "-10088211"
   )
   public static void method1871(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class56.field651.startsWith("win")) {
            class20.method144(var0, 0, "openjs");
         } else if(class56.field651.startsWith("mac")) {
            class20.method144(var0, 1, "openjs");
         } else {
            class20.method144(var0, 2, "openjs");
         }
      } else {
         class20.method144(var0, 3, "openjs");
      }

   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "102"
   )
   static final void method1866(int var0, int var1, int var2, int var3) {
      if(Client.itemSelectionState == 0 && !Client.spellSelected) {
         class164.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class134.field1970; ++var6) {
         var7 = class134.field1971[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && class51.region.method2712(class8.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = WidgetNode.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(var12 == null) {
                  continue;
               }

               if(Client.itemSelectionState == 1) {
                  class164.addMenuEntry("Use", Client.field1037 + " " + "->" + " " + CacheFile.getColTags('\uffff') + var12.name, 1, var7, var8, var9);
               } else if(Client.spellSelected) {
                  if((class96.field1481 & 4) == 4) {
                     class164.addMenuEntry(Client.field972, Client.field1042 + " " + "->" + " " + CacheFile.getColTags('\uffff') + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.actions;
                  if(Client.field969) {
                     var13 = FileOnDisk.method1920(var13);
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

                           class164.addMenuEntry(var13[var14], CacheFile.getColTags('\uffff') + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class164.addMenuEntry("Examine", CacheFile.getColTags('\uffff') + var12.name, 1002, var12.id << 14, var8, var9);
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

               if(var23.composition.field3535 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var19 = 0; var19 < Client.field932; ++var19) {
                     var20 = Client.cachedNPCs[Client.npcIndices[var19]];
                     if(var20 != null && var20 != var23 && var20.composition.field3535 == 1 && var20.x == var23.x && var23.y == var20.y) {
                        class20.method142(var20.composition, Client.npcIndices[var19], var8, var9);
                     }
                  }

                  var19 = class96.field1470;
                  var28 = class96.field1468;

                  for(var27 = 0; var27 < var19; ++var27) {
                     var16 = Client.cachedPlayers[var28[var27]];
                     if(var16 != null && var23.x == var16.x && var16.y == var23.y) {
                        DState.method3184(var16, var28[var27], var8, var9);
                     }
                  }
               }

               class20.method142(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var19 = 0; var19 < Client.field932; ++var19) {
                     var20 = Client.cachedNPCs[Client.npcIndices[var19]];
                     if(var20 != null && var20.composition.field3535 == 1 && var20.x == var24.x && var24.y == var20.y) {
                        class20.method142(var20.composition, Client.npcIndices[var19], var8, var9);
                     }
                  }

                  var19 = class96.field1470;
                  var28 = class96.field1468;

                  for(var27 = 0; var27 < var19; ++var27) {
                     var16 = Client.cachedPlayers[var28[var27]];
                     if(var16 != null && var16 != var24 && var24.x == var16.x && var16.y == var24.y) {
                        DState.method3184(var16, var28[var27], var8, var9);
                     }
                  }
               }

               if(var11 != Client.field927) {
                  DState.method3184(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[class8.plane][var8][var9];
               if(var25 != null) {
                  for(Item var26 = (Item)var25.getTail(); var26 != null; var26 = (Item)var25.getPrevious()) {
                     ItemComposition var29 = Friend.getItemDefinition(var26.id);
                     if(Client.itemSelectionState == 1) {
                        class164.addMenuEntry("Use", Client.field1037 + " " + "->" + " " + CacheFile.getColTags(16748608) + var29.name, 16, var26.id, var8, var9);
                     } else if(Client.spellSelected) {
                        if((class96.field1481 & 1) == 1) {
                           class164.addMenuEntry(Client.field972, Client.field1042 + " " + "->" + " " + CacheFile.getColTags(16748608) + var29.name, 17, var26.id, var8, var9);
                        }
                     } else {
                        String[] var21 = var29.groundActions;
                        if(Client.field969) {
                           var21 = FileOnDisk.method1920(var21);
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

                              class164.addMenuEntry(var21[var22], CacheFile.getColTags(16748608) + var29.name, var17, var26.id, var8, var9);
                           } else if(var22 == 2) {
                              class164.addMenuEntry("Take", CacheFile.getColTags(16748608) + var29.name, 20, var26.id, var8, var9);
                           }
                        }

                        class164.addMenuEntry("Examine", CacheFile.getColTags(16748608) + var29.name, 1004, var26.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var18 = Client.cachedPlayers[Client.field927];
         DState.method3184(var18, Client.field927, var6, var7);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-4"
   )
   static int method1870(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method1883();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "-19957507"
   )
   public static char method1869(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }
}
