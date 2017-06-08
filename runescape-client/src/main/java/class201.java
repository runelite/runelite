import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("go")
public class class201 implements Iterable {
   @ObfuscatedName("n")
   public CacheableNode field2501;

   public class201() {
      this.field2501 = new CacheableNode();
      this.field2501.previous = this.field2501;
      this.field2501.next = this.field2501;
   }

   public Iterator iterator() {
      return new class200(this);
   }

   @ObfuscatedName("p")
   public void method3680(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3641();
      }

      var1.next = this.field2501.next;
      var1.previous = this.field2501;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("n")
   public void method3681() {
      while(this.field2501.previous != this.field2501) {
         this.field2501.previous.method3641();
      }

   }
}
