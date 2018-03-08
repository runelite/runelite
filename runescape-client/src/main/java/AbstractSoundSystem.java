import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1292031391
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("b")
   @Export("audioHighMemory")
   public static boolean audioHighMemory;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ldh;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lcf;"
   )
   @Export("soundTaskDataProvider")
   static class101 soundTaskDataProvider;
   @ObfuscatedName("v")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ldo;"
   )
   TaskDataNode field1542;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1875376693
   )
   int field1543;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -6065173535750317565L
   )
   long field1546;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -814692235
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -469203287
   )
   int field1535;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1641027675
   )
   int field1541;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 5845031911777927327L
   )
   long field1548;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1968792841
   )
   int field1547;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1155451429
   )
   int field1550;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 521191711
   )
   int field1551;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -7811807144473672961L
   )
   long field1552;
   @ObfuscatedName("m")
   boolean field1555;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1959180947
   )
   int field1554;
   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "[Ldo;"
   )
   TaskDataNode[] field1553;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "[Ldo;"
   )
   TaskDataNode[] field1549;

   protected AbstractSoundSystem() {
      this.field1543 = 32;
      this.field1546 = WorldMapRegion.method465();
      this.field1548 = 0L;
      this.field1547 = 0;
      this.field1550 = 0;
      this.field1551 = 0;
      this.field1552 = 0L;
      this.field1555 = true;
      this.field1554 = 0;
      this.field1553 = new TaskDataNode[8];
      this.field1549 = new TaskDataNode[8];
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "833376500"
   )
   protected void vmethod2240() throws Exception {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "720557872"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("a")
   protected void write() throws Exception {
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   protected void close() {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1807576321"
   )
   protected void flush() throws Exception {
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Ldo;I)V",
      garbageValue = "1823418519"
   )
   public final synchronized void method2209(TaskDataNode var1) {
      this.field1542 = var1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2071754441"
   )
   public final synchronized void method2210() {
      if(this.samples != null) {
         long var1 = WorldMapRegion.method465();

         try {
            if(this.field1548 != 0L) {
               if(var1 < this.field1548) {
                  return;
               }

               this.create(this.offset);
               this.field1548 = 0L;
               this.field1555 = true;
            }

            int var3 = this.size();
            if(this.field1551 - var3 > this.field1547) {
               this.field1547 = this.field1551 - var3;
            }

            int var4 = this.field1535 + this.field1541;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.offset) {
               this.offset += 1024;
               if(this.offset > 16384) {
                  this.offset = 16384;
               }

               this.close();
               this.create(this.offset);
               var3 = 0;
               this.field1555 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1541 = var4 - this.field1535;
               }
            }

            while(var3 < var4) {
               this.method2215(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1552) {
               if(!this.field1555) {
                  if(this.field1547 == 0 && this.field1550 == 0) {
                     this.close();
                     this.field1548 = var1 + 2000L;
                     return;
                  }

                  this.field1541 = Math.min(this.field1550, this.field1547);
                  this.field1550 = this.field1547;
               } else {
                  this.field1555 = false;
               }

               this.field1547 = 0;
               this.field1552 = var1 + 2000L;
            }

            this.field1551 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1548 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1546) {
               var1 = this.field1546;
            }

            while(var1 > 5000L + this.field1546) {
               this.method2214(256);
               this.field1546 += (long)(256000 / sampleRate);
            }
         } catch (Exception var6) {
            this.field1546 = var1;
         }

      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "26471"
   )
   public final void method2211() {
      this.field1555 = true;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2127123800"
   )
   @Export("tryFlush")
   public final synchronized void tryFlush() {
      this.field1555 = true;

      try {
         this.flush();
      } catch (Exception var2) {
         this.close();
         this.field1548 = WorldMapRegion.method465() + 2000L;
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   @Export("shutdown")
   public final synchronized void shutdown() {
      if(task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == task.systems[var2]) {
               task.systems[var2] = null;
            }

            if(task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            CombatInfo1.field1203.shutdownNow();
            CombatInfo1.field1203 = null;
            task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1775631347"
   )
   final void method2214(int var1) {
      this.field1554 -= var1;
      if(this.field1554 < 0) {
         this.field1554 = 0;
      }

      if(this.field1542 != null) {
         this.field1542.vmethod4367(var1);
      }

   }

   @ObfuscatedName("an")
   final void method2215(int[] var1, int var2) {
      int var3 = var2;
      if(audioHighMemory) {
         var3 = var2 << 1;
      }

      class205.method3870(var1, 0, var3);
      this.field1554 -= var2;
      if(this.field1542 != null && this.field1554 <= 0) {
         this.field1554 += sampleRate >> 4;
         NetWriter.method2084(this.field1542);
         this.method2237(this.field1542, this.field1542.vmethod2489());
         int var4 = 0;
         int var5 = 255;

         int var6;
         TaskDataNode var10;
         label104:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var8;
            if(var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  TaskDataNode var11 = this.field1553[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        AbstractIntegerNode0 var12 = var11.data;
                        if(var12 != null && var12.int1 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1627;
                        } else {
                           var11.field1628 = true;
                           int var13 = var11.vmethod4363();
                           var4 += var13;
                           if(var12 != null) {
                              var12.int1 += var13;
                           }

                           if(var4 >= this.field1543) {
                              break label104;
                           }

                           TaskDataNode var14 = var11.vmethod4354();
                           if(var14 != null) {
                              for(int var15 = var11.field1626; var14 != null; var14 = var11.vmethod4356()) {
                                 this.method2237(var14, var15 * var14.vmethod2489() >> 8);
                              }
                           }

                           TaskDataNode var18 = var11.field1627;
                           var11.field1627 = null;
                           if(var10 == null) {
                              this.field1553[var7] = var18;
                           } else {
                              var10.field1627 = var18;
                           }

                           if(var18 == null) {
                              this.field1549[var7] = var10;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            TaskDataNode var16 = this.field1553[var6];
            TaskDataNode[] var17 = this.field1553;
            this.field1549[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1627;
               var16.field1627 = null;
            }
         }
      }

      if(this.field1554 < 0) {
         this.field1554 = 0;
      }

      if(this.field1542 != null) {
         this.field1542.vmethod4357(var1, 0, var2);
      }

      this.field1546 = WorldMapRegion.method465();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Ldo;II)V",
      garbageValue = "-1426346280"
   )
   final void method2237(TaskDataNode var1, int var2) {
      int var3 = var2 >> 5;
      TaskDataNode var4 = this.field1549[var3];
      if(var4 == null) {
         this.field1553[var3] = var1;
      } else {
         var4.field1627 = var1;
      }

      this.field1549[var3] = var1;
      var1.field1626 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljc;Ljc;ZI)V",
      garbageValue = "-1239470758"
   )
   public static void method2217(IndexDataBase var0, IndexDataBase var1, boolean var2) {
      ObjectComposition.objects_ref = var0;
      class21.field315 = var1;
      ObjectComposition.objectCompositionLowDetail = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljc;Ljc;III)Lkm;",
      garbageValue = "2087319744"
   )
   public static Font method2222(IndexDataBase var0, IndexDataBase var1, int var2, int var3) {
      byte[] var5 = var0.getConfigData(var2, var3);
      boolean var4;
      if(var5 == null) {
         var4 = false;
      } else {
         Widget.decodeSprite(var5);
         var4 = true;
      }

      if(!var4) {
         return null;
      } else {
         byte[] var6 = var1.getConfigData(var2, var3);
         Font var8;
         if(var6 == null) {
            var8 = null;
         } else {
            Font var7 = new Font(var6, class90.field1360, class153.offsetsY, class332.field3998, GrandExchangeOffer.field294, class332.field3994, ClassInfo.spritePixels);
            class316.method5605();
            var8 = var7;
         }

         return var8;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILcj;ZB)I",
      garbageValue = "-104"
   )
   static int method2265(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = GZipDecompressor.getWidget(class81.intStack[--class5.intStackSize]);
      } else {
         var3 = var2?class233.field2755:class81.field1260;
      }

      GameEngine.method1053(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class81.intStack[--class5.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = WorldMapData.localPlayer.composition.method4421();
            return 1;
         } else {
            return 2;
         }
      } else {
         class5.intStackSize -= 2;
         int var4 = class81.intStack[class5.intStackSize];
         int var5 = class81.intStack[class5.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = class81.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2866 = var6.offsetX2d;
         var3.field2867 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2864 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2864 = 1;
         } else {
            var3.field2864 = 2;
         }

         if(var3.field2872 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2872;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-120597163"
   )
   static final void method2255() {
      if(ScriptState.field726) {
         if(KeyFocusListener.clanMemberManager != null) {
            KeyFocusListener.clanMemberManager.method5309();
         }

         class2.method3();
         ScriptState.field726 = false;
      }

   }
}
