import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gl")
@Implements("Deque")
public class class199 {
   @ObfuscatedName("w")
   class208 field3107;
   @ObfuscatedName("a")
   @Export("head")
   public class208 field3108 = new class208();

   @ObfuscatedName("a")
   public void method3898() {
      while(true) {
         class208 var1 = this.field3108.field3124;
         if(var1 == this.field3108) {
            this.field3107 = null;
            return;
         }

         var1.method3998();
      }
   }

   @ObfuscatedName("w")
   public void method3900(class208 var1) {
      if(var1.field3123 != null) {
         var1.method3998();
      }

      var1.field3123 = this.field3108.field3123;
      var1.field3124 = this.field3108;
      var1.field3123.field3124 = var1;
      var1.field3124.field3123 = var1;
   }

   @ObfuscatedName("d")
   public void method3901(class208 var1) {
      if(var1.field3123 != null) {
         var1.method3998();
      }

      var1.field3123 = this.field3108;
      var1.field3124 = this.field3108.field3124;
      var1.field3123.field3124 = var1;
      var1.field3124.field3123 = var1;
   }

   @ObfuscatedName("q")
   public class208 method3902() {
      class208 var1 = this.field3107;
      if(var1 == this.field3108) {
         this.field3107 = null;
         return null;
      } else {
         this.field3107 = var1.field3124;
         return var1;
      }
   }

   @ObfuscatedName("y")
   public class208 method3903() {
      class208 var1 = this.field3108.field3124;
      if(var1 == this.field3108) {
         return null;
      } else {
         var1.method3998();
         return var1;
      }
   }

   @ObfuscatedName("p")
   public class208 method3906() {
      class208 var1 = this.field3108.field3123;
      if(var1 == this.field3108) {
         this.field3107 = null;
         return null;
      } else {
         this.field3107 = var1.field3123;
         return var1;
      }
   }

   @ObfuscatedName("k")
   public class208 method3908() {
      class208 var1 = this.field3108.field3123;
      if(var1 == this.field3108) {
         return null;
      } else {
         var1.method3998();
         return var1;
      }
   }

   @ObfuscatedName("m")
   public class208 method3919() {
      class208 var1 = this.field3107;
      if(var1 == this.field3108) {
         this.field3107 = null;
         return null;
      } else {
         this.field3107 = var1.field3123;
         return var1;
      }
   }

   public class199() {
      this.field3108.field3124 = this.field3108;
      this.field3108.field3123 = this.field3108;
   }

   @ObfuscatedName("r")
   public class208 method3926() {
      class208 var1 = this.field3108.field3124;
      if(var1 == this.field3108) {
         this.field3107 = null;
         return null;
      } else {
         this.field3107 = var1.field3124;
         return var1;
      }
   }

   @ObfuscatedName("c")
   public static void method3933(class208 var0, class208 var1) {
      if(var0.field3123 != null) {
         var0.method3998();
      }

      var0.field3123 = var1.field3123;
      var0.field3124 = var1;
      var0.field3123.field3124 = var0;
      var0.field3124.field3123 = var0;
   }
}
