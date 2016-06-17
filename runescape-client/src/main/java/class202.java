import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gv")
public class class202 implements Iterable {
   @ObfuscatedName("b")
   class208 field3101 = new class208();

   @ObfuscatedName("b")
   public void method3863(class208 var1) {
      if(var1.field3115 != null) {
         var1.method3916();
      }

      var1.field3115 = this.field3101.field3115;
      var1.field3114 = this.field3101;
      var1.field3115.field3114 = var1;
      var1.field3114.field3115 = var1;
   }

   @ObfuscatedName("g")
   public class208 method3864() {
      return this.method3868((class208)null);
   }

   public class202() {
      this.field3101.field3114 = this.field3101;
      this.field3101.field3115 = this.field3101;
   }

   public Iterator iterator() {
      return new class205(this);
   }

   @ObfuscatedName("j")
   class208 method3868(class208 var1) {
      class208 var2;
      if(var1 == null) {
         var2 = this.field3101.field3114;
      } else {
         var2 = var1;
      }

      return var2 == this.field3101?null:var2;
   }
}
