import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gv")
public class class203 implements Iterable {
   @ObfuscatedName("x")
   public CacheableNode field3157 = new CacheableNode();

   @ObfuscatedName("x")
   public void method3873() {
      while(this.field3157.previous != this.field3157) {
         this.field3157.previous.method3925();
      }

   }

   public Iterator iterator() {
      return new class209(this);
   }

   @ObfuscatedName("r")
   public void method3877(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3925();
      }

      var1.next = this.field3157.next;
      var1.previous = this.field3157;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public class203() {
      this.field3157.previous = this.field3157;
      this.field3157.next = this.field3157;
   }
}
