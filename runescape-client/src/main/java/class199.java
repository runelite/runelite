import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gk")
@Implements("Deque")
public class class199 {
   @ObfuscatedName("h")
   @Export("current")
   class208 field3106;
   @ObfuscatedName("j")
   @Export("head")
   public class208 field3107 = new class208();

   @ObfuscatedName("n")
   public class208 method3777() {
      class208 var1 = this.field3106;
      if(var1 == this.field3107) {
         this.field3106 = null;
         return null;
      } else {
         this.field3106 = var1.field3123;
         return var1;
      }
   }

   @ObfuscatedName("e")
   public class208 method3778() {
      class208 var1 = this.field3107.field3124;
      if(var1 == this.field3107) {
         return null;
      } else {
         var1.method3883();
         return var1;
      }
   }

   @ObfuscatedName("h")
   public void method3779(class208 var1) {
      if(var1.field3124 != null) {
         var1.method3883();
      }

      var1.field3124 = this.field3107.field3124;
      var1.field3123 = this.field3107;
      var1.field3124.field3123 = var1;
      var1.field3123.field3124 = var1;
   }

   @ObfuscatedName("m")
   public void method3780(class208 var1) {
      if(var1.field3124 != null) {
         var1.method3883();
      }

      var1.field3124 = this.field3107;
      var1.field3123 = this.field3107.field3123;
      var1.field3124.field3123 = var1;
      var1.field3123.field3124 = var1;
   }

   @ObfuscatedName("z")
   public static void method3781(class208 var0, class208 var1) {
      if(var0.field3124 != null) {
         var0.method3883();
      }

      var0.field3124 = var1.field3124;
      var0.field3123 = var1;
      var0.field3124.field3123 = var0;
      var0.field3123.field3124 = var0;
   }

   @ObfuscatedName("x")
   public class208 method3782() {
      class208 var1 = this.field3107.field3123;
      if(var1 == this.field3107) {
         return null;
      } else {
         var1.method3883();
         return var1;
      }
   }

   @ObfuscatedName("i")
   public class208 method3784() {
      class208 var1 = this.field3107.field3123;
      if(var1 == this.field3107) {
         this.field3106 = null;
         return null;
      } else {
         this.field3106 = var1.field3123;
         return var1;
      }
   }

   @ObfuscatedName("c")
   public class208 method3785() {
      class208 var1 = this.field3107.field3124;
      if(var1 == this.field3107) {
         this.field3106 = null;
         return null;
      } else {
         this.field3106 = var1.field3124;
         return var1;
      }
   }

   @ObfuscatedName("l")
   public class208 method3787() {
      class208 var1 = this.field3106;
      if(var1 == this.field3107) {
         this.field3106 = null;
         return null;
      } else {
         this.field3106 = var1.field3124;
         return var1;
      }
   }

   public class199() {
      this.field3107.field3123 = this.field3107;
      this.field3107.field3124 = this.field3107;
   }

   @ObfuscatedName("j")
   public void method3789() {
      while(true) {
         class208 var1 = this.field3107.field3123;
         if(var1 == this.field3107) {
            this.field3106 = null;
            return;
         }

         var1.method3883();
      }
   }
}
