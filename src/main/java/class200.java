import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
public class class200 implements Iterable {
   @ObfuscatedName("a")
   public class204 field3109 = new class204();

   @ObfuscatedName("w")
   public void method3937(class204 var1) {
      if(var1.field3113 != null) {
         var1.method3979();
      }

      var1.field3113 = this.field3109.field3113;
      var1.field3114 = this.field3109;
      var1.field3113.field3114 = var1;
      var1.field3114.field3113 = var1;
   }

   public Iterator iterator() {
      return new class206(this);
   }

   public class200() {
      this.field3109.field3114 = this.field3109;
      this.field3109.field3113 = this.field3109;
   }

   @ObfuscatedName("a")
   public void method3941() {
      while(this.field3109.field3114 != this.field3109) {
         this.field3109.field3114.method3979();
      }

   }
}
