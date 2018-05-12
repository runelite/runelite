import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cc")
   long field2454;
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "Lgc;"
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
