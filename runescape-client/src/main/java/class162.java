import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class162 implements class115 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 55369785
   )
   public final int field2634;
   @ObfuscatedName("e")
   public static final class162 field2635 = new class162(3, 1);
   @ObfuscatedName("n")
   public static final class162 field2636 = new class162(0, 2);
   @ObfuscatedName("t")
   public static final class162 field2637 = new class162(1, 3);
   @ObfuscatedName("f")
   public static final class162 field2638 = new class162(2, 0);
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 702607079
   )
   final int field2639;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)[Lclass21;",
      garbageValue = "7"
   )
   static class21[] method3195() {
      return new class21[]{class21.field578, class21.field586, class21.field579, class21.field581};
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "50702266"
   )
   public int vmethod3196() {
      return this.field2639;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class162(int var1, int var2) {
      this.field2634 = var1;
      this.field2639 = var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "40895140"
   )
   public static String method3198(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class56.method1169(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
