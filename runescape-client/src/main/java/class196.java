import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class196 extends CacheableNode {
   @ObfuscatedName("x")
   static class182 field2851;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2136901033
   )
   int field2852 = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -682940369
   )
   int field2853 = -1;
   @ObfuscatedName("a")
   public static NodeCache field2854 = new NodeCache(64);
   @ObfuscatedName("f")
   @Export("spriteCache")
   public static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("c")
   public static NodeCache field2856 = new NodeCache(20);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1548563985
   )
   public int field2857 = 0;
   @ObfuscatedName("i")
   static class182 field2860;
   @ObfuscatedName("u")
   static class182 field2861;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1726485437
   )
   public int field2862 = 16777215;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -529600985
   )
   int field2863 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1360201231
   )
   int field2865 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1276064045
   )
   int field2866 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 127261101
   )
   public int field2867 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -999830123
   )
   public int field2868 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2008811229
   )
   public int field2869 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1696196979
   )
   public int field2870 = -1;
   @ObfuscatedName("s")
   String field2871 = "";
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1619718861
   )
   public int field2873 = 70;
   @ObfuscatedName("o")
   public int[] field2874;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1469353097
   )
   int field2875 = -1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -621031591
   )
   int field2876 = -1;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-782609975"
   )
   public static final boolean method3554() {
      class105 var0 = class105.keyboard;
      class105 var1 = class105.keyboard;
      synchronized(class105.keyboard) {
         if(class105.field1683 == class105.field1709) {
            return false;
         } else {
            class162.field2134 = class105.field1705[class105.field1709];
            class175.field2631 = class105.field1704[class105.field1709];
            class105.field1709 = class105.field1709 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1604495180"
   )
   public String method3555(int var1) {
      String var2 = this.field2871;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         String var4 = var2.substring(0, var3);
         String var5 = Integer.toString(var1);
         var2 = var4 + var5 + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lclass196;",
      garbageValue = "-1938456630"
   )
   public final class196 method3556() {
      int var1 = -1;
      if(this.field2875 != -1) {
         var1 = class101.method1911(this.field2875);
      } else if(this.field2876 != -1) {
         var1 = class165.widgetSettings[this.field2876];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field2874.length - 1) {
         var2 = this.field2874[var1];
      } else {
         var2 = this.field2874[this.field2874.length - 1];
      }

      return var2 != -1?class65.method1118(var2):null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "33"
   )
   public SpritePixels method3558() {
      if(this.field2863 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2863);
         if(null != var1) {
            return var1;
         } else {
            var1 = TextureProvider.method1410(field2851, this.field2863, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2863);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "17"
   )
   public SpritePixels method3559() {
      if(this.field2865 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2865);
         if(null != var1) {
            return var1;
         } else {
            var1 = TextureProvider.method1410(field2851, this.field2865, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2865);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-993236225"
   )
   public SpritePixels method3560() {
      if(this.field2866 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2866);
         if(var1 != null) {
            return var1;
         } else {
            var1 = TextureProvider.method1410(field2851, this.field2866, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2866);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1627793862"
   )
   public SpritePixels method3561() {
      if(this.field2852 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2852);
         if(null != var1) {
            return var1;
         } else {
            var1 = TextureProvider.method1410(field2851, this.field2852, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2852);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2137325616"
   )
   void method3588(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2853 = var1.method2790();
      } else if(var2 == 2) {
         this.field2862 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field2863 = var1.method2790();
      } else if(var2 == 4) {
         this.field2866 = var1.method2790();
      } else if(var2 == 5) {
         this.field2865 = var1.method2790();
      } else if(var2 == 6) {
         this.field2852 = var1.method2790();
      } else if(var2 == 7) {
         this.field2868 = var1.method2968();
      } else if(var2 == 8) {
         this.field2871 = var1.method2784();
      } else if(var2 == 9) {
         this.field2873 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field2869 = var1.method2968();
      } else if(var2 == 11) {
         this.field2870 = 0;
      } else if(var2 == 12) {
         this.field2867 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field2857 = var1.method2968();
      } else if(var2 == 14) {
         this.field2870 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field2875 = var1.readUnsignedShort();
         if(this.field2875 == '\uffff') {
            this.field2875 = -1;
         }

         this.field2876 = var1.readUnsignedShort();
         if(this.field2876 == '\uffff') {
            this.field2876 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field2874 = new int[2 + var4];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field2874[var5] = var1.readUnsignedShort();
            if(this.field2874[var5] == '\uffff') {
               this.field2874[var5] = -1;
            }
         }

         this.field2874[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Lclass208;",
      garbageValue = "-21"
   )
   public class208 method3590() {
      if(this.field2853 == -1) {
         return null;
      } else {
         class208 var1 = (class208)field2856.get((long)this.field2853);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class63.method1110(field2851, field2860, this.field2853, 0);
            if(var1 != null) {
               field2856.put(var1, (long)this.field2853);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1564837690"
   )
   void method3592(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3588(var1, var2);
      }
   }
}
