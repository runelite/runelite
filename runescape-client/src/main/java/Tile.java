import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = -130247403
   )
   static int field1832;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -933014925
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 372148033
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -259436571
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2024927675
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Leq;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ldj;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1278960999
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Lep;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("t")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -503006599
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 848908507
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("q")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("v")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("f")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -794908549
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -461980623
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -23689347
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1744785451
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lew;"
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([Lbq;II[I[II)V",
      garbageValue = "1964219701"
   )
   static void method2753(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
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
                     var11 = var0[var6].method1653()?1:0;
                     var12 = var8.method1653()?1:0;
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
                     var11 = var0[var5].method1653()?1:0;
                     var12 = var8.method1653()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
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

         method2753(var0, var1, var6, var3, var4);
         method2753(var0, var6 + 1, var2, var3, var4);
      }

   }
}
