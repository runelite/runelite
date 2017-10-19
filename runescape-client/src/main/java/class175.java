import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class175 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -2949231290816300145L
   )
   static long field2403;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 4437018352818201081L
   )
   static long field2404;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljo;",
      garbageValue = "543434979"
   )
   static IndexedSprite method3460() {
      IndexedSprite var0 = new IndexedSprite();
      var0.width = class287.field3809;
      var0.originalHeight = class287.field3807;
      var0.offsetX = class287.field3808[0];
      var0.offsetY = class21.offsetsY[0];
      var0.originalWidth = class287.field3806[0];
      var0.height = class56.field700[0];
      var0.palette = class114.field1675;
      var0.pixels = class227.spritePixels[0];
      class249.method4493();
      return var0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1092213840"
   )
   public static void method3455(int var0) {
      MouseInput.mouseIdleTicks = var0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-18176"
   )
   public static final void method3459() {
      class132.field1988 = false;
      class132.field1981 = 0;
   }
}
