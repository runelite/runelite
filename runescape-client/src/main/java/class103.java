import java.io.File;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("Frames")
public class class103 extends class204 {
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = -1811177379
   )
   static int field1755;
   @ObfuscatedName("b")
   class88[] field1756;
   @ObfuscatedName("x")
   static File field1759;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "2"
   )
   public boolean method2290(int var1) {
      return this.field1756[var1].field1512;
   }

   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;IZ)V",
      garbageValue = "0"
   )
   public class103(class167 var1, class167 var2, int var3, boolean var4) {
      class199 var5 = new class199();
      int var6 = var1.method3276(var3);
      this.field1756 = new class88[var6];
      int[] var7 = var1.method3307(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3266(var3, var7[var8]);
         class102 var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(class102 var12 = (class102)var5.method3844(); null != var12; var12 = (class102)var5.method3834()) {
            if(var11 == var12.field1743) {
               var10 = var12;
               break;
            }
         }

         if(null == var10) {
            byte[] var13 = var2.method3298(var11, 0);
            var10 = new class102(var11, var13);
            var5.method3819(var10);
         }

         this.field1756[var7[var8]] = new class88(var9, var10);
      }

   }

   @ObfuscatedName("g")
   public static String method2293(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class162.field2639[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }
}
