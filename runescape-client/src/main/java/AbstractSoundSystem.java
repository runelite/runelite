import net.runelite.mapping.*;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.ScheduledExecutorService;

@ObfuscatedName("dn")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("f")
   static ScheduledExecutorService field1535;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lca;"
   )
   @Export("soundTaskDataProvider")
   static TaskDataProvider soundTaskDataProvider;
   @ObfuscatedName("n")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   TaskDataNode field1537;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2108492871
   )
   int field1529;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -3487522473593626019L
   )
   long field1530;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 578551261
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1998847825
   )
   int field1527;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -831054689
   )
   int field1533;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 3485912435572982805L
   )
   long field1534;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2073128245
   )
   int field1538;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -269132505
   )
   int field1536;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1830410573
   )
   int field1532;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -9075587933886342265L
   )
   long field1528;
   @ObfuscatedName("p")
   boolean field1539;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1308682575
   )
   int field1541;
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "[Ldy;"
   )
   TaskDataNode[] field1542;
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "[Ldy;"
   )
   TaskDataNode[] field1543;

   protected AbstractSoundSystem() {
      this.field1529 = 32;
      this.field1530 = Preferences.currentTimeMs();
      this.field1534 = 0L;
      this.field1538 = 0;
      this.field1536 = 0;
      this.field1532 = 0;
      this.field1528 = 0L;
      this.field1539 = true;
      this.field1541 = 0;
      this.field1542 = new TaskDataNode[8];
      this.field1543 = new TaskDataNode[8];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2039373449"
   )
   protected void vmethod2025() throws Exception {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-629465154"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "351885970"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("k")
   protected void write() throws Exception {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2089279767"
   )
   protected void close() {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1216740366"
   )
   protected void flush() throws Exception {
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Ldy;I)V",
      garbageValue = "1531776038"
   )
   public final synchronized void method2002(TaskDataNode var1) {
      this.field1537 = var1;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1945174993"
   )
   public final synchronized void method2003() {
      if(this.samples != null) {
         long var1 = Preferences.currentTimeMs();

         try {
            if(0L != this.field1534) {
               if(var1 < this.field1534) {
                  return;
               }

               this.create(this.offset);
               this.field1534 = 0L;
               this.field1539 = true;
            }

            int var3 = this.size();
            if(this.field1532 - var3 > this.field1538) {
               this.field1538 = this.field1532 - var3;
            }

            int var4 = this.field1533 + this.field1527;
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
               this.field1539 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1533 = var4 - this.field1527;
               }
            }

            while(var3 < var4) {
               this.method2008(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1528) {
               if(!this.field1539) {
                  if(this.field1538 == 0 && this.field1536 == 0) {
                     this.close();
                     this.field1534 = var1 + 2000L;
                     return;
                  }

                  this.field1533 = Math.min(this.field1536, this.field1538);
                  this.field1536 = this.field1538;
               } else {
                  this.field1539 = false;
               }

               this.field1538 = 0;
               this.field1528 = 2000L + var1;
            }

            this.field1532 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1534 = var1 + 2000L;
         }

         try {
            if(var1 > this.field1530 + 500000L) {
               var1 = this.field1530;
            }

            while(var1 > 5000L + this.field1530) {
               this.method2007(256);
               this.field1530 += (long)(256000 / ScriptState.sampleRate);
            }
         } catch (Exception var6) {
            this.field1530 = var1;
         }

      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1596473976"
   )
   public final void method2004() {
      this.field1539 = true;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1384948412"
   )
   @Export("tryFlush")
   public final synchronized void tryFlush() {
      this.field1539 = true;

      try {
         this.flush();
      } catch (Exception var2) {
         this.close();
         this.field1534 = Preferences.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1986195761"
   )
   @Export("shutdown")
   public final synchronized void shutdown() {
      if(GroundObject.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == GroundObject.task.systems[var2]) {
               GroundObject.task.systems[var2] = null;
            }

            if(GroundObject.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1535.shutdownNow();
            field1535 = null;
            GroundObject.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-27188"
   )
   final void method2007(int var1) {
      this.field1541 -= var1;
      if(this.field1541 < 0) {
         this.field1541 = 0;
      }

      if(this.field1537 != null) {
         this.field1537.vmethod4046(var1);
      }

   }

   @ObfuscatedName("ax")
   final void method2008(int[] var1, int var2) {
      int var3 = var2;
      if(ContextMenuRow.highMemory) {
         var3 = var2 << 1;
      }

      class194.method3611(var1, 0, var3);
      this.field1541 -= var2;
      if(this.field1537 != null && this.field1541 <= 0) {
         this.field1541 += ScriptState.sampleRate >> 4;
         Player.method1078(this.field1537);
         this.method2018(this.field1537, this.field1537.vmethod2290());
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
                  TaskDataNode var11 = this.field1542[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        AbstractIntegerNode0 var12 = var11.field1613;
                        if(var12 != null && var12.int1 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1612;
                        } else {
                           var11.field1614 = true;
                           int var13 = var11.vmethod4045();
                           var4 += var13;
                           if(var12 != null) {
                              var12.int1 += var13;
                           }

                           if(var4 >= this.field1529) {
                              break label104;
                           }

                           TaskDataNode var14 = var11.vmethod4041();
                           if(var14 != null) {
                              for(int var15 = var11.field1611; var14 != null; var14 = var11.vmethod4040()) {
                                 this.method2018(var14, var15 * var14.vmethod2290() >> 8);
                              }
                           }

                           TaskDataNode var18 = var11.field1612;
                           var11.field1612 = null;
                           if(var10 == null) {
                              this.field1542[var7] = var18;
                           } else {
                              var10.field1612 = var18;
                           }

                           if(var18 == null) {
                              this.field1543[var7] = var10;
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
            TaskDataNode var16 = this.field1542[var6];
            TaskDataNode[] var17 = this.field1542;
            this.field1543[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1612;
               var16.field1612 = null;
            }
         }
      }

      if(this.field1541 < 0) {
         this.field1541 = 0;
      }

      if(this.field1537 != null) {
         this.field1537.vmethod4062(var1, 0, var2);
      }

      this.field1530 = Preferences.currentTimeMs();
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ldy;IB)V",
      garbageValue = "101"
   )
   final void method2018(TaskDataNode var1, int var2) {
      int var3 = var2 >> 5;
      TaskDataNode var4 = this.field1543[var3];
      if(var4 == null) {
         this.field1542[var3] = var1;
      } else {
         var4.field1612 = var1;
      }

      this.field1543[var3] = var1;
      var1.field1611 = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "17142342"
   )
   @Export("openRandomAccessFile")
   static boolean method2055(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILck;ZB)I",
      garbageValue = "4"
   )
   @Export("cs2_2000s")
   static int method2056(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = VertexNormal.getWidget(class82.intStack[--class82.intStackSize]);
      } else {
         var3 = var2?class139.field2008:AttackOption.field1306;
      }

      if(var0 == 1927) {
         if(class82.field1250 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2868 == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.objs = var3.field2868;
            var4.field778 = class82.field1250 + 1;
            Client.field1027.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "([Lhz;II)V",
      garbageValue = "1711263018"
   )
   static final void method2057(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !Occluder.method2905(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && Occluder.method2905(var3) && var3 != class29.field391) {
                  continue;
               }

               method2057(var0, var3.id);
               if(var3.children != null) {
                  method2057(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var7 != null) {
                  var5 = var7.id;
                  if(GraphicsObject.loadWidget(var5)) {
                     method2057(Widget.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2806 != -1 || var3.field2807 != -1) {
                  boolean var4 = ClanMember.method1117(var3);
                  if(var4) {
                     var5 = var3.field2807;
                  } else {
                     var5 = var3.field2806;
                  }

                  if(var5 != -1) {
                     Sequence var6 = Permission.getAnimation(var5);

                     for(var3.field2892 += Client.field847; var3.field2892 > var6.frameLenghts[var3.field2881]; class33.method344(var3)) {
                        var3.field2892 -= var6.frameLenghts[var3.field2881];
                        ++var3.field2881;
                        if(var3.field2881 >= var6.frameIDs.length) {
                           var3.field2881 -= var6.frameStep;
                           if(var3.field2881 < 0 || var3.field2881 >= var6.frameIDs.length) {
                              var3.field2881 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2815 != 0 && !var3.hasScript) {
                  int var8 = var3.field2815 >> 16;
                  var5 = var3.field2815 << 16 >> 16;
                  var8 *= Client.field847;
                  var5 *= Client.field847;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class33.method344(var3);
               }
            }
         }
      }

   }
}
