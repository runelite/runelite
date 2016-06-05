import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public final class class104 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -817248233
   )
   int field1786;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 213473825
   )
   int field1787;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2072543245
   )
   int field1788;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1710801649
   )
   int field1789;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -772142931
   )
   int field1790;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1266614987
   )
   int field1791;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -256060605
   )
   int field1792;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1449242095
   )
   int field1793;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1381818773
   )
   int field1794;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 29805079
   )
   int field1795;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -995081493
   )
   int field1796;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -765688005
   )
   int field1797;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1691809583
   )
   int field1798;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1733974349
   )
   int field1799;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1293302141
   )
   int field1800;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1027434039
   )
   int field1801;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1068156943
   )
   int field1802;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 50376149
   )
   int field1803;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IS)Z",
      garbageValue = "3"
   )
   static boolean method2249(String var0, int var1) {
      return class185.method3673(var0, var1, "openjs");
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass167;II)Lclass80;",
      garbageValue = "-1405616368"
   )
   public static class80 method2250(class167 var0, int var1) {
      byte[] var3 = var0.method3275(var1);
      boolean var2;
      if(var3 == null) {
         var2 = false;
      } else {
         class163.method3181(var3);
         var2 = true;
      }

      return !var2?null:class16.method165();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "1667752794"
   )
   public static File method2251(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class34.field774 = new File(class149.field2272, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      File var22;
      if(class34.field774.exists()) {
         try {
            class227 var7 = new class227(class34.field774, "rw", 10000L);

            class119 var8;
            int var9;
            for(var8 = new class119((int)var7.method4075()); var8.field2000 < var8.field2001.length; var8.field2000 += var9) {
               var9 = var7.method4086(var8.field2001, var8.field2000, var8.field2001.length - var8.field2000);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.field2000 = 0;
            var9 = var8.method2494();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.method2494();
            }

            if(var9 <= 2) {
               var4 = var8.method2477();
               if(var10 == 1) {
                  var5 = var8.method2477();
               }
            } else {
               var4 = var8.method2478();
               if(var10 == 1) {
                  var5 = var8.method2478();
               }
            }

            var7.method4074();
         } catch (IOException var20) {
            var20.printStackTrace();
         }

         if(var4 != null) {
            var22 = new File(var4);
            if(!var22.exists()) {
               var4 = null;
            }
         }

         if(null != var4) {
            var22 = new File(var4, "test.dat");
            if(!class131.method2810(var22, true)) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label123:
         for(int var15 = 0; var15 < class8.field143.length; ++var15) {
            for(int var16 = 0; var16 < class149.field2271.length; ++var16) {
               File var17 = new File(class149.field2271[var16] + class8.field143[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && class131.method2810(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label123;
               }
            }
         }
      }

      if(null == var4) {
         var4 = class149.field2272 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      if(null != var5) {
         File var21 = new File(var5);
         var22 = new File(var4);

         try {
            File[] var23 = var21.listFiles();
            File[] var18 = var23;

            for(int var11 = 0; var11 < var18.length; ++var11) {
               File var12 = var18[var11];
               File var13 = new File(var22, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var19) {
            var19.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         class59.method1225(new File(var4), (File)null);
      }

      return new File(var4);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1622480721"
   )
   static final void method2252(boolean var0) {
      while(true) {
         if(client.field327.method2715(client.field328) >= 27) {
            int var1 = client.field327.method2713(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(null == client.field320[var1]) {
                  client.field320[var1] = new class34();
                  var2 = true;
               }

               class34 var3 = client.field320[var1];
               client.field322[++client.field293 - 1] = var1;
               var3.field823 = client.field332;
               int var4;
               if(var0) {
                  var4 = client.field327.method2713(8);
                  if(var4 > 127) {
                     var4 -= 256;
                  }
               } else {
                  var4 = client.field327.method2713(5);
                  if(var4 > 15) {
                     var4 -= 32;
                  }
               }

               int var5;
               if(var0) {
                  var5 = client.field327.method2713(8);
                  if(var5 > 127) {
                     var5 -= 256;
                  }
               } else {
                  var5 = client.field327.method2713(5);
                  if(var5 > 15) {
                     var5 -= 32;
                  }
               }

               int var6 = client.field327.method2713(1);
               if(var6 == 1) {
                  client.field285[++client.field323 - 1] = var1;
               }

               var3.field772 = class17.method169(client.field327.method2713(14));
               int var7 = client.field438[client.field327.method2713(3)];
               if(var2) {
                  var3.field831 = var3.field805 = var7;
               }

               int var8 = client.field327.method2713(1);
               var3.field807 = var3.field772.field881;
               var3.field863 = var3.field772.field897;
               if(var3.field863 == 0) {
                  var3.field805 = 0;
               }

               var3.field811 = var3.field772.field898;
               var3.field812 = var3.field772.field890;
               var3.field814 = var3.field772.field889;
               var3.field857 = var3.field772.field903;
               var3.field808 = var3.field772.field886;
               var3.field837 = var3.field772.field877;
               var3.field810 = var3.field772.field888;
               var3.method704(class152.field2301.field847[0] + var5, var4 + class152.field2301.field839[0], var8 == 1);
               continue;
            }
         }

         client.field327.method2714();
         return;
      }
   }
}
