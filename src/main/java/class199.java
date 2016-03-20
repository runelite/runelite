import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gf")
public class class199 implements Iterable {
   @ObfuscatedName("a")
   public class203 field3095 = new class203();

   @ObfuscatedName("r")
   public void method3882(class203 var1) {
      if(var1.field3099 != null) {
         var1.method3920();
      }

      var1.field3099 = this.field3095.field3099;
      var1.field3100 = this.field3095;
      var1.field3099.field3100 = var1;
      var1.field3100.field3099 = var1;
   }

   @ObfuscatedName("a")
   public void method3883() {
      while(this.field3095.field3100 != this.field3095) {
         this.field3095.field3100.method3920();
      }

   }

   public Iterator iterator() {
      return new class205(this);
   }

   public class199() {
      this.field3095.field3100 = this.field3095;
      this.field3095.field3099 = this.field3095;
   }
}
