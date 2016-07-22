import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class8 {
   @ObfuscatedName("l")
   LinkedHashMap field126 = new LinkedHashMap();
   @ObfuscatedName("e")
   boolean field127;
   @ObfuscatedName("ev")
   static class81[] field131;
   @ObfuscatedName("o")
   boolean field132;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -759229081
   )
   int field136 = 1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1507105021
   )
   static int field137 = 4;

   class8() {
      this.method107(true);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "22"
   )
   void method107(boolean var1) {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Lclass122;",
      garbageValue = "1008909453"
   )
   class122 method108() {
      class122 var1 = new class122(100);
      var1.method2557(field137);
      var1.method2557(this.field127?1:0);
      var1.method2557(this.field132?1:0);
      var1.method2557(this.field136);
      var1.method2557(this.field126.size());
      Iterator var2 = this.field126.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2560(((Integer)var3.getKey()).intValue());
         var1.method2560(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   class8(class122 var1) {
      if(var1 != null && var1.field2047 != null) {
         int var2 = var1.method2556();
         if(var2 >= 0 && var2 <= field137) {
            if(var1.method2556() == 1) {
               this.field127 = true;
            }

            if(var2 > 1) {
               this.field132 = var1.method2556() == 1;
            }

            if(var2 > 3) {
               this.field136 = var1.method2556();
            }

            if(var2 > 2) {
               int var3 = var1.method2556();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2577();
                  int var6 = var1.method2577();
                  this.field126.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method107(true);
         }
      } else {
         this.method107(true);
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lclass39;B)V",
      garbageValue = "15"
   )
   static final void method109(class39 var0) {
      if(var0.field883 != 0) {
         if(var0.field856 != -1) {
            Object var1 = null;
            if(var0.field856 < '耀') {
               var1 = client.field308[var0.field856];
            } else if(var0.field856 >= '耀') {
               var1 = client.field393[var0.field856 - '耀'];
            }

            if(null != var1) {
               int var2 = var0.field864 - ((class39)var1).field864;
               int var3 = var0.field831 - ((class39)var1).field831;
               if(var2 != 0 || var3 != 0) {
                  var0.field881 = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field857) {
               var0.field856 = -1;
               var0.field857 = false;
            }
         }

         if(var0.field867 != -1 && (var0.field875 == 0 || var0.field888 > 0)) {
            var0.field881 = var0.field867;
            var0.field867 = -1;
         }

         int var4 = var0.field881 - var0.field832 & 2047;
         if(var4 == 0 && var0.field857) {
            var0.field856 = -1;
            var0.field857 = false;
         }

         if(var4 != 0) {
            ++var0.field882;
            boolean var6;
            if(var4 > 1024) {
               var0.field832 -= var0.field883;
               var6 = true;
               if(var4 < var0.field883 || var4 > 2048 - var0.field883) {
                  var0.field832 = var0.field881;
                  var6 = false;
               }

               if(var0.field859 == var0.field847 && (var0.field882 > 25 || var6)) {
                  if(var0.field876 != -1) {
                     var0.field859 = var0.field876;
                  } else {
                     var0.field859 = var0.field839;
                  }
               }
            } else {
               var0.field832 += var0.field883;
               var6 = true;
               if(var4 < var0.field883 || var4 > 2048 - var0.field883) {
                  var0.field832 = var0.field881;
                  var6 = false;
               }

               if(var0.field847 == var0.field859 && (var0.field882 > 25 || var6)) {
                  if(var0.field837 != -1) {
                     var0.field859 = var0.field837;
                  } else {
                     var0.field859 = var0.field839;
                  }
               }
            }

            var0.field832 &= 2047;
         } else {
            var0.field882 = 0;
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Ljava/lang/String;Ljava/lang/String;I)Lclass227;",
      garbageValue = "1458329296"
   )
   public static class227 method115(class170 var0, class170 var1, String var2, String var3) {
      int var4 = var0.method3319(var2);
      int var5 = var0.method3368(var4, var3);
      return class143.method3029(var0, var1, var4, var5);
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "([Lclass176;II)V",
      garbageValue = "-1874592522"
   )
   static final void method116(class176[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class176 var3 = var0[var2];
         if(var3 != null) {
            if(var3.field2929 == 0) {
               if(var3.field2919 != null) {
                  method116(var3.field2919, var1);
               }

               class3 var4 = (class3)client.field535.method3856((long)var3.field2795);
               if(null != var4) {
                  class178.method3501(var4.field66, var1);
               }
            }

            class0 var5;
            if(var1 == 0 && null != var3.field2902) {
               var5 = new class0();
               var5.field3 = var3;
               var5.field1 = var3.field2902;
               class43.method884(var5, 200000);
            }

            if(var1 == 1 && null != var3.field2903) {
               if(var3.field2796 >= 0) {
                  class176 var6 = class34.method720(var3.field2795);
                  if(null == var6 || null == var6.field2919 || var3.field2796 >= var6.field2919.length || var3 != var6.field2919[var3.field2796]) {
                     continue;
                  }
               }

               var5 = new class0();
               var5.field3 = var3;
               var5.field1 = var3.field2903;
               class43.method884(var5, 200000);
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)[Lclass21;",
      garbageValue = "5615"
   )
   static class21[] method117() {
      return new class21[]{class21.field568, class21.field569, class21.field581, class21.field570};
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "16711680"
   )
   public static File method118(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class152.field2292 = new File(class52.field1155, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      class122 var8;
      File var23;
      if(class152.field2292.exists()) {
         try {
            class230 var7 = new class230(class152.field2292, "rw", 10000L);

            int var9;
            for(var8 = new class122((int)var7.method4214()); var8.field2045 < var8.field2047.length; var8.field2045 += var9) {
               var9 = var7.method4210(var8.field2047, var8.field2045, var8.field2047.length - var8.field2045);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.field2045 = 0;
            var9 = var8.method2556();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.method2556();
            }

            if(var9 <= 2) {
               var4 = var8.method2581();
               if(var10 == 1) {
                  var5 = var8.method2581();
               }
            } else {
               var4 = var8.method2582();
               if(var10 == 1) {
                  var5 = var8.method2582();
               }
            }

            var7.method4223();
         } catch (IOException var21) {
            var21.printStackTrace();
         }

         if(var4 != null) {
            var23 = new File(var4);
            if(!var23.exists()) {
               var4 = null;
            }
         }

         if(null != var4) {
            var23 = new File(var4, "test.dat");
            if(!class114.method2490(var23, true)) {
               var4 = null;
            }
         }
      }

      if(null == var4 && var2 == 0) {
         label129:
         for(int var15 = 0; var15 < class52.field1154.length; ++var15) {
            for(int var16 = 0; var16 < class53.field1159.length; ++var16) {
               File var17 = new File(class53.field1159[var16] + class52.field1154[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && class114.method2490(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label129;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class52.field1155 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      File var22;
      if(null != var5) {
         var22 = new File(var5);
         var23 = new File(var4);

         try {
            File[] var24 = var22.listFiles();
            File[] var18 = var24;

            for(int var11 = 0; var11 < var18.length; ++var11) {
               File var12 = var18[var11];
               File var13 = new File(var23, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var20) {
            var20.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         var22 = new File(var4);
         var8 = null;

         try {
            class230 var25 = new class230(class152.field2292, "rw", 10000L);
            class122 var26 = new class122(500);
            var26.method2557(3);
            Object var10001 = null;
            var26.method2557(0);
            var26.method2565(var22.getPath());
            Object var10000 = null;
            var25.method4207(var26.field2047, 0, var26.field2045);
            var25.method4223();
         } catch (IOException var19) {
            var19.printStackTrace();
         }
      }

      return new File(var4);
   }
}
