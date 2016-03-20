import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ce")
public final class class103 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1983383777
   )
   int field1766;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1430202317
   )
   int field1767;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2084646481
   )
   int field1768;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 399332467
   )
   int field1769;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1390430617
   )
   int field1770;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -178857091
   )
   int field1771;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1770748979
   )
   int field1772;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1183310869
   )
   int field1773;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -76957145
   )
   int field1775;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2122998395
   )
   int field1776;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1235781481
   )
   int field1777;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -632060381
   )
   int field1778;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1049917739
   )
   int field1779;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -555051381
   )
   int field1780;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 478040193
   )
   int field1781;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -236114465
   )
   int field1782;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -349977015
   )
   int field1783;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 364625093
   )
   int field1785;

   @ObfuscatedName("ba")
   static void method2300() {
      if(client.field448) {
         class172 var0 = class13.method183(class8.field135, client.field382);
         if(null != var0 && var0.field2856 != null) {
            class0 var1 = new class0();
            var1.field6 = var0;
            var1.field8 = var0.field2856;
            class150.method3148(var1);
         }

         client.field448 = false;
         class36.method745(var0);
      }
   }

   @ObfuscatedName("a")
   public static final void method2301(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var7) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var6) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var5) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("a")
   public static final boolean method2302(String var0, String var1, String var2, String var3) {
      return null != var0 && null != var2?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   @ObfuscatedName("f")
   public static boolean method2303(int var0) {
      if(class172.field2733[var0]) {
         return true;
      } else if(!class172.field2782.method3295(var0)) {
         return false;
      } else {
         int var1 = class172.field2782.method3273(var0);
         if(0 == var1) {
            class172.field2733[var0] = true;
            return true;
         } else {
            if(null == class172.field2850[var0]) {
               class172.field2850[var0] = new class172[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == class172.field2850[var0][var2]) {
                  byte[] var3 = class172.field2782.method3263(var0, var2);
                  if(var3 != null) {
                     class172.field2850[var0][var2] = new class172();
                     class172.field2850[var0][var2].field2800 = (var2 + (var0 << 16)) * -1;
                     if(var3[0] == -1) {
                        class172.field2850[var0][var2].method3416(new class118(var3));
                     } else {
                        class172.field2850[var0][var2].method3415(new class118(var3));
                     }
                  }
               }
            }

            class172.field2733[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("r")
   static final int method2304(long var0, String var2) {
      Random var3 = new Random();
      class118 var4 = new class118(128);
      class118 var5 = new class118(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.method2497(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2663(var3.nextInt());
      }

      var4.method2663(var6[0]);
      var4.method2663(var6[1]);
      var4.method2670(var0);
      var4.method2670(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2663(var3.nextInt());
      }

      var4.method2551(class9.field144, class9.field153);
      var5.method2497(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.method2663(var3.nextInt());
      }

      var5.method2670(var3.nextLong());
      var5.method2501(var3.nextLong());
      byte[] var22 = new byte[24];

      try {
         class148.field2223.method4173(0L);
         class148.field2223.method4175(var22);

         int var8;
         for(var8 = 0; var8 < 24 && var22[var8] == 0; ++var8) {
            ;
         }

         if(var8 >= 24) {
            throw new IOException();
         }
      } catch (Exception var20) {
         for(int var9 = 0; var9 < 24; ++var9) {
            var22[var9] = -1;
         }
      }

      var5.method2699(var22, 0, 24);
      var5.method2670(var3.nextLong());
      var5.method2551(class9.field144, class9.field153);
      var7 = class22.method578(var2);
      if(0 != var7 % 8) {
         var7 += 8 - var7 % 8;
      }

      class118 var21 = new class118(var7);
      var21.method2503(var2);
      var21.field1979 = var7;
      var21.method2528(var6);
      class118 var23 = new class118(5 + var4.field1979 + var5.field1979 + var21.field1979);
      var23.method2497(2);
      var23.method2497(var4.field1979);
      var23.method2699(var4.field1980, 0, var4.field1979);
      var23.method2497(var5.field1979);
      var23.method2699(var5.field1980, 0, var5.field1979);
      var23.method2498(var21.field1979);
      var23.method2699(var21.field1980, 0, var21.field1979);
      String var10 = class35.method738(var23.field1980);

      try {
         URL var11 = new URL(class93.method2183("services", false) + "m=accountappeal/login.ws");
         URLConnection var12 = var11.openConnection();
         var12.setDoInput(true);
         var12.setDoOutput(true);
         var12.setConnectTimeout(5000);
         OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
         var13.write("data2=" + class180.method3546(var10) + "&dest=" + class180.method3546("passwordchoice.ws"));
         var13.flush();
         InputStream var14 = var12.getInputStream();
         var23 = new class118(new byte[1000]);

         do {
            int var15 = var14.read(var23.field1980, var23.field1979, 1000 - var23.field1979);
            if(-1 == var15) {
               var13.close();
               var14.close();
               String var24 = new String(var23.field1980);
               if(var24.startsWith("OFFLINE")) {
                  return 4;
               } else if(var24.startsWith("WRONG")) {
                  return 7;
               } else if(var24.startsWith("RELOAD")) {
                  return 3;
               } else if(var24.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var23.method2529(var6);

                  while(var23.field1979 > 0 && 0 == var23.field1980[var23.field1979 - 1]) {
                     --var23.field1979;
                  }

                  var24 = new String(var23.field1980, 0, var23.field1979);
                  boolean var16;
                  if(null == var24) {
                     var16 = false;
                  } else {
                     label102: {
                        try {
                           new URL(var24);
                        } catch (MalformedURLException var18) {
                           var16 = false;
                           break label102;
                        }

                        var16 = true;
                     }
                  }

                  if(var16) {
                     class32.method710(var24, true);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var23.field1979 += var15;
         } while(var23.field1979 < 1000);

         return 5;
      } catch (Throwable var19) {
         var19.printStackTrace();
         return 5;
      }
   }
}
