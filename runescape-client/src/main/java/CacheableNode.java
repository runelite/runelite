import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dm")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cg")
   @Export("next")
   public CacheableNode next;
   @ObfuscatedName("ce")
   @Export("previous")
   public CacheableNode previous;

   @ObfuscatedName("cu")
   public void method2413() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }

   }
}
