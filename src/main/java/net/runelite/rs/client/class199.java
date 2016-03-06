import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
public class class199 implements Iterable {
   @ObfuscatedName("j")
   public class203 field3096 = new class203();

   @ObfuscatedName("j")
   public void method3798() {
      while(this.field3096.field3100 != this.field3096) {
         this.field3096.field3100.method3835();
      }

   }

   @ObfuscatedName("l")
   public void method3799(class203 var1) {
      if(var1.field3101 != null) {
         var1.method3835();
      }

      var1.field3101 = this.field3096.field3101;
      var1.field3100 = this.field3096;
      var1.field3101.field3100 = var1;
      var1.field3100.field3101 = var1;
   }

   public class199() {
      this.field3096.field3100 = this.field3096;
      this.field3096.field3101 = this.field3096;
   }

   public Iterator iterator() {
      return new class205(this);
   }
}
