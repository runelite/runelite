import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("c")
   boolean field211 = false;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1346181913
   )
   int field212;
   @ObfuscatedName("ck")
   static class102 field213;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2043062997
   )
   @Export("id")
   int id;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      longValue = -2573240277744781123L
   )
   static long field216;
   @ObfuscatedName("e")
   static class179 field218;

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-2113931816"
   )
   static final void method205(Actor var0, int var1) {
      if(var0.field671 > Client.gameCycle) {
         class88.method1936(var0);
      } else if(var0.field647 >= Client.gameCycle) {
         RSCanvas.method2138(var0);
      } else {
         Player.method268(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field671 = 0;
         var0.field647 = 0;
         var0.x = 128 * var0.pathX[0] + var0.field672 * 64;
         var0.y = 128 * var0.pathY[0] + var0.field672 * 64;
         var0.method616();
      }

      if(var0 == class22.localPlayer && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field671 = 0;
         var0.field647 = 0;
         var0.x = var0.field672 * 64 + 128 * var0.pathX[0];
         var0.y = var0.field672 * 64 + 128 * var0.pathY[0];
         var0.method616();
      }

      if(var0.field678 != 0) {
         if(var0.interacting != -1) {
            Object var5 = null;
            if(var0.interacting < '耀') {
               var5 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var5 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(null != var5) {
               int var3 = var0.x - ((Actor)var5).x;
               int var4 = var0.y - ((Actor)var5).y;
               if(var3 != 0 || var4 != 0) {
                  var0.field676 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field652) {
               var0.interacting = -1;
               var0.field652 = false;
            }
         }

         if(var0.field653 != -1 && (var0.field679 == 0 || var0.field683 > 0)) {
            var0.field676 = var0.field653;
            var0.field653 = -1;
         }

         int var2 = var0.field676 - var0.angle & 2047;
         if(var2 == 0 && var0.field652) {
            var0.interacting = -1;
            var0.field652 = false;
         }

         if(var2 != 0) {
            ++var0.field675;
            boolean var7;
            if(var2 > 1024) {
               var0.angle -= var0.field678;
               var7 = true;
               if(var2 < var0.field678 || var2 > 2048 - var0.field678) {
                  var0.angle = var0.field676;
                  var7 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field675 > 25 || var7)) {
                  if(var0.field684 != -1) {
                     var0.poseAnimation = var0.field684;
                  } else {
                     var0.poseAnimation = var0.field667;
                  }
               }
            } else {
               var0.angle += var0.field678;
               var7 = true;
               if(var2 < var0.field678 || var2 > 2048 - var0.field678) {
                  var0.angle = var0.field676;
                  var7 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field675 > 25 || var7)) {
                  if(var0.field632 != -1) {
                     var0.poseAnimation = var0.field632;
                  } else {
                     var0.poseAnimation = var0.field667;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field675 = 0;
         }
      }

      class38.method812(var0);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-2031511331"
   )
   static int method206(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = World.method670(class32.field756[--class32.field752]);
      } else {
         var3 = var2?class26.field624:class32.field754;
      }

      String var4 = class32.scriptStringStack[--class9.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var8 = class32.field756[--class32.field752];
         if(var8 > 0) {
            for(var5 = new int[var8]; var8-- > 0; var5[var8] = class32.field756[--class32.field752]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var6 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var6.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var6[var7] = class32.scriptStringStack[--class9.scriptStringStackSize];
         } else {
            var6[var7] = new Integer(class32.field756[--class32.field752]);
         }
      }

      var7 = class32.field756[--class32.field752];
      if(var7 != -1) {
         var6[0] = new Integer(var7);
      } else {
         var6 = null;
      }

      if(var0 == 1400) {
         var3.field2268 = var6;
      } else if(var0 == 1401) {
         var3.field2271 = var6;
      } else if(var0 == 1402) {
         var3.field2309 = var6;
      } else if(var0 == 1403) {
         var3.field2272 = var6;
      } else if(var0 == 1404) {
         var3.field2274 = var6;
      } else if(var0 == 1405) {
         var3.field2275 = var6;
      } else if(var0 == 1406) {
         var3.field2278 = var6;
      } else if(var0 == 1407) {
         var3.field2279 = var6;
         var3.field2280 = var5;
      } else if(var0 == 1408) {
         var3.field2285 = var6;
      } else if(var0 == 1409) {
         var3.field2286 = var6;
      } else if(var0 == 1410) {
         var3.field2303 = var6;
      } else if(var0 == 1411) {
         var3.field2253 = var6;
      } else if(var0 == 1412) {
         var3.field2273 = var6;
      } else if(var0 == 1414) {
         var3.field2281 = var6;
         var3.field2205 = var5;
      } else if(var0 == 1415) {
         var3.field2283 = var6;
         var3.field2245 = var5;
      } else if(var0 == 1416) {
         var3.field2277 = var6;
      } else if(var0 == 1417) {
         var3.field2317 = var6;
      } else if(var0 == 1418) {
         var3.field2288 = var6;
      } else if(var0 == 1419) {
         var3.field2289 = var6;
      } else if(var0 == 1420) {
         var3.field2290 = var6;
      } else if(var0 == 1421) {
         var3.field2291 = var6;
      } else if(var0 == 1422) {
         var3.field2292 = var6;
      } else if(var0 == 1423) {
         var3.field2293 = var6;
      } else if(var0 == 1424) {
         var3.field2294 = var6;
      } else if(var0 == 1425) {
         var3.field2296 = var6;
      } else if(var0 == 1426) {
         var3.field2299 = var6;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2295 = var6;
      }

      var3.field2178 = true;
      return 1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "333886217"
   )
   public static void method207() {
      Object var0 = class183.field2725;
      synchronized(class183.field2725) {
         if(class183.field2718 != 0) {
            class183.field2718 = 1;

            try {
               class183.field2725.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-267560240"
   )
   static final void method208(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field311; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field518[var4] = true;
         }
      }

   }
}
