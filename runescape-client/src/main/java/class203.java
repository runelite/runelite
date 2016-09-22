import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gs")
public class class203 implements Iterable {
   @ObfuscatedName("a")
   public CacheableNode field3154 = new CacheableNode();

   @ObfuscatedName("a")
   public void method3887() {
      while(this.field3154.previous != this.field3154) {
         this.field3154.previous.method3938();
      }

   }

   public class203() {
      this.field3154.previous = this.field3154;
      this.field3154.next = this.field3154;
   }

   @ObfuscatedName("d")
   public void method3888(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3938();
      }

      var1.next = this.field3154.next;
      var1.previous = this.field3154;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class209(this);
   }
}
