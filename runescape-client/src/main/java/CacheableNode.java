import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gn")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("ci")
   @Export("next")
   public CacheableNode next;
   @ObfuscatedName("cb")
   @Export("previous")
   public CacheableNode previous;

   @ObfuscatedName("cj")
   @Export("unlinkDual")
   public void unlinkDual() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
