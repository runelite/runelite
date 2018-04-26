import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1743274173
   )
   @Export("type")
   int type;
   @ObfuscatedName("e")
   byte[] field3358;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   @Export("index")
   IndexFile index;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("data")
   IndexData data;

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1270225217"
   )
   static final void method4637() {
      for(int var0 = 0; var0 < Client.npcIndexesCount; ++var0) {
         int var1 = Client.npcIndices[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            BoundingBox3D.method55(var2, var2.composition.size);
         }
      }

   }
}
