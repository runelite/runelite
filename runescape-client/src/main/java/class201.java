import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
public class class201 implements Iterable {
   @ObfuscatedName("i")
   public CacheableNode field2485;

   @ObfuscatedName("i")
   public void method3722() {
      while(this.field2485.previous != this.field2485) {
         this.field2485.previous.method3687();
      }

   }

   @ObfuscatedName("h")
   public void method3723(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3687();
      }

      var1.next = this.field2485.next;
      var1.previous = this.field2485;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class200(this);
   }

   public class201() {
      this.field2485 = new CacheableNode();
      this.field2485.previous = this.field2485;
      this.field2485.next = this.field2485;
   }
}
