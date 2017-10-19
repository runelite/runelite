import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("BaseVarType")
public enum BaseVarType implements RSEnum {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   @Export("INTEGER")
   INTEGER(0, 0, Integer.class, new class2()),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   @Export("LONG")
   LONG(1, 1, Long.class, new class3()),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   @Export("STRING")
   STRING(2, 2, String.class, new class5());

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1185107347
   )
   final int field37;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 993275761
   )
   final int field40;
   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static IndexData field41;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Lw;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.field40 = var3;
      this.field37 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   public int rsOrdinal() {
      return this.field37;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "751605406"
   )
   public static void method13() {
      Varbit.varbits.reset();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1257741605"
   )
   static final void method9() {
      short var0 = 256;
      int var1;
      if(class90.field1423 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class90.field1423 > 768) {
               Signlink.field2231[var1] = class34.method475(class294.field3916[var1], class17.field322[var1], 1024 - class90.field1423);
            } else if(class90.field1423 > 256) {
               Signlink.field2231[var1] = class17.field322[var1];
            } else {
               Signlink.field2231[var1] = class34.method475(class17.field322[var1], class294.field3916[var1], 256 - class90.field1423);
            }
         }
      } else if(class90.field1424 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class90.field1424 > 768) {
               Signlink.field2231[var1] = class34.method475(class294.field3916[var1], class219.field2789[var1], 1024 - class90.field1424);
            } else if(class90.field1424 > 256) {
               Signlink.field2231[var1] = class219.field2789[var1];
            } else {
               Signlink.field2231[var1] = class34.method475(class219.field2789[var1], class294.field3916[var1], 256 - class90.field1424);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            Signlink.field2231[var1] = class294.field3916[var1];
         }
      }

      Rasterizer2D.setDrawRegion(class90.field1413, 9, class90.field1413 + 128, var0 + 7);
      class90.field1427.method5172(class90.field1413, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      int var2 = GameEngine.field733.width * 9 + class90.field1413;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class90.field1443[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class90.field1425[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = Signlink.field2231[var7];
               var10 = GameEngine.field733.pixels[var2];
               GameEngine.field733.pixels[var2++] = (var8 * (var7 & 65280) + var9 * (var10 & 65280) & 16711680) + ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + GameEngine.field733.width - 128;
      }

      Rasterizer2D.setDrawRegion(class90.field1413 + 765 - 128, 9, class90.field1413 + 765, var0 + 7);
      class8.field250.method5172(class90.field1413 + 382, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      var2 = GameEngine.field733.width * 9 + class90.field1413 + 637 + 24;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class90.field1443[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class90.field1425[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = Signlink.field2231[var7];
               var10 = GameEngine.field733.pixels[var2];
               GameEngine.field733.pixels[var2++] = ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) + (var9 * (var10 & 65280) + var8 * (var7 & 65280) & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += GameEngine.field733.width - var5 - var4;
      }

   }
}
