import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("p")
public class class4 {
   @ObfuscatedName("w")
   static final BigInteger field72 = new BigInteger("8bdfd1426ecd0bedebc542d065a75094de20d14e62ff61e677ffb20adf8165b99aa5fd511ed8858fed7578238a56794b2900fa3f1fb4267cd367e8cb6ad010efd4467f22cf79ce655c0d20aaf9ccd75f8019d9db88fd6b117bf703c17eded8cd038be2f7ba66e2e871c09a916b4ac1210d4d248430dbd7328c388dd63caddc05", 16);
   @ObfuscatedName("j")
   static int[][][] field74;
   @ObfuscatedName("qs")
   protected static class133 field75;
   @ObfuscatedName("e")
   static final BigInteger field78 = new BigInteger("10001", 16);

   @ObfuscatedName("s")
   public static void method44(int var0) {
      class183.field2958 = 1;
      class14.field209 = null;
      class148.field2219 = -1;
      class164.field2656 = -1;
      class96.field1611 = 0;
      class125.field2030 = false;
      class209.field3118 = var0;
   }

   @ObfuscatedName("ah")
   static final void method45(class66 var0) {
      var0.field1238 = false;
      if(null != var0.field1237) {
         var0.field1237.field1234 = 0;
      }

      for(class66 var1 = var0.vmethod3713(); null != var1; var1 = var0.vmethod3733()) {
         method45(var1);
      }

   }

   @ObfuscatedName("b")
   static final void method46() {
      if(client.field472 > 0) {
         class27.method635();
      } else {
         class141.method2971(40);
         class87.field1516 = class46.field1040;
         class46.field1040 = null;
      }
   }

   @ObfuscatedName("az")
   static final void method47(class37 var0) {
      int var1 = var0.field833 - client.field289;
      int var2 = var0.field792 * 64 + var0.field816 * 128;
      int var3 = var0.field831 * 128 + var0.field792 * 64;
      var0.field804 += (var2 - var0.field804) / var1;
      var0.field814 += (var3 - var0.field814) / var1;
      var0.field832 = 0;
      var0.field793 = var0.field840;
   }

   @ObfuscatedName("e")
   public static void method48(class113 var0) {
      class222.field3180 = var0;
   }
}
