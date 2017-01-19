import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1336961813
   )
   int field1467;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 861150163
   )
   int field1468;
   @ObfuscatedName("f")
   int[] field1469;
   @ObfuscatedName("ai")
   static int[] field1470;
   @ObfuscatedName("h")
   int[][] field1471;
   @ObfuscatedName("m")
   public static class60 field1472;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = 2058327405
   )
   static int field1473;

   FrameMap(int var1, byte[] var2) {
      this.field1467 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1468 = var3.readUnsignedByte();
      this.field1469 = new int[this.field1468];
      this.field1471 = new int[this.field1468][];

      int var4;
      for(var4 = 0; var4 < this.field1468; ++var4) {
         this.field1469[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field1468; ++var4) {
         this.field1471[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field1468; ++var4) {
         for(int var5 = 0; var5 < this.field1471[var4].length; ++var5) {
            this.field1471[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2052999570"
   )
   static final int method1655(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;B)V",
      garbageValue = "-124"
   )
   public static void method1656(class182 var0, class182 var1) {
      NPCComposition.field3012 = var0;
      NPCComposition.field3005 = var1;
   }
}
