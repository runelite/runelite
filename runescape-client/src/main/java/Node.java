import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hb")
@Implements("Node")
public class Node {
   @ObfuscatedName("eq")
   @Export("next")
   public Node next;
   @ObfuscatedName("ef")
   @Export("previous")
   Node previous;
   @ObfuscatedName("em")
   @Export("hash")
   public long hash;

   @ObfuscatedName("ii")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }

   }

   @ObfuscatedName("jc")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
