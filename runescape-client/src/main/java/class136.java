import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ed")
public class class136 implements Iterable {
   @ObfuscatedName("b")
   public CacheableNode field1896 = new CacheableNode();

   @ObfuscatedName("b")
   public void method2529() {
      while(this.field1896.previous != this.field1896) {
         this.field1896.previous.method2497();
      }

   }

   @ObfuscatedName("l")
   public void method2531(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2497();
      }

      var1.next = this.field1896.next;
      var1.previous = this.field1896;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class135(this);
   }

   public class136() {
      this.field1896.previous = this.field1896;
      this.field1896.next = this.field1896;
   }
}
