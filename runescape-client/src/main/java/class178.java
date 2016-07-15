import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class178 extends class207 {
   @ObfuscatedName("h")
   public final int[] field2937;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2125165529
   )
   public final int field2938;
   @ObfuscatedName("c")
   public final int[] field2939;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 620938607
   )
   public final int field2940;
   @ObfuscatedName("u")
   public static int[] field2941;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;B)[Lclass83;",
      garbageValue = "86"
   )
   public static class83[] method3539(class170 var0, String var1, String var2) {
      int var3 = var0.method3342(var1);
      int var4 = var0.method3357(var3, var2);
      class83[] var5;
      if(!class42.method884(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class119.method2549();
      }

      return var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "1"
   )
   public boolean method3541(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2937.length) {
         int var3 = this.field2937[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2939[var2]) {
            return true;
         }
      }

      return false;
   }

   class178(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2940 = var1;
      this.field2938 = var2;
      this.field2939 = var3;
      this.field2937 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "284968051"
   )
   static void method3543(int var0) {
      class15 var1 = (class15)class15.field227.method3864((long)var0);
      if(null != var1) {
         var1.method4000();
      }
   }
}
