import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public final class class123 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2011998533
   )
   int field2006;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -519434421
   )
   int field2008;
   @ObfuscatedName("p")
   int[] field2009 = new int[256];
   @ObfuscatedName("h")
   int[] field2010 = new int[256];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 593654631
   )
   int field2011;
   @ObfuscatedName("eb")
   static class78[] field2014;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -348237681
   )
   int field2015;

   @ObfuscatedName("e")
   final int method2776() {
      if(0 == --this.field2008 + 1) {
         this.method2778();
         this.field2008 = 255;
      }

      return this.field2009[this.field2008];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "1706292359"
   )
   public static void method2777(String var0, String var1, int var2, int var3) throws IOException {
      class149.field2228 = var3;
      class189.field3047 = var2;

      try {
         class135.field2077 = System.getProperty("os.name");
      } catch (Exception var11) {
         class135.field2077 = "Unknown";
      }

      class136.field2083 = class135.field2077.toLowerCase();

      try {
         class35.field765 = System.getProperty("user.home");
         if(null != class35.field765) {
            class35.field765 = class35.field765 + "/";
         }
      } catch (Exception var10) {
         ;
      }

      try {
         if(class136.field2083.startsWith("win")) {
            if(null == class35.field765) {
               class35.field765 = System.getenv("USERPROFILE");
            }
         } else if(class35.field765 == null) {
            class35.field765 = System.getenv("HOME");
         }

         if(class35.field765 != null) {
            class35.field765 = class35.field765 + "/";
         }
      } catch (Exception var9) {
         ;
      }

      if(null == class35.field765) {
         class35.field765 = "~/";
      }

      class109.field1891 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class35.field765, "/tmp/", ""};
      class77.field1368 = new String[]{".jagex_cache_" + class189.field3047, ".file_store_" + class189.field3047};
      int var4 = 0;

      label127:
      while(var4 < 4) {
         class149.field2237 = class116.method2474(var0, var1, var4);
         if(!class149.field2237.exists()) {
            class149.field2237.mkdirs();
         }

         File[] var5 = class149.field2237.listFiles();
         if(var5 == null) {
            break;
         }

         File[] var6 = var5;
         int var7 = 0;

         while(true) {
            if(var7 >= var6.length) {
               break label127;
            }

            File var8 = var6[var7];
            if(!class18.method184(var8, false)) {
               ++var4;
               break;
            }

            ++var7;
         }
      }

      class89.method2097(class149.field2237);

      try {
         File var13 = new File(class35.field765, "random.dat");
         int var16;
         if(var13.exists()) {
            class149.field2232 = new class228(new class227(var13, "rw", 25L), 24, 0);
         } else {
            label109:
            for(int var14 = 0; var14 < class77.field1368.length; ++var14) {
               for(var16 = 0; var16 < class109.field1891.length; ++var16) {
                  File var17 = new File(class109.field1891[var16] + class77.field1368[var14] + File.separatorChar + "random.dat");
                  if(var17.exists()) {
                     class149.field2232 = new class228(new class227(var17, "rw", 25L), 24, 0);
                     break label109;
                  }
               }
            }
         }

         if(class149.field2232 == null) {
            RandomAccessFile var15 = new RandomAccessFile(var13, "rw");
            var16 = var15.read();
            var15.seek(0L);
            var15.write(var16);
            var15.seek(0L);
            var15.close();
            class149.field2232 = new class228(new class227(var13, "rw", 25L), 24, 0);
         }
      } catch (IOException var12) {
         ;
      }

      class149.field2227 = new class228(new class227(class40.method838("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class149.field2234 = new class228(new class227(class40.method838("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      class149.field2230 = new class228[class149.field2228];

      for(var4 = 0; var4 < class149.field2228; ++var4) {
         class149.field2230[var4] = new class228(new class227(class40.method838("main_file_cache.idx" + var4), "rw", 1048576L), 6000, 0);
      }

   }

   @ObfuscatedName("w")
   final void method2778() {
      this.field2006 += ++this.field2015;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2010[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2011 ^= this.field2011 << 13;
            } else {
               this.field2011 ^= this.field2011 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2011 ^= this.field2011 << 2;
         } else {
            this.field2011 ^= this.field2011 >>> 16;
         }

         this.field2011 += this.field2010[var1 + 128 & 255];
         int var3;
         this.field2010[var1] = var3 = this.field2006 + this.field2011 + this.field2010[(var2 & 1020) >> 2];
         this.field2009[var1] = this.field2006 = this.field2010[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("f")
   final void method2779() {
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
         var2 += this.field2009[var1];
         var3 += this.field2009[1 + var1];
         var4 += this.field2009[var1 + 2];
         var5 += this.field2009[var1 + 3];
         var6 += this.field2009[4 + var1];
         var7 += this.field2009[5 + var1];
         var8 += this.field2009[6 + var1];
         var9 += this.field2009[7 + var1];
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
         this.field2010[var1] = var2;
         this.field2010[var1 + 1] = var3;
         this.field2010[var1 + 2] = var4;
         this.field2010[var1 + 3] = var5;
         this.field2010[4 + var1] = var6;
         this.field2010[var1 + 5] = var7;
         this.field2010[6 + var1] = var8;
         this.field2010[7 + var1] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2010[var1];
         var3 += this.field2010[1 + var1];
         var4 += this.field2010[2 + var1];
         var5 += this.field2010[3 + var1];
         var6 += this.field2010[4 + var1];
         var7 += this.field2010[5 + var1];
         var8 += this.field2010[var1 + 6];
         var9 += this.field2010[7 + var1];
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
         this.field2010[var1] = var2;
         this.field2010[var1 + 1] = var3;
         this.field2010[var1 + 2] = var4;
         this.field2010[var1 + 3] = var5;
         this.field2010[4 + var1] = var6;
         this.field2010[var1 + 5] = var7;
         this.field2010[6 + var1] = var8;
         this.field2010[var1 + 7] = var9;
      }

      this.method2778();
      this.field2008 = 256;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "104"
   )
   static final void method2787(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = var2 + 6;
      int var5 = class25.field628.method4016(var0, 250);
      int var6 = class25.field628.method4017(var0, 250) * 13;
      class79.method1809(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2, 0);
      class79.method1801(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2, 16777215);
      class25.field628.method4022(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class27.method650(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = class12.field192.getGraphics();
            class134.field2070.vmethod1886(var7, 0, 0);
         } catch (Exception var12) {
            class12.field192.repaint();
         }
      } else {
         int var13 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < client.field465; ++var11) {
            if(client.field486[var11] + client.field354[var11] > var13 && client.field486[var11] < var13 + var9 && client.field489[var11] + client.field487[var11] > var8 && client.field487[var11] < var10 + var8) {
               client.field484[var11] = true;
            }
         }
      }

   }

   class123(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2009[var2] = var1[var2];
      }

      this.method2779();
   }
}
