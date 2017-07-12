import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public final class class10 extends class9 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 231072645
   )
   final int field252;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1567545477
   )
   final int field253;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1125016273
   )
   final int field254;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 577740585
   )
   final int field255;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 953326563
   )
   final int field256;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1595372943
   )
   final int field257;
   @ObfuscatedName("o")
   static int[] field258;
   @ObfuscatedName("ci")
   static IndexData field259;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 992425755
   )
   final int field260;

   class10(Model var1, int var2, int var3, int var4, int var5) {
      this.field260 = var2 + var1.field1969 - var1.field1966;
      this.field252 = var3 + var1.field1989 - var1.field1967;
      this.field253 = var4 + var1.field1932 - var1.field1968;
      this.field254 = var2 + var1.field1969 + var1.field1966;
      this.field255 = var3 + var1.field1989 + var1.field1967;
      this.field256 = var4 + var1.field1932 + var1.field1968;
      this.field257 = var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "366399750"
   )
   final void vmethod50() {
      for(int var1 = 0; var1 < 8; ++var1) {
         int var2 = (var1 & 1) == 0?this.field260:this.field254;
         int var3 = (var1 & 2) == 0?this.field252:this.field255;
         int var4 = (var1 & 4) == 0?this.field253:this.field256;
         int var5;
         int var6;
         int[] var7;
         int[] var8;
         if((var1 & 1) == 0) {
            var5 = this.field254;
            var6 = this.field257;
            var7 = Region.method2796(var2, var3, var4);
            var8 = Region.method2796(var5, var3, var4);
            Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
         }

         if((var1 & 2) == 0) {
            var5 = this.field255;
            var6 = this.field257;
            var7 = Region.method2796(var2, var3, var4);
            var8 = Region.method2796(var2, var5, var4);
            Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
         }

         if((var1 & 4) == 0) {
            var5 = this.field256;
            var6 = this.field257;
            var7 = Region.method2796(var2, var3, var4);
            var8 = Region.method2796(var2, var3, var5);
            Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
         }
      }

   }
}
