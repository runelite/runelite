import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -691483983
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -13700523
   )
   @Export("maxTileX")
   int maxTileX;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 768402657
   )
   @Export("minTileY")
   int minTileY;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1501977891
   )
   @Export("maxTileY")
   int maxTileY;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -806776509
   )
   @Export("type")
   int type;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1824663821
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2141305127
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -41239751
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1805075909
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 842961497
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1114046315
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 826041747
   )
   @Export("__k")
   int __k;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -407777817
   )
   @Export("surfaceOffsetY")
   int surfaceOffsetY;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1324959981
   )
   @Export("__i")
   int __i;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1527021367
   )
   @Export("__a")
   int __a;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -570391007
   )
   @Export("__z")
   int __z;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -373839103
   )
   @Export("__j")
   int __j;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1334433969
   )
   @Export("__s")
   int __s;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)Lia;",
      garbageValue = "16"
   )
   public static VarbitDefinition method3255(int var0) {
      VarbitDefinition var1 = (VarbitDefinition)VarbitDefinition.VarbitDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarbitDefinition.VarbitDefinition_indexCache.takeRecord(14, var0);
         var1 = new VarbitDefinition();
         if(var2 != null) {
            var1.read(new Buffer(var2));
         }

         VarbitDefinition.VarbitDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)Lcg;",
      garbageValue = "-1164060583"
   )
   @Export("newScript")
   static Script newScript(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.index = var2.array.length - 2;
      int var3 = var2.__ag_302();
      int var4 = var2.array.length - 2 - var3 - 12;
      var2.index = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.__ag_302();
      var1.localStringCount = var2.__ag_302();
      var1.intArgumentCount = var2.__ag_302();
      var1.stringArgumentCount = var2.__ag_302();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.__o_164(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.__ag_302();
            IterableNodeHashTable var9 = new IterableNodeHashTable(var8 > 0?World.method1759(var8):1);
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.put(new IntegerNode(var11), (long)var10);
            }
         }
      }

      var2.index = 0;
      var2.readStringCp1252NullTerminatedOrNull();
      var1.opcodes = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.index < var4; var1.opcodes[var7++] = var8) {
         var8 = var2.__ag_302();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readStringCp1252NullTerminated();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }
}
