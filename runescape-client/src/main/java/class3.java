import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
final class class3 implements Comparator {
   @ObfuscatedName("o")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-15"
   )
   public static void method19(boolean var0) {
      if(null != class185.field2770) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class185.field2770.method2105(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class185.field2770.method2113();
            } catch (Exception var3) {
               ;
            }

            ++class185.field2782;
            class185.field2770 = null;
         }

      }
   }

   public int compare(Object var1, Object var2) {
      return this.method28((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LCipherBuffer;I)V",
      garbageValue = "-1361293869"
   )
   static final void method22(CipherBuffer var0) {
      int var1 = 0;
      var0.method3102();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class45.field923; ++var2) {
         var3 = class45.field918[var2];
         if((class45.field926[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class45.field926[var3] = (byte)(class45.field926[var3] | 2);
            } else {
               var4 = var0.method3111(1);
               if(var4 == 0) {
                  var1 = ChatLineBuffer.method938(var0);
                  class45.field926[var3] = (byte)(class45.field926[var3] | 2);
               } else {
                  class8.method90(var0, var3);
               }
            }
         }
      }

      var0.method3103();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method3102();

         for(var2 = 0; var2 < class45.field923; ++var2) {
            var3 = class45.field918[var2];
            if((class45.field926[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class45.field926[var3] = (byte)(class45.field926[var3] | 2);
               } else {
                  var4 = var0.method3111(1);
                  if(var4 == 0) {
                     var1 = ChatLineBuffer.method938(var0);
                     class45.field926[var3] = (byte)(class45.field926[var3] | 2);
                  } else {
                     class8.method90(var0, var3);
                  }
               }
            }
         }

         var0.method3103();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method3102();

            for(var2 = 0; var2 < class45.field925; ++var2) {
               var3 = class45.field934[var2];
               if((class45.field926[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class45.field926[var3] = (byte)(class45.field926[var3] | 2);
                  } else {
                     var4 = var0.method3111(1);
                     if(var4 == 0) {
                        var1 = ChatLineBuffer.method938(var0);
                        class45.field926[var3] = (byte)(class45.field926[var3] | 2);
                     } else if(class60.method1182(var0, var3)) {
                        class45.field926[var3] = (byte)(class45.field926[var3] | 2);
                     }
                  }
               }
            }

            var0.method3103();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method3102();

               for(var2 = 0; var2 < class45.field925; ++var2) {
                  var3 = class45.field934[var2];
                  if((class45.field926[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class45.field926[var3] = (byte)(class45.field926[var3] | 2);
                     } else {
                        var4 = var0.method3111(1);
                        if(var4 == 0) {
                           var1 = ChatLineBuffer.method938(var0);
                           class45.field926[var3] = (byte)(class45.field926[var3] | 2);
                        } else if(class60.method1182(var0, var3)) {
                           class45.field926[var3] = (byte)(class45.field926[var3] | 2);
                        }
                     }
                  }
               }

               var0.method3103();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class45.field923 = 0;
                  class45.field925 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class45.field926[var2] = (byte)(class45.field926[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class45.field918[++class45.field923 - 1] = var2;
                     } else {
                        class45.field934[++class45.field925 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)[Lclass177;",
      garbageValue = "0"
   )
   public static class177[] method23() {
      return new class177[]{class177.field2692, class177.field2694, class177.field2683, class177.field2684, class177.field2680, class177.field2681};
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "-193118310"
   )
   static final void method24(Player var0, int var1, int var2, int var3) {
      if(Projectile.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.field261 == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + RSCanvas.method2130(var0.combatLevel, Projectile.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field261 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field455 == 1) {
               class119.addMenuEntry("Use", Client.field457 + " " + "->" + " " + XItemContainer.method153(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field458) {
               if((ItemComposition.field3004 & 8) == 8) {
                  class119.addMenuEntry(Client.field326, Client.field527 + " " + "->" + " " + XItemContainer.method153(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(null != Client.playerOptions[var5]) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(class40.field827 == Client.field328) {
                           continue;
                        }

                        if(class40.field830 == Client.field328 || Client.field328 == class40.field829 && var0.combatLevel > Projectile.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(Projectile.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == Projectile.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriority[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = Client.field420[var5] + var6;
                     class119.addMenuEntry(Client.playerOptions[var5], XItemContainer.method153(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = XItemContainer.method153(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[IB)V",
      garbageValue = "25"
   )
   static void method25(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var1 + var2) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method632()?1:0;
                     var12 = var8.method632()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method632()?1:0;
                     var12 = var8.method632()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method25(var0, var1, var6, var3, var4);
         method25(var0, 1 + var6, var2, var3, var4);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LGameEngine;B)V",
      garbageValue = "-16"
   )
   static void method26(GameEngine var0) {
      if(class115.field1823 == 1 || !class177.field2687 && class115.field1823 == 4) {
         int var1 = 280 + class41.field859;
         if(class115.field1825 >= var1 && class115.field1825 <= var1 + 14 && class115.field1813 >= 4 && class115.field1813 <= 18) {
            class20.method186(0, 0);
            return;
         }

         if(class115.field1825 >= 15 + var1 && class115.field1825 <= var1 + 80 && class115.field1813 >= 4 && class115.field1813 <= 18) {
            class20.method186(0, 1);
            return;
         }

         int var2 = 390 + class41.field859;
         if(class115.field1825 >= var2 && class115.field1825 <= 14 + var2 && class115.field1813 >= 4 && class115.field1813 <= 18) {
            class20.method186(1, 0);
            return;
         }

         if(class115.field1825 >= 15 + var2 && class115.field1825 <= var2 + 80 && class115.field1813 >= 4 && class115.field1813 <= 18) {
            class20.method186(1, 1);
            return;
         }

         int var3 = class41.field859 + 500;
         if(class115.field1825 >= var3 && class115.field1825 <= var3 + 14 && class115.field1813 >= 4 && class115.field1813 <= 18) {
            class20.method186(2, 0);
            return;
         }

         if(class115.field1825 >= var3 + 15 && class115.field1825 <= var3 + 80 && class115.field1813 >= 4 && class115.field1813 <= 18) {
            class20.method186(2, 1);
            return;
         }

         int var4 = 610 + class41.field859;
         if(class115.field1825 >= var4 && class115.field1825 <= var4 + 14 && class115.field1813 >= 4 && class115.field1813 <= 18) {
            class20.method186(3, 0);
            return;
         }

         if(class115.field1825 >= var4 + 15 && class115.field1825 <= var4 + 80 && class115.field1813 >= 4 && class115.field1813 <= 18) {
            class20.method186(3, 1);
            return;
         }

         if(class115.field1825 >= class41.field859 + 708 && class115.field1813 >= 4 && class115.field1825 <= 50 + 708 + class41.field859 && class115.field1813 <= 20) {
            class41.worldSelectShown = false;
            class41.field838.method4141(class41.field859, 0);
            class1.field7.method4141(382 + class41.field859, 0);
            class41.field839.method4088(382 + class41.field859 - class41.field839.originalWidth / 2, 18);
            return;
         }

         if(class41.field866 != -1) {
            World var5 = World.worldList[class41.field866];
            class142.method2750(var5);
            class41.worldSelectShown = false;
            class41.field838.method4141(class41.field859, 0);
            class1.field7.method4141(class41.field859 + 382, 0);
            class41.field839.method4088(382 + class41.field859 - class41.field839.originalWidth / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass182;II)Z",
      garbageValue = "1591255650"
   )
   static boolean method27(class182 var0, int var1) {
      byte[] var2 = var0.method3389(var1);
      if(null == var2) {
         return false;
      } else {
         class184.method3451(var2);
         return true;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;S)I",
      garbageValue = "8369"
   )
   int method28(class2 var1, class2 var2) {
      return var1.field19.totalQuantity < var2.field19.totalQuantity?-1:(var1.field19.totalQuantity == var2.field19.totalQuantity?0:1);
   }
}
