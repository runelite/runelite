import java.awt.Canvas;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -173934575
   )
   @Export("y")
   int y;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -468266811
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1435456085
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 801139799
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("qz")
   @Export("canvas")
   public static Canvas canvas;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -465539687
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 715579607
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 78677275
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1101401
   )
   int field1725;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -12662473
   )
   int field1726;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2083782637
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1117630543
   )
   @Export("flags")
   int flags = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2007164275
   )
   @Export("height")
   int height;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2096861113
   )
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @Export("renderable")
   public Renderable renderable;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BB)Ljava/lang/String;",
      garbageValue = "-124"
   )
   public static String method2232(byte[] var0) {
      return class20.method566(var0, 0, var0.length);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "120390475"
   )
   public static String method2233(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "2007697765"
   )
   public static void method2234(String var0, String var1, int var2, int var3) throws IOException {
      class152.field2280 = var3;
      CollisionData.field1957 = var2;

      try {
         class26.field643 = System.getProperty("os.name");
      } catch (Exception var16) {
         class26.field643 = "Unknown";
      }

      class22.field590 = class26.field643.toLowerCase();

      try {
         class152.field2278 = System.getProperty("user.home");
         if(class152.field2278 != null) {
            class152.field2278 = class152.field2278 + "/";
         }
      } catch (Exception var15) {
         ;
      }

      try {
         if(class22.field590.startsWith("win")) {
            if(null == class152.field2278) {
               class152.field2278 = System.getenv("USERPROFILE");
            }
         } else if(class152.field2278 == null) {
            class152.field2278 = System.getenv("HOME");
         }

         if(null != class152.field2278) {
            class152.field2278 = class152.field2278 + "/";
         }
      } catch (Exception var14) {
         ;
      }

      if(null == class152.field2278) {
         class152.field2278 = "~/";
      }

      class75.field1398 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class152.field2278, "/tmp/", ""};
      class43.field982 = new String[]{".jagex_cache_" + CollisionData.field1957, ".file_store_" + CollisionData.field1957};
      int var12 = 0;

      label99:
      while(var12 < 4) {
         class152.field2279 = FaceNormal.method1952(var0, var1, var12);
         if(!class152.field2279.exists()) {
            class152.field2279.mkdirs();
         }

         File[] var5 = class152.field2279.listFiles();
         if(var5 == null) {
            break;
         }

         File[] var6 = var5;
         int var7 = 0;

         while(true) {
            if(var7 >= var6.length) {
               break label99;
            }

            File var8 = var6[var7];

            boolean var9;
            try {
               RandomAccessFile var10 = new RandomAccessFile(var8, "rw");
               int var11 = var10.read();
               var10.seek(0L);
               var10.write(var11);
               var10.seek(0L);
               var10.close();
               var9 = true;
            } catch (Exception var13) {
               var9 = false;
            }

            if(!var9) {
               ++var12;
               break;
            }

            ++var7;
         }
      }

      class114.method2456(class152.field2279);
      class49.method1010();
      class152.field2281 = new class231(new FileOnDisk(class140.method2954("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class152.field2283 = new class231(new FileOnDisk(class140.method2954("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      class23.field606 = new class231[class152.field2280];

      for(var12 = 0; var12 < class152.field2280; ++var12) {
         class23.field606[var12] = new class231(new FileOnDisk(class140.method2954("main_file_cache.idx" + var12), "rw", 1048576L), 6000, 0);
      }

   }
}
