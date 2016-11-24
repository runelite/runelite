import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("en")
public class class136 implements Iterable {
   @ObfuscatedName("n")
   public CacheableNode field1897 = new CacheableNode();

   @ObfuscatedName("d")
   public void method2521(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2483();
      }

      var1.next = this.field1897.next;
      var1.previous = this.field1897;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("n")
   public void method2522() {
      while(this.field1897.previous != this.field1897) {
         this.field1897.previous.method2483();
      }

   }

   public Iterator iterator() {
      return new class135(this);
   }

   public class136() {
      this.field1897.previous = this.field1897;
      this.field1897.next = this.field1897;
   }
}
