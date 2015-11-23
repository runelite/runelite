package net.runelite.rs.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cu")
@Implements("Tile")
public final class class100 extends class207 {
   @ObfuscatedName("a")
   class96 field1716;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 764072419
   )
   int field1717;
   @ObfuscatedName("e")
   int[] field1718 = new int[5];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 696408695
   )
   int field1719;
   @ObfuscatedName("u")
   class88 field1720;
   @ObfuscatedName("k")
   @Export("itemLayer")
   class98 field1721;
   @ObfuscatedName("h")
   class86 field1722;
   @ObfuscatedName("i")
   class93 field1723;
   @ObfuscatedName("t")
   class92 field1724;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -979755461
   )
   int field1725;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1533965455
   )
   @Export("plane")
   int field1726;
   @ObfuscatedName("w")
   @Export("objects")
   class97[] field1727 = new class97[5];
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 94480263
   )
   int field1728 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2057134613
   )
   @Export("y")
   int field1729;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 378859669
   )
   int field1730;
   @ObfuscatedName("r")
   boolean field1731;
   @ObfuscatedName("g")
   boolean field1732;
   @ObfuscatedName("d")
   class100 field1733;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2107385047
   )
   int field1734;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -932743753
   )
   int field1735;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 954164807
   )
   int field1736;
   @ObfuscatedName("n")
   boolean field1737;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 262047279
   )
   @Export("x")
   int field1738;

   @ObfuscatedName("a")
   static int method2307(class25 var0, class25 var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class128.method2863(var0, var1, var2, var3);
      if(0 != var6) {
         return var3?-var6:var6;
      } else if(-1 == var4) {
         return 0;
      } else {
         int var7 = class128.method2863(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }

   @ObfuscatedName("f")
   static class35 method2308(int var0, int var1) {
      class27 var2 = (class27)class11.field171.get(Integer.valueOf(var0));
      return var2.method681(var1);
   }

   @ObfuscatedName("m")
   static final int method2309(long var0, String var2) {
      Random var3 = new Random();
      class118 var4 = new class118(128);
      class118 var5 = new class118(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.method2521(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2524(var3.nextInt());
      }

      var4.method2524(var6[0]);
      var4.method2524(var6[1]);
      var4.method2690(var0);
      var4.method2690(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2524(var3.nextInt());
      }

      var4.method2555(class9.field149, class9.field147);
      var5.method2521(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.method2524(var3.nextInt());
      }

      var5.method2690(var3.nextLong());
      var5.method2659(var3.nextLong());
      byte[] var22 = new byte[24];

      try {
         class148.field2220.method4188(0L);
         class148.field2220.method4190(var22);

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

      var5.method2530(var22, 0, 24);
      var5.method2690(var3.nextLong());
      var5.method2555(class9.field149, class9.field147);
      var7 = class102.method2318(var2);
      if(0 != var7 % 8) {
         var7 += 8 - var7 % 8;
      }

      class118 var21 = new class118(var7);
      var21.method2527(var2);
      var21.field1981 = var7;
      var21.method2551(var6);
      class118 var23 = new class118(var21.field1981 + var5.field1981 + 5 + var4.field1981);
      var23.method2521(2);
      var23.method2521(var4.field1981);
      var23.method2530(var4.field1980, 0, var4.field1981);
      var23.method2521(var5.field1981);
      var23.method2530(var5.field1980, 0, var5.field1981);
      var23.method2522(var21.field1981);
      var23.method2530(var21.field1980, 0, var21.field1981);
      byte[] var11 = var23.field1980;
      int var13 = var11.length;
      StringBuilder var14 = new StringBuilder();

      int var17;
      for(int var15 = 0; var15 < 0 + var13; var15 += 3) {
         int var16 = var11[var15] & 255;
         var14.append(class160.field2624[var16 >>> 2]);
         if(var15 < var13 - 1) {
            var17 = var11[1 + var15] & 255;
            var14.append(class160.field2624[(var16 & 3) << 4 | var17 >>> 4]);
            if(var15 < var13 - 2) {
               int var18 = var11[2 + var15] & 255;
               var14.append(class160.field2624[(var17 & 15) << 2 | var18 >>> 6]).append(class160.field2624[var18 & 63]);
            } else {
               var14.append(class160.field2624[(var17 & 15) << 2]).append("=");
            }
         } else {
            var14.append(class160.field2624[(var16 & 3) << 4]).append("==");
         }
      }

      String var12 = var14.toString();
      var12 = var12;

      try {
         URL var24 = new URL(class22.method617("services", false) + "m=accountappeal/login.ws");
         URLConnection var25 = var24.openConnection();
         var25.setDoInput(true);
         var25.setDoOutput(true);
         var25.setConnectTimeout(5000);
         OutputStreamWriter var26 = new OutputStreamWriter(var25.getOutputStream());
         var26.write("data2=" + class28.method699(var12) + "&dest=" + class28.method699("passwordchoice.ws"));
         var26.flush();
         InputStream var27 = var25.getInputStream();
         var23 = new class118(new byte[1000]);

         do {
            var17 = var27.read(var23.field1980, var23.field1981, 1000 - var23.field1981);
            if(-1 == var17) {
               var26.close();
               var27.close();
               String var28 = new String(var23.field1980);
               if(var28.startsWith("OFFLINE")) {
                  return 4;
               } else if(var28.startsWith("WRONG")) {
                  return 7;
               } else if(var28.startsWith("RELOAD")) {
                  return 3;
               } else if(var28.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var23.method2592(var6);

                  while(var23.field1981 > 0 && var23.field1980[var23.field1981 - 1] == 0) {
                     --var23.field1981;
                  }

                  var28 = new String(var23.field1980, 0, var23.field1981);
                  if(class0.method0(var28)) {
                     class158.method3209(var28, true);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var23.field1981 += var17;
         } while(var23.field1981 < 1000);

         return 5;
      } catch (Throwable var19) {
         var19.printStackTrace();
         return 5;
      }
   }

   class100(int var1, int var2, int var3) {
      this.field1719 = this.field1726 = var1;
      this.field1738 = var2;
      this.field1729 = var3;
   }
}
