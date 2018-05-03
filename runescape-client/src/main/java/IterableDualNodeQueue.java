import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
@Implements("IterableDualNodeQueue")
public class IterableDualNodeQueue implements Iterable {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   @Export("sentinel")
   public CacheableNode sentinel;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   CacheableNode field2680;

   public IterableDualNodeQueue() {
      this.sentinel = new CacheableNode();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("g")
   @Export("clear")
   public void clear() {
      while(this.sentinel.previous != this.sentinel) {
         this.sentinel.previous.unlinkDual();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lhf;)V"
   )
   @Export("add")
   public void add(CacheableNode var1) {
      if(var1.next != null) {
         var1.unlinkDual();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "()Lhf;"
   )
   CacheableNode method4192() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.unlinkDual();
         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Lhf;"
   )
   CacheableNode method4193() {
      return this.method4199((CacheableNode)null);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lhf;)Lhf;"
   )
   CacheableNode method4199(CacheableNode var1) {
      CacheableNode var2;
      if(var1 == null) {
         var2 = this.sentinel.previous;
      } else {
         var2 = var1;
      }

      if(var2 == this.sentinel) {
         this.field2680 = null;
         return null;
      } else {
         this.field2680 = var2.previous;
         return var2;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Lhf;"
   )
   CacheableNode method4198() {
      CacheableNode var1 = this.field2680;
      if(var1 == this.sentinel) {
         this.field2680 = null;
         return null;
      } else {
         this.field2680 = var1.previous;
         return var1;
      }
   }

   public Iterator iterator() {
      return new class226(this);
   }
}
