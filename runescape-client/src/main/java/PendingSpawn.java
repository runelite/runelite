import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 300693017
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1567374659
   )
   @Export("hitpoints")
   int hitpoints;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2139915869
   )
   @Export("x")
   int x;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -122822591
   )
   @Export("y")
   int y;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1557112861
   )
   int field1191;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 189315145
   )
   @Export("type")
   int type;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 366797655
   )
   int field1193;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2031361961
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -182140341
   )
   int field1195;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1327814527
   )
   int field1196;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1330395765
   )
   @Export("level")
   int level;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1629142317
   )
   @Export("delay")
   int delay;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)Z",
      garbageValue = "38"
   )
   static final boolean method1434(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = class134.field1995 + var6;
      if(var7 < var0 && var7 < var1 && var7 < var2) {
         return false;
      } else {
         var7 = class134.field1995 - var6;
         if(var7 > var0 && var7 > var1 && var7 > var2) {
            return false;
         } else {
            var7 = class134.field1994 + var6;
            if(var7 < var3 && var7 < var4 && var7 < var5) {
               return false;
            } else {
               var7 = class134.field1994 - var6;
               return var7 <= var3 || var7 <= var4 || var7 <= var5;
            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "-139192427"
   )
   static char method1435(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }
}
