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
         } else {
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
                     } catch (InterruptedException var10) {
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
               } catch (IOException var9) {
                  this.exceptionWriting = true;
               }

               this.__l = (var1 + this.__l) % this.__d;

               try {
                  if(this.__e == this.__l) {
                     this.outputStream.flush();
                  }
               } catch (IOException var8) {
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
            } catch (IOException var7) {
               ;
            }

            this.array = null;
            break;
         }
      } catch (Exception var12) {
         NpcDefinition.sendStackTrace((String)null, var12);
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
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class178.__fi_q[var8][var9] = 0;
            class178.__fi_w[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var13;
      int var14;
      int var15;
      int var17;
      int var19;
      int var20;
      int var21;
      boolean var28;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var10 = var0;
         var11 = var1;
         byte var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class178.__fi_q[var12][var13] = 99;
         class178.__fi_w[var12][var13] = 0;
         byte var16 = 0;
         var17 = 0;
         class178.__fi_l[var16] = var0;
         var33 = var16 + 1;
         class178.__fi_e[var16] = var1;
         int[][] var18 = var4.flags;

         boolean var29;
         while(true) {
            if(var33 == var17) {
               WidgetGroupParent.__bx_o = var10;
               UrlRequester.__eo_u = var11;
               var29 = false;
               break;
            }

            var10 = class178.__fi_l[var17];
            var11 = class178.__fi_e[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.xInset;
            var20 = var11 - var4.yInset;
            if(var3.vmethod3644(1, var10, var11, var4)) {
               WidgetGroupParent.__bx_o = var10;
               UrlRequester.__eo_u = var11;
               var29 = true;
               break;
            }

            var21 = class178.__fi_w[var30][var31] + 1;
            if(var30 > 0 && class178.__fi_q[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class178.__fi_l[var33] = var10 - 1;
               class178.__fi_e[var33] = var11;
               var33 = var33 + 1 & 4095;
               class178.__fi_q[var30 - 1][var31] = 2;
               class178.__fi_w[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class178.__fi_q[var30 + 1][var31] == 0 && (var18[var19 + 1][var20] & 19136896) == 0) {
               class178.__fi_l[var33] = var10 + 1;
               class178.__fi_e[var33] = var11;
               var33 = var33 + 1 & 4095;
               class178.__fi_q[var30 + 1][var31] = 8;
               class178.__fi_w[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class178.__fi_q[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class178.__fi_l[var33] = var10;
               class178.__fi_e[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class178.__fi_q[var30][var31 - 1] = 1;
               class178.__fi_w[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class178.__fi_q[var30][var31 + 1] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class178.__fi_l[var33] = var10;
               class178.__fi_e[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class178.__fi_q[var30][var31 + 1] = 4;
               class178.__fi_w[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class178.__fi_q[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class178.__fi_l[var33] = var10 - 1;
               class178.__fi_e[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class178.__fi_q[var30 - 1][var31 - 1] = 3;
               class178.__fi_w[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && class178.__fi_q[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class178.__fi_l[var33] = var10 + 1;
               class178.__fi_e[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class178.__fi_q[var30 + 1][var31 - 1] = 9;
               class178.__fi_w[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class178.__fi_q[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class178.__fi_l[var33] = var10 - 1;
               class178.__fi_e[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class178.__fi_q[var30 - 1][var31 + 1] = 6;
               class178.__fi_w[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 127 && var31 < 127 && class178.__fi_q[var30 + 1][var31 + 1] == 0 && (var18[var19 + 1][var20 + 1] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class178.__fi_l[var33] = var10 + 1;
               class178.__fi_e[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class178.__fi_q[var30 + 1][var31 + 1] = 12;
               class178.__fi_w[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else if(var2 == 2) {
         var28 = WorldMapSection2.method593(var0, var1, var3, var4);
      } else {
         var28 = IndexStore.method3585(var0, var1, var2, var3, var4);
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = WidgetGroupParent.__bx_o;
      var30 = UrlRequester.__eo_u;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field2120;
         var17 = var3.field2121;
         int var27 = var3.field2122;
         var19 = var3.field2123;

         for(var20 = var33 - var32; var20 <= var32 + var33; ++var20) {
            for(var21 = var17 - var32; var21 <= var17 + var32; ++var21) {
               int var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class178.__fi_w[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var27 + var33 - 1) {
                     var24 = var20 - (var27 + var33 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var19 + var17 - 1) {
                     var25 = var21 - (var19 + var17 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var26 == var31 && class178.__fi_w[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class178.__fi_w[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if(var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var30 == var1) {
         return 0;
      } else {
         var13 = 0;
         class178.__fi_l[var13] = var11;
         var31 = var13 + 1;
         class178.__fi_e[var13] = var30;

         for(var14 = var15 = class178.__fi_q[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class178.__fi_q[var11 - var9][var30 - var10]) {
            if(var14 != var15) {
               var15 = var14;
               class178.__fi_l[var31] = var11;
               class178.__fi_e[var31++] = var30;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var30;
            } else if((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class178.__fi_l[var31];
            var7[var33++] = class178.__fi_e[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
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
