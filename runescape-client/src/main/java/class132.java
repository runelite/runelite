import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public final class class132 {
   @ObfuscatedName("gs")
   static class176 field2104;

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(Lclass32;III)V",
      garbageValue = "-2071733525"
   )
   static final void method2973(class32 var0, int var1, int var2) {
      class51.method1090(var0.field729, var0.field739, var0.field737, var0.field732, var0.field733, var0.field733, var1, var2);
   }

   @ObfuscatedName("l")
   public static String method2974(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(var0 != 0L) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class165.field2707[(int)(var6 - 37L * var0)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1585514549"
   )
   static final void method2975() {
      if(client.field523 != class99.field1701) {
         client.field523 = class99.field1701;
         class127.method2930(class99.field1701);
      }

   }
}
