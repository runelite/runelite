import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
@Implements("NetSocket")
public final class NetSocket extends AbstractSocket implements Runnable {
   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   @Export("__fb_bm")
   static IndexedSprite __fb_bm;
   @ObfuscatedName("m")
   @Export("inputStream")
   InputStream inputStream;
   @ObfuscatedName("f")
   @Export("outputStream")
   OutputStream outputStream;
   @ObfuscatedName("q")
   @Export("socket")
   Socket socket;
   @ObfuscatedName("w")
   @Export("isClosed")
   boolean isClosed;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   @Export("taskHandler")
   TaskHandler taskHandler;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lfm;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("g")
   @Export("array")
   byte[] array;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -738185459
   )
   @Export("__l")
   int __l;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2057244853
   )
   @Export("__e")
   int __e;
   @ObfuscatedName("x")
   @Export("exceptionWriting")
   boolean exceptionWriting;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1644762957
   )
   @Export("__d")
   final int __d;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -782964015
   )
   @Export("__k")
   final int __k;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lfz;I)V"
   )
   public NetSocket(Socket var1, TaskHandler var2, int var3) throws IOException {
      this.isClosed = false;
      this.__l = 0;
      this.__e = 0;
      this.exceptionWriting = false;
      this.taskHandler = var2;
      this.socket = var1;
      this.__d = var3;
      this.__k = var3 - 100;
      this.socket.setSoTimeout(30000);
      this.socket.setTcpNoDelay(true);
      this.socket.setReceiveBufferSize(65536);
      this.socket.setSendBufferSize(65536);
      this.inputStream = this.socket.getInputStream();
      this.outputStream = this.socket.getOutputStream();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1765046516"
   )
   public boolean isAvailable(int var1) throws IOException {
      return this.isClosed?false:this.inputStream.available() >= var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1078471130"
   )
   public int available() throws IOException {
      return this.isClosed?0:this.inputStream.available();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "516705222"
   )
   public int readUnsignedByte() throws IOException {
      return this.isClosed?0:this.inputStream.read();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1089665746"
   )
   public int read(byte[] var1, int var2, int var3) throws IOException {
      if(this.isClosed) {
         return 0;
      } else {
         int var4;
         int var5;
         for(var4 = var3; var3 > 0; var3 -= var5) {
            var5 = this.inputStream.read(var1, var2, var3);
            if(var5 <= 0) {
               throw new EOFException();
            }

            var2 += var5;
         }

         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-86"
   )
   public void write(byte[] var1, int var2, int var3) throws IOException {
      this.write0(var1, var2, var3);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1252618448"
   )
   public void close() {
      if(!this.isClosed) {
         synchronized(this) {
            this.isClosed = true;
            this.notifyAll();
         }

         if(this.task != null) {
            while(this.task.status == 0) {
               class203.method4010(1L);
            }

            if(this.task.status == 1) {
               try {
                  ((Thread)this.task.result).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.task = null;
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-77"
   )
   @Export("write0")
   void write0(byte[] var1, int var2, int var3) throws IOException {
      if(!this.isClosed) {
         if(this.exceptionWriting) {
            this.exceptionWriting = false;
            throw new IOException();
         }

         if(this.array == null) {
            this.array = new byte[this.__d];
         }

         synchronized(this) {
            for(int var5 = 0; var5 < var3; ++var5) {
               this.array[this.__e] = var1[var5 + var2];
               this.__e = (this.__e + 1) % this.__d;
               if((this.__k + this.__l) % this.__d == this.__e) {
                  throw new IOException();
               }
            }

            if(this.task == null) {
               this.task = this.taskHandler.newThreadTask(this, 3);
            }

            this.notifyAll();
         }
      }

   }

   @Export("run")
   @ObfuscatedName("run")
   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.__e == this.__l) {
                     if(this.isClosed) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var9) {
                        ;
                     }
                  }

                  var2 = this.__l;
                  if(this.__e >= this.__l) {
                     var1 = this.__e - this.__l;
                  } else {
                     var1 = this.__d - this.__l;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.outputStream.write(this.array, var2, var1);
               } catch (IOException var8) {
                  this.exceptionWriting = true;
               }

               this.__l = (var1 + this.__l) % this.__d;

               try {
                  if(this.__e == this.__l) {
                     this.outputStream.flush();
                  }
               } catch (IOException var7) {
                  this.exceptionWriting = true;
               }
               continue;
            }

            try {
               if(this.inputStream != null) {
                  this.inputStream.close();
               }

               if(this.outputStream != null) {
                  this.outputStream.close();
               }

               if(this.socket != null) {
                  this.socket.close();
               }
            } catch (IOException var6) {
               ;
            }

            this.array = null;
            break;
         }
      } catch (Exception var11) {
         NPCDefinition.sendStackTrace((String)null, var11);
      }

   }

   @Export("finalize")
   @ObfuscatedName("finalize")
   protected void finalize() {
      this.close();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILfe;Lfy;Z[I[IB)I",
      garbageValue = "-98"
   )
   public static int method3571(int var0, int var1, int var2, class179 var3, CollisionMap var4, boolean var5, int[] var6, int[] var7) {
      int var8;
      int var9;
      for(var9 = 0; var9 < 128; ++var9) {
         for(var8 = 0; var8 < 128; ++var8) {
            class178.__fi_q[var9][var8] = 0;
            class178.__fi_w[var9][var8] = 99999999;
         }
      }

      int var10;
      byte var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      boolean var18;
      int var19;
      int var20;
      int var21;
      byte var22;
      if(var2 == 1) {
         var9 = var0;
         var10 = var1;
         var22 = 64;
         var11 = 64;
         var12 = var0 - var22;
         var13 = var1 - var11;
         class178.__fi_q[var22][var11] = 99;
         class178.__fi_w[var22][var11] = 0;
         byte var23 = 0;
         var14 = 0;
         class178.__fi_l[var23] = var0;
         var21 = var23 + 1;
         class178.__fi_e[var23] = var1;
         int[][] var24 = var4.flags;

         boolean var25;
         label226: {
            while(var21 != var14) {
               var9 = class178.__fi_l[var14];
               var10 = class178.__fi_e[var14];
               var14 = var14 + 1 & 4095;
               var19 = var9 - var12;
               var20 = var10 - var13;
               var15 = var9 - var4.xInset;
               var16 = var10 - var4.yInset;
               if(var3.vmethod3644(1, var9, var10, var4)) {
                  WidgetGroupParent.__bx_o = var9;
                  UrlRequester.__eo_u = var10;
                  var25 = true;
                  break label226;
               }

               var17 = class178.__fi_w[var19][var20] + 1;
               if(var19 > 0 && class178.__fi_q[var19 - 1][var20] == 0 && (var24[var15 - 1][var16] & 19136776) == 0) {
                  class178.__fi_l[var21] = var9 - 1;
                  class178.__fi_e[var21] = var10;
                  var21 = var21 + 1 & 4095;
                  class178.__fi_q[var19 - 1][var20] = 2;
                  class178.__fi_w[var19 - 1][var20] = var17;
               }

               if(var19 < 127 && class178.__fi_q[var19 + 1][var20] == 0 && (var24[var15 + 1][var16] & 19136896) == 0) {
                  class178.__fi_l[var21] = var9 + 1;
                  class178.__fi_e[var21] = var10;
                  var21 = var21 + 1 & 4095;
                  class178.__fi_q[var19 + 1][var20] = 8;
                  class178.__fi_w[var19 + 1][var20] = var17;
               }

               if(var20 > 0 && class178.__fi_q[var19][var20 - 1] == 0 && (var24[var15][var16 - 1] & 19136770) == 0) {
                  class178.__fi_l[var21] = var9;
                  class178.__fi_e[var21] = var10 - 1;
                  var21 = var21 + 1 & 4095;
                  class178.__fi_q[var19][var20 - 1] = 1;
                  class178.__fi_w[var19][var20 - 1] = var17;
               }

               if(var20 < 127 && class178.__fi_q[var19][var20 + 1] == 0 && (var24[var15][var16 + 1] & 19136800) == 0) {
                  class178.__fi_l[var21] = var9;
                  class178.__fi_e[var21] = var10 + 1;
                  var21 = var21 + 1 & 4095;
                  class178.__fi_q[var19][var20 + 1] = 4;
                  class178.__fi_w[var19][var20 + 1] = var17;
               }

               if(var19 > 0 && var20 > 0 && class178.__fi_q[var19 - 1][var20 - 1] == 0 && (var24[var15 - 1][var16 - 1] & 19136782) == 0 && (var24[var15 - 1][var16] & 19136776) == 0 && (var24[var15][var16 - 1] & 19136770) == 0) {
                  class178.__fi_l[var21] = var9 - 1;
                  class178.__fi_e[var21] = var10 - 1;
                  var21 = var21 + 1 & 4095;
                  class178.__fi_q[var19 - 1][var20 - 1] = 3;
                  class178.__fi_w[var19 - 1][var20 - 1] = var17;
               }

               if(var19 < 127 && var20 > 0 && class178.__fi_q[var19 + 1][var20 - 1] == 0 && (var24[var15 + 1][var16 - 1] & 19136899) == 0 && (var24[var15 + 1][var16] & 19136896) == 0 && (var24[var15][var16 - 1] & 19136770) == 0) {
                  class178.__fi_l[var21] = var9 + 1;
                  class178.__fi_e[var21] = var10 - 1;
                  var21 = var21 + 1 & 4095;
                  class178.__fi_q[var19 + 1][var20 - 1] = 9;
                  class178.__fi_w[var19 + 1][var20 - 1] = var17;
               }

               if(var19 > 0 && var20 < 127 && class178.__fi_q[var19 - 1][var20 + 1] == 0 && (var24[var15 - 1][var16 + 1] & 19136824) == 0 && (var24[var15 - 1][var16] & 19136776) == 0 && (var24[var15][var16 + 1] & 19136800) == 0) {
                  class178.__fi_l[var21] = var9 - 1;
                  class178.__fi_e[var21] = var10 + 1;
                  var21 = var21 + 1 & 4095;
                  class178.__fi_q[var19 - 1][var20 + 1] = 6;
                  class178.__fi_w[var19 - 1][var20 + 1] = var17;
               }

               if(var19 < 127 && var20 < 127 && class178.__fi_q[var19 + 1][var20 + 1] == 0 && (var24[var15 + 1][var16 + 1] & 19136992) == 0 && (var24[var15 + 1][var16] & 19136896) == 0 && (var24[var15][var16 + 1] & 19136800) == 0) {
                  class178.__fi_l[var21] = var9 + 1;
                  class178.__fi_e[var21] = var10 + 1;
                  var21 = var21 + 1 & 4095;
                  class178.__fi_q[var19 + 1][var20 + 1] = 12;
                  class178.__fi_w[var19 + 1][var20 + 1] = var17;
               }
            }

            WidgetGroupParent.__bx_o = var9;
            UrlRequester.__eo_u = var10;
            var25 = false;
         }

         var18 = var25;
      } else if(var2 == 2) {
         var18 = WorldMapSection2.method593(var0, var1, var3, var4);
      } else {
         var18 = IndexStore.method3585(var0, var1, var2, var3, var4);
      }

      var8 = var0 - 64;
      var9 = var1 - 64;
      var10 = WidgetGroupParent.__bx_o;
      var19 = UrlRequester.__eo_u;
      if(!var18) {
         var20 = Integer.MAX_VALUE;
         var12 = Integer.MAX_VALUE;
         var22 = 10;
         var21 = var3.field2120;
         var14 = var3.field2121;
         int var29 = var3.field2122;
         var15 = var3.field2123;

         for(var16 = var21 - var22; var16 <= var22 + var21; ++var16) {
            for(var17 = var14 - var22; var17 <= var14 + var22; ++var17) {
               int var30 = var16 - var8;
               int var31 = var17 - var9;
               if(var30 >= 0 && var31 >= 0 && var30 < 128 && var31 < 128 && class178.__fi_w[var30][var31] < 100) {
                  int var26 = 0;
                  if(var16 < var21) {
                     var26 = var21 - var16;
                  } else if(var16 > var29 + var21 - 1) {
                     var26 = var16 - (var29 + var21 - 1);
                  }

                  int var27 = 0;
                  if(var17 < var14) {
                     var27 = var14 - var17;
                  } else if(var17 > var15 + var14 - 1) {
                     var27 = var17 - (var15 + var14 - 1);
                  }

                  int var28 = var27 * var27 + var26 * var26;
                  if(var28 < var20 || var28 == var20 && class178.__fi_w[var30][var31] < var12) {
                     var20 = var28;
                     var12 = class178.__fi_w[var30][var31];
                     var10 = var16;
                     var19 = var17;
                  }
               }
            }
         }

         if(var20 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var10 && var19 == var1) {
         return 0;
      } else {
         var11 = 0;
         class178.__fi_l[var11] = var10;
         var20 = var11 + 1;
         class178.__fi_e[var11] = var19;

         for(var12 = var13 = class178.__fi_q[var10 - var8][var19 - var9]; var0 != var10 || var19 != var1; var12 = class178.__fi_q[var10 - var8][var19 - var9]) {
            if(var12 != var13) {
               var13 = var12;
               class178.__fi_l[var20] = var10;
               class178.__fi_e[var20++] = var19;
            }

            if((var12 & 2) != 0) {
               ++var10;
            } else if((var12 & 8) != 0) {
               --var10;
            }

            if((var12 & 1) != 0) {
               ++var19;
            } else if((var12 & 4) != 0) {
               --var19;
            }
         }

         var21 = 0;

         while(var20-- > 0) {
            var6[var21] = class178.__fi_l[var20];
            var7[var21++] = class178.__fi_e[var20];
            if(var21 >= var6.length) {
               break;
            }
         }

         return var21;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;Lir;Lhm;I)Z",
      garbageValue = "-590103687"
   )
   public static boolean method3537(AbstractIndexCache var0, AbstractIndexCache var1, AbstractIndexCache var2, MidiPcmStream var3) {
      class1.__f_m = var0;
      class214.__hf_f = var1;
      class214.__hf_q = var2;
      class214.midiPcmStream = var3;
      return true;
   }
}
