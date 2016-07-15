import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class18 {
   @ObfuscatedName("c")
   DataInputStream field261;
   @ObfuscatedName("l")
   class149 field262;
   @ObfuscatedName("a")
   byte[] field263;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1293686645
   )
   int field265;
   @ObfuscatedName("h")
   byte[] field266 = new byte[4];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1163112415
   )
   int field267;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 1444547903629387419L
   )
   long field268;
   @ObfuscatedName("bo")
   static class171 field269;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1346869615
   )
   int field270;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "-176925691"
   )
   public static byte[] method169(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof class128) {
         class128 var2 = (class128)var0;
         return var2.vmethod2906();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "662614011"
   )
   byte[] method170() throws IOException {
      if(client.method424() > this.field268) {
         throw new IOException();
      } else {
         if(this.field267 == 0) {
            if(this.field262.field2264 == 2) {
               throw new IOException();
            }

            if(this.field262.field2264 == 1) {
               this.field261 = (DataInputStream)this.field262.field2260;
               this.field267 = 1;
            }
         }

         int var1;
         if(this.field267 == 1) {
            var1 = this.field261.available();
            if(var1 > 0) {
               if(var1 + this.field265 > 4) {
                  var1 = 4 - this.field265;
               }

               this.field265 += this.field261.read(this.field266, this.field265, var1);
               if(this.field265 == 4) {
                  int var2 = (new class122(this.field266)).method2614();
                  this.field263 = new byte[var2];
                  this.field267 = 2;
               }
            }
         }

         if(this.field267 == 2) {
            var1 = this.field261.available();
            if(var1 > 0) {
               if(var1 + this.field270 > this.field263.length) {
                  var1 = this.field263.length - this.field270;
               }

               this.field270 += this.field261.read(this.field263, this.field270, var1);
               if(this.field263.length == this.field270) {
                  return this.field263;
               }
            }
         }

         return null;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1885428045"
   )
   static final void method172() {
      for(class6 var0 = (class6)client.field428.method3899(); var0 != null; var0 = (class6)client.field428.method3918()) {
         if(class50.field1119 == var0.field98 && client.field567 <= var0.field104) {
            if(client.field567 >= var0.field103) {
               if(var0.field127 > 0) {
                  class36 var1 = client.field331[var0.field127 - 1];
                  if(var1 != null && var1.field896 >= 0 && var1.field896 < 13312 && var1.field879 >= 0 && var1.field879 < 13312) {
                     var0.method79(var1.field896, var1.field879, class105.method2370(var1.field896, var1.field879, var0.field98) - var0.field102, client.field567);
                  }
               }

               if(var0.field127 < 0) {
                  int var2 = -var0.field127 - 1;
                  class2 var3;
                  if(var2 == client.field417) {
                     var3 = class118.field2035;
                  } else {
                     var3 = client.field467[var2];
                  }

                  if(var3 != null && var3.field896 >= 0 && var3.field896 < 13312 && var3.field879 >= 0 && var3.field879 < 13312) {
                     var0.method79(var3.field896, var3.field879, class105.method2370(var3.field896, var3.field879, var0.field98) - var0.field102, client.field567);
                  }
               }

               var0.method80(client.field485);
               class79.field1453.method2020(class50.field1119, (int)var0.field109, (int)var0.field110, (int)var0.field111, 60, var0, var0.field117, -1, false);
            }
         } else {
            var0.method4000();
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "70"
   )
   static void method173(int var0) {
      if(var0 != -1) {
         if(class10.method112(var0)) {
            class176[] var1 = class176.field2811[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               class176 var3 = var1[var2];
               if(null != var3.field2875) {
                  class0 var4 = new class0();
                  var4.field2 = var3;
                  var4.field4 = var3.field2875;
                  class39.method803(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1452701619"
   )
   static final void method174(int var0) {
      short var1 = 256;
      class33.field768 += var0 * 128;
      int var2;
      if(class33.field768 > class22.field606.length) {
         class33.field768 -= class22.field606.length;
         var2 = (int)(Math.random() * 12.0D);
         class36.method762(class35.field818[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = 128 * (var1 - var0);

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class33.field771[var2 + var3] - var0 * class22.field606[var2 + class33.field768 & class22.field606.length - 1] / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class33.field771[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class33.field771[var7 + var6] = 255;
            } else {
               class33.field771[var7 + var6] = 0;
            }
         }
      }

      if(class33.field769 > 0) {
         class33.field769 -= 4 * var0;
      }

      if(class33.field783 > 0) {
         class33.field783 -= var0 * 4;
      }

      if(class33.field769 == 0 && class33.field783 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class33.field769 = 1024;
         }

         if(var5 == 1) {
            class33.field783 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class33.field767[var5] = class33.field767[var5 + var0];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class33.field767[var5] = (int)(Math.sin((double)class33.field775 / 14.0D) * 16.0D + Math.sin((double)class33.field775 / 15.0D) * 14.0D + Math.sin((double)class33.field775 / 16.0D) * 12.0D);
         ++class33.field775;
      }

      class33.field766 += var0;
      var5 = ((client.field567 & 1) + var0) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class33.field766 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class33.field771[var7 + (var8 << 7)] = 192;
         }

         class33.field766 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var9 + var5 < 128) {
                  var7 += class33.field771[var9 + var8 + var5];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= class33.field771[var9 + var8 - (1 + var5)];
               }

               if(var9 >= 0) {
                  class0.field6[var9 + var8] = var7 / (1 + var5 * 2);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = 128 * var8;
               if(var8 + var5 < var1) {
                  var7 += class0.field6[var9 + var6 + var5 * 128];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= class0.field6[var9 + var6 - 128 * (var5 + 1)];
               }

               if(var8 >= 0) {
                  class33.field771[var6 + var9] = var7 / (1 + 2 * var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)[Lclass133;",
      garbageValue = "2145168248"
   )
   public static class133[] method175() {
      return new class133[]{class133.field2113, class133.field2112, class133.field2116};
   }

   class18(class139 var1, URL var2) {
      this.field262 = var1.method2997(var2);
      this.field267 = 0;
      this.field268 = client.method424() + 30000L;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-56"
   )
   static final boolean method176(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }
}
