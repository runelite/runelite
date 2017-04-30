import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ef")
@Implements("Node2LinkedList")
public final class Node2LinkedList {
   @ObfuscatedName("d")
   @Export("sentinel")
   CacheableNode sentinel;

   @ObfuscatedName("d")
   public void method2712(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2851();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("c")
   public void method2714(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2851();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("n")
   CacheableNode method2715() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.method2851();
         return var1;
      }
   }

   @ObfuscatedName("q")
   public CacheableNode method2716() {
      CacheableNode var1 = this.sentinel.previous;
      return var1 == this.sentinel?null:var1;
   }

   @ObfuscatedName("t")
   void method2723() {
      while(true) {
         CacheableNode var1 = this.sentinel.previous;
         if(var1 == this.sentinel) {
            return;
         }

         var1.method2851();
      }
   }

   public Node2LinkedList() {
      this.sentinel = new CacheableNode();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }
}
