import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public final class class94 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 664162767
   )
   int field1597;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1048438267
   )
   int field1598;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -17307039
   )
   int field1599;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1895396753
   )
   int field1600;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -617784863
   )
   int field1601;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1209663991
   )
   int field1602;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1902570151
   )
   int field1603;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 91241649
   )
   int field1604;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 119089799
   )
   int field1605;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 583249079
   )
   int field1606;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -609439335
   )
   int field1607;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1249259267
   )
   int field1608;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 26580009
   )
   int field1609;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -803915955
   )
   int field1610;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -973074251
   )
   int field1611;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -302093003
   )
   int field1612;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1139259989
   )
   int field1613;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1217655905
   )
   int field1614;

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "740016649"
   )
   static void method1950() {
      Client.secretCipherBuffer1.putOpcode(3);
      CipherBuffer var0 = Client.secretCipherBuffer1;
      int var1 = Client.isResized?2:1;
      var0.putByte(var1);
      Client.secretCipherBuffer1.putShort(class32.field755);
      Client.secretCipherBuffer1.putShort(class168.field2207);
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "783134109"
   )
   static boolean method1951(String var0) {
      if(null == var0) {
         return false;
      } else {
         String var1 = class187.method3483(var0, Ignore.field214);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class187.method3483(var3.name, Ignore.field214))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class187.method3483(var3.previousName, Ignore.field214))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1063540875"
   )
   static final void method1952(boolean var0) {
      for(int var1 = 0; var1 < Client.field402; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field342[var1]];
         int var3 = 536870912 + (Client.field342[var1] << 14);
         if(null != var2 && var2.vmethod738() && var0 == var2.composition.isVisible && var2.composition.method3742()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field622 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field337 == Client.field405[var4][var5]) {
                     continue;
                  }

                  Client.field405[var4][var5] = Client.field337;
               }

               if(!var2.composition.field3020) {
                  var3 -= Integer.MIN_VALUE;
               }

               CombatInfo1.region.method1747(Sequence.plane, var2.x, var2.y, class103.method2025(var2.field622 * 64 - 64 + var2.x, var2.field622 * 64 - 64 + var2.y, Sequence.plane), 60 + (var2.field622 * 64 - 64), var2, var2.angle, var3, var2.field621);
            }
         }
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1435271921"
   )
   static final void method1953(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = class84.field1475[var6];
         var12 = class84.field1469[var6];
         var13 = var12 * var9 - var5 * var11 >> 16;
         var10 = var11 * var9 + var12 * var5 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = class84.field1475[var7];
         var12 = class84.field1469[var7];
         var13 = var11 * var10 + var8 * var12 >> 16;
         var10 = var12 * var10 - var8 * var11 >> 16;
         var8 = var13;
      }

      MessageNode.cameraX = var0 - var8;
      class16.cameraZ = var1 - var9;
      DecorativeObject.cameraY = var2 - var10;
      class16.cameraPitch = var3;
      class9.cameraYaw = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-2074476890"
   )
   public static String method1954(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 402) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
