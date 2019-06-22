import java.math.BigInteger;
import java.util.logging.Logger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("q")
   @Export("__gr_q")
   static int[] __gr_q;
   @ObfuscatedName("o")
   @Export("__gr_o")
   static long[] __gr_o;
   @ObfuscatedName("m")
   @Export("array")
   public byte[] array;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -271438207
   )
   @Export("index")
   public int index;

   public Buffer(int var1) {
      this.array = Canvas.method862(var1);
      this.index = 0;
   }

   public Buffer(byte[] var1) {
      this.array = var1;
      this.index = 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "13572"
   )
   @Export("__f_295")
   public void __f_295() {
      if(this.array != null) {
         VertexNormal.method2984(this.array);
      }

      this.array = null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-654332799"
   )
   @Export("writeByte")
   public void writeByte(int var1) {
      this.array[++this.index - 1] = (byte)var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   @Export("writeShort")
   public void writeShort(int var1) {
      this.array[++this.index - 1] = (byte)(var1 >> 8);
      this.array[++this.index - 1] = (byte)var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-26"
   )
   @Export("writeMedium")
   public void writeMedium(int var1) {
      this.array[++this.index - 1] = (byte)(var1 >> 16);
      this.array[++this.index - 1] = (byte)(var1 >> 8);
      this.array[++this.index - 1] = (byte)var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-106996411"
   )
   @Export("writeInt")
   public void writeInt(int var1) {
      this.array[++this.index - 1] = (byte)(var1 >> 24);
      this.array[++this.index - 1] = (byte)(var1 >> 16);
      this.array[++this.index - 1] = (byte)(var1 >> 8);
      this.array[++this.index - 1] = (byte)var1;
   }

   @ObfuscatedName("g")
   @Export("writeLongMedium")
   public void writeLongMedium(long var1) {
      this.array[++this.index - 1] = (byte)((int)(var1 >> 40));
      this.array[++this.index - 1] = (byte)((int)(var1 >> 32));
      this.array[++this.index - 1] = (byte)((int)(var1 >> 24));
      this.array[++this.index - 1] = (byte)((int)(var1 >> 16));
      this.array[++this.index - 1] = (byte)((int)(var1 >> 8));
      this.array[++this.index - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("l")
   @Export("writeLong")
   public void writeLong(long var1) {
      this.array[++this.index - 1] = (byte)((int)(var1 >> 56));
      this.array[++this.index - 1] = (byte)((int)(var1 >> 48));
      this.array[++this.index - 1] = (byte)((int)(var1 >> 40));
      this.array[++this.index - 1] = (byte)((int)(var1 >> 32));
      this.array[++this.index - 1] = (byte)((int)(var1 >> 24));
      this.array[++this.index - 1] = (byte)((int)(var1 >> 16));
      this.array[++this.index - 1] = (byte)((int)(var1 >> 8));
      this.array[++this.index - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-125"
   )
   @Export("writeBoolean")
   public void writeBoolean(boolean var1) {
      this.writeByte(var1?1:0);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-9"
   )
   @Export("writeStringCp1252NullTerminated")
   public void writeStringCp1252NullTerminated(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.index += SoundCache.encodeStringCp1252(var1, 0, var1.length(), this.array, this.index);
         this.array[++this.index - 1] = 0;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "22356"
   )
   @Export("writeStringCp1252NullCircumfixed")
   public void writeStringCp1252NullCircumfixed(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.array[++this.index - 1] = 0;
         this.index += SoundCache.encodeStringCp1252(var1, 0, var1.length(), this.array, this.index);
         this.array[++this.index - 1] = 0;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)V",
      garbageValue = "58"
   )
   @Export("__j_296")
   public void __j_296(CharSequence var1) {
      int var2 = var1.length();
      int var3 = 0;

      for(int var4 = 0; var4 < var2; ++var4) {
         char var5 = var1.charAt(var4);
         if(var5 <= 127) {
            ++var3;
         } else if(var5 <= 2047) {
            var3 += 2;
         } else {
            var3 += 3;
         }
      }

      this.array[++this.index - 1] = 0;
      this.__c_301(var3);
      this.index += class16.method190(this.array, this.index, var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1915344405"
   )
   @Export("__s_297")
   public void __s_297(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.array[++this.index - 1] = var1[var4];
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-225163682"
   )
   @Export("__t_298")
   public void __t_298(int var1) {
      this.array[this.index - var1 - 4] = (byte)(var1 >> 24);
      this.array[this.index - var1 - 3] = (byte)(var1 >> 16);
      this.array[this.index - var1 - 2] = (byte)(var1 >> 8);
      this.array[this.index - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1298210761"
   )
   @Export("__y_299")
   public void __y_299(int var1) {
      this.array[this.index - var1 - 2] = (byte)(var1 >> 8);
      this.array[this.index - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1839722163"
   )
   @Export("__h_300")
   public void __h_300(int var1) {
      this.array[this.index - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1324532803"
   )
   @Export("writeSmartByteShort")
   public void writeSmartByteShort(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.writeByte(var1);
      } else {
         if(var1 < 0 || var1 >= 32768) {
            throw new IllegalArgumentException();
         }

         this.writeShort(var1 + 32768);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "820873705"
   )
   @Export("__c_301")
   public void __c_301(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.writeByte(var1 >>> 28 | 128);
               }

               this.writeByte(var1 >>> 21 | 128);
            }

            this.writeByte(var1 >>> 14 | 128);
         }

         this.writeByte(var1 >>> 7 | 128);
      }

      this.writeByte(var1 & 127);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "82"
   )
   @Export("readUnsignedByte")
   public int readUnsignedByte() {
      return this.array[++this.index - 1] & 255;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1627696222"
   )
   @Export("readByte")
   public byte readByte() {
      return this.array[++this.index - 1];
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-86"
   )
   @Export("__ag_302")
   public int __ag_302() {
      this.index += 2;
      return (this.array[this.index - 1] & 255) + ((this.array[this.index - 2] & 255) << 8);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   @Export("__aq_303")
   public int __aq_303() {
      this.index += 2;
      int var1 = (this.array[this.index - 1] & 255) + ((this.array[this.index - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1080768729"
   )
   @Export("readMedium")
   public int readMedium() {
      this.index += 3;
      return ((this.array[this.index - 3] & 255) << 16) + (this.array[this.index - 1] & 255) + ((this.array[this.index - 2] & 255) << 8);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1338012999"
   )
   @Export("readInt")
   public int readInt() {
      this.index += 4;
      return ((this.array[this.index - 3] & 255) << 16) + (this.array[this.index - 1] & 255) + ((this.array[this.index - 2] & 255) << 8) + ((this.array[this.index - 4] & 255) << 24);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-2077445946"
   )
   @Export("readLong")
   public long readLong() {
      long var1 = (long)this.readInt() & 4294967295L;
      long var3 = (long)this.readInt() & 4294967295L;
      return (var1 << 32) + var3;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2145047746"
   )
   @Export("readBoolean")
   public boolean readBoolean() {
      return (this.readUnsignedByte() & 1) == 1;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "377528415"
   )
   @Export("readStringCp1252NullTerminatedOrNull")
   public String readStringCp1252NullTerminatedOrNull() {
      if(this.array[this.index] == 0) {
         ++this.index;
         return null;
      } else {
         return this.readStringCp1252NullTerminated();
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1079610633"
   )
   @Export("readStringCp1252NullTerminated")
   public String readStringCp1252NullTerminated() {
      int var1 = this.index;

      while(this.array[++this.index - 1] != 0) {
         ;
      }

      int var2 = this.index - var1 - 1;
      return var2 == 0?"":WidgetGroupParent.decodeStringCp1252(this.array, var1, var2);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1806000702"
   )
   @Export("readStringCp1252NullCircumfixed")
   public String readStringCp1252NullCircumfixed() {
      byte var1 = this.array[++this.index - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.index;

         while(this.array[++this.index - 1] != 0) {
            ;
         }

         int var3 = this.index - var2 - 1;
         return var3 == 0?"":WidgetGroupParent.decodeStringCp1252(this.array, var2, var3);
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-14"
   )
   @Export("__aw_304")
   public String __aw_304() {
      byte var1 = this.array[++this.index - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.__as_311();
         if(var2 + this.index > this.array.length) {
            throw new IllegalStateException("");
         } else {
            byte[] var3 = this.array;
            int var4 = this.index;
            char[] var5 = new char[var2];
            int var6 = 0;
            int var7 = var4;

            int var8;
            for(int var9 = var4 + var2; var7 < var9; var5[var6++] = (char)var8) {
               int var10 = var3[var7++] & 255;
               if(var10 < 128) {
                  if(var10 == 0) {
                     var8 = 65533;
                  } else {
                     var8 = var10;
                  }
               } else if(var10 < 192) {
                  var8 = 65533;
               } else if(var10 < 224) {
                  if(var7 < var9 && (var3[var7] & 192) == 128) {
                     var8 = (var10 & 31) << 6 | var3[var7++] & 63;
                     if(var8 < 128) {
                        var8 = 65533;
                     }
                  } else {
                     var8 = 65533;
                  }
               } else if(var10 < 240) {
                  if(var7 + 1 < var9 && (var3[var7] & 192) == 128 && (var3[var7 + 1] & 192) == 128) {
                     var8 = (var10 & 15) << 12 | (var3[var7++] & 63) << 6 | var3[var7++] & 63;
                     if(var8 < 2048) {
                        var8 = 65533;
                     }
                  } else {
                     var8 = 65533;
                  }
               } else if(var10 < 248) {
                  if(var7 + 2 < var9 && (var3[var7] & 192) == 128 && (var3[var7 + 1] & 192) == 128 && (var3[var7 + 2] & 192) == 128) {
                     var8 = (var10 & 7) << 18 | (var3[var7++] & 63) << 12 | (var3[var7++] & 63) << 6 | var3[var7++] & 63;
                     if(var8 >= 65536 && var8 <= 1114111) {
                        var8 = 65533;
                     } else {
                        var8 = 65533;
                     }
                  } else {
                     var8 = 65533;
                  }
               } else {
                  var8 = 65533;
               }
            }

            String var11 = new String(var5, 0, var6);
            this.index += var2;
            return var11;
         }
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-122"
   )
   @Export("__al_305")
   public void __al_305(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.array[++this.index - 1];
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-24"
   )
   @Export("__ab_306")
   public int __ab_306() {
      int var1 = this.array[this.index] & 255;
      return var1 < 128?this.readUnsignedByte() - 64:this.__ag_302() - 49152;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1370512869"
   )
   @Export("__ae_307")
   public int __ae_307() {
      int var1 = this.array[this.index] & 255;
      return var1 < 128?this.readUnsignedByte():this.__ag_302() - 32768;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1177684230"
   )
   @Export("__at_308")
   public int __at_308() {
      int var1 = 0;

      int var2;
      for(var2 = this.__ae_307(); var2 == 32767; var2 = this.__ae_307()) {
         var1 += 32767;
      }

      var1 += var2;
      return var1;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "103"
   )
   @Export("__ad_309")
   public int __ad_309() {
      return this.array[this.index] < 0?this.readInt() & Integer.MAX_VALUE:this.__ag_302();
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1151173205"
   )
   @Export("__ap_310")
   public int __ap_310() {
      if(this.array[this.index] < 0) {
         return this.readInt() & Integer.MAX_VALUE;
      } else {
         int var1 = this.__ag_302();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "984135559"
   )
   @Export("__as_311")
   public int __as_311() {
      byte var1 = this.array[++this.index - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.array[++this.index - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "36"
   )
   @Export("xteaEncryptAll")
   public void xteaEncryptAll(int[] var1) {
      int var2 = this.index / 8;
      this.index = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.readInt();
         int var5 = this.readInt();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6) {
            var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3];
            var6 += var7;
         }

         this.index -= 8;
         this.writeInt(var4);
         this.writeInt(var5);
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "1682045100"
   )
   @Export("xteaDecryptAll")
   public void xteaDecryptAll(int[] var1) {
      int var2 = this.index / 8;
      this.index = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.readInt();
         int var5 = this.readInt();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3]) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
            var6 -= var7;
         }

         this.index -= 8;
         this.writeInt(var4);
         this.writeInt(var5);
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-1341435074"
   )
   @Export("xteaEncrypt")
   public void xteaEncrypt(int[] var1, int var2, int var3) {
      int var4 = this.index;
      this.index = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.readInt();
         int var8 = this.readInt();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9) {
            var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3];
            var9 += var10;
         }

         this.index -= 8;
         this.writeInt(var7);
         this.writeInt(var8);
      }

      this.index = var4;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "307218624"
   )
   @Export("xteaDecrypt")
   public void xteaDecrypt(int[] var1, int var2, int var3) {
      int var4 = this.index;
      this.index = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.readInt();
         int var8 = this.readInt();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
            var9 -= var10;
         }

         this.index -= 8;
         this.writeInt(var7);
         this.writeInt(var8);
      }

      this.index = var4;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "-2119154784"
   )
   @Export("encryptRsa")
   public void encryptRsa(BigInteger var1, BigInteger var2) {
      int var3 = this.index;
      this.index = 0;
      byte[] var4 = new byte[var3];
      this.__al_305(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.index = 0;
      this.writeShort(var7.length);
      Logger.getAnonymousLogger().warning("unsigned short " + var7.length);
      this.__s_297(var7, 0, var7.length);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-484928770"
   )
   @Export("__aa_312")
   public int __aa_312(int var1) {
      byte[] var2 = this.array;
      int var3 = this.index;
      int var4 = -1;

      for(int var5 = var1; var5 < var3; ++var5) {
         var4 = var4 >>> 8 ^ __gr_q[(var4 ^ var2[var5]) & 255];
      }

      var4 = ~var4;
      this.writeInt(var4);
      return var4;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-11"
   )
   @Export("__ax_313")
   public boolean __ax_313() {
      this.index -= 4;
      byte[] var1 = this.array;
      int var2 = this.index;
      int var3 = -1;

      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ __gr_q[(var3 ^ var1[var4]) & 255];
      }

      var3 = ~var3;
      var4 = this.readInt();
      return var4 == var3;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-47"
   )
   @Export("__af_314")
   public void __af_314(int var1) {
      this.array[++this.index - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1336494664"
   )
   @Export("__ai_315")
   public void __ai_315(int var1) {
      this.array[++this.index - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "21"
   )
   @Export("__ba_316")
   public void __ba_316(int var1) {
      this.array[++this.index - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-86972759"
   )
   @Export("__bb_317")
   public int __bb_317() {
      return this.array[++this.index - 1] - 128 & 255;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-840473648"
   )
   @Export("readUnsignedByteNegate")
   public int readUnsignedByteNegate() {
      return 0 - this.array[++this.index - 1] & 255;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "359814653"
   )
   @Export("__bq_318")
   public int __bq_318() {
      return 128 - this.array[++this.index - 1] & 255;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "2130167320"
   )
   @Export("__bn_319")
   public byte __bn_319() {
      return (byte)(this.array[++this.index - 1] - 128);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "1415936818"
   )
   @Export("__bk_320")
   public byte __bk_320() {
      return (byte)(0 - this.array[++this.index - 1]);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "1496705333"
   )
   @Export("__bd_321")
   public byte __bd_321() {
      return (byte)(128 - this.array[++this.index - 1]);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "51"
   )
   @Export("writeShortLE")
   public void writeShortLE(int var1) {
      this.array[++this.index - 1] = (byte)var1;
      this.array[++this.index - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "189694315"
   )
   @Export("__bo_322")
   public void __bo_322(int var1) {
      this.array[++this.index - 1] = (byte)(var1 >> 8);
      this.array[++this.index - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-7"
   )
   @Export("__bx_323")
   public void __bx_323(int var1) {
      this.array[++this.index - 1] = (byte)(var1 + 128);
      this.array[++this.index - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2147134369"
   )
   @Export("__by_324")
   public int __by_324() {
      this.index += 2;
      return ((this.array[this.index - 1] & 255) << 8) + (this.array[this.index - 2] & 255);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1489217204"
   )
   @Export("__bu_325")
   public int __bu_325() {
      this.index += 2;
      return (this.array[this.index - 1] - 128 & 255) + ((this.array[this.index - 2] & 255) << 8);
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-86"
   )
   @Export("__bm_326")
   public int __bm_326() {
      this.index += 2;
      return ((this.array[this.index - 1] & 255) << 8) + (this.array[this.index - 2] - 128 & 255);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "54"
   )
   @Export("__bl_327")
   public int __bl_327() {
      this.index += 2;
      int var1 = ((this.array[this.index - 1] & 255) << 8) + (this.array[this.index - 2] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "388487388"
   )
   @Export("__br_328")
   public int __br_328() {
      this.index += 2;
      int var1 = ((this.array[this.index - 1] & 255) << 8) + (this.array[this.index - 2] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-88751042"
   )
   @Export("__bj_329")
   public int __bj_329() {
      this.index += 3;
      return (this.array[this.index - 3] & 255) + ((this.array[this.index - 2] & 255) << 8) + ((this.array[this.index - 1] & 255) << 16);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "78"
   )
   @Export("writeIntLE")
   public void writeIntLE(int var1) {
      this.array[++this.index - 1] = (byte)var1;
      this.array[++this.index - 1] = (byte)(var1 >> 8);
      this.array[++this.index - 1] = (byte)(var1 >> 16);
      this.array[++this.index - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "80"
   )
   @Export("writeIntME")
   public void writeIntME(int var1) {
      this.array[++this.index - 1] = (byte)(var1 >> 8);
      this.array[++this.index - 1] = (byte)var1;
      this.array[++this.index - 1] = (byte)(var1 >> 24);
      this.array[++this.index - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2115295559"
   )
   @Export("writeIntLE16")
   public void writeIntLE16(int var1) {
      this.array[++this.index - 1] = (byte)(var1 >> 16);
      this.array[++this.index - 1] = (byte)(var1 >> 24);
      this.array[++this.index - 1] = (byte)var1;
      this.array[++this.index - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1322860835"
   )
   @Export("__bt_330")
   public int __bt_330() {
      this.index += 4;
      return (this.array[this.index - 4] & 255) + ((this.array[this.index - 3] & 255) << 8) + ((this.array[this.index - 2] & 255) << 16) + ((this.array[this.index - 1] & 255) << 24);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1731171028"
   )
   @Export("__bp_331")
   public int __bp_331() {
      this.index += 4;
      return ((this.array[this.index - 2] & 255) << 24) + ((this.array[this.index - 4] & 255) << 8) + (this.array[this.index - 3] & 255) + ((this.array[this.index - 1] & 255) << 16);
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-126"
   )
   @Export("__bf_332")
   public int __bf_332() {
      this.index += 4;
      return ((this.array[this.index - 1] & 255) << 8) + ((this.array[this.index - 4] & 255) << 16) + (this.array[this.index - 2] & 255) + ((this.array[this.index - 3] & 255) << 24);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1303287859"
   )
   @Export("__bh_333")
   public void __bh_333(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = (byte)(this.array[++this.index - 1] - 128);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method3915() {
      HealthBarDefinition.HealthBarDefinition_cached.clear();
      HealthBarDefinition.HealthBarDefinition_cachedSprites.clear();
   }

   static {
      __gr_q = new int[256];

      int var0;
      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = var1;

         for(var0 = 0; var0 < 8; ++var0) {
            if((var2 & 1) == 1) {
               var2 = var2 >>> 1 ^ -306674912;
            } else {
               var2 >>>= 1;
            }
         }

         __gr_q[var1] = var2;
      }

      __gr_o = new long[256];

      for(var0 = 0; var0 < 256; ++var0) {
         long var4 = (long)var0;

         for(int var3 = 0; var3 < 8; ++var3) {
            if((var4 & 1L) == 1L) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         __gr_o[var0] = var4;
      }

   }
}
