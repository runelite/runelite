import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public class class90 {
   @ObfuscatedName("e")
   public static boolean field1568;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lclass33;B)V",
      garbageValue = "0"
   )
   static final void method2164(class33 var0) {
      if(class5.field93.field844 >> 7 == client.field528 && class5.field93.field819 >> 7 == client.field347) {
         client.field528 = 0;
      }

      int var1 = class32.field771;
      int[] var2 = class32.field762;
      int var3 = var1;
      if(class33.field783 == var0 || class33.field777 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         class2 var5;
         int var6;
         if(class33.field783 == var0) {
            var5 = class5.field93;
            var6 = class5.field93.field49 << 14;
         } else if(class33.field777 == var0) {
            var5 = client.field550[client.field424];
            var6 = client.field424 << 14;
         } else {
            var5 = client.field550[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class33.field779 && var2[var4] == client.field424) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod836() && !var5.field51) {
            var5.field37 = false;
            if((client.field302 && var1 > 50 || var1 > 200) && class33.field783 != var0 && var5.field845 == var5.field822) {
               var5.field37 = true;
            }

            int var7 = var5.field844 >> 7;
            int var8 = var5.field819 >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.field46 != null && client.field306 >= var5.field35 && client.field306 < var5.field42) {
                  var5.field37 = false;
                  var5.field40 = class34.method816(var5.field844, var5.field819, class42.field1002);
                  class30.field717.method2020(class42.field1002, var5.field844, var5.field819, var5.field40, 60, var5, var5.field863, var6, var5.field47, var5.field48, var5.field52, var5.field53);
               } else {
                  if(64 == (var5.field844 & 127) && (var5.field819 & 127) == 64) {
                     if(client.field398[var7][var8] == client.field399) {
                        continue;
                     }

                     client.field398[var7][var8] = client.field399;
                  }

                  var5.field40 = class34.method816(var5.field844, var5.field819, class42.field1002);
                  class30.field717.method2019(class42.field1002, var5.field844, var5.field819, var5.field40, 60, var5, var5.field863, var6, var5.field820);
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IILclass107;Lclass108;I)Z",
      garbageValue = "-481103265"
   )
   static final boolean method2165(int var0, int var1, class107 var2, class108 var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class106.field1860[var6][var7] = 99;
      class106.field1862[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class106.field1866[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class106.field1863[var10001] = var1;
      int[][] var12 = var3.field1896;

      while(var11 != var18) {
         var4 = class106.field1866[var11];
         var5 = class106.field1863[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.field1892;
         int var14 = var5 - var3.field1893;
         if(var2.vmethod2480(1, var4, var5, var3)) {
            class24.field635 = var4;
            class50.field1107 = var5;
            return true;
         }

         int var15 = class106.field1862[var16][var17] + 1;
         if(var16 > 0 && 0 == class106.field1860[var16 - 1][var17] && 0 == (var12[var13 - 1][var14] & 19136776)) {
            class106.field1866[var18] = var4 - 1;
            class106.field1863[var18] = var5;
            var18 = 1 + var18 & 4095;
            class106.field1860[var16 - 1][var17] = 2;
            class106.field1862[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class106.field1860[1 + var16][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class106.field1866[var18] = 1 + var4;
            class106.field1863[var18] = var5;
            var18 = var18 + 1 & 4095;
            class106.field1860[var16 + 1][var17] = 8;
            class106.field1862[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && 0 == class106.field1860[var16][var17 - 1] && (var12[var13][var14 - 1] & 19136770) == 0) {
            class106.field1866[var18] = var4;
            class106.field1863[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class106.field1860[var16][var17 - 1] = 1;
            class106.field1862[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class106.field1860[var16][1 + var17] == 0 && 0 == (var12[var13][var14 + 1] & 19136800)) {
            class106.field1866[var18] = var4;
            class106.field1863[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class106.field1860[var16][var17 + 1] = 4;
            class106.field1862[var16][1 + var17] = var15;
         }

         if(var16 > 0 && var17 > 0 && class106.field1860[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class106.field1866[var18] = var4 - 1;
            class106.field1863[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class106.field1860[var16 - 1][var17 - 1] = 3;
            class106.field1862[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && 0 == class106.field1860[1 + var16][var17 - 1] && (var12[1 + var13][var14 - 1] & 19136899) == 0 && 0 == (var12[var13 + 1][var14] & 19136896) && 0 == (var12[var13][var14 - 1] & 19136770)) {
            class106.field1866[var18] = 1 + var4;
            class106.field1863[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class106.field1860[1 + var16][var17 - 1] = 9;
            class106.field1862[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class106.field1860[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && 0 == (var12[var13 - 1][var14] & 19136776) && 0 == (var12[var13][var14 + 1] & 19136800)) {
            class106.field1866[var18] = var4 - 1;
            class106.field1863[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class106.field1860[var16 - 1][var17 + 1] = 6;
            class106.field1862[var16 - 1][1 + var17] = var15;
         }

         if(var16 < 127 && var17 < 127 && class106.field1860[1 + var16][var17 + 1] == 0 && 0 == (var12[var13 + 1][var14 + 1] & 19136992) && (var12[var13 + 1][var14] & 19136896) == 0 && 0 == (var12[var13][var14 + 1] & 19136800)) {
            class106.field1866[var18] = var4 + 1;
            class106.field1863[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class106.field1860[1 + var16][1 + var17] = 12;
            class106.field1862[var16 + 1][1 + var17] = var15;
         }
      }

      class24.field635 = var4;
      class50.field1107 = var5;
      return false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-1979088247"
   )
   public static File method2166(String var0) {
      if(!class135.field2081) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class135.field2083.get(var0);
         if(null != var1) {
            return var1;
         } else {
            File var2 = new File(class135.field2090, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class135.field2083.put(var0, var2);
                  return var2;
               }
            } catch (Exception var7) {
               try {
                  if(null != var3) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var6) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIII)V",
      garbageValue = "-1237000317"
   )
   static final void method2167(class173 var0, int var1, int var2, int var3) {
      class175 var4 = var0.method3487(false);
      if(var4 != null) {
         if(client.field530 < 3) {
            class87.field1539.method1809(var1, var2, var4.field2901, var4.field2900, 25, 25, client.field379, 256, var4.field2902, var4.field2899);
         } else {
            class79.method1908(var1, var2, 0, var4.field2902, var4.field2899);
         }

      }
   }
}
