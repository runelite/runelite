import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
@Implements("Node")
public class Node {
   @ObfuscatedName("ce")
   @Export("hash")
   public long hash;
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   @Export("previous")
   Node previous;

   @ObfuscatedName("jy")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("ji")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
