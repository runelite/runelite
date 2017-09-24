import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 993034781
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("i")
   @Export("name")
   String name;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -61928167
   )
   @Export("world")
   int world;
   @ObfuscatedName("o")
   boolean field815;
   @ObfuscatedName("n")
   boolean field820;
   @ObfuscatedName("j")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -799134351
   )
   @Export("rank")
   int rank;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1604500707"
   )
   static void method1115(int var0, int var1, int var2, int var3) {
      for(class81 var4 = (class81)class81.field1334.getFront(); var4 != null; var4 = (class81)class81.field1334.getNext()) {
         if(var4.field1332 != -1 || var4.field1336 != null) {
            int var5 = 0;
            if(var1 > var4.field1335) {
               var5 += var1 - var4.field1335;
            } else if(var1 < var4.field1337) {
               var5 += var4.field1337 - var1;
            }

            if(var2 > var4.field1333) {
               var5 += var2 - var4.field1333;
            } else if(var2 < var4.field1328) {
               var5 += var4.field1328 - var2;
            }

            if(var5 - 64 <= var4.field1331 && Client.field1171 != 0 && var0 == var4.field1326) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field1331 - var5) * Client.field1171 / var4.field1331;
               if(var4.field1327 == null) {
                  if(var4.field1332 >= 0) {
                     SoundEffect var7 = SoundEffect.getTrack(class178.field2419, var4.field1332, 0);
                     if(var7 != null) {
                        class106 var8 = var7.method1943().method1984(class209.field2592);
                        class116 var9 = class116.method2130(var8, 100, var6);
                        var9.method2133(-1);
                        class33.field479.method1915(var9);
                        var4.field1327 = var9;
                     }
                  }
               } else {
                  var4.field1327.method2134(var6);
               }

               if(var4.field1338 == null) {
                  if(var4.field1336 != null && (var4.field1325 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field1336.length);
                     SoundEffect var12 = SoundEffect.getTrack(class178.field2419, var4.field1336[var11], 0);
                     if(var12 != null) {
                        class106 var13 = var12.method1943().method1984(class209.field2592);
                        class116 var10 = class116.method2130(var13, 100, var6);
                        var10.method2133(0);
                        class33.field479.method1915(var10);
                        var4.field1338 = var10;
                        var4.field1325 = var4.field1342 + (int)(Math.random() * (double)(var4.field1330 - var4.field1342));
                     }
                  }
               } else {
                  var4.field1338.method2134(var6);
                  if(!var4.field1338.linked()) {
                     var4.field1338 = null;
                  }
               }
            } else {
               if(var4.field1327 != null) {
                  class33.field479.method1880(var4.field1327);
                  var4.field1327 = null;
               }

               if(var4.field1338 != null) {
                  class33.field479.method1880(var4.field1338);
                  var4.field1338 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1692296457"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "28"
   )
   static final String method1117(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + getColTags('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + getColTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + getColTags(16776960) + var1 + "</col>");
   }
}
