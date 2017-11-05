import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("f")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   IndexFile field3235;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   IndexFile field3233;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -225565581
   )
   @Export("index")
   int index;
   @ObfuscatedName("r")
   volatile boolean field3232;
   @ObfuscatedName("m")
   boolean field3236;
   @ObfuscatedName("l")
   volatile boolean[] field3237;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 641015623
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1054200217
   )
   int field3240;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1829580295
   )
   int field3234;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfr;Lfr;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3232 = false;
      this.field3236 = false;
      this.field3234 = -1;
      this.field3235 = var1;
      this.field3233 = var2;
      this.index = var3;
      this.field3236 = var6;
      class56.method816(this, this.index);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "609099973"
   )
   void vmethod4299(int var1) {
      int var2 = this.index;
      long var3 = (long)((var2 << 16) + var1);
      FileRequest var5 = (FileRequest)class238.field3252.get(var3);
      if(var5 != null) {
         class238.field3261.setHead(var5);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "6612"
   )
   int vmethod4320(int var1) {
      return super.field3219[var1] != null?100:(this.field3237[var1]?100:class114.method2168(this.index, var1));
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "43"
   )
   void vmethod4295(int var1) {
      if(this.field3235 != null && this.field3237 != null && this.field3237[var1]) {
         class22.method174(var1, this.field3235, this);
      } else {
         class14.method87(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-88"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3232) {
         return 100;
      } else if(super.field3219 != null) {
         return 99;
      } else {
         int var1 = class114.method2168(255, this.index);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "2"
   )
   @Export("setInformation")
   void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.field3240 = var2;
      if(this.field3233 != null) {
         int var3 = this.index;
         IndexFile var4 = this.field3233;
         byte[] var6 = null;
         Deque var7 = class236.field3229;
         synchronized(class236.field3229) {
            for(FileSystem var8 = (FileSystem)class236.field3229.getFront(); var8 != null; var8 = (FileSystem)class236.field3229.getNext()) {
               if(var8.hash == (long)var3 && var4 == var8.index && var8.field3200 == 0) {
                  var6 = var8.field3197;
                  break;
               }
            }
         }

         if(var6 != null) {
            this.method4298(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.method3060(var3);
            this.method4298(var4, var3, var11, true);
         }
      } else {
         class14.method87(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "-1551921869"
   )
   void method4321(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3232) {
            throw new RuntimeException();
         }

         if(this.field3233 != null) {
            class224.method4155(this.index, var2, this.field3233);
         }

         this.method4239(var2);
         this.method4313();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.field3235 != null) {
            class224.method4155(var1, var2, this.field3235);
            this.field3237[var1] = true;
         }

         if(var4) {
            super.field3219[var1] = GameEngine.method934(var2, false);
         }
      }

   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(Lfr;I[BZS)V",
      garbageValue = "13853"
   )
   void method4298(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field3233) {
         if(this.field3232) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class14.method87(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         Buffer var9 = new Buffer(class174.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var5 != this.crcValue || var8 != this.field3240) {
            class14.method87(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.method4239(var3);
         this.method4313();
      } else {
         if(!var4 && var2 == this.field3234) {
            this.field3232 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field3237[var2] = false;
            if(this.field3236 || var4) {
               class14.method87(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.field3237[var2] = false;
            if(this.field3236 || var4) {
               class14.method87(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.field3237[var2] = true;
         if(var4) {
            super.field3219[var2] = GameEngine.method934(var3, false);
         }
      }

   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1960709689"
   )
   void method4313() {
      this.field3237 = new boolean[super.field3219.length];

      int var1;
      for(var1 = 0; var1 < this.field3237.length; ++var1) {
         this.field3237[var1] = false;
      }

      if(this.field3235 == null) {
         this.field3232 = true;
      } else {
         this.field3234 = -1;

         for(var1 = 0; var1 < this.field3237.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               class18.method139(var1, this.field3235, this);
               this.field3234 = var1;
            }
         }

         if(this.field3234 == -1) {
            this.field3232 = true;
         }

      }
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1427218670"
   )
   public int method4301() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field3219.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.vmethod4320(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lhj;I)Ljava/lang/String;",
      garbageValue = "-1898595275"
   )
   static String method4312(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + Client.method1521(class9.method52(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var6 = "";
            if(class46.field609 != null) {
               int var5 = class46.field609.field2222;
               String var4 = (var5 >> 24 & 255) + "." + (var5 >> 16 & 255) + "." + (var5 >> 8 & 255) + "." + (var5 & 255);
               var6 = var4;
               if(class46.field609.value != null) {
                  var6 = (String)class46.field609.value;
               }
            }

            var0 = var0.substring(0, var2) + var6 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }
}
