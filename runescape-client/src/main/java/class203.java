import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gw")
public class class203 implements Iterable {
   @ObfuscatedName("s")
   public CacheableNode field3150 = new CacheableNode();

   @ObfuscatedName("s")
   public void method3839() {
      while(this.field3150.previous != this.field3150) {
         this.field3150.previous.method3894();
      }

   }

   @ObfuscatedName("z")
   public void method3840(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3894();
      }

      var1.next = this.field3150.next;
      var1.previous = this.field3150;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class209(this);
   }

   public class203() {
      this.field3150.previous = this.field3150;
      this.field3150.next = this.field3150;
   }
}
