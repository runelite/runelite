import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("ct")
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
