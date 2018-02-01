import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -50434875
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1698904917
   )
   @Export("x")
   int x;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1757699383
   )
   @Export("y")
   int y;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -588276949
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ldg;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1849306135
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Leo;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("q")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1249728633
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1326835837
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("y")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("d")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("l")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -378639003
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 531201003
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1156876317
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2135894193
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   @Export("bridge")
   Tile bridge;

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.entityFlags = new int[5];
      this.flags = 0;
      this.renderLevel = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public static void method2654() {
      class265.field3471.reset();
      class265.field3480.reset();
      class265.field3473.reset();
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-1662823757"
   )
   static final void method2653(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != MessageNode.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class48.region.method2895(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class48.region.method2873(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class48.region.method2839(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class48.region.method2840(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class48.region.getObjectFlags(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class48.region.removeBoundaryObject(var0, var2, var3);
               var12 = TextureProvider.getObjectDefinition(var13);
               if(var12.clipType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var14, var15, var12.blocksProjectile);
               }
            }

            if(var1 == 1) {
               class48.region.removeWallDecoration(var0, var2, var3);
            }

            if(var1 == 2) {
               class48.region.method2830(var0, var2, var3);
               var12 = TextureProvider.getObjectDefinition(var13);
               if(var2 + var12.width > 103 || var3 + var12.width > 103 || var2 + var12.length > 103 || var3 + var12.length > 103) {
                  return;
               }

               if(var12.clipType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.width, var12.length, var15, var12.blocksProjectile);
               }
            }

            if(var1 == 3) {
               class48.region.removeFloorDecoration(var0, var2, var3);
               var12 = TextureProvider.getObjectDefinition(var13);
               if(var12.clipType == 1) {
                  Client.collisionMaps[var0].method3253(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class36.method504(var0, var11, var2, var3, var4, var5, var6, class48.region, Client.collisionMaps[var0]);
         }
      }

   }
}
