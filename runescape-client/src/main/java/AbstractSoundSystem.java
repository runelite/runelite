import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("y")
   @Export("audioHighMemory")
   public static boolean audioHighMemory;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ldw;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   @Export("soundTaskDataProvider")
   public static class101 soundTaskDataProvider;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 154503169
   )
   public static int field1569;
   @ObfuscatedName("i")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   TaskDataNode field1548;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1170429643
   )
   int field1554;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -6570495004137614929L
   )
   long field1555;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 420484273
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1479285537
   )
   int field1549;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1908854283
   )
   int field1558;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -1288993126797935761L
   )
   long field1559;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -886335685
   )
   int field1560;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1253356441
   )
   int field1561;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 600746353
   )
   int field1562;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 210073193047978725L
   )
   long field1563;
   @ObfuscatedName("a")
   boolean field1564;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -264447413
   )
   int field1566;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "[Ldt;"
   )
   TaskDataNode[] field1571;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "[Ldt;"
   )
   TaskDataNode[] field1568;

   protected AbstractSoundSystem() {
      this.field1554 = 32;
      this.field1555 = PendingSpawn.currentTimeMs();
      this.field1559 = 0L;
      this.field1560 = 0;
      this.field1561 = 0;
      this.field1562 = 0;
      this.field1563 = 0L;
      this.field1564 = true;
      this.field1566 = 0;
      this.field1571 = new TaskDataNode[8];
      this.field1568 = new TaskDataNode[8];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-89"
   )
   protected void vmethod2257() throws Exception {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "46"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2073280037"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("r")
   protected void write() throws Exception {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1633999190"
   )
   protected void close() {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1659429283"
   )
   protected void flush() throws Exception {
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Ldt;B)V",
      garbageValue = "91"
   )
   public final synchronized void method2248(TaskDataNode var1) {
      this.field1548 = var1;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "112"
   )
   public final synchronized void method2249() {
      if(this.samples != null) {
         long var1 = PendingSpawn.currentTimeMs();

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
            if(this.field1562 - var3 > this.field1560) {
               this.field1560 = this.field1562 - var3;
            }

            int var4 = this.field1558 + this.field1549;
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
                  this.field1558 = var4 - this.field1549;
               }
            }

            while(var3 < var4) {
               this.method2250(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1563) {
               if(!this.field1564) {
                  if(this.field1560 == 0 && this.field1561 == 0) {
                     this.close();
                     this.field1559 = var1 + 2000L;
                     return;
                  }

                  this.field1558 = Math.min(this.field1561, this.field1560);
                  this.field1561 = this.field1560;
               } else {
                  this.field1564 = false;
               }

               this.field1560 = 0;
               this.field1563 = 2000L + var1;
            }

            this.field1562 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1559 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1555) {
               var1 = this.field1555;
            }

            while(var1 > this.field1555 + 5000L) {
               this.method2274(256);
               this.field1555 += (long)(256000 / KeyFocusListener.sampleRate);
            }
         } catch (Exception var6) {
            this.field1555 = var1;
         }

      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1100681207"
   )
   public final void method2259() {
      this.field1564 = true;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1073152499"
   )
   @Export("tryFlush")
   public final synchronized void tryFlush() {
      this.field1564 = true;

      try {
         this.flush();
      } catch (Exception var2) {
         this.close();
         this.field1559 = PendingSpawn.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "89"
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
            class250.field3015.shutdownNow();
            class250.field3015 = null;
            task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "99"
   )
   final void method2274(int var1) {
      this.field1566 -= var1;
      if(this.field1566 < 0) {
         this.field1566 = 0;
      }

      if(this.field1548 != null) {
         this.field1548.vmethod4436(var1);
      }

   }

   @ObfuscatedName("ai")
   final void method2250(int[] var1, int var2) {
      int var3 = var2;
      if(audioHighMemory) {
         var3 = var2 << 1;
      }

      class205.method3963(var1, 0, var3);
      this.field1566 -= var2;
      if(this.field1548 != null && this.field1566 <= 0) {
         this.field1566 += KeyFocusListener.sampleRate >> 4;
         Preferences.method1698(this.field1548);
         this.method2255(this.field1548, this.field1548.vmethod2542());
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
                  TaskDataNode var11 = this.field1571[var7];

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
                           var11 = var11.field1640;
                        } else {
                           var11.field1639 = true;
                           int var13 = var11.vmethod4443();
                           var4 += var13;
                           if(var12 != null) {
                              var12.int1 += var13;
                           }

                           if(var4 >= this.field1554) {
                              break label104;
                           }

                           TaskDataNode var14 = var11.vmethod4438();
                           if(var14 != null) {
                              for(int var15 = var11.field1638; var14 != null; var14 = var11.vmethod4433()) {
                                 this.method2255(var14, var15 * var14.vmethod2542() >> 8);
                              }
                           }

                           TaskDataNode var18 = var11.field1640;
                           var11.field1640 = null;
                           if(var10 == null) {
                              this.field1571[var7] = var18;
                           } else {
                              var10.field1640 = var18;
                           }

                           if(var18 == null) {
                              this.field1568[var7] = var10;
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
            TaskDataNode var16 = this.field1571[var6];
            TaskDataNode[] var17 = this.field1571;
            this.field1568[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1640;
               var16.field1640 = null;
            }
         }
      }

      if(this.field1566 < 0) {
         this.field1566 = 0;
      }

      if(this.field1548 != null) {
         this.field1548.vmethod4435(var1, 0, var2);
      }

      this.field1555 = PendingSpawn.currentTimeMs();
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Ldt;II)V",
      garbageValue = "-1153781730"
   )
   final void method2255(TaskDataNode var1, int var2) {
      int var3 = var2 >> 5;
      TaskDataNode var4 = this.field1568[var3];
      if(var4 == null) {
         this.field1571[var3] = var1;
      } else {
         var4.field1640 = var1;
      }

      this.field1568[var3] = var1;
      var1.field1638 = var2;
   }
}
