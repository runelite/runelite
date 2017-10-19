import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("TextureProvider")
public class TextureProvider implements ITextureLoader {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 543891083
   )
   @Export("width")
   int width;
   @ObfuscatedName("g")
   @Export("brightness")
   double brightness;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Ldu;"
   )
   @Export("textures")
   Texture[] textures;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("deque")
   Deque deque;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1360794351
   )
   @Export("size")
   int size;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1757174191
   )
   @Export("maxSize")
   int maxSize;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("sprites")
   IndexDataBase sprites;

   @ObfuscatedSignature(
      signature = "(Lip;Lip;IDI)V"
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-12356"
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1098741737"
   )
   @Export("getAverageTextureRGB")
   public int getAverageTextureRGB(int var1) {
      return this.textures[var1] != null?this.textures[var1].field1864:0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IS)[I",
      garbageValue = "255"
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

         boolean var3 = var2.method2544(this.brightness, this.width, this.sprites);
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1046953986"
   )
   public boolean vmethod2911(int var1) {
      return this.width == 64;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-57"
   )
   public boolean vmethod2910(int var1) {
      return this.textures[var1].field1865;
   }

   @ObfuscatedName("w")
   @Export("brightness")
   public void brightness(double var1) {
      this.brightness = var1;
      this.reset();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-795342119"
   )
   public void method2439(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.field1866 != 0 && var3.loaded) {
            var3.method2547(var1);
            var3.loaded = false;
         }
      }

   }
}
