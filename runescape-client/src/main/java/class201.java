import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class201 implements Iterable {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public CacheableNode field2458;

   public class201() {
      this.field2458 = new CacheableNode();
      this.field2458.previous = this.field2458;
      this.field2458.next = this.field2458;
   }

   @ObfuscatedName("d")
   public void method3679() {
      while(this.field2458.previous != this.field2458) {
         this.field2458.previous.unlinkDual();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgq;)V"
   )
   public void method3678(CacheableNode var1) {
      if(var1.next != null) {
         var1.unlinkDual();
      }

      var1.next = this.field2458.next;
      var1.previous = this.field2458;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class200(this);
   }
}
