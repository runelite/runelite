import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ew")
public class class136 implements Iterable {
   @ObfuscatedName("k")
   public CacheableNode field1892 = new CacheableNode();

   @ObfuscatedName("k")
   public void method2446() {
      while(this.field1892.previous != this.field1892) {
         this.field1892.previous.method2411();
      }

   }

   @ObfuscatedName("y")
   public void method2447(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2411();
      }

      var1.next = this.field1892.next;
      var1.previous = this.field1892;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public class136() {
      this.field1892.previous = this.field1892;
      this.field1892.next = this.field1892;
   }

   public Iterator iterator() {
      return new class135(this);
   }
}
