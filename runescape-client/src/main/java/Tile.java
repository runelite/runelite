import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1730277861
   )
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -160811099
   )
   @Export("y")
   int y;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1628998881
   )
   int field1796;
   @ObfuscatedName("i")
   boolean field1798;
   @ObfuscatedName("m")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("y")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("u")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("h")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("b")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("g")
   int[] field1805 = new int[5];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 173778193
   )
   int field1806;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 270038601
   )
   int field1807;
   @ObfuscatedName("s")
   boolean field1808;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1462518855
   )
   int field1809;
   @ObfuscatedName("j")
   class100 field1810;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1580926081
   )
   int field1811 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 304091895
   )
   int field1812;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1855786959
   )
   int field1813;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -899504477
   )
   int field1814;
   @ObfuscatedName("v")
   class92 field1815;
   @ObfuscatedName("pk")
   static class224 field1816;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1648633227
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("x")
   Tile field1819;
   @ObfuscatedName("w")
   boolean field1820;

   Tile(int var1, int var2, int var3) {
      this.field1796 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-1479291941"
   )
   static final void method2351(Actor var0) {
      if(var0.field878 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < '耀') {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var1 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(null != var1) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.field876 = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field852) {
               var0.interacting = -1;
               var0.field852 = false;
            }
         }

         if(var0.field845 != -1 && (var0.field851 == 0 || var0.field883 > 0)) {
            var0.field876 = var0.field845;
            var0.field845 = -1;
         }

         int var4 = var0.field876 - var0.angle & 2047;
         if(var4 == 0 && var0.field852) {
            var0.interacting = -1;
            var0.field852 = false;
         }

         if(var4 != 0) {
            ++var0.field877;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field878;
               var6 = true;
               if(var4 < var0.field878 || var4 > 2048 - var0.field878) {
                  var0.angle = var0.field876;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field877 > 25 || var6)) {
                  if(var0.field831 != -1) {
                     var0.poseAnimation = var0.field831;
                  } else {
                     var0.poseAnimation = var0.field833;
                  }
               }
            } else {
               var0.angle += var0.field878;
               var6 = true;
               if(var4 < var0.field878 || var4 > 2048 - var0.field878) {
                  var0.angle = var0.field876;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field877 > 25 || var6)) {
                  if(var0.field832 != -1) {
                     var0.poseAnimation = var0.field832;
                  } else {
                     var0.poseAnimation = var0.field833;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field877 = 0;
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)Ljava/lang/String;",
      garbageValue = "11"
   )
   static String method2352(Buffer var0, int var1) {
      try {
         int var2 = var0.method2554();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class145.field2223.method2498(var0.payload, var0.offset, var3, 0, var2);
         String var4 = class144.method3011(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }
}
