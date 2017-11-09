import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("q")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   IndexFile field3310;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   IndexFile field3303;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1458193655
   )
   @Export("index")
   int index;
   @ObfuscatedName("d")
   volatile boolean field3305;
   @ObfuscatedName("s")
   boolean field3306;
   @ObfuscatedName("f")
   volatile boolean[] field3308;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1015026193
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1134752585
   )
   int field3307;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1731659967
   )
   int field3311;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfe;Lfe;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3305 = false;
      this.field3306 = false;
      this.field3311 = -1;
      this.field3310 = var1;
      this.field3303 = var2;
      this.index = var3;
      this.field3306 = var6;
      class27.method242(this, this.index);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1176382278"
   )
   void vmethod4400(int var1) {
      int var2 = this.index;
      long var3 = (long)((var2 << 16) + var1);
      FileRequest var5 = (FileRequest)class245.field3321.get(var3);
      if(var5 != null) {
         class245.field3326.setHead(var5);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1828486885"
   )
   int vmethod4391(int var1) {
      return super.field3276[var1] != null?100:(this.field3308[var1]?100:class139.method2966(this.index, var1));
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void vmethod4386(int var1) {
      if(this.field3310 != null && this.field3308 != null && this.field3308[var1]) {
         class189.method3616(var1, this.field3310, this);
      } else {
         ClanMember.method1227(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-34"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3305) {
         return 100;
      } else if(super.field3276 != null) {
         return 99;
      } else {
         int var1 = class139.method2966(255, this.index);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-333204809"
   )
   @Export("setInformation")
   void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.field3307 = var2;
      if(this.field3303 != null) {
         class189.method3616(this.index, this.field3303, this);
      } else {
         ClanMember.method1227(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "-1107118213"
   )
   void method4412(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3305) {
            throw new RuntimeException();
         }

         if(this.field3303 != null) {
            class36.method543(this.index, var2, this.field3303);
         }

         this.method4277(var2);
         this.method4390();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.field3310 != null) {
            class36.method543(var1, var2, this.field3310);
            this.field3308[var1] = true;
         }

         if(var4) {
            super.field3276[var1] = class182.method3517(var2, false);
         }
      }

   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(Lfe;I[BZI)V",
      garbageValue = "1753118300"
   )
   public void method4389(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field3303) {
         if(this.field3305) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            ClanMember.method1227(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         Buffer var9 = new Buffer(DynamicObject.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var5 != this.crcValue || var8 != this.field3307) {
            ClanMember.method1227(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.method4277(var3);
         this.method4390();
      } else {
         if(!var4 && var2 == this.field3311) {
            this.field3305 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field3308[var2] = false;
            if(this.field3306 || var4) {
               ClanMember.method1227(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.field3308[var2] = false;
            if(this.field3306 || var4) {
               ClanMember.method1227(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.field3308[var2] = true;
         if(var4) {
            super.field3276[var2] = class182.method3517(var3, false);
         }
      }

   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "664407819"
   )
   void method4390() {
      this.field3308 = new boolean[super.field3276.length];

      int var1;
      for(var1 = 0; var1 < this.field3308.length; ++var1) {
         this.field3308[var1] = false;
      }

      if(this.field3310 == null) {
         this.field3305 = true;
      } else {
         this.field3311 = -1;

         for(var1 = 0; var1 < this.field3308.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               class228.method4237(var1, this.field3310, this);
               this.field3311 = var1;
            }
         }

         if(this.field3311 == -1) {
            this.field3305 = true;
         }

      }
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2048809467"
   )
   public int method4392() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field3276.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.vmethod4391(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }
}
