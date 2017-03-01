import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ez")
public class class136 implements Iterable {
   @ObfuscatedName("x")
   public CacheableNode field1903 = new CacheableNode();

   public class136() {
      this.field1903.previous = this.field1903;
      this.field1903.next = this.field1903;
   }

   @ObfuscatedName("x")
   public void method2546() {
      while(this.field1903.previous != this.field1903) {
         this.field1903.previous.method2513();
      }

   }

   public Iterator iterator() {
      return new class135(this);
   }

   @ObfuscatedName("n")
   public void method2548(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2513();
      }

      var1.next = this.field1903.next;
      var1.previous = this.field1903;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }
}
