import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public class class258 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Lln;",
      garbageValue = "-51"
   )
   static Sprite method4900() {
      Sprite var0 = new Sprite();
      var0.width = class328.indexedSpriteWidth;
      var0.height = class328.indexedSpriteHeight;
      var0.yOffset = class328.indexedSpriteOffsetXs[0];
      var0.xOffset = class328.indexedSpriteOffsetYs[0];
      var0.subWidth = VarbitDefinition.indexedSpriteWidths[0];
      var0.subHeight = SecureRandomCallable.indexedSpriteHeights[0];
      int var1 = var0.subHeight * var0.subWidth;
      byte[] var2 = class328.spritePixels[0];
      var0.pixels = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.pixels[var3] = class328.indexedSpritePalette[var2[var3] & 255];
      }

      class328.indexedSpriteOffsetXs = null;
      class328.indexedSpriteOffsetYs = null;
      VarbitDefinition.indexedSpriteWidths = null;
      SecureRandomCallable.indexedSpriteHeights = null;
      class328.indexedSpritePalette = null;
      class328.spritePixels = null;
      return var0;
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "772902595"
   )
   static final void method4898(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class68 var9 = null;

      for(class68 var10 = (class68)Client.__client_kh.last(); var10 != null; var10 = (class68)Client.__client_kh.previous()) {
         if(var0 == var10.field911 && var10.field913 == var1 && var2 == var10.field901 && var3 == var10.field906) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class68();
         var9.field911 = var0;
         var9.field906 = var3;
         var9.field913 = var1;
         var9.field901 = var2;
         class13.method165(var9);
         Client.__client_kh.addFirst(var9);
      }

      var9.field899 = var4;
      var9.field908 = var5;
      var9.field907 = var6;
      var9.field909 = var7;
      var9.field910 = var8;
   }
}
