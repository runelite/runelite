import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
@Implements("TextureProvider")
public class TextureProvider implements ITextureLoader {
   @ObfuscatedName("i")
   @Export("textures")
   Texture[] textures;
   @ObfuscatedName("w")
   @Export("deque")
   Deque deque;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1408455501
   )
   @Export("size")
   int size;
   @ObfuscatedName("s")
   @Export("brightness")
   double brightness;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1756501805
   )
   @Export("width")
   int width;
   @ObfuscatedName("v")
   @Export("sprites")
   IndexDataBase sprites;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 319506549
   )
   @Export("maxSize")
   int maxSize;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   @Export("brightness")
   public void brightness(double var1) {
      this.brightness = var1;
      this.reset();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "750752520"
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

         boolean var3 = var2.method2475(this.brightness, this.width, this.sprites);
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1662598982"
   )
   @Export("getAverageTextureRGB")
   public int getAverageTextureRGB(int var1) {
      return this.textures[var1] != null?this.textures[var1].field1883:0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "349268549"
   )
   public boolean vmethod2878(int var1) {
      return this.width == 64;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "423"
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "889939768"
   )
   public void method2390(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.field1888 != 0 && var3.loaded) {
            var3.method2477(var1);
            var3.loaded = false;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1438867577"
   )
   public static void method2399() {
      Varbit.varbits.reset();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-4101"
   )
   public boolean vmethod2875(int var1) {
      return this.textures[var1].field1889;
   }

   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;IDI)V",
      garbageValue = "64"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "-842790610"
   )
   public static byte method2403(char var0) {
      byte var1;
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 == 8364) {
            var1 = -128;
         } else if(var0 == 8218) {
            var1 = -126;
         } else if(var0 == 402) {
            var1 = -125;
         } else if(var0 == 8222) {
            var1 = -124;
         } else if(var0 == 8230) {
            var1 = -123;
         } else if(var0 == 8224) {
            var1 = -122;
         } else if(var0 == 8225) {
            var1 = -121;
         } else if(var0 == 710) {
            var1 = -120;
         } else if(var0 == 8240) {
            var1 = -119;
         } else if(var0 == 352) {
            var1 = -118;
         } else if(var0 == 8249) {
            var1 = -117;
         } else if(var0 == 338) {
            var1 = -116;
         } else if(var0 == 381) {
            var1 = -114;
         } else if(var0 == 8216) {
            var1 = -111;
         } else if(var0 == 8217) {
            var1 = -110;
         } else if(var0 == 8220) {
            var1 = -109;
         } else if(var0 == 8221) {
            var1 = -108;
         } else if(var0 == 8226) {
            var1 = -107;
         } else if(var0 == 8211) {
            var1 = -106;
         } else if(var0 == 8212) {
            var1 = -105;
         } else if(var0 == 732) {
            var1 = -104;
         } else if(var0 == 8482) {
            var1 = -103;
         } else if(var0 == 353) {
            var1 = -102;
         } else if(var0 == 8250) {
            var1 = -101;
         } else if(var0 == 339) {
            var1 = -100;
         } else if(var0 == 382) {
            var1 = -98;
         } else if(var0 == 376) {
            var1 = -97;
         } else {
            var1 = 63;
         }
      } else {
         var1 = (byte)var0;
      }

      return var1;
   }

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1483925623"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class261.clientInstance.method880();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field958 = 0;
            Client.field959 = 0;
         }

         if(var0 != 20 && var0 != 40 && class215.field2640 != null) {
            class215.field2640.close();
            class215.field2640 = null;
         }

         if(Client.gameState == 25) {
            Client.field1104 = 0;
            Client.field1083 = 0;
            Client.field982 = 1;
            Client.field983 = 0;
            Client.field984 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class140.method2857(DecorativeObject.field2194, class18.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class140.method2857(DecorativeObject.field2194, class18.indexSprites, false, 4);
            } else {
               class112.method2096();
            }
         } else {
            class140.method2857(DecorativeObject.field2194, class18.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }

   }
}
