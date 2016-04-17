import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gf")
public class class195 {
   @ObfuscatedName("w")
   @Export("current")
   class207 field3096;
   @ObfuscatedName("a")
   class207 field3097 = new class207();

   public class195() {
      this.field3097.field3122 = this.field3097;
      this.field3097.field3121 = this.field3097;
   }

   @ObfuscatedName("a")
   public void method3862(class207 var1) {
      if(var1.field3121 != null) {
         var1.method3994();
      }

      var1.field3121 = this.field3097.field3121;
      var1.field3122 = this.field3097;
      var1.field3121.field3122 = var1;
      var1.field3122.field3121 = var1;
   }

   @ObfuscatedName("d")
   public class207 method3863() {
      class207 var1 = this.field3096;
      if(var1 == this.field3097) {
         this.field3096 = null;
         return null;
      } else {
         this.field3096 = var1.field3122;
         return var1;
      }
   }

   @ObfuscatedName("w")
   public class207 method3866() {
      class207 var1 = this.field3097.field3122;
      if(var1 == this.field3097) {
         this.field3096 = null;
         return null;
      } else {
         this.field3096 = var1.field3122;
         return var1;
      }
   }
}
