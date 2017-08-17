import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
public enum class258 implements RSEnum {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   field3533(1, 0),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   field3535(2, 1),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   field3534(0, 2);

   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -729722963
   )
   public final int field3532;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -30169901
   )
   final int field3536;

   class258(int var3, int var4) {
      this.field3532 = var3;
      this.field3536 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "316484705"
   )
   public int rsOrdinal() {
      return this.field3536;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)[Ljr;",
      garbageValue = "-1316988462"
   )
   static IndexedSprite[] method4663() {
      IndexedSprite[] var0 = new IndexedSprite[class287.field3780];

      for(int var1 = 0; var1 < class287.field3780; ++var1) {
         IndexedSprite var2 = var0[var1] = new IndexedSprite();
         var2.width = class287.field3779;
         var2.originalHeight = ISAACCipher.field2435;
         var2.offsetX = class287.field3781[var1];
         var2.offsetY = class211.offsetsY[var1];
         var2.originalWidth = class266.field3647[var1];
         var2.height = class287.field3782[var1];
         var2.palette = class287.field3783;
         var2.pixels = class274.spritePixels[var1];
      }

      class287.field3781 = null;
      class211.offsetsY = null;
      class266.field3647 = null;
      class287.field3782 = null;
      class287.field3783 = null;
      class274.spritePixels = null;
      return var0;
   }
}
