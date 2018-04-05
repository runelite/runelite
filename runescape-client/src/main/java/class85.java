import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class85 {
   @ObfuscatedName("h")
   static final BigInteger field1322;
   @ObfuscatedName("m")
   static final BigInteger field1323;

   static {
      field1322 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1323 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1165451474"
   )
   public static void method1887() {
      Spotanim.spotanims.reset();
      Spotanim.SpotAnimationDefinition_cachedModels.reset();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[Lld;",
      garbageValue = "798286224"
   )
   static SpritePixels[] method1886() {
      SpritePixels[] var0 = new SpritePixels[class332.indexedSpriteCount];

      for(int var1 = 0; var1 < class332.indexedSpriteCount; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class332.indexedSpriteWidth;
         var2.maxHeight = class332.indexedSpriteHeight;
         var2.offsetX = class332.indexedSpriteOffsetXs[var1];
         var2.offsetY = FileSystem.indexedSpriteOffsetYs[var1];
         var2.width = WorldMapDecoration.indexSpriteWidths[var1];
         var2.height = class332.indexedSpriteHeights[var1];
         int var3 = var2.height * var2.width;
         byte[] var4 = class332.spritePixels[var1];
         var2.pixels = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.pixels[var5] = class332.indexedSpritePalette[var4[var5] & 255];
         }
      }

      class36.method541();
      return var0;
   }
}
