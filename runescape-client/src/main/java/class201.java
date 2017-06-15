import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gr")
public class class201 implements Iterable {
   @ObfuscatedName("p")
   public CacheableNode field2501;

   @ObfuscatedName("p")
   public void method3555() {
      while(this.field2501.previous != this.field2501) {
         this.field2501.previous.method3520();
      }

   }

   @ObfuscatedName("m")
   public void method3556(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3520();
      }

      var1.next = this.field2501.next;
      var1.previous = this.field2501;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class200(this);
   }

   public class201() {
      this.field2501 = new CacheableNode();
      this.field2501.previous = this.field2501;
      this.field2501.next = this.field2501;
   }
}
