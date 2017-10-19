import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public final class class10 extends class9 {
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = -368899267
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 107240741
   )
   public static int field268;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1704824157
   )
   final int field265;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1776350297
   )
   final int field273;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1443305465
   )
   final int field266;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1393811009
   )
   final int field269;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 459839033
   )
   final int field267;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1228618253
   )
   final int field270;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 92009349
   )
   final int field271;

   @ObfuscatedSignature(
      signature = "(Leh;IIII)V"
   )
   class10(Model var1, int var2, int var3, int var4, int var5) {
      this.field265 = var2 + var1.field1967 - var1.field1964;
      this.field266 = var3 + var1.field1943 - var1.field1946;
      this.field267 = var4 + var1.field1944 - var1.field1947;
      this.field273 = var2 + var1.field1964 + var1.field1967;
      this.field269 = var3 + var1.field1946 + var1.field1943;
      this.field270 = var4 + var1.field1947 + var1.field1944;
      this.field271 = var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2004882891"
   )
   public final void vmethod57() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.field265:this.field273;
         int var2 = (var4 & 2) == 0?this.field266:this.field269;
         int var3 = (var4 & 4) == 0?this.field267:this.field270;
         if((var4 & 1) == 0) {
            class21.method163(var1, var2, var3, this.field273, var2, var3, this.field271);
         }

         if((var4 & 2) == 0) {
            class21.method163(var1, var2, var3, var1, this.field269, var3, this.field271);
         }

         if((var4 & 4) == 0) {
            class21.method163(var1, var2, var3, var1, var2, this.field270, this.field271);
         }
      }

   }
}
