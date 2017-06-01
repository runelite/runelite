import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
final class class17 implements Comparator {
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      longValue = 7922682741429947115L
   )
   static long field306;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -744061887
   )
   static int field307;
   @ObfuscatedName("i")
   static IndexDataBase field309;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "1170749802"
   )
   int method98(class14 var1, class14 var2) {
      return var1.field286.price < var2.field286.price?-1:(var2.field286.price == var1.field286.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method98((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "221209211"
   )
   public static final void method104() {
      class134.field2018 = false;
      class134.field2013 = 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "1"
   )
   static final int method108(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "-1968044240"
   )
   static String method109(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }
}
