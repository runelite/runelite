import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public final class class61 {
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -1686983529
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("d")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("x")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2106256943
   )
   static int field735;
   @ObfuscatedName("z")
   static byte[][][] field724;
   @ObfuscatedName("v")
   static byte[][][] field736;
   @ObfuscatedName("b")
   static byte[][][] field726;
   @ObfuscatedName("p")
   static int[][] field727;
   @ObfuscatedName("e")
   static final int[] field733;
   @ObfuscatedName("q")
   static final int[] field729;
   @ObfuscatedName("h")
   static final int[] field730;
   @ObfuscatedName("i")
   static final int[] field731;
   @ObfuscatedName("o")
   static final int[] field723;
   @ObfuscatedName("w")
   static final int[] field721;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1322611983
   )
   static int field734;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -419170897
   )
   static int field725;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1034761493
   )
   static int field737;
   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   static BuildType field738;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field735 = 99;
      field733 = new int[]{1, 2, 4, 8};
      field729 = new int[]{16, 32, 64, 128};
      field730 = new int[]{1, 0, -1, 0};
      field731 = new int[]{0, -1, 0, 1};
      field723 = new int[]{1, -1, -1, 1};
      field721 = new int[]{-1, -1, 1, 1};
      field734 = (int)(Math.random() * 17.0D) - 8;
      field725 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lid;Lid;Lid;Lhf;B)Z",
      garbageValue = "1"
   )
   public static boolean method1051(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, class211 var3) {
      class210.field2596 = var0;
      class210.field2594 = var1;
      class210.field2597 = var2;
      class210.field2595 = var3;
      return true;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Lil;",
      garbageValue = "122819955"
   )
   public static Varbit method1089(int var0) {
      Varbit var1 = (Varbit)Varbit.varbits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Varbit.varbit_ref.getConfigData(14, var0);
         var1 = new Varbit();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Varbit.varbits.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1595901462"
   )
   public static void method1088() {
      while(true) {
         Deque var1 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         FileSystem var0;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            var0 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_responseQueue.popFront();
         }

         if(var0 == null) {
            return;
         }

         var0.data.load(var0.index, (int)var0.hash, var0.field3280, false);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)[Liu;",
      garbageValue = "-421559085"
   )
   public static Permission[] method1087() {
      return new Permission[]{Permission.field3255, Permission.field3254, Permission.field3256, Permission.field3250, Permission.field3253, Permission.field3252};
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-61950471"
   )
   static final void method1085(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != class233.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = GrandExchangeEvent.region.method2823(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = GrandExchangeEvent.region.method2903(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = GrandExchangeEvent.region.method2825(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = GrandExchangeEvent.region.method2826(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = GrandExchangeEvent.region.getObjectFlags(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               GrandExchangeEvent.region.removeBoundaryObject(var0, var2, var3);
               var12 = class3.getObjectDefinition(var13);
               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var14, var15, var12.boolean1);
               }
            }

            if(var1 == 1) {
               GrandExchangeEvent.region.removeWallDecoration(var0, var2, var3);
            }

            if(var1 == 2) {
               GrandExchangeEvent.region.method2816(var0, var2, var3);
               var12 = class3.getObjectDefinition(var13);
               if(var2 + var12.sizeX > 103 || var3 + var12.sizeX > 103 || var2 + var12.sizeY > 103 || var3 + var12.sizeY > 103) {
                  return;
               }

               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.sizeX, var12.sizeY, var15, var12.boolean1);
               }
            }

            if(var1 == 3) {
               GrandExchangeEvent.region.removeFloorDecoration(var0, var2, var3);
               var12 = class3.getObjectDefinition(var13);
               if(var12.interactType == 1) {
                  Client.collisionMaps[var0].method3156(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class86.method1750(var0, var11, var2, var3, var4, var5, var6, GrandExchangeEvent.region, Client.collisionMaps[var0]);
         }
      }

   }
}
