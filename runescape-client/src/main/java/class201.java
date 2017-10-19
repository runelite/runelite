import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class201 implements Iterable {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public CacheableNode field2483;

   public class201() {
      this.field2483 = new CacheableNode();
      this.field2483.previous = this.field2483;
      this.field2483.next = this.field2483;
   }

   @ObfuscatedName("w")
   public void method3757() {
      while(this.field2483.previous != this.field2483) {
         this.field2483.previous.unlinkDual();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgp;)V"
   )
   public void method3752(CacheableNode var1) {
      if(var1.next != null) {
         var1.unlinkDual();
      }

      var1.next = this.field2483.next;
      var1.previous = this.field2483;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class200(this);
   }
}
