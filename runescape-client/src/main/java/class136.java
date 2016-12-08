import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("er")
public class class136 implements Iterable {
   @ObfuscatedName("o")
   public CacheableNode field1913 = new CacheableNode();

   @ObfuscatedName("o")
   public void method2408() {
      while(this.field1913.previous != this.field1913) {
         this.field1913.previous.method2380();
      }

   }

   @ObfuscatedName("m")
   public void method2409(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2380();
      }

      var1.next = this.field1913.next;
      var1.previous = this.field1913;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class135(this);
   }

   public class136() {
      this.field1913.previous = this.field1913;
      this.field1913.next = this.field1913;
   }
}
