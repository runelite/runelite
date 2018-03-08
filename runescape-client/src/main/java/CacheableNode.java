import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cg")
   long field2641;
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("ce")
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
