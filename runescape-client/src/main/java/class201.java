import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class201 implements Iterable {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   public CacheableNode field2484;

   public class201() {
      this.field2484 = new CacheableNode();
      this.field2484.previous = this.field2484;
      this.field2484.next = this.field2484;
   }

   @ObfuscatedName("a")
   public void method3670() {
      while(this.field2484.previous != this.field2484) {
         this.field2484.previous.unlinkDual();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgn;)V"
   )
   public void method3674(CacheableNode var1) {
      if(var1.next != null) {
         var1.unlinkDual();
      }

      var1.next = this.field2484.next;
      var1.previous = this.field2484;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class200(this);
   }
}
