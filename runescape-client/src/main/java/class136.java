import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eq")
public class class136 implements Iterable {
   @ObfuscatedName("f")
   public CacheableNode field1923 = new CacheableNode();

   @ObfuscatedName("f")
   public void method2534() {
      while(this.field1923.previous != this.field1923) {
         this.field1923.previous.method2495();
      }

   }

   @ObfuscatedName("i")
   public void method2535(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2495();
      }

      var1.next = this.field1923.next;
      var1.previous = this.field1923;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public class136() {
      this.field1923.previous = this.field1923;
      this.field1923.next = this.field1923;
   }

   public Iterator iterator() {
      return new class135(this);
   }
}
