import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class201 extends CacheableNode {
   @ObfuscatedName("b")
   String field2896 = "";
   @ObfuscatedName("n")
   public static IndexDataBase field2897;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1156850301
   )
   int field2898 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 797538569
   )
   public int field2899 = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1904431751
   )
   int field2900 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1334026831
   )
   int field2904 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 781196843
   )
   public int field2905 = 16777215;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1770272343
   )
   public int field2906 = 70;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1023000147
   )
   int field2907 = -1;
   @ObfuscatedName("p")
   public static NodeCache field2908 = new NodeCache(20);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1461561905
   )
   int field2909 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 600132097
   )
   int field2910 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1632878871
   )
   public int field2911 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1247301213
   )
   public int field2912 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 630683921
   )
   public int field2913 = -1;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = -1506301171
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1565782895
   )
   public int field2915 = -1;
   @ObfuscatedName("m")
   public int[] field2917;
   @ObfuscatedName("c")
   public static IndexDataBase field2918;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 682680369
   )
   int field2919 = -1;
   @ObfuscatedName("d")
   public static IndexDataBase field2920;
   @ObfuscatedName("t")
   @Export("spriteCache")
   public static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("q")
   public static NodeCache field2922 = new NodeCache(64);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "8"
   )
   void method3643(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3644(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1909504737"
   )
   void method3644(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2904 = var1.method2397();
      } else if(var2 == 2) {
         this.field2905 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field2907 = var1.method2397();
      } else if(var2 == 4) {
         this.field2909 = var1.method2397();
      } else if(var2 == 5) {
         this.field2919 = var1.method2397();
      } else if(var2 == 6) {
         this.field2910 = var1.method2397();
      } else if(var2 == 7) {
         this.field2911 = var1.readShort();
      } else if(var2 == 8) {
         this.field2896 = var1.method2430();
      } else if(var2 == 9) {
         this.field2906 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field2912 = var1.readShort();
      } else if(var2 == 11) {
         this.field2913 = 0;
      } else if(var2 == 12) {
         this.field2915 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field2899 = var1.readShort();
      } else if(var2 == 14) {
         this.field2913 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field2898 = var1.readUnsignedShort();
         if(this.field2898 == '\uffff') {
            this.field2898 = -1;
         }

         this.field2900 = var1.readUnsignedShort();
         if(this.field2900 == '\uffff') {
            this.field2900 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field2917 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field2917[var5] = var1.readUnsignedShort();
            if(this.field2917[var5] == '\uffff') {
               this.field2917[var5] = -1;
            }
         }

         this.field2917[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-64"
   )
   public SpritePixels method3647() {
      if(this.field2919 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2919);
         if(var1 != null) {
            return var1;
         } else {
            var1 = Ignore.method203(field2918, this.field2919, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2919);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)LFont;",
      garbageValue = "641023537"
   )
   public Font method3650() {
      if(this.field2904 == -1) {
         return null;
      } else {
         Font var1 = (Font)field2908.get((long)this.field2904);
         if(var1 != null) {
            return var1;
         } else {
            var1 = Tile.method1568(field2918, field2897, this.field2904, 0);
            if(var1 != null) {
               field2908.put(var1, (long)this.field2904);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "834657949"
   )
   public String method3653(int var1) {
      String var2 = this.field2896;

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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "59"
   )
   public SpritePixels method3657() {
      if(this.field2910 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2910);
         if(var1 != null) {
            return var1;
         } else {
            var1 = Ignore.method203(field2918, this.field2910, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2910);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1932641492"
   )
   public SpritePixels method3668() {
      if(this.field2909 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2909);
         if(var1 != null) {
            return var1;
         } else {
            var1 = Ignore.method203(field2918, this.field2909, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2909);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-191964184"
   )
   public SpritePixels method3672() {
      if(this.field2907 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2907);
         if(var1 != null) {
            return var1;
         } else {
            var1 = Ignore.method203(field2918, this.field2907, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2907);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Lclass201;",
      garbageValue = "28"
   )
   public final class201 method3673() {
      int var1 = -1;
      if(this.field2898 != -1) {
         var1 = class59.method1140(this.field2898);
      } else if(this.field2900 != -1) {
         var1 = class167.widgetSettings[this.field2900];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field2917.length - 1) {
         var2 = this.field2917[var1];
      } else {
         var2 = this.field2917[this.field2917.length - 1];
      }

      return var2 != -1?IndexData.method3381(var2):null;
   }
}
