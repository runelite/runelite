import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1043501435
   )
   int field1326;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1674261983
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2093607599
   )
   @Export("y")
   int y;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1466472931
   )
   int field1329;
   @ObfuscatedName("d")
   class85 field1330;
   @ObfuscatedName("k")
   class77 field1331;
   @ObfuscatedName("j")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("s")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("o")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("a")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("m")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("h")
   int[] field1338 = new int[5];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -107873261
   )
   int field1339 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2058871957
   )
   int field1340;
   @ObfuscatedName("i")
   boolean field1341;
   @ObfuscatedName("l")
   Tile field1342;
   @ObfuscatedName("n")
   boolean field1343;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 752494945
   )
   int field1344;
   @ObfuscatedName("cr")
   static Font field1346;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2033398055
   )
   int field1347;
   @ObfuscatedName("z")
   boolean field1348;
   @ObfuscatedName("kp")
   @Export("chatMessages")
   static ChatMessages chatMessages;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1692330935
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1215230511
   )
   int field1352;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1412050487
   )
   int field1353;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)LNPCComposition;",
      garbageValue = "-1047698106"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field2995.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3017.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(null != var2) {
            var1.method3704(new Buffer(var2));
         }

         var1.method3703();
         NPCComposition.field2995.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-213439466"
   )
   static final void method1549(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = var2 + 6;
      int var5 = class178.field2670.method3872(var0, 250);
      int var6 = class178.field2670.method3873(var0, 250) * 13;
      Rasterizer2D.method4020(var3 - var2, var4 - var2, var5 + var2 + var2, var6 + var2 + var2, 0);
      Rasterizer2D.method3997(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
      class178.field2670.method3866(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      NPC.method717(var3 - var2, var4 - var2, var2 + var2 + var5, var6 + var2 + var2);
      if(var1) {
         try {
            Graphics var7 = class157.canvas.getGraphics();
            class57.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var8) {
            class157.canvas.repaint();
         }
      } else {
         class165.method3119(var3, var4, var5, var6);
      }

   }

   Tile(int var1, int var2, int var3) {
      this.field1326 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)Z",
      garbageValue = "-205852319"
   )
   static boolean method1550(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  return false;
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               return false;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var1 * var5 + var10;
            if(var9 / var1 != var5) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "47"
   )
   public static boolean method1551(char var0) {
      return var0 >= 48 && var0 <= 57;
   }
}
