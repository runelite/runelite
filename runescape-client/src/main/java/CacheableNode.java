import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("cu")
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
