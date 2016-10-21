import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1873107217
   )
   @Export("x")
   int x;
   @ObfuscatedName("ml")
   static SpritePixels field1660;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 898190197
   )
   int field1661;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 643139285
   )
   int field1662;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1072882195
   )
   int field1663;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 638445877
   )
   @Export("y")
   int y;
   @ObfuscatedName("c")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -810290483
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 831390747
   )
   int field1667 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1676685211
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("k")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1786294855
   )
   int field1670;
   @ObfuscatedName("ii")
   static Widget field1672;

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "2126749748"
   )
   static final void method2203(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class9.region.method2044(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class9.region.method1994(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = field1660.image;
         var11 = 2048 * (103 - var2) + var1 * 4 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = class8.getObjectDefinition(var12);
         if(var13.field949 != -1) {
            ModIcon var14 = class24.field623[var13.field949];
            if(var14 != null) {
               int var15 = (var13.field936 * 4 - var14.originalWidth) / 2;
               int var16 = (var13.field937 * 4 - var14.height) / 2;
               var14.method1913(48 + var1 * 4 + var15, 48 + (104 - var2 - var13.field937) * 4 + var16);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 3 + 512] = var9;
                  var10[1024 + var11 + 3] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[1536 + var11 + 2] = var9;
                  var10[1536 + var11 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[1536 + 3 + var11] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[512 + 3 + var11] = var9;
                  var10[var11 + 3 + 1024] = var9;
                  var10[1536 + 3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[1536 + var11 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class9.region.method2123(var0, var1, var2);
      if(var5 != 0) {
         var6 = class9.region.method1994(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class8.getObjectDefinition(var9);
         int var19;
         if(var23.field949 != -1) {
            ModIcon var17 = class24.field623[var23.field949];
            if(null != var17) {
               var12 = (var23.field936 * 4 - var17.originalWidth) / 2;
               var19 = (var23.field937 * 4 - var17.height) / 2;
               var17.method1913(var12 + 48 + 4 * var1, 48 + 4 * (104 - var2 - var23.field937) + var19);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var18 = field1660.image;
            var19 = (103 - var2) * 2048 + 4 * var1 + 24624;
            if(var7 != 0 && var7 != 2) {
               var18[var19] = var11;
               var18[1 + var19 + 512] = var11;
               var18[var19 + 1024 + 2] = var11;
               var18[1536 + var19 + 3] = var11;
            } else {
               var18[var19 + 1536] = var11;
               var18[1 + 1024 + var19] = var11;
               var18[var19 + 512 + 2] = var11;
               var18[var19 + 3] = var11;
            }
         }
      }

      var5 = class9.region.method2026(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var20 = class8.getObjectDefinition(var6);
         if(var20.field949 != -1) {
            ModIcon var21 = class24.field623[var20.field949];
            if(var21 != null) {
               var9 = (var20.field936 * 4 - var21.originalWidth) / 2;
               int var22 = (var20.field937 * 4 - var21.height) / 2;
               var21.method1913(4 * var1 + 48 + var9, 4 * (104 - var2 - var20.field937) + 48 + var22);
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-85"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class11.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method668(var0, var1, var2, var3);
      class11.field167.method3882(var5, (long)var5.id);
      class11.field174.method3918(var5);
      Client.field325 = Client.field295;
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "-777769918"
   )
   static final void method2205(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.field913 != null) {
            var0 = var0.method798();
         }

         if(var0 != null) {
            if(var0.field916) {
               if(!var0.field898 || Client.field447 == var1) {
                  String var4 = var0.name;
                  int var8;
                  if(var0.combatLevel != 0) {
                     int var7 = var0.combatLevel;
                     var8 = class34.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var10;
                     if(var9 < -9) {
                        var10 = class92.method2126(16711680);
                     } else if(var9 < -6) {
                        var10 = class92.method2126(16723968);
                     } else if(var9 < -3) {
                        var10 = class92.method2126(16740352);
                     } else if(var9 < 0) {
                        var10 = class92.method2126(16756736);
                     } else if(var9 > 9) {
                        var10 = class92.method2126('\uff00');
                     } else if(var9 > 6) {
                        var10 = class92.method2126(4259584);
                     } else if(var9 > 3) {
                        var10 = class92.method2126(8453888);
                     } else if(var9 > 0) {
                        var10 = class92.method2126(12648192);
                     } else {
                        var10 = class92.method2126(16776960);
                     }

                     var4 = var4 + var10 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(Client.field432 == 1) {
                     Player.addMenuEntry("Use", Client.field433 + " " + "->" + " " + class92.method2126(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field434) {
                     if((class221.field3210 & 2) == 2) {
                        Player.addMenuEntry(Client.field492, Client.field438 + " " + "->" + " " + class92.method2126(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.actions;
                     if(Client.field450) {
                        var5 = class8.method111(var5);
                     }

                     int var6;
                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && !var5[var6].equalsIgnoreCase("Attack")) {
                              byte var11 = 0;
                              if(var6 == 0) {
                                 var11 = 9;
                              }

                              if(var6 == 1) {
                                 var11 = 10;
                              }

                              if(var6 == 2) {
                                 var11 = 11;
                              }

                              if(var6 == 3) {
                                 var11 = 12;
                              }

                              if(var6 == 4) {
                                 var11 = 13;
                              }

                              Player.addMenuEntry(var5[var6], class92.method2126(16776960) + var4, var11, var1, var2, var3);
                           }
                        }
                     }

                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && var5[var6].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(Client.field320 != class21.field578) {
                                 if(Client.field320 == class21.field579 || class21.field581 == Client.field320 && var0.combatLevel > class34.localPlayer.combatLevel) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(var6 == 0) {
                                    var8 = 9 + var12;
                                 }

                                 if(var6 == 1) {
                                    var8 = var12 + 10;
                                 }

                                 if(var6 == 2) {
                                    var8 = var12 + 11;
                                 }

                                 if(var6 == 3) {
                                    var8 = var12 + 12;
                                 }

                                 if(var6 == 4) {
                                    var8 = 13 + var12;
                                 }

                                 Player.addMenuEntry(var5[var6], class92.method2126(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     Player.addMenuEntry("Examine", class92.method2126(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }
}
