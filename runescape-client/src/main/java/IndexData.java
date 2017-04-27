import java.io.File;
import java.io.IOException;
import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("h")
   IndexFile field2736;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1794870999
   )
   @Export("index")
   int index;
   @ObfuscatedName("y")
   static CRC32 field2738 = new CRC32();
   @ObfuscatedName("x")
   IndexFile field2739;
   @ObfuscatedName("m")
   volatile boolean[] field2740;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 2055809065
   )
   int field2743;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 903446291
   )
   int field2744 = -1;
   @ObfuscatedName("pe")
   static class1 field2745;
   @ObfuscatedName("f")
   volatile boolean field2746 = false;
   @ObfuscatedName("o")
   boolean field2748 = false;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -111710757
   )
   int field2749;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Lclass201;",
      garbageValue = "-49"
   )
   public static class201 method3381(int var0) {
      class201 var1 = (class201)class201.field2922.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class201.field2920.getConfigData(32, var0);
         var1 = new class201();
         if(var2 != null) {
            var1.method3643(new Buffer(var2));
         }

         class201.field2922.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-249039126"
   )
   void method3382() {
      this.field2740 = new boolean[super.field2708.length];

      int var1;
      for(var1 = 0; var1 < this.field2740.length; ++var1) {
         this.field2740[var1] = false;
      }

      if(this.field2739 == null) {
         this.field2746 = true;
      } else {
         this.field2744 = -1;

         for(var1 = 0; var1 < this.field2740.length; ++var1) {
            if(super.field2711[var1] > 0) {
               IndexFile var2 = this.field2739;
               class182 var4 = new class182();
               var4.field2702 = 1;
               var4.hash = (long)var1;
               var4.field2697 = var2;
               var4.field2698 = this;
               Deque var5 = class185.field2727;
               synchronized(class185.field2727) {
                  class185.field2727.method2824(var4);
               }

               Object var10 = class185.field2730;
               synchronized(class185.field2730) {
                  if(class185.field2729 == 0) {
                     class185.field2731 = new Thread(new class185());
                     class185.field2731.setDaemon(true);
                     class185.field2731.start();
                     class185.field2731.setPriority(5);
                  }

                  class185.field2729 = 600;
               }

               this.field2744 = var1;
            }
         }

         if(this.field2744 == -1) {
            this.field2746 = true;
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1969486859"
   )
   void vmethod3383(int var1) {
      class1.method15(this.index, var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-608185415"
   )
   void vmethod3384(int var1) {
      if(this.field2739 != null && this.field2740 != null && this.field2740[var1]) {
         IndexFile var2 = this.field2739;
         byte[] var4 = null;
         Deque var5 = class185.field2727;
         synchronized(class185.field2727) {
            for(class182 var6 = (class182)class185.field2727.method2828(); var6 != null; var6 = (class182)class185.field2727.method2830()) {
               if((long)var1 == var6.hash && var2 == var6.field2697 && var6.field2702 == 0) {
                  var4 = var6.field2695;
                  break;
               }
            }
         }

         if(var4 != null) {
            this.method3401(var2, var1, var4, true);
         } else {
            byte[] var9 = var2.method2242(var1);
            this.method3401(var2, var1, var9, true);
         }
      } else {
         class174.method3261(this, this.index, var1, super.field2712[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1521527335"
   )
   public void method3385(int var1, int var2) {
      this.field2749 = var1;
      this.field2743 = var2;
      if(this.field2736 != null) {
         int var3 = this.index;
         IndexFile var4 = this.field2736;
         byte[] var6 = null;
         Deque var7 = class185.field2727;
         synchronized(class185.field2727) {
            for(class182 var8 = (class182)class185.field2727.method2828(); var8 != null; var8 = (class182)class185.field2727.method2830()) {
               if(var8.hash == (long)var3 && var8.field2697 == var4 && var8.field2702 == 0) {
                  var6 = var8.field2695;
                  break;
               }
            }
         }

         if(var6 != null) {
            this.method3401(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.method2242(var3);
            this.method3401(var4, var3, var11, true);
         }
      } else {
         class174.method3261(this, 255, this.index, this.field2749, (byte)0, true);
      }

   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "9"
   )
   public void method3386(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2746) {
            throw new RuntimeException();
         }

         if(this.field2736 != null) {
            class25.method573(this.index, var2, this.field2736);
         }

         this.method3317(var2);
         this.method3382();
      } else {
         var2[var2.length - 2] = (byte)(super.field2714[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2714[var1];
         if(this.field2739 != null) {
            class25.method573(var1, var2, this.field2739);
            this.field2740[var1] = true;
         }

         if(var4) {
            super.field2708[var1] = XClanMember.method257(var2, false);
         }
      }

   }

   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2739 = var1;
      this.field2736 = var2;
      this.index = var3;
      this.field2748 = var6;
      class163.method3087(this, this.index);
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-709520491"
   )
   int method3388(int var1) {
      if(super.field2708[var1] != null) {
         return 100;
      } else if(this.field2740[var1]) {
         return 100;
      } else {
         int var3 = this.index;
         long var4 = (long)(var1 + (var3 << 16));
         int var2;
         if(class199.field2881 != null && class199.field2881.hash == var4) {
            var2 = class187.field2751.offset * 99 / (class187.field2751.payload.length - class199.field2881.field2705) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1357922543"
   )
   public int method3399() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2708.length; ++var3) {
         if(super.field2711[var3] > 0) {
            var1 += 100;
            var2 += this.method3388(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(LIndexFile;I[BZI)V",
      garbageValue = "-1679490595"
   )
   public void method3401(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field2736 == var1) {
         if(this.field2746) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class174.method3261(this, 255, this.index, this.field2749, (byte)0, true);
            return;
         }

         field2738.reset();
         field2738.update(var3, 0, var3.length);
         var5 = (int)field2738.getValue();
         Buffer var6 = new Buffer(class170.method3184(var3));
         int var7 = var6.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.readInt();
         }

         if(this.field2749 != var5 || this.field2743 != var8) {
            class174.method3261(this, 255, this.index, this.field2749, (byte)0, true);
            return;
         }

         this.method3317(var3);
         this.method3382();
      } else {
         if(!var4 && var2 == this.field2744) {
            this.field2746 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field2740[var2] = false;
            if(this.field2748 || var4) {
               class174.method3261(this, this.index, var2, super.field2712[var2], (byte)2, var4);
            }

            return;
         }

         field2738.reset();
         field2738.update(var3, 0, var3.length - 2);
         var5 = (int)field2738.getValue();
         int var9 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
         if(super.field2712[var2] != var5 || super.field2714[var2] != var9) {
            this.field2740[var2] = false;
            if(this.field2748 || var4) {
               class174.method3261(this, this.index, var2, super.field2712[var2], (byte)2, var4);
            }

            return;
         }

         this.field2740[var2] = true;
         if(var4) {
            super.field2708[var2] = XClanMember.method257(var3, false);
         }
      }

   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   public int method3407() {
      if(this.field2746) {
         return 100;
      } else if(super.field2708 != null) {
         return 99;
      } else {
         int var2 = this.index;
         long var5 = (long)(var2 + 16711680);
         int var1;
         if(class199.field2881 != null && class199.field2881.hash == var5) {
            var1 = class187.field2751.offset * 99 / (class187.field2751.payload.length - class199.field2881.field2705) + 1;
         } else {
            var1 = 0;
         }

         int var3 = var1;
         if(var1 >= 100) {
            var3 = 99;
         }

         return var3;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass142;III)I",
      garbageValue = "581717904"
   )
   static int method3408(class142 var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         class154 var3 = (class154)var0.method2728((long)var1);
         return var3 == null?var2:var3.field2046;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "667872720"
   )
   public static File method3410(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class104.field1684 = new File(class20.field216, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      File var22;
      if(class104.field1684.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class104.field1684, "rw", 10000L);

            Buffer var8;
            int var9;
            for(var8 = new Buffer((int)var7.method1438()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.method1427(var8.payload, var8.offset, var8.payload.length - var8.offset);
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
               var4 = var8.method2430();
               if(var10 == 1) {
                  var5 = var8.method2430();
               }
            } else {
               var4 = var8.method2549();
               if(var10 == 1) {
                  var5 = var8.method2549();
               }
            }

            var7.method1425();
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
            if(!Preferences.method642(var22, true)) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label125:
         for(int var15 = 0; var15 < class190.field2792.length; ++var15) {
            for(int var16 = 0; var16 < class104.field1678.length; ++var16) {
               File var17 = new File(class104.field1678[var16] + class190.field2792[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && Preferences.method642(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label125;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class20.field216 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
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
         Widget.method3243(new File(var4), (File)null);
      }

      return new File(var4);
   }
}
