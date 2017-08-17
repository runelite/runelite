import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public class class202 implements Iterable {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   public CacheableNode field2487;

   public class202() {
      this.field2487 = new CacheableNode();
      this.field2487.previous = this.field2487;
      this.field2487.next = this.field2487;
   }

   @ObfuscatedName("j")
   public void method3662() {
      while(this.field2487.previous != this.field2487) {
         this.field2487.previous.unlinkDual();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lge;)V"
   )
   public void method3665(CacheableNode var1) {
      if(var1.next != null) {
         var1.unlinkDual();
      }

      var1.next = this.field2487.next;
      var1.previous = this.field2487;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class201(this);
   }
}
