import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("cm")
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
