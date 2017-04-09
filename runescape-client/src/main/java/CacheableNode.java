import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dm")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cq")
   @Export("next")
   public CacheableNode next;
   @ObfuscatedName("cc")
   @Export("previous")
   public CacheableNode previous;

   @ObfuscatedName("ci")
   public void method2495() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }

   }
}
