import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("a")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   IndexFile field3314;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   IndexFile field3312;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1458771797
   )
   @Export("index")
   int index;
   @ObfuscatedName("o")
   volatile boolean field3315;
   @ObfuscatedName("w")
   boolean field3316;
   @ObfuscatedName("g")
   volatile boolean[] field3317;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 365666583
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -917541101
   )
   int field3318;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1242302273
   )
   int field3321;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lff;Lff;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3315 = false;
      this.field3316 = false;
      this.field3321 = -1;
      this.field3314 = var1;
      this.field3312 = var2;
      this.index = var3;
      this.field3316 = var6;
      int var8 = this.index;
      if(class245.field3339 != null) {
         class245.field3339.offset = var8 * 8 + 5;
         int var9 = class245.field3339.readInt();
         int var10 = class245.field3339.readInt();
         this.setInformation(var9, var10);
      } else {
         Widget.method4198((IndexData)null, 255, 255, 0, (byte)0, true);
         class245.field3324[var8] = this;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1802560355"
   )
   void vmethod4370(int var1) {
      int var2 = this.index;
      long var3 = (long)((var2 << 16) + var1);
      FileRequest var5 = (FileRequest)class245.field3330.get(var3);
      if(var5 != null) {
         class245.field3329.setHead(var5);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "102"
   )
   int vmethod4378(int var1) {
      return super.field3298[var1] != null?100:(this.field3317[var1]?100:class94.method1830(this.index, var1));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "559861157"
   )
   void vmethod4373(int var1) {
      if(this.field3314 != null && this.field3317 != null && this.field3317[var1]) {
         IndexFile var2 = this.field3314;
         byte[] var4 = null;
         Deque var5 = class243.field3307;
         synchronized(class243.field3307) {
            for(FileSystem var6 = (FileSystem)class243.field3307.getFront(); var6 != null; var6 = (FileSystem)class243.field3307.getNext()) {
               if(var6.hash == (long)var1 && var2 == var6.index && var6.field3282 == 0) {
                  var4 = var6.field3280;
                  break;
               }
            }
         }

         if(var4 != null) {
            this.method4376(var2, var1, var4, true);
         } else {
            byte[] var9 = var2.method3136(var1);
            this.method4376(var2, var1, var9, true);
         }
      } else {
         Widget.method4198(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1537610235"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3315) {
         return 100;
      } else if(super.field3298 != null) {
         return 99;
      } else {
         int var1 = class94.method1830(255, this.index);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "71"
   )
   @Export("setInformation")
   public void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.field3318 = var2;
      if(this.field3312 != null) {
         int var3 = this.index;
         IndexFile var4 = this.field3312;
         byte[] var6 = null;
         Deque var7 = class243.field3307;
         synchronized(class243.field3307) {
            for(FileSystem var8 = (FileSystem)class243.field3307.getFront(); var8 != null; var8 = (FileSystem)class243.field3307.getNext()) {
               if(var8.hash == (long)var3 && var4 == var8.index && var8.field3282 == 0) {
                  var6 = var8.field3280;
                  break;
               }
            }
         }

         if(var6 != null) {
            this.method4376(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.method3136(var3);
            this.method4376(var4, var3, var11, true);
         }
      } else {
         Widget.method4198(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "1999058662"
   )
   public void method4384(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3315) {
            throw new RuntimeException();
         }

         if(this.field3312 != null) {
            KeyFocusListener.method762(this.index, var2, this.field3312);
         }

         this.method4263(var2);
         this.method4377();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.field3314 != null) {
            KeyFocusListener.method762(var1, var2, this.field3314);
            this.field3317[var1] = true;
         }

         if(var4) {
            super.field3298[var1] = class18.method157(var2, false);
         }
      }

   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(Lff;I[BZB)V",
      garbageValue = "-61"
   )
   void method4376(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field3312) {
         if(this.field3315) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            Widget.method4198(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         Buffer var9 = new Buffer(class1.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var5 != this.crcValue || var8 != this.field3318) {
            Widget.method4198(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.method4263(var3);
         this.method4377();
      } else {
         if(!var4 && var2 == this.field3321) {
            this.field3315 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field3317[var2] = false;
            if(this.field3316 || var4) {
               Widget.method4198(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.field3317[var2] = false;
            if(this.field3316 || var4) {
               Widget.method4198(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.field3317[var2] = true;
         if(var4) {
            super.field3298[var2] = class18.method157(var3, false);
         }
      }

   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "69"
   )
   void method4377() {
      this.field3317 = new boolean[super.field3298.length];

      int var1;
      for(var1 = 0; var1 < this.field3317.length; ++var1) {
         this.field3317[var1] = false;
      }

      if(this.field3314 == null) {
         this.field3315 = true;
      } else {
         this.field3321 = -1;

         for(var1 = 0; var1 < this.field3317.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               PacketNode.method3214(var1, this.field3314, this);
               this.field3321 = var1;
            }
         }

         if(this.field3321 == -1) {
            this.field3315 = true;
         }

      }
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1967216650"
   )
   public int method4379() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field3298.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.vmethod4378(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgi;III)I",
      garbageValue = "278310344"
   )
   static int method4372(IterableHashTable var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null?var2:var3.value;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "373452857"
   )
   public static void method4405() {
      MouseInput var0 = MouseInput.mouse;
      synchronized(MouseInput.mouse) {
         MouseInput.field705 = MouseInput.field704;
         MouseInput.field703 = MouseInput.mouseX;
         MouseInput.field715 = MouseInput.mouseY * -2054651093;
         MouseInput.field708 = MouseInput.field713;
         MouseInput.field709 = MouseInput.field694;
         MouseInput.field710 = MouseInput.field706;
         MouseInput.field697 = MouseInput.field707;
         MouseInput.field713 = 0;
      }
   }
}
