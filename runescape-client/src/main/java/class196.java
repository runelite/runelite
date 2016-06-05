import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gc")
@Implements("XHashTable")
public final class class196 {
   @ObfuscatedName("t")
   @Export("size")
   int field3099;
   @ObfuscatedName("i")
   @Export("buckets")
   class208[] field3100;
   @ObfuscatedName("g")
   class208 field3101;
   @ObfuscatedName("h")
   class208 field3102;
   @ObfuscatedName("z")
   int field3103 = 0;

   @ObfuscatedName("t")
   public class208 method3748(long var1) {
      class208 var3 = this.field3100[(int)(var1 & (long)(this.field3099 - 1))];

      for(this.field3101 = var3.field3126; this.field3101 != var3; this.field3101 = this.field3101.field3126) {
         if(this.field3101.field3125 == var1) {
            class208 var4 = this.field3101;
            this.field3101 = this.field3101.field3126;
            return var4;
         }
      }

      this.field3101 = null;
      return null;
   }

   @ObfuscatedName("i")
   public void method3749(class208 var1, long var2) {
      if(var1.field3124 != null) {
         var1.method3870();
      }

      class208 var4 = this.field3100[(int)(var2 & (long)(this.field3099 - 1))];
      var1.field3124 = var4.field3124;
      var1.field3126 = var4;
      var1.field3124.field3126 = var1;
      var1.field3126.field3124 = var1;
      var1.field3125 = var2;
   }

   @ObfuscatedName("g")
   void method3750() {
      for(int var1 = 0; var1 < this.field3099; ++var1) {
         class208 var2 = this.field3100[var1];

         while(true) {
            class208 var3 = var2.field3126;
            if(var3 == var2) {
               break;
            }

            var3.method3870();
         }
      }

      this.field3101 = null;
      this.field3102 = null;
   }

   @ObfuscatedName("h")
   public class208 method3751() {
      this.field3103 = 0;
      return this.method3752();
   }

   @ObfuscatedName("z")
   public class208 method3752() {
      class208 var1;
      if(this.field3103 > 0 && this.field3102 != this.field3100[this.field3103 - 1]) {
         var1 = this.field3102;
         this.field3102 = var1.field3126;
         return var1;
      } else {
         do {
            if(this.field3103 >= this.field3099) {
               return null;
            }

            var1 = this.field3100[this.field3103++].field3126;
         } while(var1 == this.field3100[this.field3103 - 1]);

         this.field3102 = var1.field3126;
         return var1;
      }
   }

   public class196(int var1) {
      this.field3099 = var1;
      this.field3100 = new class208[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class208 var3 = this.field3100[var2] = new class208();
         var3.field3126 = var3;
         var3.field3124 = var3;
      }

   }
}
