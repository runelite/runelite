import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
public class class200 implements Iterable {
   @ObfuscatedName("f")
   public class204 field3101 = new class204();

   @ObfuscatedName("f")
   public void method3886() {
      while(this.field3101.field3105 != this.field3101) {
         this.field3101.field3105.method3922();
      }

   }

   @ObfuscatedName("u")
   public void method3887(class204 var1) {
      if(var1.field3106 != null) {
         var1.method3922();
      }

      var1.field3106 = this.field3101.field3106;
      var1.field3105 = this.field3101;
      var1.field3106.field3105 = var1;
      var1.field3105.field3106 = var1;
   }

   public Iterator iterator() {
      return new class206(this);
   }

   public class200() {
      this.field3101.field3105 = this.field3101;
      this.field3101.field3106 = this.field3101;
   }
}
