import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class196 extends CacheableNode {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1397634611
   )
   int field2867 = -1;
   @ObfuscatedName("d")
   static class182 field2868;
   @ObfuscatedName("h")
   static class182 field2869;
   @ObfuscatedName("p")
   public static NodeCache field2870 = new NodeCache(64);
   @ObfuscatedName("k")
   String field2871 = "";
   @ObfuscatedName("n")
   public static NodeCache field2872 = new NodeCache(20);
   @ObfuscatedName("j")
   @Export("spriteCache")
   public static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1545042539
   )
   public int field2876 = 70;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1622316125
   )
   public int field2877 = 16777215;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -608149859
   )
   int field2878 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1660035215
   )
   int field2879 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1978116357
   )
   int field2880 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1290074277
   )
   public int field2881 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1961591421
   )
   public int field2882 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1817108679
   )
   public int field2883 = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1794601199
   )
   int field2884 = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1177204185
   )
   public int field2885 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -401261873
   )
   int field2886 = -1;
   @ObfuscatedName("g")
   public int[] field2887;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1245323601
   )
   public int field2888 = 0;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -594741971
   )
   int field2889 = -1;
   @ObfuscatedName("q")
   static class182 field2890;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "695719676"
   )
   void method3574(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3575(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1493912024"
   )
   void method3575(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2886 = var1.method3029();
      } else if(var2 == 2) {
         this.field2877 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field2867 = var1.method3029();
      } else if(var2 == 4) {
         this.field2879 = var1.method3029();
      } else if(var2 == 5) {
         this.field2878 = var1.method3029();
      } else if(var2 == 6) {
         this.field2880 = var1.method3029();
      } else if(var2 == 7) {
         this.field2881 = var1.readShort();
      } else if(var2 == 8) {
         this.field2871 = var1.method2842();
      } else if(var2 == 9) {
         this.field2876 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field2882 = var1.readShort();
      } else if(var2 == 11) {
         this.field2883 = 0;
      } else if(var2 == 12) {
         this.field2885 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field2888 = var1.readShort();
      } else if(var2 == 14) {
         this.field2883 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field2884 = var1.readUnsignedShort();
         if(this.field2884 == '\uffff') {
            this.field2884 = -1;
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
         this.field2887 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field2887[var5] = var1.readUnsignedShort();
            if(this.field2887[var5] == '\uffff') {
               this.field2887[var5] = -1;
            }
         }

         this.field2887[1 + var4] = var3;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1285270486"
   )
   public String method3577(int var1) {
      String var2 = this.field2871;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + class178.method3288(var1, false) + var2.substring(2 + var3);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-131890107"
   )
   public SpritePixels method3578() {
      if(this.field2867 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2867);
         if(null != var1) {
            return var1;
         } else {
            var1 = class182.method3305(field2868, this.field2867, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2867);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "414177965"
   )
   public SpritePixels method3579() {
      if(this.field2878 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2878);
         if(null != var1) {
            return var1;
         } else {
            var1 = class182.method3305(field2868, this.field2878, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2878);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-334141444"
   )
   public SpritePixels method3581() {
      if(this.field2880 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2880);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class182.method3305(field2868, this.field2880, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2880);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-95431604"
   )
   public SpritePixels method3586() {
      if(this.field2879 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2879);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class182.method3305(field2868, this.field2879, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2879);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BB)LFont;",
      garbageValue = "0"
   )
   static Font method3608(byte[] var0) {
      if(null == var0) {
         return null;
      } else {
         Font var1 = new Font(var0, Ignore.field223, class225.field3233, class225.field3234, class41.field862, class160.field2146, class11.field129);
         Ignore.field223 = null;
         class225.field3233 = null;
         class225.field3234 = null;
         class41.field862 = null;
         class160.field2146 = null;
         class11.field129 = null;
         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)LFont;",
      garbageValue = "11"
   )
   public Font method3609() {
      if(this.field2886 == -1) {
         return null;
      } else {
         Font var1 = (Font)field2872.get((long)this.field2886);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class182.method3380(field2868, field2869, this.field2886, 0);
            if(var1 != null) {
               field2872.put(var1, (long)this.field2886);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lclass196;",
      garbageValue = "1663686776"
   )
   public final class196 method3612() {
      int var1 = -1;
      if(this.field2884 != -1) {
         var1 = class109.method2109(this.field2884);
      } else if(this.field2889 != -1) {
         var1 = class165.widgetSettings[this.field2889];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field2887.length - 1) {
         var2 = this.field2887[var1];
      } else {
         var2 = this.field2887[this.field2887.length - 1];
      }

      return var2 != -1?class48.method970(var2):null;
   }

   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "(LWidget;B)I",
      garbageValue = "3"
   )
   static int method3614(Widget var0) {
      class133 var1 = (class133)Client.widgetFlags.method2399((long)var0.index + ((long)var0.id << 32));
      return null != var1?var1.field1895:var0.field2277;
   }
}
