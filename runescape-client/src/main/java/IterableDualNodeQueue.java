import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("IterableDualNodeQueue")
public class IterableDualNodeQueue implements Iterable {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("sentinel")
   public DualNode sentinel;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("head")
   DualNode head;

   public IterableDualNodeQueue() {
      this.sentinel = new DualNode();
      this.sentinel.previousDual = this.sentinel;
      this.sentinel.nextDual = this.sentinel;
   }

   @ObfuscatedName("m")
   @Export("clear")
   public void clear() {
      while(this.sentinel.previousDual != this.sentinel) {
         this.sentinel.previousDual.removeDual();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfn;)V"
   )
   @Export("add")
   public void add(DualNode var1) {
      if(var1.nextDual != null) {
         var1.removeDual();
      }

      var1.nextDual = this.sentinel.nextDual;
      var1.previousDual = this.sentinel;
      var1.nextDual.previousDual = var1;
      var1.previousDual.nextDual = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lfn;"
   )
   @Export("__q_448")
   public DualNode __q_448() {
      DualNode var1 = this.sentinel.previousDual;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.removeDual();
         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "()Lfn;"
   )
   @Export("__w_449")
   public DualNode __w_449() {
      return this.__o_450((DualNode)null);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfn;)Lfn;"
   )
   @Export("__o_450")
   DualNode __o_450(DualNode var1) {
      DualNode var2;
      if(var1 == null) {
         var2 = this.sentinel.previousDual;
      } else {
         var2 = var1;
      }

      if(var2 == this.sentinel) {
         this.head = null;
         return null;
      } else {
         this.head = var2.previousDual;
         return var2;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Lfn;"
   )
   @Export("__u_451")
   public DualNode __u_451() {
      DualNode var1 = this.head;
      if(var1 == this.sentinel) {
         this.head = null;
         return null;
      } else {
         this.head = var1.previousDual;
         return var1;
      }
   }

   @Export("iterator")
   @ObfuscatedName("iterator")
   public Iterator iterator() {
      return new IterableDualNodeQueueIterator(this);
   }
}
