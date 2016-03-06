package net.runelite.rs.client;
import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ds")
public final class class128 {
   @ObfuscatedName("n")
   static class80[] field2054;
   @ObfuscatedName("u")
   public static class227[] field2055;

   @ObfuscatedName("a")
   static boolean method2755(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("a")
   public static int method2756(CharSequence var0, int var1) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6);
         if(0 == var6) {
            if(45 == var7) {
               var2 = true;
               continue;
            }

            if(var7 == 43) {
               continue;
            }
         }

         int var9;
         if(var7 >= 48 && var7 <= 57) {
            var9 = var7 - 48;
         } else if(var7 >= 65 && var7 <= 90) {
            var9 = var7 - 55;
         } else {
            if(var7 < 97 || var7 > 122) {
               throw new NumberFormatException();
            }

            var9 = var7 - 87;
         }

         if(var9 >= var1) {
            throw new NumberFormatException();
         }

         if(var2) {
            var9 = -var9;
         }

         int var8 = var1 * var4 + var9;
         if(var8 / var1 != var4) {
            throw new NumberFormatException();
         }

         var4 = var8;
         var3 = true;
      }

      if(!var3) {
         throw new NumberFormatException();
      } else {
         return var4;
      }
   }

   @ObfuscatedName("b")
   public static void method2757() {
      class40.field935.method3720();
      class40.field957.method3720();
      class40.field921.method3720();
      class40.field951.method3720();
   }
}
