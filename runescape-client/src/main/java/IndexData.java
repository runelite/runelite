import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("j")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("nk")
   static byte field3231;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   IndexFile field3222;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1062294471
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   IndexFile field3229;
   @ObfuscatedName("a")
   volatile boolean field3225;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1756813029
   )
   @Export("index")
   int index;
   @ObfuscatedName("z")
   volatile boolean[] field3226;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 564316621
   )
   int field3224;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -298525511
   )
   int field3230;
   @ObfuscatedName("h")
   boolean field3232;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfv;Lfv;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3225 = false;
      this.field3232 = false;
      this.field3230 = -1;
      this.field3229 = var1;
      this.field3222 = var2;
      this.index = var3;
      this.field3232 = var6;
      int var8 = this.index;
      if(class56.field657 != null) {
         class56.field657.offset = var8 * 8 + 5;
         int var9 = class56.field657.readInt();
         int var10 = class56.field657.readInt();
         this.setInformation(var9, var10);
      } else {
         class43.method628((IndexData)null, 255, 255, 0, (byte)0, true);
         class238.field3249[var8] = this;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-662820782"
   )
   void vmethod4201(int var1) {
      if(this.field3229 != null && this.field3226 != null && this.field3226[var1]) {
         class66.method1109(var1, this.field3229, this);
      } else {
         class43.method628(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-282715715"
   )
   int vmethod4221(int var1) {
      if(super.field3203[var1] != null) {
         return 100;
      } else if(this.field3226[var1]) {
         return 100;
      } else {
         int var3 = this.index;
         long var4 = (long)((var3 << 16) + var1);
         int var2;
         if(Buffer.currentRequest != null && Buffer.currentRequest.hash == var4) {
            var2 = Ignore.field833.offset * 99 / (Ignore.field833.payload.length - Buffer.currentRequest.padding) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1967169057"
   )
   void method4208() {
      this.field3226 = new boolean[super.field3203.length];

      int var1;
      for(var1 = 0; var1 < this.field3226.length; ++var1) {
         this.field3226[var1] = false;
      }

      if(this.field3229 == null) {
         this.field3225 = true;
      } else {
         this.field3230 = -1;

         for(var1 = 0; var1 < this.field3226.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               class169.method3167(var1, this.field3229, this);
               this.field3230 = var1;
            }
         }

         if(this.field3230 == -1) {
            this.field3225 = true;
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1194485401"
   )
   void vmethod4203(int var1) {
      int var2 = this.index;
      long var3 = (long)((var2 << 16) + var1);
      FileRequest var5 = (FileRequest)class238.field3241.get(var3);
      if(var5 != null) {
         class238.field3240.setHead(var5);
      }

   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(Lfv;I[BZB)V",
      garbageValue = "-2"
   )
   public void method4235(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field3222) {
         if(this.field3225) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class43.method628(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         Buffer var9 = new Buffer(WidgetNode.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var5 != this.crcValue || var8 != this.field3224) {
            class43.method628(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.method4137(var3);
         this.method4208();
      } else {
         if(!var4 && var2 == this.field3230) {
            this.field3225 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field3226[var2] = false;
            if(this.field3232 || var4) {
               class43.method628(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.field3226[var2] = false;
            if(this.field3232 || var4) {
               class43.method628(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.field3226[var2] = true;
         if(var4) {
            super.field3203[var2] = XClanMember.method1171(var3, false);
         }
      }

   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2033387061"
   )
   @Export("setInformation")
   void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.field3224 = var2;
      if(this.field3222 != null) {
         class66.method1109(this.index, this.field3222, this);
      } else {
         class43.method628(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "47"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3225) {
         return 100;
      } else if(super.field3203 != null) {
         return 99;
      } else {
         int var2 = this.index;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(Buffer.currentRequest != null && var3 == Buffer.currentRequest.hash) {
            var1 = Ignore.field833.offset * 99 / (Ignore.field833.payload.length - Buffer.currentRequest.padding) + 1;
         } else {
            var1 = 0;
         }

         int var5 = var1;
         if(var1 >= 100) {
            var5 = 99;
         }

         return var5;
      }
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "577221341"
   )
   public int method4209() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field3203.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.vmethod4221(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "1755650541"
   )
   void method4206(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3225) {
            throw new RuntimeException();
         }

         if(this.field3222 != null) {
            int var5 = this.index;
            IndexFile var6 = this.field3222;
            FileSystem var7 = new FileSystem();
            var7.field3180 = 0;
            var7.hash = (long)var5;
            var7.field3181 = var2;
            var7.index = var6;
            Deque var8 = class236.field3220;
            synchronized(class236.field3220) {
               class236.field3220.addFront(var7);
            }

            Object var21 = class236.field3213;
            synchronized(class236.field3213) {
               if(class236.field3216 == 0) {
                  class236.field3217 = new Thread(new class236());
                  class236.field3217.setDaemon(true);
                  class236.field3217.start();
                  class236.field3217.setPriority(5);
               }

               class236.field3216 = 600;
            }
         }

         this.method4137(var2);
         this.method4208();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.field3229 != null) {
            IndexFile var13 = this.field3229;
            FileSystem var18 = new FileSystem();
            var18.field3180 = 0;
            var18.hash = (long)var1;
            var18.field3181 = var2;
            var18.index = var13;
            Deque var19 = class236.field3220;
            synchronized(class236.field3220) {
               class236.field3220.addFront(var18);
            }

            Object var20 = class236.field3213;
            synchronized(class236.field3213) {
               if(class236.field3216 == 0) {
                  class236.field3217 = new Thread(new class236());
                  class236.field3217.setDaemon(true);
                  class236.field3217.start();
                  class236.field3217.setPriority(5);
               }

               class236.field3216 = 600;
            }

            this.field3226[var1] = true;
         }

         if(var4) {
            super.field3203[var1] = XClanMember.method1171(var2, false);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BB)Ljava/lang/String;",
      garbageValue = "-114"
   )
   public static String method4210(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < var2 + 0; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class269.field3661[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class269.field3661[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class269.field3661[(var6 & 15) << 2 | var7 >>> 6]).append(class269.field3661[var7 & 63]);
            } else {
               var3.append(class269.field3661[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class269.field3661[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }
}
