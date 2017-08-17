import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
@Implements("Node")
public class Node {
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("previous")
   Node previous;
   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cv")
   @Export("hash")
   public long hash;

   @ObfuscatedName("im")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("ja")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
