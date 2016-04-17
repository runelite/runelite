import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class18 {
   @ObfuscatedName("d")
   DataInputStream field269;
   @ObfuscatedName("w")
   class146 field270;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -740068819
   )
   int field271;
   @ObfuscatedName("c")
   byte[] field272 = new byte[4];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 111025641
   )
   int field273;
   @ObfuscatedName("k")
   byte[] field274;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1767715335
   )
   int field275;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -7032377323903790969L
   )
   long field276;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -2071976557
   )
   public static int field277;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(S)[B",
      garbageValue = "24304"
   )
   byte[] method223() throws IOException {
      if(class127.method2941() > this.field276) {
         throw new IOException();
      } else {
         if(0 == this.field271) {
            if(2 == this.field270.field2210) {
               throw new IOException();
            }

            if(1 == this.field270.field2210) {
               this.field269 = (DataInputStream)this.field270.field2211;
               this.field271 = 1;
            }
         }

         int var1;
         if(1 == this.field271) {
            var1 = this.field269.available();
            if(var1 > 0) {
               if(this.field273 + var1 > 4) {
                  var1 = 4 - this.field273;
               }

               this.field273 += this.field269.read(this.field272, this.field273, var1);
               if(this.field273 == 4) {
                  int var2 = (new class119(this.field272)).method2618();
                  this.field274 = new byte[var2];
                  this.field271 = 2;
               }
            }
         }

         if(this.field271 == 2) {
            var1 = this.field269.available();
            if(var1 > 0) {
               if(var1 + this.field275 > this.field274.length) {
                  var1 = this.field274.length - this.field275;
               }

               this.field275 += this.field269.read(this.field274, this.field275, var1);
               if(this.field274.length == this.field275) {
                  return this.field274;
               }
            }
         }

         return null;
      }
   }

   class18(class136 var1, URL var2) {
      this.field270 = var1.method3011(var2);
      this.field271 = 0;
      this.field276 = class127.method2941() + 30000L;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)Lclass22;",
      garbageValue = "0"
   )
   static class22 method226(int var0) {
      class22 var1 = (class22)class22.field607.method3840((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class211.field3137.method3403(var0, 0);
         if(null == var2) {
            return null;
         } else {
            var1 = new class22();
            class119 var3 = new class119(var2);
            var3.field1992 = var3.field1993.length - 12;
            int var4 = var3.method2618();
            var1.field601 = var3.method2615();
            var1.field599 = var3.method2615();
            var1.field603 = var3.method2615();
            var1.field604 = var3.method2615();
            var3.field1992 = 0;
            var3.method2701();
            var1.field598 = new int[var4];
            var1.field606 = new int[var4];
            var1.field600 = new String[var4];

            int var6;
            for(int var5 = 0; var3.field1992 < var3.field1993.length - 12; var1.field598[var5++] = var6) {
               var6 = var3.method2615();
               if(3 == var6) {
                  var1.field600[var5] = var3.method2621();
               } else if(var6 < 100 && var6 != 21 && 38 != var6 && 39 != var6) {
                  var1.field606[var5] = var3.method2618();
               } else {
                  var1.field606[var5] = var3.method2613();
               }
            }

            class22.field607.method3842(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;B)[Lclass78;",
      garbageValue = "1"
   )
   public static class78[] method227(class167 var0, String var1, String var2) {
      int var3 = var0.method3377(var1);
      int var4 = var0.method3378(var3, var2);
      class78[] var5;
      if(!class30.method748(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class122.method2891();
      }

      return var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1107532570"
   )
   static void method228() {
      Object var0 = class170.field2705;
      synchronized(class170.field2705) {
         if(class170.field2706 == 0) {
            class107.field1874.method2991(new class170(), 5);
         }

         class170.field2706 = 600;
      }
   }
}
