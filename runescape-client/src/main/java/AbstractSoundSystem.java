import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -49008765
   )
   static int field1570;
   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("slArrowSprites")
   static IndexedSprite[] slArrowSprites;
   @ObfuscatedName("f")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   TaskDataNode field1558;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 348900291
   )
   int field1554;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -9004924527589112047L
   )
   long field1552;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1971373207
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 948907977
   )
   int field1557;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1569816935
   )
   int field1568;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -749210233094854601L
   )
   long field1559;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1806312647
   )
   int field1560;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1795134217
   )
   int field1555;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -164000139
   )
   int field1553;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 1696478325313020335L
   )
   long field1562;
   @ObfuscatedName("s")
   boolean field1564;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 351115127
   )
   int field1565;
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "[Ldd;"
   )
   TaskDataNode[] field1566;
   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "[Ldd;"
   )
   TaskDataNode[] field1567;

   protected AbstractSoundSystem() {
      this.field1554 = 32;
      this.field1552 = ScriptVarType.method28();
      this.field1559 = 0L;
      this.field1560 = 0;
      this.field1555 = 0;
      this.field1553 = 0;
      this.field1562 = 0L;
      this.field1564 = true;
      this.field1565 = 0;
      this.field1566 = new TaskDataNode[8];
      this.field1567 = new TaskDataNode[8];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-107585878"
   )
   protected void vmethod2197() throws Exception {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1217716284"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "612355067"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("j")
   protected void write() throws Exception {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1735771835"
   )
   protected void close() {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "21985"
   )
   protected void flush() throws Exception {
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ldd;I)V",
      garbageValue = "282833705"
   )
   public final synchronized void method2189(TaskDataNode var1) {
      this.field1558 = var1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-117231693"
   )
   public final synchronized void method2222() {
      if(this.samples != null) {
         long var1 = ScriptVarType.method28();

         try {
            if(this.field1559 != 0L) {
               if(var1 < this.field1559) {
                  return;
               }

               this.create(this.offset);
               this.field1559 = 0L;
               this.field1564 = true;
            }

            int var3 = this.size();
            if(this.field1553 - var3 > this.field1560) {
               this.field1560 = this.field1553 - var3;
            }

            int var4 = this.field1557 + this.field1568;
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
               this.field1564 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1568 = var4 - this.field1557;
               }
            }

            while(var3 < var4) {
               this.method2233(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1562) {
               if(!this.field1564) {
                  if(this.field1560 == 0 && this.field1555 == 0) {
                     this.close();
                     this.field1559 = var1 + 2000L;
                     return;
                  }

                  this.field1568 = Math.min(this.field1555, this.field1560);
                  this.field1555 = this.field1560;
               } else {
                  this.field1564 = false;
               }

               this.field1560 = 0;
               this.field1562 = var1 + 2000L;
            }

            this.field1553 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1559 = var1 + 2000L;
         }

         try {
            if(var1 > this.field1552 + 500000L) {
               var1 = this.field1552;
            }

            while(var1 > this.field1552 + 5000L) {
               this.method2194(256);
               this.field1552 += (long)(256000 / class317.sampleRate);
            }
         } catch (Exception var6) {
            this.field1552 = var1;
         }

      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2062432065"
   )
   public final void method2191() {
      this.field1564 = true;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-828022911"
   )
   @Export("tryFlush")
   public final synchronized void tryFlush() {
      this.field1564 = true;

      try {
         this.flush();
      } catch (Exception var2) {
         this.close();
         this.field1559 = ScriptVarType.method28() + 2000L;
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1671586360"
   )
   @Export("shutdown")
   public final synchronized void shutdown() {
      if(class27.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class27.task.systems[var2]) {
               class27.task.systems[var2] = null;
            }

            if(class27.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class57.field654.shutdownNow();
            class57.field654 = null;
            class27.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "8"
   )
   final void method2194(int var1) {
      this.field1565 -= var1;
      if(this.field1565 < 0) {
         this.field1565 = 0;
      }

      if(this.field1558 != null) {
         this.field1558.vmethod4340(var1);
      }

   }

   @ObfuscatedName("aa")
   final void method2233(int[] var1, int var2) {
      int var3 = var2;
      if(UnitPriceComparator.audioHighMemory) {
         var3 = var2 << 1;
      }

      class205.method3854(var1, 0, var3);
      this.field1565 -= var2;
      if(this.field1558 != null && this.field1565 <= 0) {
         this.field1565 += class317.sampleRate >> 4;
         class85.method1842(this.field1558);
         this.method2196(this.field1558, this.field1558.vmethod2472());
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
                  TaskDataNode var11 = this.field1566[var7];

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
                           var11 = var11.field1639;
                        } else {
                           var11.field1638 = true;
                           int var13 = var11.vmethod4338();
                           var4 += var13;
                           if(var12 != null) {
                              var12.int1 += var13;
                           }

                           if(var4 >= this.field1554) {
                              break label104;
                           }

                           TaskDataNode var14 = var11.vmethod4336();
                           if(var14 != null) {
                              for(int var15 = var11.field1640; var14 != null; var14 = var11.vmethod4337()) {
                                 this.method2196(var14, var15 * var14.vmethod2472() >> 8);
                              }
                           }

                           TaskDataNode var18 = var11.field1639;
                           var11.field1639 = null;
                           if(var10 == null) {
                              this.field1566[var7] = var18;
                           } else {
                              var10.field1639 = var18;
                           }

                           if(var18 == null) {
                              this.field1567[var7] = var10;
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
            TaskDataNode var16 = this.field1566[var6];
            TaskDataNode[] var17 = this.field1566;
            this.field1567[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1639;
               var16.field1639 = null;
            }
         }
      }

      if(this.field1565 < 0) {
         this.field1565 = 0;
      }

      if(this.field1558 != null) {
         this.field1558.vmethod4339(var1, 0, var2);
      }

      this.field1552 = ScriptVarType.method28();
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Ldd;II)V",
      garbageValue = "-1325832273"
   )
   final void method2196(TaskDataNode var1, int var2) {
      int var3 = var2 >> 5;
      TaskDataNode var4 = this.field1567[var3];
      if(var4 == null) {
         this.field1566[var3] = var1;
      } else {
         var4.field1639 = var1;
      }

      this.field1567[var3] = var1;
      var1.field1640 = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljs;II)V",
      garbageValue = "-1902848877"
   )
   static void method2241(IndexData var0, int var1) {
      if(class264.NetCache_reference != null) {
         class264.NetCache_reference.offset = var1 * 8 + 5;
         int var2 = class264.NetCache_reference.readInt();
         int var3 = class264.NetCache_reference.readInt();
         var0.setInformation(var2, var3);
      } else {
         Frames.requestNetFile((IndexData)null, 255, 255, 0, (byte)0, true);
         class264.NetCache_indexCaches[var1] = var0;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)[Llt;",
      garbageValue = "-2132299585"
   )
   public static class329[] method2198() {
      return new class329[]{class329.field3966, class329.field3965, class329.field3963, class329.field3964, class329.field3962};
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "-833566027"
   )
   static int method2188(int var0, Script var1, boolean var2) {
      if(var0 == 5630) {
         Client.field903 = 250;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(Lbg;IB)V",
      garbageValue = "31"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      Player.worldToScreen(var0.x, var0.y, var1);
   }
}
