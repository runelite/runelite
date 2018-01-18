import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("cv")
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
