import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gd")
@Implements("Deque")
public class class198 {
   @ObfuscatedName("r")
   @Export("current")
   class207 field3093;
   @ObfuscatedName("a")
   @Export("head")
   public class207 field3094 = new class207();

   @ObfuscatedName("a")
   public void method3854() {
      while(true) {
         class207 var1 = this.field3094.field3110;
         if(var1 == this.field3094) {
            this.field3093 = null;
            return;
         }

         var1.method3946();
      }
   }

   @ObfuscatedName("r")
   public void method3855(class207 var1) {
      if(var1.field3109 != null) {
         var1.method3946();
      }

      var1.field3109 = this.field3094.field3109;
      var1.field3110 = this.field3094;
      var1.field3109.field3110 = var1;
      var1.field3110.field3109 = var1;
   }

   @ObfuscatedName("f")
   public void method3856(class207 var1) {
      if(var1.field3109 != null) {
         var1.method3946();
      }

      var1.field3109 = this.field3094;
      var1.field3110 = this.field3094.field3110;
      var1.field3109.field3110 = var1;
      var1.field3110.field3109 = var1;
   }

   @ObfuscatedName("e")
   public class207 method3859() {
      class207 var1 = this.field3094.field3109;
      if(var1 == this.field3094) {
         return null;
      } else {
         var1.method3946();
         return var1;
      }
   }

   @ObfuscatedName("g")
   public class207 method3860() {
      class207 var1 = this.field3094.field3110;
      if(var1 == this.field3094) {
         this.field3093 = null;
         return null;
      } else {
         this.field3093 = var1.field3110;
         return var1;
      }
   }

   @ObfuscatedName("j")
   public class207 method3861() {
      class207 var1 = this.field3093;
      if(var1 == this.field3094) {
         this.field3093 = null;
         return null;
      } else {
         this.field3093 = var1.field3110;
         return var1;
      }
   }

   @ObfuscatedName("n")
   public class207 method3863() {
      class207 var1 = this.field3093;
      if(var1 == this.field3094) {
         this.field3093 = null;
         return null;
      } else {
         this.field3093 = var1.field3109;
         return var1;
      }
   }

   @ObfuscatedName("y")
   public class207 method3866() {
      class207 var1 = this.field3094.field3110;
      if(var1 == this.field3094) {
         return null;
      } else {
         var1.method3946();
         return var1;
      }
   }

   @ObfuscatedName("m")
   public class207 method3872() {
      class207 var1 = this.field3094.field3109;
      if(var1 == this.field3094) {
         this.field3093 = null;
         return null;
      } else {
         this.field3093 = var1.field3109;
         return var1;
      }
   }

   @ObfuscatedName("s")
   public static void method3875(class207 var0, class207 var1) {
      if(var0.field3109 != null) {
         var0.method3946();
      }

      var0.field3109 = var1.field3109;
      var0.field3110 = var1;
      var0.field3109.field3110 = var0;
      var0.field3110.field3109 = var0;
   }

   public class198() {
      this.field3094.field3110 = this.field3094;
      this.field3094.field3109 = this.field3094;
   }
}
