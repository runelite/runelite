import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gs")
@Implements("Deque")
public class class199 {
   @ObfuscatedName("j")
   @Export("current")
   class208 field3108;
   @ObfuscatedName("s")
   @Export("head")
   public class208 field3109 = new class208();

   @ObfuscatedName("s")
   public void method3806() {
      while(true) {
         class208 var1 = this.field3109.field3124;
         if(var1 == this.field3109) {
            this.field3108 = null;
            return;
         }

         var1.method3898();
      }
   }

   @ObfuscatedName("j")
   public void method3807(class208 var1) {
      if(var1.field3126 != null) {
         var1.method3898();
      }

      var1.field3126 = this.field3109.field3126;
      var1.field3124 = this.field3109;
      var1.field3126.field3124 = var1;
      var1.field3124.field3126 = var1;
   }

   @ObfuscatedName("p")
   public void method3808(class208 var1) {
      if(var1.field3126 != null) {
         var1.method3898();
      }

      var1.field3126 = this.field3109;
      var1.field3124 = this.field3109.field3124;
      var1.field3126.field3124 = var1;
      var1.field3124.field3126 = var1;
   }

   @ObfuscatedName("x")
   public static void method3809(class208 var0, class208 var1) {
      if(var0.field3126 != null) {
         var0.method3898();
      }

      var0.field3126 = var1.field3126;
      var0.field3124 = var1;
      var0.field3126.field3124 = var0;
      var0.field3124.field3126 = var0;
   }

   @ObfuscatedName("d")
   public class208 method3810() {
      class208 var1 = this.field3109.field3124;
      if(var1 == this.field3109) {
         return null;
      } else {
         var1.method3898();
         return var1;
      }
   }

   @ObfuscatedName("o")
   public class208 method3812() {
      class208 var1 = this.field3109.field3124;
      if(var1 == this.field3109) {
         this.field3108 = null;
         return null;
      } else {
         this.field3108 = var1.field3124;
         return var1;
      }
   }

   public class199() {
      this.field3109.field3124 = this.field3109;
      this.field3109.field3126 = this.field3109;
   }

   @ObfuscatedName("u")
   public class208 method3813() {
      class208 var1 = this.field3109.field3126;
      if(var1 == this.field3109) {
         return null;
      } else {
         var1.method3898();
         return var1;
      }
   }

   @ObfuscatedName("c")
   public class208 method3814() {
      class208 var1 = this.field3108;
      if(var1 == this.field3109) {
         this.field3108 = null;
         return null;
      } else {
         this.field3108 = var1.field3126;
         return var1;
      }
   }

   @ObfuscatedName("k")
   public class208 method3817() {
      class208 var1 = this.field3108;
      if(var1 == this.field3109) {
         this.field3108 = null;
         return null;
      } else {
         this.field3108 = var1.field3124;
         return var1;
      }
   }

   @ObfuscatedName("b")
   public class208 method3831() {
      class208 var1 = this.field3109.field3126;
      if(var1 == this.field3109) {
         this.field3108 = null;
         return null;
      } else {
         this.field3108 = var1.field3126;
         return var1;
      }
   }
}
