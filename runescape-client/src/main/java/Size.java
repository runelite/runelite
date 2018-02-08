import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("Size")
public class Size {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   public static final Size field345;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   public static final Size field344;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   public static final Size field343;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static IndexedSprite field350;
   @ObfuscatedName("h")
   final String field346;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -219564825
   )
   final int field347;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1786310579
   )
   final int field348;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1961744397
   )
   final int field349;

   static {
      field345 = new Size("SMALL", 1, 0, 4);
      field344 = new Size("MEDIUM", 2, 1, 2);
      field343 = new Size("LARGE", 0, 2, 0);
   }

   Size(String var1, int var2, int var3, int var4) {
      this.field346 = var1;
      this.field347 = var2;
      this.field348 = var3;
      this.field349 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "948584451"
   )
   boolean method176(float var1) {
      return var1 >= (float)this.field349;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Ljt;",
      garbageValue = "-231581533"
   )
   public static class265 method181(int var0) {
      class265 var1 = (class265)class265.field3490.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class265.field3500.getConfigData(32, var0);
         var1 = new class265();
         if(var2 != null) {
            var1.method4884(new Buffer(var2));
         }

         class265.field3490.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Lv;",
      garbageValue = "-29"
   )
   static Size method177(int var0) {
      Size[] var1 = new Size[]{field345, field343, field344};
      Size[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Size var4 = var2[var3];
         if(var0 == var4.field348) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-1241627329"
   )
   static boolean method183(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "71"
   )
   static final void method175(int var0) {
      int[] var1 = SoundTask.minimapSprite.pixels;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class62.tileSettings[var0][var5][var3] & 24) == 0) {
               TotalQuantityComparator.region.method2984(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class62.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               TotalQuantityComparator.region.method2984(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      SoundTask.minimapSprite.method5677();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class62.tileSettings[var0][var6][var5] & 24) == 0) {
               GraphicsObject.method1835(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class62.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               GraphicsObject.method1835(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field1050 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = TotalQuantityComparator.region.method2933(class60.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class219.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  Client.mapIcons[Client.field1050] = Area.mapAreaType[var8].getMapIcon(false);
                  Client.field1034[Client.field1050] = var5;
                  Client.field1052[Client.field1050] = var6;
                  ++Client.field1050;
               }
            }
         }
      }

      class22.rasterProvider.setRaster();
   }
}
