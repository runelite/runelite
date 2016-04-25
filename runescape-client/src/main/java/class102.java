import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public class class102 extends class208 {
   @ObfuscatedName("z")
   int[][] field1742;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2135288213
   )
   int field1743;
   @ObfuscatedName("m")
   int[] field1744;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1338442823
   )
   int field1747;

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(Lclass173;III)V",
      garbageValue = "-1533248780"
   )
   static void method2272(class173 var0, int var1, int var2) {
      if(var0.field2749 == 0) {
         var0.field2796 = var0.field2753;
      } else if(var0.field2749 == 1) {
         var0.field2796 = var0.field2753 + (var1 - var0.field2840) / 2;
      } else if(2 == var0.field2749) {
         var0.field2796 = var1 - var0.field2840 - var0.field2753;
      } else if(var0.field2749 == 3) {
         var0.field2796 = var1 * var0.field2753 >> 14;
      } else if(var0.field2749 == 4) {
         var0.field2796 = (var1 - var0.field2840) / 2 + (var1 * var0.field2753 >> 14);
      } else {
         var0.field2796 = var1 - var0.field2840 - (var0.field2753 * var1 >> 14);
      }

      if(0 == var0.field2750) {
         var0.field2758 = var0.field2754;
      } else if(var0.field2750 == 1) {
         var0.field2758 = (var2 - var0.field2746) / 2 + var0.field2754;
      } else if(var0.field2750 == 2) {
         var0.field2758 = var2 - var0.field2746 - var0.field2754;
      } else if(var0.field2750 == 3) {
         var0.field2758 = var2 * var0.field2754 >> 14;
      } else if(var0.field2750 == 4) {
         var0.field2758 = (var2 - var0.field2746) / 2 + (var2 * var0.field2754 >> 14);
      } else {
         var0.field2758 = var2 - var0.field2746 - (var0.field2754 * var2 >> 14);
      }

      if(client.field443 && 0 == var0.field2820) {
         if(var0.field2796 < 0) {
            var0.field2796 = 0;
         } else if(var0.field2796 + var0.field2840 > var1) {
            var0.field2796 = var1 - var0.field2840;
         }

         if(var0.field2758 < 0) {
            var0.field2758 = 0;
         } else if(var0.field2758 + var0.field2746 > var2) {
            var0.field2758 = var2 - var0.field2746;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)[B",
      garbageValue = "-56"
   )
   public static byte[] method2273(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 <= 0 || var4 >= 128) && (var4 < 160 || var4 > 255)) {
            if(8364 == var4) {
               var2[var3] = -128;
            } else if(8218 == var4) {
               var2[var3] = -126;
            } else if(402 == var4) {
               var2[var3] = -125;
            } else if(8222 == var4) {
               var2[var3] = -124;
            } else if(8230 == var4) {
               var2[var3] = -123;
            } else if(8224 == var4) {
               var2[var3] = -122;
            } else if(var4 == 8225) {
               var2[var3] = -121;
            } else if(710 == var4) {
               var2[var3] = -120;
            } else if(var4 == 8240) {
               var2[var3] = -119;
            } else if(352 == var4) {
               var2[var3] = -118;
            } else if(var4 == 8249) {
               var2[var3] = -117;
            } else if(338 == var4) {
               var2[var3] = -116;
            } else if(381 == var4) {
               var2[var3] = -114;
            } else if(8216 == var4) {
               var2[var3] = -111;
            } else if(var4 == 8217) {
               var2[var3] = -110;
            } else if(var4 == 8220) {
               var2[var3] = -109;
            } else if(8221 == var4) {
               var2[var3] = -108;
            } else if(8226 == var4) {
               var2[var3] = -107;
            } else if(8211 == var4) {
               var2[var3] = -106;
            } else if(var4 == 8212) {
               var2[var3] = -105;
            } else if(732 == var4) {
               var2[var3] = -104;
            } else if(var4 == 8482) {
               var2[var3] = -103;
            } else if(var4 == 353) {
               var2[var3] = -102;
            } else if(var4 == 8250) {
               var2[var3] = -101;
            } else if(339 == var4) {
               var2[var3] = -100;
            } else if(382 == var4) {
               var2[var3] = -98;
            } else if(var4 == 376) {
               var2[var3] = -97;
            } else {
               var2[var3] = 63;
            }
         } else {
            var2[var3] = (byte)var4;
         }
      }

      return var2;
   }

   class102(int var1, byte[] var2) {
      this.field1747 = var1;
      class119 var3 = new class119(var2);
      this.field1743 = var3.method2500();
      this.field1744 = new int[this.field1743];
      this.field1742 = new int[this.field1743][];

      int var4;
      for(var4 = 0; var4 < this.field1743; ++var4) {
         this.field1744[var4] = var3.method2500();
      }

      for(var4 = 0; var4 < this.field1743; ++var4) {
         this.field1742[var4] = new int[var3.method2500()];
      }

      for(var4 = 0; var4 < this.field1743; ++var4) {
         for(int var5 = 0; var5 < this.field1742[var4].length; ++var5) {
            this.field1742[var4][var5] = var3.method2500();
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "25"
   )
   public static final boolean method2274(String var0, String var1, String var2, String var3) {
      return var0 != null && null != var2?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;B)Lclass80;",
      garbageValue = "0"
   )
   public static class80 method2275(class167 var0, String var1, String var2) {
      int var3 = var0.method3232(var1);
      int var4 = var0.method3233(var3, var2);
      return class38.method752(var0, var3, var4);
   }
}
