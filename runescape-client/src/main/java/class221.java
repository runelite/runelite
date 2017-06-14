import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class221 implements class178 {
   @ObfuscatedName("p")
   static final class221 field2811;
   @ObfuscatedName("y")
   static final class221 field2812;
   @ObfuscatedName("i")
   public static final class221 field2813;
   @ObfuscatedName("j")
   public static final class221 field2814;
   @ObfuscatedName("f")
   public static final class221 field2815;
   @ObfuscatedName("n")
   public static final class221 field2816;
   @ObfuscatedName("c")
   static final class221 field2817;
   @ObfuscatedName("z")
   static final class221 field2818;
   @ObfuscatedName("h")
   static final class221 field2819;
   @ObfuscatedName("g")
   static final class221 field2820;
   @ObfuscatedName("x")
   static final class221 field2821;
   @ObfuscatedName("o")
   static final class221 field2822;
   @ObfuscatedName("e")
   static final class221 field2823;
   @ObfuscatedName("a")
   static final class221 field2824;
   @ObfuscatedName("l")
   public static final class221 field2825;
   @ObfuscatedName("r")
   static final class221 field2826;
   @ObfuscatedName("b")
   static final class221 field2827;
   @ObfuscatedName("s")
   static final class221 field2828;
   @ObfuscatedName("v")
   static final class221 field2829;
   @ObfuscatedName("t")
   static final class221 field2830;
   @ObfuscatedName("w")
   public static final class221 field2831;
   @ObfuscatedName("m")
   static final class221 field2832;
   @ObfuscatedName("q")
   public static final class221 field2833;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -289783309
   )
   public final int field2834;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -274740629
   )
   @Export("spellTargetFlags")
   static int spellTargetFlags;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "81"
   )
   public static int method4087(CharSequence var0, int var1, boolean var2) {
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

            int var9 = var1 * var5 + var10;
            if(var9 / var1 != var5) {
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1469137335"
   )
   public int vmethod5059() {
      return this.field2834;
   }

   static {
      field2816 = new class221(0, 0);
      field2811 = new class221(1, 0);
      field2813 = new class221(2, 0);
      field2814 = new class221(3, 0);
      field2815 = new class221(9, 2);
      field2832 = new class221(4, 1);
      field2817 = new class221(5, 1);
      field2818 = new class221(6, 1);
      field2819 = new class221(7, 1);
      field2820 = new class221(8, 1);
      field2823 = new class221(12, 2);
      field2822 = new class221(13, 2);
      field2821 = new class221(14, 2);
      field2824 = new class221(15, 2);
      field2812 = new class221(16, 2);
      field2826 = new class221(17, 2);
      field2827 = new class221(18, 2);
      field2828 = new class221(19, 2);
      field2829 = new class221(20, 2);
      field2830 = new class221(21, 2);
      field2831 = new class221(10, 2);
      field2825 = new class221(11, 2);
      field2833 = new class221(22, 3);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "265380458"
   )
   public static void method4091(IndexDataBase var0) {
      Enum.field3410 = var0;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class221(int var1, int var2) {
      this.field2834 = var1;
   }
}
