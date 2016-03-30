import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
public class class52 extends class204 {
   @ObfuscatedName("pl")
   static class221 field1164;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -583315863
   )
   public static int field1165;
   @ObfuscatedName("w")
   static class167 field1166;
   @ObfuscatedName("gp")
   static class173 field1167;
   @ObfuscatedName("h")
   public static String field1168;
   @ObfuscatedName("t")
   public static class193 field1169 = new class193(64);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1072903265
   )
   public int field1171 = 0;

   @ObfuscatedName("p")
   void method1104(class119 var1, int var2) {
      if(var2 == 5) {
         this.field1171 = var1.method2508();
      }

   }

   @ObfuscatedName("t")
   void method1105(class119 var1) {
      while(true) {
         int var2 = var1.method2506();
         if(0 == var2) {
            return;
         }

         this.method1104(var1, var2);
      }
   }

   @ObfuscatedName("x")
   static final int method1112(long var0, String var2) {
      Random var3 = new Random();
      class119 var4 = new class119(128);
      class119 var5 = new class119(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.method2573(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2494(var3.nextInt());
      }

      var4.method2494(var6[0]);
      var4.method2494(var6[1]);
      var4.method2496(var0);
      var4.method2496(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2494(var3.nextInt());
      }

      var4.method2526(class9.field168, class9.field170);
      var5.method2573(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.method2494(var3.nextInt());
      }

      var5.method2496(var3.nextLong());
      var5.method2495(var3.nextLong());
      byte[] var23 = new byte[24];

      try {
         class149.field2252.method4169(0L);
         class149.field2252.method4154(var23);

         int var8;
         for(var8 = 0; var8 < 24 && 0 == var23[var8]; ++var8) {
            ;
         }

         if(var8 >= 24) {
            throw new IOException();
         }
      } catch (Exception var21) {
         for(int var9 = 0; var9 < 24; ++var9) {
            var23[var9] = -1;
         }
      }

      var5.method2606(var23, 0, 24);
      var5.method2496(var3.nextLong());
      var5.method2526(class9.field168, class9.field170);
      var7 = class45.method992(var2);
      if(0 != var7 % 8) {
         var7 += 8 - var7 % 8;
      }

      class119 var22 = new class119(var7);
      var22.method2661(var2);
      var22.field2011 = var7;
      var22.method2522(var6);
      class119 var24 = new class119(var22.field2011 + var5.field2011 + 5 + var4.field2011);
      var24.method2573(2);
      var24.method2573(var4.field2011);
      var24.method2606(var4.field2012, 0, var4.field2011);
      var24.method2573(var5.field2011);
      var24.method2606(var5.field2012, 0, var5.field2011);
      var24.method2492(var22.field2011);
      var24.method2606(var22.field2012, 0, var22.field2011);
      String var10 = class90.method2080(var24.field2012);

      try {
         URL var11 = new URL(class36.method763("services", false) + "m=accountappeal/login.ws");
         URLConnection var12 = var11.openConnection();
         var12.setDoInput(true);
         var12.setDoOutput(true);
         var12.setConnectTimeout(5000);
         OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
         var13.write("data2=" + class22.method596(var10) + "&dest=" + class22.method596("passwordchoice.ws"));
         var13.flush();
         InputStream var14 = var12.getInputStream();
         var24 = new class119(new byte[1000]);

         do {
            int var15 = var14.read(var24.field2012, var24.field2011, 1000 - var24.field2011);
            if(var15 == -1) {
               var13.close();
               var14.close();
               String var25 = new String(var24.field2012);
               if(var25.startsWith("OFFLINE")) {
                  return 4;
               } else if(var25.startsWith("WRONG")) {
                  return 7;
               } else if(var25.startsWith("RELOAD")) {
                  return 3;
               } else if(var25.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var24.method2523(var6);

                  while(var24.field2011 > 0 && 0 == var24.field2012[var24.field2011 - 1]) {
                     --var24.field2011;
                  }

                  var25 = new String(var24.field2012, 0, var24.field2011);
                  boolean var16;
                  if(null == var25) {
                     var16 = false;
                  } else {
                     label125: {
                        try {
                           new URL(var25);
                        } catch (MalformedURLException var19) {
                           var16 = false;
                           break label125;
                        }

                        var16 = true;
                     }
                  }

                  if(!var16) {
                     return 5;
                  } else {
                     if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                        try {
                           Desktop.getDesktop().browse(new URI(var25));
                           return 2;
                        } catch (Exception var18) {
                           ;
                        }
                     }

                     if(class138.field2151.startsWith("win")) {
                        class35.method749(var25, 0, "openjs");
                     } else if(class138.field2151.startsWith("mac")) {
                        class35.method749(var25, 1, "openjs");
                     } else {
                        class35.method749(var25, 2, "openjs");
                     }

                     return 2;
                  }
               }
            }

            var24.field2011 += var15;
         } while(var24.field2011 < 1000);

         return 5;
      } catch (Throwable var20) {
         var20.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("w")
   static void method1113() {
      class5.field108 = 99;
      class34.field782 = new byte[4][104][104];
      class5.field93 = new byte[4][104][104];
      class137.field2147 = new byte[4][104][104];
      class114.field1985 = new byte[4][104][104];
      class3.field72 = new int[4][105][105];
      class129.field2062 = new byte[4][105][105];
      class5.field97 = new int[105][105];
      class5.field94 = new int[104];
      class161.field2667 = new int[104];
      class134.field2090 = new int[104];
      class95.field1635 = new int[104];
      class95.field1637 = new int[104];
   }

   @ObfuscatedName("t")
   public static int method1114(CharSequence var0, int var1) {
      return class156.method3194(var0, var1);
   }

   @ObfuscatedName("x")
   public static class173 method1115(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(class173.field2830[var1] == null || class173.field2830[var1][var2] == null) {
         boolean var3 = class39.method817(var1);
         if(!var3) {
            return null;
         }
      }

      return class173.field2830[var1][var2];
   }

   @ObfuscatedName("e")
   public static void method1116(int var0) {
      class183.field2968 = 1;
      class151.field2279 = null;
      class72.field1358 = -1;
      class183.field2964 = -1;
      class183.field2970 = 0;
      class14.field225 = false;
      class75.field1384 = var0;
   }
}
