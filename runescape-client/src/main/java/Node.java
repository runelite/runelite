import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
@Implements("Node")
public class Node {
   @ObfuscatedName("cc")
   @Export("hash")
   public long hash;
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("previous")
   Node previous;

   @ObfuscatedName("jk")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("jz")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
