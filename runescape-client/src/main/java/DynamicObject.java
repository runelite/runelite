import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   static IndexedSprite field1442;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1885131287
   )
   @Export("id")
   int id;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1370973419
   )
   @Export("type")
   int type;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 868992911
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 434762305
   )
   @Export("level")
   int level;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 829704213
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1026432357
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   Sequence field1446;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 500179389
   )
   int field1447;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1312116929
   )
   int field1440;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLeo;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1446 = class45.getAnimation(var7);
         this.field1447 = 0;
         this.field1440 = Client.gameCycle - 1;
         if(this.field1446.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.field1446 == this.field1446) {
               this.field1447 = var10.field1447;
               this.field1440 = var10.field1440;
               return;
            }
         }

         if(var8 && this.field1446.frameStep != -1) {
            this.field1447 = (int)(Math.random() * (double)this.field1446.frameIDs.length);
            this.field1440 -= (int)(Math.random() * (double)this.field1446.frameLenghts[this.field1447]);
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Les;",
      garbageValue = "-17"
   )
   protected final Model getModel() {
      if(this.field1446 != null) {
         int var1 = Client.gameCycle - this.field1440;
         if(var1 > 100 && this.field1446.frameStep > 0) {
            var1 = 100;
         }

         label56: {
            do {
               do {
                  if(var1 <= this.field1446.frameLenghts[this.field1447]) {
                     break label56;
                  }

                  var1 -= this.field1446.frameLenghts[this.field1447];
                  ++this.field1447;
               } while(this.field1447 < this.field1446.frameIDs.length);

               this.field1447 -= this.field1446.frameStep;
            } while(this.field1447 >= 0 && this.field1447 < this.field1446.frameIDs.length);

            this.field1446 = null;
         }

         this.field1440 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = NPC.getObjectDefinition(this.id);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.orientation != 1 && this.orientation != 3) {
            var2 = var12.width;
            var3 = var12.length;
         } else {
            var2 = var12.length;
            var3 = var12.width;
         }

         int var4 = (var2 >> 1) + this.sceneX;
         int var5 = (var2 + 1 >> 1) + this.sceneX;
         int var6 = (var3 >> 1) + this.sceneY;
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class61.tileHeights[this.level];
         int var9 = var8[var5][var7] + var8[var5][var6] + var8[var4][var6] + var8[var4][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4712(this.type, this.orientation, var8, var10, var9, var11, this.field1446, this.field1447);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lil;Lil;B)V",
      garbageValue = "1"
   )
   public static void method1887(IndexDataBase var0, IndexDataBase var1) {
      NPCComposition.NpcDefinition_indexCache = var0;
      NPCComposition.NpcDefinition_modelIndexCache = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Lja;",
      garbageValue = "2005780679"
   )
   public static class262 method1881(int var0) {
      class262 var1 = (class262)class262.field3480.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class262.field3479.getConfigData(11, var0);
         var1 = new class262();
         if(var2 != null) {
            var1.method4615(new Buffer(var2));
         }

         var1.method4618();
         class262.field3480.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lff;IIB)Ldd;",
      garbageValue = "43"
   )
   public static final AbstractSoundSystem method1885(Signlink var0, int var1, int var2) {
      if(AbstractSoundSystem.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = class160.soundTaskDataProvider.taskData();
            var3.samples = new int[(class2.highMemory?2:1) * 256];
            var3.field1546 = var2;
            var3.vmethod2091();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(AbstractSoundSystem.priority > 0 && class1.task == null) {
               class1.task = new SoundTask();
               class35.field475 = Executors.newScheduledThreadPool(1);
               class35.field475.scheduleAtFixedRate(class1.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class1.task != null) {
               if(class1.task.systems[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class1.task.systems[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new AbstractSoundSystem();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(Ljh;IIII)V",
      garbageValue = "1340595999"
   )
   static final void method1884(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3666) {
               if(!var0.field3668 || Client.field1047 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + class31.method272(var0.combatLevel, GrandExchangeOffer.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3668 && Client.field1002) {
                     DecorativeObject.addMenuEntry("Examine", class54.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     DecorativeObject.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class54.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((MouseRecorder.field817 & 2) == 2) {
                        DecorativeObject.addMenuEntry(Client.field1013, Client.field1014 + " " + "->" + " " + class54.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3668 && Client.field1002?2000:0;
                     String[] var6 = var0.actions;
                     if(Client.numberMenuOptions) {
                        var6 = class37.prependIndices(var6);
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

                              DecorativeObject.addMenuEntry(var6[var7], class54.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(AttackOption.AttackOption_hidden != Client.npcAttackOption) {
                                 if(Client.npcAttackOption == AttackOption.AttackOption_alwaysRightClick || AttackOption.AttackOption_dependsOnCombatLevels == Client.npcAttackOption && var0.combatLevel > GrandExchangeOffer.localPlayer.combatLevel) {
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

                                 DecorativeObject.addMenuEntry(var6[var7], class54.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3668 || !Client.field1002) {
                        DecorativeObject.addMenuEntry("Examine", class54.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}
