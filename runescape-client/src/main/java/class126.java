import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public final class class126 {
   @ObfuscatedName("l")
   int[] field2072 = new int[256];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1521367643
   )
   int field2074;
   @ObfuscatedName("g")
   int[] field2075 = new int[256];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1940529233
   )
   int field2077;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2058944505
   )
   int field2079;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1062983967
   )
   int field2082;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2038516846"
   )
   final void method2825() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2075[var1];
         var3 += this.field2075[var1 + 1];
         var4 += this.field2075[2 + var1];
         var5 += this.field2075[var1 + 3];
         var6 += this.field2075[4 + var1];
         var7 += this.field2075[5 + var1];
         var8 += this.field2075[var1 + 6];
         var9 += this.field2075[7 + var1];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2072[var1] = var2;
         this.field2072[1 + var1] = var3;
         this.field2072[var1 + 2] = var4;
         this.field2072[3 + var1] = var5;
         this.field2072[4 + var1] = var6;
         this.field2072[5 + var1] = var7;
         this.field2072[6 + var1] = var8;
         this.field2072[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2072[var1];
         var3 += this.field2072[var1 + 1];
         var4 += this.field2072[2 + var1];
         var5 += this.field2072[var1 + 3];
         var6 += this.field2072[4 + var1];
         var7 += this.field2072[var1 + 5];
         var8 += this.field2072[6 + var1];
         var9 += this.field2072[7 + var1];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2072[var1] = var2;
         this.field2072[var1 + 1] = var3;
         this.field2072[2 + var1] = var4;
         this.field2072[3 + var1] = var5;
         this.field2072[var1 + 4] = var6;
         this.field2072[var1 + 5] = var7;
         this.field2072[var1 + 6] = var8;
         this.field2072[7 + var1] = var9;
      }

      this.method2834();
      this.field2082 = 256;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "0"
   )
   public static int method2827(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   class126(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2075[var2] = var1[var2];
      }

      this.method2825();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "72"
   )
   final int method2831() {
      if(--this.field2082 + 1 == 0) {
         this.method2834();
         this.field2082 = 255;
      }

      return this.field2075[this.field2082];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "121"
   )
   final void method2834() {
      this.field2079 += ++this.field2074;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2072[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2077 ^= this.field2077 << 13;
            } else {
               this.field2077 ^= this.field2077 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2077 ^= this.field2077 << 2;
         } else {
            this.field2077 ^= this.field2077 >>> 16;
         }

         this.field2077 += this.field2072[var1 + 128 & 255];
         int var3;
         this.field2072[var1] = var3 = this.field2077 + this.field2072[(var2 & 1020) >> 2] + this.field2079;
         this.field2075[var1] = this.field2079 = var2 + this.field2072[(var3 >> 8 & 1020) >> 2];
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "534652530"
   )
   static void method2835() {
      class33.field758 = class33.field758.trim();
      if(class33.field758.length() == 0) {
         method2836("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class22.method569();
         byte var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            String var4 = class33.field758;
            Random var5 = new Random();
            class122 var6 = new class122(128);
            class122 var7 = new class122(128);
            int[] var8 = new int[]{var5.nextInt(), var5.nextInt(), (int)(var1 >> 32), (int)var1};
            var6.method2557(10);

            int var9;
            for(var9 = 0; var9 < 4; ++var9) {
               var6.method2560(var5.nextInt());
            }

            var6.method2560(var8[0]);
            var6.method2560(var8[1]);
            var6.method2562(var1);
            var6.method2562(0L);

            for(var9 = 0; var9 < 4; ++var9) {
               var6.method2560(var5.nextInt());
            }

            var6.method2673(class9.field141, class9.field142);
            var7.method2557(10);

            for(var9 = 0; var9 < 3; ++var9) {
               var7.method2560(var5.nextInt());
            }

            var7.method2562(var5.nextLong());
            var7.method2561(var5.nextLong());
            class129.method2869(var7);
            var7.method2562(var5.nextLong());
            var7.method2673(class9.field141, class9.field142);
            var9 = class77.method1679(var4);
            if(var9 % 8 != 0) {
               var9 += 8 - var9 % 8;
            }

            class122 var10 = new class122(var9);
            var10.method2563(var4);
            var10.field2045 = var9;
            var10.method2588(var8);
            class122 var11 = new class122(var10.field2045 + 5 + var6.field2045 + var7.field2045);
            var11.method2557(2);
            var11.method2557(var6.field2045);
            var11.method2742(var6.field2047, 0, var6.field2045);
            var11.method2557(var7.field2045);
            var11.method2742(var7.field2047, 0, var7.field2045);
            var11.method2558(var10.field2045);
            var11.method2742(var10.field2047, 0, var10.field2045);
            byte[] var13 = var11.field2047;
            int var15 = var13.length;
            StringBuilder var16 = new StringBuilder();

            int var19;
            for(int var17 = 0; var17 < var15 + 0; var17 += 3) {
               int var18 = var13[var17] & 255;
               var16.append(class164.field2702[var18 >>> 2]);
               if(var17 < var15 - 1) {
                  var19 = var13[1 + var17] & 255;
                  var16.append(class164.field2702[(var18 & 3) << 4 | var19 >>> 4]);
                  if(var17 < var15 - 2) {
                     int var20 = var13[var17 + 2] & 255;
                     var16.append(class164.field2702[(var19 & 15) << 2 | var20 >>> 6]).append(class164.field2702[var20 & 63]);
                  } else {
                     var16.append(class164.field2702[(var19 & 15) << 2]).append("=");
                  }
               } else {
                  var16.append(class164.field2702[(var18 & 3) << 4]).append("==");
               }
            }

            String var14 = var16.toString();
            var14 = var14;

            byte var3;
            try {
               URL var22 = new URL(class177.method3494("services", false) + "m=accountappeal/login.ws");
               URLConnection var28 = var22.openConnection();
               var28.setDoInput(true);
               var28.setDoOutput(true);
               var28.setConnectTimeout(5000);
               OutputStreamWriter var23 = new OutputStreamWriter(var28.getOutputStream());
               var23.write("data2=" + class153.method3191(var14) + "&dest=" + class153.method3191("passwordchoice.ws"));
               var23.flush();
               InputStream var24 = var28.getInputStream();
               var11 = new class122(new byte[1000]);

               while(true) {
                  var19 = var24.read(var11.field2047, var11.field2045, 1000 - var11.field2045);
                  if(var19 == -1) {
                     var23.close();
                     var24.close();
                     String var25 = new String(var11.field2047);
                     if(var25.startsWith("OFFLINE")) {
                        var3 = 4;
                     } else if(var25.startsWith("WRONG")) {
                        var3 = 7;
                     } else if(var25.startsWith("RELOAD")) {
                        var3 = 3;
                     } else if(var25.startsWith("Not permitted for social network accounts.")) {
                        var3 = 6;
                     } else {
                        var11.method2670(var8);

                        while(var11.field2045 > 0 && var11.field2047[var11.field2045 - 1] == 0) {
                           --var11.field2045;
                        }

                        var25 = new String(var11.field2047, 0, var11.field2045);
                        boolean var29;
                        if(null == var25) {
                           var29 = false;
                        } else {
                           label120: {
                              try {
                                 new URL(var25);
                              } catch (MalformedURLException var26) {
                                 var29 = false;
                                 break label120;
                              }

                              var29 = true;
                           }
                        }

                        if(var29) {
                           class157.method3211(var25, true, "openjs", false);
                           var3 = 2;
                        } else {
                           var3 = 5;
                        }
                     }
                     break;
                  }

                  var11.field2045 += var19;
                  if(var11.field2045 >= 1000) {
                     var3 = 5;
                     break;
                  }
               }
            } catch (Throwable var27) {
               var27.printStackTrace();
               var3 = 5;
            }

            var0 = var3;
         }

         switch(var0) {
         case 2:
            method2836("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class33.field759 = 6;
            break;
         case 3:
            method2836("", "Error connecting to server.", "");
            break;
         case 4:
            method2836("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            method2836("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            method2836("", "Error connecting to server.", "");
            break;
         case 7:
            method2836("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1660570821"
   )
   static void method2836(String var0, String var1, String var2) {
      class33.field729 = var0;
      class33.field738 = var1;
      class33.field751 = var2;
   }
}
