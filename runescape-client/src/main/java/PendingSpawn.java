import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -61945089
   )
   @Export("level")
   int level;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -786096809
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1150283509
   )
   @Export("type")
   int type;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1673432669
   )
   int field1134;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -183754713
   )
   @Export("x")
   int x;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -466897419
   )
   int field1139;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1624842695
   )
   int field1140;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1550897371
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1649279443
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -105190875
   )
   int field1143;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2029538827
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1060361925
   )
   @Export("hitpoints")
   int hitpoints;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "47"
   )
   public static String method1571(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var2 + var1; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(var7 == 0) {
               var8 = 65533;
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = 65533;
         } else if(var7 < 224) {
            if(var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else if(var7 < 240) {
            if(var5 + 1 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else if(var7 < 248) {
            if(var5 + 2 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[var5 + 2] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 >= 65536 && var8 <= 1114111) {
                  var8 = 65533;
               } else {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else {
            var8 = 65533;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIIII[Lfb;I)V",
      garbageValue = "-1668332820"
   )
   static final void method1572(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
                  var5[var6].flags[var7 + var1][var2 + var8] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               class149.loadTerrain(var10, var7, var8 + var1, var9 + var2, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIB)Lbh;",
      garbageValue = "109"
   )
   static MessageNode method1573(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var0));
      return var2.method1921(var1);
   }
}
