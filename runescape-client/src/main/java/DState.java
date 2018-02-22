import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
@Implements("DState")
public final class DState {
   @ObfuscatedName("b")
   final int field2512;
   @ObfuscatedName("q")
   final int field2529;
   @ObfuscatedName("o")
   final int field2500;
   @ObfuscatedName("p")
   final int field2502;
   @ObfuscatedName("a")
   final int field2523;
   @ObfuscatedName("h")
   final int field2503;
   @ObfuscatedName("l")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1303986745
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -950036797
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("c")
   @Export("out")
   byte[] out;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1478485551
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1422650945
   )
   int field2509;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 258512033
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("v")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 962062829
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1517236197
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 212945829
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2012626887
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1223263189
   )
   int field2516;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1172242157
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -197413635
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("z")
   int[] field2519;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1084439735
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("k")
   int[] field2517;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 703406661
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("av")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ao")
   boolean[] field2524;
   @ObfuscatedName("am")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("aj")
   byte[] field2528;
   @ObfuscatedName("ah")
   int[] field2527;
   @ObfuscatedName("af")
   byte[] field2526;
   @ObfuscatedName("ai")
   byte[] field2504;
   @ObfuscatedName("aq")
   byte[][] field2530;
   @ObfuscatedName("ak")
   int[][] field2531;
   @ObfuscatedName("al")
   int[][] field2532;
   @ObfuscatedName("as")
   int[][] field2533;
   @ObfuscatedName("az")
   int[] field2534;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1224368515
   )
   int field2501;

   DState() {
      this.field2512 = 4096;
      this.field2529 = 16;
      this.field2500 = 258;
      this.field2502 = 6;
      this.field2523 = 50;
      this.field2503 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2519 = new int[256];
      this.field2517 = new int[257];
      this.inUse = new boolean[256];
      this.field2524 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2528 = new byte[4096];
      this.field2527 = new int[16];
      this.field2526 = new byte[18002];
      this.field2504 = new byte[18002];
      this.field2530 = new byte[6][258];
      this.field2531 = new int[6][258];
      this.field2532 = new int[6][258];
      this.field2533 = new int[6][258];
      this.field2534 = new int[6];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1970811397"
   )
   public static int method3524(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lee;IIIB)V",
      garbageValue = "115"
   )
   public static final void method3527(Model var0, int var1, int var2, int var3) {
      if(BaseVarType.boundingBox3DContainsMouse(var0, var1, var2, var3)) {
         class7.boundingBoxes.addFirst(new BoundingBox3D(var0, var1, var2, var3, -65281));
      } else if(BoundingBox3DDrawMode.ALWAYS == class7.boundingBox3DDrawMode) {
         class7.boundingBoxes.addFirst(new BoundingBox3D(var0, var1, var2, var3, -16776961));
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "518776551"
   )
   public static void method3525() {
      while(true) {
         Deque var1 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         FileSystem var0;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            var0 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_responseQueue.popFront();
         }

         if(var0 == null) {
            return;
         }

         var0.data.load(var0.index, (int)var0.hash, var0.field3316, false);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lie;Ljava/lang/String;Ljava/lang/String;I)[Llv;",
      garbageValue = "1792892118"
   )
   @Export("getIndexedSprites")
   public static IndexedSprite[] getIndexedSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class176.method3425(var0, var3, var4);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "-1616838247"
   )
   @Export("byteArrayToObject")
   public static Object byteArrayToObject(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.directBufferUnavailable) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.directBufferUnavailable = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "57"
   )
   static final void method3529() {
      Object var10000 = null;
      String var0 = "Your friend list is full. Max of 200 for free users, and 400 for members";
      class149.sendGameMessage(30, "", var0);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILca;ZB)I",
      garbageValue = "-41"
   )
   static int method3523(int var0, Script var1, boolean var2) {
      if(var0 == 3300) {
         class80.intStack[++class80.intStackSize - 1] = Client.gameCycle;
         return 1;
      } else {
         int var3;
         int var4;
         int[] var5;
         int var6;
         int var7;
         ItemContainer var8;
         if(var0 == 3301) {
            class80.intStackSize -= 2;
            var3 = class80.intStack[class80.intStackSize];
            var4 = class80.intStack[class80.intStackSize + 1];
            var5 = class80.intStack;
            var6 = ++class80.intStackSize - 1;
            var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
            if(var8 == null) {
               var7 = -1;
            } else if(var4 >= 0 && var4 < var8.itemIds.length) {
               var7 = var8.itemIds[var4];
            } else {
               var7 = -1;
            }

            var5[var6] = var7;
            return 1;
         } else if(var0 == 3302) {
            class80.intStackSize -= 2;
            var3 = class80.intStack[class80.intStackSize];
            var4 = class80.intStack[class80.intStackSize + 1];
            var5 = class80.intStack;
            var6 = ++class80.intStackSize - 1;
            var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
            if(var8 == null) {
               var7 = 0;
            } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
               var7 = var8.stackSizes[var4];
            } else {
               var7 = 0;
            }

            var5[var6] = var7;
            return 1;
         } else if(var0 == 3303) {
            class80.intStackSize -= 2;
            var3 = class80.intStack[class80.intStackSize];
            var4 = class80.intStack[class80.intStackSize + 1];
            var5 = class80.intStack;
            var6 = ++class80.intStackSize - 1;
            var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
            if(var8 == null) {
               var7 = 0;
            } else if(var4 == -1) {
               var7 = 0;
            } else {
               int var9 = 0;

               for(int var10 = 0; var10 < var8.stackSizes.length; ++var10) {
                  if(var4 == var8.itemIds[var10]) {
                     var9 += var8.stackSizes[var10];
                  }
               }

               var7 = var9;
            }

            var5[var6] = var7;
            return 1;
         } else {
            int var12;
            if(var0 == 3304) {
               var3 = class80.intStack[--class80.intStackSize];
               int[] var11 = class80.intStack;
               var12 = ++class80.intStackSize - 1;
               InvType var13 = (InvType)InvType.inventoryCache.get((long)var3);
               InvType var14;
               if(var13 != null) {
                  var14 = var13;
               } else {
                  byte[] var15 = InvType.field3384.getConfigData(5, var3);
                  var13 = new InvType();
                  if(var15 != null) {
                     var13.decode(new Buffer(var15));
                  }

                  InvType.inventoryCache.put(var13, (long)var3);
                  var14 = var13;
               }

               var11[var12] = var14.size;
               return 1;
            } else if(var0 == 3305) {
               var3 = class80.intStack[--class80.intStackSize];
               class80.intStack[++class80.intStackSize - 1] = Client.boostedSkillLevels[var3];
               return 1;
            } else if(var0 == 3306) {
               var3 = class80.intStack[--class80.intStackSize];
               class80.intStack[++class80.intStackSize - 1] = Client.realSkillLevels[var3];
               return 1;
            } else if(var0 == 3307) {
               var3 = class80.intStack[--class80.intStackSize];
               class80.intStack[++class80.intStackSize - 1] = Client.skillExperiences[var3];
               return 1;
            } else if(var0 == 3308) {
               var3 = class230.plane;
               var4 = (OwnWorldComparator.localPlayer.x >> 7) + ScriptState.baseX;
               var12 = (OwnWorldComparator.localPlayer.y >> 7) + WorldMapType1.baseY;
               class80.intStack[++class80.intStackSize - 1] = (var4 << 14) + var12 + (var3 << 28);
               return 1;
            } else if(var0 == 3309) {
               var3 = class80.intStack[--class80.intStackSize];
               class80.intStack[++class80.intStackSize - 1] = var3 >> 14 & 16383;
               return 1;
            } else if(var0 == 3310) {
               var3 = class80.intStack[--class80.intStackSize];
               class80.intStack[++class80.intStackSize - 1] = var3 >> 28;
               return 1;
            } else if(var0 == 3311) {
               var3 = class80.intStack[--class80.intStackSize];
               class80.intStack[++class80.intStackSize - 1] = var3 & 16383;
               return 1;
            } else if(var0 == 3312) {
               class80.intStack[++class80.intStackSize - 1] = Client.isMembers?1:0;
               return 1;
            } else if(var0 == 3313) {
               class80.intStackSize -= 2;
               var3 = class80.intStack[class80.intStackSize] + 32768;
               var4 = class80.intStack[class80.intStackSize + 1];
               var5 = class80.intStack;
               var6 = ++class80.intStackSize - 1;
               var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
               if(var8 == null) {
                  var7 = -1;
               } else if(var4 >= 0 && var4 < var8.itemIds.length) {
                  var7 = var8.itemIds[var4];
               } else {
                  var7 = -1;
               }

               var5[var6] = var7;
               return 1;
            } else if(var0 != 3314) {
               if(var0 == 3315) {
                  class80.intStackSize -= 2;
                  var3 = class80.intStack[class80.intStackSize] + 32768;
                  var4 = class80.intStack[class80.intStackSize + 1];
                  class80.intStack[++class80.intStackSize - 1] = IndexFile.method3358(var3, var4);
                  return 1;
               } else if(var0 == 3316) {
                  if(Client.rights >= 2) {
                     class80.intStack[++class80.intStackSize - 1] = Client.rights;
                  } else {
                     class80.intStack[++class80.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3317) {
                  class80.intStack[++class80.intStackSize - 1] = Client.field836;
                  return 1;
               } else if(var0 == 3318) {
                  class80.intStack[++class80.intStackSize - 1] = Client.world;
                  return 1;
               } else if(var0 == 3321) {
                  class80.intStack[++class80.intStackSize - 1] = Client.energy;
                  return 1;
               } else if(var0 == 3322) {
                  class80.intStack[++class80.intStackSize - 1] = Client.weight;
                  return 1;
               } else if(var0 == 3323) {
                  if(Client.field1027) {
                     class80.intStack[++class80.intStackSize - 1] = 1;
                  } else {
                     class80.intStack[++class80.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3324) {
                  class80.intStack[++class80.intStackSize - 1] = Client.flags;
                  return 1;
               } else if(var0 == 3325) {
                  class80.intStackSize -= 4;
                  var3 = class80.intStack[class80.intStackSize];
                  var4 = class80.intStack[class80.intStackSize + 1];
                  var12 = class80.intStack[class80.intStackSize + 2];
                  var6 = class80.intStack[class80.intStackSize + 3];
                  var3 += var4 << 14;
                  var3 += var12 << 28;
                  var3 += var6;
                  class80.intStack[++class80.intStackSize - 1] = var3;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               class80.intStackSize -= 2;
               var3 = class80.intStack[class80.intStackSize] + 32768;
               var4 = class80.intStack[class80.intStackSize + 1];
               var5 = class80.intStack;
               var6 = ++class80.intStackSize - 1;
               var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
               if(var8 == null) {
                  var7 = 0;
               } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
                  var7 = var8.stackSizes[var4];
               } else {
                  var7 = 0;
               }

               var5[var6] = var7;
               return 1;
            }
         }
      }
   }
}
