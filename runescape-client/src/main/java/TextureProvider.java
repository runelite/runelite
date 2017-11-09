import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("TextureProvider")
public class TextureProvider implements ITextureLoader {
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = -377463165
   )
   static int field1688;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Ldz;"
   )
   @Export("textures")
   Texture[] textures;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("deque")
   Deque deque;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 933904459
   )
   @Export("maxSize")
   int maxSize;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2102992035
   )
   @Export("size")
   int size;
   @ObfuscatedName("v")
   @Export("brightness")
   double brightness;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1878576597
   )
   @Export("width")
   int width;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("sprites")
   IndexDataBase sprites;

   @ObfuscatedSignature(
      signature = "(Lik;Lik;IDI)V"
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

   @ObfuscatedName("m")
   @Export("brightness")
   public void brightness(double var1) {
      this.brightness = var1;
      this.reset();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1553030192"
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

         boolean var3 = var2.method2601(this.brightness, this.width, this.sprites);
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-84803768"
   )
   @Export("getAverageTextureRGB")
   public int getAverageTextureRGB(int var1) {
      return this.textures[var1] != null?this.textures[var1].field1791:0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "19136896"
   )
   public boolean vmethod2988(int var1) {
      return this.textures[var1].field1796;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-8858"
   )
   public boolean vmethod2993(int var1) {
      return this.width == 64;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "127"
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1659513513"
   )
   public void method2501(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.field1792 != 0 && var3.loaded) {
            var3.method2602(var1);
            var3.loaded = false;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "60"
   )
   public static void method2505(int var0, int var1) {
      Varbit var2 = Coordinates.method4096(var0);
      int var3 = var2.configId;
      int var4 = var2.leastSignificantBit;
      int var5 = var2.mostSignificantBit;
      int var6 = class218.field2689[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      class218.widgetSettings[var3] = class218.widgetSettings[var3] & ~var6 | var1 << var4 & var6;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "582836187"
   )
   static final boolean method2512(char var0) {
      return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
   }
}
