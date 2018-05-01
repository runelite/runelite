import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -131965333
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("l")
   @Export("audioHighMemory")
   protected static boolean audioHighMemory;
   @ObfuscatedName("y")
   static ScheduledExecutorService field1555;
   @ObfuscatedName("r")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ldh;"
   )
   TaskDataNode field1543;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -73713643
   )
   int field1542;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 5308529998640436979L
   )
   long field1544;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 887985489
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1069534635
   )
   int field1545;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 609209953
   )
   int field1546;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -1298517331881557759L
   )
   long field1547;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1832351777
   )
   int field1548;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 988692971
   )
   int field1536;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1818293359
   )
   int field1550;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 8965563179912305539L
   )
   long field1551;
   @ObfuscatedName("t")
   boolean field1552;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -2123981331
   )
   int field1553;
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "[Ldh;"
   )
   TaskDataNode[] field1554;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "[Ldh;"
   )
   TaskDataNode[] field1541;

   protected AbstractSoundSystem() {
      this.field1542 = 32;
      this.field1544 = class289.method5267();
      this.field1547 = 0L;
      this.field1548 = 0;
      this.field1536 = 0;
      this.field1550 = 0;
      this.field1551 = 0L;
      this.field1552 = true;
      this.field1553 = 0;
      this.field1554 = new TaskDataNode[8];
      this.field1541 = new TaskDataNode[8];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   protected void vmethod2334() throws Exception {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1556805769"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1113283435"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("z")
   protected void write() throws Exception {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1465476948"
   )
   protected void close() {
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-541164961"
   )
   protected void flush() throws Exception {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ldh;I)V",
      garbageValue = "-1459882232"
   )
   public final synchronized void method2297(TaskDataNode var1) {
      this.field1543 = var1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "116"
   )
   public final synchronized void method2328() {
      if(this.samples != null) {
         long var1 = class289.method5267();

         try {
            if(this.field1547 != 0L) {
               if(var1 < this.field1547) {
                  return;
               }

               this.create(this.offset);
               this.field1547 = 0L;
               this.field1552 = true;
            }

            int var3 = this.size();
            if(this.field1550 - var3 > this.field1548) {
               this.field1548 = this.field1550 - var3;
            }

            int var4 = this.field1546 + this.field1545;
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
               this.field1552 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1546 = var4 - this.field1545;
               }
            }

            while(var3 < var4) {
               this.method2303(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1551) {
               if(!this.field1552) {
                  if(this.field1548 == 0 && this.field1536 == 0) {
                     this.close();
                     this.field1547 = var1 + 2000L;
                     return;
                  }

                  this.field1546 = Math.min(this.field1536, this.field1548);
                  this.field1536 = this.field1548;
               } else {
                  this.field1552 = false;
               }

               this.field1548 = 0;
               this.field1551 = var1 + 2000L;
            }

            this.field1550 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1547 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1544) {
               var1 = this.field1544;
            }

            while(var1 > 5000L + this.field1544) {
               this.method2302(256);
               this.field1544 += (long)(256000 / sampleRate);
            }
         } catch (Exception var6) {
            this.field1544 = var1;
         }

      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public final void method2299() {
      this.field1552 = true;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1173067205"
   )
   @Export("tryFlush")
   public final synchronized void tryFlush() {
      this.field1552 = true;

      try {
         this.flush();
      } catch (Exception var2) {
         this.close();
         this.field1547 = class289.method5267() + 2000L;
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-116"
   )
   @Export("shutdown")
   public final synchronized void shutdown() {
      if(GrandExchangeOffer.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == GrandExchangeOffer.task.systems[var2]) {
               GrandExchangeOffer.task.systems[var2] = null;
            }

            if(GrandExchangeOffer.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1555.shutdownNow();
            field1555 = null;
            GrandExchangeOffer.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1916550381"
   )
   final void method2302(int var1) {
      this.field1553 -= var1;
      if(this.field1553 < 0) {
         this.field1553 = 0;
      }

      if(this.field1543 != null) {
         this.field1543.vmethod4426(var1);
      }

   }

   @ObfuscatedName("ay")
   final void method2303(int[] var1, int var2) {
      int var3 = var2;
      if(audioHighMemory) {
         var3 = var2 << 1;
      }

      class205.method3943(var1, 0, var3);
      this.field1553 -= var2;
      if(this.field1543 != null && this.field1553 <= 0) {
         this.field1553 += sampleRate >> 4;
         World.method1763(this.field1543);
         this.method2316(this.field1543, this.field1543.vmethod2570());
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

                        AbstractIntegerNode0 var12 = var11.data;
                        if(var12 != null && var12.int1 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1624;
                        } else {
                           var11.field1621 = true;
                           int var13 = var11.vmethod4425();
                           var4 += var13;
                           if(var12 != null) {
                              var12.int1 += var13;
                           }

                           if(var4 >= this.field1542) {
                              break label104;
                           }

                           TaskDataNode var14 = var11.vmethod4437();
                           if(var14 != null) {
                              for(int var15 = var11.field1622; var14 != null; var14 = var11.vmethod4424()) {
                                 this.method2316(var14, var15 * var14.vmethod2570() >> 8);
                              }
                           }

                           TaskDataNode var18 = var11.field1624;
                           var11.field1624 = null;
                           if(var10 == null) {
                              this.field1554[var7] = var18;
                           } else {
                              var10.field1624 = var18;
                           }

                           if(var18 == null) {
                              this.field1541[var7] = var10;
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
            this.field1541[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1624;
               var16.field1624 = null;
            }
         }
      }

      if(this.field1553 < 0) {
         this.field1553 = 0;
      }

      if(this.field1543 != null) {
         this.field1543.vmethod4441(var1, 0, var2);
      }

      this.field1544 = class289.method5267();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ldh;IS)V",
      garbageValue = "-21264"
   )
   final void method2316(TaskDataNode var1, int var2) {
      int var3 = var2 >> 5;
      TaskDataNode var4 = this.field1541[var3];
      if(var4 == null) {
         this.field1554[var3] = var1;
      } else {
         var4.field1624 = var1;
      }

      this.field1541[var3] = var1;
      var1.field1622 = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfb;Lgo;B)Lgj;",
      garbageValue = "12"
   )
   public static PacketNode method2350(ClientPacket var0, ISAACCipher var1) {
      PacketNode var2;
      if(PacketNode.field2491 == 0) {
         var2 = new PacketNode();
      } else {
         var2 = PacketNode.packetBufferNodes[--PacketNode.field2491];
      }

      var2.clientPacket = var0;
      var2.field2487 = var0.packetLength;
      if(var2.field2487 == -1) {
         var2.packetBuffer = new PacketBuffer(260);
      } else if(var2.field2487 == -2) {
         var2.packetBuffer = new PacketBuffer(10000);
      } else if(var2.field2487 <= 18) {
         var2.packetBuffer = new PacketBuffer(20);
      } else if(var2.field2487 <= 98) {
         var2.packetBuffer = new PacketBuffer(100);
      } else {
         var2.packetBuffer = new PacketBuffer(260);
      }

      var2.packetBuffer.setIsaacCipher(var1);
      var2.packetBuffer.putOpcode(var2.clientPacket.packetId);
      var2.field2489 = 0;
      return var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Ljf;",
      garbageValue = "-1532119912"
   )
   public static VarCInt method2349(int var0) {
      VarCInt var1 = (VarCInt)VarCInt.field3476.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = IndexData.field3400.getConfigData(19, var0);
         var1 = new VarCInt();
         if(var2 != null) {
            var1.method4879(new Buffer(var2));
         }

         VarCInt.field3476.put(var1, (long)var0);
         return var1;
      }
   }
}
