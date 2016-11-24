import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dx")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cj")
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("cq")
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("cj")
   public void method2483() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
