import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class145 extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1623755831
   )
   public final int field2020;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = -917718289
   )
   static int field2021;
   @ObfuscatedName("m")
   public final int[] field2022;
   @ObfuscatedName("h")
   public final int[] field2023;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1058251001
   )
   public final int field2028;

   class145(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2028 = var1;
      this.field2020 = var2;
      this.field2022 = var3;
      this.field2023 = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-457168754"
   )
   public boolean method2784(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2023.length) {
         int var3 = this.field2023[var2];
         if(var1 >= var3 && var1 <= this.field2022[var2] + var3) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "180"
   )
   static final String method2788(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class13.method182('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class13.method182(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class13.method182(16776960) + var1 + "</col>");
   }
}
