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

      for (int var3 = 0; var3 < var1; ++var3) {
         var0.pixels[var3] = class328.indexedSpritePalette[var2[var3] & 255];
      }

      class328.indexedSpriteOffsetXs = null;
      class328.indexedSpriteOffsetYs = null;
      VarbitDefinition.indexedSpriteWidths = null;
      SecureRandomCallable.indexedSpriteHeights = null;
      class328.indexedSpritePalette = null;
      class328.spritePixels = (byte[][])null;
      return var0;
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "772902595"
   )
   static final void method4898(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for (PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.last(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.previous()) {
         if (var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if (var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         class13.method165(var9);
         Client.pendingSpawns.addFirst(var9);
      }

      var9.id = var4;
      var9.field908 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }
}
