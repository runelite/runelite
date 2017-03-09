import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -244477191
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1696256757
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2146674531
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("h")
   @Export("top")
   Renderable top;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1542042207
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("er")
   static SpritePixels[] field1223;
   @ObfuscatedName("nk")
   static class65 field1224;
   @ObfuscatedName("w")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = -349757003
   )
   protected static int field1226;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1321913185
   )
   @Export("height")
   int height;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LWorld;I)V",
      garbageValue = "-1575304801"
   )
   static void method1518(World var0) {
      if(var0.method673() != Client.isMembers) {
         Client.isMembers = var0.method673();
         boolean var1 = var0.method673();
         if(var1 != class47.isMembersWorld) {
            class39.method814();
            class47.isMembersWorld = var1;
         }
      }

      WallObject.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      Ignore.field238 = Client.field381 == 0?'ꩊ':var0.id + '鱀';
      Client.field446 = Client.field381 == 0?443:var0.id + '썐';
      GameObject.field1636 = Ignore.field238;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "50"
   )
   static int method1519(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         class32.field752 -= 2;
         var3 = class32.field756[class32.field752];
         int var4 = class32.field756[class32.field752 + 1];
         if(!Client.field440) {
            Client.field396 = var3;
            Client.mapAngle = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         class32.field756[++class32.field752 - 1] = Client.field396;
         return 1;
      } else if(var0 == 5506) {
         class32.field756[++class32.field752 - 1] = Client.mapAngle;
         return 1;
      } else if(var0 == 5530) {
         var3 = class32.field756[--class32.field752];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.field402 = var3;
         return 1;
      } else if(var0 == 5531) {
         class32.field756[++class32.field752 - 1] = Client.field402;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "-1343424480"
   )
   public static void method1520(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method1520(var0, var1, var2, var5 - 1);
         method1520(var0, var1, 1 + var5, var3);
      }

   }
}
