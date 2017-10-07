import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
@Implements("TextureProvider")
public class TextureProvider implements ITextureLoader {
   @ObfuscatedName("v")
   public static short[] field1767;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   static IndexedSprite field1758;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1450065737
   )
   @Export("width")
   int width;
   @ObfuscatedName("q")
   @Export("brightness")
   double brightness;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Ldt;"
   )
   @Export("textures")
   Texture[] textures;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("deque")
   Deque deque;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 286912423
   )
   @Export("size")
   int size;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1657259743
   )
   @Export("maxSize")
   int maxSize;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("sprites")
   IndexDataBase sprites;

   @ObfuscatedSignature(
      signature = "(Lit;Lit;IDI)V"
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1084067418"
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
      signature = "(IB)I",
      garbageValue = "-79"
   )
   @Export("getAverageTextureRGB")
   public int getAverageTextureRGB(int var1) {
      return this.textures[var1] != null?this.textures[var1].field1869:0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "803388249"
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

         boolean var3 = var2.method2581(this.brightness, this.width, this.sprites);
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "83"
   )
   public boolean vmethod2952(int var1) {
      return this.width == 64;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1690267600"
   )
   public boolean vmethod2950(int var1) {
      return this.textures[var1].field1866;
   }

   @ObfuscatedName("d")
   @Export("brightness")
   public void brightness(double var1) {
      this.brightness = var1;
      this.reset();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1898294956"
   )
   public void method2488(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.field1871 != 0 && var3.loaded) {
            var3.method2580(var1);
            var3.loaded = false;
         }
      }

   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(Lhj;IIZI)V",
      garbageValue = "-1026657266"
   )
   static void method2478(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2665 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2665 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2665 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.field2670;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.field2670;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.field2670 >> 14;
      }

      if(var0.field2665 == 4) {
         var0.width = var0.height * var0.field2675 / var0.field2657;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.field2657 * var0.width / var0.field2675;
      }

      if(Client.field961 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field1085 = var0;
      }

      if(var3 && var0.field2767 != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.field846 = var0.field2767;
         Client.field1112.addFront(var6);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "356951748"
   )
   static void method2493() {
      if(class90.username == null || class90.username.length() <= 0) {
         if(class23.preferences.field1306 != null) {
            class90.username = class23.preferences.field1306;
            class90.field1414 = true;
         } else {
            class90.field1414 = false;
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "366219428"
   )
   static int method2494(int var0, Script var1, boolean var2) {
      if(var0 == 6200) {
         class81.intStackSize -= 2;
         Client.field1166 = (short)class81.intStack[class81.intStackSize];
         if(Client.field1166 <= 0) {
            Client.field1166 = 256;
         }

         Client.field1167 = (short)class81.intStack[class81.intStackSize + 1];
         if(Client.field1167 <= 0) {
            Client.field1167 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         class81.intStackSize -= 2;
         Client.field1168 = (short)class81.intStack[class81.intStackSize];
         if(Client.field1168 <= 0) {
            Client.field1168 = 256;
         }

         Client.field1169 = (short)class81.intStack[class81.intStackSize + 1];
         if(Client.field1169 <= 0) {
            Client.field1169 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         class81.intStackSize -= 4;
         Client.field1001 = (short)class81.intStack[class81.intStackSize];
         if(Client.field1001 <= 0) {
            Client.field1001 = 1;
         }

         Client.field1059 = (short)class81.intStack[class81.intStackSize + 1];
         if(Client.field1059 <= 0) {
            Client.field1059 = 32767;
         } else if(Client.field1059 < Client.field1001) {
            Client.field1059 = Client.field1001;
         }

         Client.field1172 = (short)class81.intStack[class81.intStackSize + 2];
         if(Client.field1172 <= 0) {
            Client.field1172 = 1;
         }

         Client.field1062 = (short)class81.intStack[class81.intStackSize + 3];
         if(Client.field1062 <= 0) {
            Client.field1062 = 32767;
         } else if(Client.field1062 < Client.field1172) {
            Client.field1062 = Client.field1172;
         }

         return 1;
      } else if(var0 == 6203) {
         if(Client.field1085 != null) {
            class41.method587(0, 0, Client.field1085.width, Client.field1085.height, false);
            class81.intStack[++class81.intStackSize - 1] = Client.viewportHeight;
            class81.intStack[++class81.intStackSize - 1] = Client.viewportWidth;
         } else {
            class81.intStack[++class81.intStackSize - 1] = -1;
            class81.intStack[++class81.intStackSize - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class81.intStack[++class81.intStackSize - 1] = Client.field1168;
         class81.intStack[++class81.intStackSize - 1] = Client.field1169;
         return 1;
      } else if(var0 == 6205) {
         class81.intStack[++class81.intStackSize - 1] = Client.field1166;
         class81.intStack[++class81.intStackSize - 1] = Client.field1167;
         return 1;
      } else {
         return 2;
      }
   }
}
