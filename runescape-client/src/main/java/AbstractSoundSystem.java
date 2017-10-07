import java.io.File;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("g")
   static ScheduledExecutorService field1633;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 454263037
   )
   static int field1631;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lcz;"
   )
   public static class101 field1614;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "[Ldd;"
   )
   class117[] field1630;
   @ObfuscatedName("u")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("m")
   boolean field1627;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   class117 field1616;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -331666245
   )
   int field1628;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -17620041
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1311034909
   )
   int field1626;
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "[Ldd;"
   )
   class117[] field1629;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 5697767534503146381L
   )
   long field1622;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -636517385379084689L
   )
   long field1618;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 929665947
   )
   int field1623;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 425031733
   )
   int field1625;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -730564283
   )
   int field1615;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1122129889
   )
   int field1613;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 6949135122766394241L
   )
   long field1619;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1318024449
   )
   int field1620;

   protected AbstractSoundSystem() {
      this.field1626 = 32;
      this.field1618 = class147.currentTimeMs();
      this.field1622 = 0L;
      this.field1623 = 0;
      this.field1615 = 0;
      this.field1625 = 0;
      this.field1619 = 0L;
      this.field1627 = true;
      this.field1628 = 0;
      this.field1629 = new class117[8];
      this.field1630 = new class117[8];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1570571941"
   )
   protected void vmethod2096() throws Exception {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-529989113"
   )
   protected void close() {
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "17"
   )
   public final synchronized void method2084() {
      if(this.samples != null) {
         long var1 = class147.currentTimeMs();

         try {
            if(this.field1622 != 0L) {
               if(var1 < this.field1622) {
                  return;
               }

               this.create(this.offset);
               this.field1622 = 0L;
               this.field1627 = true;
            }

            int var3 = this.size();
            if(this.field1625 - var3 > this.field1623) {
               this.field1623 = this.field1625 - var3;
            }

            int var4 = this.field1613 + this.field1620;
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
               this.field1627 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1613 = var4 - this.field1620;
               }
            }

            while(var3 < var4) {
               this.method2122(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1619) {
               if(!this.field1627) {
                  if(this.field1623 == 0 && this.field1615 == 0) {
                     this.close();
                     this.field1622 = 2000L + var1;
                     return;
                  }

                  this.field1613 = Math.min(this.field1615, this.field1623);
                  this.field1615 = this.field1623;
               } else {
                  this.field1627 = false;
               }

               this.field1623 = 0;
               this.field1619 = 2000L + var1;
            }

            this.field1625 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1622 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1618) {
               var1 = this.field1618;
            }

            while(var1 > 5000L + this.field1618) {
               this.method2088(256);
               this.field1618 += (long)(256000 / class31.sampleRate);
            }
         } catch (Exception var6) {
            this.field1618 = var1;
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2135777451"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-106"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "180"
   )
   final void method2088(int var1) {
      this.field1628 -= var1;
      if(this.field1628 < 0) {
         this.field1628 = 0;
      }

      if(this.field1616 != null) {
         this.field1616.vmethod4023(var1);
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "471708990"
   )
   public final synchronized void method2086() {
      this.field1627 = true;

      try {
         this.vmethod2096();
      } catch (Exception var2) {
         this.close();
         this.field1622 = class147.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ldd;II)V",
      garbageValue = "-1755265088"
   )
   final void method2090(class117 var1, int var2) {
      int var3 = var2 >> 5;
      class117 var4 = this.field1630[var3];
      if(var4 == null) {
         this.field1629[var3] = var1;
      } else {
         var4.field1706 = var1;
      }

      this.field1630[var3] = var1;
      var1.field1704 = var2;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-86458148"
   )
   public final synchronized void method2118() {
      if(class88.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class88.task.systems[var2]) {
               class88.task.systems[var2] = null;
            }

            if(class88.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1633.shutdownNow();
            field1633 = null;
            class88.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-679429988"
   )
   public final void method2117() {
      this.field1627 = true;
   }

   @ObfuscatedName("am")
   final void method2122(int[] var1, int var2) {
      int var3 = var2;
      if(class33.highMemory) {
         var3 = var2 << 1;
      }

      class183.method3557(var1, 0, var3);
      this.field1628 -= var2;
      if(this.field1616 != null && this.field1628 <= 0) {
         this.field1628 += class31.sampleRate >> 4;
         class13.method78(this.field1616);
         this.method2090(this.field1616, this.field1616.vmethod2391());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class117 var10;
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
                  class117 var11 = this.field1629[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        class120 var12 = var11.field1705;
                        if(var12 != null && var12.field1737 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1706;
                        } else {
                           var11.field1703 = true;
                           int var13 = var11.vmethod4007();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1737 += var13;
                           }

                           if(var4 >= this.field1626) {
                              break label104;
                           }

                           class117 var14 = var11.vmethod4025();
                           if(var14 != null) {
                              for(int var15 = var11.field1704; var14 != null; var14 = var11.vmethod4002()) {
                                 this.method2090(var14, var15 * var14.vmethod2391() >> 8);
                              }
                           }

                           class117 var18 = var11.field1706;
                           var11.field1706 = null;
                           if(var10 == null) {
                              this.field1629[var7] = var18;
                           } else {
                              var10.field1706 = var18;
                           }

                           if(var18 == null) {
                              this.field1630[var7] = var10;
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
            class117 var16 = this.field1629[var6];
            class117[] var17 = this.field1629;
            this.field1630[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1706;
               var16.field1706 = null;
            }
         }
      }

      if(this.field1628 < 0) {
         this.field1628 = 0;
      }

      if(this.field1616 != null) {
         this.field1616.vmethod4004(var1, 0, var2);
      }

      this.field1618 = class147.currentTimeMs();
   }

   @ObfuscatedName("p")
   protected void write() throws Exception {
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Ldd;I)V",
      garbageValue = "1886231477"
   )
   public final synchronized void method2107(class117 var1) {
      this.field1616 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected void vmethod2133() throws Exception {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lit;IIB)Lkr;",
      garbageValue = "40"
   )
   public static SpritePixels method2136(IndexDataBase var0, int var1, int var2) {
      return !class249.method4517(var0, var1, var2)?null:Signlink.method3021();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "-210504247"
   )
   public static File method2129(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class155.field2255 = new File(class89.userHome, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      File var22;
      if(class155.field2255.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class155.field2255, "rw", 10000L);

            Buffer var8;
            int var9;
            for(var8 = new Buffer((int)var7.length()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.read(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.readUnsignedByte();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.readUnsignedByte();
            }

            if(var9 <= 2) {
               var4 = var8.getJagString();
               if(var10 == 1) {
                  var5 = var8.getJagString();
               }
            } else {
               var4 = var8.getCESU8();
               if(var10 == 1) {
                  var5 = var8.getCESU8();
               }
            }

            var7.close();
         } catch (IOException var20) {
            var20.printStackTrace();
         }

         if(var4 != null) {
            var22 = new File(var4);
            if(!var22.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var22 = new File(var4, "test.dat");
            if(!MessageNode.method1155(var22, true)) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label121:
         for(int var15 = 0; var15 < class72.field879.length; ++var15) {
            for(int var16 = 0; var16 < class17.cacheLocations.length; ++var16) {
               File var17 = new File(class17.cacheLocations[var16] + class72.field879[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && MessageNode.method1155(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label121;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class89.userHome + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      if(var5 != null) {
         File var21 = new File(var5);
         var22 = new File(var4);

         try {
            File[] var23 = var21.listFiles();
            File[] var18 = var23;

            for(int var11 = 0; var11 < var18.length; ++var11) {
               File var12 = var18[var11];
               File var13 = new File(var22, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var19) {
            var19.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         class20.method148(new File(var4), (File)null);
      }

      return new File(var4);
   }
}
