import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gh")
@Implements("Deque")
public class class202 {
   @ObfuscatedName("w")
   @Export("current")
   class211 field3149;
   @ObfuscatedName("m")
   @Export("head")
   public class211 field3150 = new class211();

   @ObfuscatedName("w")
   public void method3877(class211 var1) {
      if(var1.field3166 != null) {
         var1.method3990();
      }

      var1.field3166 = this.field3150.field3166;
      var1.field3168 = this.field3150;
      var1.field3166.field3168 = var1;
      var1.field3168.field3166 = var1;
   }

   @ObfuscatedName("e")
   public void method3878(class211 var1) {
      if(var1.field3166 != null) {
         var1.method3990();
      }

      var1.field3166 = this.field3150;
      var1.field3168 = this.field3150.field3168;
      var1.field3166.field3168 = var1;
      var1.field3168.field3166 = var1;
   }

   @ObfuscatedName("o")
   public static void method3879(class211 var0, class211 var1) {
      if(var0.field3166 != null) {
         var0.method3990();
      }

      var0.field3166 = var1.field3166;
      var0.field3168 = var1;
      var0.field3166.field3168 = var0;
      var0.field3168.field3166 = var0;
   }

   @ObfuscatedName("g")
   public class211 method3880() {
      class211 var1 = this.field3150.field3168;
      if(var1 == this.field3150) {
         return null;
      } else {
         var1.method3990();
         return var1;
      }
   }

   @ObfuscatedName("l")
   public class211 method3881() {
      class211 var1 = this.field3150.field3166;
      if(var1 == this.field3150) {
         return null;
      } else {
         var1.method3990();
         return var1;
      }
   }

   @ObfuscatedName("j")
   public class211 method3882() {
      class211 var1 = this.field3150.field3168;
      if(var1 == this.field3150) {
         this.field3149 = null;
         return null;
      } else {
         this.field3149 = var1.field3168;
         return var1;
      }
   }

   @ObfuscatedName("r")
   public class211 method3883() {
      class211 var1 = this.field3150.field3166;
      if(var1 == this.field3150) {
         this.field3149 = null;
         return null;
      } else {
         this.field3149 = var1.field3166;
         return var1;
      }
   }

   public class202() {
      this.field3150.field3168 = this.field3150;
      this.field3150.field3166 = this.field3150;
   }

   @ObfuscatedName("x")
   public class211 method3891() {
      class211 var1 = this.field3149;
      if(var1 == this.field3150) {
         this.field3149 = null;
         return null;
      } else {
         this.field3149 = var1.field3168;
         return var1;
      }
   }

   @ObfuscatedName("m")
   public void method3893() {
      while(true) {
         class211 var1 = this.field3150.field3168;
         if(var1 == this.field3150) {
            this.field3149 = null;
            return;
         }

         var1.method3990();
      }
   }

   @ObfuscatedName("k")
   public class211 method3898() {
      class211 var1 = this.field3149;
      if(var1 == this.field3150) {
         this.field3149 = null;
         return null;
      } else {
         this.field3149 = var1.field3166;
         return var1;
      }
   }
}
