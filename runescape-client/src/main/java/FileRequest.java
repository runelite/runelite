import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("index")
   IndexData index;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 742677959
   )
   @Export("crc")
   int crc;
   @ObfuscatedName("i")
   @Export("padding")
   byte padding;

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-140770075"
   )
   static final int method4275() {
      if(Buffer.preferences.hideRoofs) {
         return Ignore.plane;
      } else {
         int var0 = class70.getTileHeight(class29.cameraX, Player.cameraY, Ignore.plane);
         return var0 - class70.cameraZ < 800 && (class61.tileSettings[Ignore.plane][class29.cameraX >> 7][Player.cameraY >> 7] & 4) != 0?Ignore.plane:3;
      }
   }
}
