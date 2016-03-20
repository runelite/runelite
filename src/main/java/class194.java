import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gj")
public class class194 {
   @ObfuscatedName("r")
   class206 field3082;
   @ObfuscatedName("a")
   class206 field3083 = new class206();

   @ObfuscatedName("a")
   public void method3816(class206 var1) {
      if(var1.field3107 != null) {
         var1.method3940();
      }

      var1.field3107 = this.field3083.field3107;
      var1.field3108 = this.field3083;
      var1.field3107.field3108 = var1;
      var1.field3108.field3107 = var1;
   }

   @ObfuscatedName("r")
   public class206 method3817() {
      class206 var1 = this.field3083.field3108;
      if(var1 == this.field3083) {
         this.field3082 = null;
         return null;
      } else {
         this.field3082 = var1.field3108;
         return var1;
      }
   }

   @ObfuscatedName("f")
   public class206 method3818() {
      class206 var1 = this.field3082;
      if(var1 == this.field3083) {
         this.field3082 = null;
         return null;
      } else {
         this.field3082 = var1.field3108;
         return var1;
      }
   }

   public class194() {
      this.field3083.field3108 = this.field3083;
      this.field3083.field3107 = this.field3083;
   }
}
