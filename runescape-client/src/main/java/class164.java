import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class164 extends CacheableNode {
   @ObfuscatedName("g")
   public final int[] field2162;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 2050120767
   )
   static int field2163;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 534225715
   )
   public final int field2164;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1177685645
   )
   public final int field2165;
   @ObfuscatedName("l")
   public static short[] field2166;
   @ObfuscatedName("b")
   public final int[] field2168;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-141039945"
   )
   public boolean method3052(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2162.length) {
         int var3 = this.field2162[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2168[var2]) {
            return true;
         }
      }

      return false;
   }

   class164(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2164 = var1;
      this.field2165 = var2;
      this.field2168 = var3;
      this.field2162 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass196;",
      garbageValue = "13845423"
   )
   public static class196 method3054(int var0) {
      class196 var1 = (class196)class196.field2869.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class196.field2866.method3203(32, var0);
         var1 = new class196();
         if(null != var2) {
            var1.method3477(new Buffer(var2));
         }

         class196.field2869.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "351726258"
   )
   public static void method3055(Applet var0, String var1) {
      class114.field1800 = var0;
      class114.field1799 = var1;
   }
}
