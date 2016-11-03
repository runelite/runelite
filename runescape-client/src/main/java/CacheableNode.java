import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gv")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cp")
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("cd")
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("fp")
   public void method3932() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
