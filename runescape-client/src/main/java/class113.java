import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public final class class113 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1548746045
   )
   int field1990;
   @ObfuscatedName("d")
   final int field1991 = 16;
   @ObfuscatedName("v")
   final int field1992 = 258;
   @ObfuscatedName("bx")
   static class171 field1993;
   @ObfuscatedName("aq")
   int[][] field1994 = new int[6][258];
   @ObfuscatedName("t")
   final int field1995 = 18002;
   @ObfuscatedName("n")
   byte[] field1996;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2032820821
   )
   int field1997 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -753303321
   )
   int field1998;
   @ObfuscatedName("r")
   final int field1999 = 6;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 712766035
   )
   int field2000 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -315747987
   )
   int field2001;
   @ObfuscatedName("a")
   final int field2002 = 4096;
   @ObfuscatedName("l")
   int[] field2003 = new int[257];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -748296973
   )
   int field2004;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1441824325
   )
   int field2005;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -304654327
   )
   int field2006;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -68270597
   )
   int field2007;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1448090433
   )
   int field2008;
   @ObfuscatedName("z")
   final int field2009 = 50;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1099244703
   )
   int field2010;
   @ObfuscatedName("e")
   int[] field2011 = new int[256];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -770729513
   )
   int field2012;
   @ObfuscatedName("aa")
   byte[] field2013 = new byte[18002];
   @ObfuscatedName("am")
   byte[] field2014 = new byte[4096];
   @ObfuscatedName("ac")
   boolean[] field2015 = new boolean[256];
   @ObfuscatedName("as")
   boolean[] field2016 = new boolean[16];
   @ObfuscatedName("af")
   byte[] field2017 = new byte[256];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -943220255
   )
   int field2018;
   @ObfuscatedName("ap")
   int[] field2019 = new int[16];
   @ObfuscatedName("j")
   byte field2020;
   @ObfuscatedName("ar")
   byte[] field2021 = new byte[18002];
   @ObfuscatedName("av")
   byte[][] field2022 = new byte[6][258];
   @ObfuscatedName("ez")
   static ModIcon[] field2023;
   @ObfuscatedName("ao")
   int[][] field2024 = new int[6][258];
   @ObfuscatedName("ax")
   int[][] field2025 = new int[6][258];
   @ObfuscatedName("at")
   int[] field2026 = new int[6];
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 411097091
   )
   int field2027;
   @ObfuscatedName("m")
   byte[] field2028;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 399672651
   )
   int field2029;

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1225928289"
   )
   static final void method2446(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field518; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field374[var4] = true;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1744454638"
   )
   public static String method2447(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1733224945"
   )
   static final void method2448() {
      short var0 = 256;
      int var1;
      if(class33.field744 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class33.field744 > 768) {
               class137.field2145[var1] = class172.method3414(class33.field743[var1], ChatMessages.field273[var1], 1024 - class33.field744);
            } else if(class33.field744 > 256) {
               class137.field2145[var1] = ChatMessages.field273[var1];
            } else {
               class137.field2145[var1] = class172.method3414(ChatMessages.field273[var1], class33.field743[var1], 256 - class33.field744);
            }
         }
      } else if(class33.field769 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class33.field769 > 768) {
               class137.field2145[var1] = class172.method3414(class33.field743[var1], class1.field25[var1], 1024 - class33.field769);
            } else if(class33.field769 > 256) {
               class137.field2145[var1] = class1.field25[var1];
            } else {
               class137.field2145[var1] = class172.method3414(class1.field25[var1], class33.field743[var1], 256 - class33.field769);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class137.field2145[var1] = class33.field743[var1];
         }
      }

      class82.method1830(class33.field736, 9, class33.field736 + 128, 7 + var0);
      class130.field2124.method1807(class33.field736, 0);
      class82.method1822();
      var1 = 0;
      int var2 = class33.field736 + Buffer.bufferProvider.width * 9;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class33.field742[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class9.field149[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class137.field2145[var7];
               var10 = Buffer.bufferProvider.pixels[var2];
               Buffer.bufferProvider.pixels[var2++] = ((var10 & '\uff00') * var9 + var8 * (var7 & '\uff00') & 16711680) + (var8 * (var7 & 16711935) + var9 * (var10 & 16711935) & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += Buffer.bufferProvider.width + var5 - 128;
      }

      class82.method1830(class33.field736 + 765 - 128, 9, class33.field736 + 765, 7 + var0);
      class137.field2153.method1807(class33.field736 + 382, 0);
      class82.method1822();
      var1 = 0;
      var2 = class33.field736 + 24 + Buffer.bufferProvider.width * 9 + 637;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class33.field742[var3] / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class9.field149[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class137.field2145[var7];
               var10 = Buffer.bufferProvider.pixels[var2];
               Buffer.bufferProvider.pixels[var2++] = ((var7 & '\uff00') * var8 + (var10 & '\uff00') * var9 & 16711680) + ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += Buffer.bufferProvider.width - var5 - var4;
      }

   }
}
