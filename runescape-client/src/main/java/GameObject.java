import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1866751847
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1840593029
   )
   @Export("height")
   int height;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1087761421
   )
   @Export("x")
   int x;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1063628249
   )
   @Export("y")
   int y;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1672836637
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1610249375
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1511254367
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 19135965
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 235575925
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 792465583
   )
   @Export("drawPriority")
   int drawPriority;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -833063441
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1044473627
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 195247177
   )
   @Export("flags")
   int flags;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-360058868"
   )
   static final void method2909(int var0) {
      short var1 = 256;
      class91.field1321 += var0 * 128;
      int var2;
      if(class91.field1321 > class36.field478.length) {
         class91.field1321 -= class36.field478.length;
         var2 = (int)(Math.random() * 12.0D);
         CombatInfoListHolder.method1623(class234.runeSprites[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class89.field1302[var2 + var3] - class36.field478[var2 + class91.field1321 & class36.field478.length - 1] * var0 / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class89.field1302[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class89.field1302[var7 + var6] = 255;
            } else {
               class89.field1302[var6 + var7] = 0;
            }
         }
      }

      if(class91.field1323 > 0) {
         class91.field1323 -= var0 * 4;
      }

      if(class91.field1327 > 0) {
         class91.field1327 -= var0 * 4;
      }

      if(class91.field1323 == 0 && class91.field1327 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class91.field1323 = 1024;
         }

         if(var5 == 1) {
            class91.field1327 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class91.field1324[var5] = class91.field1324[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class91.field1324[var5] = (int)(Math.sin((double)class91.field1342 / 14.0D) * 16.0D + Math.sin((double)class91.field1342 / 15.0D) * 14.0D + Math.sin((double)class91.field1342 / 16.0D) * 12.0D);
         ++class91.field1342;
      }

      class91.field1350 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class91.field1350 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class89.field1302[var7 + (var8 << 7)] = 192;
         }

         class91.field1350 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var5 + var9 < 128) {
                  var7 += class89.field1302[var9 + var8 + var5];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= class89.field1302[var9 + var8 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  BoundingBox.field238[var9 + var8] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var5 + var8 < var1) {
                  var7 += BoundingBox.field238[var9 + var6 + var5 * 128];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= BoundingBox.field238[var9 + var6 - (var5 + 1) * 128];
               }

               if(var8 >= 0) {
                  class89.field1302[var9 + var6] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }
}
