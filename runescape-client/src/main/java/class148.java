import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public class class148 {
   static {
      new HashMap();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "-108715856"
   )
   public static String method2781(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var0 < 0) {
            return Integer.toString(var0, var1);
         } else {
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
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   class148() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-884514968"
   )
   static final void method2783(int var0, int var1) {
      if(class103.method1973(var0)) {
         class5.method65(Widget.widgets[var0], var1);
      }
   }
}
