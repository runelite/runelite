import java.awt.Font;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class43 extends CacheableNode {
   @ObfuscatedName("q")
   public static NodeCache field987 = new NodeCache(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -988092583
   )
   int field988 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 134918303
   )
   public int field989;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -812749859
   )
   public int field990;
   @ObfuscatedName("mu")
   static byte field991;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = -1698871357
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2121396709
   )
   public int field995;
   @ObfuscatedName("h")
   static class215 field996;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 567426853
   )
   public int field998;
   @ObfuscatedName("k")
   public static class170 field999;
   @ObfuscatedName("qj")
   protected static Font field1000;

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1587100051"
   )
   static final void method876(boolean var0) {
      for(int var1 = 0; var1 < Client.field319; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field501[var1]];
         int var3 = 536870912 + (Client.field501[var1] << 14);
         if(var2 != null && var2.vmethod774() && var2.composition.isVisible == var0 && var2.composition.method823()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field841 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field386 == Client.field385[var4][var5]) {
                     continue;
                  }

                  Client.field385[var4][var5] = Client.field386;
               }

               if(!var2.composition.field926) {
                  var3 -= Integer.MIN_VALUE;
               }

               Frames.region.method1972(class145.plane, var2.x, var2.y, class109.method2439(var2.x + (var2.field841 * 64 - 64), var2.y + (var2.field841 * 64 - 64), class145.plane), 60 + (var2.field841 * 64 - 64), var2, var2.angle, var3, var2.field828);
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "968792770"
   )
   void method877(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field988 = var1.method2575();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-59"
   )
   public static int method879(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1367903260"
   )
   public void method881(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.method2571();
         if(var3 == 0) {
            return;
         }

         this.method877(var1, var3, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1141662202"
   )
   public void method884() {
      this.method891(this.field988);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;ZI)V",
      garbageValue = "1941160828"
   )
   public static void method888(class170 var0, class170 var1, boolean var2) {
      ObjectComposition.field935 = var0;
      ObjectComposition.field936 = var1;
      ObjectComposition.field966 = var2;
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIIB)V",
      garbageValue = "-109"
   )
   static final void method890(Player var0, int var1, int var2, int var3) {
      if(class165.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.field28 == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + ChatMessages.method226(var0.combatLevel, class165.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field28 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field497 == 1) {
               class5.addMenuEntry("Use", Client.field434 + " " + "->" + " " + class144.method3013(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field435) {
               if((class145.field2220 & 8) == 8) {
                  class5.addMenuEntry(Client.field328, Client.field439 + " " + "->" + " " + class144.method3013(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.field408[var5] != null) {
                     short var6 = 0;
                     if(Client.field408[var5].equalsIgnoreCase("Attack")) {
                        if(class21.field573 == Client.field559) {
                           continue;
                        }

                        if(class21.field571 == Client.field559 || Client.field559 == class21.field577 && var0.combatLevel > class165.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class165.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class165.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.field409[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = Client.field459[var5] + var6;
                     class5.addMenuEntry(Client.field408[var5], class144.method3013(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class144.method3013(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-521064590"
   )
   void method891(int var1) {
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
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field995 = (int)(256.0D * var14);
      this.field990 = (int)(var16 * 256.0D);
      if(this.field995 < 0) {
         this.field995 = 0;
      } else if(this.field995 > 255) {
         this.field995 = 255;
      }

      if(this.field990 < 0) {
         this.field990 = 0;
      } else if(this.field990 > 255) {
         this.field990 = 255;
      }

      if(var16 > 0.5D) {
         this.field998 = (int)((1.0D - var16) * var14 * 512.0D);
      } else {
         this.field998 = (int)(512.0D * var14 * var16);
      }

      if(this.field998 < 1) {
         this.field998 = 1;
      }

      this.field989 = (int)((double)this.field998 * var12);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Lclass51;",
      garbageValue = "128705188"
   )
   public static class51 method892(int var0) {
      class51 var1 = (class51)class51.field1112.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class51.field1115.method3305(32, var0);
         var1 = new class51();
         if(null != var2) {
            var1.method1045(new Buffer(var2));
         }

         class51.field1112.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2013420713"
   )
   static final int method893(int var0, int var1) {
      int var2 = class26.method613(var0 - 1, var1 - 1) + class26.method613(1 + var0, var1 - 1) + class26.method613(var0 - 1, 1 + var1) + class26.method613(1 + var0, 1 + var1);
      int var3 = class26.method613(var0 - 1, var1) + class26.method613(1 + var0, var1) + class26.method613(var0, var1 - 1) + class26.method613(var0, 1 + var1);
      int var4 = class26.method613(var0, var1);
      return var3 / 8 + var2 / 16 + var4 / 4;
   }
}
