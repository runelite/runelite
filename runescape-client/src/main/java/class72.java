import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class72 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   IndexedSprite[] field998;
   @ObfuscatedName("g")
   int[] field1015;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 475300985
   )
   int field1008;
   @ObfuscatedName("e")
   int[] field1013;
   @ObfuscatedName("x")
   int[] field1006;
   @ObfuscatedName("d")
   int[] field1007;
   @ObfuscatedName("k")
   int[] field1014;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 521751567
   )
   int field1009;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 486426941
   )
   int field1005;
   @ObfuscatedName("a")
   int[] field1011;
   @ObfuscatedName("z")
   int[] field1012;
   @ObfuscatedName("j")
   int[] field1004;
   @ObfuscatedName("s")
   int[] field1018;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 242237475
   )
   int field1010;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -422060935
   )
   int field1016;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1072107507
   )
   int field1017;

   @ObfuscatedSignature(
      signature = "([Llq;)V"
   )
   class72(IndexedSprite[] var1) {
      this.field1015 = new int[256];
      this.field1008 = 0;
      this.field1009 = 0;
      this.field1005 = 0;
      this.field1010 = 0;
      this.field1016 = 0;
      this.field1017 = 0;
      this.field998 = var1;
      this.method1772();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1987616827"
   )
   void method1772() {
      this.field1006 = new int[256];

      int var1;
      for(var1 = 0; var1 < 64; ++var1) {
         this.field1006[var1] = var1 * 262144;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1006[var1 + 64] = var1 * 1024 + 16711680;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1006[var1 + 128] = var1 * 4 + 16776960;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1006[var1 + 192] = 16777215;
      }

      this.field1007 = new int[256];

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1007[var1] = var1 * 1024;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1007[var1 + 64] = var1 * 4 + 65280;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1007[var1 + 128] = var1 * 262144 + 65535;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1007[var1 + 192] = 16777215;
      }

      this.field1014 = new int[256];

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1014[var1] = var1 * 4;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1014[var1 + 64] = var1 * 262144 + 255;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1014[var1 + 128] = var1 * 1024 + 16711935;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1014[var1 + 192] = 16777215;
      }

      this.field1013 = new int[256];
      this.field1010 = 0;
      this.field1004 = new int[32768];
      this.field1018 = new int[32768];
      this.method1779((IndexedSprite)null);
      this.field1011 = new int[32768];
      this.field1012 = new int[32768];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1269720175"
   )
   void method1762() {
      this.field1006 = null;
      this.field1007 = null;
      this.field1014 = null;
      this.field1013 = null;
      this.field1004 = null;
      this.field1018 = null;
      this.field1011 = null;
      this.field1012 = null;
      this.field1010 = 0;
      this.field1016 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1684910110"
   )
   void method1782(int var1, int var2) {
      if(this.field1011 == null) {
         this.method1772();
      }

      if(this.field1017 == 0) {
         this.field1017 = var2;
      }

      int var3 = var2 - this.field1017;
      if(var3 >= 256) {
         var3 = 0;
      }

      this.field1017 = var2;
      if(var3 > 0) {
         this.method1791(var3);
      }

      this.method1787(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "115"
   )
   final void method1791(int var1) {
      this.field1010 += var1 * 128;
      int var2;
      if(this.field1010 > this.field1004.length) {
         this.field1010 -= this.field1004.length;
         var2 = (int)(Math.random() * 12.0D);
         this.method1779(this.field998[var2]);
      }

      var2 = 0;
      int var3 = var1 * 128;
      int var4 = (256 - var1) * 128;

      int var5;
      for(int var6 = 0; var6 < var4; ++var6) {
         var5 = this.field1011[var3 + var2] - this.field1004[var2 + this.field1010 & this.field1004.length - 1] * var1 / 6;
         if(var5 < 0) {
            var5 = 0;
         }

         this.field1011[var2++] = var5;
      }

      byte var15 = 10;
      var5 = 128 - var15;

      int var7;
      int var8;
      for(var7 = 256 - var1; var7 < 256; ++var7) {
         int var9 = var7 * 128;

         for(int var10 = 0; var10 < 128; ++var10) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var10 > var15 && var10 < var5) {
               this.field1011[var10 + var9] = 255;
            } else {
               this.field1011[var10 + var9] = 0;
            }
         }
      }

      if(this.field1009 > 0) {
         this.field1009 -= var1 * 4;
      }

      if(this.field1005 > 0) {
         this.field1005 -= var1 * 4;
      }

      if(this.field1009 == 0 && this.field1005 == 0) {
         var7 = (int)(Math.random() * (double)(2000 / var1));
         if(var7 == 0) {
            this.field1009 = 1024;
         }

         if(var7 == 1) {
            this.field1005 = 1024;
         }
      }

      for(var7 = 0; var7 < 256 - var1; ++var7) {
         this.field1015[var7] = this.field1015[var7 + var1];
      }

      for(var7 = 256 - var1; var7 < 256; ++var7) {
         this.field1015[var7] = (int)(Math.sin((double)this.field1008 / 14.0D) * 16.0D + Math.sin((double)this.field1008 / 15.0D) * 14.0D + Math.sin((double)this.field1008 / 16.0D) * 12.0D);
         ++this.field1008;
      }

      this.field1016 += var1;
      var7 = ((Client.cycle & 1) + var1) / 2;
      if(var7 > 0) {
         short var16 = 128;
         byte var17 = 2;
         var8 = 128 - var17 - var17;

         int var11;
         int var12;
         int var13;
         for(var11 = 0; var11 < this.field1016 * 100; ++var11) {
            var12 = (int)(Math.random() * (double)var8) + var17;
            var13 = (int)(Math.random() * (double)var16) + var16;
            this.field1011[var12 + (var13 << 7)] = 192;
         }

         this.field1016 = 0;

         int var14;
         for(var11 = 0; var11 < 256; ++var11) {
            var12 = 0;
            var13 = var11 * 128;

            for(var14 = -var7; var14 < 128; ++var14) {
               if(var7 + var14 < 128) {
                  var12 += this.field1011[var7 + var14 + var13];
               }

               if(var14 - (var7 + 1) >= 0) {
                  var12 -= this.field1011[var14 + var13 - (var7 + 1)];
               }

               if(var14 >= 0) {
                  this.field1012[var14 + var13] = var12 / (var7 * 2 + 1);
               }
            }
         }

         for(var11 = 0; var11 < 128; ++var11) {
            var12 = 0;

            for(var13 = -var7; var13 < 256; ++var13) {
               var14 = var13 * 128;
               if(var13 + var7 < 256) {
                  var12 += this.field1012[var14 + var11 + var7 * 128];
               }

               if(var13 - (var7 + 1) >= 0) {
                  var12 -= this.field1012[var11 + var14 - (var7 + 1) * 128];
               }

               if(var13 >= 0) {
                  this.field1011[var11 + var14] = var12 / (var7 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1964326152"
   )
   final int method1765(int var1, int var2, int var3) {
      int var4 = 256 - var3;
      return (var4 * (var1 & 65280) + var3 * (var2 & 65280) & 16711680) + (var4 * (var1 & 16711935) + var3 * (var2 & 16711935) & -16711936) >> 8;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2128815315"
   )
   final void method1787(int var1) {
      int var2 = this.field1013.length;
      if(this.field1009 > 0) {
         this.method1766(this.field1009, this.field1007);
      } else if(this.field1005 > 0) {
         this.method1766(this.field1005, this.field1014);
      } else {
         for(int var3 = 0; var3 < var2; ++var3) {
            this.field1013[var3] = this.field1006[var3];
         }
      }

      this.method1767(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I[II)V",
      garbageValue = "647774031"
   )
   final void method1766(int var1, int[] var2) {
      int var3 = this.field1013.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         if(var1 > 768) {
            this.field1013[var4] = this.method1765(this.field1006[var4], var2[var4], 1024 - var1);
         } else if(var1 > 256) {
            this.field1013[var4] = var2[var4];
         } else {
            this.field1013[var4] = this.method1765(var2[var4], this.field1006[var4], 256 - var1);
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-3198599"
   )
   final void method1767(int var1) {
      int var2 = 0;

      for(int var3 = 1; var3 < 255; ++var3) {
         int var4 = (256 - var3) * this.field1015[var3] / 256;
         int var5 = var4 + var1;
         int var6 = 0;
         int var7 = 128;
         if(var5 < 0) {
            var6 = -var5;
            var5 = 0;
         }

         if(var5 + 128 >= class197.rasterProvider.width) {
            var7 = class197.rasterProvider.width - var5;
         }

         int var8 = var5 + (var3 + 8) * class197.rasterProvider.width;
         var2 += var6;

         for(int var9 = var6; var9 < var7; ++var9) {
            int var10 = this.field1011[var2++];
            int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
            if(var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
               int var12 = var10;
               int var13 = 256 - var10;
               var10 = this.field1013[var10];
               int var14 = class197.rasterProvider.pixels[var8];
               class197.rasterProvider.pixels[var8++] = -16777216 | ((var10 & 16711935) * var12 + (var14 & 16711935) * var13 & -16711936) + (var12 * (var10 & 65280) + var13 * (var14 & 65280) & 16711680) >> 8;
            } else {
               ++var8;
            }
         }

         var2 += 128 - var7;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Llq;I)V",
      garbageValue = "849366777"
   )
   final void method1779(IndexedSprite var1) {
      int var2;
      for(var2 = 0; var2 < this.field1004.length; ++var2) {
         this.field1004[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * 256.0D);
         this.field1004[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < 255; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               this.field1018[var5] = (this.field1004[var5 + 1] + this.field1004[var5 + 128] + this.field1004[var5 - 128] + this.field1004[var5 - 1]) / 4;
            }
         }

         int[] var6 = this.field1004;
         this.field1004 = this.field1018;
         this.field1018 = var6;
      }

      if(var1 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var1.subHeight; ++var3) {
            for(var4 = 0; var4 < var1.subWidth; ++var4) {
               if(var1.pixels[var2++] != 0) {
                  var5 = var4 + var1.xOffset + 16;
                  int var8 = var3 + var1.yOffset + 16;
                  int var7 = var5 + (var8 << 7);
                  this.field1004[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;S)I",
      garbageValue = "842"
   )
   static final int method1778(long var0, String var2) {
      Random var3 = new Random();
      Buffer var4 = new Buffer(128);
      Buffer var5 = new Buffer(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.writeByte(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.writeInt(var3.nextInt());
      }

      var4.writeInt(var6[0]);
      var4.writeInt(var6[1]);
      var4.writeLong(var0);
      var4.writeLong(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.writeInt(var3.nextInt());
      }

      var4.encryptRsa(class80.__ce_o, class80.__ce_u);
      var5.writeByte(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.writeInt(var3.nextInt());
      }

      var5.writeLong(var3.nextLong());
      var5.writeLongMedium(var3.nextLong());
      Varps.method4400(var5);
      var5.writeLong(var3.nextLong());
      var5.encryptRsa(class80.__ce_o, class80.__ce_u);
      var7 = WorldMapRegion.method550(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var8 = new Buffer(var7);
      var8.writeStringCp1252NullTerminated(var2);
      var8.index = var7;
      var8.xteaEncryptAll(var6);
      Buffer var9 = new Buffer(var4.index + var5.index + var8.index + 5);
      var9.writeByte(2);
      var9.writeByte(var4.index);
      var9.__s_297(var4.array, 0, var4.index);
      var9.writeByte(var5.index);
      var9.__s_297(var5.array, 0, var5.index);
      var9.writeShort(var8.index);
      var9.__s_297(var8.array, 0, var8.index);
      byte[] var10 = var9.array;
      int var11 = var10.length;
      StringBuilder var12 = new StringBuilder();

      int var13;
      for(int var14 = 0; var14 < var11 + 0; var14 += 3) {
         int var15 = var10[var14] & 255;
         var12.append(class307.__kc_m[var15 >>> 2]);
         if(var14 < var11 - 1) {
            var13 = var10[var14 + 1] & 255;
            var12.append(class307.__kc_m[(var15 & 3) << 4 | var13 >>> 4]);
            if(var14 < var11 - 2) {
               int var16 = var10[var14 + 2] & 255;
               var12.append(class307.__kc_m[(var13 & 15) << 2 | var16 >>> 6]).append(class307.__kc_m[var16 & 63]);
            } else {
               var12.append(class307.__kc_m[(var13 & 15) << 2]).append("=");
            }
         } else {
            var12.append(class307.__kc_m[(var15 & 3) << 4]).append("==");
         }
      }

      String var21 = var12.toString();
      var21 = var21;

      try {
         URL var22 = new URL(Message.method1227("services", false) + "m=accountappeal/login.ws");
         URLConnection var23 = var22.openConnection();
         var23.setDoInput(true);
         var23.setDoOutput(true);
         var23.setConnectTimeout(5000);
         OutputStreamWriter var17 = new OutputStreamWriter(var23.getOutputStream());
         var17.write("data2=" + class306.method5781(var21) + "&dest=" + class306.method5781("passwordchoice.ws"));
         var17.flush();
         InputStream var18 = var23.getInputStream();
         var9 = new Buffer(new byte[1000]);

         do {
            var13 = var18.read(var9.array, var9.index, 1000 - var9.index);
            if(var13 == -1) {
               var17.close();
               var18.close();
               String var19 = new String(var9.array);
               if(var19.startsWith("OFFLINE")) {
                  return 4;
               } else if(var19.startsWith("WRONG")) {
                  return 7;
               } else if(var19.startsWith("RELOAD")) {
                  return 3;
               } else if(var19.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.xteaDecryptAll(var6);

                  while(var9.index > 0 && var9.array[var9.index - 1] == 0) {
                     --var9.index;
                  }

                  var19 = new String(var9.array, 0, var9.index);
                  if(class83.method2026(var19)) {
                     WorldMapCacheName.method635(var19, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var9.index += var13;
         } while(var9.index < 1000);

         return 5;
      } catch (Throwable var20) {
         var20.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Ljm;",
      garbageValue = "-499011631"
   )
   @Export("getHitSplatDefinition")
   public static HitSplatDefinition getHitSplatDefinition(int var0) {
      HitSplatDefinition var1 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = HitSplatDefinition.__jm_m.takeRecord(32, var0);
         var1 = new HitSplatDefinition();
         if(var2 != null) {
            var1.read(new Buffer(var2));
         }

         HitSplatDefinition.HitSplatDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2135404786"
   )
   public static void method1780() {
      ItemDefinition.ItemDefinition_cached.clear();
      ItemDefinition.ItemDefinition_cachedModels.clear();
      ItemDefinition.Sprite_cached.clear();
   }
}
