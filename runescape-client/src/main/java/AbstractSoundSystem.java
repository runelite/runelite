import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("ny")
   @ObfuscatedSignature(
      signature = "[Lbr;"
   )
   @Export("clanMembers")
   static ClanMember[] clanMembers;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 956408751
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 896619963
   )
   @Export("priority")
   public static int priority;
   @ObfuscatedName("w")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   TaskDataNode field1542;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1708293273
   )
   int field1543;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 7140468744731449599L
   )
   long field1549;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 948189211
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -545799503
   )
   int field1546;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1163118943
   )
   int field1547;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 413189105346987989L
   )
   long field1548;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 908103895
   )
   int field1544;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2029734851
   )
   int field1557;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1612822349
   )
   int field1551;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -7274072909264329991L
   )
   long field1538;
   @ObfuscatedName("q")
   boolean field1553;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1182601005
   )
   int field1554;
   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "[Ldk;"
   )
   TaskDataNode[] field1552;
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "[Ldk;"
   )
   TaskDataNode[] field1556;

   protected AbstractSoundSystem() {
      this.field1543 = 32;
      this.field1549 = class60.currentTimeMs();
      this.field1548 = 0L;
      this.field1544 = 0;
      this.field1557 = 0;
      this.field1551 = 0;
      this.field1538 = 0L;
      this.field1553 = true;
      this.field1554 = 0;
      this.field1552 = new TaskDataNode[8];
      this.field1556 = new TaskDataNode[8];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2071014398"
   )
   protected void vmethod2091() throws Exception {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-3112"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1441335077"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("r")
   protected void write() throws Exception {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1628319647"
   )
   protected void close() {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-118"
   )
   protected void flush() throws Exception {
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Ldk;B)V",
      garbageValue = "-95"
   )
   public final synchronized void method2063(TaskDataNode var1) {
      this.field1542 = var1;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "183615261"
   )
   public final synchronized void method2078() {
      if(this.samples != null) {
         long var1 = class60.currentTimeMs();

         try {
            if(0L != this.field1548) {
               if(var1 < this.field1548) {
                  return;
               }

               this.create(this.offset);
               this.field1548 = 0L;
               this.field1553 = true;
            }

            int var3 = this.size();
            if(this.field1551 - var3 > this.field1544) {
               this.field1544 = this.field1551 - var3;
            }

            int var4 = this.field1546 + this.field1547;
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
               this.field1553 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1547 = var4 - this.field1546;
               }
            }

            while(var3 < var4) {
               this.method2102(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1538) {
               if(!this.field1553) {
                  if(this.field1544 == 0 && this.field1557 == 0) {
                     this.close();
                     this.field1548 = var1 + 2000L;
                     return;
                  }

                  this.field1547 = Math.min(this.field1557, this.field1544);
                  this.field1557 = this.field1544;
               } else {
                  this.field1553 = false;
               }

               this.field1544 = 0;
               this.field1538 = 2000L + var1;
            }

            this.field1551 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1548 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1549) {
               var1 = this.field1549;
            }

            while(var1 > 5000L + this.field1549) {
               this.method2068(256);
               this.field1549 += (long)(256000 / sampleRate);
            }
         } catch (Exception var6) {
            this.field1549 = var1;
         }

      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-379274694"
   )
   public final void method2065() {
      this.field1553 = true;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1093441803"
   )
   @Export("tryFlush")
   public final synchronized void tryFlush() {
      this.field1553 = true;

      try {
         this.flush();
      } catch (Exception var2) {
         this.close();
         this.field1548 = class60.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "95"
   )
   @Export("shutdown")
   public final synchronized void shutdown() {
      if(class1.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class1.task.systems[var2]) {
               class1.task.systems[var2] = null;
            }

            if(class1.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class35.field475.shutdownNow();
            class35.field475 = null;
            class1.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "4090"
   )
   final void method2068(int var1) {
      this.field1554 -= var1;
      if(this.field1554 < 0) {
         this.field1554 = 0;
      }

      if(this.field1542 != null) {
         this.field1542.vmethod4100(var1);
      }

   }

   @ObfuscatedName("az")
   final void method2102(int[] var1, int var2) {
      int var3 = var2;
      if(class2.highMemory) {
         var3 = var2 << 1;
      }

      class194.method3673(var1, 0, var3);
      this.field1554 -= var2;
      if(this.field1542 != null && this.field1554 <= 0) {
         this.field1554 += sampleRate >> 4;
         NetWriter.method1921(this.field1542);
         this.method2074(this.field1542, this.field1542.vmethod2352());
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
                  TaskDataNode var11 = this.field1552[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        AbstractIntegerNode0 var12 = var11.field1631;
                        if(var12 != null && var12.int1 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1630;
                        } else {
                           var11.field1628 = true;
                           int var13 = var11.vmethod4109();
                           var4 += var13;
                           if(var12 != null) {
                              var12.int1 += var13;
                           }

                           if(var4 >= this.field1543) {
                              break label104;
                           }

                           TaskDataNode var14 = var11.vmethod4096();
                           if(var14 != null) {
                              for(int var15 = var11.field1629; var14 != null; var14 = var11.vmethod4097()) {
                                 this.method2074(var14, var15 * var14.vmethod2352() >> 8);
                              }
                           }

                           TaskDataNode var18 = var11.field1630;
                           var11.field1630 = null;
                           if(var10 == null) {
                              this.field1552[var7] = var18;
                           } else {
                              var10.field1630 = var18;
                           }

                           if(var18 == null) {
                              this.field1556[var7] = var10;
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
            TaskDataNode var16 = this.field1552[var6];
            TaskDataNode[] var17 = this.field1552;
            this.field1556[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1630;
               var16.field1630 = null;
            }
         }
      }

      if(this.field1554 < 0) {
         this.field1554 = 0;
      }

      if(this.field1542 != null) {
         this.field1542.vmethod4099(var1, 0, var2);
      }

      this.field1549 = class60.currentTimeMs();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ldk;II)V",
      garbageValue = "1325707349"
   )
   final void method2074(TaskDataNode var1, int var2) {
      int var3 = var2 >> 5;
      TaskDataNode var4 = this.field1556[var3];
      if(var4 == null) {
         this.field1552[var3] = var1;
      } else {
         var4.field1630 = var1;
      }

      this.field1556[var3] = var1;
      var1.field1629 = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lil;III)[Lkm;",
      garbageValue = "-1933798798"
   )
   static IndexedSprite[] method2112(IndexDataBase var0, int var1, int var2) {
      return !class288.method5126(var0, var1, var2)?null:class39.method536();
   }
}
