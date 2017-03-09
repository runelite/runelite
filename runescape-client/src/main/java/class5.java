import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
final class class5 implements Comparator {
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = -532571113
   )
   static int field58;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method79((class2)var1, (class2)var2);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1453130922"
   )
   static void method67(String var0, String var1, String var2) {
      class41.loginMessage1 = var0;
      class41.loginMessage2 = var1;
      class41.loginMessage3 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "38"
   )
   static final int method75(int var0, int var1) {
      int var2 = class0.method14(var0 - 1, var1 - 1) + class0.method14(1 + var0, var1 - 1) + class0.method14(var0 - 1, var1 + 1) + class0.method14(var0 + 1, 1 + var1);
      int var3 = class0.method14(var0 - 1, var1) + class0.method14(var0 + 1, var1) + class0.method14(var0, var1 - 1) + class0.method14(var0, var1 + 1);
      int var4 = class0.method14(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([Lclass158;IB)Lclass158;",
      garbageValue = "0"
   )
   public static class158 method77(class158[] var0, int var1) {
      class158[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class158 var4 = var2[var3];
         if(var1 == var4.vmethod4085()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2079291205"
   )
   static final int method78() {
      if(class8.field84.field717) {
         return class31.plane;
      } else {
         int var0 = 3;
         if(class25.cameraPitch < 310) {
            int var1 = class65.cameraX >> 7;
            int var2 = CombatInfoListHolder.cameraY >> 7;
            int var3 = class22.localPlayer.x >> 7;
            int var4 = class22.localPlayer.y >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class31.plane;
            }

            if((class10.tileSettings[class31.plane][var1][var2] & 4) != 0) {
               var0 = class31.plane;
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

                  if((class10.tileSettings[class31.plane][var1][var2] & 4) != 0) {
                     var0 = class31.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class10.tileSettings[class31.plane][var1][var2] & 4) != 0) {
                        var0 = class31.plane;
                     }
                  }
               }
            } else {
               var7 = 65536 * var5 / var6;
               var8 = '耀';

               while(var2 != var4) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class10.tileSettings[class31.plane][var1][var2] & 4) != 0) {
                     var0 = class31.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class10.tileSettings[class31.plane][var1][var2] & 4) != 0) {
                        var0 = class31.plane;
                     }
                  }
               }
            }
         }

         if(class22.localPlayer.x >= 0 && class22.localPlayer.y >= 0 && class22.localPlayer.x < 13312 && class22.localPlayer.y < 13312) {
            if((class10.tileSettings[class31.plane][class22.localPlayer.x >> 7][class22.localPlayer.y >> 7] & 4) != 0) {
               var0 = class31.plane;
            }

            return var0;
         } else {
            return class31.plane;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "1371655328"
   )
   int method79(class2 var1, class2 var2) {
      return var1.field25.price < var2.field25.price?-1:(var2.field25.price == var1.field25.price?0:1);
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZB)V",
      garbageValue = "34"
   )
   static final void method80(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            if(var6) {
               Client.field391 = Client.menuOptionCount;
            }

            ++Client.menuOptionCount;
         }

      }
   }
}
