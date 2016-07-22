import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class178 extends class207 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1313887825
   )
   public final int field2938;
   @ObfuscatedName("e")
   public final int[] field2940;
   @ObfuscatedName("o")
   public final int[] field2941;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1498912197
   )
   public final int field2948;

   class178(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2948 = var1;
      this.field2938 = var2;
      this.field2940 = var3;
      this.field2941 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2081812237"
   )
   public boolean method3499(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2941.length) {
         int var3 = this.field2941[var2];
         if(var1 >= var3 && var1 <= this.field2940[var2] + var3) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "10"
   )
   static final void method3501(int var0, int var1) {
      if(class122.method2739(var0)) {
         class8.method116(class176.field2814[var0], var1);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass46;",
      garbageValue = "-84867592"
   )
   @Export("getKitDefinition")
   public static class46 method3502(int var0) {
      class46 var1 = (class46)class46.field1047.method3817((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class46.field1049.method3304(3, var0);
         var1 = new class46();
         if(var2 != null) {
            var1.method971(new class122(var2));
         }

         class46.field1047.method3823(var1, (long)var0);
         return var1;
      }
   }
}
