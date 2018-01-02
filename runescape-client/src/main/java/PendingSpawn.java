import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   @Export("jagexLoginType")
   static JagexLoginType jagexLoginType;
   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   @Export("topContextMenuRow")
   static ContextMenuRow topContextMenuRow;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1314434327
   )
   @Export("level")
   int level;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1135806613
   )
   @Export("type")
   int type;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1534725047
   )
   @Export("x")
   int x;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2011832797
   )
   @Export("y")
   int y;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1155203191
   )
   int field1112;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1851868879
   )
   int field1113;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1968438559
   )
   int field1114;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -591865171
   )
   @Export("id")
   int id;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1702666337
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2067797229
   )
   int field1117;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1885900041
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1299482467
   )
   @Export("hitpoints")
   int hitpoints;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;B)V",
      garbageValue = "58"
   )
   public static void method1461(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILck;ZB)I",
      garbageValue = "127"
   )
   static int method1459(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         class82.intStackSize -= 3;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         int var5 = class82.intStack[class82.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = VertexNormal.getWidget(var3);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class139.field2008 = var12;
               } else {
                  AttackOption.field1306 = var12;
               }

               class33.method344(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class139.field2008:AttackOption.field1306;
            Widget var10 = VertexNormal.getWidget(var9.id);
            var10.children[var9.index] = null;
            class33.method344(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = VertexNormal.getWidget(class82.intStack[--class82.intStackSize]);
            var9.children = null;
            class33.method344(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = VertexNormal.getWidget(class82.intStack[--class82.intStackSize]);
               if(var9 != null) {
                  class82.intStack[++class82.intStackSize - 1] = 1;
                  if(var2) {
                     class139.field2008 = var9;
                  } else {
                     AttackOption.field1306 = var9;
                  }
               } else {
                  class82.intStack[++class82.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class82.intStackSize -= 2;
            var3 = class82.intStack[class82.intStackSize];
            var4 = class82.intStack[class82.intStackSize + 1];
            Widget var11 = TextureProvider.getWidgetChild(var3, var4);
            if(var11 != null && var4 != -1) {
               class82.intStack[++class82.intStackSize - 1] = 1;
               if(var2) {
                  class139.field2008 = var11;
               } else {
                  AttackOption.field1306 = var11;
               }
            } else {
               class82.intStack[++class82.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lcp;Lcp;IZIZI)I",
      garbageValue = "-262261266"
   )
   static int method1460(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = SceneMapObj.method268(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = SceneMapObj.method268(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(Lbj;ZI)V",
      garbageValue = "-1700483995"
   )
   static void method1462(Player var0, boolean var1) {
      if(var0 != null && var0.hasConfig() && !var0.hidden) {
         int var2 = var0.field810 << 14;
         var0.isLowDetail = false;
         if((Client.lowMemory && class94.playerIndexesCount > 50 || class94.playerIndexesCount > 200) && var1 && var0.idlePoseAnimation == var0.poseAnimation) {
            var0.isLowDetail = true;
         }

         int var3 = var0.x >> 7;
         int var4 = var0.y >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(var0.model != null && Client.gameCycle >= var0.animationCycleStart && Client.gameCycle < var0.animationCycleEnd) {
               var0.isLowDetail = false;
               var0.field816 = WorldMapType2.getTileHeight(var0.x, var0.y, BoundingBox2D.plane);
               class48.region.method2862(BoundingBox2D.plane, var0.x, var0.y, var0.field816, 60, var0, var0.angle, var2, var0.field823, var0.field824, var0.field825, var0.field828);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.field931[var3][var4] == Client.field932) {
                     return;
                  }

                  Client.field931[var3][var4] = Client.field932;
               }

               var0.field816 = WorldMapType2.getTileHeight(var0.x, var0.y, BoundingBox2D.plane);
               class48.region.method2701(BoundingBox2D.plane, var0.x, var0.y, var0.field816, 60, var0, var0.angle, var2, var0.field1170);
            }
         }
      }

   }
}
