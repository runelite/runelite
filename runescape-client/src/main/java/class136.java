import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ed")
public class class136 implements Iterable {
   @ObfuscatedName("s")
   public CacheableNode field1906 = new CacheableNode();

   @ObfuscatedName("c")
   public void method2389(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2361();
      }

      var1.next = this.field1906.next;
      var1.previous = this.field1906;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class135(this);
   }

   public class136() {
      this.field1906.previous = this.field1906;
      this.field1906.next = this.field1906;
   }

   @ObfuscatedName("s")
   public void method2394() {
      while(this.field1906.previous != this.field1906) {
         this.field1906.previous.method2361();
      }

   }
}
