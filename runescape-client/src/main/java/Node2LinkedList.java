import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ga")
@Implements("Node2LinkedList")
public final class Node2LinkedList {
   @ObfuscatedName("i")
   @Export("sentinel")
   CacheableNode sentinel;

   @ObfuscatedName("i")
   public void method3460(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3604();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("a")
   CacheableNode method3462() {
      CacheableNode var1 = this.sentinel.previous;
      if(this.sentinel == var1) {
         return null;
      } else {
         var1.method3604();
         return var1;
      }
   }

   @ObfuscatedName("t")
   public CacheableNode method3463() {
      CacheableNode var1 = this.sentinel.previous;
      return this.sentinel == var1?null:var1;
   }

   @ObfuscatedName("s")
   void method3464() {
      while(true) {
         CacheableNode var1 = this.sentinel.previous;
         if(this.sentinel == var1) {
            return;
         }

         var1.method3604();
      }
   }

   @ObfuscatedName("w")
   public void method3467(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3604();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Node2LinkedList() {
      this.sentinel = new CacheableNode();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }
}
