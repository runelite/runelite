import java.lang.management.GarbageCollectorMXBean;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public final class class11 {
   @ObfuscatedName("y")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("r")
   @Export("underlayIds")
   static byte[][][] underlayIds;
   @ObfuscatedName("e")
   static final int[] field98 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("q")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("s")
   static int[] field100;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1528627443
   )
   static int field102 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("u")
   static final int[] field103 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("b")
   static final int[] field104 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("m")
   static final int[] field105 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("i")
   static boolean field106;
   @ObfuscatedName("f")
   static final int[] field107 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 252047475
   )
   static int field108 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("bk")
   static class184 field109;
   @ObfuscatedName("ph")
   static GarbageCollectorMXBean field110;
   @ObfuscatedName("w")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("k")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2608327
   )
   static int field115 = 99;
   @ObfuscatedName("z")
   static final int[] field116 = new int[]{16, 32, 64, 128};

   class11() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1114232946"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class48.plane][var0][var1];
      if(var2 == null) {
         class65.region.method1854(class48.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method2403(); null != var6; var6 = (Item)var2.method2398()) {
            ItemComposition var7 = PlayerComposition.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(null == var5) {
            class65.region.method1854(class48.plane, var0, var1);
         } else {
            var2.method2381(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method2403(); null != var6; var6 = (Item)var2.method2398()) {
               if(var6.id != var5.id) {
                  if(null == var11) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && null == var10) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class65.region.method1714(class48.plane, var0, var1, Renderable.method1883(64 + var0 * 128, 128 * var1 + 64, class48.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-388693929"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class60.method1146();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field546 = 0;
            Client.field312 = 0;
            Client.field313 = 0;
         }

         if(var0 != 20 && var0 != 40 && class167.field2308 != null) {
            class167.field2308.method2064();
            class167.field2308 = null;
         }

         if(Client.gameState == 25) {
            Client.field337 = 0;
            Client.field279 = 0;
            Client.field334 = 1;
            Client.field335 = 0;
            Client.field465 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class38.method761(class32.canvas, class174.field2628, Friend.field147, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class38.method761(class32.canvas, class174.field2628, Friend.field147, false, 4);
            } else if(class41.field845) {
               class41.field821 = null;
               class41.field820 = null;
               class41.field823 = null;
               class156.field2209 = null;
               class148.field2032 = null;
               class1.field11 = null;
               class41.field824 = null;
               class60.field1079 = null;
               class179.field2677 = null;
               class229.field3251 = null;
               class196.field2855 = null;
               class57.field1052 = null;
               class103.field1678 = null;
               class8.field70 = null;
               class5.field47 = null;
               class205.field3071 = null;
               class41.field829 = null;
               class41.field828 = null;
               class60.field1083 = null;
               class116.field1818 = null;
               class41.field847 = null;
               class41.field833 = null;
               class103.method1966(2);
               Renderable.method1875(true);
               class41.field845 = false;
            }
         } else {
            class38.method761(class32.canvas, class174.field2628, Friend.field147, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-2130147680"
   )
   public static boolean method169(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class114.field1785.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var10.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var3 = class100.method1930(class114.field1792, var2, new Object[]{(new URL(class114.field1792.getCodeBase(), var0)).toString()});
            return var3 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class114.field1792.getAppletContext().showDocument(new URL(class114.field1792.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class100.method1929(class114.field1792, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class114.field1792.getAppletContext().showDocument(new URL(class114.field1792.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
