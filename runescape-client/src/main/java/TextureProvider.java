import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
@Implements("TextureProvider")
public class TextureProvider implements ITextureLoader {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1815933983
   )
   @Export("width")
   int width;
   @ObfuscatedName("v")
   @Export("brightness")
   double brightness;
   @ObfuscatedName("a")
   @Export("textures")
   Texture[] textures;
   @ObfuscatedName("j")
   @Export("deque")
   Deque deque;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1952578149
   )
   @Export("size")
   int size;
   @ObfuscatedName("l")
   @Export("sprites")
   IndexDataBase sprites;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1202783989
   )
   @Export("maxSize")
   int maxSize;

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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-110"
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "769753382"
   )
   @Export("getAverageTextureRGB")
   public int getAverageTextureRGB(int var1) {
      return this.textures[var1] != null?this.textures[var1].field1868:0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "883752153"
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

         boolean var3 = var2.method2487(this.brightness, this.width, this.sprites);
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-16711936"
   )
   public boolean vmethod2877(int var1) {
      return this.width == 64;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-31277212"
   )
   public boolean vmethod2875(int var1) {
      return this.textures[var1].field1869;
   }

   @ObfuscatedName("a")
   @Export("brightness")
   public void brightness(double var1) {
      this.brightness = var1;
      this.reset();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1836397146"
   )
   public void method2369(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.field1874 != 0 && var3.loaded) {
            var3.method2488(var1);
            var3.loaded = false;
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(LSignlink;IIB)LAbstractSoundSystem;",
      garbageValue = "-54"
   )
   public static final AbstractSoundSystem method2381(Signlink var0, int var1, int var2) {
      if(ChatLineBuffer.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = class267.field3666.vmethod1892();
            var3.samples = new int[256 * (AbstractSoundSystem.highMemory?2:1)];
            var3.field1631 = var2;
            var3.vmethod1992();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(class11.priority > 0 && class24.task == null) {
               class24.task = new SoundTask();
               class280.field3754 = Executors.newScheduledThreadPool(1);
               class280.field3754.scheduleAtFixedRate(class24.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class24.task != null) {
               if(class24.task.systems[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class24.task.systems[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new AbstractSoundSystem();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
