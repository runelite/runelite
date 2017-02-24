import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ex")
public class class136 implements Iterable {
   @ObfuscatedName("q")
   public CacheableNode field1900 = new CacheableNode();

   public class136() {
      this.field1900.previous = this.field1900;
      this.field1900.next = this.field1900;
   }

   public Iterator iterator() {
      return new class135(this);
   }

   @ObfuscatedName("d")
   public void method2523(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2484();
      }

      var1.next = this.field1900.next;
      var1.previous = this.field1900;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("q")
   public void method2525() {
      while(this.field1900.previous != this.field1900) {
         this.field1900.previous.method2484();
      }

   }
}
