import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("ki")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field629;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 130502055
   )
   static int field626;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1718948249
   )
   int field630;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1140831587
   )
   int field622;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 516108485
   )
   int field632;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -568275821
   )
   int field619;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2025062643
   )
   int field620;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1556846705
   )
   int field624;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 214105443
   )
   int field623;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2140769619
   )
   int field627;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1064731839
   )
   int field621;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1485934049
   )
   int field625;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "59"
   )
   public boolean vmethod747(int var1, int var2) {
      return var1 >= (this.field622 << 6) + (this.field632 << 3) && var1 <= (this.field622 << 6) + (this.field632 << 3) + 7 && var2 >= (this.field623 << 6) + (this.field627 << 3) && var2 <= (this.field623 << 6) + (this.field627 << 3) + 7;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1746025354"
   )
   public boolean vmethod746(int var1, int var2, int var3) {
      return var1 >= this.field630 && var1 < this.field619 + this.field630?var2 >= (this.field620 << 6) + (this.field624 << 3) && var2 <= (this.field620 << 6) + (this.field624 << 3) + 7 && var3 >= (this.field621 << 6) + (this.field625 << 3) && var3 <= (this.field621 << 6) + (this.field625 << 3) + 7:false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "2013920575"
   )
   public void vmethod745(WorldMapData var1) {
      if(var1.field462 > this.field622) {
         var1.field462 = this.field622;
      }

      if(var1.field468 < this.field622) {
         var1.field468 = this.field622;
      }

      if(var1.field456 > this.field623) {
         var1.field456 = this.field623;
      }

      if(var1.field465 < this.field623) {
         var1.field465 = this.field623;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Lhs;",
      garbageValue = "1278074658"
   )
   public Coordinates vmethod771(int var1, int var2) {
      if(!this.vmethod747(var1, var2)) {
         return null;
      } else {
         int var3 = this.field624 * 8 - this.field632 * 8 + this.field620 * 64 - this.field622 * 64 + var1;
         int var4 = var2 + (this.field621 * 64 - this.field623 * 64) + (this.field625 * 8 - this.field627 * 8);
         return new Coordinates(this.field630, var3, var4);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1584803853"
   )
   public int[] vmethod757(int var1, int var2, int var3) {
      if(!this.vmethod746(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field622 * 64 - this.field620 * 64 + var2 + (this.field632 * 8 - this.field624 * 8), var3 + (this.field623 * 64 - this.field621 * 64) + (this.field627 * 8 - this.field625 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-1644047401"
   )
   public void vmethod751(Buffer var1) {
      this.field630 = var1.readUnsignedByte();
      this.field619 = var1.readUnsignedByte();
      this.field620 = var1.readUnsignedShort();
      this.field624 = var1.readUnsignedByte();
      this.field621 = var1.readUnsignedShort();
      this.field625 = var1.readUnsignedByte();
      this.field622 = var1.readUnsignedShort();
      this.field632 = var1.readUnsignedByte();
      this.field623 = var1.readUnsignedShort();
      this.field627 = var1.readUnsignedByte();
      this.method752();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "152533182"
   )
   void method752() {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lil;",
      garbageValue = "-1791412752"
   )
   public static class252 method774(int var0) {
      class252 var1 = (class252)class252.field3389.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class252.field3388.getConfigData(11, var0);
         var1 = new class252();
         if(var2 != null) {
            var1.method4442(new Buffer(var2));
         }

         var1.method4441();
         class252.field3389.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2034101455"
   )
   static final void method753() {
      for(Projectile var0 = (Projectile)Client.projectiles.getFront(); var0 != null; var0 = (Projectile)Client.projectiles.getNext()) {
         if(var0.floor == class27.plane && Client.gameCycle <= var0.cycle) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method1768(var1.x, var1.y, class227.getTileHeight(var1.x, var1.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = Player.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method1768(var3.x, var3.y, class227.getTileHeight(var3.x, var3.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               var0.method1770(Client.field1007);
               ScriptState.region.method2877(class27.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.rotationX, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "944998697"
   )
   static final void method775(int var0, int var1, int var2, int var3) {
      if(Client.itemSelectionState == 0 && !Client.spellSelected) {
         class36.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class133.field2009; ++var6) {
         var7 = class133.field2003[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && ScriptState.region.method2741(class27.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = GameObject.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(var12 == null) {
                  continue;
               }

               if(Client.itemSelectionState == 1) {
                  class36.addMenuEntry("Use", Client.field1085 + " " + "->" + " " + Friend.getColTags('\uffff') + var12.name, 1, var7, var8, var9);
               } else if(Client.spellSelected) {
                  if((class67.field845 & 4) == 4) {
                     class36.addMenuEntry(Client.field1089, Client.field1090 + " " + "->" + " " + Friend.getColTags('\uffff') + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.actions;
                  if(Client.field1102) {
                     var13 = class171.method3220(var13);
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

                           class36.addMenuEntry(var13[var14], Friend.getColTags('\uffff') + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class36.addMenuEntry("Examine", Friend.getColTags('\uffff') + var12.name, 1002, var12.id << 14, var8, var9);
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

               if(var23.composition.field3574 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var19 = 0; var19 < Client.field946; ++var19) {
                     var20 = Client.cachedNPCs[Client.npcIndices[var19]];
                     if(var20 != null && var20 != var23 && var20.composition.field3574 == 1 && var23.x == var20.x && var20.y == var23.y) {
                        class5.method12(var20.composition, Client.npcIndices[var19], var8, var9);
                     }
                  }

                  var19 = class95.field1507;
                  var28 = class95.field1511;

                  for(var27 = 0; var27 < var19; ++var27) {
                     var16 = Client.cachedPlayers[var28[var27]];
                     if(var16 != null && var16.x == var23.x && var23.y == var16.y) {
                        class73.method1144(var16, var28[var27], var8, var9);
                     }
                  }
               }

               class5.method12(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var19 = 0; var19 < Client.field946; ++var19) {
                     var20 = Client.cachedNPCs[Client.npcIndices[var19]];
                     if(var20 != null && var20.composition.field3574 == 1 && var24.x == var20.x && var20.y == var24.y) {
                        class5.method12(var20.composition, Client.npcIndices[var19], var8, var9);
                     }
                  }

                  var19 = class95.field1507;
                  var28 = class95.field1511;

                  for(var27 = 0; var27 < var19; ++var27) {
                     var16 = Client.cachedPlayers[var28[var27]];
                     if(var16 != null && var16 != var24 && var24.x == var16.x && var16.y == var24.y) {
                        class73.method1144(var16, var28[var27], var8, var9);
                     }
                  }
               }

               if(var11 != Client.field1060) {
                  class73.method1144(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[class27.plane][var8][var9];
               if(var25 != null) {
                  for(Item var26 = (Item)var25.getTail(); var26 != null; var26 = (Item)var25.getPrevious()) {
                     ItemComposition var29 = class169.getItemDefinition(var26.id);
                     if(Client.itemSelectionState == 1) {
                        class36.addMenuEntry("Use", Client.field1085 + " " + "->" + " " + Friend.getColTags(16748608) + var29.name, 16, var26.id, var8, var9);
                     } else if(Client.spellSelected) {
                        if((class67.field845 & 1) == 1) {
                           class36.addMenuEntry(Client.field1089, Client.field1090 + " " + "->" + " " + Friend.getColTags(16748608) + var29.name, 17, var26.id, var8, var9);
                        }
                     } else {
                        String[] var21 = var29.groundActions;
                        if(Client.field1102) {
                           var21 = class171.method3220(var21);
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

                              class36.addMenuEntry(var21[var22], Friend.getColTags(16748608) + var29.name, var17, var26.id, var8, var9);
                           } else if(var22 == 2) {
                              class36.addMenuEntry("Take", Friend.getColTags(16748608) + var29.name, 20, var26.id, var8, var9);
                           }
                        }

                        class36.addMenuEntry("Examine", Friend.getColTags(16748608) + var29.name, 1004, var26.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var18 = Client.cachedPlayers[Client.field1060];
         class73.method1144(var18, Client.field1060, var6, var7);
      }

   }

   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "(B)Lkr;",
      garbageValue = "1"
   )
   static RenderOverview method767() {
      return KeyFocusListener.renderOverview;
   }
}
