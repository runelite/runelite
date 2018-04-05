import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class155 extends class297 {
   @ObfuscatedName("pm")
   @ObfuscatedSignature(
      signature = "Ldf;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -750892181
   )
   static int field2162;
   @ObfuscatedName("o")
   final boolean field2163;

   public class155(boolean var1) {
      this.field2163 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;B)I",
      garbageValue = "60"
   )
   int method3160(ChatPlayer var1, ChatPlayer var2) {
      return var2.world != var1.world?(this.field2163?var1.world - var2.world:var2.world - var1.world):this.method5282(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3160((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2143770548"
   )
   public static void method3165() {
      class229.field2690.method4140();
      class229.field2687 = 1;
      class185.field2511 = null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Lll;",
      garbageValue = "-668334694"
   )
   static IndexedSprite method3159() {
      IndexedSprite var0 = new IndexedSprite();
      var0.originalWidth = class332.indexedSpriteWidth;
      var0.originalHeight = class332.indexedSpriteHeight;
      var0.offsetX = class332.indexedSpriteOffsetXs[0];
      var0.offsetY = FileSystem.indexedSpriteOffsetYs[0];
      var0.width = WorldMapDecoration.indexSpriteWidths[0];
      var0.height = class332.indexedSpriteHeights[0];
      var0.palette = class332.indexedSpritePalette;
      var0.pixels = class332.spritePixels[0];
      class36.method541();
      return var0;
   }
}
