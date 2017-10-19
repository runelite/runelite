import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("next")
   public CacheableNode next;
   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("previous")
   public CacheableNode previous;

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
