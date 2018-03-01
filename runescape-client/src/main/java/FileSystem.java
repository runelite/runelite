import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static IndexedSprite field3358;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1348650597
   )
   @Export("type")
   int type;
   @ObfuscatedName("z")
   byte[] field3359;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   @Export("index")
   IndexFile index;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("data")
   IndexData data;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgb;II)V",
      garbageValue = "2145641317"
   )
   static final void method4665(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class93.field1410 = 0;
      UnitPriceComparator.method121(var0);
      MapIconReference.method711(var0);
      if(var0.offset - var2 != var1) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }
}
