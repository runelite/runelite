import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class22 extends class119 {
   @ObfuscatedName("hb")
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 830803765
   )
   @Export("cameraX")
   static int cameraX;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "-899017539"
   )
   public boolean vmethod2294(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field1859 && super.field1862 == var3;
   }
}
