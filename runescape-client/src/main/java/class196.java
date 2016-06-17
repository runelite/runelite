import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gs")
@Implements("XHashTable")
public final class class196 {
   @ObfuscatedName("j")
   class208 field3088;
   @ObfuscatedName("g")
   @Export("buckets")
   class208[] field3089;
   @ObfuscatedName("d")
   class208 field3090;
   @ObfuscatedName("b")
   @Export("size")
   int field3091;
   @ObfuscatedName("x")
   int field3092 = 0;

   @ObfuscatedName("g")
   public void method3797(class208 var1, long var2) {
      if(var1.field3115 != null) {
         var1.method3916();
      }

      class208 var4 = this.field3089[(int)(var2 & (long)(this.field3091 - 1))];
      var1.field3115 = var4.field3115;
      var1.field3114 = var4;
      var1.field3115.field3114 = var1;
      var1.field3114.field3115 = var1;
      var1.field3113 = var2;
   }

   @ObfuscatedName("j")
   void method3798() {
      for(int var1 = 0; var1 < this.field3091; ++var1) {
         class208 var2 = this.field3089[var1];

         while(true) {
            class208 var3 = var2.field3114;
            if(var3 == var2) {
               break;
            }

            var3.method3916();
         }
      }

      this.field3088 = null;
      this.field3090 = null;
   }

   @ObfuscatedName("d")
   public class208 method3799() {
      this.field3092 = 0;
      return this.method3800();
   }

   @ObfuscatedName("x")
   public class208 method3800() {
      class208 var1;
      if(this.field3092 > 0 && this.field3090 != this.field3089[this.field3092 - 1]) {
         var1 = this.field3090;
         this.field3090 = var1.field3114;
         return var1;
      } else {
         do {
            if(this.field3092 >= this.field3091) {
               return null;
            }

            var1 = this.field3089[this.field3092++].field3114;
         } while(var1 == this.field3089[this.field3092 - 1]);

         this.field3090 = var1.field3114;
         return var1;
      }
   }

   public class196(int var1) {
      this.field3091 = var1;
      this.field3089 = new class208[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class208 var3 = this.field3089[var2] = new class208();
         var3.field3114 = var3;
         var3.field3115 = var3;
      }

   }

   @ObfuscatedName("b")
   public class208 method3807(long var1) {
      class208 var3 = this.field3089[(int)(var1 & (long)(this.field3091 - 1))];

      for(this.field3088 = var3.field3114; this.field3088 != var3; this.field3088 = this.field3088.field3114) {
         if(this.field3088.field3113 == var1) {
            class208 var4 = this.field3088;
            this.field3088 = this.field3088.field3114;
            return var4;
         }
      }

      this.field3088 = null;
      return null;
   }
}
