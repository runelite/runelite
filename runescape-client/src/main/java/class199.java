import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gh")
@Implements("Deque")
public class class199 {
   @ObfuscatedName("u")
   @Export("current")
   class208 field3099;
   @ObfuscatedName("f")
   @Export("head")
   public class208 field3100 = new class208();

   @ObfuscatedName("f")
   public void method3849() {
      while(true) {
         class208 var1 = this.field3100.field3116;
         if(var1 == this.field3100) {
            this.field3099 = null;
            return;
         }

         var1.method3946();
      }
   }

   @ObfuscatedName("d")
   public class208 method3850() {
      class208 var1 = this.field3100.field3117;
      if(var1 == this.field3100) {
         return null;
      } else {
         var1.method3946();
         return var1;
      }
   }

   @ObfuscatedName("x")
   public void method3851(class208 var1) {
      if(var1.field3117 != null) {
         var1.method3946();
      }

      var1.field3117 = this.field3100;
      var1.field3116 = this.field3100.field3116;
      var1.field3117.field3116 = var1;
      var1.field3116.field3117 = var1;
   }

   @ObfuscatedName("n")
   public class208 method3852() {
      class208 var1 = this.field3100.field3116;
      if(var1 == this.field3100) {
         this.field3099 = null;
         return null;
      } else {
         this.field3099 = var1.field3116;
         return var1;
      }
   }

   @ObfuscatedName("l")
   public class208 method3853() {
      class208 var1 = this.field3100.field3116;
      if(var1 == this.field3100) {
         return null;
      } else {
         var1.method3946();
         return var1;
      }
   }

   @ObfuscatedName("m")
   public class208 method3856() {
      class208 var1 = this.field3100.field3117;
      if(var1 == this.field3100) {
         this.field3099 = null;
         return null;
      } else {
         this.field3099 = var1.field3117;
         return var1;
      }
   }

   @ObfuscatedName("g")
   public class208 method3857() {
      class208 var1 = this.field3099;
      if(var1 == this.field3100) {
         this.field3099 = null;
         return null;
      } else {
         this.field3099 = var1.field3116;
         return var1;
      }
   }

   @ObfuscatedName("s")
   public class208 method3858() {
      class208 var1 = this.field3099;
      if(var1 == this.field3100) {
         this.field3099 = null;
         return null;
      } else {
         this.field3099 = var1.field3117;
         return var1;
      }
   }

   public class199() {
      this.field3100.field3116 = this.field3100;
      this.field3100.field3117 = this.field3100;
   }

   @ObfuscatedName("b")
   public static void method3872(class208 var0, class208 var1) {
      if(var0.field3117 != null) {
         var0.method3946();
      }

      var0.field3117 = var1.field3117;
      var0.field3116 = var1;
      var0.field3117.field3116 = var0;
      var0.field3116.field3117 = var0;
   }

   @ObfuscatedName("u")
   public void method3877(class208 var1) {
      if(var1.field3117 != null) {
         var1.method3946();
      }

      var1.field3117 = this.field3100.field3117;
      var1.field3116 = this.field3100;
      var1.field3117.field3116 = var1;
      var1.field3116.field3117 = var1;
   }
}
