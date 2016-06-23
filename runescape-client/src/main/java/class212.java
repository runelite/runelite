import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public class class212 {
   @ObfuscatedName("x")
   static final class212 field3131 = new class212(4, 2, "", "");
   @ObfuscatedName("u")
   static final class212 field3132 = new class212(1, 1, "", "");
   @ObfuscatedName("b")
   static final class212 field3134 = new class212(0, 3, "", "");
   @ObfuscatedName("l")
   static final class212 field3135 = new class212(6, 4, "", "");
   @ObfuscatedName("d")
   static final class212 field3136 = new class212(3, 5, "", "");
   @ObfuscatedName("n")
   static final class212 field3137 = new class212(8, 6, "", "");
   @ObfuscatedName("m")
   static final class212 field3138 = new class212(7, 7, "", "");
   @ObfuscatedName("g")
   public static final class212 field3139;
   @ObfuscatedName("f")
   public static final class212 field3140 = new class212(2, 0, "", "");
   @ObfuscatedName("r")
   final String field3141;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -458349327
   )
   public final int field3142;

   public String toString() {
      return this.field3141;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass25;Lclass25;IZB)I",
      garbageValue = "-1"
   )
   static int method3963(class25 var0, class25 var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.field638;
         int var5 = var1.field638;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.field650 - var1.field650:(var2 == 3?(var0.field631.equals("-")?(var1.field631.equals("-")?0:(var3?-1:1)):(var1.field631.equals("-")?(var3?1:-1):var0.field631.compareTo(var1.field631))):(var2 == 4?(var0.method639()?(var1.method639()?0:1):(var1.method639()?-1:0)):(var2 == 5?(var0.method636()?(var1.method636()?0:1):(var1.method636()?-1:0)):(var2 == 6?(var0.method635()?(var1.method635()?0:1):(var1.method635()?-1:0)):(var2 == 7?(var0.method646()?(var1.method646()?0:1):(var1.method646()?-1:0)):var0.field640 - var1.field640)))));
      }
   }

   class212(int var1, int var2, String var3, String var4) {
      this.field3142 = var1;
      this.field3141 = var4;
   }

   static {
      field3139 = new class212(5, -1, "", "", true, new class212[]{field3140, field3132, field3131, field3135, field3134});
   }

   class212(int var1, int var2, String var3, String var4, boolean var5, class212[] var6) {
      this.field3142 = var1;
      this.field3141 = var4;
   }
}
