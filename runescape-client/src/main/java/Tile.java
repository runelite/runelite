import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ldo;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 522504713
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Lem;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -221732423
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ldf;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("i")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("bridge")
   Tile bridge;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1137641357
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1082202281
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("a")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1617720745
   )
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1965362807
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1355594373
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("e")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 798838591
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("v")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -398219749
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1177383225
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2132972443
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.entityFlags = new int[5];
      this.flags = 0;
      this.renderLevel = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1912169005"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Z",
      garbageValue = "121"
   )
   static boolean method2522(String var0, int var1) {
      return class9.method43(var0, var1, "openjs");
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIILez;[Lfc;B)V",
      garbageValue = "3"
   )
   static final void method2521(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
      Buffer var5 = new Buffer(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.getUSmart();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.getUSmart();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.readUnsignedByte();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var11 + var1;
            int var17 = var10 + var2;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class61.tileSettings[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               CollisionData var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               class89.addObject(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "([BII)V",
      garbageValue = "1771357207"
   )
   static void method2520(byte[] var0, int var1) {
      if(Client.field971 == null) {
         Client.field971 = new byte[24];
      }

      class184.method3463(var0, var1, Client.field971, 0, 24);
   }
}
