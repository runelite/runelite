import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
@Implements("XHashTable")
public final class class199 {
   @ObfuscatedName("r")
   class211 field3147;
   @ObfuscatedName("g")
   @Export("buckets")
   class211[] field3148;
   @ObfuscatedName("e")
   class211 field3149;
   @ObfuscatedName("l")
   @Export("size")
   int field3150;
   @ObfuscatedName("h")
   int field3151 = 0;

   @ObfuscatedName("h")
   public class211 method3935() {
      class211 var1;
      if(this.field3151 > 0 && this.field3149 != this.field3148[this.field3151 - 1]) {
         var1 = this.field3149;
         this.field3149 = var1.field3173;
         return var1;
      } else {
         do {
            if(this.field3151 >= this.field3150) {
               return null;
            }

            var1 = this.field3148[this.field3151++].field3173;
         } while(var1 == this.field3148[this.field3151 - 1]);

         this.field3149 = var1.field3173;
         return var1;
      }
   }

   @ObfuscatedName("l")
   public class211 method3936(long var1) {
      class211 var3 = this.field3148[(int)(var1 & (long)(this.field3150 - 1))];

      for(this.field3147 = var3.field3173; this.field3147 != var3; this.field3147 = this.field3147.field3173) {
         if(this.field3147.field3175 == var1) {
            class211 var4 = this.field3147;
            this.field3147 = this.field3147.field3173;
            return var4;
         }
      }

      this.field3147 = null;
      return null;
   }

   @ObfuscatedName("r")
   void method3938() {
      for(int var1 = 0; var1 < this.field3150; ++var1) {
         class211 var2 = this.field3148[var1];

         while(true) {
            class211 var3 = var2.field3173;
            if(var3 == var2) {
               break;
            }

            var3.method4067();
         }
      }

      this.field3147 = null;
      this.field3149 = null;
   }

   @ObfuscatedName("e")
   public class211 method3939() {
      this.field3151 = 0;
      return this.method3935();
   }

   @ObfuscatedName("g")
   public void method3940(class211 var1, long var2) {
      if(var1.field3174 != null) {
         var1.method4067();
      }

      class211 var4 = this.field3148[(int)(var2 & (long)(this.field3150 - 1))];
      var1.field3174 = var4.field3174;
      var1.field3173 = var4;
      var1.field3174.field3173 = var1;
      var1.field3173.field3174 = var1;
      var1.field3175 = var2;
   }

   public class199(int var1) {
      this.field3150 = var1;
      this.field3148 = new class211[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class211 var3 = this.field3148[var2] = new class211();
         var3.field3173 = var3;
         var3.field3174 = var3;
      }

   }
}
