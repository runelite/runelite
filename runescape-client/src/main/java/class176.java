import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class176 {
   @ObfuscatedName("o")
   static int[][] field2241;
   @ObfuscatedName("p")
   static int[][] field2246;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1770049375
   )
   static int field2243;
   @ObfuscatedName("y")
   static int[] field2244;
   @ObfuscatedName("g")
   static int[] field2245;

   static {
      field2241 = new int[128][128];
      field2246 = new int[128][128];
      field2244 = new int[4096];
      field2245 = new int[4096];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lie;III)[Llv;",
      garbageValue = "-358112551"
   )
   static IndexedSprite[] method3425(IndexDataBase var0, int var1, int var2) {
      return !class258.method4705(var0, var1, var2)?null:CollisionData.method3419();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZB)V",
      garbageValue = "-1"
   )
   public static void method3424(String var0, boolean var1, boolean var2) {
      FrameMap.method2880(var0, var1, "openjs", var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "-56"
   )
   public static String method3426(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
            if(var4 == ' ') {
               var2.append('+');
            } else {
               byte var5 = class27.charToByteCp1252(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1252117464"
   )
   static final int method3421() {
      if(Client.preferences.hideRoofs) {
         return class230.plane;
      } else {
         int var0 = WorldMapType1.getTileHeight(class39.cameraX, CombatInfo1.cameraY, class230.plane);
         return var0 - class159.cameraZ < 800 && (class61.tileSettings[class230.plane][class39.cameraX >> 7][CombatInfo1.cameraY >> 7] & 4) != 0?class230.plane:3;
      }
   }
}
