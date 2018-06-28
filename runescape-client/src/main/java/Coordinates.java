import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 327374529
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -510649741
   )
   @Export("worldX")
   public int worldX;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 104556867
   )
   @Export("worldY")
   public int worldY;

   @ObfuscatedSignature(
      signature = "(Lhh;)V"
   )
   public Coordinates(Coordinates var1) {
      this.plane = var1.plane;
      this.worldX = var1.worldX;
      this.worldY = var1.worldY;
   }

   public Coordinates(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   public Coordinates() {
      this.plane = -1;
   }

   public Coordinates(int var1) {
      if(var1 == -1) {
         this.plane = -1;
      } else {
         this.plane = var1 >> 28 & 3;
         this.worldX = var1 >> 14 & 16383;
         this.worldY = var1 & 16383;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "62"
   )
   @Export("set")
   public void set(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "92"
   )
   @Export("bitpack")
   public int bitpack() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lhh;I)Z",
      garbageValue = "-1581452973"
   )
   boolean method4468(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "-37"
   )
   String method4470(String var1) {
      return this.plane + var1 + (this.worldX >> 6) + var1 + (this.worldY >> 6) + var1 + (this.worldX & 63) + var1 + (this.worldY & 63);
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method4468((Coordinates)var1));
   }

   public int hashCode() {
      return this.bitpack();
   }

   public String toString() {
      return this.method4470(",");
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "741148208"
   )
   public static boolean method4482(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)[Llc;",
      garbageValue = "2024020127"
   )
   static SpritePixels[] method4483() {
      SpritePixels[] var0 = new SpritePixels[class319.indexedSpriteCount];

      for(int var1 = 0; var1 < class319.indexedSpriteCount; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class319.indexedSpriteWidth;
         var2.maxHeight = class275.indexedSpriteHeight;
         var2.offsetX = class319.indexedSpriteOffsetXs[var1];
         var2.offsetY = class319.indexedSpriteOffsetYs[var1];
         var2.width = class192.indexSpriteWidths[var1];
         var2.height = class319.indexedSpriteHeights[var1];
         int var3 = var2.width * var2.height;
         byte[] var4 = class294.spritePixels[var1];
         var2.pixels = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.pixels[var5] = class319.indexedSpritePalette[var4[var5] & 255];
         }
      }

      class319.indexedSpriteOffsetXs = null;
      class319.indexedSpriteOffsetYs = null;
      class192.indexSpriteWidths = null;
      class319.indexedSpriteHeights = null;
      class319.indexedSpritePalette = null;
      class294.spritePixels = null;
      return var0;
   }
}
