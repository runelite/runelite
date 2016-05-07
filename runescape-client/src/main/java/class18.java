import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class18 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1074498791
   )
   int field248;
   @ObfuscatedName("j")
   class146 field249;
   @ObfuscatedName("p")
   DataInputStream field250;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 981501365
   )
   int field252;
   @ObfuscatedName("u")
   byte[] field253;
   @ObfuscatedName("x")
   byte[] field254 = new byte[4];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -4444377537002811023L
   )
   long field255;
   @ObfuscatedName("y")
   public static String field258;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1236080591
   )
   int field261;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1903948208"
   )
   byte[] method207() throws IOException {
      if(class12.method162() > this.field255) {
         throw new IOException();
      } else {
         if(this.field248 == 0) {
            if(this.field249.field2226 == 2) {
               throw new IOException();
            }

            if(1 == this.field249.field2226) {
               this.field250 = (DataInputStream)this.field249.field2224;
               this.field248 = 1;
            }
         }

         int var1;
         if(this.field248 == 1) {
            var1 = this.field250.available();
            if(var1 > 0) {
               if(var1 + this.field252 > 4) {
                  var1 = 4 - this.field252;
               }

               this.field252 += this.field250.read(this.field254, this.field252, var1);
               if(4 == this.field252) {
                  int var2 = (new class119(this.field254)).method2497();
                  this.field253 = new byte[var2];
                  this.field248 = 2;
               }
            }
         }

         if(this.field248 == 2) {
            var1 = this.field250.available();
            if(var1 > 0) {
               if(var1 + this.field261 > this.field253.length) {
                  var1 = this.field253.length - this.field261;
               }

               this.field261 += this.field250.read(this.field253, this.field261, var1);
               if(this.field261 == this.field253.length) {
                  return this.field253;
               }
            }
         }

         return null;
      }
   }

   class18(class136 var1, URL var2) {
      this.field249 = var1.method2867(var2);
      this.field248 = 0;
      this.field255 = class12.method162() + 30000L;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-229933151"
   )
   static final void method210() {
      for(int var0 = 0; var0 < client.field521; ++var0) {
         --client.field524[var0];
         if(client.field524[var0] >= -10) {
            class58 var10 = client.field526[var0];
            if(var10 == null) {
               class58 var10000 = (class58)null;
               var10 = class58.method1228(class28.field682, client.field537[var0], 0);
               if(var10 == null) {
                  continue;
               }

               client.field524[var0] += var10.method1225();
               client.field526[var0] = var10;
            }

            if(client.field524[var0] < 0) {
               int var2;
               if(client.field407[var0] != 0) {
                  int var3 = (client.field407[var0] & 255) * 128;
                  int var4 = client.field407[var0] >> 16 & 255;
                  int var5 = 64 + var4 * 128 - class106.field1881.field823;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = client.field407[var0] >> 8 & 255;
                  int var7 = 64 + 128 * var6 - class106.field1881.field813;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     client.field524[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = client.field520 * (var3 - var8) / var3;
               } else {
                  var2 = client.field519;
               }

               if(var2 > 0) {
                  class62 var11 = var10.method1222().method1256(class110.field1960);
                  class64 var12 = class64.method1280(var11, 100, var2);
                  var12.method1428(client.field523[var0] - 1);
                  class114.field1978.method1127(var12);
               }

               client.field524[var0] = -100;
            }
         } else {
            --client.field521;

            for(int var1 = var0; var1 < client.field521; ++var1) {
               client.field537[var1] = client.field537[1 + var1];
               client.field526[var1] = client.field526[var1 + 1];
               client.field523[var1] = client.field523[var1 + 1];
               client.field524[var1] = client.field524[1 + var1];
               client.field407[var1] = client.field407[var1 + 1];
            }

            --var0;
         }
      }

      if(client.field518) {
         boolean var9;
         if(0 != class183.field2973) {
            var9 = true;
         } else {
            var9 = class183.field2972.method3585();
         }

         if(!var9) {
            if(0 != client.field516 && -1 != client.field370) {
               class82.method1869(class102.field1776, client.field370, 0, client.field516, false);
            }

            client.field518 = false;
         }
      }

   }
}
