import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -762093045
   )
   int field1312;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -911511291
   )
   int field1313;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 542622381
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("z")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("h")
   class77 field1317;
   @ObfuscatedName("n")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("f")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1235694445
   )
   int field1320;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1727481985
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -416435617
   )
   int field1322;
   @ObfuscatedName("e")
   Tile field1323;
   @ObfuscatedName("p")
   int[] field1324 = new int[5];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1031853713
   )
   int field1325 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2060725395
   )
   @Export("x")
   int x;
   @ObfuscatedName("y")
   boolean field1327;
   @ObfuscatedName("w")
   boolean field1328;
   @ObfuscatedName("m")
   boolean field1329;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 390196237
   )
   int field1330;
   @ObfuscatedName("r")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1115057971
   )
   int field1332;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 137026403
   )
   int field1333;
   @ObfuscatedName("k")
   class85 field1334;

   Tile(int var1, int var2, int var3) {
      this.field1332 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LModIcon;B)V",
      garbageValue = "33"
   )
   static final void method1607(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < Buffer.field2088.length; ++var2) {
         Buffer.field2088[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         Buffer.field2088[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               class13.field130[var5] = (Buffer.field2088[var5 + 128] + Buffer.field2088[var5 + 1] + Buffer.field2088[var5 - 1] + Buffer.field2088[var5 - 128]) / 4;
            }
         }

         int[] var8 = Buffer.field2088;
         Buffer.field2088 = class13.field130;
         class13.field130 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var0.offsetX + var4 + 16;
                  int var6 = var3 + 16 + var0.offsetY;
                  int var7 = (var6 << 7) + var5;
                  Buffer.field2088[var7] = 0;
               }
            }
         }
      }

   }
}
