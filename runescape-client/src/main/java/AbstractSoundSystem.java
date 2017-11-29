import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1933183041
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("m")
   @Export("highMemory")
   protected static boolean highMemory;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1836552753
   )
   @Export("priority")
   static int priority;
   @ObfuscatedName("c")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ldn;"
   )
   TaskDataNode field1549;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1079948135
   )
   int field1550;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 6801925527409343321L
   )
   long field1551;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2132244943
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1717941327
   )
   int field1544;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1632295359
   )
   int field1562;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 822431412891331563L
   )
   long field1555;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2120148963
   )
   int field1556;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1599835795
   )
   int field1557;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -785087097
   )
   int field1558;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 3839991801298215907L
   )
   long field1559;
   @ObfuscatedName("a")
   boolean field1560;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1093896469
   )
   int field1563;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "[Ldn;"
   )
   TaskDataNode[] field1554;
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "[Ldn;"
   )
   TaskDataNode[] field1566;

   protected AbstractSoundSystem() {
      this.field1550 = 32;
      this.field1551 = ServerPacket.currentTimeMs();
      this.field1555 = 0L;
      this.field1556 = 0;
      this.field1557 = 0;
      this.field1558 = 0;
      this.field1559 = 0L;
      this.field1560 = true;
      this.field1563 = 0;
      this.field1554 = new TaskDataNode[8];
      this.field1566 = new TaskDataNode[8];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "655323066"
   )
   protected void vmethod2118() throws Exception {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "110957333"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1327145255"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("z")
   protected void write() throws Exception {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2079807203"
   )
   protected void close() {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-55"
   )
   protected void flush() throws Exception {
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Ldn;I)V",
      garbageValue = "302028315"
   )
   public final synchronized void method2094(TaskDataNode var1) {
      this.field1549 = var1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-405592090"
   )
   public final synchronized void method2095() {
      if(this.samples != null) {
         long var1 = ServerPacket.currentTimeMs();

         try {
            if(this.field1555 != 0L) {
               if(var1 < this.field1555) {
                  return;
               }

               this.create(this.offset);
               this.field1555 = 0L;
               this.field1560 = true;
            }

            int var3 = this.size();
            if(this.field1558 - var3 > this.field1556) {
               this.field1556 = this.field1558 - var3;
            }

            int var4 = this.field1562 + this.field1544;
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
               this.field1560 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1562 = var4 - this.field1544;
               }
            }

            while(var3 < var4) {
               this.method2130(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1559) {
               if(!this.field1560) {
                  if(this.field1556 == 0 && this.field1557 == 0) {
                     this.close();
                     this.field1555 = var1 + 2000L;
                     return;
                  }

                  this.field1562 = Math.min(this.field1557, this.field1556);
                  this.field1557 = this.field1556;
               } else {
                  this.field1560 = false;
               }

               this.field1556 = 0;
               this.field1559 = var1 + 2000L;
            }

            this.field1558 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1555 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1551) {
               var1 = this.field1551;
            }

            while(var1 > this.field1551 + 5000L) {
               this.method2152(256);
               this.field1551 += (long)(256000 / sampleRate);
            }
         } catch (Exception var6) {
            this.field1551 = var1;
         }

      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-478960381"
   )
   public final void method2096() {
      this.field1560 = true;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "346188434"
   )
   @Export("tryFlush")
   public final synchronized void tryFlush() {
      this.field1560 = true;

      try {
         this.flush();
      } catch (Exception var2) {
         this.close();
         this.field1555 = ServerPacket.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1884305932"
   )
   @Export("shutdown")
   public final synchronized void shutdown() {
      if(class33.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class33.task.systems[var2]) {
               class33.task.systems[var2] = null;
            }

            if(class33.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            Size.field347.shutdownNow();
            Size.field347 = null;
            class33.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1022272700"
   )
   final void method2152(int var1) {
      this.field1563 -= var1;
      if(this.field1563 < 0) {
         this.field1563 = 0;
      }

      if(this.field1549 != null) {
         this.field1549.vmethod4058(var1);
      }

   }

   @ObfuscatedName("aj")
   final void method2130(int[] var1, int var2) {
      int var3 = var2;
      if(highMemory) {
         var3 = var2 << 1;
      }

      class190.method3618(var1, 0, var3);
      this.field1563 -= var2;
      if(this.field1549 != null && this.field1563 <= 0) {
         this.field1563 += sampleRate >> 4;
         class226.method4216(this.field1549);
         this.method2100(this.field1549, this.field1549.vmethod2413());
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
                  TaskDataNode var11 = this.field1554[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        AbstractIntegerNode0 var12 = var11.field1634;
                        if(var12 != null && var12.int1 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1633;
                        } else {
                           var11.field1635 = true;
                           int var13 = var11.vmethod4056();
                           var4 += var13;
                           if(var12 != null) {
                              var12.int1 += var13;
                           }

                           if(var4 >= this.field1550) {
                              break label104;
                           }

                           TaskDataNode var14 = var11.vmethod4054();
                           if(var14 != null) {
                              for(int var15 = var11.field1632; var14 != null; var14 = var11.vmethod4055()) {
                                 this.method2100(var14, var15 * var14.vmethod2413() >> 8);
                              }
                           }

                           TaskDataNode var18 = var11.field1633;
                           var11.field1633 = null;
                           if(var10 == null) {
                              this.field1554[var7] = var18;
                           } else {
                              var10.field1633 = var18;
                           }

                           if(var18 == null) {
                              this.field1566[var7] = var10;
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
            TaskDataNode var16 = this.field1554[var6];
            TaskDataNode[] var17 = this.field1554;
            this.field1566[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1633;
               var16.field1633 = null;
            }
         }
      }

      if(this.field1563 < 0) {
         this.field1563 = 0;
      }

      if(this.field1549 != null) {
         this.field1549.vmethod4057(var1, 0, var2);
      }

      this.field1551 = ServerPacket.currentTimeMs();
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Ldn;II)V",
      garbageValue = "112999140"
   )
   final void method2100(TaskDataNode var1, int var2) {
      int var3 = var2 >> 5;
      TaskDataNode var4 = this.field1566[var3];
      if(var4 == null) {
         this.field1554[var3] = var1;
      } else {
         var4.field1633 = var1;
      }

      this.field1566[var3] = var1;
      var1.field1632 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "16711935"
   )
   public static char method2104(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZZI)I",
      garbageValue = "2106145338"
   )
   public static int method2156(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class245.NetCache_pendingPriorityResponsesCount + class245.NetCache_pendingPriorityWritesCount;
      return var3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2061188297"
   )
   public static void method2157() {
      class259.field3461.reset();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1367371695"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }
}
