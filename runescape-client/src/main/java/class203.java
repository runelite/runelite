import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gl")
public class class203 implements Iterable {
   @ObfuscatedName("k")
   public CacheableNode field3150 = new CacheableNode();

   public Iterator iterator() {
      return new class209(this);
   }

   @ObfuscatedName("k")
   public void method3873() {
      while(this.field3150.previous != this.field3150) {
         this.field3150.previous.method3932();
      }

   }

   @ObfuscatedName("q")
   public void method3877(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3932();
      }

      var1.next = this.field3150.next;
      var1.previous = this.field3150;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public class203() {
      this.field3150.previous = this.field3150;
      this.field3150.next = this.field3150;
   }
}
