import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("next")
   public CacheableNode next;
   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("previous")
   public CacheableNode previous;

   @ObfuscatedName("cy")
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
