import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
@Implements("DualNode")
public class DualNode extends Node {
   @ObfuscatedName("cg")
   @Export("keyDual")
   public long keyDual;
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("previousDual")
   public DualNode previousDual;
   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("nextDual")
   public DualNode nextDual;

   @ObfuscatedName("cg")
   @Export("removeDual")
   public void removeDual() {
      if(this.nextDual != null) {
         this.nextDual.previousDual = this.previousDual;
         this.previousDual.nextDual = this.nextDual;
         this.previousDual = null;
         this.nextDual = null;
      }

   }
}
