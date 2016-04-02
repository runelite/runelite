import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class18 {
   @ObfuscatedName("s")
   byte[] field252 = new byte[4];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1846254959
   )
   int field253;
   @ObfuscatedName("f")
   DataInputStream field254;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 32566027
   )
   int field255;
   @ObfuscatedName("h")
   byte[] field256;
   @ObfuscatedName("w")
   class146 field257;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 708303875
   )
   int field258;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 1004286753407424235L
   )
   long field259;
   @ObfuscatedName("r")
   static class80[] field260;

   @ObfuscatedName("f")
   static boolean method184(File var0, boolean var1) {
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

   @ObfuscatedName("e")
   byte[] method185() throws IOException {
      if(class140.method2967() > this.field259) {
         throw new IOException();
      } else {
         if(this.field253 == 0) {
            if(this.field257.field2213 == 2) {
               throw new IOException();
            }

            if(1 == this.field257.field2213) {
               this.field254 = (DataInputStream)this.field257.field2216;
               this.field253 = 1;
            }
         }

         int var1;
         if(this.field253 == 1) {
            var1 = this.field254.available();
            if(var1 > 0) {
               if(this.field255 + var1 > 4) {
                  var1 = 4 - this.field255;
               }

               this.field255 += this.field254.read(this.field252, this.field255, var1);
               if(4 == this.field255) {
                  int var2 = (new class119(this.field252)).method2528();
                  this.field256 = new byte[var2];
                  this.field253 = 2;
               }
            }
         }

         if(this.field253 == 2) {
            var1 = this.field254.available();
            if(var1 > 0) {
               if(var1 + this.field258 > this.field256.length) {
                  var1 = this.field256.length - this.field258;
               }

               this.field258 += this.field254.read(this.field256, this.field258, var1);
               if(this.field256.length == this.field258) {
                  return this.field256;
               }
            }
         }

         return null;
      }
   }

   @ObfuscatedName("ch")
   static final String method189(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class39.method784(16711680):(var2 < -6?class39.method784(16723968):(var2 < -3?class39.method784(16740352):(var2 < 0?class39.method784(16756736):(var2 > 9?class39.method784('\uff00'):(var2 > 6?class39.method784(4259584):(var2 > 3?class39.method784(8453888):(var2 > 0?class39.method784(12648192):class39.method784(16776960))))))));
   }

   @ObfuscatedName("e")
   public static void method190(class167 var0, class167 var1, boolean var2, class224 var3) {
      class5.field101 = var0;
      class51.field1083 = var1;
      class51.field1100 = var2;
      class51.field1126 = class5.field101.method3307(10);
      class222.field3181 = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2134346080"
   )
   static void method191(int var0, int var1, int var2) {
      if(0 != client.field396 && var1 != 0 && client.field383 < 50) {
         client.field521[client.field383] = var0;
         client.field522[client.field383] = var1;
         client.field523[client.field383] = var2;
         client.field444[client.field383] = null;
         client.field446[client.field383] = 0;
         ++client.field383;
      }

   }

   class18(class136 var1, URL var2) {
      this.field257 = var1.method2877(var2);
      this.field253 = 0;
      this.field259 = class140.method2967() + 30000L;
   }

   @ObfuscatedName("r")
   public static boolean method192(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
