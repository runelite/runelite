import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("t")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 656904343
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1096353093
   )
   @Export("count")
   int count;
   @ObfuscatedName("e")
   @Export("types")
   int[] types;
   @ObfuscatedName("k")
   @Export("list")
   int[][] list;

   FrameMap(int var1, byte[] var2) {
      this.id = var1;
      Buffer var3 = new Buffer(var2);
      this.count = var3.readUnsignedByte();
      this.types = new int[this.count];
      this.list = new int[this.count][];

      int var4;
      for(var4 = 0; var4 < this.count; ++var4) {
         this.types[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         this.list[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         for(int var5 = 0; var5 < this.list[var4].length; ++var5) {
            this.list[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2054020432"
   )
   static int method2686(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "86910519"
   )
   public static int method2687(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)[Lcz;",
      garbageValue = "-394441470"
   )
   static AttackOption[] method2688() {
      return new AttackOption[]{AttackOption.AttackOption_hidden, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_dependsOnCombatLevels};
   }
}
