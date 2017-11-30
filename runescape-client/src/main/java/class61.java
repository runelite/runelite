import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public final class class61 {
   @ObfuscatedName("qw")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("a")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("w")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2012572909
   )
   static int field694;
   @ObfuscatedName("k")
   static byte[][][] field693;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 565582015
   )
   public static int field692;
   @ObfuscatedName("g")
   static int[][] field696;
   @ObfuscatedName("j")
   static int[] field697;
   @ObfuscatedName("x")
   static int[] field698;
   @ObfuscatedName("s")
   static int[] field699;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("currentRequest")
   public static FileRequest currentRequest;
   @ObfuscatedName("l")
   static final int[] field701;
   @ObfuscatedName("m")
   static final int[] field703;
   @ObfuscatedName("q")
   static final int[] field704;
   @ObfuscatedName("b")
   static final int[] field702;
   @ObfuscatedName("h")
   static final int[] field705;
   @ObfuscatedName("d")
   static final int[] field706;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 584074055
   )
   static int field707;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 459242055
   )
   static int field708;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      longValue = -4223808054581464677L
   )
   static long field709;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field694 = 99;
      field701 = new int[]{1, 2, 4, 8};
      field703 = new int[]{16, 32, 64, 128};
      field704 = new int[]{1, 0, -1, 0};
      field702 = new int[]{0, -1, 0, 1};
      field705 = new int[]{1, -1, -1, 1};
      field706 = new int[]{-1, -1, 1, 1};
      field707 = (int)(Math.random() * 17.0D) - 8;
      field708 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1237725702"
   )
   public static final void method1021(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.min(var3, Math.min(var4, var5)) - var6;
      int var8 = Math.max(var3, Math.max(var4, var5)) + var6;
      int var9 = Math.min(var0, Math.min(var1, var2)) - var6;
      int var10 = Math.max(var0, Math.max(var1, var2)) + var6;
      class7.boundingBoxes.addFirst(new BoundingBox2D(var7, var9, var8, var10, -49088));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "1279275627"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class94.field1391[++class94.field1400 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field814 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class94.Players_regions[var1] = (var4.field821 << 28) + (class46.baseX + var4.pathX[0] >> 13 << 14) + (Client.baseY + var4.pathY[0] >> 13);
            if(var4.field1150 != -1) {
               class94.Players_orientations[var1] = var4.field1150;
            } else {
               class94.Players_orientations[var1] = var4.orientation;
            }

            class94.Players_targetIndices[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               class86.decodeRegionHash(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.getBits(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1082(var6, var7);
               var4.field814 = false;
            } else if(var2) {
               var4.field814 = true;
               var4.field833 = var6;
               var4.field834 = var7;
            } else {
               var4.field814 = false;
               var4.method1085(var6, var7, class94.field1388[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.getBits(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field814 = true;
                  var4.field833 = var6;
                  var4.field834 = var7;
               } else {
                  var4.field814 = false;
                  var4.method1085(var6, var7, class94.field1388[var1]);
               }
            } else {
               var4.method1082(var6, var7);
               var4.field814 = false;
            }

         } else {
            var5 = var0.getBits(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.getBits(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field814 = true;
                     var4.field833 = var10;
                     var4.field834 = var11;
                  } else {
                     var4.field814 = false;
                     var4.method1085(var10, var11, class94.field1388[var1]);
                  }
               } else {
                  var4.method1082(var10, var11);
                  var4.field814 = false;
               }

               var4.field821 = (byte)(var7 + var4.field821 & 3);
               if(Client.localInteractingIndex == var1) {
                  BoundingBox2D.plane = var4.field821;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class46.baseX + var4.pathX[0] & 16383) - class46.baseX;
               var11 = (var9 + Client.baseY + var4.pathY[0] & 16383) - Client.baseY;
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1082(var10, var11);
                  var4.field814 = false;
               } else if(var2) {
                  var4.field814 = true;
                  var4.field833 = var10;
                  var4.field834 = var11;
               } else {
                  var4.field814 = false;
                  var4.method1085(var10, var11, class94.field1388[var1]);
               }

               var4.field821 = (byte)(var7 + var4.field821 & 3);
               if(Client.localInteractingIndex == var1) {
                  BoundingBox2D.plane = var4.field821;
               }

            }
         }
      }
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "994058606"
   )
   static final void method1018(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(GraphicsObject.loadWidget(var0)) {
         class3.field17 = null;
         class82.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class3.field17 != null) {
            class82.gameDraw(class3.field17, -1412584499, var1, var2, var3, var4, class81.field1222, class186.field2526, var7);
            class3.field17 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1033[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1033[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "795956452"
   )
   static final String method1015(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + Buffer.getColTags(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + Buffer.getColTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + Buffer.getColTags(16776960) + var1 + "</col>");
   }
}
