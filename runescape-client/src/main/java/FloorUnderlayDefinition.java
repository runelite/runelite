import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("underlay_ref")
   static IndexDataBase underlay_ref;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("underlays")
   static NodeCache underlays;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1438211403
   )
   @Export("rgbColor")
   int rgbColor;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2098976857
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2143417425
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1265465935
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 843135855
   )
   @Export("hueMultiplier")
   public int hueMultiplier;

   static {
      underlays = new NodeCache(64);
   }

   FloorUnderlayDefinition() {
      this.rgbColor = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   @Export("post")
   void post() {
      this.setHSL(this.rgbColor);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-2041163024"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.decode(var1, var3, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgy;III)V",
      garbageValue = "272019025"
   )
   @Export("decode")
   void decode(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.rgbColor = var1.read24BitInt();
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1094017096"
   )
   @Export("setHSL")
   void setHSL(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.saturation = (int)(256.0D * var14);
      this.lightness = (int)(256.0D * var16);
      if(this.saturation < 0) {
         this.saturation = 0;
      } else if(this.saturation > 255) {
         this.saturation = 255;
      }

      if(this.lightness < 0) {
         this.lightness = 0;
      } else if(this.lightness > 255) {
         this.lightness = 255;
      }

      if(var16 > 0.5D) {
         this.hueMultiplier = (int)(512.0D * var14 * (1.0D - var16));
      } else {
         this.hueMultiplier = (int)(var16 * var14 * 512.0D);
      }

      if(this.hueMultiplier < 1) {
         this.hueMultiplier = 1;
      }

      this.hue = (int)(var12 * (double)this.hueMultiplier);
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-104177046"
   )
   static final void method4966(int var0, int var1, int var2, int var3) {
      if(Client.itemSelectionState == 0 && !Client.spellSelected) {
         TextureProvider.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class132.Viewport_entityCountAtMouse; ++var6) {
         var7 = class132.Viewport_entityIdsAtMouse[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && class86.region.getObjectFlags(class36.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = class169.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(var12 == null) {
                  continue;
               }

               if(Client.itemSelectionState == 1) {
                  TextureProvider.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + IndexFile.getColTags(65535) + var12.name, 1, var7, var8, var9);
               } else if(Client.spellSelected) {
                  if((class243.field2960 & 4) == 4) {
                     TextureProvider.addMenuEntry(Client.field1097, Client.field941 + " " + "->" + " " + IndexFile.getColTags(65535) + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var19 = var12.actions;
                  if(var19 != null) {
                     for(int var20 = 4; var20 >= 0; --var20) {
                        if(var19[var20] != null) {
                           short var15 = 0;
                           if(var20 == 0) {
                              var15 = 3;
                           }

                           if(var20 == 1) {
                              var15 = 4;
                           }

                           if(var20 == 2) {
                              var15 = 5;
                           }

                           if(var20 == 3) {
                              var15 = 6;
                           }

                           if(var20 == 4) {
                              var15 = 1001;
                           }

                           TextureProvider.addMenuEntry(var19[var20], IndexFile.getColTags(65535) + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  TextureProvider.addMenuEntry("Examine", IndexFile.getColTags(65535) + var12.name, 1002, var12.id << 14, var8, var9);
               }
            }

            int var13;
            NPC var14;
            Player var16;
            int[] var26;
            int var28;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field3709 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.npcIndexesCount; ++var13) {
                     var14 = Client.cachedNPCs[Client.npcIndices[var13]];
                     if(var14 != null && var14 != var23 && var14.composition.field3709 == 1 && var23.x == var14.x && var14.y == var23.y) {
                        class153.method3220(var14.composition, Client.npcIndices[var13], var8, var9);
                     }
                  }

                  var13 = class93.playerIndexesCount;
                  var26 = class93.playerIndices;

                  for(var28 = 0; var28 < var13; ++var28) {
                     var16 = Client.cachedPlayers[var26[var28]];
                     if(var16 != null && var23.x == var16.x && var23.y == var16.y) {
                        class22.method173(var16, var26[var28], var8, var9);
                     }
                  }
               }

               class153.method3220(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.npcIndexesCount; ++var13) {
                     var14 = Client.cachedNPCs[Client.npcIndices[var13]];
                     if(var14 != null && var14.composition.field3709 == 1 && var24.x == var14.x && var14.y == var24.y) {
                        class153.method3220(var14.composition, Client.npcIndices[var13], var8, var9);
                     }
                  }

                  var13 = class93.playerIndexesCount;
                  var26 = class93.playerIndices;

                  for(var28 = 0; var28 < var13; ++var28) {
                     var16 = Client.cachedPlayers[var26[var28]];
                     if(var16 != null && var16 != var24 && var24.x == var16.x && var24.y == var16.y) {
                        class22.method173(var16, var26[var28], var8, var9);
                     }
                  }
               }

               if(var11 != Client.field1103) {
                  class22.method173(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[class36.plane][var8][var9];
               if(var25 != null) {
                  for(Item var29 = (Item)var25.getTail(); var29 != null; var29 = (Item)var25.getPrevious()) {
                     ItemComposition var27 = class251.getItemDefinition(var29.id);
                     if(Client.itemSelectionState == 1) {
                        TextureProvider.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + IndexFile.getColTags(16748608) + var27.name, 16, var29.id, var8, var9);
                     } else if(Client.spellSelected) {
                        if((class243.field2960 & 1) == 1) {
                           TextureProvider.addMenuEntry(Client.field1097, Client.field941 + " " + "->" + " " + IndexFile.getColTags(16748608) + var27.name, 17, var29.id, var8, var9);
                        }
                     } else {
                        String[] var21 = var27.groundActions;

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

                              TextureProvider.addMenuEntry(var21[var22], IndexFile.getColTags(16748608) + var27.name, var17, var29.id, var8, var9);
                           } else if(var22 == 2) {
                              TextureProvider.addMenuEntry("Take", IndexFile.getColTags(16748608) + var27.name, 20, var29.id, var8, var9);
                           }
                        }

                        TextureProvider.addMenuEntry("Examine", IndexFile.getColTags(16748608) + var27.name, 1004, var29.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var18 = Client.cachedPlayers[Client.field1103];
         class22.method173(var18, Client.field1103, var6, var7);
      }

   }
}
