import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class196 extends CacheableNode {
   @ObfuscatedName("a")
   public int[] field2864;
   @ObfuscatedName("j")
   public static class182 field2865;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -736047391
   )
   int field2866 = -1;
   @ObfuscatedName("d")
   public static NodeCache field2867 = new NodeCache(64);
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -697175177
   )
   int field2868 = -1;
   @ObfuscatedName("h")
   public static NodeCache field2869 = new NodeCache(20);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1807232785
   )
   public int field2872 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 65756653
   )
   public int field2875 = 16777215;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1289656623
   )
   public int field2876 = 70;
   @ObfuscatedName("w")
   @Export("spriteCache")
   public static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1188661099
   )
   int field2878 = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 835509085
   )
   int field2879 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1025253409
   )
   int field2880 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1143681189
   )
   public int field2881 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -274680049
   )
   public int field2882 = 0;
   @ObfuscatedName("x")
   public static class182 field2883;
   @ObfuscatedName("z")
   String field2884 = "";
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2083392141
   )
   public int field2885 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 70887621
   )
   public int field2886 = 0;
   @ObfuscatedName("c")
   public static class182 field2887;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1437774911
   )
   int field2888 = -1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 85802421
   )
   int field2889 = -1;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "29"
   )
   void method3583(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3605(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lclass196;",
      garbageValue = "2011337046"
   )
   public final class196 method3585() {
      int var1 = -1;
      if(this.field2888 != -1) {
         var1 = class88.method1937(this.field2888);
      } else if(this.field2889 != -1) {
         var1 = class165.widgetSettings[this.field2889];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field2864.length - 1) {
         var2 = this.field2864[var1];
      } else {
         var2 = this.field2864[this.field2864.length - 1];
      }

      return var2 != -1?class171.method3266(var2):null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-54"
   )
   public String method3586(int var1) {
      String var2 = this.field2884;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + class119.method2328(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-4713807"
   )
   public SpritePixels method3588() {
      if(this.field2878 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2878);
         if(null != var1) {
            return var1;
         } else {
            var1 = class99.method1997(field2865, this.field2878, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2878);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-812675006"
   )
   public SpritePixels method3589() {
      if(this.field2879 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2879);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class99.method1997(field2865, this.field2879, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2879);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "915361938"
   )
   public SpritePixels method3590() {
      if(this.field2880 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2880);
         if(null != var1) {
            return var1;
         } else {
            var1 = class99.method1997(field2865, this.field2880, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2880);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LFont;",
      garbageValue = "2054239283"
   )
   public Font method3591() {
      if(this.field2868 == -1) {
         return null;
      } else {
         Font var1 = (Font)field2869.get((long)this.field2868);
         if(null != var1) {
            return var1;
         } else {
            var1 = TextureProvider.method1516(field2865, field2887, this.field2868, 0);
            if(var1 != null) {
               field2869.put(var1, (long)this.field2868);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1371332104"
   )
   public static int method3599(CharSequence var0) {
      return class176.method3276(var0, 10, true);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1905231479"
   )
   public SpritePixels method3602() {
      if(this.field2866 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2866);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class99.method1997(field2865, this.field2866, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2866);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2107199512"
   )
   void method3605(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2868 = var1.method2846();
      } else if(var2 == 2) {
         this.field2875 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field2866 = var1.method2846();
      } else if(var2 == 4) {
         this.field2879 = var1.method2846();
      } else if(var2 == 5) {
         this.field2878 = var1.method2846();
      } else if(var2 == 6) {
         this.field2880 = var1.method2846();
      } else if(var2 == 7) {
         this.field2881 = var1.readShort();
      } else if(var2 == 8) {
         this.field2884 = var1.method2973();
      } else if(var2 == 9) {
         this.field2876 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field2882 = var1.readShort();
      } else if(var2 == 11) {
         this.field2872 = 0;
      } else if(var2 == 12) {
         this.field2885 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field2886 = var1.readShort();
      } else if(var2 == 14) {
         this.field2872 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field2888 = var1.readUnsignedShort();
         if(this.field2888 == '\uffff') {
            this.field2888 = -1;
         }

         this.field2889 = var1.readUnsignedShort();
         if(this.field2889 == '\uffff') {
            this.field2889 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field2864 = new int[2 + var4];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field2864[var5] = var1.readUnsignedShort();
            if(this.field2864[var5] == '\uffff') {
               this.field2864[var5] = -1;
            }
         }

         this.field2864[var4 + 1] = var3;
      }

   }
}
