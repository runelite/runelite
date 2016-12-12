import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class196 extends CacheableNode {
   @ObfuscatedName("i")
   static class182 field2866;
   @ObfuscatedName("k")
   static NodeCache field2868 = new NodeCache(64);
   @ObfuscatedName("e")
   static class182 field2869;
   @ObfuscatedName("n")
   static NodeCache field2870 = new NodeCache(20);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 251668547
   )
   public int field2871 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1625048615
   )
   int field2873 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 284097471
   )
   public int field2875 = 70;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1712208261
   )
   int field2876 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1258258825
   )
   int field2877 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1377719063
   )
   int field2878 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 546380845
   )
   int field2879 = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1638076071
   )
   public int field2880 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1251748871
   )
   public int field2881 = 0;
   @ObfuscatedName("g")
   @Export("spriteCache")
   static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("s")
   String field2883 = "";
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1432937241
   )
   public int field2884 = 16777215;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1212173583
   )
   public int field2885 = 0;
   @ObfuscatedName("b")
   public int[] field2886;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -474087065
   )
   int field2887 = -1;
   @ObfuscatedName("f")
   static class182 field2888;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1723700831
   )
   public int field2889 = -1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1289097095
   )
   int field2890 = -1;
   @ObfuscatedName("db")
   @Export("xteaKeys")
   static int[][] xteaKeys;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "-15477"
   )
   void method3510(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3532(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1351009828"
   )
   public String method3512(int var1) {
      String var2 = this.field2883;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + class155.method2947(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Lclass196;",
      garbageValue = "1454485368"
   )
   public final class196 method3513() {
      int var1 = -1;
      if(this.field2887 != -1) {
         var1 = class97.method1898(this.field2887);
      } else if(this.field2890 != -1) {
         var1 = class165.widgetSettings[this.field2890];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field2886.length - 1) {
         var2 = this.field2886[var1];
      } else {
         var2 = this.field2886[this.field2886.length - 1];
      }

      return var2 != -1?class119.method2256(var2):null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1266633470"
   )
   public SpritePixels method3514() {
      if(this.field2877 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2877);
         if(null != var1) {
            return var1;
         } else {
            var1 = Player.method218(field2869, this.field2877, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2877);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-2"
   )
   public SpritePixels method3515() {
      if(this.field2878 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2878);
         if(null != var1) {
            return var1;
         } else {
            var1 = Player.method218(field2869, this.field2878, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2878);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Lclass208;",
      garbageValue = "1119662964"
   )
   public class208 method3517() {
      if(this.field2873 == -1) {
         return null;
      } else {
         class208 var1 = (class208)field2870.get((long)this.field2873);
         if(var1 != null) {
            return var1;
         } else {
            class182 var3 = field2869;
            class182 var4 = field2888;
            int var5 = this.field2873;
            class208 var2;
            if(!class178.method3196(var3, var5, 0)) {
               var2 = null;
            } else {
               byte[] var7 = var4.method3211(var5, 0);
               class208 var6;
               if(var7 == null) {
                  var6 = null;
               } else {
                  class208 var8 = new class208(var7, class225.field3217, RSCanvas.field1748, class225.field3218, Item.field897, class167.field2191, class154.field2106);
                  class185.method3361();
                  var6 = var8;
               }

               var2 = var6;
            }

            if(null != var2) {
               field2870.put(var2, (long)this.field2873);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2116609684"
   )
   void method3532(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2873 = var1.method2774();
      } else if(var2 == 2) {
         this.field2884 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field2876 = var1.method2774();
      } else if(var2 == 4) {
         this.field2878 = var1.method2774();
      } else if(var2 == 5) {
         this.field2877 = var1.method2774();
      } else if(var2 == 6) {
         this.field2879 = var1.method2774();
      } else if(var2 == 7) {
         this.field2880 = var1.method2762();
      } else if(var2 == 8) {
         this.field2883 = var1.method2808();
      } else if(var2 == 9) {
         this.field2875 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field2881 = var1.method2762();
      } else if(var2 == 11) {
         this.field2871 = 0;
      } else if(var2 == 12) {
         this.field2889 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field2885 = var1.method2762();
      } else if(var2 == 14) {
         this.field2871 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field2887 = var1.readUnsignedShort();
         if(this.field2887 == '\uffff') {
            this.field2887 = -1;
         }

         this.field2890 = var1.readUnsignedShort();
         if(this.field2890 == '\uffff') {
            this.field2890 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field2886 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field2886[var5] = var1.readUnsignedShort();
            if(this.field2886[var5] == '\uffff') {
               this.field2886[var5] = -1;
            }
         }

         this.field2886[1 + var4] = var3;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "125"
   )
   public SpritePixels method3533() {
      if(this.field2879 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2879);
         if(null != var1) {
            return var1;
         } else {
            var1 = Player.method218(field2869, this.field2879, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2879);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-114"
   )
   public SpritePixels method3534() {
      if(this.field2876 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2876);
         if(null != var1) {
            return var1;
         } else {
            var1 = Player.method218(field2869, this.field2876, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2876);
            }

            return var1;
         }
      }
   }
}
