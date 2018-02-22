import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public abstract class class28 {
   @ObfuscatedName("e")
   static int[] field385;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -774640135
   )
   int field383;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1117632883
   )
   int field373;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1199555583
   )
   int field374;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1707108663
   )
   int field381;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1572747469
   )
   int field384;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1211763019
   )
   int field377;
   @ObfuscatedName("l")
   short[][][] field378;
   @ObfuscatedName("y")
   short[][][] field379;
   @ObfuscatedName("g")
   byte[][][] field386;
   @ObfuscatedName("c")
   byte[][][] field380;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[[[[Laf;"
   )
   class31[][][][] field382;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILgn;I)V",
      garbageValue = "-1692742764"
   )
   void method242(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method264(var1, var2, var3, var4);
         } else {
            this.method249(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IILgn;IB)V",
      garbageValue = "-1"
   )
   void method264(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field379[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field378[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IILgn;II)V",
      garbageValue = "-1120258659"
   )
   void method249(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field378[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field379[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field386[var9][var1][var2] = (byte)(var11 >> 2);
               this.field380[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field382[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3732();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "511102545"
   )
   int method251(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field378[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "9021"
   )
   int method245() {
      return this.field374;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1857869472"
   )
   int method255() {
      return this.field381;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1715336912"
   )
   @Export("getVarbit")
   public static int getVarbit(int var0) {
      Varbit var2 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var7 = UnitPriceComparator.varbit_ref.getConfigData(14, var0);
         var2 = new Varbit();
         if(var7 != null) {
            var2.decode(new Buffer(var7));
         }

         Varbit.varbits.put(var2, (long)var0);
         var1 = var2;
      }

      int var3 = var1.configId;
      int var4 = var1.leastSignificantBit;
      int var5 = var1.mostSignificantBit;
      int var6 = class231.varpsMasks[var5 - var4];
      return class231.widgetSettings[var3] >> var4 & var6;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1924909316"
   )
   static final void method246(int var0) {
      class131.Viewport_entityIdsAtMouse[++class131.Viewport_entityCountAtMouse - 1] = var0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1848548232"
   )
   static synchronized void method267(byte[] var0) {
      if(var0.length == 100 && class194.field2551 < 1000) {
         class194.field2546[++class194.field2551 - 1] = var0;
      } else if(var0.length == 5000 && class194.field2544 < 250) {
         class194.field2549[++class194.field2544 - 1] = var0;
      } else if(var0.length == 30000 && class194.field2545 < 50) {
         class194.field2548[++class194.field2545 - 1] = var0;
      } else {
         if(class317.field3873 != null) {
            for(int var1 = 0; var1 < class194.field2547.length; ++var1) {
               if(var0.length == class194.field2547[var1] && class249.field3284[var1] < class317.field3873[var1].length) {
                  class317.field3873[var1][class249.field3284[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(ILca;ZI)I",
      garbageValue = "-1246100485"
   )
   static int method266(int var0, Script var1, boolean var2) {
      if(var0 == 5306) {
         int[] var3 = class80.intStack;
         int var4 = ++class80.intStackSize - 1;
         int var5 = Client.isResized?2:1;
         var3[var4] = var5;
         return 1;
      } else {
         int var6;
         if(var0 == 5307) {
            var6 = class80.intStack[--class80.intStackSize];
            if(var6 == 1 || var6 == 2) {
               IndexStoreActionHandler.method4626(var6);
            }

            return 1;
         } else if(var0 == 5308) {
            class80.intStack[++class80.intStackSize - 1] = Client.preferences.screenType;
            return 1;
         } else if(var0 != 5309) {
            return 2;
         } else {
            var6 = class80.intStack[--class80.intStackSize];
            if(var6 == 1 || var6 == 2) {
               Client.preferences.screenType = var6;
               VertexNormal.method2802();
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(Lbl;IIII)V",
      garbageValue = "-1282340091"
   )
   static final void method268(Player var0, int var1, int var2, int var3) {
      if(OwnWorldComparator.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.totalLevel == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + RunException.method3227(var0.combatLevel, OwnWorldComparator.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var5;
            if(Client.itemSelectionState == 1) {
               class21.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + BoundingBox3D.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((Size.field340 & 8) == 8) {
                  class21.addMenuEntry(Client.field961, Client.field962 + " " + "->" + " " + BoundingBox3D.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(Client.playerAttackOption == AttackOption.AttackOption_hidden) {
                           continue;
                        }

                        if(Client.playerAttackOption == AttackOption.AttackOption_alwaysRightClick || Client.playerAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > OwnWorldComparator.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(OwnWorldComparator.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == OwnWorldComparator.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = Client.playerMenuTypes[var5] + var6;
                     class21.addMenuEntry(Client.playerOptions[var5], BoundingBox3D.getColTags(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = BoundingBox3D.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
