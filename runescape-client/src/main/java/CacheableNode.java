import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cs")
   long field2662;
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("cg")
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
