import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1953922609
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lda;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   static JagexGame field1553;
   @ObfuscatedName("f")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ldb;"
   )
   TaskDataNode field1545;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1685661295
   )
   int field1541;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -1854317018751269611L
   )
   long field1547;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 115768663
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 933828139
   )
   int field1549;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1669092149
   )
   int field1562;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 7718671973033651295L
   )
   long field1551;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1337481377
   )
   int field1552;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -766408087
   )
   int field1550;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2063938765
   )
   int field1554;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 1091774419264358171L
   )
   long field1555;
   @ObfuscatedName("a")
   boolean field1548;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1562220637
   )
   int field1558;
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "[Ldb;"
   )
   TaskDataNode[] field1559;
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "[Ldb;"
   )
   TaskDataNode[] field1560;

   protected AbstractSoundSystem() {
      this.field1541 = 32;
      this.field1547 = SceneTilePaint.currentTimeMs();
      this.field1551 = 0L;
      this.field1552 = 0;
      this.field1550 = 0;
      this.field1554 = 0;
      this.field1555 = 0L;
      this.field1548 = true;
      this.field1558 = 0;
      this.field1559 = new TaskDataNode[8];
      this.field1560 = new TaskDataNode[8];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1245857206"
   )
   protected void vmethod2282() throws Exception {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2092615115"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2031484234"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("h")
   protected void write() throws Exception {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-195662644"
   )
   protected void close() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1001891710"
   )
   protected void flush() throws Exception {
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Ldb;S)V",
      garbageValue = "26701"
   )
   public final synchronized void method2293(TaskDataNode var1) {
      this.field1545 = var1;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-24"
   )
   public final synchronized void method2262() {
      if(this.samples != null) {
         long var1 = SceneTilePaint.currentTimeMs();

         try {
            if(this.field1551 != 0L) {
               if(var1 < this.field1551) {
                  return;
               }

               this.create(this.offset);
               this.field1551 = 0L;
               this.field1548 = true;
            }

            int var3 = this.size();
            if(this.field1554 - var3 > this.field1552) {
               this.field1552 = this.field1554 - var3;
            }

            int var4 = this.field1549 + this.field1562;
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
               this.field1548 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1562 = var4 - this.field1549;
               }
            }

            while(var3 < var4) {
               this.method2267(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1555) {
               if(!this.field1548) {
                  if(this.field1552 == 0 && this.field1550 == 0) {
                     this.close();
                     this.field1551 = 2000L + var1;
                     return;
                  }

                  this.field1562 = Math.min(this.field1550, this.field1552);
                  this.field1550 = this.field1552;
               } else {
                  this.field1548 = false;
               }

               this.field1552 = 0;
               this.field1555 = 2000L + var1;
            }

            this.field1554 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1551 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1547) {
               var1 = this.field1547;
            }

            while(var1 > this.field1547 + 5000L) {
               this.method2266(256);
               this.field1547 += (long)(256000 / sampleRate);
            }
         } catch (Exception var6) {
            this.field1547 = var1;
         }

      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2076439895"
   )
   public final void method2263() {
      this.field1548 = true;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1457848397"
   )
   @Export("tryFlush")
   public final synchronized void tryFlush() {
      this.field1548 = true;

      try {
         this.flush();
      } catch (Exception var2) {
         this.close();
         this.field1551 = SceneTilePaint.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "571843562"
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
            SoundTask.field1574.shutdownNow();
            SoundTask.field1574 = null;
            task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-86"
   )
   final void method2266(int var1) {
      this.field1558 -= var1;
      if(this.field1558 < 0) {
         this.field1558 = 0;
      }

      if(this.field1545 != null) {
         this.field1545.vmethod4315(var1);
      }

   }

   @ObfuscatedName("ak")
   final void method2267(int[] var1, int var2) {
      int var3 = var2;
      if(CombatInfo1.audioHighMemory) {
         var3 = var2 << 1;
      }

      class194.method3882(var1, 0, var3);
      this.field1558 -= var2;
      if(this.field1545 != null && this.field1558 <= 0) {
         this.field1558 += sampleRate >> 4;
         class25.method184(this.field1545);
         this.method2264(this.field1545, this.field1545.vmethod2558());
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
                  TaskDataNode var11 = this.field1559[var7];

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
                           int var13 = var11.vmethod4313();
                           var4 += var13;
                           if(var12 != null) {
                              var12.int1 += var13;
                           }

                           if(var4 >= this.field1541) {
                              break label104;
                           }

                           TaskDataNode var14 = var11.vmethod4311();
                           if(var14 != null) {
                              for(int var15 = var11.field1625; var14 != null; var14 = var11.vmethod4312()) {
                                 this.method2264(var14, var15 * var14.vmethod2558() >> 8);
                              }
                           }

                           TaskDataNode var18 = var11.field1627;
                           var11.field1627 = null;
                           if(var10 == null) {
                              this.field1559[var7] = var18;
                           } else {
                              var10.field1627 = var18;
                           }

                           if(var18 == null) {
                              this.field1560[var7] = var10;
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
            TaskDataNode var16 = this.field1559[var6];
            TaskDataNode[] var17 = this.field1559;
            this.field1560[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1627;
               var16.field1627 = null;
            }
         }
      }

      if(this.field1558 < 0) {
         this.field1558 = 0;
      }

      if(this.field1545 != null) {
         this.field1545.vmethod4314(var1, 0, var2);
      }

      this.field1547 = SceneTilePaint.currentTimeMs();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Ldb;II)V",
      garbageValue = "-481169694"
   )
   final void method2264(TaskDataNode var1, int var2) {
      int var3 = var2 >> 5;
      TaskDataNode var4 = this.field1560[var3];
      if(var4 == null) {
         this.field1559[var3] = var1;
      } else {
         var4.field1627 = var1;
      }

      this.field1560[var3] = var1;
      var1.field1625 = var2;
   }
}
