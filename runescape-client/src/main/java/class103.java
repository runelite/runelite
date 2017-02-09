import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class103 implements Runnable {
   @ObfuscatedName("r")
   class102 field1676 = null;
   @ObfuscatedName("o")
   class102 field1677 = null;
   @ObfuscatedName("bm")
   static ModIcon[] field1678;
   @ObfuscatedName("w")
   Thread field1679;
   @ObfuscatedName("j")
   boolean field1680 = false;
   @ObfuscatedName("q")
   public EventQueue field1681;
   @ObfuscatedName("py")
   static class116 field1684;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1002781659
   )
   static int field1685;
   @ObfuscatedName("be")
   static class184 field1686;
   @ObfuscatedName("k")
   public static String field1687;

   public final void run() {
      while(true) {
         class102 var1;
         synchronized(this) {
            while(true) {
               if(this.field1680) {
                  return;
               }

               if(this.field1677 != null) {
                  var1 = this.field1677;
                  this.field1677 = this.field1677.field1673;
                  if(this.field1677 == null) {
                     this.field1676 = null;
                  }
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var8) {
                  ;
               }
            }
         }

         try {
            int var5 = var1.field1672;
            if(var5 == 1) {
               var1.field1675 = new Socket(InetAddress.getByName((String)var1.field1671), var1.field1670);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field1671);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field1670);
               var1.field1675 = var3;
            } else if(var5 == 4) {
               var1.field1675 = new DataInputStream(((URL)var1.field1671).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field1670 >> 24 & 255) + "." + (var1.field1670 >> 16 & 255) + "." + (var1.field1670 >> 8 & 255) + "." + (var1.field1670 & 255);
               var1.field1675 = InetAddress.getByName(var10).getHostName();
            }

            var1.field1667 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field1667 = 2;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass102;",
      garbageValue = "1931154204"
   )
   final class102 method1943(int var1, int var2, int var3, Object var4) {
      class102 var5 = new class102();
      var5.field1672 = var1;
      var5.field1670 = var2;
      var5.field1671 = var4;
      synchronized(this) {
         if(this.field1676 != null) {
            this.field1676.field1673 = var5;
            this.field1676 = var5;
         } else {
            this.field1676 = this.field1677 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass102;",
      garbageValue = "773413767"
   )
   public final class102 method1944(String var1, int var2) {
      return this.method1943(1, var2, 0, var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass102;",
      garbageValue = "-120123247"
   )
   public final class102 method1945(Runnable var1, int var2) {
      return this.method1943(2, var2, 0, var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass102;",
      garbageValue = "-187123149"
   )
   public final class102 method1947(URL var1) {
      return this.method1943(4, 0, 0, var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-286525366"
   )
   final void method1952() {
      synchronized(this) {
         this.field1680 = true;
         this.notifyAll();
      }

      try {
         this.field1679.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass102;",
      garbageValue = "-1817531867"
   )
   public final class102 method1960(int var1) {
      return this.method1943(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[II)V",
      garbageValue = "2124005953"
   )
   static void method1962(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var11;
            int var12;
            int var13;
            do {
               --var6;

               for(var13 = 0; var13 < 4; ++var13) {
                  if(var3[var13] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var13] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var13] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var13] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var13] == 3) {
                     var11 = var0[var6].method652()?1:0;
                     var12 = var8.method652()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var13] != 1 || var11 <= var12) && (var4[var13] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var13 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var13 = 0; var13 < 4; ++var13) {
                  if(var3[var13] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var13] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var13] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var13] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var13] == 3) {
                     var11 = var0[var5].method652()?1:0;
                     var12 = var8.method652()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var13] != 1 || var11 >= var12) && (var4[var13] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var13 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var10 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var10;
            }
         }

         method1962(var0, var1, var6, var3, var4);
         method1962(var0, 1 + var6, var2, var3, var4);
      }

   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "-14"
   )
   static void method1965(Widget var0) {
      Widget var1 = var0.parentId == -1?null:class37.method759(var0.parentId);
      int var2;
      int var3;
      if(null == var1) {
         var2 = XItemContainer.field123;
         var3 = class143.field1999;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      class38.method760(var0, var2, var3, false);
      class7.method109(var0, var2, var3);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2123264311"
   )
   public static void method1966(int var0) {
      class138.field1910 = 1;
      class1.field10 = null;
      class138.field1915 = -1;
      ChatLineBuffer.field971 = -1;
      class97.field1631 = 0;
      class138.field1912 = false;
      class15.field165 = var0;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "5"
   )
   static final byte[] method1967(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.method3062();
      if(var3 >= 0 && (class182.field2709 == 0 || var3 <= class182.field2709)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method3095(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method3062();
            if(var4 >= 0 && (class182.field2709 == 0 || var4 <= class182.field2709)) {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class154.method2865(var5, var4, var0, var3, 9);
               } else {
                  class182.field2705.method2860(var1, var5);
               }

               return var5;
            } else {
               throw new RuntimeException();
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1906057169"
   )
   public static void method1969() {
      if(null != class185.field2748) {
         class185.field2748.method2064();
      }

   }

   class103() {
      field1687 = "Unknown";
      class45.field904 = "1.1";

      try {
         field1687 = System.getProperty("java.vendor");
         class45.field904 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field1681 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field1680 = false;
      this.field1679 = new Thread(this);
      this.field1679.setPriority(10);
      this.field1679.setDaemon(true);
      this.field1679.start();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)Ljava/io/File;",
      garbageValue = "-28569"
   )
   public static File method1970(String var0) {
      if(!class107.field1728) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class107.field1729.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class107.field1727, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class107.field1729.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }
}
