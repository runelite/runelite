import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 2953124454465133635L
   )
   @Export("length")
   long length;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -7975727942497631007L
   )
   @Export("position")
   long position;
   @ObfuscatedName("dy")
   static byte[][] field1194;
   @ObfuscatedName("s")
   @Export("file")
   RandomAccessFile file;

   @ObfuscatedName("s")
   final void method1377(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(-1L == var3) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.file = new RandomAccessFile(var1, var2);
      this.length = var3;
      this.position = 0L;
      int var5 = this.file.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.file.seek(0L);
         this.file.write(var5);
      }

      this.file.seek(0L);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-572414524"
   )
   public final void method1378() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)J",
      garbageValue = "180"
   )
   public final long method1379() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "-1"
   )
   public final int method1380(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method1378();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-91"
   )
   public static boolean method1385() {
      long var0 = class2.method27();
      int var2 = (int)(var0 - class185.field2749);
      class185.field2749 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class185.field2760 += var2;
      if(class185.field2758 == 0 && class185.field2753 == 0 && class185.field2747 == 0 && class185.field2751 == 0) {
         return true;
      } else if(class185.field2755 == null) {
         return false;
      } else {
         try {
            if(class185.field2760 > 30000) {
               throw new IOException();
            } else {
               class181 var3;
               Buffer var4;
               while(class185.field2753 < 20 && class185.field2751 > 0) {
                  var3 = (class181)class185.field2750.method2283();
                  var4 = new Buffer(4);
                  var4.method2708(1);
                  var4.method2710((int)var3.hash);
                  class185.field2755.method2015(var4.payload, 0, 4);
                  class185.field2752.method2282(var3, var3.hash);
                  --class185.field2751;
                  ++class185.field2753;
               }

               while(class185.field2758 < 20 && class185.field2747 > 0) {
                  var3 = (class181)class185.field2754.method2229();
                  var4 = new Buffer(4);
                  var4.method2708(0);
                  var4.method2710((int)var3.hash);
                  class185.field2755.method2015(var4.payload, 0, 4);
                  var3.method2361();
                  class185.field2757.method2282(var3, var3.hash);
                  --class185.field2747;
                  ++class185.field2758;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class185.field2755.method2007();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class185.field2760 = 0;
                  byte var5 = 0;
                  if(class138.field1925 == null) {
                     var5 = 8;
                  } else if(class185.field2767 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class185.field2759.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class185.field2755.method2005(class185.field2759.payload, class185.field2759.offset, var6);
                     if(class185.field2763 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class185.field2759.payload[class185.field2759.offset + var7] ^= class185.field2763;
                        }
                     }

                     class185.field2759.offset += var6;
                     if(class185.field2759.offset < var5) {
                        break;
                     }

                     if(class138.field1925 == null) {
                        class185.field2759.offset = 0;
                        var7 = class185.field2759.readUnsignedByte();
                        var8 = class185.field2759.readUnsignedShort();
                        int var9 = class185.field2759.readUnsignedByte();
                        var10 = class185.field2759.method2727();
                        long var11 = (long)((var7 << 16) + var8);
                        class181 var13 = (class181)class185.field2752.method2274(var11);
                        class8.field85 = true;
                        if(var13 == null) {
                           var13 = (class181)class185.field2757.method2274(var11);
                           class8.field85 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class138.field1925 = var13;
                        class20.field236 = new Buffer(var10 + var14 + class138.field1925.field2708);
                        class20.field236.method2708(var9);
                        class20.field236.method2711(var10);
                        class185.field2767 = 8;
                        class185.field2759.offset = 0;
                     } else if(class185.field2767 == 0) {
                        if(class185.field2759.payload[0] == -1) {
                           class185.field2767 = 1;
                           class185.field2759.offset = 0;
                        } else {
                           class138.field1925 = null;
                        }
                     }
                  } else {
                     var6 = class20.field236.payload.length - class138.field1925.field2708;
                     var7 = 512 - class185.field2767;
                     if(var7 > var6 - class20.field236.offset) {
                        var7 = var6 - class20.field236.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class185.field2755.method2005(class20.field236.payload, class20.field236.offset, var7);
                     if(class185.field2763 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class20.field236.payload[var8 + class20.field236.offset] ^= class185.field2763;
                        }
                     }

                     class20.field236.offset += var7;
                     class185.field2767 += var7;
                     if(class20.field236.offset == var6) {
                        if(class138.field1925.hash == 16711935L) {
                           class15.field172 = class20.field236;

                           for(var8 = 0; var8 < 256; ++var8) {
                              class184 var17 = class185.field2764[var8];
                              if(var17 != null) {
                                 class15.field172.offset = 8 * var8 + 5;
                                 var10 = class15.field172.method2727();
                                 int var21 = class15.field172.method2727();
                                 var17.method3273(var10, var21);
                              }
                           }
                        } else {
                           class185.field2761.reset();
                           class185.field2761.update(class20.field236.payload, 0, var6);
                           var8 = (int)class185.field2761.getValue();
                           if(var8 != class138.field1925.field2707) {
                              try {
                                 class185.field2755.method2006();
                              } catch (Exception var19) {
                                 ;
                              }

                              ++class185.field2748;
                              class185.field2755 = null;
                              class185.field2763 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class185.field2748 = 0;
                           class185.field2756 = 0;
                           class138.field1925.field2706.method3274((int)(class138.field1925.hash & 65535L), class20.field236.payload, (class138.field1925.hash & 16711680L) == 16711680L, class8.field85);
                        }

                        class138.field1925.unlink();
                        if(class8.field85) {
                           --class185.field2753;
                        } else {
                           --class185.field2758;
                        }

                        class185.field2767 = 0;
                        class138.field1925 = null;
                        class20.field236 = null;
                     } else {
                        if(class185.field2767 != 512) {
                           break;
                        }

                        class185.field2767 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var20) {
            try {
               class185.field2755.method2006();
            } catch (Exception var18) {
               ;
            }

            ++class185.field2756;
            class185.field2755 = null;
            return false;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-551918433"
   )
   public final void method1396(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-768609078"
   )
   public static int method1397(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class15.method155(var0.charAt(var3));
      }

      return var2;
   }
}
