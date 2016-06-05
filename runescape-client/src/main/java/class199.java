import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gr")
@Implements("Deque")
public class class199 {
   @ObfuscatedName("t")
   @Export("head")
   public class208 field3108 = new class208();
   @ObfuscatedName("i")
   @Export("current")
   class208 field3109;

   @ObfuscatedName("i")
   public void method3771(class208 var1) {
      if(var1.field3124 != null) {
         var1.method3870();
      }

      var1.field3124 = this.field3108.field3124;
      var1.field3126 = this.field3108;
      var1.field3124.field3126 = var1;
      var1.field3126.field3124 = var1;
   }

   @ObfuscatedName("t")
   public void method3772() {
      while(true) {
         class208 var1 = this.field3108.field3126;
         if(var1 == this.field3108) {
            this.field3109 = null;
            return;
         }

         var1.method3870();
      }
   }

   public class199() {
      this.field3108.field3126 = this.field3108;
      this.field3108.field3124 = this.field3108;
   }

   @ObfuscatedName("r")
   public class208 method3776() {
      class208 var1 = this.field3108.field3124;
      if(var1 == this.field3108) {
         return null;
      } else {
         var1.method3870();
         return var1;
      }
   }

   @ObfuscatedName("s")
   public class208 method3777() {
      class208 var1 = this.field3108.field3124;
      if(var1 == this.field3108) {
         this.field3109 = null;
         return null;
      } else {
         this.field3109 = var1.field3124;
         return var1;
      }
   }

   @ObfuscatedName("d")
   public class208 method3779() {
      class208 var1 = this.field3109;
      if(var1 == this.field3108) {
         this.field3109 = null;
         return null;
      } else {
         this.field3109 = var1.field3126;
         return var1;
      }
   }

   @ObfuscatedName("l")
   public class208 method3780() {
      class208 var1 = this.field3109;
      if(var1 == this.field3108) {
         this.field3109 = null;
         return null;
      } else {
         this.field3109 = var1.field3124;
         return var1;
      }
   }

   @ObfuscatedName("h")
   public static void method3785(class208 var0, class208 var1) {
      if(var0.field3124 != null) {
         var0.method3870();
      }

      var0.field3124 = var1.field3124;
      var0.field3126 = var1;
      var0.field3124.field3126 = var0;
      var0.field3126.field3124 = var0;
   }

   @ObfuscatedName("g")
   public void method3788(class208 var1) {
      if(var1.field3124 != null) {
         var1.method3870();
      }

      var1.field3124 = this.field3108;
      var1.field3126 = this.field3108.field3126;
      var1.field3124.field3126 = var1;
      var1.field3126.field3124 = var1;
   }

   @ObfuscatedName("z")
   public class208 method3789() {
      class208 var1 = this.field3108.field3126;
      if(var1 == this.field3108) {
         return null;
      } else {
         var1.method3870();
         return var1;
      }
   }

   @ObfuscatedName("f")
   public class208 method3797() {
      class208 var1 = this.field3108.field3126;
      if(var1 == this.field3108) {
         this.field3109 = null;
         return null;
      } else {
         this.field3109 = var1.field3126;
         return var1;
      }
   }
}
