import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gx")
public class class202 implements Iterable {
   @ObfuscatedName("w")
   class208 field3111 = new class208();

   @ObfuscatedName("t")
   class208 method3876(class208 var1) {
      class208 var2;
      if(var1 == null) {
         var2 = this.field3111.field3124;
      } else {
         var2 = var1;
      }

      return var2 == this.field3111?null:var2;
   }

   @ObfuscatedName("w")
   public void method3877(class208 var1) {
      if(var1.field3125 != null) {
         var1.method3935();
      }

      var1.field3125 = this.field3111.field3125;
      var1.field3124 = this.field3111;
      var1.field3125.field3124 = var1;
      var1.field3124.field3125 = var1;
   }

   @ObfuscatedName("x")
   public class208 method3879() {
      return this.method3876((class208)null);
   }

   public class202() {
      this.field3111.field3124 = this.field3111;
      this.field3111.field3125 = this.field3111;
   }

   public Iterator iterator() {
      return new class205(this);
   }
}
