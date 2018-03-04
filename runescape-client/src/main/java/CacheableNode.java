import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cf")
   long field2658;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Lhu;"
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
