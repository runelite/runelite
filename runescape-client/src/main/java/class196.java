import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gc")
@Implements("XHashTable")
public final class class196 {
   @ObfuscatedName("m")
   class208 field3097;
   @ObfuscatedName("h")
   class208[] field3098;
   @ObfuscatedName("j")
   int field3099;
   @ObfuscatedName("z")
   class208 field3100;
   @ObfuscatedName("x")
   int field3101 = 0;

   @ObfuscatedName("j")
   public class208 method3742(long var1) {
      class208 var3 = this.field3098[(int)(var1 & (long)(this.field3099 - 1))];

      for(this.field3097 = var3.field3123; this.field3097 != var3; this.field3097 = this.field3097.field3123) {
         if(this.field3097.field3122 == var1) {
            class208 var4 = this.field3097;
            this.field3097 = this.field3097.field3123;
            return var4;
         }
      }

      this.field3097 = null;
      return null;
   }

   @ObfuscatedName("h")
   public void method3743(class208 var1, long var2) {
      if(var1.field3124 != null) {
         var1.method3883();
      }

      class208 var4 = this.field3098[(int)(var2 & (long)(this.field3099 - 1))];
      var1.field3124 = var4.field3124;
      var1.field3123 = var4;
      var1.field3124.field3123 = var1;
      var1.field3123.field3124 = var1;
      var1.field3122 = var2;
   }

   @ObfuscatedName("m")
   void method3744() {
      for(int var1 = 0; var1 < this.field3099; ++var1) {
         class208 var2 = this.field3098[var1];

         while(true) {
            class208 var3 = var2.field3123;
            if(var3 == var2) {
               break;
            }

            var3.method3883();
         }
      }

      this.field3097 = null;
      this.field3100 = null;
   }

   @ObfuscatedName("z")
   public class208 method3745() {
      this.field3101 = 0;
      return this.method3746();
   }

   @ObfuscatedName("x")
   public class208 method3746() {
      class208 var1;
      if(this.field3101 > 0 && this.field3100 != this.field3098[this.field3101 - 1]) {
         var1 = this.field3100;
         this.field3100 = var1.field3123;
         return var1;
      } else {
         do {
            if(this.field3101 >= this.field3099) {
               return null;
            }

            var1 = this.field3098[this.field3101++].field3123;
         } while(var1 == this.field3098[this.field3101 - 1]);

         this.field3100 = var1.field3123;
         return var1;
      }
   }

   public class196(int var1) {
      this.field3099 = var1;
      this.field3098 = new class208[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class208 var3 = this.field3098[var2] = new class208();
         var3.field3123 = var3;
         var3.field3124 = var3;
      }

   }
}
