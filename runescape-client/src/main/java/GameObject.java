import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 635841177
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -679546869
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -89704105
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2124637843
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -794664543
   )
   @Export("flags")
   int flags = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -482191997
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1830302523
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 544477081
   )
   int field1738;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1227518657
   )
   int field1739;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 46906273
   )
   @Export("height")
   int height;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -733748801
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1528506441
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 95261857
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = -1664151529
   )
   static int field1745;
   @ObfuscatedName("v")
   public static String field1746;
   @ObfuscatedName("dz")
   @Export("xteaKeys")
   static int[][] xteaKeys;

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "1683296091"
   )
   static void method2286(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2806 == 0) {
         var0.width = var0.field2818;
      } else if(var0.field2806 == 1) {
         var0.width = var1 - var0.field2818;
      } else if(var0.field2806 == 2) {
         var0.width = var0.field2818 * var1 >> 14;
      }

      if(var0.field2815 == 0) {
         var0.height = var0.field2819;
      } else if(var0.field2815 == 1) {
         var0.height = var2 - var0.field2819;
      } else if(var0.field2815 == 2) {
         var0.height = var2 * var0.field2819 >> 14;
      }

      if(var0.field2806 == 4) {
         var0.width = var0.field2922 * var0.height / var0.field2917;
      }

      if(var0.field2815 == 4) {
         var0.height = var0.field2917 * var0.width / var0.field2922;
      }

      if(Client.field471 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field465 = var0;
      }

      if(var3 && null != var0.field2916 && (var0.width != var4 || var5 != var0.height)) {
         class0 var6 = new class0();
         var6.field2 = var0;
         var6.field8 = var0.field2916;
         Client.field353.method3963(var6);
      }

   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(LWidget;I)LWidget;",
      garbageValue = "39270046"
   )
   static Widget method2287(Widget var0) {
      Widget var1 = Sequence.method935(var0);
      if(var1 == null) {
         var1 = var0.parent;
      }

      return var1;
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIIB)V",
      garbageValue = "4"
   )
   @Export("generateMenuActionsForPlayer")
   static final void generateMenuActionsForPlayer(Player var0, int var1, int var2, int var3) {
      if(WidgetNode.localPlayer != var0 && Client.menuOptionCount < 400) {
         String var4;
         if(var0.field54 == 0) {
            var4 = var0.actions[0] + var0.name + var0.actions[1] + class136.method3003(var0.combatLevel, WidgetNode.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
         } else {
            var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field54 + ")" + var0.actions[2];
         }

         int var5;
         if(Client.field439 == 1) {
            class107.addMenuEntry("Use", Client.field447 + " " + "->" + " " + class16.method205(16777215) + var4, 14, var1, var2, var3);
         } else if(Client.field448) {
            if((World.field675 & 8) == 8) {
               class107.addMenuEntry(Client.field306, Client.field452 + " " + "->" + " " + class16.method205(16777215) + var4, 15, var1, var2, var3);
            }
         } else {
            for(var5 = 7; var5 >= 0; --var5) {
               if(null != Client.field422[var5]) {
                  short var6 = 0;
                  if(Client.field422[var5].equalsIgnoreCase("Attack")) {
                     if(class21.field589 == Client.field292) {
                        continue;
                     }

                     if(Client.field292 == class21.field587 || Client.field292 == class21.field590 && var0.combatLevel > WidgetNode.localPlayer.combatLevel) {
                        var6 = 2000;
                     }

                     if(WidgetNode.localPlayer.team != 0 && var0.team != 0) {
                        if(var0.team == WidgetNode.localPlayer.team) {
                           var6 = 2000;
                        } else {
                           var6 = 0;
                        }
                     }
                  } else if(Client.field423[var5]) {
                     var6 = 2000;
                  }

                  boolean var7 = false;
                  int var8 = Client.field421[var5] + var6;
                  class107.addMenuEntry(Client.field422[var5], class16.method205(16777215) + var4, var8, var1, var2, var3);
               }
            }
         }

         for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
            if(Client.menuTypes[var5] == 23) {
               Client.menuTargets[var5] = class16.method205(16777215) + var4;
               break;
            }
         }
      }

   }
}
