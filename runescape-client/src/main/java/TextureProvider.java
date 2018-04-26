import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("TextureProvider")
public class TextureProvider implements ITextureLoader {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Ldd;"
   )
   @Export("textures")
   Texture[] textures;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   @Export("deque")
   Deque deque;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1185179727
   )
   @Export("maxSize")
   int maxSize;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 626087027
   )
   @Export("size")
   int size;
   @ObfuscatedName("n")
   @Export("brightness")
   double brightness;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1996601173
   )
   @Export("width")
   int width;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("sprites")
   IndexDataBase sprites;

   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;IDI)V"
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "99128115"
   )
   public int method2658() {
      int var1 = 0;
      int var2 = 0;
      Texture[] var3 = this.textures;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         Texture var5 = var3[var4];
         if(var5 != null && var5.fileIds != null) {
            var1 += var5.fileIds.length;
            int[] var6 = var5.fileIds;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               int var8 = var6[var7];
               if(this.sprites.method4646(var8)) {
                  ++var2;
               }
            }
         }
      }

      if(var1 == 0) {
         return 0;
      } else {
         return var2 * 100 / var1;
      }
   }

   @ObfuscatedName("e")
   @Export("brightness")
   public void brightness(double var1) {
      this.brightness = var1;
      this.reset();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1381079357"
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

         boolean var3 = var2.method2770(this.brightness, this.width, this.sprites);
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-699855363"
   )
   @Export("getAverageTextureRGB")
   public int getAverageTextureRGB(int var1) {
      return this.textures[var1] != null?this.textures[var1].field1771:0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "254038017"
   )
   public boolean vmethod3152(int var1) {
      return this.textures[var1].field1776;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-79"
   )
   public boolean vmethod3155(int var1) {
      return this.width == 64;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "37"
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-5"
   )
   @Hook(
      value = "drawAboveOverheads",
      end = true
   )
   @Export("checkTextures")
   public void checkTextures(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.field1775 != 0 && var3.loaded) {
            var3.method2771(var1);
            var3.loaded = false;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;I)Z",
      garbageValue = "536456215"
   )
   public static boolean method2657(IndexDataBase var0, IndexDataBase var1) {
      Area.field3462 = var1;
      if(!var0.method4666()) {
         return false;
      } else {
         Area.field3450 = var0.fileCount(35);
         class190.mapAreaType = new Area[Area.field3450];

         for(int var2 = 0; var2 < Area.field3450; ++var2) {
            byte[] var3 = var0.getConfigData(35, var2);
            if(var3 != null) {
               class190.mapAreaType[var2] = new Area(var2);
               class190.mapAreaType[var2].method4869(new Buffer(var3));
               class190.mapAreaType[var2].method4857();
            }
         }

         return true;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)[Lix;",
      garbageValue = "-115"
   )
   public static Permission[] method2688() {
      return new Permission[]{Permission.field3339, Permission.field3340, Permission.field3336, Permission.field3335, Permission.field3333, Permission.field3338};
   }
}
