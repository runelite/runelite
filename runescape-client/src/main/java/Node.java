import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
@Implements("Node")
public class Node {
   @ObfuscatedName("cs")
   @Export("hash")
   public long hash;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("previous")
   Node previous;

   @ObfuscatedName("kg")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("ks")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
