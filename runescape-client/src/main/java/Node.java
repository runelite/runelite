import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("db")
@Implements("Node")
public class Node {
   @ObfuscatedName("cv")
   @Export("previous")
   Node previous;
   @ObfuscatedName("cg")
   @Export("hash")
   public long hash;
   @ObfuscatedName("cz")
   @Export("next")
   public Node next;

   @ObfuscatedName("fm")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }

   @ObfuscatedName("fy")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }
}
