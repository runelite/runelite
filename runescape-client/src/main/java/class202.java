import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class202 implements Iterable {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   public CacheableNode field2492;

   public class202() {
      this.field2492 = new CacheableNode();
      this.field2492.previous = this.field2492;
      this.field2492.next = this.field2492;
   }

   @ObfuscatedName("i")
   public void method3744() {
      while(this.field2492.previous != this.field2492) {
         this.field2492.previous.unlinkDual();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgo;)V"
   )
   public void method3743(CacheableNode var1) {
      if(var1.next != null) {
         var1.unlinkDual();
      }

      var1.next = this.field2492.next;
      var1.previous = this.field2492;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class201(this);
   }
}
