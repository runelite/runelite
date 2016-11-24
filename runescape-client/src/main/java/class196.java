import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
public class class196 extends CacheableNode {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 721302357
   )
   public int field2865 = 0;
   @ObfuscatedName("d")
   public static class182 field2866;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 786096497
   )
   public int field2867 = 70;
   @ObfuscatedName("h")
   static NodeCache field2868 = new NodeCache(64);
   @ObfuscatedName("w")
   @Export("spriteCache")
   static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("r")
   static NodeCache field2870 = new NodeCache(20);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -34443735
   )
   int field2872 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 74802891
   )
   int field2873 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -876756123
   )
   public int field2874 = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2120647195
   )
   int field2875 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -312287023
   )
   int field2876 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1009034603
   )
   int field2877 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 40760689
   )
   int field2878 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1565199807
   )
   public int field2879 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2025923329
   )
   public int field2880 = 0;
   @ObfuscatedName("n")
   public static class182 field2881;
   @ObfuscatedName("j")
   String field2882 = "";
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1460715575
   )
   public int field2883 = 16777215;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1097104941
   )
   public int field2884 = -1;
   @ObfuscatedName("u")
   public int[] field2885;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1038064481
   )
   int field2886 = -1;
   @ObfuscatedName("m")
   public static class182 field2888;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1506534106"
   )
   void method3617(Buffer var1) {
      while(true) {
         int var2 = var1.method3033();
         if(var2 == 0) {
            return;
         }

         this.method3628(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "2"
   )
   public String method3618(int var1) {
      String var2 = this.field2882;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + ItemLayer.method1487(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Lclass196;",
      garbageValue = "-1529372358"
   )
   public final class196 method3619() {
      int var1 = -1;
      if(this.field2877 != -1) {
         var1 = class37.method765(this.field2877);
      } else if(this.field2886 != -1) {
         var1 = class146.widgetSettings[this.field2886];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field2885.length - 1) {
         var2 = this.field2885[var1];
      } else {
         var2 = this.field2885[this.field2885.length - 1];
      }

      return var2 != -1?class6.method92(var2):null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1493322124"
   )
   public SpritePixels method3621() {
      if(this.field2875 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2875);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class207.method3894(field2866, this.field2875, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2875);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)LSpritePixels;",
      garbageValue = "-2259"
   )
   public SpritePixels method3622() {
      if(this.field2876 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2876);
         if(null != var1) {
            return var1;
         } else {
            var1 = class207.method3894(field2866, this.field2876, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2876);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "47"
   )
   public SpritePixels method3623() {
      if(this.field2873 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2873);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class207.method3894(field2866, this.field2873, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2873);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "1"
   )
   void method3628(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2872 = var1.method3005();
      } else if(var2 == 2) {
         this.field2883 = var1.method2994();
      } else if(var2 == 3) {
         this.field2875 = var1.method3005();
      } else if(var2 == 4) {
         this.field2873 = var1.method3005();
      } else if(var2 == 5) {
         this.field2876 = var1.method3005();
      } else if(var2 == 6) {
         this.field2878 = var1.method3005();
      } else if(var2 == 7) {
         this.field2879 = var1.method2993();
      } else if(var2 == 8) {
         this.field2882 = var1.method2999();
      } else if(var2 == 9) {
         this.field2867 = var1.method3097();
      } else if(var2 == 10) {
         this.field2880 = var1.method2993();
      } else if(var2 == 11) {
         this.field2874 = 0;
      } else if(var2 == 12) {
         this.field2884 = var1.method3033();
      } else if(var2 == 13) {
         this.field2865 = var1.method2993();
      } else if(var2 == 14) {
         this.field2874 = var1.method3097();
      } else if(var2 == 17 || var2 == 18) {
         this.field2877 = var1.method3097();
         if(this.field2877 == '\uffff') {
            this.field2877 = -1;
         }

         this.field2886 = var1.method3097();
         if(this.field2886 == '\uffff') {
            this.field2886 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.method3097();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.method3033();
         this.field2885 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field2885[var5] = var1.method3097();
            if(this.field2885[var5] == '\uffff') {
               this.field2885[var5] = -1;
            }
         }

         this.field2885[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Lclass208;",
      garbageValue = "127"
   )
   public class208 method3632() {
      if(this.field2872 == -1) {
         return null;
      } else {
         class208 var1 = (class208)field2870.get((long)this.field2872);
         if(null != var1) {
            return var1;
         } else {
            var1 = class186.method3474(field2866, field2888, this.field2872, 0);
            if(null != var1) {
               field2870.put(var1, (long)this.field2872);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-2126211801"
   )
   public SpritePixels method3634() {
      if(this.field2878 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2878);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class207.method3894(field2866, this.field2878, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2878);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "-403833355"
   )
   public static byte method3649(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
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

      return var1;
   }
}
