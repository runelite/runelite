import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class40 extends class210 {
   @ObfuscatedName("v")
   short field900;
   @ObfuscatedName("d")
   String field901;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1593146625
   )
   int field902 = (int)(class5.method63() / 1000L);
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -105683097
   )
   static int field903;
   @ObfuscatedName("iv")
   static Widget field906;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIZB)Ljava/lang/String;",
      garbageValue = "1"
   )
   static String method801(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var2 && var0 >= 0) {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if(var8 >= 10) {
                  var5[var6] = (char)(87 + var8);
               } else {
                  var5[var6] = (char)(48 + var8);
               }
            }

            return new String(var5);
         } else {
            return Integer.toString(var0, var1);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "7314817"
   )
   static void method802(int var0) {
      if(var0 != -1) {
         if(class93.method2114(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2897 != null) {
                  class0 var4 = new class0();
                  var4.field2 = var3;
                  var4.field7 = var3.field2897;
                  class1.method9(var4, 2000000);
               }
            }

         }
      }
   }

   class40(String var1, int var2) {
      this.field901 = var1;
      this.field900 = (short)var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-507491965"
   )
   static void method803() {
      class34.field779 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class34.field778[var0] = null;
         class34.field777[var0] = 1;
      }

   }
}
