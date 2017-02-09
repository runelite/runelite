import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public class class196 extends CacheableNode {
   @ObfuscatedName("y")
   static class182 field2850;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -695962365
   )
   int field2851 = -1;
   @ObfuscatedName("o")
   static class182 field2852;
   @ObfuscatedName("w")
   @Export("spriteCache")
   public static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("j")
   public static NodeCache field2854 = new NodeCache(20);
   @ObfuscatedName("an")
   static ModIcon[] field2855;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1792969925
   )
   int field2856 = -1;
   @ObfuscatedName("r")
   public static NodeCache field2857 = new NodeCache(64);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1881164779
   )
   public int field2858 = 70;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 475309227
   )
   int field2859 = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -647423473
   )
   int field2860 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1700518617
   )
   public int field2861 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -459341005
   )
   int field2862 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 364367725
   )
   public int field2863 = 0;
   @ObfuscatedName("b")
   String field2864 = "";
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2052144385
   )
   public int field2865 = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1269234415
   )
   int field2866 = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 639711705
   )
   public int field2867 = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1542800629
   )
   public int field2868 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 99577581
   )
   int field2869 = -1;
   @ObfuscatedName("l")
   public int[] field2870;
   @ObfuscatedName("k")
   static class182 field2871;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1949838521
   )
   public int field2872 = 16777215;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-56"
   )
   void method3563(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2856 = var1.method3096();
      } else if(var2 == 2) {
         this.field2872 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field2859 = var1.method3096();
      } else if(var2 == 4) {
         this.field2869 = var1.method3096();
      } else if(var2 == 5) {
         this.field2860 = var1.method3096();
      } else if(var2 == 6) {
         this.field2862 = var1.method3096();
      } else if(var2 == 7) {
         this.field2863 = var1.readShort();
      } else if(var2 == 8) {
         this.field2864 = var1.method2918();
      } else if(var2 == 9) {
         this.field2858 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field2861 = var1.readShort();
      } else if(var2 == 11) {
         this.field2865 = 0;
      } else if(var2 == 12) {
         this.field2867 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field2868 = var1.readShort();
      } else if(var2 == 14) {
         this.field2865 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field2851 = var1.readUnsignedShort();
         if(this.field2851 == '\uffff') {
            this.field2851 = -1;
         }

         this.field2866 = var1.readUnsignedShort();
         if(this.field2866 == '\uffff') {
            this.field2866 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field2870 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field2870[var5] = var1.readUnsignedShort();
            if(this.field2870[var5] == '\uffff') {
               this.field2870[var5] = -1;
            }
         }

         this.field2870[1 + var4] = var3;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Lclass196;",
      garbageValue = "-251351299"
   )
   public final class196 method3564() {
      int var1 = -1;
      if(this.field2851 != -1) {
         var1 = class10.method127(this.field2851);
      } else if(this.field2866 != -1) {
         var1 = class146.widgetSettings[this.field2866];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field2870.length - 1) {
         var2 = this.field2870[var1];
      } else {
         var2 = this.field2870[this.field2870.length - 1];
      }

      return var2 != -1?class151.method2847(var2):null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1182313776"
   )
   public String method3565(int var1) {
      String var2 = this.field2864;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + Ignore.method206(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-103"
   )
   public SpritePixels method3567() {
      if(this.field2860 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2860);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class60.method1158(field2850, this.field2860, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2860);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "4"
   )
   public SpritePixels method3568() {
      if(this.field2869 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2869);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class60.method1158(field2850, this.field2869, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2869);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1818594247"
   )
   public SpritePixels method3569() {
      if(this.field2862 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2862);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class60.method1158(field2850, this.field2862, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2862);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "0"
   )
   void method3580(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3563(var1, var2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1404098874"
   )
   public SpritePixels method3585() {
      if(this.field2859 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2859);
         if(null != var1) {
            return var1;
         } else {
            var1 = class60.method1158(field2850, this.field2859, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2859);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)LFont;",
      garbageValue = "-1342601451"
   )
   public Font method3586() {
      if(this.field2856 == -1) {
         return null;
      } else {
         Font var1 = (Font)field2854.get((long)this.field2856);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class44.method825(field2850, field2852, this.field2856, 0);
            if(var1 != null) {
               field2854.put(var1, (long)this.field2856);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-78378487"
   )
   public static void method3589() {
      try {
         File var0 = new File(ChatLineBuffer.field968, "random.dat");
         int var2;
         if(var0.exists()) {
            class104.field1693 = new class72(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label38:
            for(int var1 = 0; var1 < class104.field1697.length; ++var1) {
               for(var2 = 0; var2 < FileOnDisk.field1198.length; ++var2) {
                  File var3 = new File(FileOnDisk.field1198[var2] + class104.field1697[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class104.field1693 = new class72(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label38;
                  }
               }
            }
         }

         if(class104.field1693 == null) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class104.field1693 = new class72(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }
}
