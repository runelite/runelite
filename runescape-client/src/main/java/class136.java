import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eo")
public class class136 implements Iterable {
   @ObfuscatedName("i")
   public CacheableNode field1896 = new CacheableNode();

   @ObfuscatedName("i")
   public void method2428() {
      while(this.field1896.previous != this.field1896) {
         this.field1896.previous.method2388();
      }

   }

   @ObfuscatedName("e")
   public void method2429(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2388();
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
