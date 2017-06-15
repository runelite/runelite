import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2031712489
   )
   @Export("z")
   int z;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1038179007
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1453231937
   )
   @Export("x")
   int x;
   @ObfuscatedName("cm")
   @Export("indexTrack1")
   static IndexData indexTrack1;

   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "-2083302659"
   )
   static void method2763(Sequence var0, int var1, int var2, int var3) {
      if(Client.field931 < 50 && Client.field1041 != 0) {
         if(var0.field3610 != null && var1 < var0.field3610.length) {
            int var4 = var0.field3610[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field1036[Client.field931] = var5;
               Client.field1155[Client.field931] = var6;
               Client.field1150[Client.field931] = 0;
               Client.audioEffects[Client.field931] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field1170[Client.field931] = (var9 << 8) + (var8 << 16) + var7;
               ++Client.field931;
            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   public static void method2764() {
      NPCComposition.field3585.reset();
      NPCComposition.npcModelCache.reset();
   }
}
