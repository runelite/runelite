import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hg")
@Implements("Node")
public class Node {
   @ObfuscatedName("ey")
   @Export("next")
   public Node next;
   @ObfuscatedName("ek")
   @Export("hash")
   public long hash;
   @ObfuscatedName("ea")
   @Export("previous")
   Node previous;

   @ObfuscatedName("jl")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("jm")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
