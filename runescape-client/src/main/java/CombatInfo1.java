import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1785795855
   )
   int field1295;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1215146307
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 535612513
   )
   @Export("health")
   int health;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1584005299
   )
   int field1294;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field1295 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1294 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-30"
   )
   void method1546(int var1, int var2, int var3, int var4) {
      this.field1295 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1294 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lem;IIIII)V",
      garbageValue = "1076295667"
   )
   public static final void method1541(Model var0, int var1, int var2, int var3, int var4) {
      class7.field231.method3638(new class10(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(Lbg;II)V",
      garbageValue = "-1094769390"
   )
   static final void method1545(Actor var0, int var1) {
      if(var0.field1275 > Client.gameCycle) {
         int var2 = var0.field1275 - Client.gameCycle;
         int var3 = var0.field1233 * 64 + var0.field1271 * 128;
         int var4 = var0.field1229 * 128 + var0.field1233 * 64;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field1287 = 0;
         var0.orientation = var0.field1277;
      } else if(var0.field1276 >= Client.gameCycle) {
         Script.method1860(var0);
      } else {
         RSSocket.method3081(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1275 = 0;
         var0.field1276 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1233 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1233 * 64;
         var0.method1528();
      }

      if(Player.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1275 = 0;
         var0.field1276 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1233 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1233 * 64;
         var0.method1528();
      }

      class133.method2612(var0);
      class25.method207(var0);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIILiq;IS)V",
      garbageValue = "3921"
   )
   static void method1547(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class81 var5 = new class81();
      var5.field1326 = var0;
      var5.field1337 = var1 * 128;
      var5.field1328 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field1335 = (var6 + var1) * 128;
      var5.field1333 = (var7 + var2) * 128;
      var5.field1332 = var3.ambientSoundId;
      var5.field1331 = var3.field3479 * 128;
      var5.field1342 = var3.field3480;
      var5.field1330 = var3.field3461;
      var5.field1336 = var3.field3482;
      if(var3.impostorIds != null) {
         var5.field1339 = var3;
         var5.method1609();
      }

      class81.field1334.addFront(var5);
      if(var5.field1336 != null) {
         var5.field1325 = var5.field1342 + (int)(Math.random() * (double)(var5.field1330 - var5.field1342));
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1217768476"
   )
   static final int method1548(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
