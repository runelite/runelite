import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("Frames")
public class class103 extends class204 {
   @ObfuscatedName("t")
   class88[] field1782;
   @ObfuscatedName("bg")
   static class168 field1783;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-185144799"
   )
   public boolean method2241(int var1) {
      return this.field1782[var1].field1557;
   }

   class103(class167 var1, class167 var2, int var3, boolean var4) {
      class199 var5 = new class199();
      int var6 = var1.method3231(var3);
      this.field1782 = new class88[var6];
      int[] var7 = var1.method3230(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3221(var3, var7[var8]);
         class102 var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(class102 var12 = (class102)var5.method3797(); null != var12; var12 = (class102)var5.method3779()) {
            if(var12.field1773 == var11) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.method3240(0, var11);
            } else {
               var13 = var2.method3240(var11, 0);
            }

            var10 = new class102(var11, var13);
            var5.method3771(var10);
         }

         this.field1782[var7[var8]] = new class88(var9, var10);
      }

   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "125405652"
   )
   static final void method2245() {
      client.field325.method2733(93);
      client.field325.method2453(0);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BIS)I",
      garbageValue = "0"
   )
   public static int method2248(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var1 + var6);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var6 + var4] = -128;
            } else if(var7 == 8218) {
               var3[var4 + var6] = -126;
            } else if(var7 == 402) {
               var3[var6 + var4] = -125;
            } else if(var7 == 8222) {
               var3[var4 + var6] = -124;
            } else if(var7 == 8230) {
               var3[var6 + var4] = -123;
            } else if(var7 == 8224) {
               var3[var6 + var4] = -122;
            } else if(var7 == 8225) {
               var3[var4 + var6] = -121;
            } else if(var7 == 710) {
               var3[var4 + var6] = -120;
            } else if(var7 == 8240) {
               var3[var4 + var6] = -119;
            } else if(var7 == 352) {
               var3[var4 + var6] = -118;
            } else if(var7 == 8249) {
               var3[var4 + var6] = -117;
            } else if(var7 == 338) {
               var3[var4 + var6] = -116;
            } else if(var7 == 381) {
               var3[var6 + var4] = -114;
            } else if(var7 == 8216) {
               var3[var4 + var6] = -111;
            } else if(var7 == 8217) {
               var3[var4 + var6] = -110;
            } else if(var7 == 8220) {
               var3[var4 + var6] = -109;
            } else if(var7 == 8221) {
               var3[var4 + var6] = -108;
            } else if(var7 == 8226) {
               var3[var6 + var4] = -107;
            } else if(var7 == 8211) {
               var3[var6 + var4] = -106;
            } else if(var7 == 8212) {
               var3[var4 + var6] = -105;
            } else if(var7 == 732) {
               var3[var4 + var6] = -104;
            } else if(var7 == 8482) {
               var3[var4 + var6] = -103;
            } else if(var7 == 353) {
               var3[var6 + var4] = -102;
            } else if(var7 == 8250) {
               var3[var4 + var6] = -101;
            } else if(var7 == 339) {
               var3[var6 + var4] = -100;
            } else if(var7 == 382) {
               var3[var4 + var6] = -98;
            } else if(var7 == 376) {
               var3[var6 + var4] = -97;
            } else {
               var3[var6 + var4] = 63;
            }
         } else {
            var3[var6 + var4] = (byte)var7;
         }
      }

      return var5;
   }
}
