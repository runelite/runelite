import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -72604677
   )
   @Export("type")
   int type;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1418021977
   )
   @Export("x")
   int x;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -205612967
   )
   @Export("y")
   int y;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2124617679
   )
   int field1202;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2137500001
   )
   @Export("level")
   int level;
   @ObfuscatedName("in")
   static Widget field1204;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 288760971
   )
   @Export("id")
   int id;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -233112685
   )
   int field1207;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 554127361
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1035715197
   )
   int field1211;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1009362479
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -276221133
   )
   @Export("hitpoints")
   int hitpoints;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -355898623
   )
   int field1214;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZIZI)I",
      garbageValue = "1824236157"
   )
   static int method1481(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class56.method809(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class56.method809(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1001724018"
   )
   static final void method1482() {
      for(GraphicsObject var0 = (GraphicsObject)Client.field1048.method3622(); var0 != null; var0 = (GraphicsObject)Client.field1048.method3608()) {
         if(var0.level == class92.plane && !var0.field1361) {
            if(Client.gameCycle >= var0.field1365) {
               var0.method1654(Client.field990);
               if(var0.field1361) {
                  var0.unlink();
               } else {
                  class61.region.method2686(var0.level, var0.x, var0.y, var0.height, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }
}
