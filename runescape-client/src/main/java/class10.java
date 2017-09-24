import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public final class class10 extends class9 {
   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   static class148 field264;
   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "[Lkd;"
   )
   @Export("pkIcons")
   static SpritePixels[] pkIcons;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1761665601
   )
   final int field266;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1860339831
   )
   final int field259;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1207710427
   )
   final int field257;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1932930275
   )
   final int field265;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 613098399
   )
   final int field256;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 805369403
   )
   final int field261;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1020217981
   )
   final int field262;

   @ObfuscatedSignature(
      signature = "(Lem;IIII)V"
   )
   class10(Model var1, int var2, int var3, int var4, int var5) {
      this.field266 = var2 + var1.field1963 - var1.field1975;
      this.field257 = var3 + var1.field1932 - var1.field1982;
      this.field256 = var4 + var1.field1965 - var1.field1968;
      this.field259 = var2 + var1.field1963 + var1.field1975;
      this.field265 = var3 + var1.field1982 + var1.field1932;
      this.field261 = var4 + var1.field1965 + var1.field1968;
      this.field262 = var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-56481943"
   )
   public final void vmethod58() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.field266:this.field259;
         int var2 = (var4 & 2) == 0?this.field257:this.field265;
         int var3 = (var4 & 4) == 0?this.field256:this.field261;
         if((var4 & 1) == 0) {
            class37.method526(var1, var2, var3, this.field259, var2, var3, this.field262);
         }

         if((var4 & 2) == 0) {
            class37.method526(var1, var2, var3, var1, this.field265, var3, this.field262);
         }

         if((var4 & 4) == 0) {
            class37.method526(var1, var2, var3, var1, var2, this.field261, this.field262);
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lii;Ljava/lang/String;Ljava/lang/String;I)[Lkd;",
      garbageValue = "-2096693165"
   )
   public static SpritePixels[] method62(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class40.method576(var0, var3, var4);
   }
}
