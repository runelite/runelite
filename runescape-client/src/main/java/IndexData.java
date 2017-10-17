import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("ij")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("m")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   IndexFile field3240;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   IndexFile field3244;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1692707415
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("l")
   volatile boolean field3242;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1975586357
   )
   @Export("index")
   int index;
   @ObfuscatedName("n")
   volatile boolean[] field3241;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 756564445
   )
   int field3248;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1663109401
   )
   int field3246;
   @ObfuscatedName("w")
   boolean field3243;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfr;Lfr;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3242 = false;
      this.field3243 = false;
      this.field3246 = -1;
      this.field3244 = var1;
      this.field3240 = var2;
      this.index = var3;
      this.field3243 = var6;
      int var8 = this.index;
      if(SceneTilePaint.field2033 != null) {
         SceneTilePaint.field2033.offset = var8 * 8 + 5;
         int var9 = SceneTilePaint.field2033.readInt();
         int var10 = SceneTilePaint.field2033.readInt();
         this.setInformation(var9, var10);
      } else {
         class224.method4193((IndexData)null, 255, 255, 0, (byte)0, true);
         class238.field3260[var8] = this;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1778515348"
   )
   void vmethod4340(int var1) {
      if(this.field3244 != null && this.field3241 != null && this.field3241[var1]) {
         IndexFile var2 = this.field3244;
         byte[] var4 = null;
         Deque var5 = class236.field3237;
         synchronized(class236.field3237) {
            for(FileSystem var6 = (FileSystem)class236.field3237.getFront(); var6 != null; var6 = (FileSystem)class236.field3237.getNext()) {
               if(var6.hash == (long)var1 && var2 == var6.index && var6.field3206 == 0) {
                  var4 = var6.field3203;
                  break;
               }
            }
         }

         if(var4 != null) {
            this.method4319(var2, var1, var4, true);
         } else {
            byte[] var9 = var2.method3100(var1);
            this.method4319(var2, var1, var9, true);
         }
      } else {
         class224.method4193(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "102"
   )
   int vmethod4321(int var1) {
      return super.field3221[var1] != null?100:(this.field3241[var1]?100:class225.method4197(this.index, var1));
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method4320() {
      this.field3241 = new boolean[super.field3221.length];

      int var1;
      for(var1 = 0; var1 < this.field3241.length; ++var1) {
         this.field3241[var1] = false;
      }

      if(this.field3244 == null) {
         this.field3242 = true;
      } else {
         this.field3246 = -1;

         for(var1 = 0; var1 < this.field3241.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               FaceNormal.method2939(var1, this.field3244, this);
               this.field3246 = var1;
            }
         }

         if(this.field3246 == -1) {
            this.field3242 = true;
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "5"
   )
   void vmethod4315(int var1) {
      class51.method789(this.index, var1);
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(Lfr;I[BZB)V",
      garbageValue = "55"
   )
   public void method4319(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field3240) {
         if(this.field3242) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class224.method4193(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         Buffer var9 = new Buffer(class170.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var5 != this.crcValue || var8 != this.field3248) {
            class224.method4193(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.method4216(var3);
         this.method4320();
      } else {
         if(!var4 && var2 == this.field3246) {
            this.field3242 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field3241[var2] = false;
            if(this.field3243 || var4) {
               class224.method4193(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.field3241[var2] = false;
            if(this.field3243 || var4) {
               class224.method4193(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.field3241[var2] = true;
         if(var4) {
            super.field3221[var2] = ScriptVarType.method26(var3, false);
         }
      }

   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1868366307"
   )
   @Export("setInformation")
   void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.field3248 = var2;
      if(this.field3240 != null) {
         int var3 = this.index;
         IndexFile var4 = this.field3240;
         byte[] var6 = null;
         Deque var7 = class236.field3237;
         synchronized(class236.field3237) {
            for(FileSystem var8 = (FileSystem)class236.field3237.getFront(); var8 != null; var8 = (FileSystem)class236.field3237.getNext()) {
               if(var8.hash == (long)var3 && var4 == var8.index && var8.field3206 == 0) {
                  var6 = var8.field3203;
                  break;
               }
            }
         }

         if(var6 != null) {
            this.method4319(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.method3100(var3);
            this.method4319(var4, var3, var11, true);
         }
      } else {
         class224.method4193(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1049324614"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3242) {
         return 100;
      } else if(super.field3221 != null) {
         return 99;
      } else {
         int var1 = class225.method4197(255, this.index);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "1"
   )
   void method4318(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3242) {
            throw new RuntimeException();
         }

         if(this.field3240 != null) {
            int var5 = this.index;
            IndexFile var6 = this.field3240;
            FileSystem var7 = new FileSystem();
            var7.field3206 = 0;
            var7.hash = (long)var5;
            var7.field3203 = var2;
            var7.index = var6;
            Deque var8 = class236.field3237;
            synchronized(class236.field3237) {
               class236.field3237.addFront(var7);
            }

            Object var21 = class236.field3236;
            synchronized(class236.field3236) {
               if(class236.field3234 == 0) {
                  class236.field3235 = new Thread(new class236());
                  class236.field3235.setDaemon(true);
                  class236.field3235.start();
                  class236.field3235.setPriority(5);
               }

               class236.field3234 = 600;
            }
         }

         this.method4216(var2);
         this.method4320();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.field3244 != null) {
            IndexFile var13 = this.field3244;
            FileSystem var18 = new FileSystem();
            var18.field3206 = 0;
            var18.hash = (long)var1;
            var18.field3203 = var2;
            var18.index = var13;
            Deque var19 = class236.field3237;
            synchronized(class236.field3237) {
               class236.field3237.addFront(var18);
            }

            Object var20 = class236.field3236;
            synchronized(class236.field3236) {
               if(class236.field3234 == 0) {
                  class236.field3235 = new Thread(new class236());
                  class236.field3235.setDaemon(true);
                  class236.field3235.start();
                  class236.field3235.setPriority(5);
               }

               class236.field3234 = 600;
            }

            this.field3241[var1] = true;
         }

         if(var4) {
            super.field3221[var1] = ScriptVarType.method26(var2, false);
         }
      }

   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "15119"
   )
   public int method4322() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field3221.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.vmethod4321(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1438866591"
   )
   static final void method4316() {
      Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CLOSED_WINDOW);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3646(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3647()) {
         if(var0.owner == 0 || var0.owner == 3) {
            PendingSpawn.method1584(var0, true);
         }
      }

      if(Client.field1077 != null) {
         class25.method172(Client.field1077);
         Client.field1077 = null;
      }

   }
}
