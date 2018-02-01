import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
@Implements("Node")
public class Node {
   @ObfuscatedName("cm")
   @Export("hash")
   public long hash;
   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("previous")
   Node previous;

   @ObfuscatedName("ij")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("jw")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
