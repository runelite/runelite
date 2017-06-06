import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class164 {
   @ObfuscatedName("i")
   static RSSocket field2337;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1035052110"
   )
   public static void method3060() {
      class203.field2511.method3674();
      class203.field2514 = 1;
      class203.field2513 = null;
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "1085742118"
   )
   static final void method3068(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.method4652();
         }

         if(var0 != null) {
            if(var0.field3559) {
               if(!var0.field3580 || var1 == Client.field1193) {
                  String var4 = var0.name;
                  int var7;
                  int var8;
                  if(var0.combatLevel != 0) {
                     var7 = var0.combatLevel;
                     var8 = World.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = WorldMapData.method337(16711680);
                     } else if(var9 < -6) {
                        var6 = WorldMapData.method337(16723968);
                     } else if(var9 < -3) {
                        var6 = WorldMapData.method337(16740352);
                     } else if(var9 < 0) {
                        var6 = WorldMapData.method337(16756736);
                     } else if(var9 > 9) {
                        var6 = WorldMapData.method337('\uff00');
                     } else if(var9 > 6) {
                        var6 = WorldMapData.method337(4259584);
                     } else if(var9 > 3) {
                        var6 = WorldMapData.method337(8453888);
                     } else if(var9 > 0) {
                        var6 = WorldMapData.method337(12648192);
                     } else {
                        var6 = WorldMapData.method337(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3580 && Client.field1156) {
                     class3.addMenuEntry("Examine", WorldMapData.method337(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.field1083 == 1) {
                     class3.addMenuEntry("Use", Client.field1084 + " " + "->" + " " + WorldMapData.method337(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field1085) {
                     if((class64.field808 & 2) == 2) {
                        class3.addMenuEntry(Client.field1088, Client.field1089 + " " + "->" + " " + WorldMapData.method337(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var10 = var0.field3580 && Client.field1156?2000:0;
                     String[] var11 = var0.actions;
                     if(Client.field1101) {
                        var11 = Actor.method1518(var11);
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && !var11[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var10 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var10 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = var10 + 11;
                              }

                              if(var7 == 3) {
                                 var8 = var10 + 12;
                              }

                              if(var7 == 4) {
                                 var8 = var10 + 13;
                              }

                              class3.addMenuEntry(var11[var7], WorldMapData.method337(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && var11[var7].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(class91.field1439 != Client.field984) {
                                 if(class91.field1436 == Client.field984 || Client.field984 == class91.field1440 && var0.combatLevel > World.localPlayer.combatLevel) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var12 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = var12 + 10;
                                 }

                                 if(var7 == 2) {
                                    var8 = var12 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = var12 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = var12 + 13;
                                 }

                                 class3.addMenuEntry(var11[var7], WorldMapData.method337(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3580 || !Client.field1156) {
                        class3.addMenuEntry("Examine", WorldMapData.method337(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method3069() {
      int var0 = class67.menuX;
      int var1 = WorldMapType3.menuY;
      int var2 = class98.menuWidth;
      int var3 = class4.menuHeight;
      int var4 = 6116423;
      Rasterizer2D.method4923(var0, var1, var2, var3, var4);
      Rasterizer2D.method4923(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.method4945(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      XClanMember.field922.method4737("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = class59.field737;
      int var6 = class59.field738;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = var1 + 31 + (Client.menuOptionCount - 1 - var7) * 15;
         int var9 = 16777215;
         if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         XClanMember.field922.method4737(class61.method1022(var7), var0 + 3, var8, var9, 0);
      }

      class92.method1736(class67.menuX, WorldMapType3.menuY, class98.menuWidth, class4.menuHeight);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;IZI)LFrames;",
      garbageValue = "1133811310"
   )
   public static Frames method3070(IndexDataBase var0, IndexDataBase var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method4161(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method4116(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9 = var1.method4116(var8, 0);
            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;S)[LModIcon;",
      garbageValue = "-21469"
   )
   public static ModIcon[] method3071(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method4125(var1);
      int var4 = var0.method4126(var3, var2);
      ModIcon[] var5;
      if(!class7.method28(var0, var3, var4)) {
         var5 = null;
      } else {
         ModIcon[] var7 = new ModIcon[class286.field3791];

         for(int var8 = 0; var8 < class286.field3791; ++var8) {
            ModIcon var9 = var7[var8] = new ModIcon();
            var9.width = class286.field3790;
            var9.originalHeight = class286.field3792;
            var9.offsetX = class286.field3793[var8];
            var9.offsetY = class266.field3657[var8];
            var9.originalWidth = class233.field3205[var8];
            var9.height = ScriptState.field779[var8];
            var9.palette = class4.field33;
            var9.pixels = IndexFile.field2307[var8];
         }

         class251.method4451();
         var5 = var7;
      }

      return var5;
   }
}
