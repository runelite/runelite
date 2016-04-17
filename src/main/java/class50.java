import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class50 extends class204 {
   @ObfuscatedName("w")
   static class193 field1106 = new class193(64);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1121209493
   )
   static int field1107;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2021483897
   )
   public int field1111 = 0;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "0"
   )
   static void method1112(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(class25.field652[var5] != var0) {
            var2[var4] = class25.field652[var5];
            var3[var4] = class25.field643[var5];
            ++var4;
         }
      }

      class25.field652 = var2;
      class25.field643 = var3;
      class34.method817(class129.field2051, 0, class129.field2051.length - 1, class25.field652, class25.field643);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "50"
   )
   void method1113(class119 var1) {
      while(true) {
         int var2 = var1.method2613();
         if(0 == var2) {
            return;
         }

         this.method1122(var1, var2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "-20"
   )
   void method1122(class119 var1, int var2) {
      if(2 == var2) {
         this.field1111 = var1.method2615();
      }

   }

   @ObfuscatedName("a")
   public static String method1123(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(0L != var0) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class162.field2638[(int)(var6 - 37L * var0)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }
}
