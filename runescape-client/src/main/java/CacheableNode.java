import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dr")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cu")
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("cm")
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("cg")
   public void method2484() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
