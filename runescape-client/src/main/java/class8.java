import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public final class class8 extends class9 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1302847551
   )
   final int field241;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 109322883
   )
   final int field242;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 13962393
   )
   final int field244;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -979153529
   )
   final int field245;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = -1954231835
   )
   static int field246;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1965263191
   )
   final int field247;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1403509867"
   )
   public final void vmethod44() {
      Rasterizer2D.method4945(Rasterizer2D.field3757 + this.field242, Rasterizer2D.field3752 + this.field247, this.field241 - this.field242, this.field244 - this.field247, this.field245);
   }

   class8(int var1, int var2, int var3, int var4, int var5) {
      this.field242 = var1;
      this.field247 = var2;
      this.field241 = var3;
      this.field244 = var4;
      this.field245 = var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)LWorld;",
      garbageValue = "1374543584"
   )
   static World method32() {
      return World.field1322 < World.field1326?World.worldList[++World.field1322 - 1]:null;
   }
}
