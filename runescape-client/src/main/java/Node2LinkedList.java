import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dh")
@Implements("Node2LinkedList")
public final class Node2LinkedList {
   @ObfuscatedName("p")
   @Export("sentinel")
   CacheableNode sentinel = new CacheableNode();

   @ObfuscatedName("x")
   CacheableNode method2302() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.method2440();
         return var1;
      }
   }

   @ObfuscatedName("p")
   public void method2304(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2440();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Node2LinkedList() {
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("d")
   void method2305() {
      while(true) {
         CacheableNode var1 = this.sentinel.previous;
         if(var1 == this.sentinel) {
            return;
         }

         var1.method2440();
      }
   }

   @ObfuscatedName("g")
   public void method2306(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2440();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("q")
   public CacheableNode method2314() {
      CacheableNode var1 = this.sentinel.previous;
      return var1 == this.sentinel?null:var1;
   }
}
