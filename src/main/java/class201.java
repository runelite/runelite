import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ga")
public class class201 implements Iterable {
   @ObfuscatedName("a")
   class207 field3097 = new class207();

   @ObfuscatedName("r")
   public class207 method3893() {
      return this.method3902((class207)null);
   }

   public Iterator iterator() {
      return new class204(this);
   }

   @ObfuscatedName("a")
   public void method3895(class207 var1) {
      if(var1.field3109 != null) {
         var1.method3946();
      }

      var1.field3109 = this.field3097.field3109;
      var1.field3110 = this.field3097;
      var1.field3109.field3110 = var1;
      var1.field3110.field3109 = var1;
   }

   @ObfuscatedName("f")
   class207 method3902(class207 var1) {
      class207 var2;
      if(var1 == null) {
         var2 = this.field3097.field3110;
      } else {
         var2 = var1;
      }

      return var2 == this.field3097?null:var2;
   }

   public class201() {
      this.field3097.field3110 = this.field3097;
      this.field3097.field3109 = this.field3097;
   }
}
