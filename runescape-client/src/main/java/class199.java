import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ge")
@Implements("XHashTable")
public final class class199 {
   @ObfuscatedName("h")
   class211 field3135;
   @ObfuscatedName("l")
   @Export("buckets")
   class211[] field3136;
   @ObfuscatedName("e")
   @Export("size")
   int field3137;
   @ObfuscatedName("c")
   class211 field3138;
   @ObfuscatedName("r")
   int field3139 = 0;

   @ObfuscatedName("e")
   public class211 method3864(long var1) {
      class211 var3 = this.field3136[(int)(var1 & (long)(this.field3137 - 1))];

      for(this.field3138 = var3.field3162; this.field3138 != var3; this.field3138 = this.field3138.field3162) {
         if(this.field3138.field3161 == var1) {
            class211 var4 = this.field3138;
            this.field3138 = this.field3138.field3162;
            return var4;
         }
      }

      this.field3138 = null;
      return null;
   }

   @ObfuscatedName("l")
   public void method3865(class211 var1, long var2) {
      if(var1.field3163 != null) {
         var1.method4000();
      }

      class211 var4 = this.field3136[(int)(var2 & (long)(this.field3137 - 1))];
      var1.field3163 = var4.field3163;
      var1.field3162 = var4;
      var1.field3163.field3162 = var1;
      var1.field3162.field3163 = var1;
      var1.field3161 = var2;
   }

   @ObfuscatedName("h")
   public class211 method3867() {
      this.field3139 = 0;
      return this.method3868();
   }

   @ObfuscatedName("r")
   public class211 method3868() {
      class211 var1;
      if(this.field3139 > 0 && this.field3135 != this.field3136[this.field3139 - 1]) {
         var1 = this.field3135;
         this.field3135 = var1.field3162;
         return var1;
      } else {
         do {
            if(this.field3139 >= this.field3137) {
               return null;
            }

            var1 = this.field3136[this.field3139++].field3162;
         } while(var1 == this.field3136[this.field3139 - 1]);

         this.field3135 = var1.field3162;
         return var1;
      }
   }

   public class199(int var1) {
      this.field3137 = var1;
      this.field3136 = new class211[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class211 var3 = this.field3136[var2] = new class211();
         var3.field3162 = var3;
         var3.field3163 = var3;
      }

   }

   @ObfuscatedName("c")
   void method3877() {
      for(int var1 = 0; var1 < this.field3137; ++var1) {
         class211 var2 = this.field3136[var1];

         while(true) {
            class211 var3 = var2.field3162;
            if(var3 == var2) {
               break;
            }

            var3.method4000();
         }
      }

      this.field3138 = null;
      this.field3135 = null;
   }
}
