import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("BoundingBox3D")
public final class BoundingBox3D extends BoundingBox {
   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      signature = "Lll;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("slStarSprites")
   static IndexedSprite[] slStarSprites;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1861114873
   )
   @Export("int1")
   final int int1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2012900661
   )
   @Export("int2")
   final int int2;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 281041455
   )
   @Export("int3")
   final int int3;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 788713727
   )
   @Export("int4")
   final int int4;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 520475771
   )
   @Export("int5")
   final int int5;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -410584357
   )
   @Export("int6")
   final int int6;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1149564663
   )
   @Export("color")
   final int color;

   @ObfuscatedSignature(
      signature = "(Lee;IIII)V"
   )
   BoundingBox3D(Model var1, int var2, int var3, int var4, int var5) {
      this.int1 = var2 + var1.centerX - var1.extremeX;
      this.int2 = var3 + var1.centerY - var1.extremeY;
      this.int3 = var4 + var1.centerZ - var1.extremeZ;
      this.int4 = var2 + var1.extremeX + var1.centerX;
      this.int5 = var3 + var1.centerY + var1.extremeY;
      this.int6 = var4 + var1.extremeZ + var1.centerZ;
      this.color = var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2133791811"
   )
   public final void vmethod48() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.int1:this.int4;
         int var2 = (var4 & 2) == 0?this.int2:this.int5;
         int var3 = (var4 & 4) == 0?this.int3:this.int6;
         if((var4 & 1) == 0) {
            class234.method4415(var1, var2, var3, this.int4, var2, var3, this.color);
         }

         if((var4 & 2) == 0) {
            class234.method4415(var1, var2, var3, var1, this.int5, var3, this.color);
         }

         if((var4 & 4) == 0) {
            class234.method4415(var1, var2, var3, var1, var2, this.int6, this.color);
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-2059698736"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }
}
