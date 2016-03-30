import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ga")
@Implements("Deque")
public class class199 {
   @ObfuscatedName("x")
   @Export("current")
   class208 field3107;
   @ObfuscatedName("w")
   @Export("head")
   public class208 field3108 = new class208();

   @ObfuscatedName("w")
   public void method3833() {
      while(true) {
         class208 var1 = this.field3108.field3124;
         if(var1 == this.field3108) {
            this.field3107 = null;
            return;
         }

         var1.method3935();
      }
   }

   @ObfuscatedName("x")
   public void method3834(class208 var1) {
      if(var1.field3125 != null) {
         var1.method3935();
      }

      var1.field3125 = this.field3108.field3125;
      var1.field3124 = this.field3108;
      var1.field3125.field3124 = var1;
      var1.field3124.field3125 = var1;
   }

   @ObfuscatedName("t")
   public void method3835(class208 var1) {
      if(var1.field3125 != null) {
         var1.method3935();
      }

      var1.field3125 = this.field3108;
      var1.field3124 = this.field3108.field3124;
      var1.field3125.field3124 = var1;
      var1.field3124.field3125 = var1;
   }

   @ObfuscatedName("m")
   public class208 method3836() {
      class208 var1 = this.field3108.field3124;
      if(var1 == this.field3108) {
         this.field3107 = null;
         return null;
      } else {
         this.field3107 = var1.field3124;
         return var1;
      }
   }

   @ObfuscatedName("e")
   public class208 method3837() {
      class208 var1 = this.field3108.field3124;
      if(var1 == this.field3108) {
         return null;
      } else {
         var1.method3935();
         return var1;
      }
   }

   @ObfuscatedName("y")
   public class208 method3839() {
      class208 var1 = this.field3108.field3125;
      if(var1 == this.field3108) {
         return null;
      } else {
         var1.method3935();
         return var1;
      }
   }

   @ObfuscatedName("c")
   public class208 method3840() {
      class208 var1 = this.field3108.field3125;
      if(var1 == this.field3108) {
         this.field3107 = null;
         return null;
      } else {
         this.field3107 = var1.field3125;
         return var1;
      }
   }

   @ObfuscatedName("v")
   public class208 method3841() {
      class208 var1 = this.field3107;
      if(var1 == this.field3108) {
         this.field3107 = null;
         return null;
      } else {
         this.field3107 = var1.field3124;
         return var1;
      }
   }

   @ObfuscatedName("l")
   public class208 method3842() {
      class208 var1 = this.field3107;
      if(var1 == this.field3108) {
         this.field3107 = null;
         return null;
      } else {
         this.field3107 = var1.field3125;
         return var1;
      }
   }

   public class199() {
      this.field3108.field3124 = this.field3108;
      this.field3108.field3125 = this.field3108;
   }

   @ObfuscatedName("p")
   public static void method3859(class208 var0, class208 var1) {
      if(var0.field3125 != null) {
         var0.method3935();
      }

      var0.field3125 = var1.field3125;
      var0.field3124 = var1;
      var0.field3125.field3124 = var0;
      var0.field3124.field3125 = var0;
   }
}
