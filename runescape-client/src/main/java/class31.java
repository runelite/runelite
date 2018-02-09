import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class31 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Lbs;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1884190427
   )
   static int field425;
   @ObfuscatedName("an")
   static int[] field424;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 452860795
   )
   final int field419;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1053715011
   )
   final int field423;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1131360409
   )
   final int field421;

   class31(int var1, int var2, int var3) {
      this.field419 = var1;
      this.field423 = var2;
      this.field421 = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Lkh;",
      garbageValue = "364820352"
   )
   static IndexedSprite[] method270() {
      IndexedSprite[] var0 = new IndexedSprite[class310.field3909];

      for(int var1 = 0; var1 < class310.field3909; ++var1) {
         IndexedSprite var2 = var0[var1] = new IndexedSprite();
         var2.width = class310.field3908;
         var2.originalHeight = class310.field3910;
         var2.offsetX = class219.field2698[var1];
         var2.offsetY = class263.offsetsY[var1];
         var2.originalWidth = class60.field708[var1];
         var2.height = class310.field3911[var1];
         var2.palette = class289.field3786;
         var2.pixels = class310.spritePixels[var1];
      }

      Name.method5282();
      return var0;
   }
}
