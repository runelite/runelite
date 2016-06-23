import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gg")
@Implements("XHashTable")
public final class class196 {
   @ObfuscatedName("x")
   class208 field3090;
   @ObfuscatedName("u")
   @Export("buckets")
   class208[] field3091;
   @ObfuscatedName("b")
   class208 field3092;
   @ObfuscatedName("l")
   int field3093 = 0;
   @ObfuscatedName("f")
   @Export("size")
   int field3094;

   @ObfuscatedName("f")
   public class208 method3822(long var1) {
      class208 var3 = this.field3091[(int)(var1 & (long)(this.field3094 - 1))];

      for(this.field3090 = var3.field3116; this.field3090 != var3; this.field3090 = this.field3090.field3116) {
         if(this.field3090.field3115 == var1) {
            class208 var4 = this.field3090;
            this.field3090 = this.field3090.field3116;
            return var4;
         }
      }

      this.field3090 = null;
      return null;
   }

   @ObfuscatedName("l")
   public class208 method3823() {
      class208 var1;
      if(this.field3093 > 0 && this.field3092 != this.field3091[this.field3093 - 1]) {
         var1 = this.field3092;
         this.field3092 = var1.field3116;
         return var1;
      } else {
         do {
            if(this.field3093 >= this.field3094) {
               return null;
            }

            var1 = this.field3091[this.field3093++].field3116;
         } while(var1 == this.field3091[this.field3093 - 1]);

         this.field3092 = var1.field3116;
         return var1;
      }
   }

   @ObfuscatedName("x")
   void method3824() {
      for(int var1 = 0; var1 < this.field3094; ++var1) {
         class208 var2 = this.field3091[var1];

         while(true) {
            class208 var3 = var2.field3116;
            if(var3 == var2) {
               break;
            }

            var3.method3946();
         }
      }

      this.field3090 = null;
      this.field3092 = null;
   }

   @ObfuscatedName("b")
   public class208 method3825() {
      this.field3093 = 0;
      return this.method3823();
   }

   @ObfuscatedName("u")
   public void method3826(class208 var1, long var2) {
      if(var1.field3117 != null) {
         var1.method3946();
      }

      class208 var4 = this.field3091[(int)(var2 & (long)(this.field3094 - 1))];
      var1.field3117 = var4.field3117;
      var1.field3116 = var4;
      var1.field3117.field3116 = var1;
      var1.field3116.field3117 = var1;
      var1.field3115 = var2;
   }

   public class196(int var1) {
      this.field3094 = var1;
      this.field3091 = new class208[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class208 var3 = this.field3091[var2] = new class208();
         var3.field3116 = var3;
         var3.field3117 = var3;
      }

   }
}
