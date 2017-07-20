import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class201 implements Iterable {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   public CacheableNode field2456;

   public class201() {
      this.field2456 = new CacheableNode();
      this.field2456.previous = this.field2456;
      this.field2456.next = this.field2456;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgc;)V"
   )
   public void method3616(CacheableNode var1) {
      if(var1.next != null) {
         var1.unlinkDual();
      }

      var1.next = this.field2456.next;
      var1.previous = this.field2456;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("c")
   public void method3613() {
      while(this.field2456.previous != this.field2456) {
         this.field2456.previous.unlinkDual();
      }

   }

   public Iterator iterator() {
      return new class200(this);
   }
}
