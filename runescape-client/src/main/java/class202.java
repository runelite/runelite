import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class202 implements Iterable {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   public CacheableNode field2470;

   public class202() {
      this.field2470 = new CacheableNode();
      this.field2470.previous = this.field2470;
      this.field2470.next = this.field2470;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgz;)V"
   )
   public void method3674(CacheableNode var1) {
      if(var1.next != null) {
         var1.unlinkDual();
      }

      var1.next = this.field2470.next;
      var1.previous = this.field2470;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("e")
   public void method3672() {
      while(this.field2470.previous != this.field2470) {
         this.field2470.previous.unlinkDual();
      }

   }

   public Iterator iterator() {
      return new class201(this);
   }
}
