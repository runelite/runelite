import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2063951413
   )
   int field1822;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 66116233
   )
   int field1824;
   @ObfuscatedName("f")
   int[] field1825;
   @ObfuscatedName("c")
   int[][] field1826;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = -663477681
   )
   static int field1827;
   @ObfuscatedName("as")
   static SpritePixels[] field1828;
   @ObfuscatedName("bw")
   static class171 field1829;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIS)V",
      garbageValue = "-941"
   )
   public static void method2353(String var0, String var1, int var2, int var3) throws IOException {
      class21.field578 = var3;
      class26.field635 = var2;

      try {
         class219.field3210 = System.getProperty("os.name");
      } catch (Exception var15) {
         class219.field3210 = "Unknown";
      }

      SecondaryBufferProvider.field1431 = class219.field3210.toLowerCase();

      try {
         class9.field149 = System.getProperty("user.home");
         if(class9.field149 != null) {
            class9.field149 = class9.field149 + "/";
         }
      } catch (Exception var14) {
         ;
      }

      try {
         if(SecondaryBufferProvider.field1431.startsWith("win")) {
            if(null == class9.field149) {
               class9.field149 = System.getenv("USERPROFILE");
            }
         } else if(null == class9.field149) {
            class9.field149 = System.getenv("HOME");
         }

         if(null != class9.field149) {
            class9.field149 = class9.field149 + "/";
         }
      } catch (Exception var13) {
         ;
      }

      if(class9.field149 == null) {
         class9.field149 = "~/";
      }

      class22.field587 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class9.field149, "/tmp/", ""};
      class125.field2076 = new String[]{".jagex_cache_" + class26.field635, ".file_store_" + class26.field635};
      int var9 = 0;

      label131:
      while(var9 < 4) {
         WidgetNode.field61 = class164.method3219(var0, var1, var9);
         if(!WidgetNode.field61.exists()) {
            WidgetNode.field61.mkdirs();
         }

         File[] var5 = WidgetNode.field61.listFiles();
         if(null == var5) {
            break;
         }

         File[] var6 = var5;
         int var7 = 0;

         while(true) {
            if(var7 >= var6.length) {
               break label131;
            }

            File var8 = var6[var7];
            if(!class18.method178(var8, false)) {
               ++var9;
               break;
            }

            ++var7;
         }
      }

      class79.method1717(WidgetNode.field61);

      try {
         File var4 = new File(class9.field149, "random.dat");
         int var11;
         if(var4.exists()) {
            class152.field2283 = new class231(new FileOnDisk(var4, "rw", 25L), 24, 0);
         } else {
            label113:
            for(int var10 = 0; var10 < class125.field2076.length; ++var10) {
               for(var11 = 0; var11 < class22.field587.length; ++var11) {
                  File var12 = new File(class22.field587[var11] + class125.field2076[var10] + File.separatorChar + "random.dat");
                  if(var12.exists()) {
                     class152.field2283 = new class231(new FileOnDisk(var12, "rw", 25L), 24, 0);
                     break label113;
                  }
               }
            }
         }

         if(class152.field2283 == null) {
            RandomAccessFile var17 = new RandomAccessFile(var4, "rw");
            var11 = var17.read();
            var17.seek(0L);
            var17.write(var11);
            var17.seek(0L);
            var17.close();
            class152.field2283 = new class231(new FileOnDisk(var4, "rw", 25L), 24, 0);
         }
      } catch (IOException var16) {
         ;
      }

      class152.field2279 = new class231(new FileOnDisk(class11.method135("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class152.field2284 = new class231(new FileOnDisk(class11.method135("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      XItemContainer.field218 = new class231[class21.field578];

      for(var9 = 0; var9 < class21.field578; ++var9) {
         XItemContainer.field218[var9] = new class231(new FileOnDisk(class11.method135("main_file_cache.idx" + var9), "rw", 1048576L), 6000, 0);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Lclass170;I)V",
      garbageValue = "1224246711"
   )
   public static void method2354(class170 var0, class170 var1, class170 var2) {
      class51.field1115 = var0;
      class181.field2961 = var1;
      class51.field1113 = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass171;IIIBZB)V",
      garbageValue = "85"
   )
   static void method2355(class171 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class175 var8 = (class175)class174.field2776.method3828(var6);
      if(null == var8) {
         var8 = (class175)class174.field2765.method3828(var6);
         if(null == var8) {
            var8 = (class175)class174.field2768.method3828(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3932();
                  class174.field2776.method3822(var8, var6);
                  --class174.field2779;
                  ++class174.field2774;
               }

            } else {
               if(!var5) {
                  var8 = (class175)class174.field2764.method3828(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class175();
               var8.field2782 = var0;
               var8.field2785 = var3;
               var8.field2784 = var4;
               if(var5) {
                  class174.field2776.method3822(var8, var6);
                  ++class174.field2774;
               } else {
                  class174.field2767.method3920(var8);
                  class174.field2768.method3822(var8, var6);
                  ++class174.field2779;
               }

            }
         }
      }
   }

   FrameMap(int var1, byte[] var2) {
      this.field1824 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1822 = var3.method2571();
      this.field1825 = new int[this.field1822];
      this.field1826 = new int[this.field1822][];

      int var4;
      for(var4 = 0; var4 < this.field1822; ++var4) {
         this.field1825[var4] = var3.method2571();
      }

      for(var4 = 0; var4 < this.field1822; ++var4) {
         this.field1826[var4] = new int[var3.method2571()];
      }

      for(var4 = 0; var4 < this.field1822; ++var4) {
         for(int var5 = 0; var5 < this.field1826[var4].length; ++var5) {
            this.field1826[var4][var5] = var3.method2571();
         }
      }

   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(LWidget;I)I",
      garbageValue = "-1483270394"
   )
   static int method2356(Widget var0) {
      class204 var1 = (class204)Client.widgetFlags.method3828((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.field3151:var0.field2870;
   }
}
