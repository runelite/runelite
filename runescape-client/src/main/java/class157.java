import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fe")
public class class157 implements Iterable {
   @ObfuscatedName("d")
   public CacheableNode field2051;

   public class157() {
      this.field2051 = new CacheableNode();
      this.field2051.previous = this.field2051;
      this.field2051.next = this.field2051;
   }

   @ObfuscatedName("c")
   public void method2883(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2851();
      }

      var1.next = this.field2051.next;
      var1.previous = this.field2051;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class156(this);
   }

   @ObfuscatedName("d")
   public void method2884() {
      while(this.field2051.previous != this.field2051) {
         this.field2051.previous.method2851();
      }

   }
}
