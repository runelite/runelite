import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
@Implements("Ignore")
public class Ignore extends Nameable {
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = 591646507
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 335077035
   )
   int field3839;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkt;B)I",
      garbageValue = "-58"
   )
   int method5380(Ignore var1) {
      return this.field3839 - var1.field3839;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lkv;I)I",
      garbageValue = "-1435662815"
   )
   public int vmethod5444(Nameable var1) {
      return this.method5380((Ignore)var1);
   }

   public int compareTo(Object var1) {
      return this.method5380((Ignore)var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Llk;",
      garbageValue = "-32"
   )
   static IndexedSprite method5387() {
      IndexedSprite var0 = new IndexedSprite();
      var0.width = class332.field3995;
      var0.originalHeight = class332.field3996;
      var0.offsetX = class90.field1360[0];
      var0.offsetY = class153.offsetsY[0];
      var0.originalWidth = class332.field3998[0];
      var0.height = GrandExchangeOffer.field294[0];
      var0.palette = class332.field3994;
      var0.pixels = ClassInfo.spritePixels[0];
      class316.method5605();
      return var0;
   }
}
