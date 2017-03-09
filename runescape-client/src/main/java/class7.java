import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
final class class7 implements Comparator {
   @ObfuscatedName("f")
   static int[] field71;
   @ObfuscatedName("ks")
   @Export("chatMessages")
   static ChatMessages chatMessages;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = 623892409
   )
   static int field73;
   @ObfuscatedName("po")
   static class230 field75;

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "14"
   )
   static final byte[] method93(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 >= 0 && (class182.field2708 == 0 || var3 <= class182.field2708)) {
         if(var2 == 0) {
            byte[] var4 = new byte[var3];
            var1.method2842(var4, 0, var3);
            return var4;
         } else {
            int var6 = var1.readInt();
            if(var6 >= 0 && (class182.field2708 == 0 || var6 <= class182.field2708)) {
               byte[] var5 = new byte[var6];
               if(var2 == 1) {
                  class147.method2768(var5, var6, var0, var3, 9);
               } else {
                  class182.field2709.method2767(var1, var5);
               }

               return var5;
            } else {
               throw new RuntimeException();
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "-18"
   )
   int method94(class2 var1, class2 var2) {
      return var1.field24 < var2.field24?-1:(var1.field24 == var2.field24?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(LWidget;IIB)V",
      garbageValue = "16"
   )
   static final void method95(Widget var0, int var1, int var2) {
      if(null == Client.field486 && !Client.isMenuOpen) {
         if(var0 != null) {
            Widget var5 = var0;
            int var7 = class174.method3271(var0);
            int var6 = var7 >> 17 & 7;
            int var8 = var6;
            int var9;
            Widget var11;
            if(var6 == 0) {
               var11 = null;
            } else {
               var9 = 0;

               while(true) {
                  if(var9 >= var8) {
                     var11 = var5;
                     break;
                  }

                  var5 = World.method670(var5.parentId);
                  if(null == var5) {
                     var11 = null;
                     break;
                  }

                  ++var9;
               }
            }

            Widget var10 = var11;
            if(var11 == null) {
               var10 = var0.parent;
            }

            if(null != var10) {
               Client.field486 = var0;
               var5 = var0;
               var7 = class174.method3271(var0);
               var6 = var7 >> 17 & 7;
               var8 = var6;
               if(var6 == 0) {
                  var11 = null;
               } else {
                  var9 = 0;

                  while(true) {
                     if(var9 >= var8) {
                        var11 = var5;
                        break;
                     }

                     var5 = World.method670(var5.parentId);
                     if(null == var5) {
                        var11 = null;
                        break;
                     }

                     ++var9;
                  }
               }

               var10 = var11;
               if(var11 == null) {
                  var10 = var0.parent;
               }

               Client.field487 = var10;
               Client.field526 = var1;
               Client.field470 = var2;
               World.field709 = 0;
               Client.field398 = false;
               int var4 = class145.method2764();
               if(var4 != -1) {
                  class65.field1115 = new class38();
                  class65.field1115.field822 = Client.menuActionParams0[var4];
                  class65.field1115.field831 = Client.menuActionParams1[var4];
                  class65.field1115.field823 = Client.menuTypes[var4];
                  class65.field1115.field830 = Client.menuIdentifiers[var4];
                  class65.field1115.field825 = Client.menuOptions[var4];
               }

               return;
            }
         }

      }
   }

   public int compare(Object var1, Object var2) {
      return this.method94((class2)var1, (class2)var2);
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "448743522"
   )
   static final void method101(Player var0, int var1, int var2, int var3) {
      if(class22.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.field281 == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + class168.method3202(var0.combatLevel, class22.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field281 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field466 == 1) {
               class22.addMenuEntry("Use", Client.field496 + " " + "->" + " " + class116.method2288(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field468) {
               if((field73 & 8) == 8) {
                  class22.addMenuEntry(Client.field489, Client.field472 + " " + "->" + " " + class116.method2288(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(null != Client.playerOptions[var5]) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(class40.field836 == Client.field336) {
                           continue;
                        }

                        if(class40.field835 == Client.field336 || class40.field839 == Client.field336 && var0.combatLevel > class22.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class22.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class22.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriority[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = Client.field438[var5] + var6;
                     class22.addMenuEntry(Client.playerOptions[var5], class116.method2288(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class116.method2288(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIILRegion;[LCollisionData;B)V",
      garbageValue = "-45"
   )
   static final void method102(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
      Buffer var5 = new Buffer(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.method3013();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.method3013();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.readUnsignedByte();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var1 + var11;
            int var17 = var2 + var10;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class10.tileSettings[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               CollisionData var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               class32.method751(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }
}
