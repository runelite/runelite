import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("q")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   static BuildType field3233;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   IndexFile field3234;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1032074727
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   IndexFile field3225;
   @ObfuscatedName("x")
   volatile boolean field3226;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -238307721
   )
   @Export("index")
   int index;
   @ObfuscatedName("j")
   volatile boolean[] field3228;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1189380023
   )
   int field3231;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -867870039
   )
   int field3232;
   @ObfuscatedName("i")
   boolean field3223;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfq;Lfq;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3226 = false;
      this.field3223 = false;
      this.field3232 = -1;
      this.field3225 = var1;
      this.field3234 = var2;
      this.index = var3;
      this.field3223 = var6;
      class60.method1027(this, this.index);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1333197963"
   )
   void vmethod4211(int var1) {
      if(this.field3225 != null && this.field3228 != null && this.field3228[var1]) {
         class226.method4084(var1, this.field3225, this);
      } else {
         class258.method4651(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1623590145"
   )
   int vmethod4213(int var1) {
      return super.field3199[var1] != null?100:(this.field3228[var1]?100:class239.method4245(this.index, var1));
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "122458479"
   )
   void method4212() {
      this.field3228 = new boolean[super.field3199.length];

      int var1;
      for(var1 = 0; var1 < this.field3228.length; ++var1) {
         this.field3228[var1] = false;
      }

      if(this.field3225 == null) {
         this.field3226 = true;
      } else {
         this.field3232 = -1;

         for(var1 = 0; var1 < this.field3228.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               IndexFile var2 = this.field3225;
               FileSystem var4 = new FileSystem();
               var4.field3189 = 1;
               var4.hash = (long)var1;
               var4.index = var2;
               var4.data = this;
               Deque var5 = class237.field3215;
               synchronized(class237.field3215) {
                  class237.field3215.addFront(var4);
               }

               Object var10 = class237.field3217;
               synchronized(class237.field3217) {
                  if(class237.field3216 == 0) {
                     class237.field3219 = new Thread(new class237());
                     class237.field3219.setDaemon(true);
                     class237.field3219.start();
                     class237.field3219.setPriority(5);
                  }

                  class237.field3216 = 600;
               }

               this.field3232 = var1;
            }
         }

         if(this.field3232 == -1) {
            this.field3226 = true;
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1873316388"
   )
   void vmethod4208(int var1) {
      Buffer.method3312(this.index, var1);
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(Lfq;I[BZB)V",
      garbageValue = "2"
   )
   public void method4207(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field3234) {
         if(this.field3226) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class258.method4651(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         Buffer var9 = new Buffer(class171.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var5 != this.crcValue || var8 != this.field3231) {
            class258.method4651(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.method4163(var3);
         this.method4212();
      } else {
         if(!var4 && var2 == this.field3232) {
            this.field3226 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field3228[var2] = false;
            if(this.field3223 || var4) {
               class258.method4651(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.field3228[var2] = false;
            if(this.field3223 || var4) {
               class258.method4651(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.field3228[var2] = true;
         if(var4) {
            super.field3199[var2] = class89.method1732(var3, false);
         }
      }

   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-952838716"
   )
   @Export("setInformation")
   public void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.field3231 = var2;
      if(this.field3234 != null) {
         class226.method4084(this.index, this.field3234, this);
      } else {
         class258.method4651(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-524486370"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3226) {
         return 100;
      } else if(super.field3199 != null) {
         return 99;
      } else {
         int var1 = class239.method4245(255, this.index);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "70"
   )
   public int method4214() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field3199.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.vmethod4213(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "-614750541"
   )
   public void method4215(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3226) {
            throw new RuntimeException();
         }

         if(this.field3234 != null) {
            class61.method1070(this.index, var2, this.field3234);
         }

         this.method4163(var2);
         this.method4212();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.field3225 != null) {
            class61.method1070(var1, var2, this.field3225);
            this.field3228[var1] = true;
         }

         if(var4) {
            super.field3199[var1] = class89.method1732(var2, false);
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "80840268"
   )
   static void method4242(int var0) {
      if(var0 != -1) {
         if(class10.loadWidget(var0)) {
            Widget[] var1 = Item.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2647 != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.field849 = var3.field2647;
                  class8.method40(var4, 2000000);
               }
            }

         }
      }
   }
}
