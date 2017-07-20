import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = -705561133
   )
   static int field827;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 1872642347
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("i")
   boolean field823;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -532834593
   )
   @Export("id")
   int id;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1115058349
   )
   @Export("owner")
   int owner;

   WidgetNode() {
      this.field823 = false;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1807152720"
   )
   static int method1045(int var0, int var1, int var2) {
      return (class61.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class61.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }
}
