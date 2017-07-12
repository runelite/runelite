import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
public final class class82 extends Node {
   @ObfuscatedName("i")
   static Deque field1349;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1051222987
   )
   int field1338;
   @ObfuscatedName("r")
   ObjectComposition field1345;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1720722111
   )
   int field1344;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2126725121
   )
   int field1347;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 66226405
   )
   int field1348;
   @ObfuscatedName("z")
   int[] field1353;
   @ObfuscatedName("e")
   class117 field1346;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1336452109
   )
   int field1352;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1522915565
   )
   int field1340;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 32616749
   )
   int field1343;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1293001177
   )
   int field1341;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2144107343
   )
   int field1339;
   @ObfuscatedName("c")
   class117 field1351;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1676533379
   )
   int field1350;

   static {
      field1349 = new Deque();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "66"
   )
   void method1617() {
      int var1 = this.field1338;
      ObjectComposition var2 = this.field1345.getImpostor();
      if(var2 != null) {
         this.field1338 = var2.ambientSoundId;
         this.field1344 = var2.field3491 * 128;
         this.field1347 = var2.field3492;
         this.field1348 = var2.field3493;
         this.field1353 = var2.field3494;
      } else {
         this.field1338 = -1;
         this.field1344 = 0;
         this.field1347 = 0;
         this.field1348 = 0;
         this.field1353 = null;
      }

      if(var1 != this.field1338 && this.field1346 != null) {
         class19.field328.method1887(this.field1346);
         this.field1346 = null;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-11"
   )
   static void method1625() {
      if(class1.loadWorlds()) {
         class92.worldSelectShown = true;
      }

   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1776884771"
   )
   static final void method1616(boolean var0) {
      for(int var1 = 0; var1 < Client.field937; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method4666()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1242 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field1058[var4][var5] == Client.field957) {
                     continue;
                  }

                  Client.field1058[var4][var5] = Client.field957;
               }

               if(!var2.composition.field3588) {
                  var3 -= Integer.MIN_VALUE;
               }

               class2.region.method2677(WallObject.plane, var2.x, var2.y, WorldMapData.getTileHeight(var2.field1242 * 64 - 64 + var2.x, var2.field1242 * 64 - 64 + var2.y, WallObject.plane), var2.field1242 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1267);
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILIndexDataBase;IIIZI)V",
      garbageValue = "1681101811"
   )
   public static void method1628(int var0, IndexDataBase var1, int var2, int var3, int var4, boolean var5) {
      class203.field2508 = 1;
      class61.field785 = var1;
      class203.field2511 = var2;
      class203.field2512 = var3;
      class203.field2513 = var4;
      class203.field2515 = var5;
      class203.field2517 = var0;
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "934153680"
   )
   static final void method1626(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = WorldMapData.getTileHeight(var0, var1, WallObject.plane) - var2;
         var0 -= class155.cameraX;
         var3 -= class60.cameraZ;
         var1 -= class157.cameraY;
         int var4 = Graphics3D.SINE[Player.cameraPitch];
         int var5 = Graphics3D.COSINE[Player.cameraPitch];
         int var6 = Graphics3D.SINE[class22.cameraYaw];
         int var7 = Graphics3D.COSINE[class22.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var4 * var1 >> 16;
         var1 = var3 * var4 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.screenY = var0 * Client.scale / var1 + Client.viewportHeight / 2;
            Client.screenX = Client.viewportWidth / 2 + Client.scale * var8 / var1;
         } else {
            Client.screenY = -1;
            Client.screenX = -1;
         }

      } else {
         Client.screenY = -1;
         Client.screenX = -1;
      }
   }
}
