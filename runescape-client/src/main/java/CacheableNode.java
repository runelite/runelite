import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dh")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cp")
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("cx")
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("cz")
   public void method2411() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
