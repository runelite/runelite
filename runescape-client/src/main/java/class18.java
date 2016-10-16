import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class18 {
   @ObfuscatedName("bb")
   static class171 field236;
   @ObfuscatedName("z")
   class149 field237;
   @ObfuscatedName("t")
   DataInputStream field238;
   @ObfuscatedName("y")
   byte[] field239 = new byte[4];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2044244273
   )
   int field240;
   @ObfuscatedName("g")
   byte[] field241;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2128148143
   )
   int field243;
   @ObfuscatedName("l")
   static class13 field244;
   @ObfuscatedName("au")
   static boolean field245;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -285279861
   )
   int field248;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -29138309582144615L
   )
   long field249;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CB)B",
      garbageValue = "91"
   )
   public static byte method192(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "70"
   )
   byte[] method193() throws IOException {
      if(class113.method2394() > this.field249) {
         throw new IOException();
      } else {
         if(this.field243 == 0) {
            if(this.field237.field2257 == 2) {
               throw new IOException();
            }

            if(this.field237.field2257 == 1) {
               this.field238 = (DataInputStream)this.field237.field2261;
               this.field243 = 1;
            }
         }

         int var1;
         if(this.field243 == 1) {
            var1 = this.field238.available();
            if(var1 > 0) {
               if(this.field240 + var1 > 4) {
                  var1 = 4 - this.field240;
               }

               this.field240 += this.field238.read(this.field239, this.field240, var1);
               if(this.field240 == 4) {
                  int var2 = (new Buffer(this.field239)).method2526();
                  this.field241 = new byte[var2];
                  this.field243 = 2;
               }
            }
         }

         if(this.field243 == 2) {
            var1 = this.field238.available();
            if(var1 > 0) {
               if(var1 + this.field248 > this.field241.length) {
                  var1 = this.field241.length - this.field248;
               }

               this.field248 += this.field238.read(this.field241, this.field248, var1);
               if(this.field241.length == this.field248) {
                  return this.field241;
               }
            }
         }

         return null;
      }
   }

   class18(class139 var1, URL var2) {
      this.field237 = var1.method2880(var2);
      this.field243 = 0;
      this.field249 = class113.method2394() + 30000L;
   }
}
