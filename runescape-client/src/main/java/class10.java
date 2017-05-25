import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public final class class10 extends class9 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1778372685
   )
   final int field254;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -965919075
   )
   final int field255;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -723096627
   )
   final int field256;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1237451555
   )
   final int field257;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1626507769
   )
   final int field258;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1524180513
   )
   final int field259;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -830223607
   )
   final int field260;
   @ObfuscatedName("gv")
   static SpritePixels[] field261;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;LIndexDataBase;Lclass204;I)Z",
      garbageValue = "295222076"
   )
   public static boolean method42(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, class204 var3) {
      class203.field2496 = var0;
      class203.field2503 = var1;
      class203.field2502 = var2;
      class36.field501 = var3;
      return true;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-911944324"
   )
   final void vmethod43() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.field260:this.field256;
         int var2 = (var4 & 2) == 0?this.field255:this.field257;
         int var3 = (var4 & 4) == 0?this.field254:this.field258;
         if((var4 & 1) == 0) {
            class177.method3454(var1, var2, var3, this.field256, var2, var3, this.field259);
         }

         if((var4 & 2) == 0) {
            class177.method3454(var1, var2, var3, var1, this.field257, var3, this.field259);
         }

         if((var4 & 4) == 0) {
            class177.method3454(var1, var2, var3, var1, var2, this.field258, this.field259);
         }
      }

   }

   class10(Model var1, int var2, int var3, int var4, int var5) {
      this.field260 = var1.field1919 + var2 - var1.field1963;
      this.field255 = var3 + var1.field1941 - var1.field1956;
      this.field254 = var4 + var1.field1942 - var1.field1945;
      this.field256 = var2 + var1.field1919 + var1.field1963;
      this.field257 = var1.field1956 + var1.field1941 + var3;
      this.field258 = var1.field1945 + var1.field1942 + var4;
      this.field259 = var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-223869245"
   )
   public static int method45() {
      return ++class59.mouseIdleTicks - 1;
   }
}
