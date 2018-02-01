import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class47 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 75102437
   )
   public int field556;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   public Coordinates field554;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   public Coordinates field555;

   @ObfuscatedSignature(
      signature = "(ILhn;Lhn;)V"
   )
   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field556 = var1;
      this.field554 = var2;
      this.field555 = var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1509865219"
   )
   static void method698() {
      class310.field3892 = null;
      class310.offsetsY = null;
      class310.field3895 = null;
      class310.field3896 = null;
      class310.field3897 = null;
      class160.spritePixels = null;
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(Lbx;II)V",
      garbageValue = "-2075400050"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      MilliTimer.worldToScreen(var0.x, var0.y, var1);
   }
}
