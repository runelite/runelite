import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
public final class class94 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 549251397
   )
   int field1565;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1174715419
   )
   int field1566;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -305646789
   )
   int field1567;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -44066099
   )
   int field1568;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1766037167
   )
   int field1569;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2034536789
   )
   int field1570;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1141360357
   )
   int field1571;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -14730885
   )
   int field1572;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -651104059
   )
   int field1573;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 28555737
   )
   int field1574;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -547239509
   )
   int field1575;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1522309915
   )
   int field1576;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2014415491
   )
   int field1577;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -479786901
   )
   int field1578;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1985032413
   )
   int field1579;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -224435669
   )
   int field1580;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1385661443
   )
   int field1581;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -581941113
   )
   int field1582;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 928652953
   )
   public static int field1584;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Lclass200;",
      garbageValue = "-1303328508"
   )
   public static class200 method1867(int var0) {
      class200 var1 = (class200)class200.field3044.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class200.field3039.method3203(4, var0);
         var1 = new class200();
         if(var2 != null) {
            var1.method3648(new Buffer(var2), var0);
         }

         var1.method3647();
         class200.field3044.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-1"
   )
   static final boolean method1868(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-77533207"
   )
   public static boolean method1869(int var0, int var1) {
      return (var0 >> 1 + var1 & 1) != 0;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-208187886"
   )
   static final int method1870() {
      if(XGrandExchangeOffer.field35.field699) {
         return class63.plane;
      } else {
         int var0 = 3;
         if(WidgetNode.cameraPitch < 310) {
            int var1 = class110.cameraX >> 7;
            int var2 = class16.cameraY >> 7;
            int var3 = class5.localPlayer.x >> 7;
            int var4 = class5.localPlayer.y >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class63.plane;
            }

            if((class10.tileSettings[class63.plane][var1][var2] & 4) != 0) {
               var0 = class63.plane;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = var6 * 65536 / var5;
               var8 = '耀';

               while(var1 != var3) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class10.tileSettings[class63.plane][var1][var2] & 4) != 0) {
                     var0 = class63.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class10.tileSettings[class63.plane][var1][var2] & 4) != 0) {
                        var0 = class63.plane;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = '耀';

               while(var4 != var2) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class10.tileSettings[class63.plane][var1][var2] & 4) != 0) {
                     var0 = class63.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class10.tileSettings[class63.plane][var1][var2] & 4) != 0) {
                        var0 = class63.plane;
                     }
                  }
               }
            }
         }

         if(class5.localPlayer.x >= 0 && class5.localPlayer.y >= 0 && class5.localPlayer.x < 13312 && class5.localPlayer.y < 13312) {
            if((class10.tileSettings[class63.plane][class5.localPlayer.x >> 7][class5.localPlayer.y >> 7] & 4) != 0) {
               var0 = class63.plane;
            }

            return var0;
         } else {
            return class63.plane;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "1"
   )
   public static int method1871(int var0) {
      var0 = (var0 >>> 1 & 1431655765) + (var0 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = (var0 >>> 4) + var0 & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "-1019254303"
   )
   static final void method1872(Player var0, int var1, int var2, int var3) {
      if(class5.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.field254 == 0) {
               String var10 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = class5.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class16.method182(16711680);
               } else if(var9 < -6) {
                  var6 = class16.method182(16723968);
               } else if(var9 < -3) {
                  var6 = class16.method182(16740352);
               } else if(var9 < 0) {
                  var6 = class16.method182(16756736);
               } else if(var9 > 9) {
                  var6 = class16.method182('\uff00');
               } else if(var9 > 6) {
                  var6 = class16.method182(4259584);
               } else if(var9 > 3) {
                  var6 = class16.method182(8453888);
               } else if(var9 > 0) {
                  var6 = class16.method182(12648192);
               } else {
                  var6 = class16.method182(16776960);
               }

               var4 = var10 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field254 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field437 == 1) {
               class48.addMenuEntry("Use", Client.field438 + " " + "->" + " " + class16.method182(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field439) {
               if((class116.field1837 & 8) == 8) {
                  class48.addMenuEntry(Client.field562, Client.field443 + " " + "->" + " " + class16.method182(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(null != Client.field413[var5]) {
                     short var11 = 0;
                     if(Client.field413[var5].equalsIgnoreCase("Attack")) {
                        if(class40.field824 == Client.field376) {
                           continue;
                        }

                        if(class40.field818 == Client.field376 || Client.field376 == class40.field821 && var0.combatLevel > class5.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if(class5.localPlayer.team != 0 && var0.team != 0) {
                           if(class5.localPlayer.team == var0.team) {
                              var11 = 2000;
                           } else {
                              var11 = 0;
                           }
                        }
                     } else if(Client.field373[var5]) {
                        var11 = 2000;
                     }

                     boolean var12 = false;
                     var7 = Client.field412[var5] + var11;
                     class48.addMenuEntry(Client.field413[var5], class16.method182(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class16.method182(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
