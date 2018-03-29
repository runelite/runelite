import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class167 {
   @ObfuscatedName("j")
   @Export("jagexClDat")
   static File jagexClDat;
   @ObfuscatedName("k")
   public static File field2206;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ldq;"
   )
   @Export("randomDat")
   public static CacheFile randomDat;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ldq;"
   )
   @Export("dat2File")
   public static CacheFile dat2File;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldq;"
   )
   @Export("idx255File")
   public static CacheFile idx255File;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Ldq;"
   )
   @Export("idxFiles")
   public static CacheFile[] idxFiles;
   @ObfuscatedName("h")
   public static String[] field2214;

   static {
      randomDat = null;
      dat2File = null;
      idx255File = null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljm;I)V",
      garbageValue = "-766944462"
   )
   public static void method3254(IndexDataBase var0) {
      class279.field3549 = var0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-787694628"
   )
   static final void method3256(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2929(var0, var1, var2);
      int[] var8 = Region.method2929(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(Lib;B)Z",
      garbageValue = "112"
   )
   static final boolean method3248(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = class47.method713(var0, var1);
            int var3 = var0.field2928[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("kx")
   @ObfuscatedSignature(
      signature = "([BII)V",
      garbageValue = "1075413476"
   )
   static void method3253(byte[] var0, int var1) {
      if(Client.field896 == null) {
         Client.field896 = new byte[24];
      }

      class205.method3845(var0, var1, Client.field896, 0, 24);
   }
}
