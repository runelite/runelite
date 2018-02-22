import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("TextureProvider")
public class TextureProvider implements ITextureLoader {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -745914891
   )
   public static int field1658;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[Lda;"
   )
   @Export("textures")
   Texture[] textures;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("deque")
   Deque deque;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1307691331
   )
   @Export("maxSize")
   int maxSize;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1073873597
   )
   @Export("size")
   int size;
   @ObfuscatedName("a")
   @Export("brightness")
   double brightness;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1597641741
   )
   @Export("width")
   int width;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("sprites")
   IndexDataBase sprites;

   @ObfuscatedSignature(
      signature = "(Lie;Lie;IDI)V"
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method2574() {
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
               if(this.sprites.method4541(var8)) {
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

   @ObfuscatedName("q")
   @Export("brightness")
   public void brightness(double var1) {
      this.brightness = var1;
      this.reset();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1038419006"
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

         boolean var3 = var2.method2692(this.brightness, this.width, this.sprites);
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1120814065"
   )
   @Export("getAverageTextureRGB")
   public int getAverageTextureRGB(int var1) {
      return this.textures[var1] != null?this.textures[var1].field1754:0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-120"
   )
   public boolean vmethod3058(int var1) {
      return this.textures[var1].field1756;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "146160731"
   )
   public boolean vmethod3059(int var1) {
      return this.width == 64;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1269074617"
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
      garbageValue = "47"
   )
   @Hook(
      value = "drawAboveOverheads",
      end = true
   )
   @Export("checkTextures")
   public void checkTextures(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.field1762 != 0 && var3.loaded) {
            var3.method2688(var1);
            var3.loaded = false;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-43053108"
   )
   public static File method2596(String var0) {
      if(!class169.field2185) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class169.field2183.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class169.field2182, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class169.field2183.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(Lbq;I)V",
      garbageValue = "461591561"
   )
   static final void method2584(Actor var0) {
      if(var0.field1147 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < 32768) {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= 32768) {
               var1 = Client.cachedPlayers[var0.interacting - 32768];
            }

            if(var1 != null) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field1121) {
               var0.interacting = -1;
               var0.field1121 = false;
            }
         }

         if(var0.field1122 != -1 && (var0.queueSize == 0 || var0.field1128 > 0)) {
            var0.orientation = var0.field1122;
            var0.field1122 = -1;
         }

         int var4 = var0.orientation - var0.angle & 2047;
         if(var4 == 0 && var0.field1121) {
            var0.interacting = -1;
            var0.field1121 = false;
         }

         if(var4 != 0) {
            ++var0.field1120;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field1147;
               var6 = true;
               if(var4 < var0.field1147 || var4 > 2048 - var0.field1147) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1120 > 25 || var6)) {
                  if(var0.field1100 != -1) {
                     var0.poseAnimation = var0.field1100;
                  } else {
                     var0.poseAnimation = var0.field1102;
                  }
               }
            } else {
               var0.angle += var0.field1147;
               var6 = true;
               if(var4 < var0.field1147 || var4 > 2048 - var0.field1147) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1120 > 25 || var6)) {
                  if(var0.field1101 != -1) {
                     var0.poseAnimation = var0.field1101;
                  } else {
                     var0.poseAnimation = var0.field1102;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1120 = 0;
         }

      }
   }
}
