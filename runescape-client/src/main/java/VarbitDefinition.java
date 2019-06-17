import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("VarbitDefinition")
public class VarbitDefinition extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("VarbitDefinition_indexCache")
   static AbstractIndexCache VarbitDefinition_indexCache;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("VarbitDefinition_cached")
   public static EvictingDualNodeHashTable VarbitDefinition_cached;
   @ObfuscatedName("u")
   @Export("indexedSpriteWidths")
   static int[] indexedSpriteWidths;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1552575189
   )
   @Export("varp")
   public int varp;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -870948181
   )
   @Export("lowBit")
   public int lowBit;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1710935305
   )
   @Export("highBit")
   public int highBit;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "-1888757206"
   )
   @Export("read")
   void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgr;IB)V",
      garbageValue = "-76"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.varp = var1.__ag_302();
         this.lowBit = var1.readUnsignedByte();
         this.highBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1635045878"
   )
   static final boolean method4910(int var0, int var1) {
      ObjectDefinition var2 = class50.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.__u_421(var1);
   }

   static {
      VarbitDefinition_cached = new EvictingDualNodeHashTable(64);
   }
}
