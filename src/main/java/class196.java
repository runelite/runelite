import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
@Implements("XHashTable")
public final class class196 {
   @ObfuscatedName("x")
   class208[] field3098;
   @ObfuscatedName("e")
   int field3099 = 0;
   @ObfuscatedName("t")
   class208 field3100;
   @ObfuscatedName("p")
   class208 field3101;
   @ObfuscatedName("w")
   int field3102;

   @ObfuscatedName("p")
   public class208 method3805() {
      this.field3099 = 0;
      return this.method3809();
   }

   @ObfuscatedName("w")
   public class208 method3806(long var1) {
      class208 var3 = this.field3098[(int)(var1 & (long)(this.field3102 - 1))];

      for(this.field3100 = var3.field3124; this.field3100 != var3; this.field3100 = this.field3100.field3124) {
         if(this.field3100.field3123 == var1) {
            class208 var4 = this.field3100;
            this.field3100 = this.field3100.field3124;
            return var4;
         }
      }

      this.field3100 = null;
      return null;
   }

   @ObfuscatedName("x")
   public void method3807(class208 var1, long var2) {
      if(var1.field3125 != null) {
         var1.method3935();
      }

      class208 var4 = this.field3098[(int)(var2 & (long)(this.field3102 - 1))];
      var1.field3125 = var4.field3125;
      var1.field3124 = var4;
      var1.field3125.field3124 = var1;
      var1.field3124.field3125 = var1;
      var1.field3123 = var2;
   }

   @ObfuscatedName("t")
   void method3808() {
      for(int var1 = 0; var1 < this.field3102; ++var1) {
         class208 var2 = this.field3098[var1];

         while(true) {
            class208 var3 = var2.field3124;
            if(var3 == var2) {
               break;
            }

            var3.method3935();
         }
      }

      this.field3100 = null;
      this.field3101 = null;
   }

   public class196(int var1) {
      this.field3102 = var1;
      this.field3098 = new class208[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class208 var3 = this.field3098[var2] = new class208();
         var3.field3124 = var3;
         var3.field3125 = var3;
      }

   }

   @ObfuscatedName("e")
   public class208 method3809() {
      class208 var1;
      if(this.field3099 > 0 && this.field3101 != this.field3098[this.field3099 - 1]) {
         var1 = this.field3101;
         this.field3101 = var1.field3124;
         return var1;
      } else {
         do {
            if(this.field3099 >= this.field3102) {
               return null;
            }

            var1 = this.field3098[this.field3099++].field3124;
         } while(var1 == this.field3098[this.field3099 - 1]);

         this.field3101 = var1.field3124;
         return var1;
      }
   }
}
