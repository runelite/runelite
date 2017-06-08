import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gr")
@Implements("Node")
public class Node {
   @ObfuscatedName("cd")
   @Export("next")
   public Node next;
   @ObfuscatedName("cf")
   @Export("hash")
   public long hash;
   @ObfuscatedName("ce")
   @Export("previous")
   Node previous;

   @ObfuscatedName("ig")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }

   @ObfuscatedName("il")
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
