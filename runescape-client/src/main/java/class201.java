import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
public class class201 implements Iterable {
   @ObfuscatedName("i")
   public CacheableNode field2499;

   @ObfuscatedName("i")
   public void method3634() {
      while(this.field2499.previous != this.field2499) {
         this.field2499.previous.method3600();
      }

   }

   public Iterator iterator() {
      return new class200(this);
   }

   @ObfuscatedName("c")
   public void method3642(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3600();
      }

      var1.next = this.field2499.next;
      var1.previous = this.field2499;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public class201() {
      this.field2499 = new CacheableNode();
      this.field2499.previous = this.field2499;
      this.field2499.next = this.field2499;
   }
}
