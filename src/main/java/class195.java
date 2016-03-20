import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("go")
@Implements("XHashTable")
public final class class195 {
   @ObfuscatedName("r")
   class207[] field3084;
   @ObfuscatedName("a")
   int field3085;
   @ObfuscatedName("f")
   class207 field3086;
   @ObfuscatedName("s")
   class207 field3087;
   @ObfuscatedName("y")
   int field3088 = 0;

   @ObfuscatedName("f")
   void method3823() {
      for(int var1 = 0; var1 < this.field3085; ++var1) {
         class207 var2 = this.field3084[var1];

         while(true) {
            class207 var3 = var2.field3110;
            if(var3 == var2) {
               break;
            }

            var3.method3946();
         }
      }

      this.field3086 = null;
      this.field3087 = null;
   }

   @ObfuscatedName("a")
   public class207 method3824(long var1) {
      class207 var3 = this.field3084[(int)(var1 & (long)(this.field3085 - 1))];

      for(this.field3086 = var3.field3110; this.field3086 != var3; this.field3086 = this.field3086.field3110) {
         if(this.field3086.field3111 == var1) {
            class207 var4 = this.field3086;
            this.field3086 = this.field3086.field3110;
            return var4;
         }
      }

      this.field3086 = null;
      return null;
   }

   public class195(int var1) {
      this.field3085 = var1;
      this.field3084 = new class207[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class207 var3 = this.field3084[var2] = new class207();
         var3.field3110 = var3;
         var3.field3109 = var3;
      }

   }

   @ObfuscatedName("y")
   public class207 method3827() {
      class207 var1;
      if(this.field3088 > 0 && this.field3087 != this.field3084[this.field3088 - 1]) {
         var1 = this.field3087;
         this.field3087 = var1.field3110;
         return var1;
      } else {
         do {
            if(this.field3088 >= this.field3085) {
               return null;
            }

            var1 = this.field3084[this.field3088++].field3110;
         } while(var1 == this.field3084[this.field3088 - 1]);

         this.field3087 = var1.field3110;
         return var1;
      }
   }

   @ObfuscatedName("r")
   public void method3831(class207 var1, long var2) {
      if(var1.field3109 != null) {
         var1.method3946();
      }

      class207 var4 = this.field3084[(int)(var2 & (long)(this.field3085 - 1))];
      var1.field3109 = var4.field3109;
      var1.field3110 = var4;
      var1.field3109.field3110 = var1;
      var1.field3110.field3109 = var1;
      var1.field3111 = var2;
   }

   @ObfuscatedName("s")
   public class207 method3836() {
      this.field3088 = 0;
      return this.method3827();
   }
}
