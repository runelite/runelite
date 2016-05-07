import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gr")
@Implements("XHashTable")
public final class class196 {
   @ObfuscatedName("p")
   class208 field3099;
   @ObfuscatedName("j")
   class208[] field3100;
   @ObfuscatedName("x")
   class208 field3101;
   @ObfuscatedName("s")
   int field3102;
   @ObfuscatedName("d")
   int field3103 = 0;

   @ObfuscatedName("s")
   public class208 method3777(long var1) {
      class208 var3 = this.field3100[(int)(var1 & (long)(this.field3102 - 1))];

      for(this.field3099 = var3.field3124; this.field3099 != var3; this.field3099 = this.field3099.field3124) {
         if(this.field3099.field3125 == var1) {
            class208 var4 = this.field3099;
            this.field3099 = this.field3099.field3124;
            return var4;
         }
      }

      this.field3099 = null;
      return null;
   }

   @ObfuscatedName("j")
   public void method3778(class208 var1, long var2) {
      if(var1.field3126 != null) {
         var1.method3898();
      }

      class208 var4 = this.field3100[(int)(var2 & (long)(this.field3102 - 1))];
      var1.field3126 = var4.field3126;
      var1.field3124 = var4;
      var1.field3126.field3124 = var1;
      var1.field3124.field3126 = var1;
      var1.field3125 = var2;
   }

   @ObfuscatedName("p")
   void method3779() {
      for(int var1 = 0; var1 < this.field3102; ++var1) {
         class208 var2 = this.field3100[var1];

         while(true) {
            class208 var3 = var2.field3124;
            if(var3 == var2) {
               break;
            }

            var3.method3898();
         }
      }

      this.field3099 = null;
      this.field3101 = null;
   }

   @ObfuscatedName("x")
   public class208 method3780() {
      this.field3103 = 0;
      return this.method3781();
   }

   @ObfuscatedName("d")
   public class208 method3781() {
      class208 var1;
      if(this.field3103 > 0 && this.field3101 != this.field3100[this.field3103 - 1]) {
         var1 = this.field3101;
         this.field3101 = var1.field3124;
         return var1;
      } else {
         do {
            if(this.field3103 >= this.field3102) {
               return null;
            }

            var1 = this.field3100[this.field3103++].field3124;
         } while(var1 == this.field3100[this.field3103 - 1]);

         this.field3101 = var1.field3124;
         return var1;
      }
   }

   public class196(int var1) {
      this.field3102 = var1;
      this.field3100 = new class208[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class208 var3 = this.field3100[var2] = new class208();
         var3.field3124 = var3;
         var3.field3126 = var3;
      }

   }
}
