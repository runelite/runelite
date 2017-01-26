import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class164 extends CacheableNode {
   @ObfuscatedName("x")
   public final int[] field2150;
   @ObfuscatedName("q")
   public final int[] field2152;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 937892455
   )
   public final int field2153;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2050204903
   )
   public final int field2156;

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-188803735"
   )
   static final String method3115(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + Client.method568('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + Client.method568(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + Client.method568(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "13"
   )
   public boolean method3116(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2152.length) {
         int var3 = this.field2152[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2150[var2]) {
            return true;
         }
      }

      return false;
   }

   class164(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2156 = var1;
      this.field2153 = var2;
      this.field2150 = var3;
      this.field2152 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;B)LModIcon;",
      garbageValue = "4"
   )
   public static ModIcon method3118(class182 var0, String var1, String var2) {
      int var3 = var0.method3276(var1);
      int var4 = var0.method3287(var3, var2);
      ModIcon var5;
      if(!class196.method3575(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class186.method3418();
      }

      return var5;
   }
}
