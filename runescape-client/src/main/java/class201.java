import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gx")
public class class201 implements Iterable {
   @ObfuscatedName("i")
   public CacheableNode field2492;

   @ObfuscatedName("w")
   public void method3642(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3604();
      }

      var1.next = this.field2492.next;
      var1.previous = this.field2492;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class200(this);
   }

   public class201() {
      this.field2492 = new CacheableNode();
      this.field2492.previous = this.field2492;
      this.field2492.next = this.field2492;
   }

   @ObfuscatedName("i")
   public void method3645() {
      while(this.field2492 != this.field2492.previous) {
         this.field2492.previous.method3604();
      }

   }
}
