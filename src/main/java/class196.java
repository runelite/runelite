import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gs")
@Implements("XHashTable")
public final class class196 {
   @ObfuscatedName("y")
   int field3098 = 0;
   @ObfuscatedName("c")
   class208 field3099;
   @ObfuscatedName("d")
   class208 field3100;
   @ObfuscatedName("a")
   int field3101;
   @ObfuscatedName("w")
   class208[] field3102;

   @ObfuscatedName("y")
   public class208 method3867() {
      class208 var1;
      if(this.field3098 > 0 && this.field3099 != this.field3102[this.field3098 - 1]) {
         var1 = this.field3099;
         this.field3099 = var1.field3124;
         return var1;
      } else {
         do {
            if(this.field3098 >= this.field3101) {
               return null;
            }

            var1 = this.field3102[this.field3098++].field3124;
         } while(var1 == this.field3102[this.field3098 - 1]);

         this.field3099 = var1.field3124;
         return var1;
      }
   }

   @ObfuscatedName("a")
   public class208 method3868(long var1) {
      class208 var3 = this.field3102[(int)(var1 & (long)(this.field3101 - 1))];

      for(this.field3100 = var3.field3124; this.field3100 != var3; this.field3100 = this.field3100.field3124) {
         if(this.field3100.field3125 == var1) {
            class208 var4 = this.field3100;
            this.field3100 = this.field3100.field3124;
            return var4;
         }
      }

      this.field3100 = null;
      return null;
   }

   @ObfuscatedName("d")
   void method3870() {
      for(int var1 = 0; var1 < this.field3101; ++var1) {
         class208 var2 = this.field3102[var1];

         while(true) {
            class208 var3 = var2.field3124;
            if(var3 == var2) {
               break;
            }

            var3.method3998();
         }
      }

      this.field3100 = null;
      this.field3099 = null;
   }

   @ObfuscatedName("c")
   public class208 method3871() {
      this.field3098 = 0;
      return this.method3867();
   }

   @ObfuscatedName("w")
   public void method3875(class208 var1, long var2) {
      if(var1.field3123 != null) {
         var1.method3998();
      }

      class208 var4 = this.field3102[(int)(var2 & (long)(this.field3101 - 1))];
      var1.field3123 = var4.field3123;
      var1.field3124 = var4;
      var1.field3123.field3124 = var1;
      var1.field3124.field3123 = var1;
      var1.field3125 = var2;
   }

   public class196(int var1) {
      this.field3101 = var1;
      this.field3102 = new class208[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class208 var3 = this.field3102[var2] = new class208();
         var3.field3124 = var3;
         var3.field3123 = var3;
      }

   }
}
