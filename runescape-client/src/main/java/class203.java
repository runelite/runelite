import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ge")
public class class203 implements Iterable {
   @ObfuscatedName("f")
   public CacheableNode field3150 = new CacheableNode();

   @ObfuscatedName("e")
   public void method3918(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3968();
      }

      var1.next = this.field3150.next;
      var1.previous = this.field3150;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class209(this);
   }

   @ObfuscatedName("f")
   public void method3921() {
      while(this.field3150.previous != this.field3150) {
         this.field3150.previous.method3968();
      }

   }

   public class203() {
      this.field3150.previous = this.field3150;
      this.field3150.next = this.field3150;
   }
}
