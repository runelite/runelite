import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("Node")
public class Node {
   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("previous")
   Node previous;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cl")
   @Export("hash")
   public long hash;

   @ObfuscatedName("jt")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("js")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
