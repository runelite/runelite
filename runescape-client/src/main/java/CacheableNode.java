import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   @Export("next")
   public CacheableNode next;
   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   @Export("previous")
   public CacheableNode previous;

   @ObfuscatedName("ca")
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
