import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
@Implements("TextureProvider")
public class TextureProvider implements ITextureLoader {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   static IndexedSprite field1790;
   @ObfuscatedName("fl")
   static byte[][] field1793;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 463571385
   )
   @Export("width")
   int width;
   @ObfuscatedName("o")
   @Export("brightness")
   double brightness;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Ldk;"
   )
   @Export("textures")
   Texture[] textures;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   @Export("deque")
   Deque deque;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1800261481
   )
   @Export("size")
   int size;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   @Export("sprites")
   IndexDataBase sprites;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1081175379
   )
   @Export("maxSize")
   int maxSize;

   @ObfuscatedSignature(
      signature = "(Lii;Lii;IDI)V"
   )
   public TextureProvider(IndexDataBase var1, IndexDataBase var2, int var3, double var4, int var6) {
      this.deque = new Deque();
      this.size = 0;
      this.brightness = 1.0D;
      this.width = 128;
      this.sprites = var2;
      this.maxSize = var3;
      this.size = this.maxSize;
      this.brightness = var4;
      this.width = var6;
      int[] var7 = var1.getChilds(0);
      int var8 = var7.length;
      this.textures = new Texture[var1.fileCount(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.getConfigData(0, var7[var9]));
         this.textures[var7[var9]] = new Texture(var10);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "382924969"
   )
   @Export("reset")
   public void reset() {
      for(int var1 = 0; var1 < this.textures.length; ++var1) {
         if(this.textures[var1] != null) {
            this.textures[var1].resetPixels();
         }
      }

      this.deque = new Deque();
      this.size = this.maxSize;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "664221956"
   )
   @Export("getAverageTextureRGB")
   public int getAverageTextureRGB(int var1) {
      return this.textures[var1] != null?this.textures[var1].field1893:0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "899946592"
   )
   @Export("load")
   public int[] load(int var1) {
      Texture var2 = this.textures[var1];
      if(var2 != null) {
         if(var2.pixels != null) {
            this.deque.addTail(var2);
            var2.loaded = true;
            return var2.pixels;
         }

         boolean var3 = var2.method2501(this.brightness, this.width, this.sprites);
         if(var3) {
            if(this.size == 0) {
               Texture var4 = (Texture)this.deque.popTail();
               var4.resetPixels();
            } else {
               --this.size;
            }

            this.deque.addTail(var2);
            var2.loaded = true;
            return var2.pixels;
         }
      }

      return null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "562063917"
   )
   public boolean vmethod2931(int var1) {
      return this.width == 64;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "811109479"
   )
   public boolean vmethod2928(int var1) {
      return this.textures[var1].field1887;
   }

   @ObfuscatedName("i")
   @Export("brightness")
   public void brightness(double var1) {
      this.brightness = var1;
      this.reset();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "2"
   )
   public void method2398(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.field1892 != 0 && var3.loaded) {
            var3.method2503(var1);
            var3.loaded = false;
         }
      }

   }
}
