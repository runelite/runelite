import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dp")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cd")
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("cq")
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("cc")
   public void method2497() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
