import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("t")
   static byte[][][] field745;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("listFetcher")
   static UrlRequest listFetcher;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lce;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 63878031
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("k")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("z")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Liw;",
      garbageValue = "-1306658854"
   )
   @Export("getUnderlayDefinition")
   public static FloorUnderlayDefinition getUnderlayDefinition(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.underlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class54.underlay_ref.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         FloorUnderlayDefinition.underlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-7"
   )
   static synchronized void method1095(byte[] var0) {
      if(var0.length == 100 && class181.field2508 < 1000) {
         class181.field2503[++class181.field2508 - 1] = var0;
      } else if(var0.length == 5000 && class181.field2501 < 250) {
         class181.field2507[++class181.field2501 - 1] = var0;
      } else if(var0.length == 30000 && class181.field2502 < 50) {
         class181.field2505[++class181.field2502 - 1] = var0;
      } else {
         if(class181.field2509 != null) {
            for(int var1 = 0; var1 < class3.field23.length; ++var1) {
               if(var0.length == class3.field23[var1] && class181.field2504[var1] < class181.field2509[var1].length) {
                  class181.field2509[var1][class181.field2504[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(B)Lko;",
      garbageValue = "-15"
   )
   static RenderOverview method1094() {
      return MouseInput.renderOverview;
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lhx;I)Ljava/lang/String;",
      garbageValue = "1543891432"
   )
   static String method1091(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         for(int var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = CacheFile.method2441(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }
      }

      return var0;
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(IIIILky;Lhl;B)V",
      garbageValue = "15"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class217 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var3 * var8 + var9 * var2 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5293(var10 + var5.field2683 / 2 - var4.maxWidth / 2, var5.field2682 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2683, var5.field2682, var5.field2684, var5.field2681);
            } else {
               var4.drawAt(var0 + var10 + var5.field2683 / 2 - var4.maxWidth / 2, var5.field2682 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }

   @ObfuscatedName("ki")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "1425114357"
   )
   static String method1090(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(Preferences.sessionToken != null) {
         var3 = "/p=" + Preferences.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + class29.field397 + var3 + "/";
   }
}
