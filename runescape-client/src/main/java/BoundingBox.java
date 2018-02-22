import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
@Implements("BoundingBox")
public abstract class BoundingBox extends Node {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 689125175
   )
   @Export("priority")
   static int priority;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2133791811"
   )
   public abstract void vmethod48();

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgu;II)Z",
      garbageValue = "1446447976"
   )
   @Export("decodeRegionHash")
   static boolean decodeRegionHash(PacketBuffer var0, int var1) {
      int var2 = var0.getBits(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.getBits(1) != 0) {
            decodeRegionHash(var0, var1);
         }

         var3 = var0.getBits(13);
         var4 = var0.getBits(13);
         boolean var12 = var0.getBits(1) == 1;
         if(var12) {
            class92.field1370[++class92.field1382 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field808 = var1;
            if(class92.field1374[var1] != null) {
               var6.decodeApperance(class92.field1374[var1]);
            }

            var6.orientation = class92.Players_orientations[var1];
            var6.interacting = class92.Players_targetIndices[var1];
            var7 = class92.Players_regions[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.pathTraversed[0] = class92.field1378[var1];
            var6.field802 = (byte)var8;
            var6.method1191((var9 << 13) + var3 - ScriptState.baseX, (var10 << 13) + var4 - WorldMapType1.baseY);
            var6.field806 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class92.Players_regions[var1];
         class92.Players_regions[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class92.Players_regions[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class92.Players_regions[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class92.Players_regions[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var11 + var7 & 255;
            class92.Players_regions[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILca;ZI)I",
      garbageValue = "1288885138"
   )
   static int method45(int var0, Script var1, boolean var2) {
      Widget var3 = NetWriter.getWidget(class80.intStack[--class80.intStackSize]);
      if(var0 == 2500) {
         class80.intStack[++class80.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class80.intStack[++class80.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class80.intStack[++class80.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class80.intStack[++class80.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class80.intStack[++class80.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class80.intStack[++class80.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }
}
