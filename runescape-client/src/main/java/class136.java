import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("er")
public class class136 implements Iterable {
   @ObfuscatedName("u")
   public CacheableNode field1886 = new CacheableNode();

   public class136() {
      this.field1886.previous = this.field1886;
      this.field1886.next = this.field1886;
   }

   @ObfuscatedName("u")
   public void method2449() {
      while(this.field1886.previous != this.field1886) {
         this.field1886.previous.method2413();
      }

   }

   @ObfuscatedName("x")
   public void method2450(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2413();
      }

      var1.next = this.field1886.next;
      var1.previous = this.field1886;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class135(this);
   }
}
