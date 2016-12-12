import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class146 {
   @ObfuscatedName("i")
   Inflater field2019;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BB)V",
      garbageValue = "-6"
   )
   public void method2695(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.field2019 == null) {
            this.field2019 = new Inflater(true);
         }

         try {
            this.field2019.setInput(var1.payload, 10 + var1.offset, var1.payload.length - (8 + var1.offset + 10));
            this.field2019.inflate(var2);
         } catch (Exception var4) {
            this.field2019.reset();
            throw new RuntimeException("");
         }

         this.field2019.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   public class146() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class146(int var1, int var2, int var3) {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIILObjectComposition;II)V",
      garbageValue = "1354202052"
   )
   static void method2697(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class31 var5 = new class31();
      var5.field699 = var0;
      var5.field700 = var1 * 128;
      var5.field701 = var2 * 128;
      int var6 = var3.field2907;
      int var7 = var3.field2908;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.field2908;
         var7 = var3.field2907;
      }

      var5.field702 = (var6 + var1) * 128;
      var5.field703 = (var2 + var7) * 128;
      var5.field705 = var3.field2936;
      var5.field704 = var3.field2920 * 128;
      var5.field713 = var3.field2938;
      var5.field708 = var3.field2902;
      var5.field707 = var3.field2940;
      if(null != var3.impostorIds) {
         var5.field712 = var3;
         var5.method637();
      }

      class31.field706.method2376(var5);
      if(var5.field707 != null) {
         var5.field710 = var5.field713 + (int)(Math.random() * (double)(var5.field708 - var5.field713));
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BIB)I",
      garbageValue = "66"
   )
   public static int method2698(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var4 + var6] = -125;
         } else if(var7 == 8222) {
            var3[var4 + var6] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(var7 == 8225) {
            var3[var4 + var6] = -121;
         } else if(var7 == 710) {
            var3[var6 + var4] = -120;
         } else if(var7 == 8240) {
            var3[var4 + var6] = -119;
         } else if(var7 == 352) {
            var3[var4 + var6] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var6 + var4] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if(var7 == 8220) {
            var3[var4 + var6] = -109;
         } else if(var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var4 + var6] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var4 + var6] = -103;
         } else if(var7 == 353) {
            var3[var4 + var6] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var4 + var6] = -100;
         } else if(var7 == 382) {
            var3[var4 + var6] = -98;
         } else if(var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var4 + var6] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "-2143504343"
   )
   public static int method2699(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var5 != var9 / var1) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
