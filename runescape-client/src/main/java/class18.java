import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class18 {
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 235775177
   )
   static int field262;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 2751052548157810653L
   )
   long field263;
   @ObfuscatedName("x")
   DataInputStream field264;
   @ObfuscatedName("b")
   byte[] field265 = new byte[4];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1811086385
   )
   int field266;
   @ObfuscatedName("u")
   class146 field267;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1373370935
   )
   int field268;
   @ObfuscatedName("ag")
   static int[] field270;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1600968945
   )
   int field271;
   @ObfuscatedName("d")
   byte[] field272;

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(Lclass173;III)V",
      garbageValue = "-2146669010"
   )
   static final void method202(class173 var0, int var1, int var2) {
      if(client.field428 == null && !client.field310) {
         if(var0 != null) {
            class173 var5 = class76.method1704(var0);
            if(var5 == null) {
               var5 = var0.field2829;
            }

            if(var5 != null) {
               client.field428 = var0;
               var5 = class76.method1704(var0);
               if(var5 == null) {
                  var5 = var0.field2829;
               }

               client.field298 = var5;
               client.field308 = var1;
               client.field545 = var2;
               class72.field1367 = 0;
               client.field369 = false;
               if(client.field429 > 0) {
                  int var4 = client.field429 - 1;
                  class13.field203 = new class30();
                  class13.field203.field712 = client.field434[var4];
                  class13.field203.field704 = client.field431[var4];
                  class13.field203.field705 = client.field329[var4];
                  class13.field203.field703 = client.field433[var4];
                  class13.field203.field707 = client.field459[var4];
               }

               return;
            }
         }

      }
   }

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)I",
      garbageValue = "2129851777"
   )
   static int method205(class173 var0) {
      class201 var1 = (class201)client.field489.method3822((long)var0.field2755 + ((long)var0.field2869 << 32));
      return null != var1?var1.field3102:var0.field2826;
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "1856518919"
   )
   static final String[] method207(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && null != var0[var2]) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;ZLclass224;I)V",
      garbageValue = "-1353118677"
   )
   public static void method208(class167 var0, class167 var1, boolean var2, class224 var3) {
      class51.field1115 = var0;
      class213.field3143 = var1;
      class131.field2066 = var2;
      class3.field73 = class51.field1115.method3321(10);
      class51.field1123 = var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-42"
   )
   byte[] method209() throws IOException {
      if(class130.method2846() > this.field263) {
         throw new IOException();
      } else {
         if(this.field271 == 0) {
            if(this.field267.field2214 == 2) {
               throw new IOException();
            }

            if(this.field267.field2214 == 1) {
               this.field264 = (DataInputStream)this.field267.field2216;
               this.field271 = 1;
            }
         }

         int var1;
         if(this.field271 == 1) {
            var1 = this.field264.available();
            if(var1 > 0) {
               if(this.field266 + var1 > 4) {
                  var1 = 4 - this.field266;
               }

               this.field266 += this.field264.read(this.field265, this.field266, var1);
               if(this.field266 == 4) {
                  int var2 = (new class119(this.field265)).method2696();
                  this.field272 = new byte[var2];
                  this.field271 = 2;
               }
            }
         }

         if(this.field271 == 2) {
            var1 = this.field264.available();
            if(var1 > 0) {
               if(this.field268 + var1 > this.field272.length) {
                  var1 = this.field272.length - this.field268;
               }

               this.field268 += this.field264.read(this.field272, this.field268, var1);
               if(this.field272.length == this.field268) {
                  return this.field272;
               }
            }
         }

         return null;
      }
   }

   class18(class136 var1, URL var2) {
      this.field267 = var1.method2905(var2);
      this.field271 = 0;
      this.field263 = class130.method2846() + 30000L;
   }
}
