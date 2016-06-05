import java.awt.Canvas;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class59 {
   @ObfuscatedName("h")
   class196 field1220 = new class196(256);
   @ObfuscatedName("qx")
   @Export("canvas")
   public static Canvas field1221;
   @ObfuscatedName("g")
   class196 field1222 = new class196(256);
   @ObfuscatedName("i")
   class167 field1224;
   @ObfuscatedName("t")
   class167 field1225;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass62;",
      garbageValue = "-43"
   )
   class62 method1218(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class62 var7 = (class62)this.field1220.method3748(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class70 var8 = (class70)this.field1222.method3748(var5);
         if(var8 == null) {
            var8 = class70.method1492(this.field1224, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1222.method3749(var8, var5);
         }

         var7 = var8.method1486(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.method3870();
            this.field1220.method3749(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass62;",
      garbageValue = "-2008478074"
   )
   public class62 method1219(int var1, int[] var2) {
      if(this.field1225.method3232() == 1) {
         return this.method1227(0, var1, var2);
      } else if(this.field1225.method3231(var1) == 1) {
         return this.method1227(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass62;",
      garbageValue = "95"
   )
   public class62 method1220(int var1, int[] var2) {
      if(this.field1224.method3232() == 1) {
         return this.method1218(0, var1, var2);
      } else if(this.field1224.method3231(var1) == 1) {
         return this.method1218(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method1221() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < client.field294 - 1; ++var1) {
            if(client.field392[var1] < 1000 && client.field392[1 + var1] > 1000) {
               String var2 = client.field337[var1];
               client.field337[var1] = client.field337[1 + var1];
               client.field337[var1 + 1] = var2;
               String var3 = client.field429[var1];
               client.field429[var1] = client.field429[1 + var1];
               client.field429[var1 + 1] = var3;
               int var4 = client.field392[var1];
               client.field392[var1] = client.field392[var1 + 1];
               client.field392[1 + var1] = var4;
               var4 = client.field425[var1];
               client.field425[var1] = client.field425[1 + var1];
               client.field425[var1 + 1] = var4;
               var4 = client.field426[var1];
               client.field426[var1] = client.field426[var1 + 1];
               client.field426[var1 + 1] = var4;
               var4 = client.field502[var1];
               client.field502[var1] = client.field502[1 + var1];
               client.field502[var1 + 1] = var4;
               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;I)V",
      garbageValue = "1912777288"
   )
   static void method1225(File var0, File var1) {
      try {
         class227 var2 = new class227(class34.field774, "rw", 10000L);
         class119 var3 = new class119(500);
         var3.method2453(3);
         var3.method2453(null != var1?1:0);
         var3.method2461(var0.getPath());
         if(null != var1) {
            var3.method2461(var1.getPath());
         }

         var2.method4073(var3.field2001, 0, var3.field2000);
         var2.method4074();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II[IS)Lclass62;",
      garbageValue = "8229"
   )
   class62 method1227(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class62 var7 = (class62)this.field1220.method3748(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class58 var8 = class58.method1206(this.field1225, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method1207();
            this.field1220.method3749(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1235.length;
            }

            return var7;
         }
      }
   }

   public class59(class167 var1, class167 var2) {
      this.field1225 = var1;
      this.field1224 = var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1554835827"
   )
   static final void method1228(int var0) {
      short var1 = 256;
      class31.field714 += 128 * var0;
      int var2;
      if(class31.field714 > class162.field2678.length) {
         class31.field714 -= class162.field2678.length;
         var2 = (int)(Math.random() * 12.0D);
         class143.method2959(class109.field1916[var2]);
      }

      var2 = 0;
      int var3 = 128 * var0;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class32.field752[var2 + var3] - class162.field2678[var2 + class31.field714 & class162.field2678.length - 1] * var0 / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class32.field752[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = 128 * var5;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class32.field752[var7 + var6] = 255;
            } else {
               class32.field752[var6 + var7] = 0;
            }
         }
      }

      if(class31.field709 > 0) {
         class31.field709 -= 4 * var0;
      }

      if(class31.field710 > 0) {
         class31.field710 -= var0 * 4;
      }

      if(class31.field709 == 0 && class31.field710 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class31.field709 = 1024;
         }

         if(var5 == 1) {
            class31.field710 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class31.field707[var5] = class31.field707[var5 + var0];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class31.field707[var5] = (int)(Math.sin((double)class31.field720 / 14.0D) * 16.0D + Math.sin((double)class31.field720 / 15.0D) * 14.0D + Math.sin((double)class31.field720 / 16.0D) * 12.0D);
         ++class31.field720;
      }

      class31.field729 += var0;
      var5 = ((client.field332 & 1) + var0) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class31.field729 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class32.field752[(var8 << 7) + var7] = 192;
         }

         class31.field729 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var9 + var5 < 128) {
                  var7 += class32.field752[var5 + var8 + var9];
               }

               if(var9 - (1 + var5) >= 0) {
                  var7 -= class32.field752[var8 + var9 - (1 + var5)];
               }

               if(var9 >= 0) {
                  class7.field136[var9 + var8] = var7 / (1 + var5 * 2);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var5 + var8 < var1) {
                  var7 += class7.field136[128 * var5 + var9 + var6];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= class7.field136[var9 + var6 - 128 * (var5 + 1)];
               }

               if(var8 >= 0) {
                  class32.field752[var9 + var6] = var7 / (1 + 2 * var5);
               }
            }
         }
      }

   }
}
