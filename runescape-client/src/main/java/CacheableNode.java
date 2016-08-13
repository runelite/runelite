import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cb")
   @Export("next")
   public CacheableNode next;
   @ObfuscatedName("cs")
   @Export("previous")
   public CacheableNode previous;

   @ObfuscatedName("fr")
   public void method4045() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }

   }
}
