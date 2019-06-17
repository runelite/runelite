import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lg")
@Implements("SpriteIds")
public class SpriteIds {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1673796151
   )
   @Export("__m")
   public int __m;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 159591367
   )
   @Export("__f")
   public int __f;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -104203005
   )
   @Export("mapScenes")
   public int mapScenes;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1052769237
   )
   @Export("headIconsPk")
   public int headIconsPk;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1744250043
   )
   @Export("headIconsPrayer")
   public int headIconsPrayer;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 185111653
   )
   @Export("headIconsHint")
   public int headIconsHint;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1217061337
   )
   @Export("mapMarkers")
   public int mapMarkers;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 536911453
   )
   @Export("crosses")
   public int crosses;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1114417319
   )
   @Export("mapDots")
   public int mapDots;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -919662109
   )
   @Export("scrollBars")
   public int scrollBars;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2043130323
   )
   @Export("modIcons")
   public int modIcons;

   public SpriteIds() {
      this.__m = -1;
      this.__f = -1;
      this.mapScenes = -1;
      this.headIconsPk = -1;
      this.headIconsPrayer = -1;
      this.headIconsHint = -1;
      this.mapMarkers = -1;
      this.crosses = -1;
      this.mapDots = -1;
      this.scrollBars = -1;
      this.modIcons = -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;I)V",
      garbageValue = "1764356022"
   )
   @Export("read")
   public void read(AbstractIndexCache var1) {
      byte[] var2 = var1.takeRecordFlat(class311.field3810.field3809);
      Buffer var3 = new Buffer(var2);

      while(true) {
         int var4 = var3.readUnsignedByte();
         if(var4 == 0) {
            return;
         }

         switch(var4) {
         case 1:
            var3.readMedium();
            break;
         case 2:
            this.__m = var3.__ap_310();
            this.__f = var3.__ap_310();
            this.mapScenes = var3.__ap_310();
            this.headIconsPk = var3.__ap_310();
            this.headIconsPrayer = var3.__ap_310();
            this.headIconsHint = var3.__ap_310();
            this.mapMarkers = var3.__ap_310();
            this.crosses = var3.__ap_310();
            this.mapDots = var3.__ap_310();
            this.scrollBars = var3.__ap_310();
            this.modIcons = var3.__ap_310();
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;III)Lkk;",
      garbageValue = "195396240"
   )
   public static Font method5823(AbstractIndexCache var0, AbstractIndexCache var1, int var2, int var3) {
      if(!SpriteMask.method4392(var0, var2, var3)) {
         return null;
      } else {
         byte[] var4 = var1.takeRecord(var2, var3);
         Font var5;
         if(var4 == null) {
            var5 = null;
         } else {
            Font var6 = new Font(var4, class328.indexedSpriteOffsetXs, class328.indexedSpriteOffsetYs, VarbitDefinition.indexedSpriteWidths, SecureRandomCallable.indexedSpriteHeights, class328.indexedSpritePalette, class328.spritePixels);
            class328.indexedSpriteOffsetXs = null;
            class328.indexedSpriteOffsetYs = null;
            VarbitDefinition.indexedSpriteWidths = null;
            SecureRandomCallable.indexedSpriteHeights = null;
            class328.indexedSpritePalette = null;
            class328.spritePixels = (byte[][])null;
            var5 = var6;
         }

         return var5;
      }
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(Lbz;B)V",
      garbageValue = "58"
   )
   static final void method5828(Actor var0) {
      int var1 = var0.__bw - Client.cycle;
      int var2 = var0.__bf * 128 + var0.size * 64;
      int var3 = var0.__be * 128 + var0.size * 64;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.__cq = 0;
      var0.orientation = var0.__cv;
   }
}
