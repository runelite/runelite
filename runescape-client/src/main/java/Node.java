import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
@Implements("Node")
public class Node {
   @ObfuscatedName("co")
   @Export("hash")
   public long hash;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("previous")
   Node previous;

   @ObfuscatedName("ks")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("ka")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
