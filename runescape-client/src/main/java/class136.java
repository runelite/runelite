import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ep")
public class class136 implements Iterable {
   @ObfuscatedName("x")
   public CacheableNode field1902 = new CacheableNode();

   @ObfuscatedName("x")
   public void method2513() {
      while(this.field1902.previous != this.field1902) {
         this.field1902.previous.method2476();
      }

   }

   @ObfuscatedName("j")
   public void method2515(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2476();
      }

      var1.next = this.field1902.next;
      var1.previous = this.field1902;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class135(this);
   }

   public class136() {
      this.field1902.previous = this.field1902;
      this.field1902.next = this.field1902;
   }
}
