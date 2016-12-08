import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class40 implements class158 {
   @ObfuscatedName("m")
   static final class40 field818 = new class40(1);
   @ObfuscatedName("b")
   static final class40 field819 = new class40(2);
   @ObfuscatedName("o")
   static final class40 field821 = new class40(0);
   @ObfuscatedName("g")
   static final class40 field824 = new class40(3);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -94819943
   )
   final int field825;

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class40(int var1) {
      this.field825 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "255"
   )
   public int vmethod3989() {
      return this.field825;
   }

   @ObfuscatedName("o")
   public static String method733(long var0) {
      class162.field2158.setTime(new Date(var0));
      int var2 = class162.field2158.get(7);
      int var3 = class162.field2158.get(5);
      int var4 = class162.field2158.get(2);
      int var5 = class162.field2158.get(1);
      int var6 = class162.field2158.get(11);
      int var7 = class162.field2158.get(12);
      int var8 = class162.field2158.get(13);
      return class162.field2157[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class162.field2156[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2142156932"
   )
   static int method734(int var0) {
      MessageNode var1 = (MessageNode)class47.field945.method2258((long)var0);
      return var1 == null?-1:(var1.next == class47.field939.field1913?-1:((MessageNode)var1.next).id);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1616971064"
   )
   public static boolean method735(char var0) {
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 != 0) {
            char[] var1 = class203.field3068;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var3 == var0) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return true;
      }
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1463140374"
   )
   static final void method736(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class25 var9 = null;

      for(class25 var10 = (class25)Client.field300.method2349(); null != var10; var10 = (class25)Client.field300.method2351()) {
         if(var10.field575 == var0 && var10.field584 == var1 && var2 == var10.field573 && var3 == var10.field571) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class25();
         var9.field575 = var0;
         var9.field571 = var3;
         var9.field584 = var1;
         var9.field573 = var2;
         Client.method400(var9);
         Client.field300.method2361(var9);
      }

      var9.field579 = var4;
      var9.field570 = var5;
      var9.field578 = var6;
      var9.field580 = var7;
      var9.field577 = var8;
   }
}
