import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kc")
@Implements("Ignore")
public class Ignore extends Nameable {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -564406465
   )
   int field3716;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lkc;I)I",
      garbageValue = "1400119308"
   )
   int method5321(Ignore var1) {
      return this.field3716 - var1.field3716;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Ljw;I)I",
      garbageValue = "-1639507459"
   )
   public int vmethod5385(Nameable var1) {
      return this.method5321((Ignore)var1);
   }

   public int compareTo(Object var1) {
      return this.method5321((Ignore)var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "-1517009499"
   )
   static String method5330(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var2 && var0 >= 0) {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = '+';

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
         } else {
            return Integer.toString(var0, var1);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2061309487"
   )
   static final int method5331(int var0, int var1) {
      int var2 = TotalQuantityComparator.getSmoothNoise(var0 + 45365, var1 + 91923, 4) - 128 + (TotalQuantityComparator.getSmoothNoise(10294 + var0, 37821 + var1, 2) - 128 >> 1) + (TotalQuantityComparator.getSmoothNoise(var0, var1, 1) - 128 >> 2);
      var2 = (int)((double)var2 * 0.3D) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }
}
