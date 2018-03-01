import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
@Implements("Node")
public class Node {
   @ObfuscatedName("cp")
   @Export("hash")
   public long hash;
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("previous")
   Node previous;

   @ObfuscatedName("kn")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("kl")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
